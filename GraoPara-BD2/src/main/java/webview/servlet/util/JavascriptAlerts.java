package webview.servlet.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class JavascriptAlerts {
	
	public static void alertAndRedirectPage(HttpServletResponse response, String alert, String jsp_Page) throws IOException{
		response.setContentType("text/html");  
	    PrintWriter out=response.getWriter();   
		out.println("<script>");  
	    out.println("alert('" + alert + "');");  
	    out.println("document.location=('" + jsp_Page + "');");  
	    out.println("</script>");
	}
	
	public static void alertAndRedirectPage(HttpServletResponse response, String alert) throws IOException{
		response.setContentType("text/html");  
	    PrintWriter out=response.getWriter();   
		out.println("<script>");  
	    out.println("alert('" + alert + "');");  
	    out.println("</script>");
	}
	
	public static void alertAndRedirectHistory(HttpServletResponse response, String alert) throws IOException{
		response.setContentType("text/html");  
	    PrintWriter out=response.getWriter();   
		out.println("<script>");  
	    out.println("alert('" + alert + "');");  
	    out.println("history.go(-1);");  
	    out.println("</script>");
	}

}
