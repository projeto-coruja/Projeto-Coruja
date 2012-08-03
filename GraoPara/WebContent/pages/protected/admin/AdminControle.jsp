<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<link href="/GraoParaWEB/faces/pages/css/principal.css" rel="stylesheet" type="text/css"/>
<link href="/GraoParaWEB/faces/pages/css/tabs.css" rel="stylesheet" type="text/css"/>
<link href="/GraoParaWEB/faces/pages/css/controle.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Painel de controle</title>
</head>
<body>
<div id="painel">
		<form class="control" >
		<table class="tableControle">
		<tr>
			<th colspan="3" align="center"> Painel de controle </th>
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
		<form class="control" >
		<table class="tableControle">
		<tr>
			<th colspan="3" align="center"> Mudar Senha Atual </th>
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
		<!-- Novo formulário para novos usuários -->
	
		<br>
		<!-- <div id="wrapper">
			<div id="tabContainer">
				<div class="tabs">
					<ul>
						<li id="tabHeader_1">Novos Usuários</li>
						<li id="tabHeader_2">Usuários Cadastrados</li>
						<li id="tabHeader_3">Palavras-Chaves Pendentes</li>
						<li id="tabHeader_4">Palavras-Chaves</li>
					</ul>
				</div>
				<div class="tabscontent">
					<div class="tabpage" id="tabpage_1">
						<h2>Novos Usuários</h2>
						<p>Novos usuários</p>
					</div>
					<div class="tabpage" id="tabpage_2">
						<h2>Usuários Cadastrados</h2>
						<p>Lista</p>
					</div>
					<div class="tabpage" id="tabpage_3">
						<h2>Palavras-Chaves Pendentes</h2>
						<p>Lista Palavras Pendentes</p>
					</div>
					<div class="tabpage" id="tabpage_4">
						<h2>Palavras-Chaves</h2>
						<p>Lista Palavras</p>
					</div>
				</div>
			</div>
		</div>  -->
		<article class="tabsCSS">  
    		<section id="tab1">  
        		<h2><a href="#tab1">Palavras-Chaves Pendentes</a></h2>  
        		<br>
        		<p>This content appears on tab 1.</p>  
   			</section>  
    		<section id="tab2">  
        		<h2><a href="#tab2">Novos Usuários</a></h2>  
        		<br>
        		<p>This content appears on tab 2.</p>  
    		</section>  
    		<section id="tab3">  
        		<h2><a href="#tab3">Usuários</a></h2>  
        		<br>
        		<p>This content appears on tab 3.</p>  
    		</section>
    		<section id="tab4">  
        		<h2><a href="#tab4">Palavras-Chaves</a></h2>  
        		<br>
        		<p>This content appears on tab 4.</p>  
    		</section>  
		</article>  
	</div>
	<script type="text/javascript" src="../../javascript/tabs.js"></script>
	<script type="text/javascript" src="../javascript/tabs.js"></script>
</body>
</html>