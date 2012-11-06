<%@page import="webview.util.WebUtility"%>

<table class="tableForms">
	<tr>
		<td class="field">
			<input id="action" name="action" type="hidden" value="update"></input>
			<input id="pesquisa_num_APEP_SEQ" name="pesquisa_num_APEP_SEQ" type="hidden" value="<%= request.getAttribute("codDocumento") %>"></input>
			<input id="pesquisa_APEP_SEQ" name="pesquisa_APEP_SEQ" type="hidden" value="<%= request.getAttribute("tipoCodDocumento") %>"></input>
		</td>
	</tr>

	<tr>
		<td class="tdForms">
			<label id="lidentificacao" class="labelForms" for="identificacao">C�dice/Caixa</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<select id="identificacao" class="inputLong" name="identificacao">
				<%=WebUtility.printSelectTituloCodiceCaixa(request, false)%>
			</select>
		</td>
		<td class="status"></td>
	</tr>
	
	<tr>
		<td class="tdForms"><label class="labelForms" id="lnumero" for="numero">N�mero APEP ou Sequencial</label></td>
	</tr>
	
	<tr>
		<td class="field">
			<select name="tipo_num" class="inputTipoNum" id="tipo_num">
				<option value=<%= request.getAttribute("tipoCodDocumento") %>><%= request.getAttribute("tipoCodDocumento") %></option>
				<option value="">--------</option>
				<option value="APEP">APEP</option>
				<option value="SEQ">Sequencial</option>
			</select>
			<input class="inputShort" name="numero" id="numero" type="text" maxlength="4" value=<%= request.getAttribute("codDocumento") %> />
		</td>
		<td class="status"></td>
	</tr>
	
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="ltituloDocumento" for="tituloDocumento">T�tulo do Documento</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<input class="input" name="tituloDocumento" id="tituloDocumento" type="text" size="20" maxlength="1024" value="<%=request.getAttribute("titulo") %>"/>
		</td>
		<td class="status"></td>
	</tr>
	
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="lautor" for="autor">Autor do Documento</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<input class="input" name="autor" id="autor" type="text" size="20" maxlength="1024" value="<%=request.getAttribute("autorNome") %>" />
		</td>
		<td class="status"></td>
	</tr>
	
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="lautorOcupacao" for="autorOcupacao">Ocupa��o do Autor do Documento</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<input class="input" name="autorOcupacao" id="autorOcupacao" type="text" size="20" maxlength="48" value="<%=request.getAttribute("autorOcupacao") %>" />
		</td>
		<td class="status"></td>
	</tr>
	
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="ldestinatario" for="destinatario">Destinat�rio do Documento</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<input class="input" name="destinatario" id="destinatario" type="text" size="20" maxlength="1024" value="<%=request.getAttribute("destinatarioNome") %>" />
		</td>
		<td class="status"></td>
	</tr>
	
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="ldestinatarioOcupacao" for="destinatarioOcupacao">Ocupa��o do Destinat�rio do Documento</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<input class="input" name="destinatarioOcupacao" id="destinatarioOcupacao" type="text" size="20" maxlength="48" value="<%=request.getAttribute("destinatarioOcupacao") %>" />
		</td>
		<td class="status"></td>
	</tr>
	
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="llocal" for="local">Local</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<input class="input" name="local" id="local" type="text" maxlength="1024" value="<%=request.getAttribute("local")%>"/>
		</td>
		<td class="status"></td>
	</tr>
	
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="ldata" for="data">Data do Documento</label>
		</td>
	</tr>
	
	<tr>
		<%@include file="/WEB-INF/templates/datesEdit.jsp"%>
		<td class="status"></td>
	</tr>
	
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="ltipoDoc" for="tipoDoc">Tipo do Documento</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<!-- Pegar do Banco de dados os tipos e, caso o usuario selecione outro, exibir campo para cadastrar outro tipo -->
			<select class="inputLong" name="tipoDoc" id="tipoDoc">
				<%=WebUtility.printSelectTipoDoc(request)%>
			</select>
		</td>
		<td class="status"></td>
	</tr>
	
	<tr>
		<td class="tdForms">
			<label class="labelForms">Resumo ou Verbete do Documento</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<textarea class="inputResumo" id="resumo" name="resumo" rows="7" cols="40" maxlength="2048"><%= request.getAttribute("resumo") %></textarea>
		</td>
		<td class="status"></td>
	</tr>
	
	<tr>
		<td class="tdForms">
			<label for="palavrasChaves" class="labelForms">Palavras-Chave</label>
		</td>
	</tr>
</table>
	
<table class="tableFormsKey">
	<tr>
		<td class="field"><label for="chave1" class="labelForms">A��o:</label></td>
		<td class="field"><label for="chave2" class="labelForms">Autores:</label></td>
		<td class="field"><label for="chave3" class="labelForms" >Institui��o:</label></td>
	</tr>
</table>

<table class="tableFormsKey">
	<tr>		
		<td class="field">
			<select class="inputKey" name="chave1" id="chave1">
				<option value="">Nenhuma</option>
				<%=WebUtility.printSelectKeyWords(request, "palavraChave1", "A��o")%>
			</select>
		
			<select class="inputKey" name="chave2" id="chave2">
				<option value="">Nenhuma</option>
				<%=WebUtility.printSelectKeyWords(request, "palavraChave2", "Autores")%>
			</select>		
		
			<select class="inputKey" name="chave3" id="chave3">
				<option value="">Nenhuma</option>
				<%=WebUtility.printSelectKeyWords(request, "palavraChave3", "Institui��o")%>
			</select>
		</td>
		<td class="status"></td>
	</tr>
	
	<!-- Reservado o campo para amazenar o link de imagem -->
	<tr>
		<td class="tdForms">
			<label class="labelForms" id="lurlImagem" for="urlImagem">URL da Imagem</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<input class="input" name="urlImagem" id="urlImagem" type="text" size="20" maxlength="1024" value="<%= request.getAttribute("url") %>"/>
		</td>
		<td class="status"></td>
	</tr>
	
	<tr>
		<td class="tdForms">
			<br>
			<input class="buttonRegistrar" id="signupsubmit" name="inserir" type="submit" value="Enviar" />
		</td>
	</tr>
</table>