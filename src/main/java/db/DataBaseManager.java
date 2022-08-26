package db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static ui.constants.ApiData.*;

public class DataBaseManager {

    protected static final Logger logger = LoggerFactory.getLogger(DataBaseManager.class);
    private static Connection connection;
    private static Statement statement;

    public static void createConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            statement = connection.createStatement();
        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }

    public static void closeConnection() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }
}
