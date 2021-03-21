package tech.fatalist.itmo.lab1.service.javaee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class PostgreSQLDAO {
    private final Connection connection;

    public PostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    public Collection<Person> getAllPersons() throws SQLException {
        var persons = new ArrayList<Person>();
        var statement = connection.createStatement();
        var resultSet = statement.executeQuery("select * from lab1.persons");

        while (resultSet.next()) {
            var name = resultSet.getString("name");
            var surname = resultSet.getString("surname");
            var age = resultSet.getInt("age");

            var person = new Person(name, surname, age);
            persons.add(person);
        }

        return persons;
    }

    public Collection<Person> getPersonsByName(String name) throws SQLException {
        var persons = new ArrayList<Person>();
        var statement = connection.prepareStatement("select * from lab1.persons where name = ?");
        statement.setString(1, name);
        var resultSet = statement.executeQuery();

        while (resultSet.next()) {
            var person = new Person(
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getInt("age")
            );
            persons.add(person);
        }

        return persons;

    }
}
