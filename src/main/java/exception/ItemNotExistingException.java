package main.java.exception;

/**
 * This exception gets thrown when an object contains an object which was not registered before.
 */
public class ItemNotExistingException extends RuntimeException {

    /**
     * Constructor with String as exception message
     * @param message Requires a String as the message
     */
    public ItemNotExistingException(String message) {
        super(message);
    }

}