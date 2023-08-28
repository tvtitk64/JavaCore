package src.Training.Ex14.Repository;

import src.Training.Ex14.Model.GoodStudent;
import src.Training.Ex14.Model.NormalStudent;
import src.Training.Ex14.Model.Student;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static final String insertStudent = "insert into students(fullName, dateOfBirth, sex, phoneNumber, universityName, grade) values(?,?, ?,?, ?, ?)";
    private static final String insertGoodStudent = "insert into good_students(student_id, gpa, bestReward) values(?, ?, ?)";
    private static final String insertNormalStudent = "insert into normal_students(student_id, entryTestScore, EnglistScore) values(?, ?, ?)";
    private static final String queryGoodStudent = """
            select * from good_student inner join students on good_student.student_id = students.id""";
    private static final String queryNormalStudent = """
            select * from normal_student inner join students on normal_student.student_id = students.id""";

    public static void insertGoodStudent(GoodStudent goodStudent) throws SQLException {
        Connection connection = Database.getConnection();
        try{
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(insertStudent, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, goodStudent.getFullName());
            preparedStatement.setString(2, goodStudent.getDateOfBirth());
            preparedStatement.setString(3, goodStudent.getSex());
            preparedStatement.setString(4, goodStudent.getPhoneNumber());
            preparedStatement.setString(5, goodStudent.getUniversityName());
            preparedStatement.setString(6, goodStudent.getGradeLevel());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                if (id == 0) {
                    connection.rollback();
                }
                PreparedStatement preparedStatement1 = connection.prepareStatement(insertGoodStudent);
                preparedStatement1.setInt(1,id);
                preparedStatement1.setDouble(2, goodStudent.getGpa());
                preparedStatement1.setString(3,goodStudent.getBestRewardName());
                preparedStatement1.executeUpdate();
            }
            connection.commit();
        } catch (Exception e) {
            System.out.println(e.toString());
            connection.rollback();
            throw e;
        }
    }

    public static void insertNormalStudent(NormalStudent normalStudent) throws SQLException {
        Connection connection = Database.getConnection();
        try{
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(insertStudent, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, normalStudent.getFullName());
            preparedStatement.setString(2, normalStudent.getDateOfBirth());
            preparedStatement.setString(3, normalStudent.getSex());
            preparedStatement.setString(4, normalStudent.getPhoneNumber());
            preparedStatement.setString(5, normalStudent.getUniversityName());
            preparedStatement.setString(6, normalStudent.getGradeLevel());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                if (id == 0) {
                    connection.rollback();
                }
                PreparedStatement preparedStatement1 = connection.prepareStatement(insertNormalStudent);
                preparedStatement1.setInt(1,id);
                preparedStatement1.setDouble(2, normalStudent.getEntryTestScore());
                preparedStatement1.setDouble(3,normalStudent.getEnglishScore());
                preparedStatement1.executeUpdate();
            }
            connection.commit();
        } catch (Exception e) {
            System.out.println(e.toString());
            connection.rollback();
            throw e;
        }
    }

    public static List<Student> getAllStudent() throws SQLException {
        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(queryGoodStudent);
        List<Student> employees = new ArrayList<>();
        while (resultSet.next()) {
            float gpa = resultSet.getFloat(2);
            String bestRewardName = resultSet.getString(3);
            String fullName = resultSet.getString(5);
            String dateOfBirth = resultSet.getString(6);
            String phoneNumber = resultSet.getString(7);
            String universityName = resultSet.getString(8);
            String gradeLevel = resultSet.getString(9);
            String sex = resultSet.getString(10);
            Student student = new GoodStudent(fullName, dateOfBirth, sex, phoneNumber, universityName, gradeLevel, gpa, bestRewardName);
            employees.add(student);
        }
        resultSet = statement.executeQuery(queryNormalStudent);
        while (resultSet.next()) {
            int entryTestScore = resultSet.getInt(2);
            int englishScore = resultSet.getInt(3);
            String fullName = resultSet.getString(5);
            String dateOfBirth = resultSet.getString(6);
            String phoneNumber = resultSet.getString(7);
            String universityName = resultSet.getString(8);
            String gradeLevel = resultSet.getString(9);
            String sex = resultSet.getString(10);
            Student student = new NormalStudent(fullName, dateOfBirth, sex, phoneNumber, universityName, gradeLevel, englishScore, entryTestScore);
            employees.add(student);
        }
        return employees;
    }
}
