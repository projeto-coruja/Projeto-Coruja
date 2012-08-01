<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/principal.css" rel="stylesheet" type="text/css"/>
<link href="../css/controle.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Painel de controle</title>
</head>
<body>
<div id="painel">
		<form>
		<table class="tableControle">
		<tr>
			<th colspan="3" align="center">Painel de controle </th>
		</tr>
		
		<tr>
			<td><label for="documentos">Meus documentos: </label></td>
			<td colspan="2"><select class="inputControle" name="documentos">
			<option selected>Selecione...</option>
			<option value="Script"> Script </option>
			</select>
			</td>
			
		</tr>
		<tr>
			<td><input type="button" class="buttonDocumento" value="Visualizar" name="Visualizar" alt="Verificar campos de cadastro desse documento"></td>
			<td><input type="button" class="buttonDocumento" value="Alterar" name="Alterar" alt="Alterar os campos de cadastro desse documento"></td>
			<td><input type="button" class="buttonDocumento" value="Deletar" name="Deletar" alt="Deletar o registro desse documento"></td>
		</tr>
		</table>
		</form>
		<!-- Novo formulário para mudança de senha -->
		<form>
		<table class="tableControle">
		<tr>
			<th colspan="3" align="center">Mudar Senha Atual </th>
		</tr>
		<tr>
			<td><label for="senhaAtual">Senha atual: </label></td>
			<td colspan="2"><input class="inputControle" type="password" name="senhaAtual" />
		</tr>
		<tr>
			<td><label for="senhaNova">Nova senha: </label></td>
			<td colspan="2"><input class="inputControle" type="password" name="senhaNova" />
		</tr>
		<tr>
			<td><label for="senhaConfirme">Confirme nova senha: </label></td>
			<td colspan="2"><input class="inputControle" type="password" name="senhaConfirme" />
		</tr>
		<tr>
			
			<td><input type="button" class="buttonDocumento" value="Mudar" name="Mudar" alt="Mudar a senha atual."></td>
			<td></td>
			<td></td>
		</tr>
		</table>
		</form>

	
</div>


</body>
</html>