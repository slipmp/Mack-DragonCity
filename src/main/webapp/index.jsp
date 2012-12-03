<%@ include file="/inc/init.jsp" %>
<html>
<head>
		<title>MackDragon City</title>
		<%@ include file="/adm/inc/taghead.jsp" %>
		<link rel="stylesheet" type="text/css" href="css/Estilos.css" /> 		
</head>
<body>
<div id="conteudo">
	<div id="header">
	   <div id="logo"><img src="Imagens/Logo_mackenzie_fundo.png" /></div>
	   <div id="links">
		   <ul class="menu">
			   <li><a href="cadastro.jsp">Cadastrar Jogador</a></li>
			   <li><a href="sobre.html">|Sobre o Jogo</a></li>
			   <li><a href="contato.html">|Contate-nos</a></li>
		   </ul>
	   </div>
	</div> 
	<div align="center">
	    <img src="Imagens/Logo_jogo.png" />	
    </div>  
    <p class="titulo_centralizado"><em>Seja bem vindo!Ao jogo do Ano, Dragon City!!!!<br/>Para jogar é necessário realizar o login</em></p>
	<div>
    	<form action="jogador/login.action" method="post">		
    	<input type="hidden" name="requestedUrl" value="${requestedUrl}">
	        <p align="center"><label for="login">Login:</label><input type="text" name="usuario" id="usuario" value="${usuario}"></p>
			<p align="center">Senha:<input type="password" name="senha" id="senha" value="${senha}"></p>
			
			<%String erro = request.getParameter("error");			
				if(erro == null){
					erro ="";				
				}			
			%>			
			<table class="tabela">	
				<tr>
	                <td colspan="2" align="center"><input type="submit" class="btn_enviar" value="Entrar"/></td>
				</tr>
				<tr><td colspan="2"><strong> &nbsp; <label class="erro" generated="true" ><%=erro%></label></strong></td></tr>
				<tr>
				    <td>Primeiro acesso?</td>
			        <td><a href="/cadastro.jsp">Clique aqui e cadastre-se</a></td>
				</tr>
			</table>
		</form>
	</div>    
	
	<div id="footer">
		<img src="Imagens/Footer.png" />
	</div>       
</div>
</body>
</html>
