package business.EJB.documents;

import java.util.List;

import persistence.dto.DTO;
import persistence.dto.Documento;
import persistence.dto.TipoDocumento;
import business.DAO.document.CodiceCaixaDAO;
import business.DAO.document.DocumentoDAO;
import business.DAO.document.PalavraChaveDAO;
import business.DAO.document.TemaPalavraChaveDAO;
import business.DAO.document.TipoDocumentoDAO;
import business.exceptions.documents.DocumentNotFoundException;
import business.exceptions.documents.DocumentTypeNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

public class DocumentEJB {
	
	private final CodiceCaixaDAO codiceCaixaDAO;
	private final TemaPalavraChaveDAO temaDAO;
	private final PalavraChaveDAO keyWordDao;
	private final TipoDocumentoDAO typeDocumentDAO;
	private final DocumentoDAO docDao;
	
	private static String default_query = "from DocumentoMO where ";

	public DocumentEJB() {
		codiceCaixaDAO = new CodiceCaixaDAO();
		temaDAO = new TemaPalavraChaveDAO();
		keyWordDao = new PalavraChaveDAO();
		typeDocumentDAO = new TipoDocumentoDAO();
		docDao = new DocumentoDAO();
	}
	
	public List<DTO> findDocuments(
			String codCodiceCaixa,
			String tituloCodiceCaixa,
			String anoInicioCodiceCaixa,
			String anoFimCodiceCaixa,
			
			String codDocumento,
			
			String autor,
			String ocupacaoAutor,
			
			String destinatario,
			String ocupacaoDestinatario,
			
			String tipoDocumento,
			String local, 
			String resumo,
			String palavraChave1,	String palavraChave2,	String palavraChave3) throws DocumentNotFoundException, UnreachableDataBaseException{
		
		boolean continue_query = false;
		String query = new String(default_query);
		
		if(codCodiceCaixa != null && !codCodiceCaixa.isEmpty()){
			query += " codiceCaixa in (SELECT cod FROM CodiceCaixaMO cod = '" + codCodiceCaixa.trim() + "'";
			continue_query = true;
		}
		
		if(tituloCodiceCaixa != null && !tituloCodiceCaixa.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += " codiceCaixa IN (SELECT titulo FROM CodiceCaixaMO where titulo like '%" + tituloCodiceCaixa + "%') ";
			continue_query = true;
		}
		
		if(anoInicioCodiceCaixa != null && !anoInicioCodiceCaixa.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			if(anoFimCodiceCaixa == null || anoFimCodiceCaixa.isEmpty()){
				query += " codiceCaixa IN (SELECT anoInicio FROM  CodiceCaixaMO " 
						+ "WHERE anoInicio >= " + anoInicioCodiceCaixa + ")";
			}
			else
				query += " codiceCaixa IN "
						+"(SELECT anoInicio FROM  CodiceCaixaMO WHERE anoInicio >= '" + anoInicioCodiceCaixa + "' "
							+"AND anoFim <=" + anoFimCodiceCaixa+" )";
		}
		else{
			if(continue_query == true){
				query += " and ";
			}
			if(anoFimCodiceCaixa != null && !anoFimCodiceCaixa.isEmpty()){
				query += " codiceCaixa IN (SELECT anoInicio FROM  CodiceCaixaMO " 
						+ "WHERE anoFim <= " + anoFimCodiceCaixa + ")";
			}
		}
		
		if(autor != null && !autor.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += " autor IN (SELECT nome FROM AutorMO where nome like '%" + autor + "%')";
			continue_query = true;
		}
		
		if(ocupacaoAutor != null && !ocupacaoAutor.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += " autor IN (SELECT ocupacao FROM AutorMO where ocupacao like '%" + ocupacaoAutor + "%')";
			continue_query = true;
		}

		if(destinatario != null && !destinatario.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += " destinatario IN (SELECT nome FROM AutorMO where nome like '%" + destinatario + "%')";
			continue_query = true;
		}
		
		if(ocupacaoDestinatario != null && !ocupacaoDestinatario.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += " destinatario IN (SELECT ocupacao FROM AutorMO where ocupacao like '%" + ocupacaoDestinatario + "%')";
			continue_query = true;
		}
		
		if(local != null && !local.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += " local like '%" + local + "%'";
			continue_query = true;
		}
		
		if(resumo != null && !resumo.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += " resumo like '%" + resumo + "%'";
			continue_query = true;
		}
		
		if(palavraChave1 != null && !palavraChave1.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += "(palavra_chave_1 like '%" + palavraChave1 + "%'";
			query += "or palavra_chave_2 like '%" + palavraChave1 + "%'";
			query += "or palavra_chave_3 like '%" + palavraChave1 + "%')";
			continue_query = true;
		}

		if(palavraChave2 != null && !palavraChave2.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += "(palavra_chave_1 like '%" + palavraChave2 + "%'";
			query += "or palavra_chave_2 like '%" + palavraChave2 + "%'";
			query += "or palavra_chave_3 like '%" + palavraChave2 + "%')";
			continue_query = true;
		}

		if(palavraChave3 != null && !palavraChave3.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += "(palavra_chave_1 like '%" + palavraChave3 + "%'";
			query += "or palavra_chave_2 like '%" + palavraChave3 + "%'";
			query += "or palavra_chave_3 like '%" + palavraChave3 + "%')";
			continue_query = true;
		}
		
		if(query.equals(default_query)) {
			query = " FROM DocumentoMO ";
		}
		
		query += " order by cod, titulo ";
		return docDao.findDocumentByQuery(query);
	}
	
	public List<DTO> findByDocumentType(String type) throws UnreachableDataBaseException, DocumentNotFoundException{

		String query = new String(default_query);

		query += "tipoDocumento in (SELECT nome FROM TipoDocumentoMO where nome like '%" + type + "%')";

		List<DTO> list = docDao.findDocumentByQuery(query);
		if(list == null) throw new DocumentNotFoundException();
		return list;
	}
	
	public List<DTO> findByCodiceCaixa(String codCodiceCaixa) throws UnreachableDataBaseException, DocumentNotFoundException{

		String query = new String(default_query);

		query += "codiceCaixa in (SELECT cod FROM CodiceCaixaMO where cod = '" + codCodiceCaixa + "')";

		List<DTO> list = docDao.findDocumentByQuery(query);
		if(list == null) throw new DocumentNotFoundException();
		return list;
	}

}
