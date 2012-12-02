<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="br.com.projeto.businessrules.JogoRegrasNegocio"%>
<%@page import="br.com.projeto.businessrules.MapaRegrasNegocio"%>
<%@page import="br.com.projeto.entity.Entidade"%>
<%@page import="br.com.projeto.entity.Jogo"%>
<%@page import="br.com.projeto.entity.CasaCentral"%>
<%@page import="br.com.projeto.entity.MapaLocal"%>
<%@page import="br.com.projeto.entity.DragaoTipo"%>
<%@page import="br.com.projeto.entity.Construcao"%>
<%@page import="br.com.projeto.entity.Habitat"%>
<%@page import="br.com.projeto.entity.Dragao"%>
<%@page import="br.com.projeto.entity.Fazenda"%>


<%@page import="net.sf.cglib.core.Converter"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Mack - Dragon City</title>
<link href="css/jogo.css" rel="stylesheet" type="text/css" />
<script>
	var pontucao = 0;
	function funcaoClick(id){
		alert(id);
		/*
		pontuacao += 10;
		$('#'+id).css('background-image','url('')');
		*/
	}

	function criar_novo_jogo()
	{
		var mensagem = confirm("Você tem certeza que deseja criar um novo jogo?");

		if (mensagem == true)
			window.location = "jogo/novojogo.action";
	}

	function sair_jogo()
	{	
		var mensagem = confirm("Você tem certeza que deseja sair do jogo?");

		if (mensagem == true)
			window.location = "/index.jsp";
	}

	function alertar_opcao_indisponivel()
	{	
		alert("Opção indisponível no momento.");
	}

	function alertar_opcao_indisponivel()
	{	
		alert("Opção indisponível no momento.");
	}		
</script>
</head>

<body>
<div class="cabecalho">
	<a id="cadastrar_jogador" href="/cadastro.jsp">Cadastrar jogador</a>
	&nbsp;&nbsp;<input id="traco_01" type="image" src="Imagens/bg_cabecalho_traco.gif" align="middle"/>
    <a id="sobre_jogo" href="javascript:alertar_opcao_indisponivel();">Sobre o jogo</a>
    &nbsp;&nbsp;<input id="traco_02" type="image" src="Imagens/bg_cabecalho_traco.gif" align="middle"/>
    <a id="contate-nos" href="javascript:alertar_opcao_indisponivel();">Contate-nos</a>
    &nbsp;&nbsp;<input id="traco_03" type="image" src="Imagens/bg_cabecalho_traco.gif" align="middle"/>
    <a id="sair" href="javascript:sair_jogo();">Sair</a>
    &nbsp;&nbsp;<input id="traco_04" type="image" src="Imagens/bg_cabecalho_traco.gif" align="middle"/>
</div>
<% 
	String html_cabecalho = "";

	if (session.getAttribute("jogo") != null && session.getAttribute("jogo") != "" )
	{
		Jogo jogo = (Jogo)session.getAttribute("jogo");
		
		System.out.println("Total de Ouro: " + jogo.getVlrTotalOuro()); 
		html_cabecalho =  "<label id=\"qtd_ouro\"><b>" + jogo.getVlrTotalOuro() + "</b></label>";
		html_cabecalho += "<label id=\"qtd_alimento\"><b>" + jogo.getVlrTotalComida() + "</b></label>";
		html_cabecalho += "<label id=\"qtd_dragao\"><b>" + 0 + "</b></label>"; //jogo.getListDragao().size()
		html_cabecalho += "<label id=\"qtd_pontos\"><b>" + jogo.getQtdTotalPontosXP() + "</b></label>";
		html_cabecalho += "<label id=\"nmr_nivel\"><b>" + session.getAttribute("nmr_nivel_jogo") + "</b></label>";
		html_cabecalho += "<label id=\"nme_jogador\"><b>Jogador logado: " + jogo.getJogador().getNome() + "</b></label>";
		
		session.setAttribute("html_cabecalho", html_cabecalho); 
	}
%>  	
<div class="pontuacao"> ${html_cabecalho} </div>  	
<div class="novoJogo">
	 <a id="novo_jogo" href="javascript:criar_novo_jogo();" title="Novo jogo">Novo Jogo</a>;
