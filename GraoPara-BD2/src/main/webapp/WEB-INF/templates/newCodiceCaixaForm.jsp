<table class="tableForms">

	<!-- Identifica��o -->
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="ltipo" for="tipo">Identifica��o</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<select name="tipo" class="inputLong" id="tipo" style="width:350px;">
					<option value="">Selecione...</option>
					<option value="codice">N�mero de C�dice</option>
					<option value="caixa">N�mero de Caixa</option>
			</select>
		</td>
		<td class="status"></td>
	</tr>

	<!-- C�digo -->
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="lcodigo" for="codigo">C�digo</label>
		</td>		
	</tr>
	
	<tr>
		<td class="field">
			<input class="input" name="codigo" size="10" id="codigo" type="text" maxlength="5" style="width:350px;"/>
		</td>		
		<td class="status"></td>
	</tr>

	<!-- T�tulo -->
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="ltitulo" for="titulo">T�tulo</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<input class="input" name="titulo" id="titulo" type="text" size="20" maxlength="350" style="width:350px;"/>
		</td>
		<td class="status"></td>
	</tr>
	
	<!-- Ano Inicial -->
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="lanoIni" for="anoIni">Ano Inicial</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<input class="input" name="anoIni" id="anoIni" type="text" size="10" maxlength="4" style="width:160px;"/>
		</td>
		<td class="status"></td>
	</tr>
	
	<!-- Ano Final -->
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="lanoFim" for="anoFim">Ano Final</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<input class="input" name="anoFim" id="anoFim" type="text" size="10" maxlength="4" style="width:160px;"/>
		</td>
		<td class="status"></td>
	</tr>

	<!-- Botao Cadastrar -->
	<tr>
		<td class="tdForms">
			<br>
			<input class="buttonRegistrar" id="signupsubmit" name="inserir" type="submit" value="Cadastrar"/>
		</td>
	</tr>
</table>