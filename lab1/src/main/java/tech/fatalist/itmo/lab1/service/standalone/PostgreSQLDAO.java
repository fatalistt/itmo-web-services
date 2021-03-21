package tech.fatalist.itmo.lab1.service.standalone;

import tech.fatalist.itmo.lab1.common.Person;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDAO {
    private static final Logger logger = Logger.getLogger(PostgreSQLDAO.class.getName());

    public Collection<Person> getPersons() {
        var persons = new ArrayList<Person>();
        try (var connection = ConnectionUtil.getConnection()) {
            var statement = connection.createStatement();
            var resultSet = statement.executeQuery("select * from lab1.persons");

            while (resultSet.next()) {
                var name = resultSet.getString("name");
                var surname = resultSet.getString("surname");
                var age = resultSet.getInt("age");

                var person = new Person(name, surname, age);
                persons.add(person);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        return persons;
    }
}
