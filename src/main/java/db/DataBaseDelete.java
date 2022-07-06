package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseDelete {
    private DataBase dataBase;
    private static Connection connection;

    public void deleteEvenDataBase(Integer id) {
        try {
            dataBase = new DataBase();
            connection = dataBase.connectionDataBase();
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM events WHERE id=" + id + ";");
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
