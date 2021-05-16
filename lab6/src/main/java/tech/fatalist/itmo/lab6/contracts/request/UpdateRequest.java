package tech.fatalist.itmo.lab6.contracts.request;

public record UpdateRequest(
        String name,
        String surname,
        Integer age,
        String country,
        String city,
        byte[] avatar) {
}
