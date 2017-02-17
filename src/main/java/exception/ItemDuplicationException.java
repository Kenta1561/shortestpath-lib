package main.java.exception;

/**
 * Created by kenta on 17.02.2017.
 */
public class ItemDuplicationException extends RuntimeException {

    public ItemDuplicationException(String message) {
        super(message);
    }

}