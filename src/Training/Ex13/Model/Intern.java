package src.Training.Ex13.Model;

import src.Training.Ex13.ModifyEnum.ModifyIntern;
import src.Training.Ex13.View.EmployeeEnum;
import src.Training.Ex13.View.Main;

import java.time.LocalDate;
import java.util.List;

public class Intern extends Employee {
    private String majors;
    private int semeters;
    private String universityName;

    public Intern(String ID, String fullName, String birthDay, String phone, String email, String employeeType,
                  String majors, int semesters, String universityName) {
        super(ID, fullName, birthDay, phone, email, employeeType);
        this.majors = majors;
        this.semeters = semesters;
        this.universityName = universityName;
    }

    @Override
    public void showInformation() {
        super.showInformation();
        System.out.println("Majors: " + majors);
        System.out.println("Semester: " + semeters);
        System.out.println("University: " + universityName);
        this.getCertificateSet().forEach(Certificate::showCertificate);
        System.out.println("---------------------------------------------------");
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public int getSemeters() {
        return semeters;
    }

    public void setSemeters(int semeters) {
        this.semeters = semeters;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public void modifyInfor() {
        super.modifyInfor();
        boolean condition = true;
        while (condition) {
            this.printModifyOption();
            System.out.println("\t7: Majors");
            System.out.println("\t8: Semester");
            System.out.println("\t9: University");
            System.out.println("\t10: Exit");

            int modifyOption = scanner.nextInt();
            ModifyIntern opt = ModifyIntern.getEnumModifyIntern(modifyOption);

            switch (opt) {
                case ID:
                    String newID;
                    while (true) {
                        System.out.println("New ID: ");
                        newID = scanner.nextLine();
                        String finalNewID = newID;
                        if (Main.employeeSet.stream().anyMatch(item -> item.equals(new Employee(finalNewID))))
                            System.out.println("This ID already exist!");
                        else
                            break;
                    }
                    this.setId(newID);
                    break;

                case FULLNAME:
                    System.out.println("New full name: ");
                    String newFullName = scanner.nextLine();
                    this.setFullname(newFullName);
                    break;

                case BIRTHDAY:
                    System.out.println("New birthday: ");
                    String newBirthDay =scanner.nextLine();
                    this.setBirthday(newBirthDay);
                    break;

                case PHONE:
                    System.out.println("New phone: ");
                    String newPhone = scanner.nextLine();
                    this.setPhone(newPhone);
                    break;

                case EMAIL:
                    System.out.println("New email: ");
                    String newEmail = scanner.nextLine();
                    this.setEmail(newEmail);
                    break;

                case TYPE_EMPLOYEE:
                    System.out.println("New type of employee: ");
                    System.out.println("\t1: Experience");
                    System.out.println("\t2: Fresher");
                    System.out.println("\t3: Intern");

                    int typeOpt = scanner.nextInt();
                    this.setEmployeeType(EmployeeEnum.getString(EmployeeEnum.getEnumEmployee(typeOpt)));
                    break;

                case MAJORS:
                    System.out.println("New majors: ");
                    String newMajors = scanner.nextLine();
                    this.setMajors(newMajors);
                    break;

                case SEMESTER:
                    System.out.println("New semester: ");
                    int newSemester = scanner.nextInt();
                    this.setSemeters(newSemester);
                    break;

                case UNIVERSITY:
                    System.out.println("New university: ");
                    String newUniversity = scanner.nextLine();
                    this.setUniversityName(newUniversity);
                    break;

                case EXIT:
                    condition = false;
                    break;
            }
        }
    }
}
