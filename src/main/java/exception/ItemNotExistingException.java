package main.java.exception;

/**
 * Created by kenta on 17.02.2017.
 */
public class ItemNotExistingException extends RuntimeException {

    public ItemNotExistingException(String message) {
        super(message);
    }

}