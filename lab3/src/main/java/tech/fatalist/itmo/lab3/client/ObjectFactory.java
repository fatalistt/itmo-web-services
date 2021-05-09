
package tech.fatalist.itmo.lab3.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tech.fatalist.itmo.lab3.client package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreatePerson_QNAME = new QName("http://standalone.service.lab3.itmo.fatalist.tech/", "createPerson");
    private final static QName _CreatePersonResponse_QNAME = new QName("http://standalone.service.lab3.itmo.fatalist.tech/", "createPersonResponse");
    private final static QName _DeletePerson_QNAME = new QName("http://standalone.service.lab3.itmo.fatalist.tech/", "deletePerson");
    private final static QName _DeletePersonResponse_QNAME = new QName("http://standalone.service.lab3.itmo.fatalist.tech/", "deletePersonResponse");
    private final static QName _GetPersons_QNAME = new QName("http://standalone.service.lab3.itmo.fatalist.tech/", "getPersons");
    private final static QName _GetPersonsResponse_QNAME = new QName("http://standalone.service.lab3.itmo.fatalist.tech/", "getPersonsResponse");
    private final static QName _UpdatePerson_QNAME = new QName("http://standalone.service.lab3.itmo.fatalist.tech/", "updatePerson");
    private final static QName _UpdatePersonResponse_QNAME = new QName("http://standalone.service.lab3.itmo.fatalist.tech/", "updatePersonResponse");
    private final static QName _WebExceptionDetails_QNAME = new QName("http://standalone.service.lab3.itmo.fatalist.tech/", "webExceptionDetails");
    private final static QName _ObjectNotFoundException_QNAME = new QName("http://standalone.service.lab3.itmo.fatalist.tech/", "ObjectNotFoundException");
    private final static QName _SQLException_QNAME = new QName("http://standalone.service.lab3.itmo.fatalist.tech/", "SQLException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tech.fatalist.itmo.lab3.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreatePerson }
     * 
     */
    public CreatePerson createCreatePerson() {
        return new CreatePerson();
    }

    /**
     * Create an instance of {@link CreatePersonResponse }
     * 
     */
    public CreatePersonResponse createCreatePersonResponse() {
        return new CreatePersonResponse();
    }

    /**
     * Create an instance of {@link DeletePerson }
     * 
     */
    public DeletePerson createDeletePerson() {
        return new DeletePerson();
    }

    /**
     * Create an instance of {@link DeletePersonResponse }
     * 
     */
    public DeletePersonResponse createDeletePersonResponse() {
        return new DeletePersonResponse();
    }

    /**
     * Create an instance of {@link GetPersons }
     * 
     */
    public GetPersons createGetPersons() {
        return new GetPersons();
    }

    /**
     * Create an instance of {@link GetPersonsResponse }
     * 
     */
    public GetPersonsResponse createGetPersonsResponse() {
        return new GetPersonsResponse();
    }

    /**
     * Create an instance of {@link UpdatePerson }
     * 
     */
    public UpdatePerson createUpdatePerson() {
        return new UpdatePerson();
    }

    /**
     * Create an instance of {@link UpdatePersonResponse }
     * 
     */
    public UpdatePersonResponse createUpdatePersonResponse() {
        return new UpdatePersonResponse();
    }

    /**
     * Create an instance of {@link WebExceptionDetails }
     * 
     */
    public WebExceptionDetails createWebExceptionDetails() {
        return new WebExceptionDetails();
    }

    /**
     * Create an instance of {@link SQLException }
     * 
     */
    public SQLException createSQLException() {
        return new SQLException();
    }

    /**
     * Create an instance of {@link DeletionResult }
     * 
     */
    public DeletionResult createDeletionResult() {
        return new DeletionResult();
    }

    /**
     * Create an instance of {@link CreationResult }
     * 
     */
    public CreationResult createCreationResult() {
        return new CreationResult();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link UpdateResult }
     * 
     */
    public UpdateResult createUpdateResult() {
        return new UpdateResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePerson }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreatePerson }{@code >}
     */
    @XmlElementDecl(namespace = "http://standalone.service.lab3.itmo.fatalist.tech/", name = "createPerson")
    public JAXBElement<CreatePerson> createCreatePerson(CreatePerson value) {
        return new JAXBElement<CreatePerson>(_CreatePerson_QNAME, CreatePerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePersonResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreatePersonResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://standalone.service.lab3.itmo.fatalist.tech/", name = "createPersonResponse")
    public JAXBElement<CreatePersonResponse> createCreatePersonResponse(CreatePersonResponse value) {
        return new JAXBElement<CreatePersonResponse>(_CreatePersonResponse_QNAME, CreatePersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePerson }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeletePerson }{@code >}
     */
    @XmlElementDecl(namespace = "http://standalone.service.lab3.itmo.fatalist.tech/", name = "deletePerson")
    public JAXBElement<DeletePerson> createDeletePerson(DeletePerson value) {
        return new JAXBElement<DeletePerson>(_DeletePerson_QNAME, DeletePerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePersonResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeletePersonResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://standalone.service.lab3.itmo.fatalist.tech/", name = "deletePersonResponse")
    public JAXBElement<DeletePersonResponse> createDeletePersonResponse(DeletePersonResponse value) {
        return new JAXBElement<DeletePersonResponse>(_DeletePersonResponse_QNAME, DeletePersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersons }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPersons }{@code >}
     */
    @XmlElementDecl(namespace = "http://standalone.service.lab3.itmo.fatalist.tech/", name = "getPersons")
    public JAXBElement<GetPersons> createGetPersons(GetPersons value) {
        return new JAXBElement<GetPersons>(_GetPersons_QNAME, GetPersons.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPersonsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://standalone.service.lab3.itmo.fatalist.tech/", name = "getPersonsResponse")
    public JAXBElement<GetPersonsResponse> createGetPersonsResponse(GetPersonsResponse value) {
        return new JAXBElement<GetPersonsResponse>(_GetPersonsResponse_QNAME, GetPersonsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePerson }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdatePerson }{@code >}
     */
    @XmlElementDecl(namespace = "http://standalone.service.lab3.itmo.fatalist.tech/", name = "updatePerson")
    public JAXBElement<UpdatePerson> createUpdatePerson(UpdatePerson value) {
        return new JAXBElement<UpdatePerson>(_UpdatePerson_QNAME, UpdatePerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePersonResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdatePersonResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://standalone.service.lab3.itmo.fatalist.tech/", name = "updatePersonResponse")
    public JAXBElement<UpdatePersonResponse> createUpdatePersonResponse(UpdatePersonResponse value) {
        return new JAXBElement<UpdatePersonResponse>(_UpdatePersonResponse_QNAME, UpdatePersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WebExceptionDetails }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WebExceptionDetails }{@code >}
     */
    @XmlElementDecl(namespace = "http://standalone.service.lab3.itmo.fatalist.tech/", name = "webExceptionDetails")
    public JAXBElement<WebExceptionDetails> createWebExceptionDetails(WebExceptionDetails value) {
        return new JAXBElement<WebExceptionDetails>(_WebExceptionDetails_QNAME, WebExceptionDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WebExceptionDetails }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WebExceptionDetails }{@code >}
     */
    @XmlElementDecl(namespace = "http://standalone.service.lab3.itmo.fatalist.tech/", name = "ObjectNotFoundException")
    public JAXBElement<WebExceptionDetails> createObjectNotFoundException(WebExceptionDetails value) {
        return new JAXBElement<WebExceptionDetails>(_ObjectNotFoundException_QNAME, WebExceptionDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SQLException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SQLException }{@code >}
     */
    @XmlElementDecl(namespace = "http://standalone.service.lab3.itmo.fatalist.tech/", name = "SQLException")
    public JAXBElement<SQLException> createSQLException(SQLException value) {
        return new JAXBElement<SQLException>(_SQLException_QNAME, SQLException.class, null, value);
    }

}
