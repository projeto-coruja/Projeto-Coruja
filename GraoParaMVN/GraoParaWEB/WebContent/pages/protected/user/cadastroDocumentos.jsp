<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" charset="utf-8">
<title>Projeto Grão-Pará</title>

<link href="../../css/principal.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="../jscripts/tiny_mce/tiny_mce.js"></script>
<script type="text/javascript">

//Formatanto a data:
function Formatadata(Campo, teclapres)
{
	var tecla = teclapres.keyCode;
	var vr = new String(Campo.value);
	vr = vr.replace("/", "");
	vr = vr.replace("/", "");
	vr = vr.replace("/", "");
	tam = vr.length + 1;
	if (tecla != 8 && tecla != 8)
	{
		if (tam > 0 && tam < 2)
			Campo.value = vr.substr(0, 2) ;
		if (tam > 2 && tam < 4)
			Campo.value = vr.substr(0, 2) + '/' + vr.substr(2, 2);
		if (tam > 4 && tam < 7)
			Campo.value = vr.substr(0, 2) + '/' + vr.substr(2, 2) + '/' + vr.substr(4, 7);
	}
}
	// O2k7 skin (silver)
	tinyMCE.init({
		// General options
		mode : "exact",
		elements : "resumo",
		theme : "advanced",
		skin : "o2k7",
		skin_variant : "black",
		plugins : "lists,pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template,inlinepopups,autosave",

		// Theme options
		theme_advanced_buttons1 : "save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,styleselect,formatselect,fontselect,fontsizeselect",
		theme_advanced_buttons2 : "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
		theme_advanced_buttons3 : "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen",
		theme_advanced_buttons4 : "insertlayer,moveforward,movebackward,absolute,|,styleprops,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,pagebreak,restoredraft",
		theme_advanced_toolbar_location : "top",
		theme_advanced_toolbar_align : "left",
		theme_advanced_statusbar_location : "bottom",
		theme_advanced_resizing : true,

		// Example content CSS (should be your site CSS)
		content_css : "css/content.css",

		// Drop lists for link/image/media/template dialogs
		template_external_list_url : "lists/template_list.js",
		external_link_list_url : "lists/link_list.js",
		external_image_list_url : "lists/image_list.js",
		media_external_list_url : "lists/media_list.js",

		// Replace values for the template plugin
		template_replace_values : {
			username : "Some User",
			staffid : "991234"
		}
	});
</script>

</head>
<body>
	
<h2>Cadastro de Documentos</h2>
	<form action="#" method="POST" name="cadastro" onSubmit="return valida();">
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
				 	<select name="identificacao" class="input" required>
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
						<input class="input" name="codigo" type="text" size="10" maxlength="5" required>
                        <label for="maxDigitos" class="labelForms">(máx. 5 digitos)</label>
				</td>
			</tr>
			<tr>
				<td height="20">
					<label for="nomeDocumento" class="labelForms">Nome do Documento:<font color="#FF0000">*</font></label>
				</td>
				<td width="377" height="20">
						<input class="input" name="nome" type="text" size="20" maxlength="100" required>
                        <label for="maxDigitos" class="labelForms">(máx.100 digitos)</label> 
				</td>
			</tr>
			<tr>
				<td height="20">
					<label for="numeroAPEP" class="labelForms">Número APEP ou Sequencial:<font color="#FF0000">*</font></label>
				</td>
				<td width="377" height="20">
						<input class="input" name="numero" type="text" size="10" maxlength="4" required>
                        <label for="maxDigitos" class="labelForms">(máx. 4 digitos)</label>
				</td>
			</tr>
			<tr>
				<td height="20">
					<label for="autor" class="labelForms">Autor do Documento:<font color="#FF0000">*</font></label>
				</td>
				<td width="377" height="20">
				 		<input class="input" name="autor" type="text" size="20" maxlength="100" required>
                        <label for="maxDigitos" class="labelForms">(máx. 100 digitos)</label>
				</td>
			</tr>
			<tr>
				<td height="20">
					<label for="destinario" class="labelForms">Destinatário do Documento:<font color="#FF0000">*</font></label>
				</td>
				<td width="377" height="20">
				     
				    	<input class="input" name="destinatario" type="text" size="20" maxlength="100" required>
                        <label for="maxDigitos" class="labelForms">(máx. 100 digitos)</label>
				</td>
			</tr>
			<tr>
				<td height="20">
					<label for="estado" class="labelForms">Estado:<font color="#FF0000">*</font></label>
                
				</td>
                <td>
                    <select class="inputEstado" name="estado" id="estado" required>
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
                <input class="input" name="cidade" type="text" size="15" maxlength="8" required>
                </td>
            </tr>
			<tr>
				<td height="20">
					<label for="dataDocumento" class="labelForms">Data do Documento:<font color="#FF0000">*</font></label>
				</td>
				<td height="20">
					<input placeholder="xx-xx-xxxx" class="input" type="date" name="data" maxlength="10" required /> <!--  onkeyup="Formatadata(this,event)" -->
				</td>
			</tr>
			<tr>
				<td height="20">
					<label for="dataDocumento" class="labelForms">Tipo do Documento:<font color="#FF0000">*</font></label>
				</td>
				<td height="20">
				 	<select class="input" name="tipoDoc" required> <!-- Pegar do Banco de dados os tipos e, caso o usuÃ¡rio selecione outro, exibir campo para cadastrar outro tipo -->
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
					<textarea class="inputResumo" id="resumo" name="resumo" rows="7" cols="40" maxlength="1000"></textarea>
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
						<input class="inputPalavraChave" name="chave1" type="text" size="15" maxlength="30" required> - 
						<input class="inputPalavraChave" name="chave2" type="text" size="15" maxlength="30"> - 
						<input class="inputPalavraChave" name="chave3" type="text" size="15" maxlength="30"> 
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