package boardGame;

public class BoardException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
//recebe msg como argumento e repassa para superclasse runtimeException.
	public BoardException(String msg) {
		super(msg);
	}
	
}
