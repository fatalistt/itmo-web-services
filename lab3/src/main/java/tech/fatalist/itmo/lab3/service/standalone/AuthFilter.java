package tech.fatalist.itmo.lab3.service.standalone;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Base64;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class AuthFilter extends AbstractPhaseInterceptor<Message> {
    private static final Fault Unauthorized = new Fault("Basic authentication required", (ResourceBundle) null);
    private static final Fault Forbidden = new Fault("Wrong login or password", (ResourceBundle) null);

    static {
        Unauthorized.setStatusCode(401);
        Unauthorized.setFaultCode(new QName("Client"));
        Forbidden.setStatusCode(403);
        Forbidden.setFaultCode(new QName("Client"));
    }

    public AuthFilter() {
        super(Phase.READ);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        var headers = ((TreeMap<String, ArrayList<String>>)message.get(Message.PROTOCOL_HEADERS))
                .get("Authorization");
        if (headers == null) {
            throw Unauthorized;
        }

        var header = headers.get(0);

        var splitted = header.trim().split("\\s+");
        if (splitted.length != 2 || !"Basic".equals(splitted[0]))
        {
            throw Unauthorized;
        }

        var loginPassword = new String(Base64.getDecoder().decode(splitted[1]));
        splitted = loginPassword.split(":");
        if (splitted.length != 2) {
            throw Forbidden;
        }

        var login = splitted[0];
        var password = splitted[1];

        if (!"tarasov".equals(login) || !"dmtr".equals(password)) {
            throw Forbidden;
        }
    }
}
