package src.Training.Ex13.Model;

import java.time.LocalDate;
import java.util.List;

public class Experience extends Employee{
    private int expInYear;
    private String proSkill;

    public Experience() {

    }

    public Experience(String id, String fullname, LocalDate birthday, String phone, String email, List<Certificate> certificateList, int expInYear, String proSkill) {
        super(id, fullname, birthday, phone, email, certificateList);
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
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Experience{" +
                "expInYear=" + expInYear +
                ", proSkill='" + proSkill + '\'' +
                ", id='" + id + '\'' +
                ", fullname='" + fullname + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", certificateList=" + certificateList +
                '}';
    }
}
