<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MackDragon-City - Adm</title>
<%@ include file="/adm/inc/taghead.jsp" %>
</head>
<body>
<form method="post">
  	<div id="container">
		<%@ include file="/adm/inc/header.jsp" %>
    </div>
    <div align="center">    
    	<fieldset>		
			<legend class="fieldset_legend">Lista de Jogadores</legend>
	    	<table cellpadding="0" cellspacing="0" style="text-align:left">
	    		<tr>
	    			<td style="width:20px"><c:out value="C�digo" /></td>
	    			<td style="width:250px"><c:out value="Nome" /></td>
	    			<td style="width:150px"><c:out value="Login" /></td>
	    			<td> Ativo/Inativo</td>
	    		</tr>	    		
	    		<c:forEach items="${listJogadores}" var="item">
	    			<tr>
		    			<td>${item.getCodigo()}</td>
		    			<td>${item.getNome()}</td>
		    			<td>${item.getLogin()}</td>
		    			<td>X</td>
	    			</tr>
	    		</c:forEach>
	    		
	    	</table>
		</fieldset>
		 </div>
   </form>

</body>
</html>

<script type="text/javascript">
		$(document).ready(function() {
		
			///alert("entrou no javascript");
			$(":checkbox").click(function(){
				var string = $(this).attr("value");
				var idJogador = string.split("/")[0];
				var name = string.split("/")[1];
				var ativar = $(this).is(':checked');
				var status;
				
				if (ativar) {
					status = "ativado";
				} else {
					status = "desativado";
				}

				$.ajax({
					url: "/adm/jogador/ativarJogador.action", 
					type: "post",
				 	data: {idJogador: idJogador, ativar: ativar},
				 	success: function (response, textStatus, jqXHR){
						$("#"+idJogador).html("Jogador " + name + " " + status + " com sucesso!");
				 	},
			        error: function(jqXHR, textStatus, errorThrown){
			            console.log(
			                "Ocorreu o seguinte erro: "+
			                textStatus, errorThrown
			            );
			        }
				});
			});
			
		});
</script>