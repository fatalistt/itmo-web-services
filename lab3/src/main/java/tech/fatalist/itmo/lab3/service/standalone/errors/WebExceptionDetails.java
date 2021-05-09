package tech.fatalist.itmo.lab3.service.standalone.errors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public record WebExceptionDetails(String message) {
    public WebExceptionDetails() {
        this(null);
    }
}
