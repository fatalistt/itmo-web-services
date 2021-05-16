package tech.fatalist.itmo.lab6.service.standalone.exception;

import java.io.Serial;

public class ObjectNotFoundException extends Exception {
    @Serial
    private static final long serialVersionUID = -6735337550441052114L;
    private static final String message = "Object not found";

    public ObjectNotFoundException() {
        super(message);
    }

    public ObjectNotFoundException(Throwable cause) {
        super(message, cause);
    }

    protected ObjectNotFoundException(Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
