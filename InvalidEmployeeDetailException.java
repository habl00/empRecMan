package Logically;

public class InvalidEmployeeDetailException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	InvalidEmployeeDetailException() {
        super("Invalid Input for employee");
    }

    InvalidEmployeeDetailException(String message) {
        super(message);
    }

}