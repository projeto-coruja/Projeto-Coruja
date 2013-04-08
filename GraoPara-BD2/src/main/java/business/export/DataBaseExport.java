package business.export;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataBaseExport {

	private static final String tmp = "/tmp";

	public static String export(){
		
		ProcessBuilder pb;  
		Process p;  
		DateFormat dateFormat;
		Date date;
		String filePath;
		List<String> commands = new ArrayList<String>();
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		date = new Date();
		
		filePath = tmp+"/bkp_"+dateFormat.format(date)+".tar";

		commands.add("pg_dump");
		commands.add("-i");
		commands.add("-h");
		commands.add("localhost");
		commands.add("-p");
		commands.add("5432");
		commands.add("-U");
		commands.add("coruja_graopara");
		commands.add("-b");
		commands.add("-F");
		commands.add("c");
		commands.add("-v");
		commands.add("-f");
		commands.add(filePath);
		commands.add("coruja_graopara");
		
		pb = new ProcessBuilder(commands);
		pb.environment().put("PGPASSWORD", "coruja");
		pb.redirectErrorStream(true);
		
		try {
			p = pb.start();

	        StringBuilder out = new StringBuilder();
	        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        String line = null, previous = null;
	        while ((line = br.readLine()) != null){
	            if (!line.equals(previous)) {
	                previous = line;
	                out.append(line).append('\n');
	                System.out.println(line);
	            }
	        }
	        
			p.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return filePath;
	}
	
}
