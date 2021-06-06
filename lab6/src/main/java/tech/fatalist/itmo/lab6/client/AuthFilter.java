package tech.fatalist.itmo.lab6.client;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.ext.Provider;

import java.util.Base64;

@Provider
public class AuthFilter implements ClientRequestFilter {
    @Override
    public void filter(ClientRequestContext request) {
        final var login = "tarasov";
        final var password = "dmtr";
        final var encoded = Base64.getEncoder().encodeToString("%s:%s".formatted(login, password).getBytes());
        request.getHeaders().add("Authorization", "Basic %s".formatted(encoded));
    }
}
