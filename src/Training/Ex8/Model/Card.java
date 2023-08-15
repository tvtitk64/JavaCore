package src.Training.Ex8.Model;

public class Card {
    private String code;
    private int dayBorrow;
    private int dayReturn;
    private int bookCode;
    private Students students;

    public Card(String code, int dayBorrow, int dayReturn, int bookCode, Students students) {
        this.code = code;
        this.dayBorrow = dayBorrow;
        this.dayReturn = dayReturn;
        this.bookCode = bookCode;
        this.students = students;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getDayBorrow() {
        return dayBorrow;
    }

    public void setDayBorrow(int dayBorrow) {
        this.dayBorrow = dayBorrow;
    }

    public int getDayReturn() {
        return dayReturn;
    }

    public void setDayReturn(int dayReturn) {
        this.dayReturn = dayReturn;
    }

    public int getBookCode() {
        return bookCode;
    }

    public void setBookCode(int bookCode) {
        this.bookCode = bookCode;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }
}
