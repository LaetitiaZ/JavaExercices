package exception;

public class FactorielleException extends Exception {

	public FactorielleException() {
		super("operation cannot be done properly");
	}
	
	public FactorielleException(String message) {
		super(message);
	}
	
}
