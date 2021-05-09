package tech.fatalist.itmo.lab3.service.standalone.errors;

import javax.xml.ws.WebFault;
import java.io.Serial;

@WebFault(faultBean = "tech.fatalist.itmo.lab3.service.standalone.errors.WebExceptionDetails")
public class WebException extends Exception {
    @Serial
    private static final long serialVersionUID = 3014088012487403678L;
    private final WebExceptionDetails fault;

    public WebException(String message, WebExceptionDetails fault) {
        super(message);
        this.fault = fault;
    }

    public WebException(String message, WebExceptionDetails fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public WebExceptionDetails getFaultInfo() {
        return fault;
    }
}
