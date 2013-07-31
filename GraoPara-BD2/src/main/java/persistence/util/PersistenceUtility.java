package persistence.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import persistence.exceptions.DataAccessLayerException;

/**
 * Configurador da persistencia,
 *
 */
public class PersistenceUtility {

	private static SessionFactory sessionFactory = configureSessionFactory();
	
	private static ServiceRegistry serviceRegistry;

	private static Log log = LogFactory.getLog(PersistenceUtility.class);

	/**
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public static SessionFactory buildSessionFactory() throws HibernateException {
		if (sessionFactory != null) {
			closeFactory();
		}
		return configureSessionFactory();
	}

	/**
	 * 
	 * @return
	 * @throws DataAccessLayerException
	 */
	public static SessionFactory buildIfNeeded() throws DataAccessLayerException{
		if (sessionFactory != null) {
			return sessionFactory;
		}
		try {
			return configureSessionFactory();
		} catch (HibernateException e) {
			throw new DataAccessLayerException(e);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public static Session openSession() throws HibernateException {
		buildIfNeeded();
		return sessionFactory.openSession();
	}

	/**
	 * 
	 */
	public static void closeFactory() {
		if (sessionFactory != null) {
			try {
				sessionFactory.close();
			} catch (HibernateException ignored) {
				log.error("Couldn't close SessionFactory", ignored);
			}
		}
	}

	/**
	 * 
	 * @param session
	 */
	public static void close(Session session) {
		if (session != null) {
			try {
				session.close();
			} catch (HibernateException ignored) {
				log.error("Couldn't close Session", ignored);
			}
		}
	}

	/**
	 * 
	 * @param tx
	 */
	public static void rollback(Transaction tx) {
		try {
			if (tx != null) {
				tx.rollback();
			}
		} catch (HibernateException ignored) {
			log.error("Couldn't rollback Transaction", ignored);
		}
	}

	/**
	 * 
	 * @return
	 * @throws HibernateException
	 */
	private static SessionFactory configureSessionFactory() throws HibernateException {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		/*String rootPath = PersistenceUtility.class.getResource("PersistenceUtility.class").getPath();
		rootPath = rootPath.replace("/target/classes/persistence/utility/PersistenceUtility.class", " ");
		System.out.println(rootPath);
        System.setProperty("rootPath", rootPath);*/
		
		return sessionFactory;
	}

	/**
	 * 
	 * @return
	 */
	public static SessionFactory getSession() {
		return sessionFactory;
	}
	
	/**
	 * 
	 */
	public static void closeSessionFactory() {
		sessionFactory.close();
	}
}
