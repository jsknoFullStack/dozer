package dtos;

import org.dozer.Mapping;

public class BookDto {

    @Mapping("bookId")
    private Integer id;
    private String title;
    @Mapping("bookAuthor")
    private String author;

    public BookDto() {
    }

    public BookDto(Integer id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
