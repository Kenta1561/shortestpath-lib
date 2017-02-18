package main.java.exception;

/**
 * This exception gets thrown when the same instance was added into a Set.
 */
public class ItemDuplicationException extends RuntimeException {

    /**
     * Constructor with String as exception message
     * @param message Requires a String as the message
     */
    public ItemDuplicationException(String message) {
        super(message);
    }

}