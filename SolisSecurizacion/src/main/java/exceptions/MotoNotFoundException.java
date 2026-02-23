package exceptions;

public class MotoNotFoundException extends RuntimeException  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5030665213865363481L;

    public MotoNotFoundException() {
        super();
    }
    

    public MotoNotFoundException(String message) {
        super(message);
    }
 
    public MotoNotFoundException(long id) {
        super("Moto not found: " + id);
    }
}
