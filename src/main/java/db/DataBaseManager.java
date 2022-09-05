package db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ui.constants.ApiData.*;

public class DataBaseManager {

    protected static final Logger logger = LoggerFactory.getLogger(DataBaseManager.class);
    private static Connection connection;
    private static Statement statement;
    private static List<String> allIds = new ArrayList<>();

    public static List<String> getAllIds() {
        return allIds;
    }

    public static void addId(String id) {
        allIds.add(id);
    }

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
            allIds.clear();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }

    public static String getOfficeById(String id, String columnLabel) {
        String columnItem = "";
        String sql = "select * from offices where id = %s";
        try {
            ResultSet resultSet = statement.executeQuery(String.format(sql, id));
            while (resultSet.next()) {
                columnItem = resultSet.getString(columnLabel);
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return columnItem;
    }

    public static String getEventStatusById(String id) {
        String status = "";
        String sql = "select * from events where id = %s";
        try {
            ResultSet resultSet = statement.executeQuery(String.format(sql, id));
            while (resultSet.next()) {
                status = resultSet.getString("status");
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return status;
    }

    public static void deleteEvents(List<String> allIds) {
        String sql = "delete from events where id = %s";
        for (String id : allIds) {
            try {
                statement.executeUpdate(String.format(sql, id));
            } catch (SQLException e) {
                logger.error(e.toString());
            }
            logger.info("event with id " + id + " was deleted in DB");
        }
    }
}
