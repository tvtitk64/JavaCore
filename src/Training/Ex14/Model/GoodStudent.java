package src.Training.Ex14.Model;

public class GoodStudent extends Student {
    private float gpa;
    private String bestRewardName;

    public GoodStudent(String fullName, String dateOfBirth, String sex, String phoneNumber, String universityName, String gradeLevel, float gpa, String bestRewardName) {
        super(fullName, dateOfBirth, sex, phoneNumber, universityName, gradeLevel);
        this.gpa = gpa;
        this.bestRewardName = bestRewardName;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getBestRewardName() {
        return bestRewardName;
    }

    public void setBestRewardName(String bestRewardName) {
        this.bestRewardName = bestRewardName;
    }

    @Override
    public void showMyInfo() {
        super.showMyInfo();
        System.out.println("GPA: " + gpa);
        System.out.println("Best Reward Name: " + bestRewardName);
    }


}
