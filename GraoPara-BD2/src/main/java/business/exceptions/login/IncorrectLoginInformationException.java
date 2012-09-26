package business.exceptions.login;

public class IncorrectLoginInformationException extends Exception {

	private static final long serialVersionUID = 8898790142799139943L;

	public IncorrectLoginInformationException() {
		super();
	}

	public IncorrectLoginInformationException(String msg) {
		super(msg);
	}
}
