package src.Training.Ex13.Repository;

import src.Training.Ex13.Model.Employee;

import java.util.List;

public interface EmployeeRepository {
    boolean insert(Employee employee);
    boolean delete(String id);
    Employee findById(String id);

    List<Employee> findAllEmployee();

    boolean update(String id, Employee employee);
}

