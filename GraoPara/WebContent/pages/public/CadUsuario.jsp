<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8"/>
<title>Projeto Grão-Pará</title>
<link href="/GraoPara/faces/pages/css/principal.css" rel="stylesheet" type="text/css">
<!-- scripts -->
				<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
				<script type="text/javascript" src="/GraoPara/faces/pages/javascript/jquery.validationEngine.js" charset="utf-8"></script>
				<script type="text/javascript" src="/GraoPara/faces/pages/javascript/languages/jquery.validationEngine-pt.js" charset="utf-8"></script>
				<script type="text/javascript" src="/GraoPara/faces/pages/javascript/script.js"></script>							
<!-- /scripts -->
 	
	<link rel="stylesheet" href="/GraoPara/faces/pages/css/validationEngine.jquery.css" type="text/css"/>
	
	</head>
<body>

	<h2>Cadastro Usuário</h2>
	<form action="#" method="POST" name="cadastro">
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
					 
					<input class="input validate[required] mediumInput" name="nome" type="text" id="nome" maxlength="50">
					<font class="digitosTexts">(máx.50 digitos)</font>  
					
				</td>
			</tr>
			<tr>
				<td height="20">
					<label for="email" class="labelForms">Email:<font color="#FF0000">*</font></label>
				</td>
				<td width="377" height="20">
					
						<input class="input validate[required] validate[custom[email]] mediumInput" name="email" id="email" maxlength="50">
						<font class="digitosTexts">(máx 50 digitos)</font> 
					
				</td>
			</tr>
			<tr>
				<td height="20">
					<label for="senha" class="labelForms">Senha:<font color="#FF0000">*</font></label>
				</td>
				<td width="377" height="20">
					<input class="input validate[required,minSize[6]]" id="senha" name="senha" type="password" maxlength="20">
					<font class="digitosTexts">(min. 6 e máx. 20 digitos)</font> 					
				</td>
			</tr>
			<tr>
				<td height="20">
					<label for="confsenha" class="labelForms">Confirme sua senha:<font color="#FF0000">*</font></label>
				</td>
				<td width="377" height="20">
					<input class="input validate[required,equals[senha]]" id="confsenha" name="confsenha" type="password" maxlength="20">
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