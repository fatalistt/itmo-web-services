package tech.fatalist.itmo.lab3.service.standalone.errors;

import java.io.Serial;

public class ObjectNotFoundException extends WebException {
    @Serial
    private static final long serialVersionUID = 1618619777227547009L;
    private static final String message = "Object not found";

    public ObjectNotFoundException(WebFault fault) {
        super(message, fault);
    }

    public ObjectNotFoundException(WebFault fault, Throwable cause) {
        super(message, fault, cause);
    }
}
