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
	   <div id="logo"><img src="Imagens/Logo_mackenzie_fundo.png" /></div>
	   <div id="links">
		   <ul class="menu">			   
			   <li><a href="#">Sobre o Jogo|</a></li>
			   <li><a href="#">Contate-nos</a></li>
		   </ul>
	   </div>
	</div> 
  	<div >
   	<form action="jogador/cadastrar.action" method="post" >
   		<p class="titulo_centralizado">Cadastrar Jogador</p>
		<table class="tabela">
			<tr>
			    <td>Nome do jogador:</td> 
		        <td><input type="text" name="nome" id="nome" value="${nome}" onblur="validaDigitos();" /></td>
			</tr>
			<tr>
			    <td>Login:</td> 
		        <td><input type="text" name="login" id="login" value="${login}" onblur="validaDigitos();" /></td>
			</tr>	
			<tr>
   			    <td>Senha:</td>
   			    <td><input type="password" name="password" id="password" value="${password}" onblur="validaDigitos();" ></td>	
			</tr>
			<tr>
			    <td>Confirmar:</td>
 		        <td><input type="password" name="senha_confirmacao" id="senha_confirmacao" onblur="valida();"></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
			    <td colspan="2">	
			   		<input type="submit" value="Salvar" class="btns_cadastro" onclick="valida();validaDigitos();" />
		           	<input type="reset" value="Cancelar"  class="btns_cadastro" />
		        </td>
            </tr>
			<tr><td>&nbsp;</td></tr>
		</table>
	</form>		
	</div>    
	
	<div id="footer">
		<img src="Imagens/Footer.png" />
	</div>       
</div>
</body>
</html>
<script type="text/javascript">
function valida()
{
    if (document.getElementById("password").value != document.getElementById("senha_confirmacao").value)
    {
        window.alert ("O campo de confirmação de senha deve ser igual ao campo senha.");
        return false;
    }
    return true;
}

function validaDigitos()
{
	var digitosPass = document.getElementById("password").value;
	var digitosLog =  document.getElementById("login").value;
	var nome =  document.getElementById("nome").value;
	

	//alert("pass=" + digitosPass + "&login=" + digitosLog);
	if (nome.length == 0)
    {
		window.alert ("O nome deve ser informado.");
        return false;
    }

	if(digitosLog.length == 0)
    {
    	window.alert ("O login deve ser informado.");
        return false;
    }
    
    if (digitosPass.length == 0)
    {
        window.alert ("A senha deve ser informada.");
        return false;
    }
    
    return true;
}
</script>