package persistence.util;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import persistence.model.EntityModel;
import persistence.util.DataAccessLayerException;
import persistence.util.PersistenceUtility;


public class EntityManager {

	private Session session;
	
	private Transaction transaction;
	
	public EntityManager(){
		PersistenceUtility.buildIfNeeded();
	}

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
	
	public void finishOperation() {
		PersistenceUtility.close(session);
	}

	private void handleException(HibernateException e) throws DataAccessLayerException {
		e.printStackTrace();
		PersistenceUtility.rollback(transaction);
		throw new DataAccessLayerException(e);
	}

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
