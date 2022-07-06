package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    public Connection connectionDataBase() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://10.10.14.55:5432/officeAssistant", "postgres", "rty456");
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }
}

