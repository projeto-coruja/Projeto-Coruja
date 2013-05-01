<%@page contentType="text/html; charset=UTF-8"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Grão-Pará</title>

		<!-- Import dos styles CSS -->
		<link rel="stylesheet" type="text/css" href="/GraoPara/css/principal.css" />
		<link rel="stylesheet" type="text/css" href="/GraoPara/css/tabs.css" />
		<link rel="stylesheet" type="text/css" href="/GraoPara/css/controle.css" />

		<link type="text/css" href="/GraoPara/css/ie.css" rel="stylesheet" />
		<style type="text/css">
			.content2{
				padding: 0 0 0 175px;
			}
			.download{
				margin: 0 0 0 -20px;
			}
			p{
				text-align: center;
				text-indent: 1em;
			}
			a:link {
				text-decoration: none;
			}

			a:visited {
				text-decoration: none;
			}

			a:hover {
				text-decoration: none;
			}

			a:active {
				text-decoration: none;
			}
		</style>
	</head>

	<body onloadstart="checkCookie()">
		<div class="container">
			<div class="header"></div>

			<div class="content2" id="content">
				<div class="browser">
					<h2>Navegador Incompatível!</h2>
					<p>
						Seu navegador não é compatível com o nosso site. <br/>Para a visualização do site, será necessário o download de um dos navegadores abaixo.
						<br />
					</p>

					<div class="download">
						<!-- Downloads de navegadores -->
						<a style="margin: 10px 20px 30px 40px;" href="http://www.google.com/chrome/?hl=pt_BR">
							<img src="/GraoPara/images/chrome.png" alt="Chrome" />
							<br />
							Download do Google Chrome
						</a>
	
						<a style="margin: 10px 20px 30px 40px;" href="http://www.mozilla.com/firefox/">
							<img src="/GraoPara/images/firefox.png" alt="Firefox" />
							<br />
							Download do Mozilla Firefox
						</a>
	
						<a style="margin: 10px 20px 30px 40px;" href="http://www.apple.com/safari/download/">
							<img src="/GraoPara/images/safari.png" alt="Safari" />
							<br />
							Download do Safari
						</a>
					</div>
				</div>
			</div>

			<!-- Rodape -->
			<div class="footer">
				<p>Copyright © - Universidade Federal de São Paulo - UNIFESP 2012</p>
				<p>Desenvolvido pelo grupo Coruja</p>
			</div>
		</div>
	</body>
</html>