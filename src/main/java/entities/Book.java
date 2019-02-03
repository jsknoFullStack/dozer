package entities;

public class Book {

    private Integer bookId;
    private String title;
    private String bookAuthor;

    public Book() {
    }

    public Book(Integer bookId, String title, String bookAuthor) {
        this.bookId = bookId;
        this.title = title;
        this.bookAuthor = bookAuthor;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
}
