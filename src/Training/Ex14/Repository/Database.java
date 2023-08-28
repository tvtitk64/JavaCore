package src.Training.Ex14.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection connection = null;

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(src.Training.Ex13.Constant.Database.url, src.Training.Ex13.Constant.Database.user, src.Training.Ex13.Constant.Database.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
