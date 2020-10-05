package exception;

public class IncoherentException extends FactorielleException{

	public IncoherentException() {
		super("result out of range");
	}
	
}
