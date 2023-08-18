package src.Training.Ex15.Model;

import java.util.*;

public class Student {
    protected String id;
    protected String name;
    protected String dOB;
    protected int year;
    protected int score;
    private Map<Integer, Double> result = new HashMap<>();

    public Student() {

    }

    public Student(String id) {
        this.id = id;
    }

    public Student(String id, String name, String dOB, int year, int score) {
        this.id = id;
        this.name = name;
        this.dOB = dOB;
        this.year = year;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getdOB() {
        return dOB;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    public Map<Integer, Double> getResult() {
        return result;
    }

    public void setResult(Map<Integer, Double> result) {
        this.result = result;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public void showInfo() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Birthday: " + dOB);
        System.out.println("Entry year: " + year);
        System.out.println("Score: " + score);
    }
}
