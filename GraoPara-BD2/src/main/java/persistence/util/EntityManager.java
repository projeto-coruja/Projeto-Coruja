package persistence.util;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import persistence.exceptions.DataAccessLayerException;
import persistence.model.EntityModel;
import persistence.util.PersistenceUtility;

/**
 * Façade responsável nas operações no banco de dados.
 *
 */
public class EntityManager {

	private Session session;
	
	private Transaction transaction;
	
	/**
	 * 
	 */
	public EntityManager(){
		PersistenceUtility.buildIfNeeded();
	}

	/**
	 * Salva uma entidade no banco de dados.
	 * Taca exceção caso a entrada já exista ou quando há uma entrada ilegal 
	 * (i.e. entidade com id já existente ou campos obrigatórios vazio).
	 * @param obj - entidade a ser salvo
	 * @throws DataAccessLayerException
	 */
	public void save(EntityModel obj) throws DataAccessLayerException{
		try{
			startOperation();
			session.save(obj);
			transaction.commit();
		}catch(HibernateException e){
			handleException(e);
		}finally{
			finishOperation();
		}
	}
	
	/**
	 * Atualiza uma entidade no banco de dados.
	 * caso a entrada não exista no BD, uma nova sera criada.
	 * @param obj
	 * @throws DataAccessLayerException
	 */
	public void update(EntityModel obj) throws DataAccessLayerException{
		try{
			startOperation();
			session.merge(obj);
			transaction.commit();
		}catch(HibernateException e){
			handleException(e);
		}finally{
			finishOperation();
		}
	}

	/**
	 * Deleta uma entrada do BD.
	 * @param obj
	 * @throws DataAccessLayerException
	 */
	public void delete(EntityModel obj) throws DataAccessLayerException{
		try{
			startOperation();
			session.delete(obj);
			transaction.commit();
		}catch(HibernateException e){
			handleException(e);
		}finally{
			finishOperation();
		}
	}
	
	/**
	 * Busca de entrada através do id.
	 * @param table - Classe, que tenha herança de EntityModel, que representa a tabela que será feito a busca.
	 * @param id - id da entrada.
	 * @return	resultado da busca.
	 * @throws DataAccessLayerException
	 */
	@SuppressWarnings("rawtypes")
	public EntityModel find(Class table, long id) throws DataAccessLayerException{
		Object obj = null;
		try{
			startOperation();
			obj = (Object) session.get(table, id);
			transaction.commit();
		}catch(HibernateException e){
			handleException(e);
		}finally{
			finishOperation();
		}
		return (EntityModel) obj;
	}
	
	/**
	 * Busca de entrada(s) através de query sql.
	 * @param criteria - Query de busca.
	 * @return List&lt;Object&gt; contendo o resultado da busca.
	 * @throws DataAccessLayerException
	 */
	@SuppressWarnings({ "unchecked"})
	public List<Object> find(String criteria) throws DataAccessLayerException{
		List<Object> obj = null;
		try{
			startOperation();
			Query query = session.createQuery(criteria);
			obj = query.list();
			transaction.commit();
		}catch(HibernateException e){
			handleException(e);
		}
		return obj;
	}
	
	/**
	 * 
	 */
	public void finishOperation() {
		PersistenceUtility.close(session);
	}

	/**
	 * 
	 * @param e
	 * @throws DataAccessLayerException
	 */
	private void handleException(HibernateException e) throws DataAccessLayerException {
		e.printStackTrace();
		PersistenceUtility.rollback(transaction);
		throw new DataAccessLayerException(e);
	}

	/**
	 * 
	 */
	private void startOperation() {
		session = PersistenceUtility.openSession();
		transaction = session.beginTransaction();
	}
	
	/**
	 * 
	 * @param table	- Tabela que será feito a pesquisa. 
	 * @param criteria - String do critério (ex: profile = 'admin'). Usar "1=1" para retornar o número de entradas.
	 * @return	Quantidade de entradas correspondente ao critério.
	 */
	public Long count(String table, String criteria){
		Query query = null;
		Long result = null;
		try{
			startOperation();
			String queryString = "select count(*) from " + table + " where " + criteria;
			query = session.createQuery(queryString);
			result = (Long) query.list().get(0);
			transaction.commit();
		}catch(HibernateException e){
			handleException(e);
		}finally{
			finishOperation();
		}
		return result;
	}

}
