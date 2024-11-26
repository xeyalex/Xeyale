package xeyale.balance.exception;

public class ResourceNotFoundException extends CustomException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