</div>
<div class="fundoConstrucao">
 
<%
	String html_saida = "";

	if (session.getAttribute("jogo") != null && session.getAttribute("jogo") != "" )
	{
		Jogo jogo = (Jogo)session.getAttribute("jogo");
		
		if (jogo != null)
		{
			JogoRegrasNegocio jogo_regras_negocio = new JogoRegrasNegocio();
			MapaRegrasNegocio mapa_regras_negocio = new MapaRegrasNegocio();
		
			html_saida = "<table width=\"810\" height=\"371\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">";
			
			if (jogo.getMapa() != null)
			{		
				for (int i=1; i<6; i++)
				{
					html_saida += "<tr>";
					
					for (int j=1; j<7; j++)
					{
						MapaLocal mapa_local = mapa_regras_negocio.getMapaLocalPorPosicao(jogo.getMapa(), i, j);
						
						html_saida += "<th width=\"135\" height=\"80\" align=\"left\" valign=\"top\" scope=\"col\">";
						
						if (mapa_local != null && mapa_local.getConstrucao() != null)
						{
							if (mapa_local.getConstrucao() instanceof CasaCentral)
							{
								CasaCentral casa_central = (CasaCentral)mapa_local.getConstrucao();
								
								System.out.println("casacentral: " + casa_central.getCodigo()); 
								//CASA CENTRAL AQUI
								if (casa_central.getOvo() == null)
								{
									System.out.println("casacentral-ovo: NULL (Chocadeira vazia)"); 
									html_saida += "<input type=\"image\" name=\"btn_casa_central\" id=\"btn_casa_central\" src=\"Imagens/btn_casa_central.gif\" title=\"Casa central\"/>";
								}
								else 
								{
									String nme_tipo_dragao = casa_central.getOvo().getDragaoTipo().getNomeTipoDragao();
									String nme_imagem = "";
									String nme_titulo = "";
									System.out.println("casacentral-ovo: Chocadeira com ovo " + nme_tipo_dragao);
									
									if (nme_tipo_dragao == "Terra")
									{
										nme_imagem = "Imagens/btn_ovo_terra_chocadeira.gif";
										nme_titulo = "Ovo - Terra";
									}
									else if (nme_tipo_dragao == "Fogo")
									{
										nme_imagem = "Imagens/btn_ovo_fogo_chocadeira.gif";
										nme_titulo = "Ovo - Fogo";
									}
									else if (nme_tipo_dragao == "Água")
									{
										nme_imagem = "Imagens/btn_ovo_aquatico_chocadeira.gif";
										nme_titulo = "Ovo - Água";
									}
									else if (nme_tipo_dragao == "Gelo")
									{
										nme_imagem = "Imagens/btn_ovo_gelo_chocadeira.gif";
										nme_titulo = "Ovo - Gelo";
									}
									else if (nme_tipo_dragao == "Planta")
									{
										nme_imagem = "Imagens/btn_ovo_vegetal_chocadeira.gif";
										nme_titulo = "Ovo - Vegetal";
									}
									else if (nme_tipo_dragao == "Aço")
									{
										nme_imagem = "Imagens/btn_ovo_metal_chocadeira.gif";
										nme_titulo = "Ovo - Metal";
									}
									else if (nme_tipo_dragao == "Raio")
									{
										nme_imagem = "Imagens/btn_ovo_eletrico_chocadeira.gif";
										nme_titulo = "Ovo - Elétrico";
									}
									
									html_saida += "<input type=\"image\" name=\"btn_casa_central\" id=\"btn_casa_central\" src=\"" + nme_imagem + "\" title=\"" + nme_titulo + "\"/>";					
								}



								
							}
							else if (mapa_local.getConstrucao() instanceof Habitat)
							{
								System.out.println("Passou no Habitat");
								Dragao dragao = ((Habitat)mapa_local.getConstrucao()).getoDragao();
								System.out.println("Dragao: " + dragao.getCodigo());
								String tipo_habitat = ((Habitat)mapa_local.getConstrucao()).getHabitatTipo().getTipo();
								System.out.println("Tipo Habitat: " + tipo_habitat);
								
								//HABITAT AQUI
							}
							else if (mapa_local.getConstrucao() instanceof Fazenda)
							{
								System.out.println("Passou na fazenda");
								html_saida += "<input type=\"image\" name=\"btn_fazenda\" id=\"btn_fazenda\" src=\"Imagens/btn_fazenda.gif\" title=\"Fazenda\"/>";
							}
						}
						else 
						{
							html_saida += "<input type=\"image\" name=\"btn_sem_construcao\" id=\"btn_sem_construcao\" src=\"Imagens/btn_sem_construcao.gif\" title=\"Clique para construir\"/>";
						}
						
						html_saida += "</th>";			
					}
					
					html_saida += "</tr>";
				}				
				
				
				
				//html_saida += "<tr>";
				//html_saida += "		<td id = \"erro\">ENTROUUUUUU." ;
				//html_saida += "</tr>";
				//html_saida += "</table>";
			}
			else
			{
				html_saida += "<tr>";
				html_saida += "		<td id = \"erro\">Nenhum mapa foi encontrado. Atualize a página novamente." ;
				html_saida += "</tr>";
				html_saida += "</table>";
			}
		}
		else
		{
			html_saida += "<tr>";
			html_saida += "		<td id = \"erro\">Nenhum jogo foi encontrado. Entre novamente." ;
			html_saida += "</tr>";
			html_saida += "</table>";
		}		
	}

	session.setAttribute("html_body", html_saida); 
