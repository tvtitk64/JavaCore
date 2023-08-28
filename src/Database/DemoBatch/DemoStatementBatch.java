package src.Database.DemoBatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DemoStatementBatch {
    public static List<User> init() {
        List<User> listUser = new ArrayList<User>();
        for (int i= 0; i< 10000; i++) {
            listUser.add(new User("name"+i,"address"+i));
        }

        return listUser;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        demoInsertWithoutBatch();
        System.out.println("---------------------------------------------------------------");
        demoInsertWithBatch(200);
    }

    public static void demoInsertWithBatch(int batchSize) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo-jdbc-batch", "root", "admin1234");
        Statement statement = connection.createStatement();
        connection.setAutoCommit(false);
        long startTime = System.currentTimeMillis();
        List<User> listUser = init();
        System.out.println("Batch - Inserting... ");
        for (int i = 0; i< listUser.size(); i++) {
            String sql = "INSERT INTO user_info (name, address) VALUES ('"+listUser.get(i).getName()+"', '"+listUser.get(i).getAddress()+"');";
            statement.addBatch(sql);
            if (i % batchSize == 0) {
                statement.executeBatch();
            }
        }
        statement.executeBatch();
        connection.commit();
        long endTime = System.currentTimeMillis();
        System.out.println("Total time: " + (endTime - startTime));
        connection.close();
    }

    public static void demoInsertWithoutBatch() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo-jdbc-batch", "root", "admin1234");
        Statement statement = connection.createStatement();
        long startTime = System.currentTimeMillis();
        List<User> listUser = init();
        System.out.println("Without Batch - Inserting... ");
        for (User user: listUser) {
            String sql = "INSERT INTO user_info (name, address) VALUES ('" +user.getName()+"', '" + user.getAddress()+ "');";
            statement.executeUpdate(sql);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total time: " + (endTime - startTime));
        connection.close();
    }
}
