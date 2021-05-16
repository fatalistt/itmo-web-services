package tech.fatalist.itmo.lab4.service.ee;

import jakarta.annotation.Resource;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

@Path("/persons")
@Produces({MediaType.APPLICATION_JSON})
public class PersonResource {
    @Resource(lookup = "java:/jdbc/itmo-web-services-lab1")
    private DataSource dataSource;

    @GET
    public Collection<Person> GetPersons(
            @QueryParam("name") String name,
            @QueryParam("surname") String surname,
            @QueryParam("age") Integer age,
            @QueryParam("country") String country,
            @QueryParam("city") String city
    ) throws SQLException {
        var dao = new PostgreSQLDAO(getConnection());
        return dao.getPersons(name, surname, age, country, city);
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
