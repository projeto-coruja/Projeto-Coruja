<%@page contentType="text/html; charset=UTF-8"%>
<table class="text">
	<tr>
		<td>
			<h2>Grão-Pará: 1800-1850</h2>
			<p <% String url = request.getRequestURL().toString();
			int h = 75;
			if(url.contains("user/")) h = 110;
			else if(url.contains("userAdv/")) h = 200;
			else if(url.contains("admin/")) h = 230;
			out.print("style=\"height:"+h+"\"");%>
			>Bem-vindo a esta ferramenta colaborativa para a criação de verbetes sobre documentos ligados à história 
			da capitania/província do Pará na primeira metade do século XIX. Através desse site, qualquer pesquisador 
			também pode ter acesso integral aos verbetes já redigidos a partir de diferentes formas de busca.</p>
			
			<img src="/GraoPara/images/LogotipoUNIFESP.jpg" alt="UNIFESP" width="190px">
			<img src="/GraoPara/images/LogotipoOficialFap.jpg" alt="Fap-UNIFESP" width="190px" height="150px">
			<img src="/GraoPara/images/LogotipoCNPq.jpg"  alt="CNPq" width="190px">
			<img src="/GraoPara/images/LogotipoFAPESP.jpg"  alt="FAPESP" width="190px">
		</td>
	</tr>
</table>