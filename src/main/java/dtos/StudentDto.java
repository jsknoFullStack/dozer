package dtos;

public class StudentDto {

    private String name;
    private String dtob;

    public StudentDto() {
    }

    public StudentDto(String name, String dtob) {
        this.name = name;
        this.dtob = dtob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDtob() {
        return dtob;
    }

    public void setDtob(String dtob) {
        this.dtob = dtob;
    }
}
