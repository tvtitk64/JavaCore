package src.Training.Ex13.Controller;

import src.Training.Ex13.Exception.BirthdayException;
import src.Training.Ex13.Exception.EmailException;
import src.Training.Ex13.Exception.FullnameException;
import src.Training.Ex13.Exception.PhoneException;
import src.Training.Ex13.Model.Employee;
import src.Training.Ex13.Model.Experience;
import src.Training.Ex13.Model.Fresher;
import src.Training.Ex13.Model.Intern;

import java.util.Scanner;

public class UI {
    Scanner scanner = new Scanner(System.in);
    private EmployeeManagement employeeManagement = new EmployeeManagement();


    public void delete() {
        System.out.print("Input ID to deleet: ");
        String id = scanner.nextLine();
        this.employeeManagement.deleteEmployee(id);
        // TODO SHOW MESSAGE HERE
    }

    public void showAllEmployee() {
        this.employeeManagement.findAll().forEach(Employee::showInformation);
    }

    private void checkData(Employee employee) throws BirthdayException, PhoneException, EmailException, FullnameException {
        Validator.birthdayCheck(employee.getBirthday());
        Validator.phoneCheck(employee.getPhone());
        Validator.emailCheck(employee.getEmail());
        Validator.nameCheck(employee.getFullname());
    }
}
