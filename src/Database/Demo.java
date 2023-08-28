package src.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.StreamSupport;

public class Demo {
    public static void main(String[] args) throws SQLException {
        Connection con = DBContext.getConnection();
        Statement st = con.createStatement(); {
            con.setAutoCommit(false);
            String sqlInsert1 = "insert into customer1 ('toan', 'bg','helu')";
            String sqlInsert2 = "insert into customer1 ('toan', 'bg','helu1')";
            try {
                st.executeUpdate(sqlInsert1);
                st.executeUpdate(sqlInsert2);
                System.out.println("Success");
                con.commit();
            } catch (Exception e) {
                e.printStackTrace();
                con.rollback();
                System.out.println("roll back");
            }
        }
    }
}
