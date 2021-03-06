
package tech.fatalist.itmo.lab3.client;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.4.2
 * 2021-05-09T19:04:43.347+03:00
 * Generated source version: 3.4.2
 */

@WebFault(name = "SQLException", targetNamespace = "http://standalone.service.lab3.itmo.fatalist.tech/")
public class SQLException_Exception extends Exception {

    private tech.fatalist.itmo.lab3.client.SQLException faultInfo;

    public SQLException_Exception() {
        super();
    }

    public SQLException_Exception(String message) {
        super(message);
    }

    public SQLException_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public SQLException_Exception(String message, tech.fatalist.itmo.lab3.client.SQLException sqlException) {
        super(message);
        this.faultInfo = sqlException;
    }

    public SQLException_Exception(String message, tech.fatalist.itmo.lab3.client.SQLException sqlException, java.lang.Throwable cause) {
        super(message, cause);
        this.faultInfo = sqlException;
    }

    public tech.fatalist.itmo.lab3.client.SQLException getFaultInfo() {
        return this.faultInfo;
    }
}
