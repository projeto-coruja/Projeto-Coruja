<div class="bordaBox">
	<b class="b1"></b>
	<b class="b2"></b>
	<b class="b3"></b>
	<b class="b4"></b>

	<div class="conteudo">
		<div class="LoginArea" id="loginDefault" style="display:block;">
			<form method="post" action="/GraoPara/doLogin">
				<fieldset>
					<label class="sidebar" for="login">Login:</label>
					<input class="inputLogin" type="text" name="login" height="30px" size="auto" placeholder="Seu login" required>

					<label class="sidebar" for="senha">Senha:</label>
					<input class="inputLogin" type="password" name="senha" height="30px" size="auto" placeholder="Sua senha" required>
				</fieldset>

				<fieldset>
					<input class="buttonEntrar" type="submit" name="Entrar"	value="Entrar" />
				</fieldset>

				<fieldset>
					<a href="/GraoPara/public/userCadastre.jsp">
						<input type="button" class="buttonRegistrar" name="Registrar" value="Registrar">
					</a>
				</fieldset>
			</form>
		</div>
	</div>

	<b class="b4"></b>
	<b class="b3"></b>
	<b class="b2"></b>
	<b class="b1"></b>
</div>