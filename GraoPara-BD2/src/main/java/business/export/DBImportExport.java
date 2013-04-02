package business.export;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBImportExport {

	private static final String tmp = "/tmp";

	public static String export(){
		
		ProcessBuilder pb;  
		Process p;  
		DateFormat dateFormat;
		Date date;
		String filepath;
		
		dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		date = new Date();
		
		filepath = tmp+"/"+dateFormat.format(date)+".sql";
		pb = new ProcessBuilder("pg_dump ", "-i", "-h", "localhost", "-p", "5432","-U", "coruja_graopara", "-b", "-F", "c", "-v" ,"-f", filepath, "coruja_graopara"); 
		pb.environment().put("PGPASSWORD", "coruja");  
		pb.redirectErrorStream(true);
		
		try {
			p = pb.start();
			p.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return filepath;
	}
	
}
