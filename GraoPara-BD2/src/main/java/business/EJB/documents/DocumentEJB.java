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
import business.exceptions.documents.DuplicatedAuthorException;
import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

public class DocumentEJB {
	
	private final DocumentoDAO docDao;
	
	private static String default_query = "FROM DocumentoMO WHERE ";

	public DocumentEJB() {
		docDao = new DocumentoDAO();
	}
	
	public List<DTO> findDocuments(
			String tipoCodiceCaixa,
			String codCodiceCaixaDe,
			String codCodiceCaixaAte,
			String tituloCodiceCaixa,
			String anoInicioCodiceCaixa,
			String anoFimCodiceCaixa,
			
			String tipoCodDocumento,
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
		
		/*if(codCodiceCaixaDe != null && !codCodiceCaixaDe.isEmpty()){
			String codCdCxDe = tipoCodiceCaixa+"-"+codCodiceCaixaDe;
			if(codCodiceCaixaAte != null && !codCodiceCaixaAte.isEmpty()) {
				String codCdCxAte = tipoCodiceCaixa+"-"+codCodiceCaixaAte;
				query += " codiceCaixa.cod BETWEEN '" + codCdCxDe.trim() + "' AND '" + codCdCxAte.trim() + "'";
			}
			else query += " codiceCaixa.cod = '" + codCdCxDe.trim() + "'";
			continue_query = true;
		}*/

		// Eu não faço a mínima idéia do que eu escrevi nas próximas 40 linha... Então se alguem quiser revisar aí, a vontade...
		// TODO: Verificar(?) se faz algum sentido!
		if(codCodiceCaixaDe != null && !codCodiceCaixaDe.isEmpty()){ 
			if(codCodiceCaixaAte != null && !codCodiceCaixaAte.isEmpty()) {
				if(tipoCodiceCaixa != null && !tipoCodiceCaixa.isEmpty()){
					query += " codiceCaixa.cod BETWEEN '" + (tipoCodiceCaixa+"-"+codCodiceCaixaDe).trim()  + "'"  + 
							" AND '" + (tipoCodiceCaixa+"-"+codCodiceCaixaAte).trim() + "'";
				}
				else{
					query += " codiceCaixa.cod BETWEEN '" + ("CODICE-"+codCodiceCaixaDe).trim() + "'" + 
							" AND '" + ("CODICE-"+codCodiceCaixaAte).trim() + "'" + 
							" AND codiceCaixa.cod BETWEEN '" + ("CAIXA-"+codCodiceCaixaDe).trim() + "'"  + 
							" AND '" + ("CAIXA-"+codCodiceCaixaAte).trim() + "'";
				}
				continue_query = true;
			}
			else{
				if(tipoCodiceCaixa != null && !tipoCodiceCaixa.isEmpty()){
					query += " codiceCaixa.cod >= '" + (tipoCodiceCaixa+"-"+codCodiceCaixaDe).trim() + "'" +
							(tipoCodiceCaixa.equals("CAIXA") ? " AND codiceCaixa.cod < 'CODICE-%'" : "");
				}
				else{
					query += " (codiceCaixa.cod >= '" + ("CAIXA-"+codCodiceCaixaDe).trim() + "' AND codiceCaixa.cod < 'CODICE-%')" +
							" OR codiceCaixa.cod >= '" + ("CODICE-"+codCodiceCaixaDe).trim() + "'";
				}
				continue_query = true;
			}
		}
		else if(codCodiceCaixaAte != null && !codCodiceCaixaAte.isEmpty()) {
			if(tipoCodiceCaixa != null && !tipoCodiceCaixa.isEmpty()){
				query += " codiceCaixa.cod <= '" + (tipoCodiceCaixa+"-"+codCodiceCaixaAte).trim() + "'" +
						(tipoCodiceCaixa.equals("CODICE") ? " AND codiceCaixa.cod > 'CAIXA-%'" : "");
			}
			else{
				query += " codiceCaixa.cod <= '" + ("CAIXA-"+codCodiceCaixaAte).trim() + "'" +
						" OR (codiceCaixa.cod <= '" + ("CODICE-"+codCodiceCaixaAte).trim() + "' AND codiceCaixa.cod > 'CAIXA-%'";
			}
			continue_query = true;
		}
		else if(tipoCodiceCaixa != null && !tipoCodiceCaixa.isEmpty()){
			query += " codiceCaixa.cod LIKE '" + tipoCodiceCaixa + "%'";
			continue_query = true;
		}
		// Fim do código que eu escrevi sem ter a mínima idéia do que eu fiz...
		
		if(tituloCodiceCaixa != null && !tituloCodiceCaixa.isEmpty()){
			if(continue_query == true){
				query += " AND ";
			}
			query += " codiceCaixa.titulo LIKE '%" + tituloCodiceCaixa + "%'";
			continue_query = true;
		}
		
		if(anoInicioCodiceCaixa != null && !anoInicioCodiceCaixa.isEmpty()){
			if(continue_query == true){
				query += " AND ";
			}
			if(anoFimCodiceCaixa == null || anoFimCodiceCaixa.isEmpty()){
				query += " codiceCaixa.anoInicio >= " + anoInicioCodiceCaixa;
			}
			else
				query += " codiceCaixa.anoInicio >= '" + anoInicioCodiceCaixa + "' "
							+"AND codiceCaixa.anoFim <=" + anoFimCodiceCaixa;
		}
		else{
			if(anoFimCodiceCaixa != null && !anoFimCodiceCaixa.isEmpty()){
				if(continue_query == true){
					query += " AND ";
				}
				query += " codiceCaixa.anoFim <= " + anoFimCodiceCaixa;
			}
		}
		
		if(autor != null && !autor.isEmpty()){
			if(continue_query == true){
				query += " AND ";
			}
			query += " autor.nome LIKE '%" + autor + "%'";
			continue_query = true;
		}
		
		if(ocupacaoAutor != null && !ocupacaoAutor.isEmpty()){
			if(continue_query == true){
				query += " AND ";
			}
			query += " autor.ocupacao LIKE '%" + ocupacaoAutor + "%'";
			continue_query = true;
		}

		if(destinatario != null && !destinatario.isEmpty()){
			if(continue_query == true){
				query += " AND ";
			}
			query += " destinatario.nome LIKE '%" + destinatario + "%'";
			continue_query = true;
		}
		
		if(ocupacaoDestinatario != null && !ocupacaoDestinatario.isEmpty()){
			if(continue_query == true){
				query += " AND ";
			}
			query += " destinatario.ocupacao LIKE '%" + ocupacaoDestinatario + "%'";
			continue_query = true;
		}
		
		if(codDocumento != null && !codDocumento.isEmpty()){
			if(continue_query == true){
				query += " AND ";
			}
			query += " cod LIKE '%" + (tipoCodDocumento != null && !tipoCodDocumento.isEmpty() ? tipoCodDocumento + "-" : "") + codDocumento + "%'";
			continue_query = true;
		}
		
		if(local != null && !local.isEmpty()){
			if(continue_query == true){
				query += " AND ";
			}
			query += " local LIKE '%" + local + "%'";
			continue_query = true;
		}
		
		if(resumo != null && !resumo.isEmpty()){
			if(continue_query == true){
				query += " AND ";
			}
			query += " resumo LIKE '%" + resumo + "%'";
			continue_query = true;
		}
		
		if(palavraChave1 != null && !palavraChave1.isEmpty()){
			if(continue_query == true){
				query += " AND ";
			}
			query += "(palavraChave1.palavra LIKE '%" + palavraChave1 + "%'";
			query += "OR palavraChave2.palavra LIKE '%" + palavraChave1 + "%'";
			query += "OR palavraChave3.palavra LIKE '%" + palavraChave1 + "%')";
			continue_query = true;
		}

		if(palavraChave2 != null && !palavraChave2.isEmpty()){
			if(continue_query == true){
				query += " AND ";
			}
			query += "(palavraChave1.palavra LIKE '%" + palavraChave2 + "%'";
			query += "OR palavraChave2.palavra LIKE '%" + palavraChave2 + "%'";
			query += "OR palavraChave3.palavra LIKE '%" + palavraChave2 + "%')";
			continue_query = true;
		}

		if(palavraChave3 != null && !palavraChave3.isEmpty()){
			if(continue_query == true){
				query += " AND ";
			}
			query += "(palavraChave1.palavra LIKE '%" + palavraChave3 + "%'";
			query += "OR palavraChave2.palavra LIKE '%" + palavraChave3 + "%'";
			query += "OR palavraChave3.palavra LIKE '%" + palavraChave3 + "%')";
			continue_query = true;
		}
		
		if(query.equals(default_query)) {
			query = " FROM DocumentoMO ";
		}
		
		query += " ORDER BY cod, titulo ";
		return docDao.findDocumentByQuery(query);
	}
	
