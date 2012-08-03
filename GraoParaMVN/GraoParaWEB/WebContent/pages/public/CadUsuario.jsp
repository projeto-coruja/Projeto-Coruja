<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8"/>
<title>Projeto Grão-Pará</title>
<link rel="stylesheet" href="style.css" type="text/css" />
<link href="../css/principal.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../jscripts/tiny_mce/tiny_mce.js"></script>
<script type="text/javascript">
 	
</script>

<link rel="stylesheet" href="../css/validationEngine.jquery.css" type="text/css"/>
	<link rel="stylesheet" href="../css/template.css" type="text/css"/>
	</head>
<body>

	<h2>Cadastro Usuário</h2>
	<form action="#" method="POST" name="cadastro" onSubmit="return valida();">
		<table class="tableForms" width="522" border="0" align="center" cellpadding="0" cellspacing="0">
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
					<label for="nome" class="labelForms">Nome Completo:<font color="#FF0000">*</font></label>
				</td>
				<td width="377" height="20">
					 
					<input class="input" name="nome" type="text" required>
					<font class="digitosTexts">(máx.50 digitos)</font>  
					
				</td>
			</tr>
			<tr>
				<td height="20">
					<label for="email" class="labelForms">Email:<font color="#FF0000">*</font></label>
				</td>
				<td width="377" height="20">
					
						<input class="input" name="email" type="email" maxlength="100" required>
						<font class="digitosTexts">(máx 50 digitos)</font> 
					
				</td>
			</tr>
			<tr>
				<td height="20">
					<label for="senha" class="labelForms">Senha:<font color="#FF0000">*</font></label>
				</td>
				<td width="377" height="20">
					<input class="input" name="senha" type="password" maxlength="20" required>
					<font class="digitosTexts">(min. 6 e máx. 20 digitos)</font> 
					
				</td>
			</tr>
			<tr>
				<td height="20">
					<label for="confsenha" class="labelForms">Confirme sua senha:<font color="#FF0000">*</font></label>
				</td>
				<td width="377" height="20">
					<input class="input" name="confsenha" type="password" maxlength="20" required">
					<font class="digitosTexts">(min. 6 e máx. 20 digitos)</font> 
				</td>
			</tr>
			<tr>
				<td height="20"></br><input type="submit" name="inserir" value="Enviar" class="buttonRegistrar"></td>
				<td height="20"></td>
			</tr>
			<tr>
				</br>
			</tr>
			<tr>
				<td colspan="2"> <font class="labelForms">Obs. Novos usuários necessitam da aprovação do administrador. 
				Aguarde o aprovamento de seu cadastro, e use o serviço de pesquisa como convidado.</font></td>
			</tr>
			
		</table>
	</form>	
</body>
</html>