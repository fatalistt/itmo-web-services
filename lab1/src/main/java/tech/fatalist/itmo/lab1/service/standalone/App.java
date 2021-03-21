package tech.fatalist.itmo.lab1.service.standalone;

import javax.xml.ws.Endpoint;

public class App {
    public static void main(String[] args) {
        var url = "http://0.0.0.0:8080/PersonService";
        Endpoint.publish(url, new PersonWebService());
    }
}
