package business.exceptions.login;

public class UnreachableDataBaseException extends Exception {

	private static final long serialVersionUID = -620020735955249556L;

	public UnreachableDataBaseException(){
		super();
	}

	public UnreachableDataBaseException(String msg){
		super(msg);
	}
	
}
