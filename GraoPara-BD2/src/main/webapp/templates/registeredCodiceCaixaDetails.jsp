<%@page import="webview.worker.PanelWorker"%>

<!-- Dar um espaço de duas linhas -->
<br><br>

<div class="scrollLong">
	<table class="tableList">
		<tr class="trList">
			<thead>
				<tr>
					<td class="tdList"><label for="codigo" class="labelExibe">Código</label></td>
					<td class="tdList"><label for="titulo" class="labelExibe">Título</label></td>
					<td class="tdList"><label for="anoIni" class="labelExibe">Início</label></td>
					<td class="tdList"><label for="anoFim" class="labelExibe">Fim</label></td>
					<td class="tdList"><label for="acao" class="labelExibe">Ação</label></td>
				</tr>
			</thead>							
		<tbody><%PanelWorker.listAllCodex(request, out);%></tbody>
	</table>
</div>