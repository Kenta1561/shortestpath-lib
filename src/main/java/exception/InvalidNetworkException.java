package main.java.exception;

/**
 * Created by kenta on 18.02.2017.
 */
public class InvalidNetworkException extends RuntimeException {

    public InvalidNetworkException(String message) {
        super(message);
    }

}