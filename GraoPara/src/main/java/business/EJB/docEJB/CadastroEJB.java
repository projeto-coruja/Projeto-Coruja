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
import business.DAO.documents.KeyWordDAO;
import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

public class CadastroEJB {
	DocumentDAO docDao;
	
	public CadastroEJB(){
		docDao = new DocumentDAO();
	}

	public void cadastrarDocumento(String origem_codOrigem, String origem_tipoOrigem, String origem_titulo,
			String idNumDoc_tipoId, String idNumDoc_codId,
			String tipoDocumento_tipoDocumento,
			String palavraChave01, String palavraChave02, String palavraChave03,
			String autor, String local, String destinatario, String resumo,
			Calendar dataDocumento, Date dataInclusao, UserDTO uploader){
		
		DocumentoDTO docDTO;
		TipoDocumentoDTO tipoDTO;
		OrigemDTO origemDTO;
		IdNumDocumentoDTO idDTO;
		PalavraChaveDTO[] palavraChaveDTO;
		
		origemDTO = new OrigemDTO(origem_codOrigem, origem_tipoOrigem, origem_titulo);
		
		idDTO = new IdNumDocumentoDTO(idNumDoc_tipoId, idNumDoc_codId);
		
		tipoDTO = new TipoDocumentoDTO(tipoDocumento_tipoDocumento);
		
		palavraChaveDTO = new PalavraChaveDTO[3];
		palavraChaveDTO[0].setPalavra(palavraChave01);
		palavraChaveDTO[0].setAprovada(false);
		palavraChaveDTO[1].setPalavra(palavraChave02);
		palavraChaveDTO[1].setAprovada(false);
		palavraChaveDTO[2].setPalavra(palavraChave03);
		palavraChaveDTO[2].setAprovada(false);
		
		docDTO = new DocumentoDTO(null, origemDTO, idDTO, tipoDTO, autor, local, destinatario, resumo, dataDocumento, dataInclusao, uploader, 
				palavraChaveDTO[0], palavraChaveDTO[1], palavraChaveDTO[2]);
		
		try {
			docDTO = docDao.addDocument(docDTO);
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		}
	}
	
	public void cadastrarPalavraChave(String palavra) throws IllegalArgumentException {
		KeyWordDAO kwDao = new KeyWordDAO();
		try {
			List<DTO> check = kwDao.findKeyWordByString(palavra);
			for(DTO dto : check){
				if(((PalavraChaveDTO)dto).getPalavra().equals(palavra))
					throw new IllegalArgumentException("Palavra já existe");
			}
			try {
				kwDao.addKeyWord(palavra);
			} catch (UnreachableDataBaseException e1) {
				e1.printStackTrace();
			}
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		} catch (KeywordNotFoundException e) {
			try {
				kwDao.addKeyWord(palavra);
			} catch (UnreachableDataBaseException e1) {
				e1.printStackTrace();
			}
//			e.printStackTrace();
		}	
	}
}
 	