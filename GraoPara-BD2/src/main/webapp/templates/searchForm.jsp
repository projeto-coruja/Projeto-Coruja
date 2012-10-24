
<%@page import="webview.util.WebUtility"%>

<div class="content" id="content">
	<h1>Pesquisa de Documento</h1>

	<form action="/GraoPara/public/listagemDocumentos.jsp" id="signupform" method="get" name="cadastro">
		<table class="tablePesquisa">
			<tr>
				<td colspan="3">
					<label class="labelForms">
						<strong>PREENCHA UM OU MAIS CAMPOS A SEGUIR:</strong>
					</label>
				</td>
			</tr>
			<tr>
				<td class="status">
					<a href="#">
						<img src="/GraoPara/images/icone_ajuda.png"	alt="Busca por qualquer palavra registrada nos campos de identifica��o do documento por este projeto." title="Busca por qualquer palavra registrada nos campos de identifica��o do documento por este projeto." />
					</a>
				</td>
			</tr>

			<tr>
				<td class="tdPesquisa">
					<label class="labelForms" id="lidentificacao" for="identificacao">
						C�dice/Caixa
					</label>
				</td>

				<td class="field">
					<select name="tipoCodCodiceCaixa" class="input" id="identificacao">
						<option selected value="">Selecione...</option>
						<option value="CODICE">C�dice</option>
						<option value="CAIXA">Caixa</option>
					</select>
				</td>
				
				<td class="status">
					<a href="#">
						<img src="/GraoPara/images/icone_ajuda.png" alt="Escolha a cole��o de C�dices ou Caixas do Arquivo P�blico do Par�." title="Escolha a cole��o de C�dices ou Caixas do Arquivo P�blico do Par�." />
					</a>
				</td>
			</tr>
			<tr>
				<td class="tdPesquisa">
					<label class="labelForms" id="lcodigo" for="codigo">
						Intervalo do C�digo do C�dice/Caixa
					</label>
				</td>

				<td class="field">
					<label class="labelForms" id="ldata" for="data">de </label>
					<input class="inputShort" type="text" name="codDe" id="ano" maxlength="4" />
					<label class="labelForms" id="ldata" for="data"> at� </label>
					<input class="inputShort" type="text" name="codAte" id="ano" maxlength="4" />
				</td> 

				<td class="status">
					<a href="#">
						<img src="/GraoPara/images/icone_ajuda.png"	alt="Pode-se solicitar a pesquisa de uma sequ�ncia de C�dices ou Caixas. Basta indicar o primeiro e o �ltimo desejado." title="Pode-se solicitar a pesquisa de uma sequ�ncia de C�dices ou Caixas. Basta indicar o primeiro e o �ltimo desejado." />
					</a>
				</td>
			</tr>

			<tr>
				<td class="tdPesquisa">
					<label class="labelForms" id="lidentificacao" for="identificacao">
						Titulo do C�dice/Caixa
					</label>
				</td>

				<td class="field">
					<select name="tituloCodiceCaixa" class="input" id="identificacao">
						<%=WebUtility.printTituloCodiceCaixa(request, true)%>
					</select>
				</td>

				<td class="status">
					<a href="#">
						<img src="/GraoPara/images/icone_ajuda.png" alt="Escolha a cole��o de C�dices ou Caixas do Arquivo P�blico do Par�." title="Escolha a cole��o de C�dices ou Caixas do Arquivo P�blico do Par�." />
					</a>
				</td>
			</tr>

			<tr>
				<td class="tdPesquisa">
					<label class="labelForms" id="lcodigo" for="codigo">
						�poca (Caixa/C�dice)
					</label>
				</td>

				<td class="field">
					<label class="labelForms" id="ldata" for="data">de </label>
					<input class="inputShort" type="text" name="epocaDe" id="ano" maxlength="4" />
					<label class="labelForms" id="ldata" for="data"> at� </label>
					<input class="inputShort" type="text" name="epocaAte" id="ano" maxlength="4" />
				</td> 

				<td class="status">
					<a href="#">
						<img src="/GraoPara/images/icone_ajuda.png"	alt="Pode-se solicitar a pesquisa de uma sequ�ncia de C�dices ou Caixas. Basta indicar o primeiro e o �ltimo desejado." title="Pode-se solicitar a pesquisa de uma sequ�ncia de C�dices ou Caixas. Basta indicar o primeiro e o �ltimo desejado." />
					</a>
				</td>
			</tr>

			<tr>
				<td class="tdPesquisa">
					<label class="labelForms" id="ltitulo" for="titulo">
						T�tulo
					</label>
				</td>

				<td class="field">
					<input class="input" name="titulo" id="titulo" type="text" size="20" maxlength="500">
				</td>

				<td class="status">
					<a href="#">
						<img src="/GraoPara/images/icone_ajuda.png" alt="Cada caixa ou c�dice tem um t�tulo, geralmente longo." title="Cada caixa ou c�dice tem um t�tulo, geralmente longo." />
					</a>
				</td>
			</tr>

			<tr>
				<td class="tdPesquisa">
					<label class="labelForms" id="lnumero" for="numero">
						Tipo APEP ou Sequencial
					</label>
				</td>

				<td class="status">
					<select name="tipoDaIdentificacao" class="input" id="identificacao">
						<option selected value="">Selecione...</option>
						<option value="APEP">APEP</option>
						<option value="SEQ">Sequencial</option>
					</select>
				</td>

				<td class="status">
					<a href="#">
						<img src="/GraoPara/images/icone_ajuda.png" alt="O N�mero APEP � aquele atribu�do pelo arquivista do APEP para cada um dos documentos do C�dice ou Caixa. Caso n�o tenha sido atribu�do um n�mero pelo arquivista, o projeto designou um que chamou de sequencial." title="O N�mero APEP � aquele atribu�do pelo arquivista do APEP para cada um dos documentos do C�dice ou Caixa. Caso n�o tenha sido atribu�do um n�mero pelo arquivista, o projeto designou um que chamou de sequencial." />
					</a>
				</td>
			</tr>
			
			<tr>
				<td class="tdPesquisa">
					<label class="labelForms" id="lnumero" for="numero">
						N�mero da Identifica��o
					</label>
				</td>

				<td class="field">
					<input class="inputShort" type="text" name="numDaIdentificacao" id="ano" maxlength="10" />
				</td> 

				<td class="status">
					<a href="#">
						<img src="/GraoPara/images/icone_ajuda.png" alt="O N�mero APEP � aquele atribu�do pelo arquivista do APEP para cada um dos documentos do C�dice ou Caixa. Caso n�o tenha sido atribu�do um n�mero pelo arquivista, o projeto designou um que chamou de sequencial." title="O N�mero APEP � aquele atribu�do pelo arquivista do APEP para cada um dos documentos do C�dice ou Caixa. Caso n�o tenha sido atribu�do um n�mero pelo arquivista, o projeto designou um que chamou de sequencial." />
					</a>
				</td>
			</tr>

			<tr>
				<td class="tdPesquisa">
					<label class="labelForms" id="lautor" for="autor">
						Autor do Documento
					</label>
				</td>

				<td class="field">
					<input class="input" name="autor" id="autor" type="text" size="20" maxlength="48">
				</td>

				<td class="status">
					<a href="#">
						<img src="/GraoPara/images/icone_ajuda.png" alt="Busca pelo nome completo ou parte do autor do documento." title="Busca pelo nome completo ou parte do autor do documento." />
					</a>
				</td>
			</tr>

			<tr>
				<td class="tdPesquisa"><label class="labelForms" id="lautorOcupacao" for="autorOcupacao">Ocupa��o do Autor do Documento</label></td>
				<td class="field"><input class="input" name="autorOcupacao" id="autorOcupacao" type="text" size="20" maxlength="48"></td>
				<td class="status"><a href="#"><img
					src="/GraoPara/images/icone_ajuda.png"
					alt="Ocupa��o do autor do documento. Por exemplo, Presidente da Prov�ncia."
					title="Ocupa��o do autor do documento. Por exemplo, Presidente da Prov�ncia." /></a>
				</td>
			</tr>					
			<tr>
				<td class="tdPesquisa"><label class="labelForms" id="ldestinatario" for="destinatario">Destinat�rio do Documento</label></td>
				<td class="field"><input class="input" name="destinatario" id="destinatario" type="text" size="20" maxlength="48"></td>
				<td class="status"><a href="#"><img
					src="/GraoPara/images/icone_ajuda.png"
					alt="Busca pelo nome completo ou parte do destinat�rio do Documento."
					title="Busca pelo nome completo ou parte do destinat�rio do Documento." /></a>
				</td>
			</tr>
			<tr>
				<td class="tdPesquisa"><label class="labelForms" id="lautorOcupacao" for="autorOcupacao">Ocupa��o do Destinat�rio do Documento</label></td>
				<td class="field"><input class="input" name="destinatarioOcupacao" id="autorOcupacao" type="text" size="20" maxlength="48"></td>
				<td class="status"><a href="#"><img
					src="/GraoPara/images/icone_ajuda.png"
					alt="Ocupa��o do destinat�rio do documento. Por exemplo, Presidente da Prov�ncia."
					title="Ocupa��o do destinat�rio do documento. Por exemplo, Presidente da Prov�ncia." /></a>
				</td>
			</tr>	
			<tr>
				<td class="tdPesquisa"><label class="labelForms" id="llocal" for="local">Local</label></td>
				<td class="field"><input class="input" name="local" id="local" type="text" maxlength="48"></td>
				<td class="status"><a href="#"><img
					src="/GraoPara/images/icone_ajuda.png"
					alt="Trata-se do local em que foi escrito o documento, normalmente a cidade. Por exemplo, Bel�m."
					title="Trata-se do local em que foi escrito o documento, normalmente a cidade. Por exemplo, Bel�m." /></a>
				</td>
			</tr>
			<tr>
				<td class="tdPesquisa"><label class="labelForms" id="ldata" for="data">Ano</label></td>
				<td class="field">
					<label class="labelForms" id="ldata" for="data">de </label>
					<input class="inputShort" type="text" name="anoIni" id="ano" maxlength="4" />
					<label class="labelForms" id="ldata" for="data"> at� </label>
					<input class="inputShort" type="text" name="anoFim" id="ano" maxlength="4" />
				</td> 
				<td class="status"><a href="#"><img
					src="/GraoPara/images/icone_ajuda.png"
					alt="Informe um per�odo para filtrar a pesquisa."
					title="Informe um per�odo para filtrar a pesquisa." /></a>
				</td>
			</tr>
			<tr>
				<td class="tdPesquisa"><label class="labelForms" id="ltipoDoc" for="tipoDoc">Tipo do Documento</label></td>
				<td class="field">
					<select class="input" name="tipoDoc" id="tipoDoc">
						<!-- Pegar do Banco de dados os tipos e, caso o usuário selecione outro, exibir campo para cadastrar outro tipo -->
						<%=WebUtility.printSelectTipoDoc(request) %>
					</select>
				</td>
				<td class="status"><a href="#"><img 
					src="/GraoPara/images/icone_ajuda.png"
					alt="Selecione um dos tipos de documentos para filtrar resultados."
					title="Selecione um dos tipos de documentos para filtrar resultados." /></a>
				</td>
			</tr>
			<tr>
				<td colspan="3"><label class="labelForms">Resumo ou Veberbete do Documento</label></td>
			</tr>
			<tr>						
				<td class="field" colspan="2"><textarea class="inputResumo" id="resumo" name="resumo" rows="7" cols="40" maxlength="2048"></textarea></td>
				<td class="status"></td>
			</tr>
			<tr>
				<td colspan="3"><label for="palavrasChaves" class="labelForms">Palavra Chaves</label></td>
			</tr>
			<tr>
				<td class="field" colspan="2">
					<select class="input" name="chave1" id="chave1" style="width: 120px"><option value = "">Nenhuma</option>
						<%= WebUtility.printSelectKeyWords(request, "chave1") %>
					</select>
					<select class="input" name="chave2" id="chave2" style="width: 120px"><option value = "">Nenhuma</option>
						<%= WebUtility.printSelectKeyWords(request, "chave2") %>
					</select>
					<select  class="input" name="chave3" id="chave3" style="width: 120px"><option value = "">Nenhuma</option>
						<%= WebUtility.printSelectKeyWords(request, "chave3") %>
					</select>
				</td>
				<td class="status"><a href="#"><img
					src="/GraoPara/images/icone_ajuda.png"
					alt="Informe de uma a tr�s palavras chaves para filtrar sua pesquisa"
					title="Informe de uma a tr�s palavras chaves para filtrar sua pesquisa" /></a>
				</td>
			</tr>
			<tr>
				<td colspan="3"><p></p>
					<input class="buttonLimpar" name="limpar" type="reset" value="Limpar" />
					<input class="buttonRegistrar" name="inserir" type="submit" value="Enviar" id="signupsubmit" style="FONT-FAMILY: 'Bitstream Charter';"/>
				</td>
			</tr>
		</table>
	</form>
</div>