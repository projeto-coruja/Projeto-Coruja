import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.metamodel.Metadata;
import org.hibernate.metamodel.MetadataSources;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateUtil {

	private static SessionFactory sessionFactory = configureSessionFactory();

	private static SessionFactory configureSessionFactory() throws HibernateException {
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().configure().buildServiceRegistry();
		MetadataSources metadataSources = new MetadataSources(serviceRegistry);
		metadataSources.addResource("hibernate.cfg.xml");        
	    Metadata metadata = metadataSources.buildMetadata();
	    SessionFactory sessionFactory = metadata.buildSessionFactory();
	    return sessionFactory;
	}
	
	public SessionFactory getSession() {
		return sessionFactory;
	}
	
}
