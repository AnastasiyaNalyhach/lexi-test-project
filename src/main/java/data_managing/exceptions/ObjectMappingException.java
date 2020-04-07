package data_managing.exceptions;

public class ObjectMappingException extends RuntimeException {
    public ObjectMappingException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
