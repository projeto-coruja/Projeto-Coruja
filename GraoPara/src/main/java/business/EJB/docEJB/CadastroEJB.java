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
	DocumentDAO docDao;

	public CadastroEJB() {
		docDao = new DocumentDAO();
	}

	public void cadastrarDocumento(String origem_codOrigem,
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

	public void cadastrarPalavraChave(String palavra)
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
	
	public void deletarDocumento(Long id) throws UnreachableDataBaseException, DocumentNotFoundException{
		DocumentoDTO docDto;
		Long count;
		DocumentTypeDAO dtDao = new DocumentTypeDAO();
		IdNumDocumentoDAO indDao = new IdNumDocumentoDAO();
		OrigemDAO originDao = new OrigemDAO();
		String query = "from Documento where id = '" + id + "'";
			
		docDto = (DocumentoDTO) docDao.findDocumentByQuery(query).get(0);
		docDao.removeDocument(docDto);
		
		count = docDao.countDocumentsByCriteria("tipo_documento = '" + docDto.getTipoDocumento().getTipoDocumento() + "'");
		if(count == 0){
			dtDao.removeDocumentType(docDto.getTipoDocumento());
		}
		
		count = docDao.countDocumentsByCriteria("tipo_id = '" + docDto.getIdNumDocumento().getTipoId() + "' and cod_id = '" + docDto.getIdNumDocumento().getCodId() + "'");
		if(count == 0){
			indDao.removeIdNumDocument(docDto.getIdNumDocumento());
		}
		
		count = docDao.countDocumentsByCriteria("tipo_origem = '" + docDto.getOrigemDocumento().getTipoOrigem() + "' and cod_origem = '" + docDto.getOrigemDocumento().getCodOrigem() + "'");
		if(count == 0){
			originDao.removeOrigin(docDto.getOrigemDocumento());
		}
		
	}
	
	public void deletarDocumento(DocumentoDTO docDto) throws UnreachableDataBaseException{
		TipoDocumentoDTO tdDto;
		Long count;
		DocumentTypeDAO dtDao = new DocumentTypeDAO();
		
		tdDto = docDto.getTipoDocumento();
		docDao.removeDocument(docDto);
		count = docDao.countDocumentsByCriteria("tipo_documento = '" + tdDto.getTipoDocumento() + "'");
		if(count == 0){
			dtDao.removeDocumentType(tdDto);
		}
		
	}
	
	public void atualizarDocumento(DocumentoDTO docDTO) throws UnreachableDataBaseException{
		docDao.updateDocument(docDTO);
	}
}
