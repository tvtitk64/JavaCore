package src.Training.Ex13.Repository.Impl;


import src.Training.Ex13.Model.Employee;
import src.Training.Ex13.Repository.DatabaseConnection;
import src.Training.Ex13.Repository.EmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;

public class EmployeeImpl implements EmployeeRepository {
    private ExperienceImpl experience = new ExperienceImpl();
    private FresherImpl fresher = new FresherImpl();
    private InternImpl intern = new InternImpl();

    @Override
    public boolean insert(Employee employee) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        boolean result = true;
        Connection connection = null;
        Savepoint savepoint = null;

        try {
            String s = "DELETE from employee where id = '" + id + "'";
            connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(s);
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("sp1");
            preparedStatement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
            try{
                connection.rollback(savepoint);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        finally{
            if (connection != null) {
                try{
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public Employee findById(String id) {
        Employee employee = experience.findById(id);
        if (employee == null) {
            employee = fresher.findById(id);
        }
        if (employee == null) {
            employee = intern.findById(id);
        }
        return employee;
    }

    @Override
    public List<Employee> findAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.addAll(experience.findAllEmployee());
        employeeList.addAll(fresher.findAllEmployee());
        employeeList.addAll(intern.findAllEmployee());
        return employeeList;
    }

    @Override
    public boolean update(String id, Employee employee) {
        return false;
    }

    public static void main(String[] args){
        EmployeeRepository employeeRepository = new EmployeeImpl();
        List<Employee> employeeList = employeeRepository.findAllEmployee();
    }

}
