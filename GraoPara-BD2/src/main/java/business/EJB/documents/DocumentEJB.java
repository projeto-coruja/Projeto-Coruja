package business.EJB.documents;

import java.util.Date;
import java.util.List;

import persistence.dto.Autor;
import persistence.dto.CodiceCaixa;
import persistence.dto.DTO;
import persistence.dto.Documento;
import persistence.dto.PalavraChave;
import persistence.dto.TipoDocumento;
import persistence.dto.UserAccount;
import persistence.exceptions.UpdateEntityException;
import business.DAO.document.AutorDAO;
import business.DAO.document.CodiceCaixaDAO;
import business.DAO.document.DocumentoDAO;
import business.DAO.document.PalavraChaveDAO;
import business.DAO.document.TipoDocumentoDAO;
import business.exceptions.documents.AuthorNotFoundException;
import business.exceptions.documents.CodiceCaixaNotFoundException;
import business.exceptions.documents.DocumentNotFoundException;
import business.exceptions.documents.DocumentTypeNotFoundException;
import business.exceptions.documents.DuplicateCodiceCaixaException;
import business.exceptions.documents.DuplicatedAuthorException;
import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

public class DocumentEJB {
	
	private final DocumentoDAO docDao;
	
	private static String default_query = "from DocumentoMO where ";

