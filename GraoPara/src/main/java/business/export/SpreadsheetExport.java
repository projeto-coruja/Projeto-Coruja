package business.export;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.TextDocument;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Column;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;

import business.EJB.util.EJBUtility;
import persistence.dto.DTO;

public class SpreadsheetExport {
	
	private static final String tmpPath = "/home/hueho/tmpcoruja";
	
	public static void generateSpreadsheet(List<DTO> resultSet, String toYear, String fromYear, String toOrigin, String fromOrigin, String typeOrigin) throws Exception{
		SpreadsheetDocument outerDoc = SpreadsheetDocument.newSpreadsheetDocument();
		String creationDate = new SimpleDateFormat("dd-MM-YYYY").format(new Date());
		
		Table tbl = outerDoc.getSheetByIndex(0);
		Row row = tbl.appendRow();
		Cell cel = row.getCellByIndex(0);
		for(int i = 0; i < 10; i++) {
			cel = row.getCellByIndex(i);
			cel.addParagraph("TESTE: " + i);
		}
		
		outerDoc.save(tmpPath + "/rlt_" + generateRandomString() + "_" + creationDate + ".ods");
		outerDoc.close();
	}
	
	public static void main(String[] args) throws Exception {
		SpreadsheetExport.generateSpreadsheet(null, null, null, null, null, null);
	}
	
	private static String generateRandomString() {
		return EJBUtility.genNewRandomPassword(8);
	}

}
