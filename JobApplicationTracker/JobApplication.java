public class JobApplication {
    private String company;
    private String position;
    private Status status;
    private String notes;

    public JobApplication(String company, String position, Status status, String notes) { //Constructor
        this.company = company;
        this.position = position;
        this.status = status;
        this.notes = notes;
    }

    //Setters
    public void setCompany(String company) {
        this.company = company;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    } 
    //Getters
    public String getNotes() {
        return notes;
    }
    public String getCompany() {
        return company;
    }
    public String getPosition() {
        return position;
    }
    public Status getStatus() {
        return status;
    }
}