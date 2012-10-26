<%@page import="webview.worker.PanelWorker"%>

<!-- Dar um espaço de duas linhas -->
<br><br>

<div class="scrollLong">
	<table class="tableList">
		<tr class="trList">
			<thead>
				<tr>
					<td class="tdList"><label for="identificacao" class="labelExibe">Identificação</label></td>
					<td class="tdList"><label for="codigo" class="labelExibe">Código</label></td>
					<td class="tdList"><label for="titulo" class="labelExibe">Títulos</label></td>
					<td class="tdList"><label for="acao" class="labelExibe">Ação</label></td>
				</tr>
			</thead>							
		<tbody><%PanelWorker.listAllCodex(request, out);%></tbody>
	</table>
</div>