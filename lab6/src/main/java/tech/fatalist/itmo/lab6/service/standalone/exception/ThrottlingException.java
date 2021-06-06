package tech.fatalist.itmo.lab6.service.standalone.exception;

import java.io.Serial;

public class ThrottlingException extends Exception {
    @Serial
    private static final long serialVersionUID = -6883082919002945393L;
    private static final String message = "Too many requests";

    public ThrottlingException() {
        super(message);
    }

    public ThrottlingException(Throwable cause) {
        super(message, cause);
    }

    protected ThrottlingException(Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
