package business.export;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;

import persistence.dto.DTO;
import persistence.dto.DocumentoDTO;
import business.EJB.docEJB.BuscaDocEJB;
import business.EJB.util.EJBUtility;

public class SpreadsheetExport {
	
	private static String tmpPath;
	
	private static void getPath(){

		tmpPath = SpreadsheetExport.class.getResource("SpreadsheetExport.class").getPath();
		tmpPath = tmpPath.replace("/target/classes/business/export/SpreadsheetExport.class", "/ExportODS/");
	}
	
	public static String generateSpreadsheet(List<DTO> resultSet) throws Exception{
		SpreadsheetDocument outerDoc = SpreadsheetDocument.newSpreadsheetDocument();
		String creationDate = new SimpleDateFormat("dd-MM-YYYY").format(new Date());
		DocumentoDTO docDTO = null;
		Table tbl = outerDoc.getSheetByIndex(0);
		Row row = tbl.appendRow();
		Cell cel = row.getCellByIndex(0);
		int coluna;
		
		// Primeira linha
		coluna = 0;
		row = tbl.getRowByIndex(0);
		

		cel = row.getCellByIndex(coluna++);
		cel.addParagraph("Identificação");
//		cel.setCellBackgroundColor(new Color("#FF1493"));
//		cel.setBorders(CellBordersType.ALL_FOUR, new Border(new Color("#000000"), 1.3, SupportedLinearMeasure.PT));
//		cel.setHorizontalAlignment(HorizontalAlignmentType.LEFT);
//		cel.setVerticalAlignment(VerticalAlignmentType.MIDDLE);
		
		cel = row.getCellByIndex(coluna++);
		cel.addParagraph("Código");
		
		cel = row.getCellByIndex(coluna++);
		cel.addParagraph("Titulo");
		
		cel = row.getCellByIndex(coluna++);
		cel.addParagraph("Tipo de Identificação");
		
		cel = row.getCellByIndex(coluna++);
		cel.addParagraph("Número");
		
		cel = row.getCellByIndex(coluna++);
		cel.addParagraph("Autor");
		
		cel = row.getCellByIndex(coluna++);
		cel.addParagraph("Destinatário");
		
		cel = row.getCellByIndex(coluna++);
		cel.addParagraph("Local");
		
		cel = row.getCellByIndex(coluna++);
		cel.addParagraph("Data");
		
		cel = row.getCellByIndex(coluna++);
		cel.addParagraph("Tipo de Documento");
		
		cel = row.getCellByIndex(coluna++);
		cel.addParagraph("Palavra Chaves");
		
//		cel = row.getCellByIndex(coluna++);
//		cel.addParagraph("Palavra-chave 1")
//		cel = row.getCellByIndex(coluna++);
//		cel.addParagraph("Palavra-chave 2");
//		cel = row.getCellByIndex(coluna++);
//		cel.addParagraph("Palavra-chave 3");
		
		// Segunda em diante
		for(int linha = 0; linha < resultSet.size(); linha++){
			coluna = 0;
			docDTO = (DocumentoDTO) resultSet.get(linha);
			row = tbl.getRowByIndex(linha+1);
			
			cel = row.getCellByIndex(coluna++);
			cel.addParagraph(docDTO.getOrigemDocumento().getTipoOrigem());
			
			cel = row.getCellByIndex(coluna++);
			cel.addParagraph(docDTO.getOrigemDocumento().getCodOrigem());
			
			cel = row.getCellByIndex(coluna++);
			cel.addParagraph(docDTO.getOrigemDocumento().getTitulo());
			
			cel = row.getCellByIndex(coluna++);
			cel.addParagraph(docDTO.getIdNumDocumento().getTipoId());
			
			cel = row.getCellByIndex(coluna++);
			cel.addParagraph(docDTO.getIdNumDocumento().getCodId());
			
			cel = row.getCellByIndex(coluna++);
			cel.addParagraph(docDTO.getAutor());
			
			cel = row.getCellByIndex(coluna++);
			cel.addParagraph(docDTO.getDestinatario());
			
			cel = row.getCellByIndex(coluna++);
			cel.addParagraph(docDTO.getLocal());
			
			cel = row.getCellByIndex(coluna++);
			cel.addParagraph(docDTO.getDataDocumento().toString());
			
			cel = row.getCellByIndex(coluna++);
			cel.addParagraph(docDTO.getTipoDocumento().getTipoDocumento());
			
			cel = row.getCellByIndex(coluna++);
			cel.addParagraph((docDTO.getPalavrasChaves1() != null ? docDTO.getPalavrasChaves1().getPalavra() : " ") 
					+ (docDTO.getPalavrasChaves2() != null ? docDTO.getPalavrasChaves2().getPalavra() : " ") + " - "
					+ (docDTO.getPalavrasChaves3() != null ? docDTO.getPalavrasChaves3().getPalavra() : " "));
			
		}
		String filePath = tmpPath + "/rlt_" + generateRandomString() + "_" + creationDate + ".ods";
		//System.out.println(fileRandomName);
		outerDoc.save(filePath);
		outerDoc.close();
		return filePath;
	}

	public static void main(String[] args) throws Exception {
		getPath();
		System.out.println(tmpPath);
	
		
		List<DTO> lista;
		BuscaDocEJB busca = new BuscaDocEJB();
		lista = busca.busca("CAIXA", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		
		SpreadsheetExport.generateSpreadsheet(lista);
		
	}
	
	private static String generateRandomString() {
		return EJBUtility.genNewRandomPassword(8);
	}

}
