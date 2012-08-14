package business.EJB.docEJB;

import business.DAO.documents.DocumentDAO;
import business.DAO.documents.DocumentTypeDAO;
import business.DAO.documents.IdNumDocumentoDAO;
import business.DAO.documents.KeyWordDAO;
import business.DAO.documents.OrigemDAO;

public class BuscaDocEJB {
	DocumentDAO docDao;
	KeyWordDAO kwDao;
	IdNumDocumentoDAO indDao;
	OrigemDAO origemDao;
	DocumentTypeDAO dtDao;
	
	public BuscaDocEJB() {
		docDao = new DocumentDAO();
		kwDao = new KeyWordDAO();
		indDao = new IdNumDocumentoDAO();
		origemDao = new OrigemDAO();
		dtDao = new DocumentTypeDAO();
	}
	
	public void busca(String identificacao, String codigo, String tipoAPEP_SEQ, String numAPEP_SEQ, String autor, 
			String destinatario, String estado,	String cidade, String data, String tipo, 
			String palavra1, String palavra2, String palavra3){
		
		boolean lala = false;
		String query = "select * from tbl_documentos where";
		
		if(!(identificacao == null && identificacao.isEmpty())){
			query += "tipo_origem = " + identificacao;
			lala = true;
		}
		
		if(!(codigo == null && codigo.isEmpty())){
			if(lala == true){
				query += " and ";
			}
			query += "cod_origem = " + codigo;
			lala = true;
		}
		
		if(!(tipoAPEP_SEQ == null && tipoAPEP_SEQ.isEmpty())){
			if(lala == true){
				query += " and ";
			}
			query += "tipo_id = " + tipoAPEP_SEQ;
			lala = true;
		}
		
		if(!(numAPEP_SEQ == null && numAPEP_SEQ.isEmpty())){
			if(lala == true){
				query += " and ";
			}
			query += "num_id = " + numAPEP_SEQ;
			lala = true;
		}
		
		if(!(autor == null && autor.isEmpty())){
			if(lala == true){
				query += " and ";
			}
			query += "autor = " + autor;
			lala = true;
		}
		
		if(!(destinatario == null && destinatario.isEmpty())){
			if(lala == true){
				query += " and ";
			}
			query += "destinatario = " + destinatario;
			lala = true;
		}
		
		if(!(estado == null && estado.isEmpty()) || !(cidade == null && cidade.isEmpty())){
			if(lala == true){
				query += " and ";
			}
			query += "local like '%" + cidade + " - " + estado +"%'";
			lala = true;
		}
		
		if(!(data == null && data.isEmpty())){
			if(lala == true){
				query += " and ";
			}
			query += "data_documento = " + data;	//TODO: Verificar padrão de data do java Calendar()
			lala = true;
		}
		
		if(!(tipo == null && tipo.isEmpty())){
			if(lala == true){
				query += " and ";
			}
			query += "tipo_documento = " + tipo;
			lala = true;
		}
		
		if(!(palavra1 == null && palavra1.isEmpty())){
			if(lala == true){
				query += " and ";
			}
			query += "palavra_chave_1 = " + palavra1;
			lala = true;
		}
		
		if(!(palavra2 == null && palavra2.isEmpty())){
			if(lala == true){
				query += " and ";
			}
			query += "palavra_chave_2 = " + palavra2;
			lala = true;
		}
		
		if(!(palavra3 == null && palavra3.isEmpty())){
			if(lala == true){
				query += " and ";
			}
			query += "palavra_chave_3 = " + palavra3;
			lala = true;
		}
	}
}
