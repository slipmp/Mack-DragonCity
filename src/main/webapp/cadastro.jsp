<%@ include file="/inc/init.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Dragon City</title>
	<link href="css/Estilos.css" rel="stylesheet" type="text/css" />
	<%@ include file="/adm/inc/taghead.jsp" %>
</head>
<body>
<div id="conteudo">
	<div id="header">
	   <div id="logo"><img src="/imagens/logo_mackenzie_fundo.png" /></div>
	   <div id="links">
		   <ul class="menu">			   
			   <li><a href="#">Sobre o Jogo|</a></li>
			   <li><a href="#">Contate-nos</a></li>
		   </ul>
	   </div>
	</div> 
  	<div >
   	<form action="/usuario/cadastrar.action" method="post" >
   		<p class="titulo_centralizado">Cadastrar Jogador</p>
		<table align="center">
			<tr>
			    <td>Login:</td> 
		            <td><input type="text" name="login" id="login" value="${login}" /></td>
			</tr>
	
			<tr>
    			    <td>Senha:</td>
    			    <td><input type="password" name="senha" id="senha" value="${password}"></td>	
			</tr>
			<tr>
			    <td>Confirmar:</td>
 		        <td><input type="password" name="senha_confirmacao" id="senha_confirmacao"></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
			    <td>
			    	<input type="submit" value="Salvar" class="btn_enviar" /></td>
		            <td><input type="reset" value="Cancelar"  class="btn_enviar" /></td>
            </tr>
			<tr><td>&nbsp;</td></tr>
		</table>
	</form>		
	</div>    
	
	<div id="footer">
		<img src="imagens/Footer.png" />
	</div>       
</div>
</body>
</html>
