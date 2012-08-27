<!doctype html>
<%@page import="java.io.PrintWriter"%>
<%@page import="webview.WebUtility"%>
<%@page import="business.EJB.userEJB.AuthBean"%>
<html>
<head>
<meta charset="utf-8">
<title>Grão-Pará</title>

<!-- Import dos styles CSS -->
<link rel="stylesheet" type="text/css"
	href="/GraoPara/css/principal.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/tabs.css" />
<link rel="stylesheet" type="text/css" href="/GraoPara/css/controle.css" />

<!-- CSS das validações -->
<link rel="stylesheet" type="text/css"
	href="/GraoPara/css/validationEngine.jquery.css" />

<!-- Import dos javascripts -->
<script type="text/javascript" src="/GraoPara/javascript/cookie.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"
	charset="utf-8"></script>


</head>
<body onloadstart="checkCookie()">
	<div class="container">
		<div class="header"></div>

		<!-- Começo do menu lateral -->
		<div class="sidebar1">

			<!--Depois de logado-->
			<div class="LoginArea" id="logado" style="display:block;">
				<form method="post" action="/GraoPara/doLogout">
					<fieldset>
						<label for="login">Bem vindo</label>
						<%
							WebUtility.printHTML(request, out);
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
					<li><a href="/GraoPara/protected/admin/gerarSenha.jsp">Gerar Senha</a></li>
					<li><a href="/GraoPara/protected/admin/sobreAdmin.jsp">Sobre</a></li>	
					<li><a href="#">Créditos</a></li>									
				</ul>
			</article>
		</div>
		<!-- Fim do Menu Lateral -->
		<div class="content" id="content">
		<h1> Como pesquisar</h1>
			<a name="num">Número do códice ou da caixa:</a>
			<p class="left">
Todos os documentos do Arquivo Público do Pará que serão trabalhados aqui estão organizados em CÓDICE ou em CAIXAS. Portanto, se o documento está em um códice ou em uma caixa faz uma enorme diferença, pois se tratam de coleções diferentes. Tudo é organizado pelo fato de ser caixa ou códice e depois a informação de qual caixa ou códice está se falando é muito importante, pois atrelada a cada uma dessas caixas ou códices está, às vezes, centenas de documentos.
A partir disso algumas considerações:
A) Ou criam-se dois bancos de dados idênticos (na verdade o mesmo, só duplicado), um para caixas e outro para códices, ou no preenchimento ficará muito claro que o dado a ser preenchido pertence a uma CAIXA ou a um CÓDICE.
B) Cada caixa ou códice tem um título, geralmente longo. Não coloquei um campo para preenchimento do título, pois pensei que isso poderia ser automático. Vocês deixariam a possibilidade dos alunos cadastrarem os títulos dos códices que estão trabalhando e depois quando fossem para a tela geral, simplesmente ao colocar o número do códice, apareceria o título já cadastrado. Isso é possível? Pensei que esse pré-cadastro funcionaria para outras coisas como palavras-chaves, tipo de documento etc.
·         possui dígito verificador? Não
·         quantos algarismos têm? De modo geral até 4, mas eu consideraria 5 como limite
·         é um campo obrigatório? Sim
·         é alfanumérico? 99% são apenas números, mas alguns possuem letras também
·         há diferenças na característica entre o número do códice e o número da caixa? (exemplo: um tem 10 algarismos e o outro tem 7) De modo geral, as caixas possuem até 3 dígitos.</p>
número APEP:
·         possui dígito verificador? Não
·         quantos algarismos têm? Até 3, mas seria bom colocar até 4
·         é alfanumérico? Até hoje só encontrei números, mas é bom contar com a possibilidade de algum registro com letras.
OBSERVAÇÃO IMPORTANTE: O número APEP é o número do documento dentro da caixa ou códice que o arquivista atribuiu. Muitos documentos possuem já essa numeração que facilita encontrar o documento dentro do conjunto. Quando existir esse número será com esse que identificaremos o documento. Em alguns casos, porém, o documento não está identificado. Aí você tem, às vezes, duzentos documentos sem nenhum tipo de numeração, o que torna impossível para o pesquisador que ler os verbetes saber rapidamente de que texto está se falando. Nestes casos, usaremos o que estamos chamando de número sequencial. Ou seja, vamos atribuir um número ao documento, considerando o primeiro como número um, o seguinte dois etc.
OBS IMPORTANTE 2: O número APEP e o número sequencial devem ser obrigatórios e excludentes. O que quero dizer: o aluno vai ter que preencher obrigatoriamente com um número APEP ou com um número sequencial. Se preencher com um não vai poder preencher com o outro e, ao mesmo tempo, não vai poder deixar de preencher os dois.
 
