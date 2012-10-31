<div class="bordaBox">
	<div class="conteudo">
		<div class="LoginArea" id="loginDefault" style="display:block;">
			<form method="post" action="/GraoPara/doLogin">
				<fieldset>				
					<!-- Login -->
					<label class="sidebar" for="login">Login:</label>
					<input class="inputLogin" type="text" name="login" height="30px" size="auto" placeholder="">

					<!-- Senha -->
					<label class="sidebar" for="senha">Senha:</label>
					<input class="inputLogin" type="password" name="senha" height="30px" size="auto" placeholder="">
				</fieldset>

				<!-- <div>
					<tr>
						<td><input class="buttonEntrar" type="submit" name="Entrar"	value="Entrar" /></td>
						<td><a href="/GraoPara/public/userCadastre.jsp"><input type="button" class="buttonRegistrar" name="Registrar" value="Registrar"></a></td>						
						<p></p>
					</tr>
				</div> -->				
				
				<!-- Espaco -->
				<fieldset>
				</fieldset>

				<fieldset>
					<input class="buttonEntrar" type="submit" name="Entrar"	value="Entrar" />
					<a href="/GraoPara/public/userCadastre.jsp"><input type="button" class="buttonRegistrar" name="Registrar" value="Registrar"></a>
				</fieldset>
			</form>
		</div>
	</div>
</div>