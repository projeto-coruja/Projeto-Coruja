<%@page contentType="text/html; charset=UTF-8"%>
<table class="text">
	<tr>
		<td>
			<h2>Como realizar pesquisas no acervo</h2>			
			<p>A primeira questão que o consulente deve lembrar é que este é um projeto aberto e em construção. 
			Em razão disso, todos os dias os alunos participantes do projeto acrescentam novos verbetes aos já existentes. 
			Dessa forma, consultas realizadas em datas diferentes podem trazer resultados distintos. O pesquisador tem como 
			acompanhar a progressão do trabalho do projeto, visualizando quais foram as caixas e códices já trabalhados. 
			Para isso, entre na página “pesquisar” e clique no link “Lista de códices/caixas consultáveis”.</p>
			<p>Para pesquisar os verbetes, entre na página “pesquisar”. Ali há uma série de campos que podem ser preenchidos para efetuar a busca. 
			O preenchimento dos campos filtra progressivamente os resultados e, portanto, quanto mais campos forem preenchidos mais 
			específicos serão os resultados. Se o consulente pedir uma pesquisa sem preencher qualquer campo, aparecerão todos os verbetes 
			já redigidos. Se selecionar a opção “códices”, aparecerão apenas verbetes relacionados a códices. Se além dessa primeira opção, 
			colocar também o intervalo de códices entre 900 e 902, só os verbetes relacionados aos códices 900, 901 e 902 aparecerão. 
			Se somadas a essas seleções, também preencher o campo “autor do documento” com a palavra “Burgos”, o resultado da pesquisa 
			trará apenas verbetes dos códices 900, 901 e 902 que tem documentos escritos por alguma pessoa que tem em seu nome a palavra “Burgos”. 
			Não é necessário escrever o nome inteiro do autor e tampouco se preocupar com as letras maiúsculas ou minúsculas. No caso do preenchimento 
			do campo data, o consulente deve saber que não aparecerão os verbetes sem data identificável, mesmo que correspondam a outros campos da busca. 
			Uma vez feita a pesquisa, os resultados apareceram na tela, separados por códice e em ordem crescente do número dos documentos, no seguinte formato:</p>  
			<br/>
			<%@include file="/WEB-INF/templates/searchCaption.jsp" %><br/>
			<p>Nessa mesma tela, na extremidade superior, o pesquisador pode solicitar que sua busca gere uma planilha com os resultados obtidos. 
			Para isto basta clicar no link “Download Pesquisa”. A planilha será criada no programa LibreOffice, que é um software livre. 
			Caso você não tenha esse software, ao lado do link “Download Pesquisa” está o link “Baixar o LibreOffice”. Recomenda-se que você grave 
			a planilha no seu disco rígido, pois isso permitirá, além da sua cópia, futuras formatações da mesma. Se a planilha for apenas aberta 
			não será possível gravá-la e tampouco fazer modificações.</p>
		</td>
	</tr>
</table>