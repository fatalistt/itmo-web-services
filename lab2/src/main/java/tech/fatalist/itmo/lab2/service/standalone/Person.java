package tech.fatalist.itmo.lab2.service.standalone;

public record Person(
    String name,
    String surname,
    int age,
    String country,
    String city,
    byte[] avatar) {

    public Person() {
        this(null, null, 0, null, null, null);
    }

    public boolean hasAvatar() {
        return avatar != null && avatar.length > 0;
    }

    @Override
    public String toString() {
        return "Person[" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", hasAvatar='" + hasAvatar() + '\'' +
                ']';
    }
}
