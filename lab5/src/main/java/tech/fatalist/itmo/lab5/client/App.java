package tech.fatalist.itmo.lab5.client;

import org.glassfish.jersey.client.JerseyClientBuilder;

public class App {
    public static void main(String[] args) {
        final var client = new PersonClient("http://0.0.0.0:8080/rest/", new JerseyClientBuilder().build());
        var persons = client.getPersons(null, null, null, null, null);
        System.out.println("Response:");
        persons.forEach(System.out::println);

        var createdId = client.createPerson(
                "Иван",
                "Иванов",
                30,
                "Россия",
                "Санкт-Петербург",
                new byte[]{1, 2, 3});
        System.out.printf("Created id: %d%n", createdId);

        var person = client.getPerson(createdId);
        System.out.printf("Created person: %s%n", person);

        var isUpdated = client.updatePerson(createdId, "НовыйИван", null, null, null, null, null);
        System.out.printf("Is updated: %b%n", isUpdated);

        person = client.getPerson(createdId);
        System.out.printf("Updated person: %s%n", person);

        var isDeleted = client.deletePerson(createdId);
        System.out.printf("Is deleted: %b%n", isDeleted);

        person = client.getPerson(createdId);
        System.out.printf("Deleted person: %s%n", person);
    }
}