	public synchronized void registerNewDocument (
			// Documento
			String tituloDocumento,
			String tipoCodDocumento, // APEP/SEQ
			String codDocumento,
			String local,
			String url,
			String resumo,
			Date data,
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
			// Palavra chave 2
			String palavraChave2,
			// Palavra chave 3
			String palavraChave3) throws UnreachableDataBaseException, IllegalArgumentException{

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
			throw new IllegalArgumentException("Nenhum Códice/Caixa selecionado");
			/*try {
				codCaixa = codiceCaixaDAO.addCodiceCaixa(
								codCodiceCaixa, 
								tituloCodiceCaixa, 
								Integer.parseInt(anoInicioCodiceCaixa), 
								Integer.parseInt(anoFimCodiceCaixa)	);
			} catch (DuplicateCodiceCaixaException e) {
				e.printStackTrace();
			}*/
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
				throw new IllegalArgumentException("Palavra-chave inexistente");
				/*palavraChave[0] = palavraChaveDAO.addKeyWord(
								palavraChave1,
								temaPalavraChave1
								);*/
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
				/*palavraChave[1] = palavraChaveDAO.addKeyWord(
								palavraChave2,
								temaPalavraChave2
								);*/
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
				/*palavraChave[2] = palavraChaveDAO.addKeyWord(
								palavraChave3,
								temaPalavraChave3
								);*/
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
		
		codDocumento = tipoCodDocumento + "-" + codDocumento;
		
		newDoc = new Documento(codDocumento, tituloDocumento, local, url, resumo, 
				codCaixa, tipoDoc, author, addressee, 
				palavraChave[0], palavraChave[1], palavraChave[2], uploader, data);
		docDao.addDocument(newDoc);
	}
	
