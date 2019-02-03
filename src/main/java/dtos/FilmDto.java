package dtos;

public class FilmDto {

    private Integer id;
    private String title;
    private Integer points;

    public FilmDto() {
    }

    public FilmDto(Integer id, String title, Integer points) {
        this.id = id;
        this.title = title;
        this.points = points;
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

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
