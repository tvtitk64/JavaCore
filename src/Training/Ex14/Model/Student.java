package src.Training.Ex14.Model;

public class Student {
    protected String fullName;
    protected String dateOfBirth;
    protected String sex;
    protected String phoneNumber;
    protected String universityName;
    protected String gradeLevel;

    public Student(String fullName, String dateOfBirth, String sex, String phoneNumber, String universityName, String gradeLevel) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.universityName = universityName;
        this.gradeLevel = gradeLevel;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public void showMyInfo() {
        System.out.println("Full name: " + fullName);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Sex: " + sex);
        System.out.println("Phone number: " + phoneNumber);
        System.out.println("University: " + universityName);
        System.out.println("Grade level: " + gradeLevel);
    }

    public void showNameAndPhone() {
        System.out.println(fullName + " | " + phoneNumber);
    }

}
