package control.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class AbstractDao {
	private Session session;
	private Transaction transaction;
	
	public AbstractDao(){
		HibernateFactory.buildIfNeeded();
	}
}
