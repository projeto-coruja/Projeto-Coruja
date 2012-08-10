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
//Verifica se está logado
if(session.getValue("loginUsuario") != null || session.getValue("senhaUsuario") != null){
out.println("Você está logado com sucesso no sistema, por isso consegue ver está pagina. Seu login é: " + session.getValue("loginUsuario") + " e sua senha: " + session.getValue("senhaUsuario") + ". Clique <a href='/GraoPara/logoff.jsp'>aqui</a> para sair do sistema");
} else {
out.println("Você não está logado no sistema. Clique <a href='/GraoPara/index.jsp'>aqui</a> para logar-se");
}
%>
</body>
</html>