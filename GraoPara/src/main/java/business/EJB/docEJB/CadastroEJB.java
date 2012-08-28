package business.EJB.docEJB;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import persistence.dto.DTO;
import persistence.dto.DocumentoDTO;
import persistence.dto.IdNumDocumentoDTO;
import persistence.dto.OrigemDTO;
import persistence.dto.PalavraChaveDTO;
import persistence.dto.TipoDocumentoDTO;
import persistence.dto.UserDTO;
import business.DAO.documents.DocumentDAO;
import business.DAO.documents.DocumentTypeDAO;
import business.DAO.documents.IdNumDocumentoDAO;
import business.DAO.documents.KeyWordDAO;
import business.DAO.documents.OrigemDAO;
import business.DAO.login.LoginDAO;
import business.exceptions.documents.DocumentNotFoundException;
import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

public class CadastroEJB {
	private final DocumentDAO docDao;
	private final KeyWordDAO keyDao;

	public CadastroEJB() {
		docDao = new DocumentDAO();
		keyDao = new KeyWordDAO();
	}

	public synchronized void cadastrarDocumento(String origem_codOrigem,
			String origem_tipoOrigem, String origem_titulo,
			String idNumDoc_tipoId, String idNumDoc_codId,
			String tipoDocumento_tipoDocumento, String palavraChave01,
			String palavraChave02, String palavraChave03, String autor,
			String local, String destinatario, String resumo,
			Calendar dataDocumento, String uploader) throws UnreachableDataBaseException, UserNotFoundException {

		DocumentoDTO docDTO;
		TipoDocumentoDTO tipoDTO;
		OrigemDTO origemDTO;
		IdNumDocumentoDTO idDTO;
		UserDTO uploaderDTO;
		PalavraChaveDTO[] palavraChaveDTO = { null, null, null };

		idNumDoc_tipoId = idNumDoc_tipoId.toUpperCase();
		origem_tipoOrigem = origem_tipoOrigem.toUpperCase();
		
		if (!( idNumDoc_tipoId.equals("APEP") || idNumDoc_tipoId.equals("SEQ") ))
			throw new IllegalArgumentException(
					"Tipo do id de documento tem que ser \"APEP\" ou \"SEQ\"");
		if (!( origem_tipoOrigem.equals("CAIXA") || origem_tipoOrigem
				.equals("CODICE")))
			throw new IllegalArgumentException(
					"Tipo da origem tem que ser \"CAIXA\" ou \"CODICE\"");
		origemDTO = new OrigemDTO(origem_codOrigem, origem_tipoOrigem,
				origem_titulo);

		idDTO = new IdNumDocumentoDTO(idNumDoc_tipoId, idNumDoc_codId);

		tipoDTO = new TipoDocumentoDTO(tipoDocumento_tipoDocumento);
		

		if(!palavraChave01.isEmpty()) {
			palavraChaveDTO[0] = new PalavraChaveDTO(palavraChave01, false);
		}
		else throw new IllegalArgumentException("Palavra-chave principal não pode ser vazia!");
			
		if(!palavraChave02.isEmpty()) {
			palavraChaveDTO[1] = new PalavraChaveDTO(palavraChave02, false);
		}
		
		if(!palavraChave03.isEmpty()) {
			palavraChaveDTO[2] = new PalavraChaveDTO(palavraChave03, false);

		}
	
		uploaderDTO = (new LoginDAO()).findUserByEmail(uploader);
		docDTO = new DocumentoDTO(null, origemDTO, idDTO, tipoDTO, autor,
				local, destinatario, resumo, dataDocumento, new Date(),
				uploaderDTO, palavraChaveDTO[0], palavraChaveDTO[1],
				palavraChaveDTO[2]);
		docDao.addDocument(docDTO);
		
	}
	
	public synchronized void deletarDocumento(Long id) throws UnreachableDataBaseException, DocumentNotFoundException{
		DocumentoDTO docDto;
		Long count;
		DocumentTypeDAO dtDao = new DocumentTypeDAO();
		IdNumDocumentoDAO indDao = new IdNumDocumentoDAO();
		OrigemDAO originDao = new OrigemDAO();
		String query = "from Documento where id = '" + id + "'";
			
		docDto = (DocumentoDTO) docDao.findDocumentByQuery(query).get(0);
		docDao.removeDocument(docDto);
		
		count = docDao.countDocumentsByCriteria("tipo_documento = '" 
				+ docDto.getTipoDocumento().getTipoDocumento() 
				+ "'");
		if(count == 0){
			dtDao.removeDocumentType(docDto.getTipoDocumento());
		}
		
		count = docDao.countDocumentsByCriteria("tipo_id = '" 
				+ docDto.getIdNumDocumento().getTipoId() 
				+ "' and cod_id = '" 
				+ docDto.getIdNumDocumento().getCodId() 
				+ "'");
		if(count == 0){
			indDao.removeIdNumDocument(docDto.getIdNumDocumento());
		}
		
		count = docDao.countDocumentsByCriteria("tipo_origem = '" 
				+ docDto.getOrigemDocumento().getTipoOrigem() 
				+ "' and cod_origem = '" 
				+ docDto.getOrigemDocumento().getCodOrigem() 
				+ "'");
		if(count == 0){
			originDao.removeOrigin(docDto.getOrigemDocumento());
		}
		
	}
	
