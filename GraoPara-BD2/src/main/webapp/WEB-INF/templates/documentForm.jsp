<%@page import="webview.util.WebUtility"%>

<tr>
	<td class="tdForms"><label class="labelForms" id="lidentificacao" for="identificacao">Códice/Caixa </label></td>
</tr>

<tr>
	<td class="field"><select name="identificacao" class="inputLong" id="identificacao"><%=WebUtility.printSelectTituloCodiceCaixa(request, false)%></select></td>
	<td class="status"></td>
</tr>

<tr>
	<td class="tdForms"><label class="labelForms" id="lanoInicioCodiceCaixa" for="anoInicioCodiceCaixa">Ano Inicial do Códice/Caixa </label></td>
</tr>

<tr>
	<td class="field"><input class="input" name="anoInicioCodiceCaixa" id="anoInicioCodiceCaixa" type="text" size="20" maxlength="4"></td>
	<td class="status"></td>
</tr>

<tr>
	<td class="tdForms"><label class="labelForms" id="lanoFimCodiceCaixa" for="anoFimCodiceCaixa">Ano Final do Códice/Caixa </label></td>
</tr>
	
<tr>
	<td class="field"><input class="input" name="anoFimCodiceCaixa" id="anoFimCodiceCaixa" type="text" size="20" maxlength="4"></td>
	<td class="status"></td>
</tr>

<tr>
	<td class="tdForms"><label class="labelForms" id="lnumero" for="numero">Número APEP ou Sequencial </label></td>
</tr>

<tr>
	<td class="field">
		<select name="tipo_num" class="inputTipoNum" id="tipo_num">
			<option value="" selected>Selecione...</option>
			<option value="APEP">APEP</option>
			<option value="SEQ">Sequencial</option>
		</select>
		<input class="inputShort" name="numero" id="numero" type="text" maxlength="4">
	</td>
	<td class="status"></td>
</tr>

<tr>
	<td class="tdForms"><label class="labelForms" id="ltituloDocumento" for="tituloDocumento">Título do Documento </label></td>
</tr>

<tr>
	<td class="field"><input class="input" name="tituloDocumento" id="tituloDocumento" type="text" size="20" maxlength="1024"></td>
	<td class="status"></td>
</tr>

<tr>
	<td class="tdForms"><label class="labelForms" id="lautor" for="autor">Autor do Documento </label></td>
</tr>

<tr>
	<td class="field"><input class="input" name="autor" id="autor" type="text" size="20" maxlength="1024"></td>
	<td class="status"></td>
</tr>

<tr>
	<td class="tdPesquisa"><label class="labelForms" id="lautorOcupacao" for="autorOcupacao">Ocupação do Autor do Documento </label></td>
</tr>

<tr>
	<td class="field"><input class="input" name="autorOcupacao" id="autorOcupacao" type="text" size="20" maxlength="48"></td>
	<td class="status"></td>
</tr>

<tr>
	<td class="tdForms"><label class="labelForms" id="ldestinatario" for="destinatario">Destinatário do Documento </label></td>
</tr>

<tr>
	<td class="field"><input class="input" name="destinatario" id="destinatario" type="text" size="20" maxlength="1024"></td>
	<td class="status"></td>
</tr>

<tr>
	<td class="tdPesquisa"><label class="labelForms" id="lautorOcupacao" for="autorOcupacao">Ocupação do Destinatário do Documento </label></td>
</tr>
	
<tr>
	<td class="field"><input class="input" name="destinatarioOcupacao" id="autorOcupacao" type="text" size="20" maxlength="48"></td>
	<td class="status"></td>
</tr>

<tr>
	<td class="tdForms"><label class="labelForms" id="llocal" for="local">Local </label></td>
</tr>

<tr>
	<td class="field"><input class="input" name="local" id="local" type="text" maxlength="1024"></td>
	<td class="status"></td>
</tr>

<!-- Reservado o campo para amazenar o link de imagem -->
<!-- <tr>
	<td class="tdForms"><label class="labelForms" id="lurlImagem" for="urlImagem">URL da Imagem</label></td>
</tr>
	
<tr>
	<td class="field"><input class="input" name="urlImagem" id="urlImagem" type="text" size="20" maxlength="1024"></td>
	<td class="status"></td>
</tr> -->

<tr>
	<td class="tdForms"><label class="labelForms" id="ldata" for="data">Data do Documento</label></td>
</tr>

<tr>
	<%@include file="/WEB-INF/templates/datesCadastre.jsp" %>
	<td class="status"></td>
</tr>

<tr>
	<td class="tdForms"><label class="labelForms" id="ltipoDoc" for="tipoDoc">Tipo do Documento </label></td>
</tr>

<tr>
	<td class="field">
		<!-- Pegar do Banco de dados os tipos e, caso o usuario selecione outro, exibir campo para cadastrar outro tipo -->
		<select class="input" name="tipoDoc" id="tipoDoc">
			<%= WebUtility.printSelectTipoDoc(request) %>
		</select>
	</td>
	<td class="status"></td>
</tr>

<tr>
	<td class="tdForms"><label class="labelForms" id="ldescricaoTipoDocumento" for="descricaoTipoDocumento">Descrição do Tipo de Documento </label></td>
</tr>

<tr>
	<td class="field"><input class="input" name="descricaoTipoDocumento" id="descricaoTipoDocumento" type="text" size="20" maxlength="1024"></td>
	<td class="status"></td>
</tr>

<tr>
	<td colspan="3"><label class="labelForms">Resumo ou Veberbete do Documento </label></td>
</tr>

<tr>
	<td class="field"><textarea class="inputResumo" id="resumo" name="resumo" rows="7" cols="40" maxlength="2048"></textarea></td>
	<td class="status"></td>
</tr>

<tr>
	<td colspan="3"><label for="palavrasChaves" class="labelForms">Palavras-Chave (Obrigatório Pelo Menos Uma)</label></td>
</tr>

<tr>
	<td class="field">
		 <select class="input" name="chave1" id="chave1" style="width: 120px">
			<option value = "">Nenhuma</option>
			<%= WebUtility.printSelectKeyWords(request, "chave1") %>
		</select>

		<select class="input" name="chave2" id="chave2" style="width: 120px">
			<option value = "">Nenhuma</option>
			<%= WebUtility.printSelectKeyWords(request, "chave2") %>
		</select>

		<select  class="input" name="chave3" id="chave3" style="width: 120px">
			<option value = "">Nenhuma</option>
			<%= WebUtility.printSelectKeyWords(request, "chave3") %>
		</select>
	</td>
	<td class="status"></td>
</tr>