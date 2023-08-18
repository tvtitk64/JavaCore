package src.Training.Ex15.Model;

import java.util.*;

public class Falcuty {
    private String falcutyName;
    private Set<Student> studentSet;

    public Falcuty(String falcutyName) {
        this.falcutyName = falcutyName;
        this.studentSet = new LinkedHashSet<>();
    }

    public String getFalcutyName() {
        return falcutyName;
    }

    public void setFalcutyName(String falcutyName) {
        this.falcutyName = falcutyName;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public void addStudent(Student student) {
        studentSet.add(student);
    }

    public List<Student> sortStudent() {
        List<Student> studentList = new ArrayList<>(studentSet);
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getScore() > o2.getScore()) {
                    return -1;
                } else if(o1.getScore() < o2.getScore()) {
                    return 1;
                } else {
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });
        return studentList;
    }

    public List<Student> sortStudentByEntryYear() {
        List<Student> studentList = new ArrayList<>(studentSet);
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getYear() > o2.getYear()) {
                    return 1;
                } else if(o1.getYear() < o2.getYear()) {
                    return -1;
                } else {
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });
        return studentList;
    }
}
