<%@page import="webview.worker.PanelWorker"%>

<!-- Dar um espa�o de duas linhas -->
<br><br>

<div class="scrollLong">
	<table class="tableList">
		<tr class="trList">
			<thead>
				<tr>
					<td class="tdList"><label for="codigo" class="labelExibe">C�digo</label></td>
					<td class="tdList"><label for="titulo" class="labelExibe">T�tulo</label></td>
					<td class="tdList"><label for="anoIni" class="labelExibe">In�cio</label></td>
					<td class="tdList"><label for="anoFim" class="labelExibe">Fim</label></td>
					<td class="tdList"><label for="acao" class="labelExibe">A��o</label></td>
				</tr>
			</thead>							
		<tbody><%PanelWorker.listAllCodex(request, out);%></tbody>
	</table>
</div>