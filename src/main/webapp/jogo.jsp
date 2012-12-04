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
<%@page import="br.com.projeto.businessrules.DragaoRegrasNegocio"%>
<%@page import="br.com.projeto.dao.DragaoTipoDao"%>


<%@page import="br.com.projeto.businessrules.NivelRegrasNegocio"%>
<%@page import="br.com.projeto.entity.HabitatTipo"%>
<%@page import="br.com.projeto.entity.DragaoEstado"%>
<%@page import="br.com.projeto.dao.DragaoEstadoDao"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Mack - Dragon City</title>
<link href="css/jogo.css" rel="stylesheet" type="text/css" />
<!-- <script type="text/javascript" src="<c:url value='/js/jquery-1.8.2.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.selectbox-0.2.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/jquery-ui-1.9.1.custom.min.js' />"></script>
-->

<script language="javascript" type="text/javascript">
	
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
		        
	function casa_central_clicado(sta_possui_ovo, nme_tipo_dragao, nme_nome_dragao, nme_tipo_habitat)
	{
		var mensagem = "";
		
		if (sta_possui_ovo == false)
		{
			mensagem = confirm("Não existe Ovo de Dragão aqui. Deseja criar um?");

			if (mensagem == true)
			{
				do 
				{
					mensagem = prompt("Escolha um tipo de Dragao: \n\n" + 
									  "1 - Dragão de Fogo\n" +
									  "2 - Dragão de Água\n" +
							  		  "3 - Dragão de Gelo\n" +
					  		  		  "4 - Dragão de Planta\n" +
					  		  		  "5 - Dragão de Aço\n" +
					  		  		  "6 - Dragão de Raio\n" +
									  "7 - Dragão de Terra\n" +
									  "0 - Sair\n");
					  
				} while (mensagem == null || mensagem == "");

				if (mensagem == "0")
					return;

				var idCdgTipoDragaoEscolhido = mensagem;

				var nomeDragao = "";
				
				do {
					nomeDragao = prompt("Dê um nome ao seu dragão: ");
				} while (nomeDragao == null || nomeDragao == "");

				window.location = "jogo/casacentral.action?cdgTipoDragaoEscolhido="+mensagem+"&nomeDragao="+nomeDragao;

 		    }	
		}
		else
		{
			mensagem = "Já existe um Ovo de " + nme_tipo_dragao + " aqui. O nome dele é " + nme_nome_dragao + ".";
			mensagem += "\nClique em um habitat do tipo " + nme_tipo_habitat + " para criar o dragão.";
			alert(mensagem);
		}
	}

	function botao_clicado(x, y)
	{
		var mensagem = "";

		mensagem = confirm("Não existe construções aqui. Deseja construir?");

		if (mensagem == true)
		{
			var cdgTipoConstrucao = "";
			
			do {
				cdgTipoConstrucao = prompt("O que deseja construir?\n\n" +
									"1 - Fazenda\n" +
									"2 - Habitat\n" +
									"0 - Sair\n") 
			} while (cdgTipoConstrucao == null || cdgTipoConstrucao == "");

			//Validar quantidade total de comida.
			
			if (cdgTipoConstrucao == 1)
			{
				window.location = "jogo/construirFazenda.action?posicaoX=" + x + "&posicaoY=" + y;
			}
			else
			{ 
				var cdgTipoHabitatEscolhido = "";

				do
				{
					cdgTipoHabitatEscolhido = prompt("Escolha um tipo de Habitat: \n\n" + 
						  "1 - Habitat de Fogo\n" +
						  "2 - Habitat de Água\n" +
				  		  "3 - Habitat de Gelo\n" +
		  		  		  "4 - Habitat de Planta\n" +
		  		  		  "5 - Habitat de Aço\n" +
		  		  		  "6 - Habitat de Raio\n" +
						  "7 - Habitat de Terra\n" +
						  "0 - Sair\n");		  
				} while (cdgTipoHabitatEscolhido == null || cdgTipoHabitatEscolhido == "");

				if (cdgTipoHabitatEscolhido == 0)
					return;
				else  
				{
					window.location = "jogo/construirHabitat.action?posicaoX=" + x + "&posicaoY=" + y + "&cdgTipoHabitatEscolhido=" + cdgTipoHabitatEscolhido;
				}
			}
		}
	}
			 
	function habitat_clicado(x, y, cdgTipoHabitat, staHabitatComOvo)
	{
		if (staHabitatComOvo == false)
		{
			var cdgTipoDragaoChocadeira = document.getElementById('btn_casa_central').value;
			
			if (cdgTipoDragaoChocadeira == "")
			{
				alert("Habitat sem dragão. Para colocar aqui é necessário criar um Ovo na Casa Central.");
				return;
			}
			else 
			{
				if (cdgTipoHabitat == cdgTipoDragaoChocadeira)
				{
					window.location = "jogo/inserirOvoHabitat.action?posicaoX=" + x + "&posicaoY=" + y;
					
				}
				else 
				{
					alert("O ovo deve ser do mesmo tipo para colocá-lo no seu habitat.");
					return;
				}
			}
		}
		else
		{
			window.location = "jogo/adicionarOuroPontosDragao.action?posicaoX=" + x + "&posicaoY=" + y;

			var qtdAlimento = "";
			
			do
			{
				qtdAlimento = prompt(document.getElementById('retorno').value + "\nInforme a quantidade de alimentos \nou 0 - Sair");
			} while (qtdAlimento == null || qtdAlimento == "");

			if (qtdAlimento <= 0)
				return;
			else  
			{
				var qtdTotalAlimento = document.getElementById('qtdTotalComida').value;

				if (qtdTotalAlimento <= 0)
				{
					alert("Vôce não possui alimento suficiente para utilizar.");
					return;
				}
				
				window.location = "jogo/alimentarDragao.action?posicaoX=" + x + "&posicaoY=" + y + "&qtdAlimento=" + qtdAlimento;

			}
		}
	}	

	function fazenda_clicado()
	{
		window.location = "jogo/adicionarAlimento.action";
	}

	function alertar_retorno()
	{
		var retorno = document.getElementById('retorno').value;

		if (retorno == '')
			return;
		else
		{
			alert(retorno);
			document.getElementById('retorno').value = "";
		}
	}

