<!-- <%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html> 
-->
<html>
<head>
<meta charset="utf-8">
<link href="principal.css" rel="stylesheet" type="text/css">
<title>Pesquisa</title>
</head>

<body>
<form action="#" method="get" name="pesquisa" onSubmit="return valida();">
		<table width="522" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td height="20">
					<font size="1" face="Verdana, Arial, Helvetica, sans-serif">Identificação:</font>
				</td>
				<td height="20">
				 	<select class="input" name="identificacao">
							<option selected>Selecione...</option>
							<option value="codice">Número de Códice</option>
							<option value="caixa">Número da Caixa</option>
					</select>
				</td>
			</tr>
			<tr>
				<td height="20">
					<font size="1" face="Verdana, Arial, Helvetica, sans-serif">Código:</font>
				</td>
				<td width="377" height="20">
					<font size="1" face="Verdana, Arial, Helvetica, sans-serif"> 
						<input class="input" name="codigo" type="text" size="10" maxlength="5">(max. 5 digitos)
					</font>
				</td>
			</tr>
			<tr>
				<td height="20">
					<font size="1" face="Verdana, Arial, Helvetica, sans-serif">Nome do Documento:</font>
				</td>
				<td width="377" height="20">
					<font size="1" face="Verdana, Arial, Helvetica, sans-serif"> 
						<input name="nome" type="text" size="20" maxlength="100"> 
					</font>
				</td>
			</tr>
			<tr>
				<td height="20">
					<font size="1" face="Verdana, Arial, Helvetica, sans-serif">Número APEP ou número sequencial:</font>
				</td>
				<td width="377" height="20">
					<font size="1" face="Verdana, Arial, Helvetica, sans-serif"> 
						<input name="numero" type="text" size="10" maxlength="4">
					</font>
				</td>
			</tr>
			<tr>
				<td height="20">
					<font size="1" face="Verdana, Arial, Helvetica, sans-serif">Autor do Documento:</font>
				</td>
				<td width="377" height="20">
					<font size="1" face="Verdana, Arial, Helvetica, sans-serif">
				 		<input name="autor" type="text" size="20" maxlength="100">
					</font>
				</td>
			</tr>
			<tr>
				<td height="20">
					<font size="1" face="Verdana, Arial, Helvetica, sans-serif">Destinatário do Documento:</font>
				</td>
				<td width="377" height="20">
				    <font size="1" face="Verdana, Arial, Helvetica, sans-serif"> 
				    	<input name="destinatario" type="text" size="20" maxlength="100"> </font>
				</td>
			</tr>
			<tr>
				<td height="20">
					<font size="1" face="Verdana, Arial, Helvetica, sans-serif">Local:</font>
				</td>
				<td width="377" height="20">
					<font size="1" face="Verdana, Arial, Helvetica, sans-serif">Cidade:</font> 
						<input name="cidade" type="text" size="15" maxlength="8">
						<select name="estado" id="estado">
							<option selected>Selecione...</option>
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
					<font size="1" face="Verdana, Arial, Helvetica, sans-serif">Data do Documento:</font>
				</td>
				<td height="20">
					<input type="text" name="data" maxlength="10" onkeyup="Formatadata(this,event)" />
				</td>
			</tr>
			<tr>
				<td height="20">
					<font size="1" face="Verdana, Arial, Helvetica, sans-serif">Tipo do Docimento:</font>
				</td>
				<td height="20">
				 	<select name="tipoDoc"> <!-- Pegar do Banco de dados os tipos e, caso o usuário selecione outro, exibir campo para cadastrar outro tipo -->
							<option selected>Selecione...</option>
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
						<font size="1" face="Verdana, Arial, Helvetica, sans-serif">Palavra Chaves:</font>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<font size="1" face="Verdana, Arial, Helvetica, sans-serif"> 
						<input name="chave1" type="text" size="15" maxlength="30"> - 
						<input name="chave2" type="text" size="15" maxlength="30"> - 
						<input name="chave3" type="text" size="15" maxlength="30"> 
					</font>
				</td>
			</tr>
			<tr>
				<td height="20"></br> </br><input type="submit" name="inserir" value="Procurar"></td>
				<td height="20"></td>
			</tr>
		</table>
	</form>	
</body>
</html>