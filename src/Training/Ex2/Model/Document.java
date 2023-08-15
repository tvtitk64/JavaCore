package src.Training.Ex2.Model;

public class Document {
    protected String code;
    protected String publisher;
    protected int number;

    public Document(String code, String publisher, int number) {
        this.code = code;
        this.publisher = publisher;
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
