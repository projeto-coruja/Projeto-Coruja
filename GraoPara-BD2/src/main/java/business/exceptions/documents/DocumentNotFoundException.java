package business.exceptions.documents;

public class DocumentNotFoundException extends Exception {

	private static final long serialVersionUID = -3341437813760056251L;

	public DocumentNotFoundException(){
		super();
	}

	public DocumentNotFoundException(String msg){
		super(msg);
	}
	
}
