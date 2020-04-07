package data_managing.exceptions;

public class ResourceReadFailedException extends RuntimeException {
    public ResourceReadFailedException(final String message) {
        super(message);
    }
}
