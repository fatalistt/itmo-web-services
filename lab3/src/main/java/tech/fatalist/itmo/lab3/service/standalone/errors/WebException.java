package tech.fatalist.itmo.lab3.service.standalone.errors;

import java.io.Serial;

@javax.xml.ws.WebFault(faultBean = "tech.fatalist.itmo.lab3.service.standalone.errors.WebFault")
public class WebException extends Exception {
    @Serial
    private static final long serialVersionUID = 3014088012487403678L;
    private final WebFault fault;

    public WebException(String message, WebFault fault) {
        super(message);
        this.fault = fault;
    }

    public WebException(String message, WebFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public WebFault getFaultInfo() {
        return fault;
    }
}
