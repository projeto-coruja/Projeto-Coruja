<%@page contentType="text/html; charset=UTF-8"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Grão-Pará</title>
		
		<!-- Import dos styles CSS -->
		<link rel="stylesheet" type="text/css"	href="/GraoPara/css/principal.css" />
		<link rel="stylesheet" type="text/css" href="/GraoPara/css/tabs.css" />
		<link rel="stylesheet" type="text/css" href="/GraoPara/css/controle.css" />

		<!-- CSS das validacoes -->
		<link rel="stylesheet" type="text/css" href="/GraoPara/css/validationEngine.jquery.css" />

		<!-- Import dos javascripts -->
		<script type="text/javascript" src="/GraoPara/javascript/cookie.js"	charset="utf-8"></script>
	</head>

	<body onloadstart="checkCookie()">
		<div class="container">
			<div class="header"></div>

			<!-- Menu lateral -->
			<div class="sidebar1">
			
				<!-- Area de login -->
				<%@include file="/WEB-INF/templates/login.jsp" %>

				<!-- Area de menu -->
				<%@include file="/WEB-INF/templates/defaultMenu.jsp"%>
			</div>
		
			<div class="content" id="content">
				<h1>Recuperar Senha</h1>
				<form id="signupform" autocomplete="off" method="post" action="/GraoPara/passwordRecovery">
					<table class="tableForms">
						<tr>
							<td class="tdForms">
								<label class="labelForms" id="lmail" for="mail">Email</label>
							</td>
						</tr>
						
						<tr>
							<td class="field">
								<input class="input" name="email" id="email" type="text" size="20" maxlength="1024" />
							</td>
							<td class="status"></td>
						</tr>
						<tr>
							<td class="tdForms2">
								<br>
								<input class="buttonRegistrar" id="signupsubmit" name="inserir" type="submit" value="Enviar" />
							</td>
						</tr>
					</table>		
				</form>
			</div>	

			<!-- Rodape -->
			<%@include file="/WEB-INF/templates/footer.jsp" %>
		</div>
	</body>
</html>