package business.export;

import java.awt.Font;
import java.awt.FontMetrics;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Column;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;

import persistence.dto.Autor;
import persistence.dto.CodiceCaixa;
import persistence.dto.DTO;
import persistence.dto.Documento;
import persistence.dto.PalavraChave;
import persistence.dto.Profile;
import persistence.dto.TemaPalavraChave;
import persistence.dto.TipoDocumento;
import persistence.dto.UserAccount;
import business.EJB.util.EJBUtility;

public class SpreadsheetExport {
	
	private static String tmpPath;
	
	private static void getPath(){
		// Para testes locais
//		tmpPath = SpreadsheetExport.class.getResource("SpreadsheetExport.class").getPath();
//		tmpPath = tmpPath.replace("/GraoPara.war/WEB-INF/classes/business/export/SpreadsheetExport.class", "/ods");
		
		tmpPath = "/tmp"; // Jboss
		
//		System.out.println(tmpPath);
	}
	
	private static double getStringWidth(String s){
		FontMetrics metrics = new FontMetrics(new Font("Arial",Font.PLAIN,10)) {
			private static final long serialVersionUID = 1L;
		};
		double width = 0;
		
		for(int i = 0; i < s.length(); i++){
			width += metrics.charWidth(s.charAt(i));
		}
		
		return (double) (0.264583 * width);
	}
	
