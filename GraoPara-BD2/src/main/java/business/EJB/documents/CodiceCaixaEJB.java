package business.EJB.documents;

import java.util.ArrayList;
import java.util.List;

import persistence.dto.CodiceCaixa;
import persistence.dto.DTO;
import persistence.exceptions.UpdateEntityException;

import business.DAO.document.CodiceCaixaDAO;
import business.DAO.document.DocumentoDAO;
import business.exceptions.documents.CodiceCaixaNotFoundException;
import business.exceptions.documents.DuplicateCodiceCaixaException;
import business.exceptions.login.UnreachableDataBaseException;

public class CodiceCaixaEJB {
	CodiceCaixaDAO dao;

	public CodiceCaixaEJB() {
		dao = new CodiceCaixaDAO();
	}
	
	public synchronized void add(String tipo, String cod, String titulo, int anoInicio, int anoFim) throws UnreachableDataBaseException, DuplicateCodiceCaixaException{
		if(anoFim < anoInicio)	throw new IllegalArgumentException("anoFim < anoInicio");
		if(tipo == null || cod == null || tipo.isEmpty() || cod.isEmpty())	throw new IllegalArgumentException("Código e/ou tipo vazio ou nulo");
		cod = tipo.toUpperCase()+"-"+cod;
		dao.addCodiceCaixa(cod, titulo, anoInicio, anoFim);
	}
	
	public synchronized void update(String oldCod, String oldTitle, String newCod, String newTitle, int anoInicio, int anoFim) throws UnreachableDataBaseException, CodiceCaixaNotFoundException, IllegalArgumentException, UpdateEntityException{
		if(anoFim < anoInicio)	throw new IllegalArgumentException("anoFim < anoInicio");
		if(oldCod == null || oldCod.isEmpty() || newCod == null || newCod.isEmpty())	throw new IllegalArgumentException("Código vazio ou nulo");
		CodiceCaixa cc = findExactEntry(oldCod, oldTitle);
		cc.setCod(newCod);
		cc.setTitulo(newTitle);
		cc.setAnoInicio(anoInicio);
		cc.setAnoFim(anoFim);
		dao.updateCodiceCaixa(cc);
	}
	
	public synchronized void update(String oldCod, String newTitle, int anoInicio, int anoFim) throws UnreachableDataBaseException, CodiceCaixaNotFoundException, IllegalArgumentException, UpdateEntityException{
		if(anoFim < anoInicio)	throw new IllegalArgumentException("anoFim < anoInicio");
		if(oldCod == null || oldCod.isEmpty())	throw new IllegalArgumentException("Código vazio ou nulo");
		CodiceCaixa cc = (CodiceCaixa) findByCod(oldCod).get(0);
		cc.setTitulo(newTitle);
		cc.setAnoInicio(anoInicio);
		cc.setAnoFim(anoFim);
		dao.updateCodiceCaixa(cc);
	}
	
	public List<DTO> findByCod(String cod) throws UnreachableDataBaseException, CodiceCaixaNotFoundException{
		return dao.findCodiceCaixaByCod(cod);
	}
	
	public List<DTO> getAllEntries() throws UnreachableDataBaseException, CodiceCaixaNotFoundException{
		return dao.findAllCodiceCaixa();
	}
	
	public List<DTO> getAllEntriesWithContent() throws UnreachableDataBaseException, CodiceCaixaNotFoundException{
		DocumentoDAO documento = new DocumentoDAO();
		List<DTO> list = dao.findAllCodiceCaixa();
		List<DTO> contents = new ArrayList<DTO>();
//		HashSet<Integer> rm = new HashSet<Integer>();
		for(int i = 0; i < list.size(); i++) {
			CodiceCaixa c = (CodiceCaixa) list.get(i);
			Long count = documento.countDocumentsByCriteria("codiceCaixa.cod = '" + c.getCod() + "'");
			if(count != 0)	contents.add(list.get(i));
//			if(count == 0) rm.add(i);
		}
//		for(Integer i : rm) list.remove(i.intValue());
		
		return contents;
	}
	
	
	public CodiceCaixa findExactEntry(String cod, String title) throws UnreachableDataBaseException, CodiceCaixaNotFoundException{
		List<DTO> resultSet;
		resultSet = dao.findCodiceCaixaByCod(cod);
		for(DTO dto : resultSet){
			if(((CodiceCaixa)dto).getCod().equals(cod) && ((CodiceCaixa)dto).getTitulo().equals(title))	return (CodiceCaixa) dto;
		}
		throw new CodiceCaixaNotFoundException("Entrada não encontrada.");
	}

	public void deleteCodCaixa(String codigo) throws UnreachableDataBaseException, CodiceCaixaNotFoundException {
		dao.removeCodiceCaixa((CodiceCaixa) dao.findCodiceCaixaByCod(codigo).get(0));
	}
	
}
