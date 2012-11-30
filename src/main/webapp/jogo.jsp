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

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Mack - Dragon City</title>
<!--<script src="enderecoArquivoJquery"></script>-->
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

	function criar_novo_jogo(id)
	{
		var mensagem = confirm("Você tem certeza que deseja criar um novo jogo?");

		if (mensagem == true)
		{
			window.onload = function(){
				$('novo_jogo').onclick = function(){
					window.location = "jogo/novojogo.action";
				}
			}		
		}
	}

	function sair_jogo()
	{	
		var mensagem = confirm("Você tem certeza que deseja sair do jogo?");

		if (mensagem == true)
		{
			window.exit;	
		}
	}	
</script>
</head>

<body>
<div class="cabecalho">
	<a id="cadastrar_jogador" href="/cadastro.jsp">Cadastrar jogador</a>
	&nbsp;&nbsp;<input id="traco_01" type="image" src="Imagens/bg_cabecalho_traco.gif" align="middle"/>
    <a id="sobre_jogo" href="">Sobre o jogo</a>
    &nbsp;&nbsp;<input id="traco_02" type="image" src="Imagens/bg_cabecalho_traco.gif" align="middle"/>
    <a id="contate-nos" href="">Contate-nos</a>
    &nbsp;&nbsp;<input id="traco_03" type="image" src="Imagens/bg_cabecalho_traco.gif" align="middle"/>
    <a id="sair" href="javascript:sair_jogo();">Sair</a>
    &nbsp;&nbsp;<input id="traco_04" type="image" src="Imagens/bg_cabecalho_traco.gif" align="middle"/>
</div>
<div class="pontuacao">
	<label id="qtd_ouro"><b>${jogo.getVlrTotalOuro()}</b></label>
	<label id="qtd_alimento"><b>${jogo.getVlrTotalComida()}</b></label>
	<label id="qtd_dragao"><b>${jogo.getListDragao().size()}</b></label>       
	<label id="qtd_pontos"><b>${jogo.getQtdTotalPontosXP()}</b></label>    
	<label id="nmr_nivel"><b>${nmr_nivel_jogo}</b></label>            
  	<label id="nme_jogador"><b>Jogador logado: ${jogo.getJogador().getNome()}</b></label>
</div>
<div class="novoJogo">
	<!-- <a id="novo_jogo" href="javascript:criar_novo_jogo('novo_jogo');" title="Novo jogo">Novo Jogo</a>; -->
	<a id="novo_jogo" href="/jogo/novojogo.action" title="Novo jogo">Novo Jogo</a>;
</div>
<div class="fundoConstrucao">
<!--  <a id="botao1x1" href="javascript:funcaoClick('botao1x1')"></a>
    <a id="botao1x2" href="javascript:funcaoClick('botao1x2')"></a> 
    <a id="botao1x3" href="javascript:funcaoClick('botao1x3')"></a>--> 
    
  
<%
	Jogo jogo = (Jogo)session.getAttribute("jogo");

	JogoRegrasNegocio jogo_regras_negocio = new JogoRegrasNegocio();
	MapaRegrasNegocio mapa_regras_negocio = new MapaRegrasNegocio();

	 String html_saida = "table width=\"810\" height=\"371\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">";
	
	for (int i=0; i<5; i++)
	{
		html_saida += "<tr>";
		
		for (int j=0; j<6; j++)
		{
			MapaLocal mapa_local = mapa_regras_negocio.getMapaLocalPorPosicao(jogo.getMapa(), i, j);
			
			html_saida += "<th width=\"135\" height=\"80\" align=\"left\" valign=\"top\" scope=\"col\">";
			
			if (mapa_local != null && mapa_local.getConstrucao() != null)
			{
				if (mapa_local.getConstrucao() instanceof CasaCentral)
				{
					CasaCentral casa_central = (CasaCentral)mapa_local.getConstrucao();
					
					if (casa_central.getOvo() != null)
					{
						html_saida += "<input type=\"image\" name=\"btn_casa_central\" id=\"btn_casa_central\" src=\"Imagens/btn_casa_central.gif\" title=\"Casa central\"/>";
					}
					else 
					{
						String nme_tipo_dragao = casa_central.getOvo().getDragaoTipo().getNomeTipoDragao();
						String nme_imagem = "";
						String nme_titulo = "";
							
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
					Dragao dragao = ((Habitat)mapa_local.getConstrucao()).getoDragao();
					String tipo_habitat = ((Habitat)mapa_local.getConstrucao()).getHabitatTipo().getTipo();
					
					if (dragao != null)
					{
						String nme_tipo_dragao = dragao.getDragaoTipo().getNomeTipoDragao();
						String nme_titulo = "Dragão " + dragao.getNomeDragao() + " - Nível: " + dragao.getLevel();
						String nme_imagem = dragao.getImagem();
						
						html_saida += "<input type=\"image\" name=\"btn_habitat\" id=\"btn_habitat\" src=\"" + nme_imagem + "\" title=\"" + nme_titulo + "\"/>";
					}
					else
					{
						String nme_imagem = "";
						String nme_titulo = "Habitat "  + tipo_habitat;
						
						if (tipo_habitat == "Terra")
							nme_imagem = "Imagens/btn_habitat_terra.gif";
						else if (tipo_habitat == "Fogo")
							nme_imagem = "Imagens/btn_habitat_fogo.gif";
						else if (tipo_habitat == "Água")
							nme_imagem = "Imagens/btn_habitat_aquatico.gif";
						else if (tipo_habitat == "Gelo")
							nme_imagem = "Imagens/btn_habitat_gelo.gif";
						else if (tipo_habitat == "Planta")
							nme_imagem = "Imagens/btn_habitat_vegetal.gif";
						else if (tipo_habitat == "Aço")
							nme_imagem = "Imagens/btn_habitat_metal.gif";
						else if (tipo_habitat == "Raio")
							nme_imagem = "Imagens/btn_habitat_eletrico.gif";
						
						html_saida += "<input type=\"image\" name=\"btn_habitat\" id=\"btn_habitat\" src=\"" + nme_imagem + "\" title=\"" + nme_titulo + "\"/>";
					}
				}
				else if (mapa_local.getConstrucao() instanceof Fazenda)
				{
					html_saida += "<input type=\"image\" name=\"btn_fazenda\" id=\"btn_fazenda\" src=\"btn_fazenda.gif\" title=\"Fazenda\"/>";
				}
			}
			else 
			{
				html_saida += "<input type=\"image\" name=\"btn_sem_construcao\" id=\"btn_sem_construcao\" src=\"btn_sem_construcao.gif\" title=\"Clique para construir\"/>";
			}
			
			html_saida += "</th>";			
		}
		
		html_saida += "</tr>";
	}

	html_saida = "</table>";
%>  	
	
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
