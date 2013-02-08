<%@page contentType="text/html; charset=UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="business.EJB.documents.CodiceCaixaEJB" %>
<%@ page import="persistence.dto.DTO" %>
<%@ page import="persistence.dto.CodiceCaixa" %>
<%@ page import="business.exceptions.login.UnreachableDataBaseException" %>
<%@ page import="business.exceptions.documents.CodiceCaixaNotFoundException" %>

<table class="tableForms">
	<tr>
		<td class="fieldDocInf">
			<!-- Lista de códices/caixas consultáveis -->
			<%				
				CodiceCaixaEJB cb = new CodiceCaixaEJB();
				try {
					List<DTO> list = cb.getAllEntriesWithContent();
					for(DTO d : list) {
						CodiceCaixa work = (CodiceCaixa) d;
						out.println("&#183" + work.getCod().replace("-", ": ") + "" + work.getTitulo() + " - " + work.getAnoInicio() + "/" + work.getAnoFim() + "<br>");
					}
				} catch (UnreachableDataBaseException e) {
					e.printStackTrace();
				} catch (CodiceCaixaNotFoundException e) {

				}
			%>
		</td>
	</tr>
</table>