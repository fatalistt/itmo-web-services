package tech.fatalist.itmo.lab3.service.standalone;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.service.invoker.MethodDispatcher;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Base64;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class AuthFilter extends AbstractSoapInterceptor {
    private static final Fault Unauthorized = new Fault("Basic authentication required", (ResourceBundle) null);
    private static final Fault Forbidden = new Fault("Wrong login or password", (ResourceBundle) null);

    static {
        Unauthorized.setStatusCode(401);
        Unauthorized.setFaultCode(new QName("Client"));
        Forbidden.setStatusCode(403);
        Forbidden.setFaultCode(new QName("Client"));
    }

    public AuthFilter() {
        super(Phase.PRE_INVOKE);
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        var boi = message.getExchange().getBindingOperationInfo();
        var dispatcher = (MethodDispatcher) message.getExchange().getService().get(MethodDispatcher.class.getName());
        var method = dispatcher.getMethod(boi);
        if (method.getAnnotation(Protected.class) == null) {
            return;
        }

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
