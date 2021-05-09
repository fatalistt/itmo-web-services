package tech.fatalist.itmo.lab3.service.standalone.errors;

import javax.xml.ws.WebFault;
import java.io.Serial;

@WebFault(faultBean = "tech.fatalist.itmo.lab3.service.standalone.errors.WebExceptionDetails")
public class ObjectNotFoundException extends WebException {
    @Serial
    private static final long serialVersionUID = 1618619777227547009L;
    private static final String message = "Object not found";

    public ObjectNotFoundException(WebExceptionDetails fault) {
        super(message, fault);
    }

    public ObjectNotFoundException(WebExceptionDetails fault, Throwable cause) {
        super(message, fault, cause);
    }
}
