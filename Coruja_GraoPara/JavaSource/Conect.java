import org.hibernate.Session;


public class Conect {
	
	public static void main(String[] args) {
		Session sessao = null;
		
		try {
			sessao = new HibernateUtil().getSession().getCurrentSession();
		}finally{
			if(sessao.isOpen())
				sessao.close();
			System.out.println("Conexão encerrada -->HibernateUtil().getSession().openSession();");
		}
	}

}
