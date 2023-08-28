package src.Training.Ex13.View;

import src.Training.Ex13.Controller.Validator;
import src.Training.Ex13.Exception.BirthdayException;
import src.Training.Ex13.Exception.EmailException;
import src.Training.Ex13.Exception.PhoneException;
import src.Training.Ex13.Model.Employee;

import java.util.Scanner;
import java.util.Set;

public class View {

    Scanner scanner = new Scanner(System.in);
    public void printOption(){
        System.out.println("Option:");
        System.out.println("\t1: Add employee");
        System.out.println("\t2: Delete employee");
        System.out.println("\t3: Modify employees information");
        System.out.println("\t4: Search employee");
        System.out.println("\t5: Exit");
    }

    public void printEmployeeOption() {
        System.out.println("Type of employee:");
        System.out.println("\t1: Experience");
        System.out.println("\t2: Fresher");
        System.out.println("\t3: Intern");
    }


    public void printReplaceOption() {
        System.out.println("This ID already exists!");
        System.out.println("Do you want to replace?");
        System.out.println("\t1: YES");
        System.out.println("\t2: NO");
    }


    public Employee createEmployee() throws BirthdayException, PhoneException, EmailException {
        String ID = this.inputID();

        System.out.println("Full name: ");
        String fullName = scanner.nextLine();

        System.out.println("Birthday: ");
        String birthDay = scanner.nextLine();
        Validator.birthdayCheck(birthDay);

        System.out.println("Phone: ");
        int phone = scanner.nextInt();
        Validator.phoneCheck(phone);

        System.out.println("Email: ");
        String email = scanner.nextLine();
        Validator.emailCheck(email);

        return new Employee(ID,fullName,birthDay,phone,email);
    }


    public String inputID() {
        System.out.println("ID: ");
        return scanner.nextLine();
    }

    public int inputExpInYear() {
        System.out.println("Number years of experience: ");
        return scanner.nextInt();
    }

    public String inputProSkill() {
        System.out.println("Pro skill: ");
        return scanner.nextLine();
    }

    public String inputGraduationDate() {
        System.out.println("Graduation date: ");
        return scanner.nextLine();
    }

    public String inputGraduationRank() {
        System.out.println("Graduation rank: ");
        return scanner.nextLine();
    }

    public String inputEducation() {
        System.out.println("Education: ");
        return scanner.nextLine();
    }

    public String inputMajors() {
        System.out.println("Majors: ");
        return scanner.nextLine();
    }

    public int inputSemester() {
        System.out.println("Semester: ");
        return scanner.nextInt();
    }

    public String inputUniversity() {
        System.out.println("University: ");
        return scanner.nextLine();
    }

    public void showNoExistID() {
        System.out.println("This ID doesn't exist!");
    }


    public void showSearchedEmployee(String employeeType, Set<Employee> searchList) {
        if (searchList.isEmpty())
            System.out.println("Don't exist " + employeeType + " employee!");
        else {
            System.out.println(employeeType + " employee:");
            searchList.forEach(Employee::showInformation);
        }
    }
}
