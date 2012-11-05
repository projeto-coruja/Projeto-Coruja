<%@page import="webview.util.WebUtility"%>
<table class="tableForms">
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="lidentificacao" for="identificacao">Códice/Caixa</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<input class="input" name="identificacao" id="identificacao" type="text" size="20" maxlength="1024" readonly="readonly" value="<%= request.getAttribute("codCodiceCaixa") %>">
		</td>
	</tr>
	
	<tr>
		<td class="tdForms"><label class="labelForms" id="lnumero" for="numero">Número APEP ou Sequencial</label></td>
	</tr>
	
	<tr>
		<td class="field">
			<input class="input" name="numero" id="numero" type="text" size="20" maxlength="1024" readonly="readonly" value="<%= request.getAttribute("codDocumento") %>">
		</td>
	</tr>
	
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="ltituloDocumento" for="tituloDocumento">Título do Documento</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<input class="input" name="tituloDocumento" id="tituloDocumento" type="text" size="20" maxlength="1024" readonly="readonly" value="<%= request.getAttribute("titulo") %>">
		</td>
	</tr>
	
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="lautor" for="autor">Autor do Documento</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<input class="input" name="autor" id="autor" type="text" size="20" maxlength="1024" readonly="readonly" value="<%= request.getAttribute("autorNome") %>">
		</td>
	</tr>
	
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="lautorOcupacao" for="autorOcupacao">Ocupação do Autor do Documento</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<input class="input" name="autorOcupacao" id="autorOcupacao" type="text" size="20" maxlength="48" readonly="readonly" value="<%= request.getAttribute("autorOcupacao") %>">
		</td>
	</tr>
	
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="ldestinatario" for="destinatario">Destinatário do Documento</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<input class="input" name="destinatario" id="destinatario" type="text" size="20" maxlength="1024" readonly="readonly" value="<%= request.getAttribute("destinatarioNome") %>">
		</td>
	</tr>
	
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="ldestinatarioOcupacao" for="destinatarioOcupacao">Ocupação do Destinatário do Documento</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<input class="input" name="destinatarioOcupacao" id="destinatarioOcupacao" type="text" size="20" maxlength="48" readonly="readonly" value="<%= request.getAttribute("destinatarioOcupacao") %>">
		</td>
	</tr>
	
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="llocal" for="local">Local</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<input class="input" name="local" id="local" type="text" maxlength="1024" readonly="readonly" value="<%= request.getAttribute("local") %>">
		</td>
	</tr>
	
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="ldata" for="data">Data do Documento</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<input class="input" name="data" id="data" type="text" size="20" maxlength="1024" readonly="readonly" value="<%= request.getAttribute("data") %>">
		</td>
	</tr>
	
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="ltipoDoc" for="tipoDoc">Tipo do Documento</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<input class="input" name="tipoDoc" id="tipoDoc" type="text" size="20" maxlength="1024" readonly="readonly" value="<%= request.getAttribute("tipoDocumento") %>">
		</td>
	</tr>
	
	<tr>
		<td class="tdForms">
			<label class="labelForms">Resumo ou Veberbete do Documento</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<textarea class="inputResumo" id="resumo" name="resumo" rows="7" cols="40" maxlength="2048" readonly="readonly"><%= request.getAttribute("resumo") %></textarea>
		</td>
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
		<td class="field">
			<select class="inputKey" name="chave1" id="chave1">
				<option value="">Nenhuma</option>
				<%=WebUtility.printSelectKeyWords(request, "chave1", "Ação")%>
			</select>
		
			<select class="inputKey" name="chave2" id="chave2">
				<option value="">Nenhuma</option>
				<%=WebUtility.printSelectKeyWords(request, "chave2", "Autores")%>
			</select>		
		
			<select class="inputKey" name="chave3" id="chave3">
				<option value="">Nenhuma</option>
				<%=WebUtility.printSelectKeyWords(request, "chave3", "Instituição")%>
			</select>
		</td>
	</tr>
	
	<!-- Reservado o campo para amazenar o link de imagem -->
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="lurlImagem" for="urlImagem">URL da Imagem</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<input class="input" name="urlImagem" id="urlImagem" type="text" size="20" maxlength="1024" readonly="readonly" value="<%= request.getAttribute("url")%>">
		</td>
	</tr>
	
	<tr>
		<td class="tdControle" colspan="3">
			<input class="buttonCancelar" type="button" value="Cancelar" onClick="history.go(-1)" />
			<input class="buttonRegistrar" id="signupsubmit" name="Atualizar" type="submit" value="Atualizar" />
		</td>
	</tr>
</table>	