package src.Training.Ex14.Model;

public class NormalStudent extends Student {
    private double englishScore;
    private double entryTestScore;

    public NormalStudent(String fullName, String dateOfBirth, String sex, String phoneNumber, String universityName, String gradeLevel, double englishScore, double entryTestScore) {
        super(fullName, dateOfBirth, sex, phoneNumber, universityName, gradeLevel);
        this.englishScore = englishScore;
        this.entryTestScore = entryTestScore;
    }

    public double getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(double englishScore) {
        this.englishScore = englishScore;
    }

    public double getEntryTestScore() {
        return entryTestScore;
    }

    public void setEntryTestScore(double entryTestScore) {
        this.entryTestScore = entryTestScore;
    }

    @Override
    public void showMyInfo() {
        super.showMyInfo();
        System.out.println("English Score: " + englishScore);
        System.out.println("Entry Test Score: " + entryTestScore);
    }


}
