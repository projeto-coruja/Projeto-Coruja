package webview.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Download
 */
@WebServlet("/Download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Download() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // TODO download!
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		FacesContext context = FacesContext.getCurrentInstance();
		String filePath = null;
		String fileName = null;
		int read = 0;
		byte[] bytes = new byte[1024];
		FileInputStream fis = null;
		OutputStream os = null;

		response = ( HttpServletResponse ) context.getExternalContext().getResponse();
		try {
			filePath = generateSpreadsheet(resultSet);	
			fileName = filePath.split("_")[2];

			response.setContentType("application/ods");
			response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\""); 

			fis = new FileInputStream(new File(filePath,fileName));
			os = response.getOutputStream();

			while((read = fis.read(bytes)) != -1){
				os.write(bytes,0,read);
			}

			os.flush();
			os.close();
		} catch (IOException e){
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		FacesContext.getCurrentInstance().responseComplete();	
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
