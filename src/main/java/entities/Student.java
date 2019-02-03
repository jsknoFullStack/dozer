package entities;

public class Student {

    private String name;
    private Long dtob;

    public Student() {
    }

    public Student(String name, Long dtob) {
        this.name = name;
        this.dtob = dtob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDtob() {
        return dtob;
    }

    public void setDtob(Long dtob) {
        this.dtob = dtob;
    }
}
