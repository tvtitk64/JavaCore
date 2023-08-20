package src.Training.Ex15.View;

import src.Training.Ex14.Exception.InvalidFullNameException;
import src.Training.Ex15.Controller.StudentManagement;
import src.Training.Ex15.Exception.InvalidDOBException;
import src.Training.Ex15.Exception.InvalidFullnameException;
import src.Training.Ex15.Model.Falcuty;
import src.Training.Ex15.Model.ServiceStudent;
import src.Training.Ex15.Model.Student;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class    View {
    Scanner scanner = new Scanner(System.in);
    StudentManagement studentManagement = new StudentManagement();
    public void printOption() {
        System.out.println("Menu:");
        System.out.println("\t1: Add student");
        System.out.println("\t2: Check standard student");
        System.out.println("\t3: Count standard student");
        System.out.println("\t4: Search semester point");
        System.out.println("\t5: Show the highest entry point");
        System.out.println("\t6: Search service student");
        System.out.println("\t7: Search student have last semester point over 8.0");
        System.out.println("\t8: Search student have the highest semester point");
        System.out.println("\t9: Show by entry year");
        System.out.println("\t10: Count by entry year");
        System.out.println("\t11: Exit");
    }

    public void printStudentType() {
        System.out.println("What is type of student?");
        System.out.println("\t1: Standard Student");
        System.out.println("\t2: Service Student");
    }

    public void printReplaceOption() {
        System.out.println("This student ID already exist! Do you want to replace?");
        System.out.println("\t1: Yes");
        System.out.println("\t2: No");
    }

    public Student createStudent() throws InvalidFullnameException, InvalidDOBException {
        System.out.println("Student ID: ");
        String id = scanner.nextLine();

        System.out.println("Full name: ");
        String name = scanner.nextLine();

        System.out.println("Birthday: ");
        String dOB = scanner.nextLine();

        System.out.println("Entry year: ");
        int year = scanner.nextInt();

        System.out.println("Score: ");
        int score = scanner.nextInt();

        return new Student(id,name,dOB,year,score);
    }


    public String inputStudentID() {
        System.out.println("Student ID: ");
        return scanner.nextLine();
    }

    public String inputFalcuty() {
        System.out.println("Falcuty: ");
        return scanner.nextLine();
    }

    public String inputTrainningLink() {
        System.out.println("Trainning link: ");
        return scanner.nextLine();
    }

    public int inputSemester() {
        System.out.println("Semester: ");
        return scanner.nextInt();
    }

    public int inputEntryYear() {
        System.out.println("Entry year: ");
        return new Scanner(System.in).nextInt();
    }


    public void showStudentType(Optional<Student> check) {
        if (check.get() instanceof ServiceStudent)
            System.out.println("The student is a service student!");
        else
            System.out.println("The student is a standard student!");
    }


    public void showNoExistStudent() {
        System.out.println("This student ID doesn't exist!");
    }


    public void showNoExistFalcuty() {
        System.out.println("This falcuty doesn't exist!");
    }


    public void showSemesterGPA(Student student, int semester) {
        if (student.getResult().containsKey(semester))
            System.out.println("Semester " + semester + ": " + student.getResult().get(semester));
        else
            System.out.println("This semester doesn't exist!");
    }


    public void searchHighestEntryPoint(List<Falcuty> falcutyList) {
        System.out.println("The highest entry point:");
        for (Falcuty falcuty : falcutyList) {
            System.out.println(falcuty.getFalcutyName());
            System.out.println("\t" + falcuty.sortStudent().get(0).getName() + ": " + falcuty.sortStudent().get(0).getScore());
        }
    }

    public void showServiceStudent(Falcuty falcuty, List<Student> searchedList) {
        System.out.println("--------------" + falcuty.getFalcutyName() + "--------------");
        for (Student student : searchedList) {
            System.out.println(student.getName());
        }
        System.out.println("-----------------------------------------------------------");
    }


    public void showPointOver8(Falcuty falcuty, List<Student> overList) {
        System.out.println("--------------" + falcuty.getFalcutyName() + "--------------");
        if (overList.isEmpty())
            System.out.println("No student!");
        else
            for (Student student : overList) {
                System.out.println(student.getName());
            }
        System.out.println("-----------------------------------------------------------");
    }

    public void showHighestSemesterPoint(Falcuty falcuty, Student student) {
        System.out.println("--------------" + falcuty.getFalcutyName() + "--------------");
        System.out.println(student.getName());
        System.out.println("-----------------------------------------------------------");
    }

    public void showByEntryYear(Falcuty falcuty, List<Student> studentList) {
        System.out.println("--------------" + falcuty.getFalcutyName() + "--------------");
        for (Student student : studentList) {
            System.out.println(student.getName() + ": " + student.getYear());
        }
        System.out.println("-----------------------------------------------------------");
    }

    public void countByEntryYear(Falcuty falcuty, int entryYear, int count) {
        System.out.println("--------------" + falcuty.getFalcutyName() + "--------------");
        System.out.println(entryYear + ": " + count + " students");
        System.out.println("-----------------------------------------------------------");
    }
}
