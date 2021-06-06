package tech.fatalist.itmo.lab6.service.standalone;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.util.Base64;

@Provider
public class AuthFilter implements ContainerRequestFilter {
    private static final Response Unauthorized = Response
            .status(Response.Status.UNAUTHORIZED)
            .header("WWW-Authenticate", "Basic realm=\"Lab 6 authentication\"")
            .build();

    private static final Response Forbidden = Response
            .status(Response.Status.FORBIDDEN)
            .build();

    @Override
    public void filter(ContainerRequestContext request) {
        var header = request.getHeaders().getFirst("Authorization");
        if (header == null)
        {
            request.abortWith(Unauthorized);
            return;
        }

        var splitted = header.trim().split("\\s+");
        if (splitted.length != 2 || !"Basic".equals(splitted[0]))
        {
            request.abortWith(Unauthorized);
            return;
        }

        var loginPassword = new String(Base64.getDecoder().decode(splitted[1]));
        splitted = loginPassword.split(":");
        if (splitted.length != 2) {
            request.abortWith(Forbidden);
            return;
        }

        var login = splitted[0];
        var password = splitted[1];

        if (!"tarasov".equals(login) || !"dmtr".equals(password)) {
            request.abortWith(Forbidden);
            return;
        }
    }
}
