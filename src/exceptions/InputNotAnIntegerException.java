package exceptions;

public class InputNotAnIntegerException extends RuntimeException {
    public InputNotAnIntegerException(String message) {
        super(message);
    }
}