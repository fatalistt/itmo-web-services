package tech.fatalist.itmo.lab4.service.standalone;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.sql.SQLException;
import java.util.Collection;

@Path("/persons")
@Produces({MediaType.APPLICATION_JSON})
public class PersonResource {
    @GET
    public Collection<Person> GetPersons(
            @QueryParam("name") String name,
            @QueryParam("surname") String surname,
            @QueryParam("age") Integer age,
            @QueryParam("country") String country,
            @QueryParam("city") String city
    ) throws SQLException {
        var dao = new PostgreSQLDAO(ConnectionUtil.getConnection());
        return dao.GetPersons(name, surname, age, country, city);
    }
}
