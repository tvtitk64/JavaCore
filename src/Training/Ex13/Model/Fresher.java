package src.Training.Ex13.Model;

import src.Training.Ex13.ModifyEnum.ModifyFresher;
import src.Training.Ex13.View.EmployeeEnum;
import src.Training.Ex13.View.Main;

import java.time.LocalDate;
import java.util.List;

public class Fresher extends Employee {
    private String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(String ID, String fullName, String birthDay, String phone, String email, String employeeType,
                   String graduationDate, String graduationRank, String education) {
        super(ID, fullName, birthDay, phone, email, employeeType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    @Override
    public void showInformation() {
        super.showInformation();
        System.out.println("Graduation date: " + graduationDate);
        System.out.println("Graduation rank: " + graduationRank);
        System.out.println("Education: " + education);
        this.getCertificateSet().forEach(Certificate::showCertificate);
        System.out.println("---------------------------------------------------");
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public void modifyInfor() {
        super.modifyInfor();
        boolean condition = true;
        while (condition) {
            this.printModifyOption();
            System.out.println("\t7: Graduation date");
            System.out.println("\t8: Graduation rank");
            System.out.println("\t9: Education");
            System.out.println("\t10: Exit");

            int modifyOption = scanner.nextInt();
            ModifyFresher opt = ModifyFresher.getEnumModifyFresher(modifyOption);

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

                case GRAD_DATE:
                    System.out.println("New graduation date: ");
                    String newGradDate = scanner.nextLine();
                    this.setGraduationDate(newGradDate);
                    break;

                case GRAD_RANK:
                    System.out.println("New graduation rank: ");
                    String newGradRank = scanner.nextLine();
                    this.setGraduationDate(newGradRank);
                    break;

                case EDUCATION:
                    System.out.println("New education: ");
                    String newEducation = scanner.nextLine();
                    this.setEducation(newEducation);
                    break;

                case EXIT:
                    condition = false;
                    break;
            }
        }
    }
}
