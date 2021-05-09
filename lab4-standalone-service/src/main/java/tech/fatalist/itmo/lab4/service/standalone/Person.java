package tech.fatalist.itmo.lab4.service.standalone;

public record Person(
        int id,
        String name,
        String surname,
        int age,
        String country,
        String city,
        byte[] avatar) {

    public boolean hasAvatar() {
        return avatar != null && avatar.length > 0;
    }
}
