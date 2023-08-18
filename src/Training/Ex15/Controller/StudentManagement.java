package src.Training.Ex15.Controller;

import src.Training.Ex14.Exception.InvalidFullNameException;
import src.Training.Ex15.Exception.InvalidDOBException;
import src.Training.Ex15.Model.Falcuty;
import src.Training.Ex15.Model.ServiceStudent;
import src.Training.Ex15.Model.Student;
import src.Training.Ex15.View.Option;
import src.Training.Ex15.View.View;

import java.io.Flushable;
import java.util.*;

public class StudentManagement {
    List<Falcuty> falcutyList = new ArrayList<>();
    View view = new View();

    public void userMenu() throws InvalidFullNameException, InvalidDOBException {
        int menuOp;
        boolean condition = true;
        while (condition){
            view.printMenu();
            menuOp = new Scanner(System.in).nextInt();
            Option menu = Option.EXIT.getOption(menuOp);
            switch (menu){
                case ADD:
                    break;

                case CHECK_STANDARD:
                    checkStandardStudent();
                    break;

                case COUNT_STANDARD:
                    countStandardStudent();
                    break;

                case SEARCH_POINT:
                    averageSemeterPointOfStudent();
                    break;

                case SHOW_HIGHEST_POINT:

                    break;

                case SEARCH_SERVICE_STUDENT:
                    getAllServiceStudent();
                    break;

                case SEARCH_POINT_OVER8:
                    getAllStudentWithAvarageScoreMoreThan8();
                    break;

                case SEARCH_HIGHEST_SEMESTER_POINT:

                    break;

                case SHOW_BY_ENTRY_YEAR:
                    getHighestScoreStudentOfFalcuty();
                    break;

                case COUNT_BY_ENTRY_YEAR:
                    statisticStudentByEntryYear();
                    break;

                case EXIT:
                    condition = false;
                    break;

            }
        }
    }


    public void checkStandardStudent(String id) {
        for (Falcuty falcuty : falcutyList) {
            Optional<Student> check = falcuty.getStudentSet().stream()
                    .filter(item -> item.equals(new Student(id)))
                    .findFirst();
            if (check.isPresent()) {
                if (check.get() instanceof ServiceStudent)
                    System.out.println("service student!");
                else
                    System.out.println("standard student!");
            }
        }
        System.out.println("Id doesn't exist");
    }

    public int countStandardStudent(String falcuty) {
        Optional<Falcuty> check = falcutyList.stream()
                .filter(item -> item.getFalcutyName().contains(falcuty)
                ).findFirst();

        if (check.isPresent()) {
            int count = 0;
            for (Student student : check.get().getStudentSet()) {
                if (student instanceof ServiceStudent) {
                    continue;
                } else {
                    count++;
                }
            }
            return count;
        } else {
            System.out.println("Falcuty doesn't exist");
            return 0;
        }
    }


    public void averageSemeterPointOfStudent(String id, int semeter) {
        for (Falcuty falcuty : falcutyList) {
            Student checkStudent = falcuty.getStudentSet().stream()
                    .filter(student -> student.equals(new Student(id))).findFirst().get();
            if (checkStudent.getResult().containsKey(semeter)) {
                System.out.println("Semeter: " + semeter + ", " + checkStudent.getResult().get(semeter));
            }
        }
    }

    public void searchHighestPoint() {
        for (Falcuty falcuty : falcutyList) {
            System.out.println(falcuty.getFalcutyName());
            System.out.println("\t" + falcuty.sortStudent().get(0).getName() + ": " + falcuty.sortStudent().get(0).getScore());
        }
    }

    public void checkFalcuty(String falcuty, Student student) {
        Optional<Falcuty> checkFalcuty = falcutyList.stream().filter(falcuty1 -> falcuty1.getFalcutyName().contains(falcuty))
                .findFirst();
        if (checkFalcuty.isPresent()) {
            checkFalcuty.get().addStudent(student);
        } else {
            Falcuty newFalcuty = new Falcuty(falcuty);
            newFalcuty.addStudent(student);
            falcutyList.add(newFalcuty);
        }
    }

    public void getAllServiceStudent(String linkedTrainingLocation) {
        for (Falcuty falcuty : falcutyList) {
            List<Student> studentList = new ArrayList<>();
            for (Student student : falcuty.getStudentSet()) {
                if (student instanceof ServiceStudent && ((ServiceStudent) student).getLinkedTrainingLocation().equals(linkedTrainingLocation)) {
                    studentList.add(student);
                }
            }
            System.out.println("Falcuty's name: " + falcuty.getFalcutyName());
            System.out.println("Students found: ");
            for (int i = 0; i < studentList.size(); i++) {
                System.out.println("Name: " + studentList.get(i).getName());
            }
        }
    }

    public void getAllStudentWithAvarageScoreMoreThan8() {
        int nearestSemeter = 0;
        Student student = new Student();
        for (Map.Entry<Integer, Double> point : student.getResult().entrySet()) {
            if (point.getKey() > nearestSemeter) {
                nearestSemeter = point.getKey();
            }
        }
        for (Falcuty falcuty : falcutyList) {
            List<Student> studentList = new ArrayList<>();
            for (Student student1 : falcuty.getStudentSet()) {
                if (student1.getScore() > 8 && student1.getResult().containsKey(nearestSemeter)) {
                    studentList.add(student1);
                }
            }
            System.out.println("Falcuty's name: " + falcuty.getFalcutyName());
            System.out.println("Students found: ");
            for (int i = 0; i < studentList.size(); i++) {
                System.out.println("Name: " + studentList.get(i).getName());
            }
        }
    }

    public Double getHisgestScoreOfEachStudent(Student student) {
        Double highestScore = 0.0;
        for (Map.Entry<Integer, Double> point : student.getResult().entrySet()) {
            if (point.getValue() > highestScore) {
                highestScore = point.getValue();
            }
        }
        return highestScore;
    }

    public void getHighestScoreStudentOfFalcuty() {
        for (Falcuty falcuty : falcutyList) {
            List<Double> studentListSemeter = new ArrayList<>();
            for (Student student : falcuty.getStudentSet()) {
                studentListSemeter.add(getHisgestScoreOfEachStudent(student));
            }
            double maxValue = 0.0;
            for (int i = 0; i < studentListSemeter.size(); i++) {
                if (maxValue < studentListSemeter.get(i)) {
                    maxValue = studentListSemeter.get(i);
                }
            }
            System.out.println("Falcuty's name: " + falcuty.getFalcutyName());
            System.out.println("Highest Score: " + maxValue);
        }
    }

    public void statisticStudentByEntryYear() {
        for (Falcuty falcuty : falcutyList) {
            Map<Integer, Integer> statistic = new HashMap<>();
            for (Student student : falcuty.getStudentSet()) {
                int count = statistic.get(student.getYear());
                statistic.put(student.getYear(), count++);
            }
            for (Map.Entry<Integer, Integer> entry : statistic.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
