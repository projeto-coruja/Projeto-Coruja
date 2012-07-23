package Persistence.Utility;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Persistence.Utility.DataAccessLayerException;
import Persistence.Utility.PersistenceUtility;

public class EntityManager {

	private Session session;
	private Transaction transaction;
	
	public EntityManager(){
		PersistenceUtility.buildIfNeeded();
	}

	public void save(Object obj) throws DataAccessLayerException{
		try{
			startOperation();
			session.save(obj);
			transaction.commit();
		}catch(HibernateException e){
			handleException(e);
		}finally{
			PersistenceUtility.close(session);
		}
	}
	
	public void update(Object obj) throws DataAccessLayerException{
		try{
			startOperation();
			session.update(obj);
			transaction.commit();
		}catch(HibernateException e){
			handleException(e);
		}finally{
			PersistenceUtility.close(session);
		}
	}

	public void delete(Object obj) throws DataAccessLayerException{
		try{
			startOperation();
			session.delete(obj);
			transaction.commit();
		}catch(HibernateException e){
			handleException(e);
		}finally{
			PersistenceUtility.close(session);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public Object find(Class table, long id) throws DataAccessLayerException{
		Object obj = null;
		try{
			startOperation();
			obj = session.load(table, id);
			transaction.commit();
		}catch(HibernateException e){
			handleException(e);
		}finally{
			PersistenceUtility.close(session);
		}
		return obj;
	}


	@SuppressWarnings({ "unchecked"})
	public <T> List<T> find(String criteria) throws DataAccessLayerException{
		List<T> obj = null;
		try{
			startOperation();
			Query query = session.createQuery(criteria);
			obj = query.list();
			transaction.commit();
		}catch(HibernateException e){
			handleException(e);
		}finally{
			PersistenceUtility.close(session);
		}
		return obj;
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
