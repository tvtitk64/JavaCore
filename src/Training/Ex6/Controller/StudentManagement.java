package src.Training.Ex6.Controller;

import src.Training.Ex6.Model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentManagement {
    private List<Student> studentList = new ArrayList<>();

    public void addStudent(Student student) {
        studentList.add(student);
    }


    public List<Student> get20YearOldStudent() {
        return studentList.stream().filter(student -> student.getAge() == 20)
                .collect(Collectors.toList());
    }

    public int get23YearOldDNStudent() {
        List<Student> countStudent = studentList.stream()
                .filter(student -> student.getAge() == 23 && student.getHometown()
                        .equalsIgnoreCase("DN")).collect(Collectors.toList());
        return countStudent.size();
    }
}
