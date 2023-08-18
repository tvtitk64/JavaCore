package src.Training.Ex15.View;

import src.Training.Ex14.Model.Student;

public enum StudentType {
    STANDARD, SERVICE;

    public static StudentType getStudentType(int choice) {
        for (StudentType student : StudentType.values()) {
            if (student.ordinal() == (choice - 1)) {
                return student;
            }
        }
        throw new RuntimeException();
    }
}
