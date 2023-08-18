package src.Training.Ex13.Model;

import java.time.LocalDate;
import java.util.List;

public abstract class Employee {
    public static long count = 0;
    protected String id;
    protected String fullname;
    protected LocalDate birthday;
    protected String phone;
    protected String email;
    protected List<Certificate> certificateList;

    public Employee() {

    }

    public Employee(String id, String fullname, LocalDate birthday, String phone, String email, List<Certificate> certificateList) {
        this.id = id;
        this.fullname = fullname;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.certificateList = certificateList;
    }

    public abstract void showInformation();

    public String getId() {
        return id;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
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

    public List<Certificate> getCertificateList() {
        return certificateList;
    }

    public void setCertificateList(List<Certificate> certificateList) {
        this.certificateList = certificateList;
    }
}
