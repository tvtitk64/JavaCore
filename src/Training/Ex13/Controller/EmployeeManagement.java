package src.Training.Ex13.Controller;

import src.Training.Ex13.Exception.BirthdayException;
import src.Training.Ex13.Exception.EmailException;
import src.Training.Ex13.Exception.PhoneException;
import src.Training.Ex13.Model.Employee;
import src.Training.Ex13.Model.Experience;
import src.Training.Ex13.Model.Fresher;
import src.Training.Ex13.Model.Intern;
import src.Training.Ex13.View.EmployeeEnum;
import src.Training.Ex13.View.Option;
import src.Training.Ex13.View.View;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeManagement {
    Scanner scanner = new Scanner(System.in);
    private Set<Employee> employeeSet;
    private View view;


    public EmployeeManagement(Set<Employee> employeeSet) {
        this.view = new View();
        this.employeeSet = employeeSet;
    }


    public void userOption() throws PhoneException, EmailException, BirthdayException {
        int menuOp;
        boolean condition = true;
        while (condition){
            view.printOption();
            menuOp = scanner.nextInt();
            Option option = Option.getEnumMenu(menuOp);
            switch (option){
                case ADD:
                    addEmployee();
                    break;

                case DELETE:
                    deleteEmployee();
                    break;

                case MODIFY:
                    modifyEmployee();
                    break;

                case SEARCH:
                    searchEmployee();
                    break;

                case EXIT:
                    condition = false;
                    break;

            }
        }
    }



    public void checkID(Employee employee) {
        Optional<Employee> check = this.employeeSet.stream()
                .filter(item -> item.equals(employee))
                .findFirst();

        if (check.isPresent()) {
            view.printReplaceOption();
            int option = new Scanner(System.in).nextInt();

            switch (option) {
                case 1:
                    this.employeeSet.remove(check.get());
                    this.employeeSet.add(employee);
                case 2:
                    return;
            }
        }
        this.employeeSet.add(employee);
    }

    public void addEmployee() throws BirthdayException, PhoneException, EmailException {
        view.printEmployeeOption();
        int employeeOption = new Scanner(System.in).nextInt();
        EmployeeEnum opt = EmployeeEnum.getEnumEmployee(employeeOption);

        Employee employee = view.createEmployee();

        switch (opt) {
            case EXPERIENCE:
                int expInYear = view.inputExpInYear();
                String proSkill = view.inputProSkill();

                Employee experience = new Experience(employee.getId(), employee.getFullname(), employee.getBirthday(),
                        employee.getPhone(), employee.getEmail(), EmployeeEnum.getString(EmployeeEnum.EXPERIENCE),
                        expInYear,proSkill);
                experience.addCertificate();
                checkID(experience);
                break;

            case FRESHER:
                String graduationDate = view.inputGraduationDate();
                String graduationRank = view.inputGraduationRank();
                String education = view.inputEducation();

                Employee fresher = new Fresher(employee.getId(), employee.getFullname(), employee.getBirthday(),
                        employee.getPhone(), employee.getEmail(), EmployeeEnum.getString(EmployeeEnum.FRESHER),
                        graduationDate,graduationRank,education);
                fresher.addCertificate();
                checkID(fresher);
                break;

            case INTERN:
                String majors = view.inputMajors();
                int semester = view.inputSemester();
                String university = view.inputUniversity();

                Employee intern = new Intern(employee.getId(), employee.getFullname(), employee.getBirthday(),
                        employee.getPhone(), employee.getEmail(), EmployeeEnum.getString(EmployeeEnum.INTERN),
                        majors,semester,university);
                intern.addCertificate();
                checkID(intern);
        }
    }


    public void deleteEmployee() {
        String ID = view.inputID();

        Optional<Employee> check = this.employeeSet.stream().filter(item -> item.equals(new Employee(ID))).findFirst();
        if (check.isPresent()) {
            this.employeeSet.remove(check.get());
            Employee.count--;
        }
        else
            view.showNoExistID();
    }


    public void modifyEmployee() {
        String ID = view.inputID();

        Optional<Employee> check = this.employeeSet.stream().filter(item -> item.equals(new Employee(ID))).findFirst();
        if (check.isPresent())
            check.get().modifyInfor();
        else
            view.showNoExistID();
    }


    public void search(String employeeType) {
        Set<Employee> searchList = this.employeeSet.stream()
                .filter(item -> item.getEmployeeType().contains(employeeType))
                .collect(Collectors.toSet());
        view.showSearchedEmployee(employeeType,searchList);
    }

    public void searchEmployee() {
        view.printEmployeeOption();
        int employeeOption = new Scanner(System.in).nextInt();

        EmployeeEnum opt = EmployeeEnum.getEnumEmployee(employeeOption);
        search(EmployeeEnum.getString(opt));
    }
}

