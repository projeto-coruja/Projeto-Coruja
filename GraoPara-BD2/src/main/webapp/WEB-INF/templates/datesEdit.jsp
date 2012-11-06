<%@page import="webview.util.WebUtility"%>
<td class="field">
	<%		
		String[] paramDia = {(String) request.getAttribute("dia"), (String) request.getAttribute("dia")};
		String[] paramMes = {(String) request.getAttribute("mes"), (String) request.getAttribute("mes")}; 
		String[] paramAno = {(String) request.getAttribute("ano"), (String) request.getAttribute("ano")};
		if(paramDia[0] == null || paramDia[0].equals("00")) {
			paramDia[0] = "Ilegível / Inexistente";
			paramDia[1] = "";
		}
		if(paramMes[0] == null || paramMes[0].equals("00")) {
			paramMes[0] = "Ilegível / Inexistente";
			paramMes[1] = "";
		}
		else {
			paramMes[0] = WebUtility.meses[Integer.parseInt(paramMes[1]) - 1];
		}
		if(paramAno[0] == null || paramAno[0].equals("0000")) {
			paramAno[0] = "Ilegível / Inexistente";
			paramAno[1] = "";
		}
	%>
	<select name="dia" id="dia" class="inputDia">
		<option value=<%= paramDia[1] %> selected="selected"><%= paramDia[0] %></option>
		<option value="">--------</option>
		<option value="00">Ilegível / Inexistente</option>
		<option value="01">1</option>
		<option value="02">2</option>
		<option value="03">3</option>
		<option value="04">4</option>
		<option value="05">5</option>
		<option value="06">6</option>
		<option value="07">7</option>
		<option value="08">8</option>
		<option value="09">9</option>
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
		<option value="31">31</option>
	</select>

	<select name="mes" id="mes" class="inputMes">
		<option value=<%= paramMes[1] %> selected="selected"><%= paramMes[0] %></option>
		<option value="">--------</option>
		<option value="">Ilegível / Inexistente</option>
		<option value="01">Janeiro</option>
		<option value="02">Fevereiro</option>
		<option value="03">Março</option>
		<option value="04">Abril</option>
		<option value="05">Maio</option>
		<option value="06">Junho</option>
		<option value="07">Julho</option>
		<option value="08">Agosto</option>
		<option value="09">Setembro</option>
		<option value="10">Outubro</option>
		<option value="11">Novembro</option>
		<option value="12">Dezembro</option>
	</select>

	<label class="labelForms" id="ldata" for="data">Ano</label>
	<input class="inputAno" type="text" name="ano" id="ano" maxlength="4" value=<%= paramAno[1] %> />
</td>