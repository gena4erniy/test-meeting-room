package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

    public void delete(Integer id) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://10.10.14.55:5432/officeAssistant", "postgres", "rty456");
        System.out.println("Успешно");
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM events WHERE id=" + id + ";");
        connection.close();
    }
}

