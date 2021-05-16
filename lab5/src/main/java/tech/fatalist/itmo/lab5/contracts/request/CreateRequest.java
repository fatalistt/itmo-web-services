package tech.fatalist.itmo.lab5.contracts.request;

public record CreateRequest(
        String name,
        String surname,
        Integer age,
        String country,
        String city,
        byte[] avatar) {
}
