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

    @WebMethod(operationName = "getAllPersons")
    public Collection<Person> getAllPersons() throws SQLException {
        var dao = new PostgreSQLDAO(getConnection());
        return dao.getAllPersons();
    }

    @WebMethod(operationName = "getPersonsByName")
    public Collection<Person> getPersonsByName(@WebParam(name = "personName") String name) throws SQLException {
        var dao = new PostgreSQLDAO(getConnection());
        return dao.getPersonsByName(name);
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
