<%@page contentType="text/html; charset=UTF-8"%>
<table class="tableForms">
	<tr>
		<td class="tdControle">
			<label class="labelForms" id="ltpDoc" for="tpDoc">Novo Tipo de Documento</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<input class="input" id="tpDoc" name="docType" type="text" value="" maxlength="20" />
		</td>
		<td class="status"></td>
	</tr>
	
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="ldescricaoTipoDocumento" for="descricaoTipoDocumento">Descrição do Tipo de Documento</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<input class="input" name="docTypeDescription" id="descricaoTipoDocumento" type="text" size="20" maxlength="1024" />
		</td>
		<td class="status"></td>
	</tr>

	<tr>
		<td class="tdForms">
			<br>
			<input class="buttonRegistrar" id="signupsubmit" name="inserir" type="submit" value="Cadastrar" />
		</td>
	</tr>
</table>