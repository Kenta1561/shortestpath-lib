package main.java.exception;

public class UnregisteredItemException extends RuntimeException {

    public UnregisteredItemException(String message) {
        super(message);
    }

}