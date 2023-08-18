package src.Training.Ex13.Controller;

import src.Training.Ex13.Model.Employee;
import src.Training.Ex13.Model.Experience;
import src.Training.Ex13.Model.Fresher;
import src.Training.Ex13.Model.Intern;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeManagement {
    private List<Employee> employeeList = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
        Employee.count++;
    }

    public Employee findById(String id) {
        return employeeList.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
    }

    public void deleteEmployee(String id) {
        Optional<Employee> employee = employeeList.stream().filter(employee1 -> employee1.getId().equals(id)).findFirst();
        if (employee.isPresent()) {
            employeeList.remove(employee);
            Employee.count--;
        }
    }

    public List<Employee> findByType(int type) {
        return employeeList.stream()
                .filter(employee -> {
                    if (type == 0) {
                        return employee instanceof Experience;
                    }
                    if (type == 1) {
                        return employee instanceof Fresher;
                    }
                    if (type == 2) {
                        return employee instanceof Intern;
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }

    public List<Employee> findAll() {
        return employeeList;
    }
}

