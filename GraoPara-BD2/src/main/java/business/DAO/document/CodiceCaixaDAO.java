package business.DAO.document;

import java.util.List;

import business.exceptions.documents.CodiceCaixaNotFoundException;
import business.exceptions.documents.DuplicateCodiceCaixaException;
import business.exceptions.login.UnreachableDataBaseException;
import persistence.PersistenceAccess;
import persistence.dto.CodiceCaixa;
import persistence.dto.DTO;
import persistence.exceptions.UpdateEntityException;
import persistence.util.DataAccessLayerException;

public class CodiceCaixaDAO {
	
	private PersistenceAccess manager;
	
	public CodiceCaixaDAO() {
		manager = new PersistenceAccess();
	}
	
	/**
	 * Adiciona um novo Códice/Caixa.
	 * @param cod uma String contendo o códice/caixa.
	 * @param titulo uma String contendo o título do novo Códice/Caixa.
	 * @param anoInicio um int contendo o ano inicial do novo Códice/Caixa.
	 * @param anoFim um int contendo o ano final do novo Códice/Caixa.
	 * @return o objeto Códice/Caixa criado.
	 * @throws UnreachableDataBaseException
	 * @throws DuplicateCodiceCaixaException
	 */
	public CodiceCaixa addCodiceCaixa(String cod, String titulo, int anoInicio, int anoFim) 
			throws UnreachableDataBaseException, DuplicateCodiceCaixaException {
		CodiceCaixa newId = new CodiceCaixa(cod, titulo, anoInicio, anoFim);
		try{
			findExactCodiceCaixa(cod);
			throw new DuplicateCodiceCaixaException("Codice/Caixa ja existe.");
		}catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");			
		} catch (CodiceCaixaNotFoundException e) {
			manager.saveEntity(newId);
			return newId;
		}
	}
	
	/**
	 * Removo o Códice/Caixa especificado.
	 * @param origin o objeto Códice/Caixa a ser removido.
	 * @throws UnreachableDataBaseException
	 */
	public void removeCodiceCaixa(CodiceCaixa origin) throws UnreachableDataBaseException{
		try{
			manager.deleteEntity(origin);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados.");
		}
	}
	
	/**
	 * Atualiza o Códice/Caixa especificado.
	 * @param codiceCaixa o objeto Códice/Caixa a ser atualizado.
	 * @throws UnreachableDataBaseException
	 * @throws IllegalArgumentException
	 * @throws UpdateEntityException
	 */
	public void updateCodiceCaixa(CodiceCaixa codiceCaixa) throws UnreachableDataBaseException, IllegalArgumentException, UpdateEntityException{
		try{
			manager.updateEntity(codiceCaixa);
		} catch(DataAccessLayerException e){
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	/**
	 * Procura o Códice/Caixa pelo seu código/caixa.
	 * @param cod uma String contendo o código/caixa.
	 * @return o objeto Códice/Caixa achado.
	 * @throws UnreachableDataBaseException
	 * @throws CodiceCaixaNotFoundException
	 */
	public CodiceCaixa findExactCodiceCaixa(String cod) 
			throws  UnreachableDataBaseException, CodiceCaixaNotFoundException  {
		
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntity("FROM CodiceCaixaMO WHERE cod = '"+ cod +"'"
					+ " ORDER BY cod, titulo, anoInicio, anoFim");
			if(resultSet == null) {
				throw new CodiceCaixaNotFoundException ("Codice/Caixa não encontrado.");
			}
			else return (CodiceCaixa) resultSet.get(0);
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	/**
	 * Procura o Códice/Caixa pelo seu código/caixa.
	 * @param cod uma String contendo o códice/caixa.
	 * @return uma lista de Códice/Caixa com o mesmo código/caixa.
	 * @throws UnreachableDataBaseException
	 * @throws CodiceCaixaNotFoundException
	 */
	public List<DTO> findCodiceCaixaByCod(String cod) throws  UnreachableDataBaseException, CodiceCaixaNotFoundException {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntity("from CodiceCaixaMO where cod like '%" + cod +"%' "
					+ "order by cod, titulo, anoInicio, anoFim");
			
			if(resultSet == null) {
				throw new CodiceCaixaNotFoundException ("Código não encontrado.");
			}
			else return resultSet;
		
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	/**
	 * Procura o Códice/Caixa pelo título.
	 * @param titulo uma String contendo o título do Códice/Caixa.
	 * @return uma lista de Códice/Caixa com o mesmo título.
	 * @throws UnreachableDataBaseException
	 * @throws CodiceCaixaNotFoundException
	 */
	public List<DTO> findCodiceCaixaByTitle(String titulo) throws  UnreachableDataBaseException, CodiceCaixaNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntity("from CodiceCaixaMO where titulo like '%" + normalize(titulo) +"%' order by cod, titulo, anoInicio, anoFim");
			if(resultSet == null) {
				throw new CodiceCaixaNotFoundException ("Título não encontrado.");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}
	
	/**
	 * Lista todos os Códice/Caixa existentes.
	 * @return uma lista de Códice/Caixa já existentes.
	 * @throws UnreachableDataBaseException
	 * @throws CodiceCaixaNotFoundException
	 */
	public List<DTO> findAllCodiceCaixa() throws  UnreachableDataBaseException, CodiceCaixaNotFoundException  {
		List<DTO> resultSet = null;
		try {
			resultSet = manager.findEntity("from CodiceCaixaMO order by cod, titulo, anoInicio, anoFim");
			if(resultSet == null) {
				throw new CodiceCaixaNotFoundException("Não existe nenhum Codice/Caixa cadastrado.");
			}
			else return resultSet;
		} catch (DataAccessLayerException e) {
			e.printStackTrace();
			throw new UnreachableDataBaseException("Erro ao acessar o banco de dados");
		}
	}

	/**
	 * Formata a palavra-chave a ser uasada na função findEntity().
	 * @param var uma string.
	 * @return a string formatada.
	 */
	private String normalize(String var){
		if(var == null)	return null;
		var = var.replace("'", "''");
//		var = var.replace("\"", "\\\"");
		return var;
	}
}
