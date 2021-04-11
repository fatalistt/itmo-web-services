package tech.fatalist.itmo.lab2.service.standalone;

import tech.fatalist.itmo.lab2.service.standalone.results.CreationResult;
import tech.fatalist.itmo.lab2.service.standalone.results.DeletionResult;
import tech.fatalist.itmo.lab2.service.standalone.results.UpdateResult;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

@WebService(serviceName = "PersonService")
public class PersonWebService {
    @WebMethod(operationName = "getPersons")
    public Collection<Person> GetPersons(
            @WebParam(name = "name") String name,
            @WebParam(name = "surname") String surname,
            @WebParam(name = "age") Integer age,
            @WebParam(name = "country") String country,
            @WebParam(name = "city") String city
    ) throws SQLException {
        var dao = new PostgreSQLDAO(ConnectionUtil.getConnection());
        return dao.GetPersons(name, surname, age, country, city);
    }

    @WebMethod(operationName = "deletePerson")
    public DeletionResult DeletePersonById(
            @WebParam(name = "id") int id
    ) throws SQLException {
        var dao = new PostgreSQLDAO(getConnection());
        var deleted = dao.DeletePerson(id);
        return new DeletionResult(deleted ? "success" : "failure");
    }

    @WebMethod(operationName = "updatePerson")
    public UpdateResult UpdatePerson(
            @WebParam(name = "id") int id,
            @WebParam(name = "name") String name,
            @WebParam(name = "surname") String surname,
            @WebParam(name = "age") Integer age,
            @WebParam(name = "country") String country,
            @WebParam(name = "city") String city,
            @WebParam(name = "avatar") byte[] avatar
    ) throws SQLException {
        var dao = new PostgreSQLDAO(getConnection());
        var updated = dao.UpdatePerson(id, name, surname, age, country, city, avatar);
        return new UpdateResult(updated ? "success" : "failure");
    }

    @WebMethod(operationName = "createPerson")
    public CreationResult CreatePerson(
            @WebParam(name = "name") String name,
            @WebParam(name = "surname") String surname,
            @WebParam(name = "age") Integer age,
            @WebParam(name = "country") String country,
            @WebParam(name = "city") String city,
            @WebParam(name = "avatar") byte[] avatar
    ) throws SQLException {
        var dao = new PostgreSQLDAO(getConnection());
        var createdId = dao.CreatePerson(name, surname, age, country, city, avatar);
        return new CreationResult(createdId);
    }

    private Connection getConnection() throws SQLException {
        return ConnectionUtil.getConnection();
    }
}
