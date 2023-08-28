package src.Training.Ex13.Repository.Impl;

import src.Training.Ex13.Model.Employee;
import src.Training.Ex13.Model.Intern;
import src.Training.Ex13.Repository.DatabaseConnection;
import src.Training.Ex13.Repository.EmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InternImpl implements EmployeeRepository {
    @Override
    public boolean insert(Employee employee) {
        boolean result = true;
        Connection connection = null;
        Savepoint savepoint = null;
        try {

            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("Savepoint1");
            String query = "INSERT INTO employee(id,full_name,birthday,phone,email) value(?,?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(query);
            Intern intern = (Intern) employee;
            pstmt.setString(1, intern.getId());
            pstmt.setString(2, intern.getFullname());
            pstmt.setString(3, intern.getBirthday());
            pstmt.setString(4, intern.getPhone());
            pstmt.setString(5, intern.getEmail());
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {


                query = "INSERT INTO intern(major,semester,university_name,employee_id) value(?,?,?,?)";
                pstmt = connection.prepareStatement(query);
                pstmt.setString(1, intern.getMajors());
                pstmt.setInt(2, intern.getSemeters());
                pstmt.setString(3, intern.getUniversityName());
                pstmt.setString(4, intern.getId());
                pstmt.execute();
                connection.commit();

            }


            connection.setAutoCommit(true);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
            try {
                connection.rollback(savepoint);
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Employee findById(String id) {

        Connection connection = null;

        try {
            String query = "SELECT e.* , it.major , it.semester , it.university_name  FROM  employee e INNER JOIN  intern it  ON e.id= it.employee_id " +
                    "WHERE e.id= '" + id + "'";

            connection = DatabaseConnection.getConnection();
            Statement stmt = connection.createStatement();


            ResultSet resultSet = stmt.executeQuery(query);
            // Xử lý kết quả truy vấn
            if (resultSet.next()) {
                String idrs = resultSet.getString("id");
                String fullName = resultSet.getString("full_name");
                String birthday = resultSet.getString("birthday");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String major = resultSet.getString("major");
                int semester = resultSet.getInt("semester");
                String university_name = resultSet.getString("university_name");

                Intern intern = new Intern(idrs, fullName, birthday, phone, email, null, major, semester, university_name);
                return  intern;
            }


        } catch (Exception e) {
            e.printStackTrace();


        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public List<Employee> findAllEmployee() {
        Connection connection = null;

        try {
            String query = "SELECT e.* , it.major , it.semester , it.university_name  FROM  employee e INNER JOIN  intern it  ON e.id= it.employee_id ";


            connection = DatabaseConnection.getConnection();
            Statement stmt = connection.createStatement();


            ResultSet resultSet = stmt.executeQuery(query);
            List<Employee> interns = new ArrayList<>();
            // Xử lý kết quả truy vấn
            while (resultSet.next()) {
                String idrs = resultSet.getString("id");
                String fullName = resultSet.getString("full_name");
                String birthday = resultSet.getString("birthday");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String major = resultSet.getString("major");
                int semester = resultSet.getInt("semester");
                String university_name = resultSet.getString("university_name");

                Intern intern = new Intern(idrs, fullName, birthday, phone, email, null, major, semester, university_name);
                interns.add(intern);
            }
            return interns;


        } catch (Exception e) {
            e.printStackTrace();


        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public boolean update(String id, Employee e) {
        boolean result = true;
        Connection connection = null;
        Savepoint savepoint = null;
        try {

            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("Savepoint1");
            String query = " UPDATE employee  set id = ? , full_name =? , birthday =?, phone = ? , email = ?"+" WHERE id= ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            Intern intern = (Intern) e;
            pstmt.setString(1, intern.getId());
            pstmt.setString(2, intern.getFullname());
            pstmt.setDate(3, Date.valueOf(intern.getBirthday()));
            pstmt.setString(4, intern.getPhone());
            pstmt.setString(5, intern.getEmail());
            pstmt.setString(6, id);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {


                query = "UPDATE intern set major =? , semester=?, university_name =? " +" WHERE employee_id= ?";
                pstmt = connection.prepareStatement(query);
                pstmt.setString(1, intern.getMajors());
                pstmt.setInt(2, intern.getSemeters());
                pstmt.setString(3, intern.getUniversityName());
                pstmt.setString(4, intern.getId());
                pstmt.execute();
                connection.commit();

            }


            connection.setAutoCommit(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            result = false;
            try {
                connection.rollback(savepoint);
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } finally {
            if (connection != null) {

                // Đóng kết nối
                try {
                    connection.close();
                } catch (SQLException ex) {
                    // TODO Auto-generated catch block
                    ex.printStackTrace();
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        EmployeeRepository employeeRepository = new InternImpl();
        List<Employee> employee = employeeRepository.findAllEmployee();
    }
}
