package tech.fatalist.itmo.lab6.service.standalone;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import tech.fatalist.itmo.lab6.service.standalone.exception.ObjectNotFoundException;
import tech.fatalist.itmo.lab6.contracts.request.CreateRequest;
import tech.fatalist.itmo.lab6.contracts.request.UpdateRequest;
import tech.fatalist.itmo.lab6.contracts.response.*;

import java.sql.Connection;
import java.sql.SQLException;

@Path("/persons")
@Produces({MediaType.APPLICATION_JSON})
public class PersonResource {
    @GET
    public GetAllResponse getPersons(
            @QueryParam("name") String name,
            @QueryParam("surname") String surname,
            @QueryParam("age") Integer age,
            @QueryParam("country") String country,
            @QueryParam("city") String city
    ) throws SQLException {
        var dao = new PostgreSQLDAO(getConnection());
        return new GetAllResponse(dao.getPersons(name, surname, age, country, city));
    }

    @GET
    @Path("{id}")
    public GetResponse getPerson(@PathParam("id") int id) throws SQLException, ObjectNotFoundException {
        var dao = new PostgreSQLDAO(getConnection());
        var person = dao.getPerson(id);
        if (person == null) {
            throw new ObjectNotFoundException();
        }
        return new GetResponse(person);
    }

    @DELETE
    @Path("{id}")
    public DeleteResponse deletePersonById(@PathParam("id") int id) throws SQLException, ObjectNotFoundException {
        var dao = new PostgreSQLDAO(getConnection());
        var deleted = dao.deletePerson(id);
        if (!deleted) {
            throw new ObjectNotFoundException();
        }
        return new DeleteResponse("success");
    }

    @PUT
    @Path("{id}")
    public UpdateResponse updatePerson(@PathParam("id") int id, UpdateRequest request) throws SQLException, ObjectNotFoundException {
        var dao = new PostgreSQLDAO(getConnection());
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

    @POST
    public CreateResponse CreatePerson(CreateRequest request) throws SQLException {
        var dao = new PostgreSQLDAO(getConnection());
        var createdId = dao.createPerson(
                request.name(),
                request.surname(),
                request.age(),
                request.country(),
                request.city(),
                request.avatar());
        return new CreateResponse(createdId);
    }

    private Connection getConnection() throws SQLException {
        return ConnectionUtil.getConnection();
    }
}
