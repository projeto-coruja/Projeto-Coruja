<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" charset="utf-8">
<title>Projeto Grão-Pará</title>

<link href="../../css/principal.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="../../css/validationEngine.jquery.css" type="text/css"/>
<link rel="stylesheet" href="../../css/template.css" type="text/css"/>
<!-- scripts -->
<script type="text/javascript" src="../../jscripts/tiny_mce/tiny_mce.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="../../javascript/jquery.validationEngine.js" charset="utf-8"></script>
<script type="text/javascript" src="../../javascript/languages/jquery.validationEngine-pt.js" charset="utf-8"></script>
<script type="text/javascript" src="../../javascript/script.js"></script>							
<!-- /scripts -->

</head>
<body>
	
<h2>Cadastro de Documentos</h2>
	<form action="#" method="POST" name="cadastro">
		<table class="tableForms" width="600" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td height="20" colspan="2">
					<div align="left">
						<font size="1" face="Verdana, Arial, Helvetica, sans-serif">
							<b>PREENCHA TODOS OS CAMPOS COM ASTERÍSCO <font
								color="#FF0000">*</font></b>
						</font>
					</div>
				</td>
			</tr>
			<tr>
				<td height="20">
					<label for="identificaÃ§Ã£o" class="labelForms">Identificação:<font color="#FF0000">*</font></label>
				</td>
				<td height="20">
				 	<select name="identificacao" class="input validate[required] smallInput" id="identificacao">
							<option value="">Selecione...</option>
							<option value="codice">Número de Códice</option>
							<option value="caixa">Número da Caixa</option>
					</select>
				</td>
			</tr>
			<tr>
				<td height="20">
					<label for="codigo" class="labelForms">Código:<font color="#FF0000">*</font></label>
				</td>
				<td width="377" height="20">
						<input class="input validate[required,custom[onlyNumberSp]]" name="codigo" id="codigo" type="text" size="10" maxlength="5">
                        <label for="maxDigitos" class="labelForms">(máx. 5 digitos)</label>
				</td>
			</tr>
			<tr>
				<td height="20">
					<label for="nomeDocumento" class="labelForms">Nome do Documento:<font color="#FF0000">*</font></label>
				</td>
				<td width="377" height="20">
						<input class="input validate[required]" name="nome" id="nome" type="text" size="20" maxlength="100">
                        <label for="maxDigitos" class="labelForms">(máx.100 digitos)</label> 
				</td>
			</tr>
			<tr>
				<td height="20">
					<label for="numeroAPEP" class="labelForms">Número APEP ou Sequencial:<font color="#FF0000">*</font></label>
				</td>
				<td width="377" height="20">
						<input class="input validate[required,custom[onlyNumberSp]]" name="numero" id="numero" type="text" size="10" maxlength="4" style="FONT-FAMILY: 'Century Schoolbook L';">
                        <label for="maxDigitos" class="labelForms">(máx. 4 digitos)</label>
				</td>
			</tr>
			<tr>
				<td height="20">
					<label for="autor" class="labelForms">Autor do Documento:<font color="#FF0000">*</font></label>
				</td>
				<td width="377" height="20">
				 		<input class="input validate[required]" name="autor" id="autor" type="text" size="20" maxlength="100">
                        <label for="maxDigitos" class="labelForms">(máx. 100 digitos)</label>
				</td>
			</tr>
			<tr>
				<td height="20">
					<label for="destinario" class="labelForms">Destinatário do Documento:<font color="#FF0000">*</font></label>
				</td>
				<td width="377" height="20">
				     
				    	<input class="input validate[required]" name="destinatario" id="destinatario" type="text" size="20" maxlength="100">
                        <label for="maxDigitos" class="labelForms">(máx. 100 digitos)</label>
				</td>
			</tr>
			<tr>
				<td height="20">
					<label for="estado" class="labelForms">Estado:<font color="#FF0000">*</font></label>
                
				</td>
                <td>
                    <select class="inputEstado validate[required] smallInput" name="estado" id="estado">
							<option value="">---</option>
							<option value="AC">AC</option>
							<option value="AL">AL</option>
							<option value="AP">AP</option>
							<option value="AM">AM</option>
							<option value="BA">BA</option>
							<option value="CE">CE</option>
							<option value="ES">ES</option>
							<option value="DF">DF</option>
							<option value="MA">MA</option>
							<option value="MT">MT</option>
							<option value="MS">MS</option>
							<option value="MG">MG</option>
							<option value="PA">PA</option>
							<option value="PB">PB</option>
							<option value="PR">PR</option>
							<option value="PE">PE</option>
							<option value="PI">PI</option>
							<option value="RJ">RJ</option>
							<option value="RN">RN</option>
							<option value="RS">RS</option>
							<option value="RO">RO</option>
							<option value="RR">RR</option>
							<option value="SC">SC</option>
							<option value="SP">SP</option>
							<option value="SE">SE</option>
							<option value="TO">TO</option>
					</select>
                </td>
				
			</tr>
            <tr>
            	<td height="20">
					<label for="cidade" class="labelForms">Cidade:<font color="#FF0000">*</font></label>
						
				</td>
                <td>
                <input class="input validate[required]" name="cidade" id="cidade" type="text" size="15" maxlength="100">
                        <label for="maxDigitos" class="labelForms">(máx. 100 digitos)</label>
            </tr>
			<tr>
				<td height="20">
					<label for="dataDocumento" class="labelForms">Data do Documento:<font color="#FF0000">*</font></label>
				</td>
				<td height="20">
					<input class="input validate[required,custom[date]]" type="text" name="data" id="data" maxlength="10"/> <label for="maxDigitos" class="labelForms">(Ex.: 12/02/1993)</label>
				</td>
			</tr>
			<tr>
				<td height="20">
					<label for="dataDocumento" class="labelForms">Tipo do Documento:<font color="#FF0000">*</font></label>
				</td>
				<td height="20">
				 	<select class="input validate[required] smallInput" name="tipoDoc" id="tipoDoc"> <!-- Pegar do Banco de dados os tipos e, caso o usuÃ¡rio selecione outro, exibir campo para cadastrar outro tipo -->
							<option value="">Selecione...</option>
							<option value="codice">Ofícios</option>
							<option value="caixa">Relatórios</option>
							<option value="caixa">Impressos</option>
							<option value="caixa">Processos</option>
							<option value="caixa">Outro</option>
					</select>
				</td>
			</tr>			
			<tr>
				<td height="20" colspan="2">
					<div align="left"> </br>
						<font size="1" face="Verdana, Arial, Helvetica, sans-serif"><b>RESUMO OU VERBETE DO DOCUMENTO:</b><font color="#FF0000">*</font></font>
					</div>
				</td>
			</tr>
			<td height="20" colspan="2">
				<font class="labelForms">
					<textarea class="inputResumo" id="resumo" name="resumo" rows="7" cols="40" maxlength="1000" style="FONT-SIZE: x-small;"></textarea>
				</font>
			</td>			
			<tr>
				<td height="20" colspan="2">
					<div align="left"> </br>
						<label for="palavrasChaves" class="labelForms">Palavra Chaves:<font color="#990000">(Obrigatório pelo menos uma)</font></label>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
						<input class="inputPalavraChave validate[groupRequired[chaves]]" id="chave1" name="chave1" type="text" size="15" maxlength="30"> - 
						<input class="inputPalavraChave validate[groupRequired[chaves]]" id="chave2" name="chave2" type="text" size="15" maxlength="30"> - 
						<input class="inputPalavraChave validate[groupRequired[chaves]]" id="chave3" name="chave3" type="text" size="15" maxlength="30"> 
				</td>
			</tr>
			<tr>
				<td height="20"></br> </br><input class="buttonEntrar" type="submit" name="inserir" value="Enviar"></td>
				<td height="20"></td>
			</tr>
		</table>
	</form>	
	
</body>
</html>