	public static String generateSpreadsheet(List<DTO> resultSet) throws Exception{
		
		SpreadsheetDocument outerDoc = SpreadsheetDocument.newSpreadsheetDocument();
		String creationDate = new SimpleDateFormat("dd-MM-YYYY").format(new Date());
		Documento docDTO = null;
		Table tbl = outerDoc.getSheetByIndex(0);
		Row row = tbl.appendRow();
		Column column = tbl.appendColumn();
		Cell cel = row.getCellByIndex(0);
		int coluna;
		String tmp;
		
		getPath();
		
		// Primeira linha
		coluna = 0;
		row = tbl.getRowByIndex(0);

		tmp = "Código da Caixa/Códice";
		column = tbl.getColumnByIndex(coluna);
		column.setWidth(getStringWidth(tmp));
		cel = row.getCellByIndex(coluna++);
		cel.addParagraph(tmp);
		
		tmp = "Título da Caixa/Códice";
		column = tbl.getColumnByIndex(coluna);
		column.setWidth(getStringWidth(tmp));
		cel = row.getCellByIndex(coluna++);
		cel.addParagraph(tmp);
		
		tmp = "Código do documento";
		column = tbl.getColumnByIndex(coluna);
		column.setWidth(getStringWidth(tmp));
		cel = row.getCellByIndex(coluna++);
		cel.addParagraph(tmp);

		tmp = "Título do documento";
		column = tbl.getColumnByIndex(coluna);
		column.setWidth(getStringWidth(tmp));
		cel = row.getCellByIndex(coluna++);
		cel.addParagraph(tmp);

		tmp = "Tipo de Documento";
		column = tbl.getColumnByIndex(coluna);
		column.setWidth(getStringWidth(tmp));
		cel = row.getCellByIndex(coluna++);
		cel.addParagraph(tmp);
		
		tmp = "Autor";
		column = tbl.getColumnByIndex(coluna);
		column.setWidth(getStringWidth(tmp));
		cel = row.getCellByIndex(coluna++);
		cel.addParagraph(tmp);

		tmp = "Ocupação do autor";
		column = tbl.getColumnByIndex(coluna);
		column.setWidth(getStringWidth(tmp));
		cel = row.getCellByIndex(coluna++);
		cel.addParagraph(tmp);
		
		tmp = "Destinatário";
		column = tbl.getColumnByIndex(coluna);
		column.setWidth(getStringWidth(tmp));
		cel = row.getCellByIndex(coluna++);
		cel.addParagraph(tmp);

		tmp = "Ocupação do destinatário";
		column = tbl.getColumnByIndex(coluna);
		column.setWidth(getStringWidth(tmp));
		cel = row.getCellByIndex(coluna++);
		cel.addParagraph(tmp);
		
		tmp = "Local";
		column = tbl.getColumnByIndex(coluna);
		column.setWidth(getStringWidth(tmp));
		cel = row.getCellByIndex(coluna++);
		cel.addParagraph(tmp);
		
		tmp = "Data";
		column = tbl.getColumnByIndex(coluna);
		column.setWidth(getStringWidth(tmp));
		cel = row.getCellByIndex(coluna++);
		cel.addParagraph(tmp);
		
		tmp = "Palavra Chaves";
		column = tbl.getColumnByIndex(coluna);
		column.setWidth(getStringWidth(tmp));
		cel = row.getCellByIndex(coluna++);
		cel.addParagraph(tmp);
		
		tmp = "Resumo";
		column = tbl.getColumnByIndex(coluna);
		column.setWidth(getStringWidth(tmp));
		cel = row.getCellByIndex(coluna++);
		cel.addParagraph(tmp);
		
		// Segunda em diante
		for(int linha = 0; linha < resultSet.size(); linha++){
			coluna = 0;
			docDTO = (Documento) resultSet.get(linha);
			row = tbl.getRowByIndex(linha+1);
			
			tmp = docDTO.getCodiceCaixa().getCod();
			column = tbl.getColumnByIndex(coluna);
			if(getStringWidth(tmp) > column.getWidth())	column.setWidth(getStringWidth(tmp));
			cel = row.getCellByIndex(coluna++);
			cel.setDisplayText(tmp);
			
			tmp = docDTO.getCodiceCaixa().getTitulo();
			column = tbl.getColumnByIndex(coluna);
			if(getStringWidth(tmp) > column.getWidth())	column.setWidth(getStringWidth(tmp));
			cel = row.getCellByIndex(coluna++);
			cel.setDisplayText(tmp);

			tmp = docDTO.getCod();
			column = tbl.getColumnByIndex(coluna);
			if(getStringWidth(tmp) > column.getWidth())	column.setWidth(getStringWidth(tmp));
			cel = row.getCellByIndex(coluna++);
			cel.setDisplayText(tmp);
			
			tmp = docDTO.getTitulo();
			column = tbl.getColumnByIndex(coluna);
			if(getStringWidth(tmp) > column.getWidth())	column.setWidth(getStringWidth(tmp));
			cel = row.getCellByIndex(coluna++);
			cel.setDisplayText(tmp);
			
			tmp = docDTO.getTipoDocumento().getNome();
			column = tbl.getColumnByIndex(coluna);
			if(getStringWidth(tmp) > column.getWidth())	column.setWidth(getStringWidth(tmp));
			cel = row.getCellByIndex(coluna++);
			cel.setDisplayText(tmp);

			tmp = docDTO.getAutor().getNome();
			column = tbl.getColumnByIndex(coluna);
			if(getStringWidth(tmp) > column.getWidth())	column.setWidth(getStringWidth(tmp));
			cel = row.getCellByIndex(coluna++);
			cel.setDisplayText(tmp);

			tmp = docDTO.getAutor().getOcupacao();
			column = tbl.getColumnByIndex(coluna);
			if(getStringWidth(tmp) > column.getWidth())	column.setWidth(getStringWidth(tmp));
			cel = row.getCellByIndex(coluna++);
			cel.setDisplayText(tmp);
			
			tmp = docDTO.getDestinatario().getNome();
			column = tbl.getColumnByIndex(coluna);
			if(getStringWidth(tmp) > column.getWidth())	column.setWidth(getStringWidth(tmp));
			cel = row.getCellByIndex(coluna++);
			cel.setDisplayText(tmp);

			tmp = docDTO.getDestinatario().getOcupacao();
			column = tbl.getColumnByIndex(coluna);
			if(getStringWidth(tmp) > column.getWidth())	column.setWidth(getStringWidth(tmp));
			cel = row.getCellByIndex(coluna++);
			cel.setDisplayText(tmp);
			
			tmp = docDTO.getLocal();
			column = tbl.getColumnByIndex(coluna);
			if(getStringWidth(tmp) > column.getWidth())	column.setWidth(getStringWidth(tmp));
			cel = row.getCellByIndex(coluna++);
			cel.setDisplayText(tmp);
			
			tmp = docDTO.getData().toString();
			column = tbl.getColumnByIndex(coluna);
			if(getStringWidth(tmp) > column.getWidth())	column.setWidth(getStringWidth(tmp));
			cel = row.getCellByIndex(coluna++);
			cel.setDisplayText(tmp);
			
			tmp = (docDTO.getPalavraChave1() != null ? docDTO.getPalavraChave1().getPalavra() : " ")
					+ (docDTO.getPalavraChave2() != null ? " - " + docDTO.getPalavraChave2().getPalavra() : " ")
					+ (docDTO.getPalavraChave3() != null ? " - " + docDTO.getPalavraChave3().getPalavra() : " ");
			column = tbl.getColumnByIndex(coluna);
			if(getStringWidth(tmp) > column.getWidth())	column.setWidth(getStringWidth(tmp));
			cel = row.getCellByIndex(coluna++);
			cel.setDisplayText(tmp);
			
			tmp = docDTO.getResumo();
			column = tbl.getColumnByIndex(coluna);
			if(getStringWidth(tmp) > column.getWidth())	column.setWidth(getStringWidth(tmp));
			cel = row.getCellByIndex(coluna++);
			cel.setDisplayText(tmp);
		}
		
		
		String filePath = tmpPath + "/rlt_" + EJBUtility.genRandomString(8) + "_" + creationDate + ".ods";
		System.out.println(filePath);
		outerDoc.save(filePath);
		outerDoc.close();
		return filePath;
	}

	public static void main(String[] args) throws Exception {
		getPath();
		System.out.println(tmpPath);
	
		
		List<DTO> lista = new ArrayList<DTO>();
//		DocumentEJB busca = new DocumentEJB();
//		lista = busca.findByKeyWord("gato");
		
		lista.add(new Documento("123","teste","local","resumo",
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
		
	}

}
