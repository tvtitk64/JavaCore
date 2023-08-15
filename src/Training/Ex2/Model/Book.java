package src.Training.Ex2.Model;

public class Book extends Document{
    private String author;
    private int pageNumber;

    public Book(String code, String publisher, int number, String author, int pageNumber) {
        super(code, publisher, number);
        this.author = author;
        this.pageNumber = pageNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", pageNumber=" + pageNumber +
                ", code=" + code +
                ", publisher=" + publisher +
                ", number=" + number +
                '}';
    }
}
