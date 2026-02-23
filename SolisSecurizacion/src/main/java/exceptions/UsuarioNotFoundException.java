package exceptions;

public class UsuarioNotFoundException extends RuntimeException  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5030665213865363481L;

    public UsuarioNotFoundException() {
        super();
    }
    

    public UsuarioNotFoundException(String message) {
        super(message);
    }
 
    public UsuarioNotFoundException(long id) {
        super("Usuario not found: " + id);
    }
}