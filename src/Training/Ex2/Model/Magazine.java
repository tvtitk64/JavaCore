package src.Training.Ex2.Model;

public class Magazine extends Document{
    private int issueNumber;
    private int monthRelease;

    public Magazine(String code, String publisher, int number, int issueNumber, int monthRelease) {
        super(code, publisher, number);
        this.issueNumber = issueNumber;
        this.monthRelease = monthRelease;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public int getMonthRelease() {
        return monthRelease;
    }

    public void setMonthRelease(int monthRelease) {
        this.monthRelease = monthRelease;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "issueNumber='" + issueNumber + '\'' +
                ", monthRelease=" + monthRelease +
                ", code=" + code +
                ", publisher=" + publisher +
                ", number=" + number +
                '}';
    }
}
