package tech.fatalist.itmo.lab6.service.standalone;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import tech.fatalist.itmo.lab6.service.standalone.exception.ThrottlingException;

@Provider
public class ThrottlingExceptionMapper implements ExceptionMapper<ThrottlingException> {
    @Override
    public Response toResponse(ThrottlingException e) {
        return Response.status(Response.Status.TOO_MANY_REQUESTS).entity(e.getMessage()).build();
    }
}
