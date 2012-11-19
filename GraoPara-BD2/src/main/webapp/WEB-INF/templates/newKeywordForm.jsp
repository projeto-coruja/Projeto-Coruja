<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="webview.util.WebUtility"%>

<table class="tableForms">
	<tr>
		<td class="tdControle"><label class="labelForms" id="lchave" for="chave">Palavra-Chave</label></td>
	</tr>
		
	<tr>
		<td class="field"><input class="input" id="palavra"	name="palavraNova" type="text" value="" maxlength="32" /></td>
		<td class="status"></td>
	</tr>	
		
	<tr>
		<td class="tdControle"><label class="labelForms" id="ltema" for="tema">Tema</label>
	</tr>
	
	<tr>		
		<td class="field">
			<select class="inputLong" id="tema" name="tema">
				<%=WebUtility.printSelectKeyWordThemes() %>
			</select>
		</td>
	 	<td class="field"><input class="input" id="action" name="action" type="hidden" value="add" maxlength="32" /></td>
		<td class="field"><input class="input" id="action" name="from" type="hidden" value="cadastrarPalavrasChave.jsp" maxlength="20" /></td>							
	</tr>

	<tr>
		<td class="tdForms" align="right" colspan="2">
			<br>
			<input class="buttonRegistrar" id="signupsubmit" name="inserir" type="submit" value="Cadastrar" />
		</td>
	</tr>
</table>