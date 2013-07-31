package business.export;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.geom.Rectangle2D;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.odftoolkit.odfdom.type.Color;
import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.style.Border;
import org.odftoolkit.simple.style.StyleTypeDefinitions.CellBordersType;
import org.odftoolkit.simple.style.StyleTypeDefinitions.HorizontalAlignmentType;
import org.odftoolkit.simple.style.StyleTypeDefinitions.SupportedLinearMeasure;
import org.odftoolkit.simple.style.StyleTypeDefinitions.VerticalAlignmentType;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Column;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;

import persistence.dto.DTO;
import persistence.dto.Documento;
import business.EJB.util.EJBUtility;

/**
 * Classe para exportar resultado.
 *
 */
public class SpreadsheetExport {

	private static String tmpPath;
	
	private static void getPath(){
		tmpPath = "/tmp"; // caminho local onde o documento será gerado.
	}
	
	/**
	 * @param s
	 * @return
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private static double getStringWidth(String s){
		Font font = new Font("Arial", Font.PLAIN, 10);  
        FontMetrics metrics = new FontMetrics(font) {
			private static final long serialVersionUID = 8731863241931241309L;  
        };  
        Rectangle2D bounds = metrics.getStringBounds(s, null);  
		return bounds.getWidth();
	}
	
	/**
	 * Cria uma planilha contendo o resultado da pesquisa de documentos.
	 * @param resultSet - List&lt;DTO&gt; contendo o resultado que será inserido no documento.
	 * @return <i>String</i> com o caminho absoluto do arquivo gerado.
	 * @throws Exception
	 */
	public static String generateSpreadsheet(List<DTO> resultSet) throws Exception{
		SpreadsheetDocument outerDoc = SpreadsheetDocument.newSpreadsheetDocument();
		String creationDate = new SimpleDateFormat("dd-MM-YYYY").format(new Date());
		Documento docDTO = null;
		Table tbl = outerDoc.getSheetByIndex(0);
		Row row = tbl.appendRow();
		Column column = tbl.appendColumn();
		Cell cel = row.getCellByIndex(0);
		
//		Color grey = new Color("#DDDDDD");
		Border border = new Border(new Color("#000000"), 0.001, SupportedLinearMeasure.IN);	// Formatação da borda das células.
		
		int coluna;
		
		getPath();
		
		// Primeira linha
		coluna = 0;
		row = tbl.getRowByIndex(0);
		// Conteúdo das células da primeira linha.
		String index[] = {"Código da Caixa/Códice",
				"Título da Caixa/Códice",
				"Código do documento",
				"Resumo",
				"Data",
				"Palavra Chaves",
				"Tipo de Documento",
				"Autor",
				"Ocupação do autor",
				"Destinatário",
				"Ocupação do destinatário",
				"Local",
				"URL da imagem"};
		// =======================================================
		// Modificando e formatando as células
		for(int i = 0; i < index.length; i++){
			column = tbl.getColumnByIndex(coluna);
//			column.setWidth(getStringWidth(index[i]));
			column.setWidth(50);											// Modifica a largura da célula
			cel = row.getCellByIndex(coluna++);
//			cel.setCellBackgroundColor(grey);
			cel.setBorders(CellBordersType.ALL_FOUR, border);				// Formata as bordas de acordo com a variável "border"
			cel.setHorizontalAlignment(HorizontalAlignmentType.CENTER);		// Seta o alinhamento horizontal.
			cel.setVerticalAlignment(VerticalAlignmentType.MIDDLE);			// Seta o alinhamento vertical.
			cel.setDisplayText(index[i]);
		}
	
		// Segunda em diante
		for(int linha = 0; linha < resultSet.size(); linha++){
			coluna = 0;
			docDTO = (Documento) resultSet.get(linha);
			row = tbl.getRowByIndex(linha+1);
			row.setHeight(50, false);
			// Conteúdo das células.
			String cellContent[] = {docDTO.getCodiceCaixa().getCod().replace("-", " - "),
					docDTO.getCodiceCaixa().getTitulo(),
					docDTO.getCod().replace("-", " - "),
					docDTO.getResumo(),
					(docDTO.getData() != null ? docDTO.getData().toString() : "Sem data" ),
					(docDTO.getPalavraChave1() != null ? docDTO.getPalavraChave1().getPalavra() : " ")	+
						(docDTO.getPalavraChave2() != null ? " - " + docDTO.getPalavraChave2().getPalavra() : " ") + 
						(docDTO.getPalavraChave3() != null ? " - " + docDTO.getPalavraChave3().getPalavra() : " "),
					docDTO.getTipoDocumento().getNome(),
					docDTO.getAutor().getNome(),
					docDTO.getAutor().getOcupacao(),
					docDTO.getDestinatario().getNome(),
					docDTO.getDestinatario().getOcupacao(),
					docDTO.getLocal(),
					docDTO.getUrl()};
			// =======================================================
			for(int i = 0; i < cellContent.length; i++){

				column = tbl.getColumnByIndex(coluna);
//				if(getStringWidth(cellContent[i]) > column.getWidth())	column.setWidth(getStringWidth(cellContent[i]));
				cel = row.getCellByIndex(coluna++);
//				if(linha%2 == 1)	cel.setCellBackgroundColor(grey);
				cel.setTextWrapped(true);
				cel.setBorders(CellBordersType.ALL_FOUR, border);
				if(i == cellContent.length - 1)	cel.setHorizontalAlignment(HorizontalAlignmentType.LEFT);
				else	cel.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
				cel.setVerticalAlignment(VerticalAlignmentType.MIDDLE);
				cel.setStringValue(cellContent[i]);
			}
		}


		String filePath = tmpPath + "/rlt_" + EJBUtility.genRandomString(8) + "_" + creationDate + ".ods";
//		System.out.println(filePath);
		outerDoc.save(filePath);
		outerDoc.close();
		return filePath;
	}

	/**
	 * Testes...
	 */
	/*public static void main(String[] args) throws Exception {
		getPath();
		System.out.println(tmpPath);
	
		
		List<DTO> lista = new ArrayList<DTO>();
//		DocumentEJB busca = new DocumentEJB();
//		lista = busca.findByKeyWord("gato");
		
		lista.add(new Documento("123","teste","local", "http://google.com.br", "resumo",
				new CodiceCaixa("123","testeCodiceCaixa",1500,1540),
				new TipoDocumento("tipoDocumento","Descrição"),
				new Autor("abcaheo aoehaeofgh aeohaeo foehrfaefh aehjioahrf","ocupação1"),
				new Autor("abcaheo","ocupação2"),
				new PalavraChave("a",new TemaPalavraChave("tema")),
				new PalavraChave("a",new TemaPalavraChave("tema")),
				new PalavraChave("a",new TemaPalavraChave("tema")),
				new UserAccount("nome", new Profile("profile"), "a@b.com", "abc"),
				new Date()));
		
		SpreadsheetExport.generateSpreadsheet(lista);
	}*/
}