	public synchronized void deletarDocumento(DocumentoDTO docDto) throws UnreachableDataBaseException{
		TipoDocumentoDTO tdDto;
//		OrigemDTO origemDTO;
		Long countTipoDocumentoDTO;
//		Long countOrigemDTO;
		DocumentTypeDAO dtDao = new DocumentTypeDAO();
		
		tdDto = docDto.getTipoDocumento();
//		origemDTO = docDto.getOrigemDocumento();
		docDao.removeDocument(docDto);
		countTipoDocumentoDTO = docDao.countDocumentsByCriteria("tipo_documento = '" + tdDto.getTipoDocumento() + "'");
		if(countTipoDocumentoDTO == 0){
			dtDao.removeDocumentType(tdDto);
		}
		
//		countOrigemDTO = docDao.countDocumentsByCriteria("cod_origem = '" + origemDTO.getCodOrigem() + "'");
//		if(countOrigemDTO == 0){
//			dtDao.remove
//		}
		
	}
	
	public synchronized void atualizarDocumento(DocumentoDTO docDTO) throws UnreachableDataBaseException{
		docDao.updateDocument(docDTO);
	}
	
	public synchronized void cadastrarPalavraChave(String palavra)
			throws IllegalArgumentException, UnreachableDataBaseException {
		KeyWordDAO kwDao = new KeyWordDAO();
		try {
			List<DTO> check = kwDao.findKeyWordByString(palavra);
			for (DTO dto : check) {
				if (((PalavraChaveDTO) dto).getPalavra().equals(palavra))
					throw new IllegalArgumentException("Palavra já existe");
			}
			try {
				kwDao.addKeyWord(palavra);
			} catch (UnreachableDataBaseException e1) {
				e1.printStackTrace();
			}
		} catch (KeywordNotFoundException e) {
			try {
				kwDao.addKeyWord(palavra);
			} catch (UnreachableDataBaseException e1) {
				e1.printStackTrace();
			}
			// e.printStackTrace();
		}
	}
	
	public synchronized void deletarPalavraChave(String keyWord) throws UnreachableDataBaseException, KeywordNotFoundException{
		BuscaDocEJB busca = new BuscaDocEJB();
		List<DTO> results = null;
		
		keyWord = keyWord.toLowerCase();
		
		try {
			results = busca.buscaDocPorPalavraChave(keyWord);
			for(DTO dto : results){
				DocumentoDTO doc = (DocumentoDTO) dto;
				if(doc.getPalavrasChaves1() != null && doc.getPalavrasChaves1().getPalavra().equals(keyWord)){
					doc.setPalavrasChaves1(doc.getPalavrasChaves2());
					doc.setPalavrasChaves2(doc.getPalavrasChaves3());
					doc.setPalavrasChaves3(null);
				}
				if(doc.getPalavrasChaves2() != null && doc.getPalavrasChaves2().getPalavra().equals(keyWord)){
					doc.setPalavrasChaves2(doc.getPalavrasChaves3());
					doc.setPalavrasChaves3(null);
				}
				if(doc.getPalavrasChaves3() != null && doc.getPalavrasChaves3().getPalavra().equals(keyWord)){
					doc.setPalavrasChaves3(null);
				}
				atualizarDocumento(doc);
			}
		} catch (DocumentNotFoundException e) {
			//e.printStackTrace();
		} finally {
			keyDao.removeKeyWord(keyWord);
		}
	}
	
	public synchronized void atualizarPalavraChave(String oldKey, String newKey, Boolean newStatus) throws UnreachableDataBaseException, KeywordNotFoundException , IllegalArgumentException {
		if(oldKey == null || newKey == null || oldKey.equals("") || newKey.equals("") || newStatus == null)	throw new IllegalArgumentException("Argumentos não podem ser null/vazio");
		
		BuscaDocEJB busca = new BuscaDocEJB();
		List<DTO> results = null;
		
		try {
			results = busca.buscaDocPorPalavraChave(oldKey);
			for(DTO dto : results){
				DocumentoDTO doc = (DocumentoDTO) dto;
				if(doc.getPalavrasChaves1() != null && doc.getPalavrasChaves1().getPalavra().equals(oldKey)){
					doc.setPalavrasChaves1(doc.getPalavrasChaves2());
					doc.setPalavrasChaves2(doc.getPalavrasChaves3());
					doc.setPalavrasChaves3(null);
				}
				if(doc.getPalavrasChaves2() != null && doc.getPalavrasChaves2().getPalavra().equals(oldKey)){
					doc.setPalavrasChaves2(doc.getPalavrasChaves3());
					doc.setPalavrasChaves3(null);
				}
				if(doc.getPalavrasChaves3() != null && doc.getPalavrasChaves3().getPalavra().equals(oldKey)){
					doc.setPalavrasChaves3(null);
				}
				atualizarDocumento(doc);
			}
		} catch (DocumentNotFoundException e) {	} 
		PalavraChaveDTO keyWordDTO = keyDao.updateKeyWord(oldKey.toLowerCase(), newKey.toLowerCase(), newStatus);
		
		for(DTO dto : results){
			DocumentoDTO doc = (DocumentoDTO) dto;
			if(doc.getPalavrasChaves1() == null){
				doc.setPalavrasChaves1(keyWordDTO);
			}
			else if(doc.getPalavrasChaves2() == null){
				doc.setPalavrasChaves2(keyWordDTO);
			}
			else if(doc.getPalavrasChaves3() == null){
				doc.setPalavrasChaves3(keyWordDTO);
			}
			atualizarDocumento(doc);
		}
	}
}
