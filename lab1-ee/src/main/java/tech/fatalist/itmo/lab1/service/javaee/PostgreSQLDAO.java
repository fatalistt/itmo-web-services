package tech.fatalist.itmo.lab1.service.javaee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class PostgreSQLDAO {
    private final Connection connection;

    public PostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    public Collection<Person> getPersons(String name, String surname, Integer age, String country, String city) throws SQLException {
        var persons = new ArrayList<Person>();
        var statement = connection.prepareStatement(createSql(name, surname, age, country, city));
        setParameters(statement, name, surname, age, country, city);
        var resultSet = statement.executeQuery();

        while (resultSet.next()) {
            var person = new Person(
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getInt("age"),
                    resultSet.getString("country"),
                    resultSet.getString("city"),
                    resultSet.getBytes("avatar"));
            persons.add(person);
        }

        return persons;
    }

    private static String createSql(String name, String surname, Integer age, String country, String city) {
        var queryBuilder = new StringBuilder("select * from lab1.persons");
        var notFirst = tryAddAndCondition(queryBuilder, name, "name", true);
        notFirst = tryAddAndCondition(queryBuilder, surname, "surname", !notFirst);
        notFirst = tryAddAndCondition(queryBuilder, age, "age", !notFirst);
        notFirst = tryAddAndCondition(queryBuilder, country, "country", !notFirst);
        notFirst = tryAddAndCondition(queryBuilder, city, "city", !notFirst);
        return queryBuilder.toString();
    }

    private static boolean tryAddAndCondition(StringBuilder sb, Object obj, String name, boolean isFirst) {
        if (obj != null) {
            if (isFirst) {
                sb.append(" where");
            } else {
                sb.append(" and");
            }
            sb.append(" ");
            sb.append(name);
            sb.append(" = ?");
            return true;
        }

        return false;
    }

    private static void setParameters(PreparedStatement statement, String name, String surname, Integer age, String country, String city) throws SQLException {
        var i = 1;
        i += tryAddParameter(statement, name, i) ? 1 : 0;
        i += tryAddParameter(statement, surname, i) ? 1 : 0;
        i += tryAddParameter(statement, age, i) ? 1 : 0;
        i += tryAddParameter(statement, country, i) ? 1 : 0;
        i += tryAddParameter(statement, city, i) ? 1 : 0;
    }

    private static boolean tryAddParameter(PreparedStatement statement, Object obj, int index) throws SQLException {
        if (obj != null) {
            if (obj instanceof String) {
                statement.setString(index, (String) obj);
            } else if (obj instanceof Integer) {
                statement.setInt(index, (Integer) obj);
            } else {
                throw new IllegalArgumentException("unsupported obj type: " + obj.getClass().getName());
            }
            return true;
        }
        return false;
    }
}
