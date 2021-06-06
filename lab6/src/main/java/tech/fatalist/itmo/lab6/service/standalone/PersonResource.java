package tech.fatalist.itmo.lab6.service.standalone;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import tech.fatalist.itmo.lab6.contracts.request.CreateRequest;
import tech.fatalist.itmo.lab6.contracts.request.UpdateRequest;
import tech.fatalist.itmo.lab6.contracts.response.*;
import tech.fatalist.itmo.lab6.service.standalone.exception.ObjectNotFoundException;
import tech.fatalist.itmo.lab6.service.standalone.exception.ThrottlingException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/persons")
@Produces({MediaType.APPLICATION_JSON})
public class PersonResource {
    private static final Logger LOGGER = Logger.getLogger(PersonResource.class.getName());
    private static final int maxRequestsCount = 3;
    private static final AtomicInteger requestsCount = new AtomicInteger();

    @GET
    public GetAllResponse getPersons(
            @QueryParam("name") String name,
            @QueryParam("surname") String surname,
            @QueryParam("age") Integer age,
            @QueryParam("country") String country,
            @QueryParam("city") String city
    ) throws Exception {
        return executeRequest(() -> {
            try (var connection = getConnection()) {
                var dao = new PostgreSQLDAO(connection);
                return new GetAllResponse(dao.getPersons(name, surname, age, country, city));
            }
        });
    }

    @GET
    @Path("{id}")
    public GetResponse getPerson(@PathParam("id") int id) throws Exception {
        return executeRequest(() -> {
            try (var connection = getConnection()) {
                var dao = new PostgreSQLDAO(connection);
                var person = dao.getPerson(id);
                if (person == null) {
                    throw new ObjectNotFoundException();
                }
                return new GetResponse(person);
            }
        });
    }

    @DELETE
    @Path("{id}")
    @Protected
    public DeleteResponse deletePersonById(@PathParam("id") int id) throws Exception {
        return executeRequest(() -> {
            try (var connection = getConnection()) {
                var dao = new PostgreSQLDAO(connection);
                var deleted = dao.deletePerson(id);
                if (!deleted) {
                    throw new ObjectNotFoundException();
                }
                return new DeleteResponse("success");
            }
        });
    }

    @PUT
    @Path("{id}")
    @Protected
    public UpdateResponse updatePerson(@PathParam("id") int id, UpdateRequest request) throws Exception {
        return executeRequest(() -> {
            try (var connection = getConnection()) {
                var dao = new PostgreSQLDAO(connection);
                var updated = dao.updatePerson(
                        id,
                        request.name(),
                        request.surname(),
                        request.age(),
                        request.country(),
                        request.city(),
                        request.avatar());
                if (!updated) {
                    throw new ObjectNotFoundException();
                }
                return new UpdateResponse("success");
            }
        });
    }

    @POST
    @Protected
    public CreateResponse CreatePerson(CreateRequest request) throws Exception {
        return executeRequest(() -> {
            try (var connection = getConnection()) {
                var dao = new PostgreSQLDAO(connection);
                var createdId = dao.createPerson(
                        request.name(),
                        request.surname(),
                        request.age(),
                        request.country(),
                        request.city(),
                        request.avatar());
                return new CreateResponse(createdId);
            }
        });
    }

    private Connection getConnection() throws SQLException {
        return ConnectionUtil.getConnection();
    }

    private static <T> T executeRequest(CheckedSupplier<T> executor) throws Exception {
        try {
            var incremented = requestsCount.incrementAndGet();
            LOGGER.log(Level.WARNING, "requests: %d".formatted(incremented));
            if (incremented > maxRequestsCount) {
                throw new ThrottlingException();
            }

            return executor.get();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception occurs", e);
            throw e;
        } finally {
            var decremented = requestsCount.decrementAndGet();
            LOGGER.log(Level.WARNING, "requests: %d".formatted(decremented));
        }
    }
}
