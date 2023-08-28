package src.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    private static String userName = "root";
    private static String pass = "123456";
    private static String url = "jdbc:mysql://localhost:3306/demo";

    public static Connection getConnection() {
        try{
            return DriverManager.getConnection(url, userName, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
