<!doctype html>
<%@page import="webview.WebUtility"%>
<html>
<head>
<meta charset="utf-8">
<title>Grão-Pará</title>


<!-- Import dos styles CSS -->
<link rel="stylesheet" type="text/css"
	href="/GraoPara/css/principal.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/tabs.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/controle.css" />

<!-- Import dos javascripts -->
<script type="text/javascript" src="/GraoPara/javascript/cookie.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"
	charset="utf-8"></script>

</head>
<body>

	<div class="container">
		<div class="header"></div>

		<!-- Começo do menu lateral -->
		<div class="sidebar1">

			<!--Depois de logado-->
			<div class="LoginArea" id="logado" style="display: block;">
				<form method="post" action="/GraoPara/doLogout">
					<fieldset>
						<label for="login">Bem vindo</label>
						<%
							WebUtility.printName(request, out);
						%>
					</fieldset>
					<fieldset>
						<input class="buttonSair" type="submit" name="Sair" value="Sair" />
					</fieldset>
				</form>
			</div>
			<!-- ----------------------------------------------------------------------- -->

			<article class="menuLateral">
				<ul class="nav" id="menu">
					<li><a href="/GraoPara/protected/admin/indexAdmin.jsp">Home</a></li>
					<li><a href="/GraoPara/protected/admin/pesquisaAdmin.jsp">Pesquisar</a></li>
					<li><a href="/GraoPara/protected/admin/cadastroDocumentosAdmin.jsp">Cadastrar Documento</a></li>
					<li><a href="/GraoPara/protected/admin/cadUserAdmin.jsp">Cadastrar Usuário</a></li>					
					<li><a href="/GraoPara/protected/admin/painelAdmin.jsp">Painel Admin</a></li>
					<li><a href="/GraoPara/protected/admin/cadastrarTipoDocumento.jsp">Cadastrar Tipo de Documento</a></li>					
					<li><a href="/GraoPara/protected/admin/gerarSenha.jsp">Gerar Senha</a></li>
					<li><a href="/GraoPara/protected/admin/sobreAdmin.jsp">Sobre</a></li>	
					<li><a href="#">Créditos</a></li>									
				</ul>
			</article>
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="content" id="content">
			<h1>Pesquisa de Documento</h1>
			<form action="/GraoPara/protected/admin/listagemDocumentos.jsp" method="get" name="cadastro" autocomplete="off">
				<table class="tablePesquisa">
					<tr>
						<td colspan="3"><label class="labelForms"><strong>PREENCHA
									UM OU MAIS CAMPOS A SEGUIR:</strong></label></td>
					</tr>
					<tr>
						<td class="tdForms"><label class="labelForms"
							id="lidentificacao" for="identificacao">Identificação:</label></td>
						<td class="field"><select name="identificacao" class="input"
							id="identificacao">
								<option value="">Selecione...</option>
								<option value="codice">Número de Códice</option>
								<option value="caixa">Número da Caixa</option>
						</select></td>
						<td class="status"><a href="#"><img
								src="/GraoPara/images/icone_ajuda.png"
								alt="Todos os documentos do Arquivo Público do Pará que serão trabalhados aqui estão organizados em CÓDICE ou em CAIXAS. Portanto, se o documento está em um códice ou em uma caixa faz uma enorme diferença, pois se tratam de coleções diferentes. Tudo é organizado pelo fato de ser caixa ou códice e depois a informação de qual caixa ou códice está se falando é muito importante, pois atrelada a cada uma dessas caixas ou códices está, às vezes, centenas de documentos."
								title="Todos os documentos do Arquivo Público do Pará que serão trabalhados aqui estão organizados em CÓDICE ou em CAIXAS. Portanto, se o documento está em um códice ou em uma caixa faz uma enorme diferença, pois se tratam de coleções diferentes. Tudo é organizado pelo fato de ser caixa ou códice e depois a informação de qual caixa ou códice está se falando é muito importante, pois atrelada a cada uma dessas caixas ou códices está, às vezes, centenas de documentos." /></a>
						</td>
					</tr>
					<tr>
						<td class="tdForms"><label class="labelForms" id="lcodigo"
							for="codigo">Código:</label></td>
						<td class="field"><input class="input" name="codigo"
							id="codigo" type="text" maxlength="5"></td>
						<td class="status"><a href="#"><img
								src="/GraoPara/images/icone_ajuda.png" alt="Código do documento"
								title="Informe o código do documento que deseja pesquisar" /></a></td>
					</tr>
					<tr>
						<td class="tdForms"><label class="labelForms" id="ltitulo"
							for="titulo">Título:</label></td>
						<td class="field"><input class="input" name="titulo"
							id="titulo" type="text" size="20" maxlength="48"></td>
						<td class="status"><a href="#"><img
								src="/GraoPara/images/icone_ajuda.png"
								alt="Cada caixa ou códice tem um título, geralmente longo."
								title="Cada caixa ou códice tem um título, geralmente longo." /></a></td>
					</tr>
					<tr>
						<td class="tdForms"><label class="labelForms" id="lnumero"
							for="numero">Número APEP ou Sequencial:</label></td>
						<td class="field"><input class="input" name="numero"
							id="numero" type="text" maxlength="4"></td>
						<td class="status"><a href="#"><img
								src="/GraoPara/images/icone_ajuda.png"
								alt="O número APEP é o número do documento dentro da caixa ou códice que o arquivista atribuiu. Muitos documentos possuem já essa numeração que facilita encontrar o documento dentro do conjunto. Quando existir esse número será com esse que identificaremos o documento. Em alguns casos, porém, o documento não está identificado. Aí você tem, às vezes, duzentos documentos sem nenhum tipo de numeração, o que torna impossível para o pesquisador que ler os verbetes saber rapidamente de que texto está se falando. Nestes casos, usaremos o que estamos chamando de número sequencial."
								title="O número APEP é o número do documento dentro da caixa ou códice que o arquivista atribuiu. Muitos documentos possuem já essa numeração que facilita encontrar o documento dentro do conjunto. Quando existir esse número será com esse que identificaremos o documento. Em alguns casos, porém, o documento não está identificado. Aí você tem, às vezes, duzentos documentos sem nenhum tipo de numeração, o que torna impossível para o pesquisador que ler os verbetes saber rapidamente de que texto está se falando. Nestes casos, usaremos o que estamos chamando de número sequencial." /></a></td>
					</tr>
					<tr>
						<td class="tdForms"><label class="labelForms" id="lautor"
							for="autor">Autor do Documento:</label></td>
						<td class="field"><input class="input" name="autor"
							id="autor" type="text" size="20" maxlength="48"></td>
						<td class="status"><a href="#"><img
								src="/GraoPara/images/icone_ajuda.png"
								alt="Autor do Documento que deseja pesquisar"
								title="Autor do Documento que deseja pesquisar" /></a></td>
					</tr>
					<tr>
						<td class="tdForms"><label class="labelForms"
							id="ldestinatario" for="destinatario">Destinatário do
								Documento:</label></td>
						<td class="field"><input class="input" name="destinatario"
							id="destinatario" type="text" size="20" maxlength="48"></td>
						<td class="status"><a href="#"><img
								src="/GraoPara/images/icone_ajuda.png"
								alt="Esse campo descreve para quem era destinado o documento. Por exemplo, o governo no Rio de Janeiro, a autoridade fulano de tal. Trata-se de um campo textual, assim como autor ou verbete."
								title="Esse campo descreve para quem era destinado o documento. Por exemplo, o governo no Rio de Janeiro, a autoridade fulano de tal. Trata-se de um campo textual, assim como autor ou verbete." /></a></td>
					</tr>
					<tr>
						<td class="tdForms"><label class="labelForms" id="llocal"
							for="local">Local:</label></td>
						<td class="field"><input class="input" name="local"
							id="local" type="text" maxlength="48"></td>
						<td class="status"><a href="#"><img
								src="/GraoPara/images/icone_ajuda.png"
								alt="Trata-se do local em que foi escrito o documento, normalmente a cidade. Por exemplo, Belém."
								title="Trata-se do local em que foi escrito o documento, normalmente a cidade. Por exemplo, Belém." /></a></td>
					</tr>
					<tr>
						<td class="tdForms"><label class="labelForms" id="ldata"
							for="data">Data do Documento:</label></td>
						<td class="field"><select name="dia" id="dia"
							class="inputDia"><option value="" selected="selected">Dia</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
								<option value="13">13</option>
								<option value="14">14</option>
								<option value="15">15</option>
								<option value="16">16</option>
								<option value="17">17</option>
								<option value="18">18</option>
								<option value="19">19</option>
								<option value="20">20</option>
								<option value="21">21</option>
								<option value="22">22</option>
								<option value="23">23</option>
								<option value="24">24</option>
								<option value="25">25</option>
								<option value="26">26</option>
								<option value="27">27</option>
								<option value="28">28</option>
								<option value="29">29</option>
								<option value="30">30</option>
								<option value="31">31</option></select> <select name="mes" id="mes"
							class="inputShort"><option value="" selected="selected">Mês</option>
								<option value="1">Jan</option>
								<option value="2">Fev</option>
								<option value="3">Mar</option>
								<option value="4">Abr</option>
								<option value="5">Mai</option>
								<option value="6">Jun</option>
								<option value="7">Jul</option>
								<option value="8">Ago</option>
								<option value="9">Set</option>
								<option value="10">Out</option>
								<option value="11">Nov</option>
								<option value="12">Dez</option></select> <label class="labelForms"
							id="ldata" for="data">Ano:</label><input class="inputAno"
							type="text" name="ano" id="ano" maxlength="4" /></td>
						<td class="status"><a href="#"><img
								src="/GraoPara/images/icone_ajuda.png"
								alt="Informe somente o ano se quiser filtrar a pesquisa por período."
								title="Informe somente o ano se quiser filtrar a pesquisa por período." /></a></td>
					</tr>
					<tr>
						<td class="tdForms"><label class="labelForms" id="ltipoDoc"
							for="tipoDoc">Tipo do Documento:</label></td>
						<td class="field"><select class="input" name="tipoDoc"
							id="tipoDoc">
								<!-- Pegar do Banco de dados os tipos e, caso o usuÃ¡rio selecione outro, exibir campo para cadastrar outro tipo -->
								<option value="">Selecione...</option>
								<option value="ofícios">Ofícios</option>
								<option value="relatórios">Relatórios</option>
								<option value="impressos">Impressos</option>
								<option value="processos">Processos</option>
								<option value="cartas">Cartas</option>
						</select></td>
						<td class="status"><a href="#"><img
								src="/GraoPara/images/icone_ajuda.png"
								alt="Selecione um dos tipos de documentos para filtrar resultados"
								title="Selecione um dos tipos de documentos para filtrar resultados" /></a></td>
					</tr>
					<tr>
						<td colspan="3"><label for="palavrasChaves"
							class="labelForms">Palavra Chaves:</label></td>
					</tr>
					<tr>
						<td class="field" colspan="2"><input
							class="inputPalavraChave" id="chave1" name="chave1" type="text"
							size="15" maxlength="32"> - <input
							class="inputPalavraChave" id="chave2" name="chave2" type="text"
							size="15" maxlength="32"> - <input
							class="inputPalavraChave" id="chave3" name="chave3" type="text"
							size="15" maxlength="32"></td>
						<td class="status"><a href="#"><img
								src="/GraoPara/images/icone_ajuda.png"
								alt="Informe de uma a três palavras chaves para filtrar sua pesquisa"
								title="Informe de uma a três palavras chaves para filtrar sua pesquisa" /></a></td>
					</tr>
					<tr>
						<td colspan="3">
							<p></p> <input class="buttonLimpar" name="limpar" type="reset"
							value="Limpar" /><input class="buttonRegistrar" name="inserir"
							type="submit" value="Enviar" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<!-- Começo do Rodapé -->
		<div class="footer">
			<p>Copyright © - Universidade Federal de São Paulo - UNIFESP 2012</p>
			<p>Desenvolvido pelo grupo Coruja</p>
		</div>
		<!-- Fim do Rodapé -->
		<!-- end .container -->
	</div>
</body>
</html>


