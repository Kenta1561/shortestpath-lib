package main.java.exception;

/**
 * @author Kenta1561
 * This exception gets thrown when a connection with the same origin and destination like another connection
 * was added to the HashSet. For the exception that gets thrown when the same instance of
 * {@link main.java.datatype.Connection} was added, see {@link ItemDuplicationException}.
 */
public class MultipleRegistrationException extends RuntimeException {

    /**
     * Constructor with String as exception message
     * @param message Requires a String as the message
     */
    public MultipleRegistrationException(String message) {
        super(message);
    }

}