	public DocumentEJB() {
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
			if(anoFimCodiceCaixa != null && !anoFimCodiceCaixa.isEmpty()){
				if(continue_query == true){
					query += " and ";
				}
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
		
		if(codDocumento != null && !codDocumento.isEmpty()){
			if(continue_query == true){
				query += " and ";
			}
			query += " cod like '%" + codDocumento + "%'";
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
	
	public void registerNewDocument(
			// Documento
			String tituloDocumento,
			String codDocumento,
			String local,
			String resumo,
			UserAccount uploader,
			// Códice e caixa
			String codCodiceCaixa,
			String tituloCodiceCaixa,
			String anoInicioCodiceCaixa,
			String anoFimCodiceCaixa,
			// Autor documento
			String autor,
			String ocupacaoAutor,
			// Destinatário (AutorMO)
			String destinatario,
			String ocupacaoDestinatario,
			// Tipo Documento
			String tipoDocumento,
			String descricaoDoTipoDocumento,
			// Palavra chave 1
			String palavraChave1,
			String temaPalavraChave1,
			// Palavra chave 2
			String palavraChave2,
			String temaPalavraChave2,
			// Palavra chave 3
			String palavraChave3,
			String temaPalavraChave3) throws UnreachableDataBaseException{

		List<DTO> check;
		CodiceCaixaDAO codiceCaixaDAO = new CodiceCaixaDAO();
		TipoDocumentoDAO tipoDocumentoDAO = new TipoDocumentoDAO();
		PalavraChaveDAO palavraChaveDAO = new PalavraChaveDAO();
		AutorDAO autorDAO = new AutorDAO();
		
		Documento newDoc;
		CodiceCaixa codCaixa = null;
		PalavraChave[] palavraChave = new PalavraChave[3];
		TipoDocumento tipoDoc = null;
		Autor author = null;
		Autor addressee = null;
		
		// Verificação de existência da origem do documento no banco
		try {
			codCaixa = codiceCaixaDAO.findExactCodiceCaixa(codCodiceCaixa, tituloCodiceCaixa);
		} catch (CodiceCaixaNotFoundException e1) {
			try {
				codCaixa = codiceCaixaDAO.addCodiceCaixa(
								codCodiceCaixa, 
								tituloCodiceCaixa, 
								Integer.parseInt(anoInicioCodiceCaixa), 
								Integer.parseInt(anoFimCodiceCaixa)	);
			} catch (DuplicateCodiceCaixaException e) {
				e.printStackTrace();
			}
		}

		// Verificação de existência do tipo de documento no banco
		try {
			check = tipoDocumentoDAO.findDocumentTypeByString(tipoDocumento);
			for(DTO dto : check){
				if(((TipoDocumento) dto).getNome().equals(tipoDocumento))
					tipoDoc = (TipoDocumento) dto;
			}
		} catch (DocumentTypeNotFoundException e1) {	
			tipoDoc = tipoDocumentoDAO.addDocumentType(tipoDocumento, descricaoDoTipoDocumento);
		}
		
		// Verificação de existência das palavras chaves documento no banco
		if(palavraChave1 != null && !palavraChave1.isEmpty())
		{	
			try {
				check = palavraChaveDAO.findKeyWordByString(palavraChave1);
				for(DTO dto : check){
					if(((PalavraChave) dto).getPalavra().equals(palavraChave1))
						palavraChave[0] = (PalavraChave) dto;
				}
			} catch (KeywordNotFoundException e1) {
				palavraChave[0] = palavraChaveDAO.addKeyWord(
								palavraChave1,
								temaPalavraChave1
								);
			}
		}

		if(palavraChave2 != null && !palavraChave2.isEmpty())
		{
			try {
				check = palavraChaveDAO.findKeyWordByString(palavraChave2);
				for(DTO dto : check){
					if(((PalavraChave) dto).getPalavra().equals(palavraChave2))
						palavraChave[1] = (PalavraChave) dto;
				}
			} catch (KeywordNotFoundException e1) {
				palavraChave[1] = palavraChaveDAO.addKeyWord(
								palavraChave2,
								temaPalavraChave2
								);
			}
		}

		if(palavraChave3 != null && !palavraChave3.isEmpty())
		{
			try {
				check = palavraChaveDAO.findKeyWordByString(palavraChave3);
				for(DTO dto : check){
					if(((PalavraChave) dto).getPalavra().equals(palavraChave3))
						palavraChave[2] = (PalavraChave) dto;
				}
			} catch (KeywordNotFoundException e1) {
				palavraChave[2] = palavraChaveDAO.addKeyWord(
								palavraChave3,
								temaPalavraChave3
								);
			}
		}
		
		if(autor != null && !autor.isEmpty()){
			if(ocupacaoAutor.isEmpty())	ocupacaoAutor = null;
			try{
				author = autorDAO.findAuthorByNameAndOccupation(autor, ocupacaoAutor);
			} catch (AuthorNotFoundException e){
				try {
					author = autorDAO.addAutor(autor, ocupacaoAutor);
				} catch (DuplicatedAuthorException e1) {
					e1.printStackTrace();
				}
			}
		}
		else author = null;
		
		if(destinatario != null && !destinatario.isEmpty()){
			if(ocupacaoDestinatario.isEmpty())	ocupacaoDestinatario = null;
			try{
				addressee = autorDAO.findAuthorByNameAndOccupation(destinatario, ocupacaoDestinatario);
			} catch (AuthorNotFoundException e){
				try {
					addressee = autorDAO.addAutor(destinatario, ocupacaoDestinatario);
				} catch (DuplicatedAuthorException e1) {
					e1.printStackTrace();
				}
			}
		}
		else addressee = null;
		
		newDoc = new Documento(codDocumento, tituloDocumento, local, resumo, 
				codCaixa, tipoDoc, author, addressee, 
				palavraChave[0], palavraChave[1], palavraChave[2], uploader, new Date());
		docDao.addDocument(newDoc);
	}
	
	public void modifyDocument(Documento document) throws IllegalArgumentException, UnreachableDataBaseException, UpdateEntityException{
		docDao.updateDocument(document);
		
	}
	
	public Documento findSingleDocument(String code) throws DocumentNotFoundException, UnreachableDataBaseException, IllegalArgumentException{
		if(code == null || code.isEmpty()) throw new IllegalArgumentException("Code is empty");
		String query = default_query;
		query += " cod = '" + code + "'";
		List<DTO> resultSet = docDao.findDocumentByQuery(query);
		for(DTO dto : resultSet){
			if(((Documento)dto).getCod().equals(code))	return (Documento) dto;
		}
		throw new DocumentNotFoundException("Documento não encontrado");
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
	
	public List<DTO> findByKeyWord(String keyWord) throws UnreachableDataBaseException, DocumentNotFoundException{

		String query = new String(default_query);

		query += "palavraChave1 in (SELECT palavra FROM PalavraChaveMO where palavra = '" + keyWord + "') OR "
				+ "palavraChave2 in (SELECT palavra FROM PalavraChaveMO where palavra = '" + keyWord + "') OR "
				+ "palavraChave3 in (SELECT palavra FROM PalavraChaveMO where palavra = '" + keyWord + "')";

		List<DTO> list = docDao.findDocumentByQuery(query);
		if(list == null) throw new DocumentNotFoundException();
		return list;
	}
	
}
