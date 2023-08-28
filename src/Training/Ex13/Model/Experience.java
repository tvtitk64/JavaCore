package src.Training.Ex13.Model;

import src.Training.Ex13.ModifyEnum.ModifyExperience;
import src.Training.Ex13.View.EmployeeEnum;
import src.Training.Ex13.View.Main;

import java.time.LocalDate;
import java.util.List;

public class Experience extends Employee{
    private int expInYear;
    private String proSkill;


    public Experience(String ID, String fullName, String birthDay, String phone, String email, String employeeType,
                      int expInYear, String proSkill) {
        super(ID, fullName, birthDay, phone, email, employeeType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public void showInformation() {
        super.showInformation();
        System.out.println("Number years of experience: " + expInYear);
        System.out.println("Pro skill: " + proSkill);
        this.getCertificateSet().forEach(Certificate::showCertificate);
        System.out.println("---------------------------------------------------");;
    }

    @Override
    public void modifyInfor() {
        super.modifyInfor();
        boolean condition = true;
        while (condition) {
            this.printModifyOption();
            System.out.println("\t7: Number years of experience");
            System.out.println("\t8: Pro skill");
            System.out.println("\t9: Exit");

            int modifyOption = scanner.nextInt();
            ModifyExperience opt = ModifyExperience.getEnumModifyExperience(modifyOption);

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
                    String newBirthDay = scanner.nextLine();
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

                case EXPERIENCE_YEAR:
                    System.out.println("New experience year: ");
                    int newExpInYear = scanner.nextInt();
                    this.setExpInYear(newExpInYear);
                    break;

                case PRO_SKILL:
                    System.out.println("New pro skill: ");
                    String newProSkill = scanner.nextLine();
                    this.setEmail(newProSkill);
                    break;

                case EXIT:
                    condition = false;
                    break;
            }
        }
    }
}
