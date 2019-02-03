package enums;

public enum CitizenStatus {

    ACTIVE(0), INACTIVE(1);

    private int statusId;

    CitizenStatus(int statusId) {
        this.statusId = statusId;
    }
}
