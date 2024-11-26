package xeyale.balance.exception;

public class UnauthorizedException extends CustomException {
    private static final long serialVersionUID = 1L;

    public UnauthorizedException(String message) {
        super(message);
    }
}
