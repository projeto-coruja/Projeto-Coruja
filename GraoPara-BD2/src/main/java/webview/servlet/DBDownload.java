package webview.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.export.DataBaseExport;

@WebServlet("/protected/admin/doDBDownload")
public class DBDownload extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2283206223781592920L;
	
	public DBDownload(){
		super();
	}
	
	protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		FileInputStream in = null;
		OutputStream out = null;
		File f = null;
		
		String filePath =  DataBaseExport.export();
		
		try {
			f = new File(filePath);
			response.setHeader("Content-Disposition", "attachment;filename=\""+ filePath.split("/")[2] +"\"");
			response.setContentLength((int) f.length());
			response.setContentType("application/x-tar");
			in = new FileInputStream(f);
			out = response.getOutputStream();
			int read = 0;
			byte[] bytes = new byte[1024];
			while((read = in.read(bytes)) != -1){
				out.write(bytes,0,read);
			}
			in.close();
			out.flush();
			out.close();
			f.delete();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
		

}
