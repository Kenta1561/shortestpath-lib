package de.kenta1561.shortestpath.main.java.exception;

/**
 * @author Kenta1561
 * This exception gets thrown when the same instance was added into a HashSet.
 * For the exception that gets thrown when the origin and destination overlaps with these from
 * another connection, see {@link MultipleRegistrationException}.
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