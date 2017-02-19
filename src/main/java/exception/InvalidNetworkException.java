package main.java.exception;

/**
 * @author Kenta1561
 * This exception gets thrown when the provided network was invalid due to lack of connectivity between nodes.
 */
public class InvalidNetworkException extends RuntimeException {

    /**
     * Constructor with String as exception message
     * @param message Requires a String as the message
     */
    public InvalidNetworkException(String message) {
        super(message);
    }

}