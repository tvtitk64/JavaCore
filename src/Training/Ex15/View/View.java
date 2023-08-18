package src.Training.Ex15.View;

import src.Training.Ex14.Exception.InvalidDOBException;
import src.Training.Ex14.Exception.InvalidFullNameException;
import src.Training.Ex15.Controller.StudentManagement;
import src.Training.Ex15.Model.ServiceStudent;
import src.Training.Ex15.Model.Student;

import java.util.Scanner;

public class    View {
    Scanner scanner = new Scanner(System.in);
    StudentManagement studentManagement = new StudentManagement();
    public void printOption() {
        System.out.println("Menu:");
        System.out.println("\t1: Add student");
        System.out.println("\t2: Check standard students");
        System.out.println("\t3: Count standard students");
        System.out.println("\t4: Lay diem tb cua sinh vien dua vao hoc ky cho truoc");
        System.out.println("\t5: Count standard students");
        System.out.println("\t6: Students's Highest score of falcuty");

        System.out.println("\t5: Exit");
    }

    public Student createStudent() throws InvalidFullNameException, InvalidDOBException {
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

    public void inputStudent() throws InvalidDOBException, InvalidFullNameException {
        System.out.println("What is type of student?");
        System.out.println("\t1: Standard Student");
        System.out.println("\t2: Service Student");

        int studentOption = scanner.nextInt();
        StudentType studentType = StudentType.getStudentType(studentOption);

        System.out.println("Falcuty: ");
        String falcuty = scanner.nextLine();

        Student student = createStudent();

        switch (studentType) {
            case STANDARD:
                studentManagement.checkFalcuty(falcuty,student);
                break;

            case SERVICE:
                System.out.println("Trainning link: ");
                String trainningLink = scanner.nextLine();

                Student serviceStudent = new ServiceStudent(student.getId(),student.getName(),student.getdOB(),
                        student.getYear(),student.getScore(),trainningLink);
                studentManagement.checkFalcuty(falcuty,serviceStudent);
                break;
        }
    }

    public String inputStudentID() {
        System.out.println("Student ID: ");
        return scanner.nextLine();
    }

    public String inputSchool() {
        System.out.println("School: ");
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
}
