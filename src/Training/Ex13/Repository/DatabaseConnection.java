package src.Training.Ex13.Repository;

import src.Training.Ex13.Constant.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(Database.url, Database.user, Database.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
