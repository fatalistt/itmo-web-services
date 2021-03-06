
package tech.fatalist.itmo.lab1.client;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.4.2
 * 2021-04-11T14:36:10.102+03:00
 * Generated source version: 3.4.2
 *
 */
public final class PersonWebService_PersonWebServicePort_Client {

    private static final QName SERVICE_NAME = new QName("http://javaee.service.lab1.itmo.fatalist.tech/", "PersonService");

    private PersonWebService_PersonWebServicePort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = PersonService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        PersonService ss = new PersonService(wsdlURL, SERVICE_NAME);
        PersonWebService port = ss.getPersonWebServicePort();

        {
        System.out.println("Invoking getPersons...");
        java.lang.String _getPersons_name = null;
        java.lang.String _getPersons_surname = null;
        java.lang.Integer _getPersons_age = null;
        java.lang.String _getPersons_country = "Россия";
        java.lang.String _getPersons_city = "Санкт-Петербург";
        try {
            java.util.List<tech.fatalist.itmo.lab1.client.Person> _getPersons__return = port.getPersons(_getPersons_name, _getPersons_surname, _getPersons_age, _getPersons_country, _getPersons_city);
            System.out.println("getPersons.result=" + _getPersons__return);

        } catch (SQLException_Exception e) {
            System.out.println("Expected exception: SQLException has occurred.");
            System.out.println(e.toString());
        }

            }

        System.exit(0);
    }

}
