package src.Training.Ex13.Model;

import java.time.LocalDate;
import java.util.List;

public class Intern extends Employee {
    private String majors;
    private int semeters;
    private String universityName;

    public Intern() {

    }

    public Intern(String id, String fullname, LocalDate birthday, String phone, String email, List<Certificate> certificateList, String majors, int semeters, String universityName) {
        super(id, fullname, birthday, phone, email, certificateList);
        this.majors = majors;
        this.semeters = semeters;
        this.universityName = universityName;
    }

    @Override
    public void showInformation() {
        System.out.println(this);
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
    public String toString() {
        return "Intern{" +
                "majors='" + majors + '\'' +
                ", semeters=" + semeters +
                ", universityName='" + universityName + '\'' +
                ", id='" + id + '\'' +
                ", fullname='" + fullname + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", certificateList=" + certificateList +
                '}';
    }
}
