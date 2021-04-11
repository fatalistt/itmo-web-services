package tech.fatalist.itmo.lab1.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.4.2
 * 2021-04-11T14:36:10.202+03:00
 * Generated source version: 3.4.2
 *
 */
@WebService(targetNamespace = "http://javaee.service.lab1.itmo.fatalist.tech/", name = "PersonWebService")
@XmlSeeAlso({ObjectFactory.class})
public interface PersonWebService {

    @WebMethod
    @RequestWrapper(localName = "getPersons", targetNamespace = "http://javaee.service.lab1.itmo.fatalist.tech/", className = "tech.fatalist.itmo.lab1.client.GetPersons")
    @ResponseWrapper(localName = "getPersonsResponse", targetNamespace = "http://javaee.service.lab1.itmo.fatalist.tech/", className = "tech.fatalist.itmo.lab1.client.GetPersonsResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<tech.fatalist.itmo.lab1.client.Person> getPersons(

        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name,
        @WebParam(name = "surname", targetNamespace = "")
        java.lang.String surname,
        @WebParam(name = "age", targetNamespace = "")
        java.lang.Integer age,
        @WebParam(name = "country", targetNamespace = "")
        java.lang.String country,
        @WebParam(name = "city", targetNamespace = "")
        java.lang.String city
    ) throws SQLException_Exception;
}