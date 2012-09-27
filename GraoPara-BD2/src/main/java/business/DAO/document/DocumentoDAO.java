package business.DAO.document;

import java.util.List;

import persistence.PersistenceAccess;
import persistence.dto.CodiceCaixa;
import persistence.dto.DTO;
import persistence.dto.Documento;
import persistence.dto.PalavraChave;
import persistence.dto.TipoDocumento;
import persistence.exceptions.UpdateEntityException;
import persistence.util.DataAccessLayerException;
import business.exceptions.documents.CodiceCaixaNotFoundException;
import business.exceptions.documents.DocumentTypeNotFoundException;
import business.exceptions.documents.DuplicateCodiceCaixaException;
import business.exceptions.documents.KeywordNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;

public class DocumentoDAO {

	private PersistenceAccess manager;

	public DocumentoDAO() {
		manager = new PersistenceAccess();
	}
	
	public void addDocument(Documento newDoc) throws UnreachableDataBaseException {

		List<DTO> check;
		CodiceCaixaDAO codiceCaixaDAO = new CodiceCaixaDAO();
		TipoDocumentoDAO tipoDocumentoDAO = new TipoDocumentoDAO();
		PalavraChaveDAO palavraChaveDAO = new PalavraChaveDAO();
		
		// Verificação de existência da origem do documento no banco
		try {
			CodiceCaixa e_check = codiceCaixaDAO.findExactCodiceCaixa(newDoc.getCodiceCaixa().getCod(), newDoc.getCodiceCaixa().getTitulo());
			newDoc.setCodiceCaixa(e_check);
		} catch (CodiceCaixaNotFoundException e1) {
			try {
				newDoc.setCodiceCaixa(
						codiceCaixaDAO.addCodiceCaixa(
								newDoc.getCodiceCaixa().getCod(), 
								newDoc.getCodiceCaixa().getTitulo(), 
								newDoc.getCodiceCaixa().getAnoInicio(), 
								newDoc.getCodiceCaixa().getAnoFim()
						)
				);
			} catch (DuplicateCodiceCaixaException e) {
				//Impossível
				e.printStackTrace();
			}
		}

		// Verificação de existência do tipo de documento no banco
		try {
			check = tipoDocumentoDAO.findDocumentTypeByString(newDoc.getTipoDocumento().getNome());
			for(DTO dto : check){
				if(((TipoDocumento) dto).getNome().equals(newDoc.getTipoDocumento().getNome()))
					newDoc.setTipoDocumento((TipoDocumento) dto);
			}
		} catch (DocumentTypeNotFoundException e1) {	
			newDoc.setTipoDocumento(tipoDocumentoDAO.addDocumentType(newDoc.getTipoDocumento().getNome(), newDoc.getTipoDocumento().getDescricao()));
		}
		
		// Verificação de existência das palavras chaves documento no banco
		if(newDoc.getPalavraChave1() != null)
		{	
			try {
				check = palavraChaveDAO.findKeyWordByString(newDoc.getPalavraChave1().getPalavra());
				for(DTO dto : check){
					if(((PalavraChave) dto).getPalavra().equals(newDoc.getPalavraChave1().getPalavra()))
						newDoc.setPalavraChave1((PalavraChave) dto);
				}
			} catch (KeywordNotFoundException e1) {
				newDoc.setPalavraChave1(
						palavraChaveDAO.addKeyWord(
								newDoc.getPalavraChave1().getPalavra(),
								newDoc.getPalavraChave1().getTema().getTema()
						) 
				);
			}
		}

		if(newDoc.getPalavraChave2() != null)
		{
			try {
				check = palavraChaveDAO.findKeyWordByString(newDoc.getPalavraChave2().getPalavra());
				for(DTO dto : check){
					if(((PalavraChave) dto).getPalavra().equals(newDoc.getPalavraChave2().getPalavra()))
						newDoc.setPalavraChave2((PalavraChave) dto);
				}
			} catch (KeywordNotFoundException e1) {
				newDoc.setPalavraChave2(
						palavraChaveDAO.addKeyWord(
								newDoc.getPalavraChave2().getPalavra(),
								newDoc.getPalavraChave2().getTema().getTema()
						) 
				);
			}
		}

		if(newDoc.getPalavraChave3() != null)
		{
			try {
				check = palavraChaveDAO.findKeyWordByString(newDoc.getPalavraChave3().getPalavra());
				for(DTO dto : check){
					if(((PalavraChave) dto).getPalavra().equals(newDoc.getPalavraChave3().getPalavra()))
						newDoc.setPalavraChave3((PalavraChave) dto);
				}
			} catch (KeywordNotFoundException e1) {
				newDoc.setPalavraChave3(
						palavraChaveDAO.addKeyWord(
								newDoc.getPalavraChave3().getPalavra(),
								newDoc.getPalavraChave3().getTema().getTema()
						) 
				);
			}
		}

		try {
			manager.saveEntity(newDoc);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public void removeDocument(Documento doc) throws UnreachableDataBaseException {
		if(doc == null)	throw new IllegalArgumentException("Nenhum documento especificado");
		try{
			manager.deleteEntity(doc);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}

	public void updateDocument(Documento doc) throws UnreachableDataBaseException, IllegalArgumentException, UpdateEntityException {
		if(doc == null) throw new IllegalArgumentException("Documento inexistente!");
		try { 
			if(doc.getId() == null) addDocument(doc);	
			else manager.updateEntity(doc);
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	public Long countDocumentsByCriteria(String criteria) throws IllegalArgumentException{
		return manager.countRows("Documento", criteria);
	}
	
}