%>  	

<div> ${html_body} </div>

	
<!-- 	 <table width="810" height="371" border="0" align="center" cellpadding="0" cellspacing="0">
  		<tr>
        	<th width="135" height="80" align="left" valign="top" scope="col">
        		<input type="image" name="btn_terra_ovo30" id="btn_terra_ovo30" src="Imagens/btn_casa_central.gif" title="Casa central"/>			
            </th>
            <th width="135" height="80" align="left" valign="top" scope="col">
                <input type="image" name="btn_terra_ovo" id="btn_terra_ovo" src="Imagens/btn_terra_ovo.gif" />          	
            </th>
            <th width="135" height="80" align="left" valign="top" scope="col">
                <input type="image" name="btn_terra_ovo2" id="btn_terra_ovo2" src="Imagens/btn_terra_filhote.gif" />          	</th>
            <th width="135" height="80" align="left" valign="top" scope="col">
                <input type="image" name="btn_terra_ovo3" id="btn_terra_ovo3" src="Imagens/btn_terra_jovem.gif" />          	</th>
            <th width="135" height="80" align="left" valign="top" scope="col">
                <input type="image" name="btn_terra_ovo4" id="btn_terra_ovo4" src="Imagens/btn_terra_adulto.gif" />          	</th>
            <th width="135" height="80" align="left" valign="top" scope="col">
                <input type="image" name="btn_terra_ovo5" id="btn_terra_ovo5" src="Imagens/btn_vegetal_ovo.gif" />          	</th>
      </tr>
      <tr>
        <th width="135" height="51" align="left" valign="top" scope="row">
            	<input type="image" name="btn_terra_ovo6" id="btn_terra_ovo6" src="Imagens/btn_vegetal_filhote.gif" />        </th>
            <td width="135" height="51" align="left" valign="top">
            	<input type="image" name="btn_terra_ovo7" id="btn_terra_ovo7" src="Imagens/btn_vegetal_jovem.gif" />        </td>
            <td width="135" height="51" align="left" valign="top">
            	<input type="image" name="btn_terra_ovo8" id="btn_terra_ovo8" src="Imagens/btn_vegetal_adulto.gif" />        </td>
            <td width="135" height="51" align="left" valign="top">
            	<input type="image" name="btn_terra_ovo9" id="btn_terra_ovo9" src="Imagens/btn_fogo_ovo.gif" />        </td>
            <td width="135" height="51" align="left" valign="top">
            	<input type="image" name="btn_terra_ovo10" id="btn_terra_ovo10" src="Imagens/btn_fogo_filhote.gif" title="DragÃ£o Foquete - nÃ­vel 01"/>        
            </td>
            <td width="135" height="51" align="left" valign="top">
        <input type="image" name="btn_terra_ovo11" id="btn_terra_ovo11" src="Imagens/btn_fogo_jovem.gif"title="DragÃ£o Foquete - nÃ­vel 05" /></td>
          </tr>
      <tr>
        <th width="135" height="80" align="left" valign="top" scope="row">
        	<input type="image" name="btn_terra_ovo12" id="btn_terra_ovo12" src="Imagens/btn_fogo_adulto.gif" title="DragÃ£o Foquete - nÃ­vel 10"/>        </th>
        <td width="135" height="80" align="left" valign="top">
        	<input type="image" name="btn_terra_ovo13" id="btn_terra_ovo13" src="Imagens/btn_aquatico_ovo.gif" />        </td>
        <td width="135" height="80" align="left" valign="top">
        	<input type="image" name="btn_terra_ovo14" id="btn_terra_ovo14" src="Imagens/btn_aquatico_filhote.gif" />        </td>
        <td width="135" height="80" align="left" valign="top">
       		<input type="image" name="btn_terra_ovo15" id="btn_terra_ovo15" src="Imagens/btn_aquatico_jovem.gif" />        </td>
        <td width="135" height="80" align="left" valign="top">
        	<input type="image" name="btn_terra_ovo16" id="btn_terra_ovo16" src="Imagens/btn_aquatico_adulto.gif" />        </td>
        <td width="135" height="80" align="left" valign="top">
        	<input type="image" name="btn_terra_ovo17" id="btn_terra_ovo17" src="Imagens/btn_gelo_ovo.gif" />        </td>
      </tr>
      <tr>
        <th width="135" height="80" align="left" valign="top" scope="row">
        	<input type="image" name="btn_terra_ovo18" id="btn_terra_ovo18" src="Imagens/btn_gelo_filhote.gif" />        </th>
        <td width="135" height="80" align="left" valign="top">
        	<input type="image" name="btn_terra_ovo19" id="btn_terra_ovo19" src="Imagens/btn_gelo_jovem.gif" />        </td>
        <td width="135" height="80" align="left" valign="top">
        	<input type="image" name="btn_terra_ovo20" id="btn_terra_ovo20" src="Imagens/btn_gelo_adulto.gif" />        </td>
        <td width="135" height="80" align="left" valign="top">
        	<input type="image" name="btn_terra_ovo21" id="btn_terra_ovo21" src="Imagens/btn_metal_ovo.gif" />        </td>
        <td width="135" height="80" align="left" valign="top">
        	<input type="image" name="btn_terra_ovo22" id="btn_terra_ovo22" src="Imagens/btn_metal_filhote.gif" />        </td>
        <td width="135" height="80" align="left" valign="top">
        	<input type="image" name="btn_terra_ovo23" id="btn_terra_ovo23" src="Imagens/btn_metal_jovem.gif" />        </td>
      </tr>
      <tr>
        <th width="135" height="80" align="left" valign="top" scope="row">
        	<input type="image" name="btn_terra_ovo24" id="btn_terra_ovo24" src="Imagens/btn_metal_adulto.gif" />        </th>
        <td width="135" height="80" align="left" valign="top">
	        <a>
            	<input type="image" class="ovoChocadeira" src="Imagens/btn_fazenda.gif" title="DragÃ£o Foguete"/> 
            </a> 
        </td>
        <td width="135" height="80" align="left" valign="top">
        	<input type="image" name="btn_terra_ovo26" id="btn_terra_ovo26" src="Imagens/btn_fazenda.gif" />        </td>
        <td width="135" height="80" align="left" valign="top">
        	<input type="image" name="btn_terra_ovo27" id="btn_terra_ovo27" src="Imagens/btn_terra_adulto.gif" />        </td>
        <td width="135" height="80" align="left" valign="top">
        	<input type="image" name="btn_terra_ovo28" id="btn_terra_ovo28" src="Imagens/btn_aquatico_adulto.gif" />        </td>
        <td width="135" height="80" align="left" valign="top">
        	<input type="image" name="btn_terra_ovo29" id="btn_terra_ovo29" src="Imagens/btn_construcao.gif" />        </td>
      </tr>
  </table>  -->
</div>
</body>
</html>