</script>
</head>

<body onload="alertar_retorno()">
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
		html_cabecalho += "<label id=\"qtd_dragao\"><b>" + session.getAttribute("qtdTotalDragao") + "</b></label>"; //jogo.getListDragao().size()
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
	int qtdTotalDragao = 0;
	
	if (session.getAttribute("jogo") != null && session.getAttribute("jogo") != "" )
	{
		Jogo jogo = (Jogo)session.getAttribute("jogo");
		
		if (jogo != null)
		{
			JogoRegrasNegocio jogo_regras_negocio = new JogoRegrasNegocio();
			MapaRegrasNegocio mapa_regras_negocio = new MapaRegrasNegocio();
		
			html_saida = "<table width=\"810\" height=\"371\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">";
			html_saida += "<input type=\"hidden\" name=\"retorno\" id=\"retorno\" value=\"" + session.getAttribute("retorno") + "\">";
			html_saida += "<input type=\"hidden\" name=\"qtdTotalOuro\" id=\"qtdTotalOuro\" value=\"" + session.getAttribute("qtdTotalOuro") + "\">";
			html_saida += "<input type=\"hidden\" name=\"qtdTotalOuro\" id=\"qtdTotalComida\" value=\"" + session.getAttribute("qtdTotalComida") + "\">";
		
			
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
								
								if (casa_central.getOvo() == null)
								{
									html_saida += "<input type=\"image\" name=\"btn_casa_central\" id=\"btn_casa_central\" value=\"\" src=\"Imagens/btn_casa_central.gif\" title=\"Casa central\" onClick=\"javascript:casa_central_clicado(false, '', '', '')\"/>";  // href=\"javascript:casa_central_clicado(false, '', '', '');\" />";
								}
								else 
								{
									String nme_tipo_dragao = casa_central.getOvo().getDragaoTipo().getNomeTipoDragao();
									String nme_nome_dragao = casa_central.getOvo().getNomeDragao();
									String nme_tipo_habitat = casa_central.getOvo().getDragaoTipo().getoHabitatTipo().getTipo();
									String nme_imagem = "";
									String nme_titulo = ""; 
									String cdg_tipo_ovo = "";
									
									if (nme_tipo_dragao.equals("Terra"))
									{
										nme_imagem = "Imagens/btn_ovo_terra_chocadeira.gif";
										cdg_tipo_ovo = "7";
									}
									else if (nme_tipo_dragao.equals("Fogo"))
									{
										nme_imagem = "Imagens/btn_ovo_fogo_chocadeira.gif";
										cdg_tipo_ovo = "1";
									}
									else if (nme_tipo_dragao.equals("Água"))
									{
										nme_imagem = "Imagens/btn_ovo_aquatico_chocadeira.gif";
										cdg_tipo_ovo = "2";
									}
									else if (nme_tipo_dragao.equals("Gelo"))
									{
										nme_imagem = "Imagens/btn_ovo_gelo_chocadeira.gif";
										cdg_tipo_ovo = "3";
									}
									else if (nme_tipo_dragao.equals("Planta"))
									{
										nme_imagem = "Imagens/btn_ovo_vegetal_chocadeira.gif";
										cdg_tipo_ovo = "4";
									}
									else if (nme_tipo_dragao.equals("Aço"))
									{
										nme_imagem = "Imagens/btn_ovo_metal_chocadeira.gif";
										cdg_tipo_ovo = "5";
									}
									else if (nme_tipo_dragao.equals("Raio"))
									{
										nme_imagem = "Imagens/btn_ovo_eletrico_chocadeira.gif";
										cdg_tipo_ovo = "6";
									}
									
									nme_titulo = "Ovo de " + nme_tipo_habitat + ": " + nme_nome_dragao;
									
									html_saida += "<input type=\"image\" name=\"btn_casa_central\" id=\"btn_casa_central\" value=\""+cdg_tipo_ovo+"\" onClick=\"javascript:casa_central_clicado(true, '" + nme_tipo_dragao + "', '" + nme_nome_dragao + "','" + nme_tipo_habitat + "')\" src=\"" + nme_imagem + "\" title=\"" + nme_titulo + "\"/>";
								}
							}
							else if (mapa_local.getConstrucao() instanceof Habitat)
							{
								Dragao dragao = ((Habitat)mapa_local.getConstrucao()).getoDragao();
								
								//HABITAT AQUI
								if (dragao != null)
								{
									qtdTotalDragao++;
									String nme_tipo_dragao = dragao.getDragaoTipo().getNomeTipoDragao();
									String nme_titulo = "Dragão " + dragao.getNomeDragao() + " - Nível: " + dragao.getLevel();
									String nme_imagem = "";
									
									if (nme_tipo_dragao.equals("Terra"))
									{
										if (dragao.getLevel() >= 1 && dragao.getLevel() <= 5)
											nme_imagem = "Imagens/btn_terra_filhote.gif";
										else if (dragao.getLevel() >= 6 && dragao.getLevel() <= 12)
											nme_imagem = "Imagens/btn_terra_jovem.gif";
										else 
											nme_imagem = "Imagens/btn_terra_adulto.gif";
									}
									else if (nme_tipo_dragao.equals("Fogo"))
									{
										if (dragao.getLevel() >= 1 && dragao.getLevel() <= 5)
											nme_imagem = "Imagens/btn_fogo_filhote.gif";
										else if (dragao.getLevel() >= 6 && dragao.getLevel() <= 12)
											nme_imagem = "Imagens/btn_fogo_jovem.gif";
										else 
											nme_imagem = "Imagens/btn_fogo_adulto.gif";
									}
									else if (nme_tipo_dragao.equals("Água"))
									{
										if (dragao.getLevel() >= 1 && dragao.getLevel() <= 5)
											nme_imagem = "Imagens/btn_aquatico_filhote.gif";
										else if (dragao.getLevel() >= 6 && dragao.getLevel() <= 12)
											nme_imagem = "Imagens/btn_aquatico_jovem.gif";
										else 
											nme_imagem = "Imagens/btn_aquatico_adulto.gif";
									}
									else if (nme_tipo_dragao.equals("Gelo"))
									{
										if (dragao.getLevel() >= 1 && dragao.getLevel() <= 5)
											nme_imagem = "Imagens/btn_gelo_filhote.gif";
										else if (dragao.getLevel() >= 6 && dragao.getLevel() <= 12)
											nme_imagem = "Imagens/btn_gelo_jovem.gif";
										else 
											nme_imagem = "Imagens/btn_gelo_adulto.gif";
									}
									else if (nme_tipo_dragao.equals("Planta"))
									{
										if (dragao.getLevel() >= 1 && dragao.getLevel() <= 5)
											nme_imagem = "Imagens/btn_vegetal_filhote.gif";
										else if (dragao.getLevel() >= 6 && dragao.getLevel() <= 12)
											nme_imagem = "Imagens/btn_vegetal_jovem.gif";
										else 
											nme_imagem = "Imagens/btn_vegetal_adulto.gif";
									}
									else if (nme_tipo_dragao.equals("Aço"))
									{
										if (dragao.getLevel() >= 1 && dragao.getLevel() <= 5)
											nme_imagem = "Imagens/btn_metal_filhote.gif";
										else if (dragao.getLevel() >= 6 && dragao.getLevel() <= 12)
											nme_imagem = "Imagens/btn_metal_jovem.gif";
										else 
											nme_imagem = "Imagens/btn_metal_adulto.gif";
									}
									else if (nme_tipo_dragao.equals("Raio"))
									{
										if (dragao.getLevel() >= 1 && dragao.getLevel() <= 5)
											nme_imagem = "Imagens/btn_eletrico_filhote.gif";
										else if (dragao.getLevel() >= 6 && dragao.getLevel() <= 12)
											nme_imagem = "Imagens/btn_eletrico_jovem.gif";
										else 
											nme_imagem = "Imagens/btn_eletrico_adulto.gif";
									}									
									
									html_saida += "<input type=\"image\" name=\"btn_habitat\" id=\"btn_habitat\" src=\"" + nme_imagem + "\" title=\"" + nme_titulo + "\" onClick=\"javascript:habitat_clicado(" + i + "," + j + ",'" + dragao.getDragaoTipo().getCodigo() + "', true)\"/>";
								}
								else
								{
									HabitatTipo habitatTipo = ((Habitat)mapa_local.getConstrucao()).getHabitatTipo();
									
									String nme_imagem = "";
									String cdg_tipo_habitat = "";
									String nme_titulo = "Habitat "  + habitatTipo.getTipo();
									
									if (habitatTipo.getTipo().equals("Terra"))
									{
										nme_imagem = "Imagens/btn_habitat_terra.gif";
										cdg_tipo_habitat = "7";
									}
									else if (habitatTipo.getTipo().equals("Fogo"))
									{
										nme_imagem = "Imagens/btn_habitat_fogo.gif";
										cdg_tipo_habitat = "1";
									}
									else if (habitatTipo.getTipo().equals("Água"))
									{
										nme_imagem = "Imagens/btn_habitat_aquatico.gif";
										cdg_tipo_habitat = "2";
									}
									else if (habitatTipo.getTipo().equals("Gelo"))
									{
										nme_imagem = "Imagens/btn_habitat_gelo.gif";
										cdg_tipo_habitat = "3";
									}
									else if (habitatTipo.getTipo().equals("Planta"))
									{
										nme_imagem = "Imagens/btn_habitat_vegetal.gif";
										cdg_tipo_habitat = "4";
									}
									else if (habitatTipo.getTipo().equals("Aço"))
									{
										nme_imagem = "Imagens/btn_habitat_metal.gif";
										cdg_tipo_habitat = "5";
									}
									else if (habitatTipo.getTipo().equals("Raio"))
									{
										nme_imagem = "Imagens/btn_habitat_eletrico.gif";
										cdg_tipo_habitat = "6";
									}
									html_saida += "<input type=\"image\" name=\"btn_habitat\" id=\"btn_habitat\" src=\"" + nme_imagem + "\" title=\"" + nme_titulo + "\" onClick=\"javascript:habitat_clicado(" + i + "," + j + "," + cdg_tipo_habitat + ", false)\"/>";
								}
							}
							else if (mapa_local.getConstrucao() instanceof Fazenda)
							{
								html_saida += "<input type=\"image\" name=\"btn_fazenda\" id=\"btn_fazenda\" src=\"Imagens/btn_fazenda.gif\" title=\"Fazenda\" onClick=\"javascript:fazenda_clicado()\" />";
							}
						}
						else 
						{
							html_saida += "<input type=\"image\" name=\"btn_sem_construcao\" id=\"btn_sem_construcao\" src=\"Imagens/btn_sem_construcao.gif\" title=\"Clique para construir\" onClick=\"javascript:botao_clicado(" + i + "," + j + ")\" />";
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
	session.setAttribute("qtdTotalDragao", qtdTotalDragao);
	session.setAttribute("html_body", html_saida); 
%>  	

<div> ${html_body} </div>

	
 	<!--  <table width="810" height="371" border="0" align="center" cellpadding="0" cellspacing="0">
  		<tr>
        	<th width="135" height="80" align="left" valign="top" scope="col">
        	<a href="javascript:sair_jogo();"> 
    			 <img src="Imagens/btn_casa_central.gif" name="btn_terra_ovo30" />
			</a>		
            </th>
            <th width="135" height="80" align="left" valign="top" scope="col">
            	<input type="image" onclick="func('hello')" src="Imagens/btn_casa_central.gif"/>
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
