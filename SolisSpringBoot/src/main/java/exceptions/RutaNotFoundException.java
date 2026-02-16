package exceptions;

public class RutaNotFoundException extends RuntimeException  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5030665213865363481L;

    public RutaNotFoundException() {
        super();
    }
    

    public RutaNotFoundException(String message) {
        super(message);
    }
 
    public RutaNotFoundException(long id) {
        super("Ruta not found: " + id);
    }
}
