<table class="tableForms">

	<!-- Identifica��o -->
	<tr>
		<td class="tdForms"><label class="labelForms" id="ltipo" for="tipo">Identifica��o</label></td>
	</tr>
	
	<tr>
		<td class="field">
			<select name="tipo" class="inputLong" id="tipo">
					<option value="">Selecione...</option>
					<option value="codice">N�mero de C�dice</option>
					<option value="caixa">N�mero de Caixa</option>
			</select>
		</td>
	</tr>

	<!-- C�digo -->
	<tr>
		<td class="tdForms"><label class="labelForms" id="lcodigo" for="codigo">C�digo</label></td>		
	</tr>
	
	<tr>
		<td class="field"><input class="input" name="codigo" size="10" id="codigo" type="text" maxlength="5" /></td>
	</tr>

	<!-- T�tulo -->
	<tr>
		<td class="tdForms"><label class="labelForms" id="ltitulo" for="titulo">T�tulo</label></td>
	</tr>
	
	<tr>
		<td class="field"><input class="input" name="titulo" id="titulo" type="text" size="20" maxlength="48" /></td>
	</tr>
	
	<!-- Ano Inicial -->
	<tr>
		<td class="tdForms"><label class="labelForms" id="lanoIni" for="anoIni">Ano Inicial</label></td>
	</tr>
	
	<tr>
		<td class="field"><input class="inputAno" name="anoIni" id="anoIni" type="text" size="10" maxlength="4" style="width:100px;" /></td>
	</tr>
	
	<!-- Ano Final -->
	<tr>
		<td class="tdForms"><label class="labelForms" id="lanoFim" for="anoFim">Ano Final</label></td>
	</tr>
	
	<tr>
		<td class="field"><input class="inputAno" name="anoFim" id="anoFim" type="text" size="10" maxlength="4" style="width:100px;" /></td>
	</tr>

	<!-- Botao Cadastrar -->
	<tr>
		<td class="tdForms">
			<br>
			<input class="buttonRegistrar" id="signupsubmit" name="inserir" type="submit" value="Cadastrar" />
		</td>
	</tr>
</table>