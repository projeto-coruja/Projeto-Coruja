package webview.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class AlertsUtility {
	
	public static void alertAndRedirectPage(HttpServletResponse response, String alert, String jsp_Page) throws IOException{
		response.setContentType("text/html; charset=UTF-8");  
	    PrintWriter out=response.getWriter();   
		out.println("<script>");  
	    out.println("alert('" + alert + "');");  
	    out.println("window.location.replace('" + jsp_Page + "');");  
	    out.println("</script>");
	}
	
	public static void alertOnly(HttpServletResponse response, String alert) throws IOException{
		response.setContentType("text/html; charset=UTF-8");  
	    PrintWriter out=response.getWriter();   
		out.println("<script>");  
	    out.println("alert('" + alert + "');");  
	    out.println("</script>");
	}
	
	public static void alertAndRedirectHistory(HttpServletResponse response, String alert) throws IOException{
		response.setContentType("text/html; charset=UTF-8");  
	    PrintWriter out=response.getWriter();   
		out.println("<script>");  
	    out.println("alert('" + alert + "');");  
	    out.println("history.go(-1);");  
	    out.println("</script>");
	}
	
	public static void redirectOnly(HttpServletResponse response, String jsp_Page) throws IOException{
		response.setContentType("text/html; charset=UTF-8");  
	    PrintWriter out=response.getWriter();   
		out.println("<script>");  
	    out.println("window.location.replace('" + jsp_Page + "');");  
	    out.println("</script>");
	}

}
