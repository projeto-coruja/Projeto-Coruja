<%@page import="webview.util.WebUtility" %>

<div class="bordaBox" style="border-top: 3px solid #033454;">
	<div class="conteudo">
		<div class="LoginArea" id="logado" style="display: block;">
			<form method="post" action="/GraoPara/doLogout">
				<fieldset>
					<label class="sidebar" for="login">
						Bem vindo <%WebUtility.printName(request, out);%>
					</label>
					
				</fieldset>

				<fieldset style="padding-left:17px">
					<input class="buttonSair" type="submit" name="Sair" value="Sair" />
				</fieldset>
			</form>
		</div>
	</div>
</div>