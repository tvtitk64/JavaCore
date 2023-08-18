package src.Training.Ex15.Model;

import java.util.List;

public class ServiceStudent extends Student{
    private String linkedTrainingLocation;

    public ServiceStudent(String id, String name, String dOB, int year, int score, String linkedTrainingLocation) {
        super(id, name, dOB, year, score);
        this.linkedTrainingLocation = linkedTrainingLocation;
    }

    public String getLinkedTrainingLocation() {
        return linkedTrainingLocation;
    }

    public void setLinkedTrainingLocation(String linkedTrainingLocation) {
        this.linkedTrainingLocation = linkedTrainingLocation;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Linked training location: " + linkedTrainingLocation);
    }
}
