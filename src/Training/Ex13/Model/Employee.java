package src.Training.Ex13.Model;

import java.time.LocalDate;
import java.util.*;

public class Employee {
    Scanner scanner = new Scanner(System.in);
    public static long count = 0;
    protected String id;
    protected String fullname;
    protected String birthday;
    protected String phone;
    protected String email;
    private String employeeType;
    protected Set<Certificate> certificateSet;

    public Employee(String id) {
        this.id = id;
    }

    public Employee(String id, String fullname, String birthday, String phone, String email) {
        this.id = id;
        this.fullname = fullname;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
    }

    public Employee(String id, String fullname, String birthday, String phone, String email, String employeeType) {
        this.id = id;
        this.fullname = fullname;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.employeeType = employeeType;
        Employee.count++;
        this.certificateSet = new LinkedHashSet<>();
    }

    public void showInformation() {
        System.out.println("Information of employee:");
        System.out.println("ID: " + id);
        System.out.println("Full name: " + fullname);
        System.out.println("Birthday: " + birthday);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Type of employee: " + employeeType);
    };

    public void printModifyOption() {
        System.out.println("What attribute do you want to modify?");
        System.out.println("\t1: ID");
        System.out.println("\t2: Full name");
        System.out.println("\t3: Birthday");
        System.out.println("\t4: Phone");
        System.out.println("\t5: Email");
        System.out.println("\t6: Type of employee");
    }

    public void modifyInfor() {
        System.out.println("Information of employee:");
        showInformation();
    };

    public Certificate createCertificate() {
        System.out.println("Certificate ID: ");
        String certificateID = scanner.nextLine();

        System.out.println("Certificate name: ");
        String certificateName = scanner.nextLine();

        System.out.println("Certificate rank: ");
        String certificateRank = scanner.nextLine();

        System.out.println("Certificate date: ");
        String certificateDate = scanner.nextLine();

        return new Certificate(certificateID,certificateName,certificateRank,certificateDate);
    }

    public void checkCertificateID(Certificate certificate) {
        Optional<Certificate> check =  this.certificateSet.stream()
                .filter(item -> item.equals(certificate))
                .findFirst();

        if (check.isPresent()) {
            System.out.println("This certificate already exists!");
            System.out.println("Do you want to replace?");
            System.out.println("\t1: YES");
            System.out.println("\t2: NO");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    this.certificateSet.remove(check.get());
                    this.certificateSet.add(certificate);
                case 2:
                    return;
            }
        }
        this.certificateSet.add(certificate);
    }

    public void addCertificate() {
        System.out.println("Quantity of certificate: ");
        int quantity = new Scanner(System.in).nextInt();

        for (int i=0; i<quantity; i++) {
            System.out.println("Certificate " + (i+1) + ":");
            checkCertificateID(createCertificate());
        }
    }

    public String getId() {
        return id;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Certificate> getCertificateSet() {
        return certificateSet;
    }

    public void setCertificateSet(Set<Certificate> certificateSet) {
        this.certificateSet = certificateSet;
    }
}
