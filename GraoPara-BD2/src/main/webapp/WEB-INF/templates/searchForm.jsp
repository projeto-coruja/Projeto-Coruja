<%@page import="webview.util.WebUtility"%>

<div class="content" id="content">
	<h1>Pesquisa de Documento <label style="font-size: x-small; color: black; padding-left: 10px;">(Os campos s�o opcionais.)</label></h1>
	

	<form action="/GraoPara/public/listagemDocumentos.jsp" id="signupform" method="get" name="cadastro">
		<table class="tableForms"">
			<!-- <tr>
				<td colspan="3">
					<label class="labelForms">
						<strong>PREENCHA UM OU MAIS CAMPOS A SEGUIR:</strong>
					</label>
				</td>
			</tr> -->

			<!-- C�dice/Caixa -->
			<tr>
				<td class="tdPesquisa">
					<label class="labelFormsSearch" id="lidentificacao" for="identificacao">&#8226 C�dice/Caixa</label>
					<label Style="padding-left:10px;"><a class="tdMinilink" href="/GraoPara/listCodex" target="_blank">Lista de c�dices/caixas consult�veis</a></label>
				</td>
			</tr>

			<tr>
				<td class="field">
					<select name="tipoCodCodiceCaixa" class="input" id="identificacao">
						<option selected value="">Selecione...</option>
						<option value="CODICE">C�dice</option>
						<option value="CAIXA">Caixa</option>
					</select>
					<label></label><a href="#"><img class="iconeAjuda" style="padding-left:9px;" src="/GraoPara/images/icone_ajuda.png" title="Escolha a cole��o de C�dices ou Caixas do Arquivo P�blico do Par�." /></a>
				</td>				
			</tr>
			
			<!-- Intervalo do C�digo do C�dice/Caixa -->
			<tr>
				<td class="tdPesquisa">
					<label class="labelFormsSearch" id="lcodigo" for="codigo">&#8226 Intervalo do C�digo do C�dice/Caixa</label>
				</td>
			</tr>
			
			<tr>
				<td class="field">
					<label class="labelFormsSearch" id="ldata" for="data">De</label>
					<input class="inputAno" type="text" name="codDe" id="ano" maxlength="4" />
					<label class="labelFormsSearch" id="ldata" for="data">At�</label>
					<input class="inputAno" type="text" name="codAte" id="ano" maxlength="4" />
					<label></label><a href="#"><img class="iconeAjuda" src="/GraoPara/images/icone_ajuda.png"	title="Pode-se solicitar a pesquisa de uma sequ�ncia de C�dices ou Caixas. Basta indicar o primeiro e o �ltimo desejado." /></a>
				</td>
				<td class="status"></td>
			</tr>

			<!-- Titulo do C�dice/Caixa -->
			<tr>
				<td class="tdPesquisa">
					<label class="labelFormsSearch" id="lidentificacao" for="identificacao">&#8226 Titulo do C�dice/Caixa</label>
				</td>
			</tr>
			
			<tr>
				<td class="field">
					<select name="tituloCodiceCaixa" class="input" id="identificacao">
						<%=WebUtility.printSelectTituloCodiceCaixa(request)%>
					</select>
					<label></label><a href="#"><img class="iconeAjuda" style="padding-left:9px;" src="/GraoPara/images/icone_ajuda.png" title="Escolha a cole��o de C�dices ou Caixas do Arquivo P�blico do Par�." /></a>
				</td>
			</tr>

			<!-- �poca (Caixa/C�dice) -->
			<tr>
				<td class="tdPesquisa">
					<label class="labelFormsSearch" id="lcodigo" for="codigo">&#8226 �poca (Caixa/C�dice)</label>
				</td>
			</tr>
			
			<tr>
				<td class="field">
					<label class="labelFormsSearch" id="ldata" for="data">De</label>
					<input class="inputAno" type="text" name="epocaDe" id="ano" maxlength="4" />
					<label class="labelFormsSearch" id="ldata" for="data">At�</label>
					<input class="inputAno" type="text" name="epocaAte" id="ano" maxlength="4" />
					<label></label>
					<a href="#"><img class="iconeAjuda" src="/GraoPara/images/icone_ajuda.png"	title="Pode-se solicitar a pesquisa de uma sequ�ncia de C�dices ou Caixas. Basta indicar o primeiro e o �ltimo desejado." /></a>
				</td>
				<td class="status"></td>
			</tr>

			<!-- T�tulo do Documento -->
			<tr>
				<td class="tdPesquisa">
					<label class="labelFormsSearch" id="ltitulo" for="titulo">&#8226 T�tulo do Documento</label>
				</td>
			</tr>

			<tr>
				<td class="field">
					<input class="input" name="titulo" id="titulo" type="text" size="20" maxlength="500">
					<label></label><a href="#"><img class="iconeAjuda" src="/GraoPara/images/icone_ajuda.png" title="Cada caixa ou c�dice tem um t�tulo, geralmente longo." /></a>
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
					<select name="tipoDaIdentificacao" class="input" id="identificacao">
						<option selected value="">Selecione...</option>
						<option value="APEP">APEP</option>
						<option value="SEQ">Sequencial</option>
					</select>
					<label></label><a href="#"><img class="iconeAjuda" style="padding-left:9px;" src="/GraoPara/images/icone_ajuda.png" title="O N�mero APEP � aquele atribu�do pelo arquivista do APEP para cada um dos documentos do C�dice ou Caixa. Caso n�o tenha sido atribu�do um n�mero pelo arquivista, o projeto designou um que chamou de sequencial." /></a>
				</td>
			</tr>
			
			
			<!-- N�mero da Identifica��o -->
			<tr>
				<td class="tdPesquisa"><label class="labelFormsSearch" id="lnumero" for="numero">&#8226 N�mero da Identifica��o</label></td>
			<tr>

			<tr>
				<td class="field"><input class="inputShort" type="text" name="numDaIdentificacao" id="ano" maxlength="10" />
				<label></label><a href="#"><img class="iconeAjuda" src="/GraoPara/images/icone_ajuda.png" title="O N�mero APEP � aquele atribu�do pelo arquivista do APEP para cada um dos documentos do C�dice ou Caixa. Caso n�o tenha sido atribu�do um n�mero pelo arquivista, o projeto designou um que chamou de sequencial." /></a>
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

			<!-- Ocupa��o do Autor do Documento -->
			<tr>
				<td class="tdPesquisa"><label class="labelFormsSearch" id="lautorOcupacao" for="autorOcupacao">&#8226 Ocupa��o do Autor do Documento</label></td>
			<tr>	
				
			<tr>
				<td class="field"><input class="input" name="autorOcupacao" id="autorOcupacao" type="text" size="20" maxlength="48">
				<label></label><a href="#"><img class="iconeAjuda" src="/GraoPara/images/icone_ajuda.png" title="Ocupa��o do autor do documento. Por exemplo, Presidente da Prov�ncia." /></a>
				</td>
			</tr>
			
			<!-- Destinat�rio do Documento -->					
			<tr>
				<td class="tdPesquisa"><label class="labelFormsSearch" id="ldestinatario" for="destinatario">&#8226 Destinat�rio do Documento</label></td>
			<tr>	
				
			<tr>	
				<td class="field"><input class="input" name="destinatario" id="destinatario" type="text" size="20" maxlength="48">
				<label></label><a href="#"><img class="iconeAjuda" src="/GraoPara/images/icone_ajuda.png" title="Busca pelo nome completo ou parte do destinat�rio do Documento." /></a>
				</td>
			</tr>
			
			<!-- Ocupa��o do Destinat�rio do Documento -->
			<tr>
				<td class="tdPesquisa"><label class="labelFormsSearch" id="lautorOcupacao" for="autorOcupacao">&#8226 Ocupa��o do Destinat�rio do Documento</label></td>
			<tr>	
				
			<tr>	
				<td class="field"><input class="input" name="destinatarioOcupacao" id="autorOcupacao" type="text" size="20" maxlength="48">
				<label></label><a href="#"><img class="iconeAjuda" src="/GraoPara/images/icone_ajuda.png" title="Ocupa��o do destinat�rio do documento. Por exemplo, Presidente da Prov�ncia." /></a>
				</td>
			</tr>
			
			<!-- Local -->	
			<tr>
				<td class="tdPesquisa"><label class="labelFormsSearch" id="llocal" for="local">&#8226 Local</label></td>
			<tr>	
				
			<tr>	
				<td class="field"><input class="input" name="local" id="local" type="text" maxlength="48">
				<label></label><a href="#"><img class="iconeAjuda" src="/GraoPara/images/icone_ajuda.png" title="Trata-se do local em que foi escrito o documento, normalmente a cidade. Por exemplo, Bel�m." /></a>
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
					<label class="labelFormsSearch" id="ldata" for="data">At�</label>
					<input class="inputAno" type="text" name="anoFim" id="ano" maxlength="4" />
				<label></label><a href="#"><img class="iconeAjuda" src="/GraoPara/images/icone_ajuda.png" title="Informe um per�odo para filtrar a pesquisa." /></a>
				</td>
			</tr>
			
			<!-- Tipo do Documento -->
			<tr>
				<td class="tdPesquisa"><label class="labelFormsSearch" id="ltipoDoc" for="tipoDoc">&#8226 Tipo do Documento</label></td>
			<tr>	
				
			<tr>	
				<td class="field">
					<select class="input" name="tipoDoc" id="tipoDoc">
						<!-- Pegar do Banco de dados os tipos e, caso o usuario selecione outro, exibir campo para cadastrar outro tipo -->
						<%=WebUtility.printSelectTipoDoc(request) %>
					</select>
				<label></label><a href="#"><img class="iconeAjuda" style="padding-left:9px;" src="/GraoPara/images/icone_ajuda.png" title="Selecione um dos tipos de documentos para filtrar resultados." /></a>
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
				<td colspan="3"><label for="palavrasChaves" class="labelFormsSearch">&#8226 Palavras-Chave</label></td>
			</tr>
			
			<tr>
				<td class="field" colspan="2">
					<select class="inputKey" name="chave1" id="chave1"><option value = "">Nenhuma</option>
						<%= WebUtility.printSelectKeyWords(request, "chave1") %>
					</select>
					<select class="inputKey" name="chave2" id="chave2"><option value = "">Nenhuma</option>
						<%= WebUtility.printSelectKeyWords(request, "chave2") %>
					</select>
					<select class="inputKey" name="chave3" id="chave3" style="width: 120px"><option value = "">Nenhuma</option>
						<%= WebUtility.printSelectKeyWords(request, "chave3") %>
					</select>
					<label></label><a href="#"><img class="iconeAjuda" style="padding-left:9px;" src="/GraoPara/images/icone_ajuda.png" title="Informe de uma a tr�s palavras chaves para filtrar sua pesquisa" /></a>
				</td>
			</tr>
			
			<tr>
				<td colspan="3">
					<br>
					<input class="buttonRegistrar" name="inserir" type="submit" value="Pesquisar" id="signupsubmit" />
					<label style="padding-left: 30px;"></label>
					<input class="buttonLimpar" name="limpar" type="reset" value="Limpar" title="Limpar todos os campos preenchidos."/>
				</td>
			</tr>
		</table>
	</form>
</div>