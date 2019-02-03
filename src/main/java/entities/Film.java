package entities;

public class Film {

    private String id;
    private String title;
    private Double points;

    public Film() {
    }

    public Film(String id, String title, Double points) {
        this.id = id;
        this.title = title;
        this.points = points;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }
}
