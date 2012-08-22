package business.EJB.docEJB;

import java.util.List;

import persistence.dto.DTO;
import business.DAO.documents.DocumentDAO;
import business.DAO.documents.DocumentTypeDAO;
import business.DAO.documents.IdNumDocumentoDAO;
import business.DAO.documents.KeyWordDAO;
import business.DAO.documents.OrigemDAO;
import business.DAO.login.LoginDAO;
import business.exceptions.documents.DocumentNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

public class BuscaDocEJB {
	DocumentDAO docDao;
	KeyWordDAO kwDao;
	IdNumDocumentoDAO indDao;
	OrigemDAO origemDao;
	DocumentTypeDAO dtDao;
	LoginDAO logDao;

	public BuscaDocEJB() {
		docDao = new DocumentDAO();
		kwDao = new KeyWordDAO();
		indDao = new IdNumDocumentoDAO();
		origemDao = new OrigemDAO();
		dtDao = new DocumentTypeDAO();
		logDao = new LoginDAO();
	}

	public List<DTO> busca(String identificacao, String codigo, String tipoAPEP_SEQ, String numAPEP_SEQ, String autor, 
			String destinatario, String local, String data, String tipo, 
			String palavra1, String palavra2, String palavra3) throws UnreachableDataBaseException, DocumentNotFoundException{
		
		boolean continue_query = false;
		String query = "from Documento where ";
		
		if(identificacao != null && !identificacao.isEmpty()){
			query += "tipo_origem = '" + identificacao.toUpperCase() + "'";
			continue_query = true;
		}
		
		if(codigo != null && !codigo.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += "cod_origem = '" + codigo + "'";
			continue_query = true;
		}
		
		if(tipoAPEP_SEQ != null && !tipoAPEP_SEQ.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += "tipo_id = '" + tipoAPEP_SEQ.toUpperCase() + "'";
			continue_query = true;
		}
		
		if(numAPEP_SEQ != null && !numAPEP_SEQ.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += "cod_id = '" + numAPEP_SEQ + "'";
			continue_query = true;
		}
		
		if(autor != null && !autor.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += "autor like '%" + autor + "%'";
			continue_query = true;
		}
		
		if(destinatario != null && !destinatario.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += "destinatario like '%" + destinatario + "%'";
			continue_query = true;
		}
		
		if(local != null && !local.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += "local like '%" + local + "%'";
			continue_query = true;
		}
		
		if(data != null && !data.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += "data_documento = '" + data + "'";	// Notação: yyyy-mm-dd
			continue_query = true;
		}
		
		if(tipo != null && !tipo.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += "tipo_documento = '" + tipo + "'";
			continue_query = true;
		}
		
		if(palavra1 != null && !palavra1.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += "(palavra_chave_1 like '%" + palavra1.toLowerCase() + "%'";
			query += "or palavra_chave_2 like '%" + palavra1.toLowerCase() + "%'";
			query += "or palavra_chave_3 like '%" + palavra1.toLowerCase() + "%')";
			continue_query = true;
		}
		
		if(palavra2 != null && !palavra2.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += "(palavra_chave_1 like '%" + palavra2.toLowerCase() + "%'";
			query += "or palavra_chave_2 like '%" + palavra2.toLowerCase() + "%'";
			query += "or palavra_chave_3 like '%" + palavra2.toLowerCase() + "%')";
			continue_query = true;
		}
		
		if(palavra3 != null && !palavra3.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += "(palavra_chave_1 like '%" + palavra3.toLowerCase() + "%'";
			query += "or palavra_chave_2 like '%" + palavra3.toLowerCase() + "%'";
			query += "or palavra_chave_3 like '%" + palavra3.toLowerCase() + "%')";
			continue_query = true;
		}
		
		if(!continue_query) throw new DocumentNotFoundException();
		else return docDao.findDocumentByQuery(query);
	}

	public Long countRowsByCriteria(String criteria) {
		return docDao.countDocumentsByCriteria(criteria);
	}

	public List<DTO> buscaPorUsuario(String email)
			throws UnreachableDataBaseException, DocumentNotFoundException {
		return docDao.findDocumentsByUploader(logDao.findUserByEmail(email));
	}
}
