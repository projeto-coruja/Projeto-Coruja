import org.hibernate.Session;


public class Conect {
	
	public static void main(String[] args) {
		Session sessao = null;
		
		System.out.println("FORA");
		try {
			System.out.println("DENTRO TRY");
			sessao = new HibernateUtil().getSession().openSession();
			System.out.println("Conectou -->HibernateUtil().getSession().openSession();");
		} 
		catch(Exception e){
			e.printStackTrace();
			return;
		}
		finally{
			if(sessao != null && sessao.isOpen())	sessao.close();
			System.out.println("Conexão encerrada -->HibernateUtil().getSession().openSession();");
		}
	}

}