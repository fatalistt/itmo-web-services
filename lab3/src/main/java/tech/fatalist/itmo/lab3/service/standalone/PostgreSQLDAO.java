package tech.fatalist.itmo.lab3.service.standalone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PostgreSQLDAO {
    private final Connection connection;

    public PostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    public Collection<Person> GetPersons(String name, String surname, Integer age, String country, String city) throws SQLException {
        var persons = new ArrayList<Person>();
        var getSql = createSqlParams(" and ", c -> String.format("%s = ?", c), name, surname, age, country, city, null);
        var statement = connection.prepareStatement(String.format("select * from lab1.persons%s", getSql.sql.length() > 0 ? " where " + getSql.sql : ""));
        for (var setter : getSql.setters) {
            setter.SetParam(statement);
        }
        var resultSet = statement.executeQuery();

        while (resultSet.next()) {
            var person = new Person(
                    resultSet.getInt("id"),
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

    public boolean DeletePerson(int id) throws SQLException {
        var statement = connection.prepareStatement("delete from lab1.persons where id = ?");
        statement.setInt(1, id);
        var affected = statement.executeUpdate();
        return affected > 0;
    }

    public boolean UpdatePerson(int id, String name, String surname, Integer age, String country, String city, byte[] avatar) throws SQLException {
        var updateSql = createSqlParams(", ", c -> String.format("%s = ?", c), name, surname, age, country, city, avatar);
        if (updateSql.sql.length() == 0) {
            return false;
        }
        var statement = connection.prepareStatement(String.format("update lab1.persons set %s where id = ?", updateSql.sql));
        for (var setter : updateSql.setters) {
            setter.SetParam(statement);
        }
        statement.setInt(updateSql.setters.size() + 1, id);
        var affected = statement.executeUpdate();
        return affected > 0;
    }

    public int CreatePerson(String name, String surname, Integer age, String country, String city, byte[] avatar) throws SQLException {
        var insertSql = createSqlParams(", ", c -> c, name, surname, age, country, city, avatar);
        String valuesSql;
        if (insertSql.sql.length() == 0)
        {
            valuesSql = "DEFAULT VALUES";
        } else {
            var questionMarks = IntStream.range(0, insertSql.setters.size()).mapToObj(idx -> "?").collect(Collectors.joining(", "));
            valuesSql = String.format("(%s) VALUES (%s)", insertSql.sql, questionMarks);
        }
        var statement = connection.prepareStatement(String.format("insert into lab1.persons %s", valuesSql), Statement.RETURN_GENERATED_KEYS);
        for (var setter : insertSql.setters) {
            setter.SetParam(statement);
        }
        statement.executeUpdate();
        var keys = statement.getGeneratedKeys();
        keys.next();
        return keys.getInt(1);
    }

    private static SqlParams createSqlParams(String delimiter, Function<String, String> nameFormat, String name, String surname, Integer age, String country, String city, byte[] avatar) {
        ColumnValue[] columns = {
            new ColumnValue("name", name),
            new ColumnValue("surname", surname),
            new ColumnValue("age", age),
            new ColumnValue("country", country),
            new ColumnValue("city", city),
            new ColumnValue("avatar", avatar)
        };
        var notNullColumns = Arrays.stream(columns)
                .filter(v -> v.value != null)
                .collect(Collectors.toCollection(ArrayList::new));
        String conditions = "";
        Collection<StatementSetter> paramsSetters = new ArrayList<>(0);
        if (notNullColumns.size() > 0) {
            conditions = notNullColumns.stream()
                    .map(v -> v.name)
                    .map(nameFormat)
                    .collect(Collectors.joining(delimiter));
            paramsSetters = IntStream.range(0, notNullColumns.size())
                    .mapToObj(idx -> createSetter(idx + 1, notNullColumns.get(idx).value))
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        return new SqlParams(conditions, paramsSetters);
    }

    private static StatementSetter createSetter(int index, Object value) {
        if (value instanceof String){
            return statement -> statement.setString(index, (String) value);
        }
        if (value instanceof Integer) {
            return statement -> statement.setInt(index, (Integer) value);
        }
        if (value instanceof byte[]) {
            return statement -> statement.setBytes(index, (byte[]) value);
        }

        throw new IllegalArgumentException("unsupported obj type: " + value.getClass().getName());
    }

    private record ColumnValue(String name, Object value){
    }

    private record SqlParams(String sql, Collection<StatementSetter> setters){
    }

    @FunctionalInterface
    private interface StatementSetter {
        void SetParam(PreparedStatement statement) throws SQLException;
    }
}
