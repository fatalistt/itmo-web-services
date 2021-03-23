package tech.fatalist.itmo.lab1.service.javaee;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

@WebService(serviceName = "PersonService")
public class PersonWebService {
    @Resource(lookup = "java:/jdbc/itmo-web-services-lab1")
    private DataSource dataSource;

    @WebMethod(operationName = "getPersons")
    public Collection<Person> getPersonsByName(
            @WebParam(name = "name") String name,
            @WebParam(name = "surname") String surname,
            @WebParam(name = "age") Integer age,
            @WebParam(name = "country") String country,
            @WebParam(name = "city") String city
    ) throws SQLException {
        var dao = new PostgreSQLDAO(getConnection());
        return dao.getPersons(name, surname, age, country, city);
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
