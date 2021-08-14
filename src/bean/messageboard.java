package bean;

public class messageboard {
    private String username;
    private String time;
    private String message;

    public messageboard() {
    }

    public messageboard(String username, String time, String message) {
        this.username = username;
        this.time = time;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "messageboard{" +
                "username='" + username + '\'' +
                ", time='" + time + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
