<%@page contentType="text/html; charset=UTF-8"%>
<table class="text">
	<tr>
		<td>
			<h2>Grão-Pará: 1800-1850</h2>
			<p>Bem-vindo a esta ferramenta colaborativa para a criação de verbetes sobre documentos ligados à história da capitania/província do 
			Pará na primeira metade do século XIX. Se você deseja participar do projeto juntamente com seus orientandos, 
			procure mais informações no link “sobre”, à esquerda da tela.</p>
			<p <% String url = request.getRequestURL().toString();
			int h = 60;
			if(url.contains("userAdv/")) h = 100;
			else if(url.contains("admin/")) h = 120;
			out.print("style=\"height:"+h+"\"");%>>Através desse site, qualquer pesquisador tem acesso livre e integral aos verbetes já redigidos pelo projeto. Para obter melhores resultados em suas buscas, recomenda-se a leitura do link “como pesquisar no acervo”, à esquerda da tela.</p>
			
			<img src="/GraoPara/images/LogotipoUNIFESP.jpg" alt="UNIFESP" width="190px">
			<img src="/GraoPara/images/LogotipoOficialFap.jpg" alt="Fap-UNIFESP" width="190px" height="150px">
			<img src="/GraoPara/images/LogotipoCNPq.jpg"  alt="CNPq" width="190px">
			<img src="/GraoPara/images/LogotipoFAPESP.jpg"  alt="FAPESP" width="210px">
		</td>
	</tr>
</table>