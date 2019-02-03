package entities;

import enums.CitizenStatus;

public class Citizen {

    private PersonWithBooksList person;
    private CitizenStatus citizenStatus;

    public Citizen() {
    }

    public Citizen(PersonWithBooksList person, CitizenStatus citizenStatus) {
        this.person = person;
        this.citizenStatus = citizenStatus;
    }

    public PersonWithBooksList getPerson() {
        return person;
    }

    public void setPerson(PersonWithBooksList person) {
        this.person = person;
    }

    public CitizenStatus getCitizenStatus() {
        return citizenStatus;
    }

    public void setCitizenStatus(CitizenStatus citizenStatus) {
        this.citizenStatus = citizenStatus;
    }
}
