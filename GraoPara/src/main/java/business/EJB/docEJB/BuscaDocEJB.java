package business.EJB.docEJB;

import java.util.List;

import persistence.dto.DTO;
import persistence.dto.DocumentoDTO;
import business.DAO.documents.DocumentDAO;
import business.DAO.login.LoginDAO;
import business.exceptions.documents.DocumentNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

public class BuscaDocEJB {
	
	private DocumentDAO docDao;
	private LoginDAO logDao;
	private static String default_query = "from Documento where ";
	
	public BuscaDocEJB() {
		docDao = new DocumentDAO();
		logDao = new LoginDAO();
	}
	
	public List<DTO> busca(String identificacao, String codigo, String titulo , String tipoAPEP_SEQ, String numAPEP_SEQ, String autor, 
			String destinatario, String local, String data, String tipo, 
			String palavra1, String palavra2, String palavra3) throws UnreachableDataBaseException, DocumentNotFoundException{
		
		boolean continue_query = false;
		String query = new String(default_query);
		
		if(identificacao != null && !identificacao.isEmpty()){
			query += "tipo_origem = '" + identificacao + "'";
			continue_query = true;
		}
		
		if(titulo != null && !titulo.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += "titulo_origem like '%" + titulo + "%'";
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
			query += "tipo_id = '" + tipoAPEP_SEQ + "'";
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
			query += "((palavra_chave_1 like '%" + palavra1.toLowerCase() + "%'" + " and (palavra_chave_1 in (select palavra from PalavraChave where aprovada = TRUE))) ";
			query += "or (palavra_chave_2 like '%" + palavra1.toLowerCase() + "%'" + " and (palavra_chave_2 in (select palavra from PalavraChave where aprovada = TRUE))) ";
			query += "or (palavra_chave_3 like '%" + palavra1.toLowerCase() + "%'"+ " and (palavra_chave_3 in (select palavra from PalavraChave where aprovada = TRUE)))) ";
			continue_query = true;
		}
		
		if(palavra2 != null && !palavra2.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += "((palavra_chave_1 like '%" + palavra2.toLowerCase() + "%'" + " and (palavra_chave_1 in (select palavra from PalavraChave where aprovada = TRUE))) ";
			query += "or (palavra_chave_2 like '%" + palavra2.toLowerCase() + "%'" + " and (palavra_chave_2 in (select palavra from PalavraChave where aprovada = TRUE))) ";
			query += "or (palavra_chave_3 like '%" + palavra2.toLowerCase() + "%'"+ " and (palavra_chave_3 in (select palavra from PalavraChave where aprovada = TRUE)))) ";
			continue_query = true;
		}
		
		if(palavra3 != null && !palavra3.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += "((palavra_chave_1 like '%" + palavra3.toLowerCase() + "%'" + " and (palavra_chave_1 in (select palavra from PalavraChave where aprovada = TRUE))) ";
			query += "or (palavra_chave_2 like '%" + palavra3.toLowerCase() + "%'" + " and (palavra_chave_2 in (select palavra from PalavraChave where aprovada = TRUE))) ";
			query += "or (palavra_chave_3 like '%" + palavra3.toLowerCase() + "%'"+ " and (palavra_chave_3 in (select palavra from PalavraChave where aprovada = TRUE)))) ";
			continue_query = true;
		}
		
		if(query.equals(default_query)) throw new DocumentNotFoundException();
		else {
			query += "order by titulo_origem";
			return docDao.findDocumentByQuery(query);
		}
	}
	
	public DocumentoDTO busca(String tipoAPEP_SEQ, String numAPEP_SEQ) throws UnreachableDataBaseException, DocumentNotFoundException{
		
		boolean continue_query = false;
		String query = new String(default_query);
		
		if(tipoAPEP_SEQ != null && !tipoAPEP_SEQ.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += "tipo_id = '" + tipoAPEP_SEQ + "'";
			continue_query = true;
		}
		
		if(numAPEP_SEQ != null && !numAPEP_SEQ.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += "cod_id = '" + numAPEP_SEQ + "'";
			continue_query = true;
		}
		
		List<DTO> list = docDao.findDocumentByQuery(query);
		if(list == null) throw new DocumentNotFoundException();
		return (DocumentoDTO) list.get(0);
			
	}
	
	public List<DTO> searchByKeyWord(String palavra) throws UnreachableDataBaseException, DocumentNotFoundException{
		
		String query = "from Documento where ";
						
		if(palavra != null && !palavra.isEmpty()){
			query += "(palavra_chave_1 like '%" + palavra.toLowerCase() + "%'";
			query += "or palavra_chave_2 like '%" + palavra.toLowerCase() + "%'";
			query += "or palavra_chave_3 like '%" + palavra.toLowerCase() + "%')";
		}
		
		return docDao.findDocumentByQuery(query);
	}
	
	public List<DTO> searchByYear(String year) throws UnreachableDataBaseException, DocumentNotFoundException{
		
		String query = "from Documento where ";
						
		if(year != null && !year.isEmpty()){
			query += " YEAR(dataDocumento) = " + year;
		}
		
		return docDao.findDocumentByQuery(query);
	}
	
	public Long countRowsByCriteria(String criteria){
		return docDao.countDocumentsByCriteria(criteria);
	}
	
	public List<DTO> buscaPorUsuario(String email) throws UnreachableDataBaseException, DocumentNotFoundException, UserNotFoundException {
		return docDao.findDocumentsByUploader(logDao.findUserByEmail(email));
	}
}
