package control.DAO;

import java.util.List;

import javax.persistence.Table;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class AbstractDao {
	private Session session;
	private Transaction transaction;

	public AbstractDao(){
		HibernateUtil.buildIfNeeded();
	}

	protected void save(Object obj) throws DataAccessLayerException{
		try{
			startOperation();
			session.save(obj);
			transaction.commit();
		}catch(HibernateException e){
			handleException(e);
		}finally{
			HibernateUtil.close(session);
		}
	}
	
	protected void update(Object obj) throws DataAccessLayerException{
		try{
			startOperation();
			session.update(obj);
			transaction.commit();
		}catch(HibernateException e){
			handleException(e);
		}finally{
			HibernateUtil.close(session);
		}
	}

	protected void delete(Object obj) throws DataAccessLayerException{
		try{
			startOperation();
			session.delete(obj);
			transaction.commit();
		}catch(HibernateException e){
			handleException(e);
		}finally{
			HibernateUtil.close(session);
		}
	}

	@SuppressWarnings("rawtypes")
	protected Object find (Class classe, long id) throws DataAccessLayerException{
		Object obj = null;
		try{
			startOperation();
			obj = session.load(classe, id);
			transaction.commit();
		}catch(HibernateException e){
			handleException(e);
		}finally{
			HibernateUtil.close(session);
		}
		return obj;

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <T> List<T> findAll(Class classe) throws DataAccessLayerException{
		List<T> obj = null;
		try{
			startOperation();
			Query query = session.createQuery("from " + classe.getName());
			obj = query.list();
			transaction.commit();
		}catch(HibernateException e){
			handleException(e);
		}finally{
			HibernateUtil.close(session);
		}
		return obj;
	}

	private void handleException(HibernateException e) throws DataAccessLayerException {
		HibernateUtil.rollback(transaction);
		throw new DataAccessLayerException(e);
	}

	private void startOperation() {
		session = HibernateUtil.openSession();
		transaction = session.beginTransaction();

	}
}