número sequencial
·         será gerado automaticamente, ou o usuário que cadastra? O usuário cadastra
·         possui dígito verificador? Não
·         quantos algarismos têm? Até 4
·         é alfanumérico? Não
resumo ou verbete do documento:
·         qual o limite de caracteres? 2 mil caracteres, aproximadamente.
·         é campo obrigatório? Sim
autor:
·         é o autor do registro no sistema(quem fez o cadastro), ou autor do documento? É o autor do documento.
·         é campo obrigatório? Sim.
destinatário:
·         detalhar o campo, por favor; Esse campo descreve para quem era destinado o documento. Por exemplo, o governo no Rio de Janeiro, a autoridade fulano de tal. Trata-se de um campo textual, assim como autor ou verbete.
·         é campo obrigatório? Sim
local:
·         é campo obrigatório? Sim
·         número de caracteres? 40
·         detalhar o campo, por favor; Trata-se do local em que foi escrito o documento, preferencialmente a cidade. Por exemplo, Belém.
 
data:
·         é campo obrigatório? Sim
OBS IMPORTANTE: Imagino que muitas pesquisas, no futuro, serão feitas por data do documento. Nesse sentido, seria bom separar o “ano” das demais informações da data (dia e mês) para facilitar a pesquisa por esse campo específico (o ano do documento)
palavras chaves:
·         é campo obrigatório? Sim
·         há limite de palavras chaves? Três, no máximo
·         há um mínimo de palavras chaves que deverá ser cadastrado? Uma, no mínimo
O ideal seria que os alunos pudessem cadastrar previamente algumas palavras chaves controladas e depois no preenchimento, eles só escolheriam essas palavras. Se não for feito isso, existirão tantas palavras chaves que o campo não servirá para nada.
tipo de documento?
·         quais são os tipos que podem ser cadastrados? É a mesma ideia de palavras chaves e dos títulos dos códices e caixas. A ideia é que os alunos possam fazer um cadastramento prévio e no trabalho do dia a dia escolher entre o que foi cadastrado. Inicialmente, é possível pensar em:
- Ofícios
- Relatórios
- Processos
- Impressos
 
 
Aproveito para reforçar um pouco qual era a minha ideia futura de possibilidade de pesquisa dos usuários externos, ou seja, como eles poderiam acessar os dados. Reproduzo abaixo um texto que escrevi sobre isso. Sei que vocês não vão mexer com isso agora, mas penso talvez seja importante essas informações para a confecção da base de dados.
 
forma de pesquisa dos historiadores através do site:
1) Através da busca por termos dos campos acima (por exemplo, palavra chave), ou por qualquer termo que tenha sido preenchido (sem apontar um campo específico para a busca).
2) Muito mais importante que a busca acima é possibilidade do banco de dados exportar relatórios (como é possível no projeto resgate, por exemplo). Esses relatórios seriam organizados por códices ou caixas, pois esse é o sentido da busca do historiador. A partir do códice ou caixa, seriam listados os verbetes de cada documento desse códice ou caixa, depois o seguinte com seus documentos etc. É muito importante que os pesquisadores possam ter acesso a relatórios que deem uma ideia geral do acervo. A pesquisa apenas por termos é muito limitada para nós. <a name="numero">Número do códice ou da caixa:</a></div>
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
