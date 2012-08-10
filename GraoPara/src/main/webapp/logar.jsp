<%
String login = "thales"; // Login
String senha = "123"; // Senha
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Sistema de Login :: JSP</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<style>
body, td, a:link, a:visited {
font-family: Verdana;
font-size: 10px;
color: #000000;
text-decoration: none;
}
a:hover{
color: #FF0000;
}
input {
font-family: Verdana, Arial, Helvetica, sans-serif;
font-size: 10px;
background-color: #FFFFFF;
border: 1px solid #000000;
}
</style>
</head> <body>
<%
String login_form = request.getParameter("login"); // Pega o Login vindo do formulário
String senha_form = request.getParameter("senha"); //Pega a senha vinda do formulário
if(login_form.equals(login) && senha_form.equals(senha)){ //Caso login e senha estejam corretos...
out.println("Logado com sucesso."); //Mostra na tela que foi logado com sucesso
session.putValue("loginUsuario", login); //Grava a session com o Login
session.putValue("senhaUsuario", senha); //Grava a session com a Senha
out.println("<script>document.location.href='/GraoPara/logado.jsp';</script>"); //Exibe um código javascript para redireionar ao painel
} else { //Se estiverem incorretos...
out.println("Login ou senha inválidos. </br> <input type='button' value='Voltar' onClick='history.go(-1)'>"); //Exibe na tela e pede para voltar
}
%>
</body>
</html>