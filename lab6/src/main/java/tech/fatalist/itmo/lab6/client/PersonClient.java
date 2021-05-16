package tech.fatalist.itmo.lab6.client;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import tech.fatalist.itmo.lab6.contracts.Person;
import tech.fatalist.itmo.lab6.contracts.request.CreateRequest;
import tech.fatalist.itmo.lab6.contracts.request.UpdateRequest;
import tech.fatalist.itmo.lab6.contracts.response.CreateResponse;
import tech.fatalist.itmo.lab6.contracts.response.DeleteResponse;
import tech.fatalist.itmo.lab6.contracts.response.GetAllResponse;
import tech.fatalist.itmo.lab6.contracts.response.GetResponse;

public class PersonClient {
    private final String baseUrl;
    private final Client rsClient;

    public PersonClient(String baseUrl, Client rsClient) {
        this.baseUrl = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;
        this.rsClient = rsClient;
    }

    public Iterable<Person> getPersons(
            String name,
            String surname,
            Integer age,
            String country,
            String city
    ) {
        var resource = rsClient.target("%s/%s".formatted(baseUrl, "persons"));
        addParamIfNotNull(resource, "name", name);
        addParamIfNotNull(resource, "surname", surname);
        addParamIfNotNull(resource, "age", age);
        addParamIfNotNull(resource, "country", country);
        addParamIfNotNull(resource, "city", city);
        return resource.request(MediaType.APPLICATION_JSON).get(GetAllResponse.class).persons();
    }

    public Person getPerson(int id) {
        var resource = rsClient.target("%s/%s/%d".formatted(baseUrl, "persons", id));
        return resource.request(MediaType.APPLICATION_JSON).get(GetResponse.class).person();
    }

    public boolean deletePerson(int id) {
        var resource = rsClient.target("%s/%s/%d".formatted(baseUrl, "persons", id));
        return "success".equals(resource.request(MediaType.APPLICATION_JSON).delete(DeleteResponse.class).status());
    }

    public boolean updatePerson(
            int id,
            String name,
            String surname,
            Integer age,
            String country,
            String city,
            byte[] avatar) {
        var resource = rsClient.target("%s/%s/%d".formatted(baseUrl, "persons", id));
        var request = new UpdateRequest(name, surname, age, country, city, avatar);
        return "success".equals(resource.request(MediaType.APPLICATION_JSON).put(Entity.json(request), DeleteResponse.class).status());
    }

    public int createPerson(
            String name,
            String surname,
            Integer age,
            String country,
            String city,
            byte[] avatar) {
        var resource = rsClient.target("%s/%s".formatted(baseUrl, "persons"));
        var request = new CreateRequest(name, surname, age, country, city, avatar);
        return resource.request(MediaType.APPLICATION_JSON).post(Entity.json(request), CreateResponse.class).id();
    }

    private static void addParamIfNotNull(WebTarget webTarget, String name, Object param) {
        if (param != null) {
            webTarget.queryParam(name, param);
        }
    }
}
