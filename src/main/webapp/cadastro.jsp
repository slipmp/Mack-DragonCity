<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Dragon City</title>
	<link href="css/Estilos.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="conteudo">
	<div id="header">
	   <div id="logo"><img src="imagens/logo_mackenzie_fundo.png" /></div>
	   <div id="links">
		   <ul class="menu">			   
			   <li><a href="#">Sobre o Jogo|</a></li>
			   <li><a href="#">Contate-nos</a></li>
		   </ul>
	   </div>
	</div> 
  	<div id="form">
   	<form id="form1">
   		<p class="titulo_centralizado">Cadastrar Jogador</p>
		<table align="center">
			<tr>
			    <td>Nome:</td> 
		            <td><input type="text" name="nometxt" id="nometxt"></td>
			</tr>
			<tr>
    		            <td>Emal:</td>
                            <td><input type="text" name="emailtxt" id="emailtxt"></td>	
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
    			    <td>Senha:</td>
    			    <td><input type="password" name="senhatxt" id="senhatxt"></td>	
			</tr>
			<tr>
			    <td>Confirmar:</td>
 		            <td><input type="password" name="confsenhatxt" id="confsenhatxt"></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
			    <td><input type="submit" value="Salvar" class="btn_enviar" /></td>
		            <td><input type="reset" value="Cancelar"  class="btn_enviar" /></td>
                        </tr>
			<tr><td>&nbsp;</td></tr>
		</table>
		<!--<div class="SeparadorHorizontalFiltro"></div>!-->
	</form>		
	</div>    
	
	<div id="footer">
		<img src="imagens/Footer.png" />
	</div>       
</div>
</body>
</html>
