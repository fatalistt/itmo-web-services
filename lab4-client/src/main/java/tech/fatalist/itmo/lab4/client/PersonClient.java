package tech.fatalist.itmo.lab4.client;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import java.util.Collection;

public class PersonClient {
    private final String baseUrl;
    private final Client rsClient;

    public PersonClient(String baseUrl, Client rsClient) {
        this.baseUrl = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;
        this.rsClient = rsClient;
    }

    public Collection<Person> getPersons(
            String name,
            String surname,
            Integer age,
            String country,
            String city
    ) {
        var resource = rsClient.target(baseUrl + "/persons");
        addParamIfNotNull(resource, "name", name);
        addParamIfNotNull(resource, "surname", surname);
        addParamIfNotNull(resource, "age", age);
        addParamIfNotNull(resource, "country", country);
        addParamIfNotNull(resource, "city", city);
        return resource.request(MediaType.APPLICATION_JSON).get(new GenericType<>() {
        });
    }

    private static void addParamIfNotNull(WebTarget webTarget, String name, Object param) {
        if (param != null) {
            webTarget.queryParam(name, param);
        }
    }
}
