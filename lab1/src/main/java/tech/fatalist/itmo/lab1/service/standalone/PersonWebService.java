package tech.fatalist.itmo.lab1.service.standalone;

import tech.fatalist.itmo.lab1.common.Person;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Collection;

@WebService(serviceName = "PersonService")
public class PersonWebService {
    @WebMethod(operationName = "getPersons")
    public Collection<Person> getPersons() {
        var dao = new PostgreSQLDAO();
        return dao.getPersons();
    }
}
