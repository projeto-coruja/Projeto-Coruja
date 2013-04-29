<%@page contentType="text/html; charset=UTF-8"%>
<table class="text">
	<tr>
		<td>
			<h2>Grão-Pará: 1800-1850</h2>
			<p <% String url = request.getRequestURL().toString();
			int h = 77;
			if(url.contains("user/")) h = 120;
			else if(url.contains("userAdv/")) h = 210;
			else if(url.contains("admin/")) h = 230;
			out.print("style=\"height:"+h+"\"");%>
			>Bem-vindo a esta ferramenta colaborativa para a criação de verbetes sobre documentos ligados à história 
			da capitania/província do Pará na primeira metade do século XIX. Através desse site, qualquer pesquisador 
			também pode ter acesso integral aos verbetes já redigidos a partir de diferentes formas de busca.</p>
			
			<img src="/GraoPara/images/LogotipoUNIFESP.jpg" width="200px"><img src="/GraoPara/images/LogotipoOficialFap.jpg" width="200px" height="150"><img src="/GraoPara/images/LogotipoCNPq.jpg" width="200px"><img src="/GraoPara/images/LogotipoCNPq.jpg" width="200px">
		</td>
	</tr>
</table>