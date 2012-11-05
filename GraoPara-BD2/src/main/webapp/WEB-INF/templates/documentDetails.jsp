<%@page import="webview.util.WebUtility"%>

<table class="tableForms">

	<tr>
		<td class="tdForms"><label class="labelForms" id="lidentificacao"
			for="identificacao">Códice/Caixa </label></td>
	</tr>
	
	<tr>
		<td class="field"><input class="input" name="identificacao"
			id="identificacao" type="text" size="20" maxlength="1024"
			readonly="readonly" value="<%= request.getAttribute("codCodiceCaixa") %>"></td>
		<td class="status"></td>
	</tr>
	
	<tr>
		<td class="tdForms"><label class="labelForms" id="lnumero"
			for="numero">Número APEP ou Sequencial </label></td>
	</tr>
	
	<tr>
		<td class="field"><input class="input" name="numero"
			id="numero" type="text" size="20" maxlength="1024"
			readonly="readonly" value="<%= request.getAttribute("codDocumento") %>"></td>
		<td class="status"></td>
	</tr>
	
	<tr>
		<td class="tdForms"><label class="labelForms"
			id="ltituloDocumento" for="tituloDocumento">Título do
				Documento </label></td>
	</tr>
	
	<tr>
		<td class="field"><input class="input" name="tituloDocumento"
			id="tituloDocumento" type="text" size="20" maxlength="1024"
			readonly="readonly" value="<%= request.getAttribute("titulo") %>"></td>
		<td class="status"></td>
	</tr>
	
	<tr>
		<td class="tdForms"><label class="labelForms" id="lautor"
			for="autor">Autor do Documento </label></td>
	</tr>
	
	<tr>
		<td class="field"><input class="input" name="autor" id="autor"
			type="text" size="20" maxlength="1024"
			readonly="readonly" value="<%= request.getAttribute("autorNome") %>"></td>
		<td class="status"></td>
	</tr>
	
	<tr>
		<td class="tdPesquisa"><label class="labelForms"
			id="lautorOcupacao" for="autorOcupacao">Ocupação do Autor do
				Documento </label></td>
	</tr>
	
	<tr>
		<td class="field"><input class="input" name="autorOcupacao"
			id="autorOcupacao" type="text" size="20" maxlength="48"
			readonly="readonly" value="<%= request.getAttribute("autorOcupacao") %>"></td>
		<td class="status"></td>
	</tr>
	
	<tr>
		<td class="tdForms"><label class="labelForms" id="ldestinatario"
			for="destinatario">Destinatário do Documento </label></td>
	</tr>
	
	<tr>
		<td class="field"><input class="input" name="destinatario"
			id="destinatario" type="text" size="20" maxlength="1024"
			readonly="readonly" value="<%= request.getAttribute("destinatarioNome") %>"></td>
		<td class="status"></td>
	</tr>
	
	<tr>
		<td class="tdPesquisa"><label class="labelForms"
			id="ldestinatarioOcupacao" for="destinatarioOcupacao">Ocupação
				do Destinatário do Documento </label></td>
	</tr>
	
	<tr>
		<td class="field"><input class="input" name="destinatarioOcupacao"
			id="destinatarioOcupacao" type="text" size="20" maxlength="48"
			readonly="readonly" value="<%= request.getAttribute("destinatarioOcupacao") %>"></td>
		<td class="status"></td>
	</tr>
	
	<tr>
		<td class="tdForms"><label class="labelForms" id="llocal"
			for="local">Local </label></td>
	</tr>
	
	<tr>
		<td class="field"><input class="input" name="local" id="local"
			type="text" maxlength="1024"
			readonly="readonly" value="<%= request.getAttribute("local") %>"></td>
		<td class="status"></td>
	</tr>
	
	<tr>
		<td class="tdForms"><label class="labelForms" id="ldata"
			for="data">Data do Documento</label></td>
	</tr>
	
	<tr>
		<td class="field"><input class="input"
			name="data" id="data" type="text"
			size="20" maxlength="1024"
			readonly="readonly" value="<%= request.getAttribute("data") %>"></td>
		<td class="status"></td>
	</tr>
	
	<tr>
		<td class="tdForms"><label class="labelForms" id="ltipoDoc"
			for="tipoDoc">Tipo do Documento </label></td>
	</tr>
	
	<tr>
		<td class="field"><input class="input"
			name="tipoDoc" id="tipoDoc" type="text"
			size="20" maxlength="1024"
			readonly="readonly" value="<%= request.getAttribute("tipoDocumento") %>"></td>
		<td class="status"></td>
	</tr>
	
	<tr>
		<td colspan="3"><label class="labelForms">Resumo ou
				Veberbete do Documento </label></td>
	</tr>
	
	<tr>
		<td class="field"><textarea class="inputResumo" id="resumo"
			name="resumo" rows="7" cols="40" maxlength="2048"
			readonly="readonly"><%= request.getAttribute("resumo") %></textarea></td>
		<td class="status"></td>
	</tr>
	
	<tr>
		<td class="tdForms">
			<label for="palavrasChaves" class="labelForms">Palavras-Chave</label>
		</td>
	</tr>	

	<tr>
		<td class="field"><label for="chave1" class="labelForms">Ação:</label></td>
		<td class="field"><label for="chave2" class="labelForms">Autores:</label></td>
		<td class="field"><label for="chave3" class="labelForms" >Instituição:</label></td>
	</tr>	

	<tr>
		<td class="field" >
			<input class="inputKey" name="palavraChave1" id="palavraChave1" type="text" maxlength="1024" readonly="readonly" value="<%= request.getAttribute("palavraChave1") %>">
			<input class="inputKey" name="palavraChave2" id="palavraChave2" type="text" maxlength="1024" readonly="readonly" value="<%= request.getAttribute("palavraChave2") %>">
			<input class="inputKey" name="palavraChave3" id="palavraChave3" type="text" maxlength="1024" readonly="readonly" value="<%= request.getAttribute("palavraChave3") %>">
		</td>
	</tr>
	
	<!-- Reservado o campo para amazenar o link de imagem -->
	<tr>
		<td class="tdForms"><label class="labelForms" id="lurlImagem"
			for="urlImagem">URL da Imagem</label></td>
	</tr>
	
	<tr>
		<td class="field"><input class="input" name="urlImagem"
			id="urlImagem" type="text" size="20" maxlength="1024"
			readonly="readonly" value="<%= request.getAttribute("url") %>"></td>
		<td class="status"></td>
	</tr>
</table>