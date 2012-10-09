<%@page import="webview.util.WebUtility" %>

<div class="bordaBox">
	<b class="b1"></b>
	<b class="b2"></b>
	<b class="b3"></b>
	<b class="b4"></b>

	<div class="conteudo">
		<div class="LoginArea" id="logado" style="display: block;">
			<form method="post" action="/GraoPara/doLogout">
				<fieldset>
					<label class="sidebar" for="login">
						Bem vindo
						<%WebUtility.printName(request, out);%>
					</label>
				</fieldset>

				<fieldset>
					<input class="buttonSair" type="submit" name="Sair" value="Sair" />
				</fieldset>
			</form>
		</div>
	</div>

	<b class="b4"></b>
	<b class="b3"></b>
	<b class="b2"></b>
	<b class="b1"></b>
</div>