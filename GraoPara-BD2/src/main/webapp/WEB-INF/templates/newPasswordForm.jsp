<%@page contentType="text/html; charset=UTF-8"%>
<table class="tableForms">

	<!-- Senha Atual -->
	<tr>
		<td class="tdControle"><label class="labelForms" id="lpassword" for="password">Senha Atual</label></td>
	</tr>	
	
	<tr>
		<td class="field"><input id="senhaAtual" class="inputPass" name="senhaAtual" type="password" maxlength="50" value="" /></td>	
		<td class="status"></td>
	</tr>

	<!-- Senha Nova -->
	<tr>
		<td class="tdControle"><label class="labelForms" id="lpassword" for="password">Senha Nova</label></td>	
	</tr>
	
	<tr>
		<td class="field"><input id="senhaNova" class="inputPass" name="senhaNova" type="password" maxlength="50" value="" /></td>	
		<td class="status"></td>
	</tr>

	<!-- Confirma Senha -->
	<tr>
		<td class="tdControle"><label class="labelForms" id="lpassword" for="password">Confirma Senha</label></td>	
	</tr>
	
	<tr>
		<td class="field"><input id="senhaConfirme" class="inputPass" name="senhaConfirme" type="password" maxlength="50" value="" /></td>	
		<td class="status"></td>
	</tr>

	<!-- Botao Alterar -->
	<tr>
		<td class="tdForms">
		<br>
		<input class="buttonRegistrar" id="signupsubmit" name="Alterar" type="submit" value="Alterar" /></td>
	</tr>
</table>