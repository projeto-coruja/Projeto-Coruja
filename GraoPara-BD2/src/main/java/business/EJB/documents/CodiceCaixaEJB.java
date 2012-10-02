package business.EJB.documents;

import java.util.List;

import persistence.dto.CodiceCaixa;
import persistence.dto.DTO;

import business.DAO.document.CodiceCaixaDAO;
import business.exceptions.documents.CodiceCaixaNotFoundException;
import business.exceptions.documents.DuplicateCodiceCaixaException;
import business.exceptions.login.UnreachableDataBaseException;

public class CodiceCaixaEJB {
	CodiceCaixaDAO dao;

	public CodiceCaixaEJB() {
		dao = new CodiceCaixaDAO();
	}
	
	public void add(String cod, String titulo, int anoInicio, int anoFim) throws UnreachableDataBaseException, DuplicateCodiceCaixaException{
		if(anoFim < anoInicio)	throw new IllegalArgumentException("anoFim < anoInicio");
		if(cod == null || cod.isEmpty())	throw new IllegalArgumentException("Código vazio ou nulo");
		dao.addCodiceCaixa(cod, titulo, anoInicio, anoFim);
	}
	
	public List<DTO> findByCod(String cod) throws UnreachableDataBaseException, CodiceCaixaNotFoundException{
		return dao.findCodiceCaixaByCod(cod);
	}
	
	public List<DTO> getAllEntries() throws UnreachableDataBaseException, CodiceCaixaNotFoundException{
		return dao.findAllCodiceCaixa();
	}
	
	public CodiceCaixa findExactEntry(String cod, String title) throws UnreachableDataBaseException, CodiceCaixaNotFoundException{
		List<DTO> resultSet;
		resultSet = dao.findCodiceCaixaByCod(cod);
		for(DTO dto : resultSet){
			if(((CodiceCaixa)dto).getCod().equals(cod) && ((CodiceCaixa)dto).getTitulo().equals(title))	return (CodiceCaixa) dto;
		}
		throw new CodiceCaixaNotFoundException("Entrada não encontrada.");
	}
	
}
