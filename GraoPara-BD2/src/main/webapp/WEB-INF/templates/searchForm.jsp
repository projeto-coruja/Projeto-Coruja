<%@page import="webview.util.WebUtility"%>

<table class="tableForms">

	<!-- Códice/Caixa -->
	<tr>
		<td class="tdPesquisa">
			<label class="labelFormsSearch" id="lidentificacao" for="identificacao">&#8226 Códice/Caixa</label>
			<label Style="padding-left:10px;"><a class="tdMinilink" href="/GraoPara/listCodex" target="_blank">Lista de códices/caixas consultáveis</a></label>
		</td>
	</tr>

	<tr>
		<td class="field">
			<select name="tipoCodCodiceCaixa" class="inputLong" id="identificacao">
				<option selected value="">Selecione...</option>
				<option value="CODICE">Códice</option>
				<option value="CAIXA">Caixa</option>
			</select>
			<label></label><a href="#"><img style="padding-left:5px; position: absolute;" src="/GraoPara/images/icone_ajuda.png" title="Escolha a coleção de Códices ou Caixas do Arquivo Público do Pará." /></a>
		</td>				
	</tr>
	
	<!-- Intervalo do Código do Códice/Caixa -->
	<tr>
		<td class="tdPesquisa">
			<label class="labelFormsSearch" id="lcodigo" for="codigo">&#8226 Intervalo do Código do Códice/Caixa</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<label class="labelFormsSearch" id="ldata" for="data">De</label>
			<input class="inputAno" type="text" name="codDe" id="ano" maxlength="4" />
			<label class="labelFormsSearch" id="ldata" for="data">Até</label>
			<input class="inputAno" type="text" name="codAte" id="ano" maxlength="4" />
			<label></label><a href="#"><img class="iconeAjuda" src="/GraoPara/images/icone_ajuda.png"	title="Pode-se solicitar a pesquisa de uma sequência de Códices ou Caixas. Basta indicar o primeiro e o último desejado." /></a>
		</td>
		<td class="status"></td>
	</tr>

	<!-- Titulo do Códice/Caixa -->
	<tr>
		<td class="tdPesquisa">
			<label class="labelFormsSearch" id="lidentificacao" for="identificacao">&#8226 Titulo do Códice/Caixa</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<select name="tituloCodiceCaixa" class="inputLong" id="identificacao">
				<%=WebUtility.printSelectTituloCodiceCaixa(request)%>
			</select>
			<label></label><a href="#"><img style="padding-left:5px; position: absolute;" src="/GraoPara/images/icone_ajuda.png" title="Escolha a coleção de Códices ou Caixas do Arquivo Público do Pará." /></a>
		</td>
	</tr>

	<!-- Época (Caixa/Códice) -->
	<tr>
		<td class="tdPesquisa">
			<label class="labelFormsSearch" id="lcodigo" for="codigo">&#8226 Época (Caixa/Códice)</label>
		</td>
	</tr>
	
	<tr>
		<td class="field">
			<label class="labelFormsSearch" id="ldata" for="data">De</label>
			<input class="inputAno" type="text" name="epocaDe" id="ano" maxlength="4" />
			<label class="labelFormsSearch" id="ldata" for="data">Até</label>
			<input class="inputAno" type="text" name="epocaAte" id="ano" maxlength="4" />
			<label></label>
			<a href="#"><img class="iconeAjuda" src="/GraoPara/images/icone_ajuda.png"	title="Pode-se solicitar a pesquisa de uma sequência de Códices ou Caixas. Basta indicar o primeiro e o último desejado." /></a>
		</td>
		<td class="status"></td>
	</tr>

	<!-- Título do Documento -->
	<tr>
		<td class="tdPesquisa">
			<label class="labelFormsSearch" id="ltitulo" for="titulo">&#8226 Título do Documento</label>
		</td>
	</tr>

	<tr>
		<td class="field">
			<input class="input" name="titulo" id="titulo" type="text" size="20" maxlength="500">
			<label></label><a href="#"><img class="iconeAjuda" src="/GraoPara/images/icone_ajuda.png" title="Cada caixa ou códice tem um título, geralmente longo." /></a>
		</td>
	</tr>

	<!-- Tipo APEP ou Sequencial -->
	<tr>
		<td class="tdPesquisa">
			<label class="labelFormsSearch" id="lnumero" for="numero">&#8226 Tipo APEP ou Sequencial</label>
		</td>
	</tr>

	<tr>
		<td class="field">
			<select name="tipoDaIdentificacao" class="inputLong" id="identificacao">
				<option selected value="">Selecione...</option>
				<option value="APEP">APEP</option>
				<option value="SEQ">Sequencial</option>
			</select>
			<label></label><a href="#"><img style="padding-left:5px; position: absolute;" src="/GraoPara/images/icone_ajuda.png" title="O Número APEP é aquele atribuído pelo arquivista do APEP para cada um dos documentos do Códice ou Caixa. Caso não tenha sido atribuído um número pelo arquivista, o projeto designou um que chamou de sequencial." /></a>
		</td>
	</tr>
	
	
	<!-- Número da Identificação -->
	<tr>
		<td class="tdPesquisa"><label class="labelFormsSearch" id="lnumero" for="numero">&#8226 Número da Identificação</label></td>
	<tr>

	<tr>
		<td class="field"><input class="input" type="text" name="numDaIdentificacao" id="ano" maxlength="10" />
		<label></label><a href="#"><img class="iconeAjuda" src="/GraoPara/images/icone_ajuda.png" title="O Número APEP é aquele atribuído pelo arquivista do APEP para cada um dos documentos do Códice ou Caixa. Caso não tenha sido atribuído um número pelo arquivista, o projeto designou um que chamou de sequencial." /></a>
		</td>
	</tr>

	<!-- Autor do Documento -->
	<tr>
		<td class="tdPesquisa"><label class="labelFormsSearch" id="lautor" for="autor">&#8226 Autor do Documento</label></td>
	<tr>
	
	<tr>
		<td class="field"><input class="input" name="autor" id="autor" type="text" size="20" maxlength="48">
		<label></label><a href="#"><img class="iconeAjuda" src="/GraoPara/images/icone_ajuda.png" title="Busca pelo nome completo ou parte do autor do documento." /></a>
		</td>
	</tr>

	<!-- Ocupação do Autor do Documento -->
	<tr>
		<td class="tdPesquisa"><label class="labelFormsSearch" id="lautorOcupacao" for="autorOcupacao">&#8226 Ocupação do Autor do Documento</label></td>
	<tr>	
		
	<tr>
		<td class="field"><input class="input" name="autorOcupacao" id="autorOcupacao" type="text" size="20" maxlength="48">
		<label></label><a href="#"><img class="iconeAjuda" src="/GraoPara/images/icone_ajuda.png" title="Ocupação do autor do documento. Por exemplo, Presidente da Província." /></a>
		</td>
	</tr>
	
	<!-- Destinatário do Documento -->					
	<tr>
		<td class="tdPesquisa"><label class="labelFormsSearch" id="ldestinatario" for="destinatario">&#8226 Destinatário do Documento</label></td>
	<tr>	
		
	<tr>	
		<td class="field"><input class="input" name="destinatario" id="destinatario" type="text" size="20" maxlength="48">
		<label></label><a href="#"><img class="iconeAjuda" src="/GraoPara/images/icone_ajuda.png" title="Busca pelo nome completo ou parte do destinatário do Documento." /></a>
		</td>
	</tr>
	
	<!-- Ocupação do Destinatário do Documento -->
	<tr>
		<td class="tdPesquisa"><label class="labelFormsSearch" id="lautorOcupacao" for="autorOcupacao">&#8226 Ocupação do Destinatário do Documento</label></td>
	<tr>	
		
	<tr>	
		<td class="field"><input class="input" name="destinatarioOcupacao" id="autorOcupacao" type="text" size="20" maxlength="48">
		<label></label><a href="#"><img class="iconeAjuda" src="/GraoPara/images/icone_ajuda.png" title="Ocupação do destinatário do documento. Por exemplo, Presidente da Província." /></a>
		</td>
	</tr>
	
	<!-- Local -->	
	<tr>
		<td class="tdPesquisa"><label class="labelFormsSearch" id="llocal" for="local">&#8226 Local</label></td>
	<tr>	
		
	<tr>	
		<td class="field"><input class="input" name="local" id="local" type="text" maxlength="48">
		<label></label><a href="#"><img class="iconeAjuda" src="/GraoPara/images/icone_ajuda.png" title="Trata-se do local em que foi escrito o documento, normalmente a cidade. Por exemplo, Belém." /></a>
		</td>
	</tr>
	
	<!-- Ano -->
	<tr>
		<td class="tdPesquisa"><label class="labelFormsSearch" id="ldata" for="data">&#8226 Ano</label></td>
	<tr>	
		
	<tr>	
		<td class="field">
			<label class="labelFormsSearch" id="ldata" for="data">De</label>
			<input class="inputAno" type="text" name="anoIni" id="ano" maxlength="4" />
			<label class="labelFormsSearch" id="ldata" for="data">Até</label>
			<input class="inputAno" type="text" name="anoFim" id="ano" maxlength="4" />
		<label></label><a href="#"><img class="iconeAjuda" src="/GraoPara/images/icone_ajuda.png" title="Informe um período para filtrar a pesquisa." /></a>
		</td>
	</tr>
	
	<!-- Tipo do Documento -->
	<tr>
		<td class="tdPesquisa"><label class="labelFormsSearch" id="ltipoDoc" for="tipoDoc">&#8226 Tipo do Documento</label></td>
	<tr>	
		
	<tr>	
		<td class="field">
			<select class="inputLong" name="tipoDoc" id="tipoDoc">
				<!-- Pegar do Banco de dados os tipos e, caso o usuario selecione outro, exibir campo para cadastrar outro tipo -->
				<%=WebUtility.printSelectTipoDoc(request) %>
			</select>
		<label></label><a href="#"><img style="padding-left:5px; position: absolute;" src="/GraoPara/images/icone_ajuda.png" title="Selecione um dos tipos de documentos para filtrar resultados." /></a>
		</td>
	</tr>
	
	<!-- Resumo ou Verbete do Documento -->
	<tr>
		<td colspan="3"><label class="labelFormsSearch">&#8226 Resumo ou Verbete do Documento</label></td>
	</tr>
	
	<tr>						
		<td class="field" colspan="2"><textarea class="inputResumo" id="resumo" name="resumo" rows="7" cols="40" maxlength="2048"></textarea></td>
	</tr>
	
	<!-- Palavras-Chave -->			
	<tr>
		<td class="tdForms">
			<label for="palavrasChaves" class="labelForms">&#8226 Palavras-Chave</label>
		</td>
	</tr>
</table>

<table class="tableFormsKey">
	<tr>
		<td class="field"><label for="chave1" class="labelForms">Ação:</label></td>
		<td class="field"><label for="chave2" class="labelForms">Autores:</label></td>
		<td class="field"><label for="chave3" class="labelForms" >Instituição:</label></td>
	</tr>
</table>

<table class="tableFormsKey">
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
			<label></label><a href="#"><img style="padding-left:5px; position: absolute;" src="/GraoPara/images/icone_ajuda.png" title="Informe de uma a três palavras chaves para filtrar sua pesquisa."/></a>
		</td>
	</tr>
	
	<tr>
		<td>
			<br>
			<input class="buttonRegistrar" name="inserir" type="submit" value="Pesquisar" id="signupsubmit" />
			<label style="padding-left: 30px;"></label>
			<input class="buttonLimpar" name="limpar" type="reset" value="Limpar" title="Limpar todos os campos preenchidos."/>
		</td>
	</tr>
</table>
