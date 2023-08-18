package src.Training.Ex13.Model;

import java.time.LocalDate;
import java.util.List;

public class Fresher extends Employee {
    private LocalDate graduationDate;
    private String graduationRank;
    private String university;

    public Fresher() {

    }

    public Fresher(String id, String fullname, LocalDate birthday, String phone, String email, List<Certificate> certificateList, LocalDate graduationDate, String graduationRank, String university) {
        super(id, fullname, birthday, phone, email, certificateList);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.university = university;
    }

    @Override
    public void showInformation() {
        System.out.println(this);
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Fresher{" +
                "graduationDate=" + graduationDate +
                ", graduationRank='" + graduationRank + '\'' +
                ", university='" + university + '\'' +
                ", id='" + id + '\'' +
                ", fullname='" + fullname + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", certificateList=" + certificateList +
                '}';
    }
}
