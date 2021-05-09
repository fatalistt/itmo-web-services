package tech.fatalist.itmo.lab4.client;

import org.glassfish.jersey.client.JerseyClientBuilder;

public class App {
    public static void main(String[] args) {
        final var client = new PersonClient("http://0.0.0.0:8080/rest/", new JerseyClientBuilder().build());
        var persons = client.getPersons(null, null, null, null, null);
        System.out.println("Response:");
        persons.forEach(System.out::println);
    }
}
