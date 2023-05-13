public class Ticket {
    private String ticketNumber;
    private String subject;
    private String description;
    private String status;
    private String priority;
    private User client;
    private User staff;

    private String resolution;

    public Ticket(String ticketNumber, String subject, String description, String status, User client) {
        this.ticketNumber = ticketNumber;
        this.subject = subject;
        this.description = description;
        this.status = status;
        this.client = client;
    }

    // Getters and setters for all fields

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public User getStaff() {
        return staff;
    }

    public void setStaff(User staff) {
        this.staff = staff;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
}