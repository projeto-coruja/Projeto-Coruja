package persistence.utility;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import persistence.model.Entidade;
import persistence.utility.DataAccessLayerException;
import persistence.utility.PersistenceUtility;


public class EntityManager {

	private Session session;
	private Transaction transaction;
	
	public EntityManager(){
		PersistenceUtility.buildIfNeeded();
	}

	public void save(Entidade obj) throws DataAccessLayerException{
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
	
	public void update(Entidade obj) throws DataAccessLayerException{
		try{
			startOperation();
			session.update(obj);
			transaction.commit();
		}catch(HibernateException e){
			handleException(e);
		}finally{
			finishOperation();
		}
	}

	public void delete(Entidade obj) throws DataAccessLayerException{
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
	public Entidade find(Class table, long id) throws DataAccessLayerException{
		Entidade obj = null;
		try{
			startOperation();
			obj = (Entidade) session.get(table, id);
			transaction.commit();
		}catch(HibernateException e){
			handleException(e);
		}finally{
			PersistenceUtility.close(session);
		}
		return obj;
	}


	@SuppressWarnings({ "unchecked"})
	public List<Entidade> find(String criteria) throws DataAccessLayerException{
		List<Entidade> obj = null;
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
		PersistenceUtility.rollback(transaction);
		throw new DataAccessLayerException(e);
	}

	private void startOperation() {
		session = PersistenceUtility.openSession();
		transaction = session.beginTransaction();

	}

}
