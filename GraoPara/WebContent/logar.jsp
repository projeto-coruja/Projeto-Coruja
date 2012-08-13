<%
	String login = "teste"; // Login
	String senha = "123"; // Senha
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Gr�o-Par�</title>

<!-- Import dos styles CSS -->
<link rel="stylesheet" type="text/css"
	href="/GraoPara/css/principal.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/tabs.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/controle.css" />

<!-- CSS das valida��es -->
<link rel="stylesheet" type="text/css"
	href="/GraoPara/css/validationEngine.jquery.css" />

<!-- Import dos javascripts -->
<script type="text/javascript" src="/GraoPara/javascript/ajax.js"
	charset="utf-8"></script>
<script type="text/javascript" src="/GraoPara/javascript/instrucao.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"
	charset="utf-8"></script>
	
<!-- Import dos scripts de valida��o de formul�rio -->
<script type="text/javascript"
	src="/GraoPara/javascript/jquery.validationEngine.js" charset="utf-8"></script>
<script type="text/javascript" src="/GraoPara/javascript/script.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="/GraoPara/javascript/languages/jquery.validationEngine-pt.js"
	charset="utf-8"></script>
</head>

<body>
	<div class="container">
		<div class="header">
			<!-- Come�o do banner -->
			<a href="/GraoPara/index.jsp" class="banner"></a>
		</div>
		<!-- Fim do Banner -->
		<!-- Come�o do menu lateral -->
		<div class="sidebar1">
			<!-- Fim da �rea de login -->
			<article class="menuLateral">
				<ul class="nav" id="menu">
					<li><a href="/GraoPara/index.jsp"><span>H</span>ome</a></li>
					<li><a href="/GraoPara/pesquisa.jsp"><span>P</span>esquisar</a></li>
					<li><a href="/GraoPara/sobre.jsp"><span>S</span>obre</a></li>
				</ul>
			</article>
			<!-- �rea para texto na barra lateral, a barra cresce ao inserir conteudo... -->
			<p></p>
			<p></p>
			<p></p>
			<p></p>
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="content" id="content">

			<%
				String login_form = request.getParameter("login"); // Pega o Login vindo do formul�rio
				String senha_form = request.getParameter("senha"); //Pega a senha vinda do formul�rio
				if (login_form.equals(login) && senha_form.equals(senha)) { //Caso login e senha estejam corretos...
					out.println("Logado com sucesso."); //Mostra na tela que foi logado com sucesso
					session.putValue("loginUsuario", login); //Grava a session com o Login
					session.putValue("senhaUsuario", senha); //Grava a session com a Senha
					out.println("<script>document.location.href='/GraoPara/logado.jsp';</script>"); //Exibe um c�digo javascript para redireionar ao painel
				} else { //Se estiverem incorretos...
					out.println("Login ou senha inv�lidos. </br> <input class='buttonEntrar' type='button' value='Voltar' onClick='history.go(-1)'>"); //Exibe na tela e pede para voltar
				}
			%>
		</div>
		<!-- Come�o do Rodap� -->
		<div class="footer">
			<p>Copyright � - Universidade Federal de S�o Paulo - UNIFESP 2012</p>
			<p>Desenvolvido pelo grupo Coruja</p>
			<a href="/GraoPara/sobre.jsp">- Sobre -</a>
		</div>
		<!-- Fim do Rodap� -->
		<!-- end .container -->
	</div>
</body>
</html>