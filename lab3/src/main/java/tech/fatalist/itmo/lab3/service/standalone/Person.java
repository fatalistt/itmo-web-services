package tech.fatalist.itmo.lab3.service.standalone;

import java.util.Arrays;
import java.util.Objects;

public final class Person {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String country;
    private String city;
    private byte[] avatar;

    public Person() {
    }

    public Person(
            int id,
            String name,
            String surname,
            int age,
            String country,
            String city,
            byte[] avatar) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.country = country;
        this.city = city;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public boolean hasAvatar() {
        return avatar != null && avatar.length > 0;
    }

    @Override
    public String toString() {
        return "Person[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", hasAvatar='" + hasAvatar() + '\'' +
                ']';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Person) obj;
        return this.id == that.id &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.surname, that.surname) &&
                this.age == that.age &&
                Objects.equals(this.country, that.country) &&
                Objects.equals(this.city, that.city) &&
                Arrays.equals(this.avatar, that.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
