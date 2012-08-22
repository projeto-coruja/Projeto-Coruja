package business.EJB.docEJB;

import java.util.List;

import persistence.dto.DTO;

import business.DAO.documents.KeyWordDAO;

public class BuscaPalavraChaveEJB {
	
	KeyWordDAO key;
	
	public BuscaPalavraChaveEJB() {
		key = new KeyWordDAO();
	}
	
	public List<DTO> buscaPalavrasChaves(){
		return null;
	}

}
