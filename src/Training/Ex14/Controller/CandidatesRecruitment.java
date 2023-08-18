package src.Training.Ex14.Controller;

import src.Training.Ex14.Exception.InvalidDOBException;
import src.Training.Ex14.Exception.InvalidFullNameException;
import src.Training.Ex14.Exception.InvalidPhoneNumberException;
import src.Training.Ex14.Model.GoodStudent;
import src.Training.Ex14.Model.NormalStudent;
import src.Training.Ex14.Model.Student;
import src.Training.Ex14.View.Level;
import src.Training.Ex14.View.Option;
import src.Training.Ex14.View.Show;

import java.util.*;
import java.util.stream.Collectors;

public class CandidatesRecruitment {
    List<Student> studentList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void printOption() {
        System.out.println("Choose your option below: ");
        System.out.println("1. Add student: ");
        System.out.println("2. Show candidates: ");
        System.out.println("3.Show full list: ");
        System.out.println("4. Exit: ");
    }

    public void userChooseOption() throws InvalidPhoneNumberException, InvalidDOBException, InvalidFullNameException {
        int choice;
        while (true) {
            printOption();
            choice = scanner.nextInt();
            Option option = Option.getListOption(choice);
            switch (option) {
                case ADD:
                    addStudent();
                    break;
                case CHOOSE:
                    recruitCandidates().forEach(Student::showMyInfo);
                    break;
                case SHOW:
                    showStudentInfoByPhoneAndName();
                    break;
                case EXIT:
                    break;
                default:
                    break;
            }
        }
    }

    public void addStudent() throws InvalidPhoneNumberException, InvalidDOBException, InvalidFullNameException {
        System.out.println("Enter student's information");
        System.out.println("Name: ");
        String fullName = scanner.nextLine();
        CheckCondition.checkFullName(fullName);
        System.out.println("Date of birth: ");
        String dateOfBirth = scanner.nextLine();
        CheckCondition.checkDOB(dateOfBirth);
        System.out.println("Sex: ");
        String sex = scanner.nextLine();
        System.out.println("Phone number: ");
        String phoneNumber = scanner.nextLine();
        CheckCondition.checkPhoneNumber(phoneNumber);
        System.out.println("Name of university: ");
        String universityName = scanner.nextLine();
        System.out.println("Level of student: 1.Good     2.Normal");
        int option = scanner.nextInt();
        Level level = Level.getLevel(option);
        switch (level) {
            case GOOD:
                System.out.println("Enter gpa: ");
                float gpa = scanner.nextFloat();
                System.out.println("Best reward: ");
                String bestReward = scanner.nextLine();
                Student goodStudent = new GoodStudent(fullName, dateOfBirth,phoneNumber, sex, universityName, Level.getString(Level.GOOD), gpa, bestReward);
                studentList.add(goodStudent);
                break;
            case NORMAL:
                System.out.println("Enter english score: ");
                int englishScore = scanner.nextInt();
                System.out.println("Entry Test Score: ");
                int entryTestScore = scanner.nextInt();
                Student normalStudent = new NormalStudent(fullName, dateOfBirth,phoneNumber, sex, universityName, Level.getString(Level.NORMAL), englishScore, entryTestScore);
                studentList.add(normalStudent);
                break;
        }
    }

    public List<Student> chooseGoodStudent() {
        return studentList.stream().filter(student -> student.getGradeLevel().contains("Good"))
                .collect(Collectors.toList());
    }

    public List<Student> chooseNormalStudent() {
        return studentList.stream().filter(student -> student.getGradeLevel().contains("Normal"))
                .collect(Collectors.toList());
    }

    public List<Student> sortGoodStudent(List<Student> goodStudentList) {
        Collections.sort(goodStudentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (((GoodStudent) o1).getGpa() > ((GoodStudent) o2).getGpa())
                    return -1;
                else if (((GoodStudent) o1).getGpa() < ((GoodStudent) o2).getGpa())
                    return 1;
                else
                    return o1.getFullName().compareTo(o2.getFullName());
            }
        });
        return goodStudentList;
    }

    public List<Student> sortNormalStudent(List<Student> normalStudentList) {
        Collections.sort(normalStudentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (((NormalStudent) o1).getEntryTestScore() > ((NormalStudent) o2).getEntryTestScore())
                    return -1;
                else if (((NormalStudent) o1).getEntryTestScore() < ((NormalStudent) o2).getEntryTestScore())
                    return 1;
                else {
                    if (((NormalStudent) o1).getEnglishScore() > ((NormalStudent) o2).getEnglishScore())
                        return -1;
                    else if (((NormalStudent) o1).getEnglishScore() < ((NormalStudent) o2).getEnglishScore())
                        return 1;
                    else
                        return o1.getFullName().compareTo(o2.getFullName());
                }
            }
        });
        return normalStudentList;
    }

    public List<Student> recruitCandidates() {
        System.out.println("Choose the number of candidates(11-15): ");
        int number = scanner.nextInt();
        List<Student> chosenCandidates;
        List<Student> goodStudentList = sortGoodStudent(chooseGoodStudent());
        List<Student> normalStudentList = sortNormalStudent(chooseNormalStudent());

        if (goodStudentList.size() <= number) {
            chosenCandidates = goodStudentList;
            for (int i = 0; i < (number - goodStudentList.size()); i++) {
                chosenCandidates.add(normalStudentList.get(i));
            }
            return chosenCandidates;
        } else {
            return goodStudentList.stream()
                    .filter(index -> goodStudentList.indexOf(index) < number)
                    .collect(Collectors.toList());
        }
    }

    public void sortFullname() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return -o1.getFullName().compareTo(o2.getFullName());
            }
        });
        studentList.forEach(Student::showNameAndPhone);
    }

    public void sortPhoneNumber() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return -o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
            }
        });
        studentList.forEach(Student::showNameAndPhone);
    }

    public void showStudentInfoByPhoneAndName() {
        System.out.println("Choose how you want to show info: ");
        System.out.println("1. By phone: ");
        System.out.println("2. By fullname: ");
        int choice = scanner.nextInt();
        Show show = Show.getChoice(choice);
        switch (show) {
            case NAME:
                sortFullname();
                break;
            case PHONE:
                sortPhoneNumber();
                break;
        }
    }
}
