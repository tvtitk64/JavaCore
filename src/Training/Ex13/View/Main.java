package src.Training.Ex13.View;
import src.Training.Ex13.Controller.EmployeeManagement;
import src.Training.Ex13.Exception.BirthdayException;
import src.Training.Ex13.Exception.EmailException;
import src.Training.Ex13.Exception.PhoneException;
import src.Training.Ex13.Model.Employee;

import java.util.*;

public class Main {
    public static Set<Employee> employeeSet;
    public static void main(String[] args) throws PhoneException, EmailException, BirthdayException {
        Main.employeeSet = new LinkedHashSet<>();
        EmployeeManagement employeeManagement = new EmployeeManagement(Main.employeeSet);
        employeeManagement.userOption();
    }
}
