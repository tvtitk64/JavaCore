package src.Training.Ex7.Controller;

import src.Training.Ex7.Model.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeacherManagement {
    private List<Teacher> teacherList = new ArrayList<>();

    public void addTeacher(Teacher teacher) {
        teacherList.add(teacher);
    }

    public void deleleTeacher(String idNumber) {
        Optional<Teacher> teacher = teacherList.stream().filter(teacher1 -> teacher1.getIdNumber().equals(idNumber)).findFirst();
        if (teacher.isPresent()) {
            teacherList.remove(teacher);
        }
    }

    public long paySalary(String idNumber) {
        Optional<Teacher> teacher = teacherList.stream().filter(teacher1 -> teacher1.getIdNumber().equals(idNumber)).findFirst();
        if (teacher.isPresent()) {
            return teacher.get().getSalary() + teacher.get().getBonus() - teacher.get().getPunish();
        } else {
            return 0;
        }
    }
}
