package src.Training.Ex13.Repository.Impl;

import src.Training.Ex13.Model.Employee;
import src.Training.Ex13.Model.Experience;
import src.Training.Ex13.Model.Fresher;
import src.Training.Ex13.Repository.DatabaseConnection;
import src.Training.Ex13.Repository.EmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FresherImpl implements EmployeeRepository {
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
            Fresher fresher = (Fresher) employee;
            preparedStatement.setString(1,fresher.getId());
            preparedStatement.setString(2,fresher.getFullname());
            preparedStatement.setDate(3, Date.valueOf(fresher.getBirthday()));
            preparedStatement.setString(4,fresher.getPhone());
            preparedStatement.setString(5,fresher.getEmail());
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {

                query = "INSERT INTO fresher((graduation_date,graduation_rank,education,employee_id) value(?,?,?,?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1,fresher.getGraduationDate());
                preparedStatement.setString(2,fresher.getGraduationRank());
                preparedStatement.setString(3,fresher.getEducation());
                preparedStatement.setString(4,fresher.getId());
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
                e1.printStackTrace();
            }
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
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
            String query = "SELECT e.* , fr.graduation_date , fr.graduation_rank , fr.education  FROM  employee e INNER JOIN  fresher fr  ON e.id= fr.employee_id \" +\n" +
                    "                    \"WHERE e.id= '\" + id + \"'";

            connection = DatabaseConnection.getConnection();
            Statement stmt = connection.createStatement();


            ResultSet resultSet = stmt.executeQuery(query);

            if (resultSet.next()) {
                String idrs = resultSet.getString("id");
                String fullName = resultSet.getString("full_name");
                String birthday = resultSet.getString("birthday");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String education = resultSet.getString("education");
                String graduationRank = resultSet.getString("graduation_rank");
                String graduationDate = resultSet.getString("graduation_date");

                Fresher fresher = new Fresher(idrs, fullName, birthday, phone, email, null, graduationDate,graduationRank, education);
                return  fresher;
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
            String query = "SELECT e.* , fr.graduation_date , fr.graduation_rank , fr.education  FROM  employee e INNER JOIN  fresher fr  ON e.id= fr.employee_id";


            connection = DatabaseConnection.getConnection();
            Statement stmt = connection.createStatement();


            ResultSet resultSet = stmt.executeQuery(query);
            List<Employee> freshers = new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String fullName = resultSet.getString("full_name");
                String birthday = resultSet.getString("birthday");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String education = resultSet.getString("education");
                String graduationRank = resultSet.getString("graduation_rank");
                String graduationDate = resultSet.getString("graduation_date");

                Fresher fresher = new Fresher(id, fullName, birthday, phone, email, null, graduationDate,graduationRank, education);
                freshers.add(fresher);
            }
            return freshers;


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
    public boolean update(String id, Employee employee) {
        boolean result = true;
        Connection connection = null;
        Savepoint savepoint = null;
        try {

            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("Savepoint1");
            String query = " UPDATE employee  set id = ? , full_name =? , birthday =?, phone = ? , email = ?\"+\" WHERE id= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            Fresher fresher = (Fresher) employee;
            preparedStatement.setString(1,fresher.getId());
            preparedStatement.setString(2,fresher.getFullname());
            preparedStatement.setString(3, fresher.getBirthday());
            preparedStatement.setString(4,fresher.getPhone());
            preparedStatement.setString(5,fresher.getEmail());
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {

                query = "UPDATE fresher set graduation_date =? , graduation_rank=?, education =? \" +\" WHERE employee_id= ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1,fresher.getGraduationDate());
                preparedStatement.setString(2,fresher.getGraduationRank());
                preparedStatement.setString(3,fresher.getEducation());
                preparedStatement.setString(4,fresher.getId());
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
                e1.printStackTrace();
            }
        }
        finally {
            if (connection != null) {

                // Đóng kết nối
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return  result;
    }
}
