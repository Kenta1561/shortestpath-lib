package de.kenta1561.shortestpath.main.java.exception;

import de.kenta1561.shortestpath.main.java.datatype.Connection;

/**
 * @author Kenta1561
 * This exception gets thrown when a connection with the same origin and destination like another connection
 * was added to the HashSet. For the exception that gets thrown when the same instance of
 * {@link Connection} was added, see {@link ItemDuplicationException}.
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