<table class="tableForms">
	<tr>
		<td class="tdForms"><label class="labelForms" id="ltipo" for="tipo">Identificação</label></td>
		<td class="field">
			<select name="tipo" class="input" id="tipo">
					<option value="">Selecione...</option>
					<option value="codice">Número de Códice</option>
					<option value="caixa">Número de Caixa</option>
			</select>
		</td>
	</tr>

	<tr>
		<td class="tdForms"><label class="labelForms" id="lcodigo" for="codigo">Código</label></td>
		<td class="field"><input class="input" name="codigo" size="10" id="codigo" type="text" maxlength="5"></td>
	</tr>

	<tr>
		<td class="tdForms"><label class="labelForms" id="ltitulo" for="titulo">Título</label></td>
		<td class="field"><input class="input" name="titulo" id="titulo" type="text" size="20" maxlength="48"></td>
	</tr>
	
	<tr>
		<td class="tdForms"><label class="labelForms" id="lanoIni" for="anoIni">Ano Inicial</label></td>
		<td class="field"><input class="input" name="anoIni" id="anoIni" type="text" size="10" maxlength="4"></td>
	</tr>
	
	<tr>
		<td class="tdForms"><label class="labelForms" id="lanoFim" for="anoFim">Ano Final</label></td>
		<td class="field"><input class="input" name="anoFim" id="anoFim" type="text" size="10" maxlength="4"></td>
	</tr>

	<tr>
		<td class="tdForms">
			<br>
			<input class="buttonRegistrar" id="signupsubmit" name="inserir" type="submit" value="Cadastrar" />
		</td>
	</tr>
</table>