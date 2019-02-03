package dtos;

import org.dozer.Mapping;

public class AnnotatedContact {

    @Mapping("id")
    private Long contactId;
    private String name;
    @Mapping("telephoneNumber")
    private String number;

    public AnnotatedContact() {
    }

    public AnnotatedContact(Long contactId, String name, String number) {
        this.contactId = contactId;
        this.name = name;
        this.number = number;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
