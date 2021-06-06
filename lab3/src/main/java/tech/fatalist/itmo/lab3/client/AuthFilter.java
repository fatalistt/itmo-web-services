package tech.fatalist.itmo.lab3.client;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

import java.util.ArrayList;
import java.util.Base64;
import java.util.TreeMap;

public class AuthFilter extends AbstractPhaseInterceptor<Message> {
    public AuthFilter() {
        super(Phase.SEND);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        final var login = "tarasov";
        final var password = "dmtr";
        final var encoded = Base64.getEncoder().encodeToString("%s:%s".formatted(login, password).getBytes());

        var authHeaders = new ArrayList<String>();
        authHeaders.add("Basic %s".formatted(encoded));

        var headers = ((TreeMap<String, ArrayList<String>>)message.get(Message.PROTOCOL_HEADERS));
        headers.put("Authorization", authHeaders);
    }
}
