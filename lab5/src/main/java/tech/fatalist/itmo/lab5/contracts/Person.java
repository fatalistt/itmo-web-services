package tech.fatalist.itmo.lab5.contracts;

import java.util.Arrays;

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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", avatar=" + Arrays.toString(avatar) +
                '}';
    }
}
