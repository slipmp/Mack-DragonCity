<%@ include file="/inc/init.jsp" %>
<html>
<head>
		<title>Dragon City</title>
		<link rel="stylesheet" type="text/css" href="css/Estilos.css" /> 
		<%@ include file="/adm/inc/taghead.jsp" %>
</head>
<body>
<div id="conteudo">
	<div id="header">
	   <div id="logo"><img src="Imagens/Logo_mackenzie_fundo.png" /></div>
	   <div id="links">
		   <ul class="menu">
			   <li><a href="#">Cadastrar Jogador|</a></li>
			   <li><a href="#">Sobre o Jogo|</a></li>
			   <li><a href="#">Contate-nos</a></li>
		   </ul>
	   </div>
	</div> 
	<div align="center">
	    <img src="Imagens/Logo_jogo.png" />	
    </div>  
    <p class="titulo_centralizado"><em>Seja bem vindo!Ao jogo do Ano, Dragon City!!!!<br/>Para jogar é necessário realizar o login</em></p>
	<div id="form" action="adm/login.action" method="post">
    	<form id="form1">		
    	<input type="text" name="requestUrl" value="jogo.jsp">
	        <p align="center"><label for="login">Login:</label><input type="text" name="login" id="login" value="${param.usuario}"></p>
			<p align="center">Senha:<input type="password" name="senha" id="senha" value="${param.senha}"></p>
			<table align="center">
				<tr>
				    <td>Esqueceu a senha?</td>
			        <td><a href="esqueceu_senha.html">Clique aqui</a></td>
	                <td rowspan="2"><input type="submit" class="btn_enviar" value="Entrar"/></td>
				</tr>		
				<tr>
				    <td>Primeiro acesso?</td>
			        <td><a href="/cadastro.jsp">Clique aqui e cadastre-se</a></td>
				</tr>
			</table>
			<p align="center"> </p>
			<p align="center"></p>	
			<strong> &nbsp; <label class="error" for="login" generated="true" >${error}</label></strong>		
		</form>
	</div>    
	
	<div id="footer">
		<img src="Imagens/Footer.png" />
	</div>       
</div>
</body>
</html>
