<%@ include file="/inc/init.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Dragon City</title>
	<%@ include file="/adm/inc/taghead.jsp" %>
	<link href="css/Estilos.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="conteudo">
	<div id="header">
	   <div id="logo"><img src="Imagens/Logo_mackenzie_fundo.png" /></div>
	   <div id="links">
		   <ul class="menu">	
		   	   <li><a href="index.jsp">Início</a></li>		   
			   <li><a href="sobre.html">|Sobre o Jogo|</a></li>
			   <li><a href="contato.html">Contate-nos</a></li>
		   </ul>
	   </div>
	</div> 
  	<div >
   	<form action="jogador/cadastrar.action" method="post" >
   		<p class="titulo_centralizado">Cadastrar Jogador</p>
		<table class="tabela">
			<tr>
			    <td>Nome do jogador:</td> 
		        <td><input type="text" name="nome" id="nome" value="${nome}" onblur="validaNome();" /></td>
			</tr>
			<tr>
			    <td>Login:</td> 
		        <td><input type="text" name="login" id="login" value="${login}" onblur="validaLog();" /></td>
			</tr>	
			<tr>
   			    <td>Senha:</td>
   			    <td><input type="password" name="password" id="password" value="${password}" onblur="validaPass();" ></td>	
			</tr>
			<tr>
			    <td>Confirmar:</td>
 		        <td><input type="password" name="senha_confirmacao" id="senha_confirmacao" onblur="valida();"></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
			    <td colspan="2">	
			   		<input type="submit" value="Salvar" class="btns_cadastro" />
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

function validaNome()
{
	var digitosNome = document.getElementById("nome").value;

	if(digitosNome.length == 0)
	{
		window.alert ("O nome deve ser informado.");
        return false;
	}

	if(digitosNome.length < 4)
	{
		window.alert ("O nome deve ter no minímo 4 dígitos.");
        return false;
	}

}

function validaLog()
{
	var digitosLog =  document.getElementById("login").value;

	if(digitosLog.length == 0)
    {
    	window.alert ("O login deve ser informado.");
        return false;
    }

	if(digitosLog.length < 4)
	{
		window.alert ("O Login deve ter no minímo 4 dígitos.");
        return false;
	}
}
function validaPass()
{
	var digitosPass = document.getElementById("password").value;
    
    if (digitosPass.length == 0)
    {
        window.alert ("A senha deve ser informada.");
        return false;
    }

    if (digitosPass.length < 4)
    {
        window.alert ("A senha deve ter no minímo 4 dígitos.");
        return false;
    }
    
    return true;
}
</script>