	public synchronized void modifyDocument(Documento doc) throws IllegalArgumentException, UnreachableDataBaseException, UpdateEntityException{
		docDao.updateDocument(doc);
	}
	
	public synchronized void modifyDocument(
			// Busca do documento a ser modificado
			String tipoCodDocumentoAntigo,
			String codDocumentoAntigo,
			// Documento
			String tituloDocumento,
			String tipoCodDocumento,
			String codDocumento,
			String local,
			String resumo,
			Date data,
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
			String temaPalavraChave3) throws UnreachableDataBaseException, DocumentNotFoundException, IllegalArgumentException, UpdateEntityException{

		List<DTO> check;
		CodiceCaixaDAO codiceCaixaDAO = new CodiceCaixaDAO();
		TipoDocumentoDAO tipoDocumentoDAO = new TipoDocumentoDAO();
		PalavraChaveDAO palavraChaveDAO = new PalavraChaveDAO();
		AutorDAO autorDAO = new AutorDAO();
		
		Documento doc = null;
		CodiceCaixa codCaixa = null;
		PalavraChave[] palavraChave = new PalavraChave[3];
		TipoDocumento tipoDoc = null;
		Autor author = null;
		Autor addressee = null;
		
		doc = findSingleDocument(tipoCodDocumentoAntigo, codDocumentoAntigo);
		
		
		doc.setCod(tipoCodDocumento+"-"+codDocumento); 
		
		
		doc.setTitulo(tituloDocumento);
		doc.setLocal(local);
		doc.setResumo(resumo);
		doc.setData(data);
		
		// Verificação de existência da origem do documento no banco
		try {
			codCaixa = codiceCaixaDAO.findExactCodiceCaixa(codCodiceCaixa, tituloCodiceCaixa);
		} catch (CodiceCaixaNotFoundException e1) {
			throw new IllegalArgumentException();
			/*try {
				codCaixa = codiceCaixaDAO.addCodiceCaixa(
								codCodiceCaixa, 
								tituloCodiceCaixa, 
								Integer.parseInt(anoInicioCodiceCaixa), 
								Integer.parseInt(anoFimCodiceCaixa)	);
			} catch (DuplicateCodiceCaixaException e) {
				e.printStackTrace();
			}*/
		}
		doc.setCodiceCaixa(codCaixa);

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
		doc.setTipoDocumento(tipoDoc);
		
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
				throw new IllegalArgumentException("Palavra chave inexistente");
				/*palavraChave[0] = palavraChaveDAO.addKeyWord(
								palavraChave1,
								temaPalavraChave1
								);*/
			}
		}
		doc.setPalavraChave1(palavraChave[0]);

		if(palavraChave2 != null && !palavraChave2.isEmpty())
		{
			try {
				check = palavraChaveDAO.findKeyWordByString(palavraChave2);
				for(DTO dto : check){
					if(((PalavraChave) dto).getPalavra().equals(palavraChave2))
						palavraChave[1] = (PalavraChave) dto;
				}
			} catch (KeywordNotFoundException e1) {
				throw new IllegalArgumentException("Palavra chave inexistente");
				/*palavraChave[1] = palavraChaveDAO.addKeyWord(
								palavraChave2,
								temaPalavraChave2
								);*/
			}
		}
		doc.setPalavraChave2(palavraChave[1]);

		if(palavraChave3 != null && !palavraChave3.isEmpty())
		{
			try {
				check = palavraChaveDAO.findKeyWordByString(palavraChave3);
				for(DTO dto : check){
					if(((PalavraChave) dto).getPalavra().equals(palavraChave3))
						palavraChave[2] = (PalavraChave) dto;
				}
			} catch (KeywordNotFoundException e1) {
				throw new IllegalArgumentException("Palavra chave inexistente");
				/*palavraChave[2] = palavraChaveDAO.addKeyWord(
								palavraChave3,
								temaPalavraChave3
								);*/
			}
		}
		doc.setPalavraChave3(palavraChave[2]);
		
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
		doc.setAutor(author);
		
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
		doc.setDestinatario(addressee);

		docDao.updateDocument(doc);
	}
	
	public synchronized void removeDocument(Documento document) throws UnreachableDataBaseException {
		docDao.removeDocument(document);
	}
	
	public Documento findSingleDocument(String type, String code) throws DocumentNotFoundException, UnreachableDataBaseException, IllegalArgumentException{
		if(code == null || code.isEmpty()) throw new IllegalArgumentException("Code is empty");
		String query = default_query;
		query += " cod = '" + type+"-"+code + "'";
		List<DTO> resultSet = docDao.findDocumentByQuery(query);
		for(DTO dto : resultSet){
			if(((Documento)dto).getCod().equals(code))	return (Documento) dto;
		}
		throw new DocumentNotFoundException("Documento não encontrado");
	}
	
	public List<DTO> findByDocumentType(String type) throws UnreachableDataBaseException, DocumentNotFoundException{

		String query = new String(default_query);

		query += "tipoDocumento.nome LIKE '%" + type + "%'";

		List<DTO> list = docDao.findDocumentByQuery(query);
		if(list == null) throw new DocumentNotFoundException();
		return list;
	}
	
	public List<DTO> findByCodiceCaixa(String codCodiceCaixa) throws UnreachableDataBaseException, DocumentNotFoundException{

		String query = new String(default_query);

		query += "codiceCaixa.cod = '" + codCodiceCaixa + "'";

		List<DTO> list = docDao.findDocumentByQuery(query);
		if(list == null) throw new DocumentNotFoundException();
		return list;
	}
	
	public List<DTO> findByKeyWord(String keyWord) throws UnreachableDataBaseException, DocumentNotFoundException{

		String query = new String(default_query);

		query += "palavraChave1.palavra = '" + keyWord + "' OR "
				+ "palavraChave2.palavra = '" + keyWord + "' OR "
				+ "palavraChave3.palavra = '" + keyWord + "'";

		List<DTO> list = docDao.findDocumentByQuery(query);
		if(list == null) throw new DocumentNotFoundException();
		return list;
	}
	
}
