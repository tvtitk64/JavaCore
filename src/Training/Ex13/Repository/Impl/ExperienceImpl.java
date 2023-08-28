package src.Training.Ex13.Repository.Impl;

import src.Training.Ex13.Model.Employee;
import src.Training.Ex13.Model.Experience;
import src.Training.Ex13.Repository.DatabaseConnection;
import src.Training.Ex13.Repository.EmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExperienceImpl implements EmployeeRepository {
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
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            Experience experience = (Experience) employee;
            preparedStatement.setString(1,experience.getId());
            preparedStatement.setString(2,experience.getFullname());
            preparedStatement.setDate(3, Date.valueOf(experience.getBirthday()));
            preparedStatement.setString(4,experience.getPhone());
            preparedStatement.setString(5,experience.getEmail());
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {

                query = "INSERT INTO experience(yearOfExperience,proSkill,employee_id) value(?,?,?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1,experience.getExpInYear());
                preparedStatement.setString(2,experience.getProSkill());
                preparedStatement.setString(3,experience.getId());
                preparedStatement.execute();
                connection.commit();

            }


            connection.setAutoCommit(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            result = false;
            try {
                connection.rollback(savepoint);
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        finally {
            if (connection != null) {

                // Đóng kết nối
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return  result;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Employee findById(String id) {
        Connection connection = null;

        try {
            String query = "SELECT e.* , ex.yearOfExperience , ex.proSkill  FROM  employee e INNER JOIN  experience ex  ON e.id= ex.employee_id " +
                    "WHERE e.id= '" + id + "'";

            connection = DatabaseConnection.getConnection();
            Statement stmt = connection.createStatement();


            ResultSet resultSet = stmt.executeQuery(query);

            if (resultSet.next()) {
                String idrs = resultSet.getString("id");
                String fullName = resultSet.getString("full_name");
                String birthday = resultSet.getString("birthday");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String proSkill = resultSet.getString("proSkill");
                int yearOfExperience = resultSet.getInt("yearOfExperience");

                Experience experience = new Experience(idrs, fullName, birthday, phone, email, null, yearOfExperience,proSkill);
                return  experience;
            }


        } catch (Exception e) {
            e.printStackTrace();


        } finally {
            if (connection != null) {

                // Đóng kết nối
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
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
            String query = "SELECT e.* , ex.yearOfExperience , ex.proSkill  FROM  employee e INNER JOIN  experience ex  ON e.id= ex.employee_id ";


            connection = DatabaseConnection.getConnection();
            Statement stmt = connection.createStatement();


            ResultSet resultSet = stmt.executeQuery(query);
            List<Employee> experiences = new ArrayList<>();
            // Xử lý kết quả truy vấn
            while (resultSet.next()) {
                String idrs = resultSet.getString("id");
                String fullName = resultSet.getString("full_name");
                String birthday = resultSet.getString("birthday");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String proSkill = resultSet.getString("proSkill");
                int yearOfExperience = resultSet.getInt("yearOfExperience");

                Experience experience = new Experience(idrs, fullName, birthday, phone, email, null, yearOfExperience,proSkill);
                experiences.add(experience);
            }
            return experiences;


        } catch (Exception e) {
            e.printStackTrace();


        } finally {
            if (connection != null) {

                // Đóng kết nối
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public boolean update(String id, Employee employee) {
        boolean result = true;
        Connection connection = null;
        Savepoint savepoint = null;
        try {

            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("Savepoint1");
            String query = " UPDATE employee  set id = ? , full_name =? , birthday =?, phone = ? , email = ?"+" WHERE id= ?";
            PreparedStatement pstmt = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            Experience experience = (Experience) employee;
            pstmt.setString(1,experience.getId());
            pstmt.setString(2,experience.getFullname());
            pstmt.setDate(3, Date.valueOf(experience.getBirthday()));
            pstmt.setString(4,experience.getPhone());
            pstmt.setString(5,experience.getEmail());
            pstmt.setString(6,experience.getId());
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {

                query = "UPDATE experience set yearOfExperience =? , proSkill=? " +" WHERE employee_id= ?";
                pstmt = connection.prepareStatement(query);
                pstmt.setInt(1,experience.getExpInYear());
                pstmt.setString(2,experience.getProSkill());
                pstmt.setString(3,experience.getId());
                pstmt.execute();
                connection.commit();

            }


            connection.setAutoCommit(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            result = false;
            try {
                connection.rollback(savepoint);
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        finally {
            if (connection != null) {

                // Đóng kết nối
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return  result;
    }
}
