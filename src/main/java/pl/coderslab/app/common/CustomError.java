package pl.coderslab.app.common;

public class CustomError {
    private String name;
    private String reason;

    public CustomError() {
    }

    public CustomError(String name, String reason) {
        this.name = name;
        this.reason = reason;
    }

    public String getName() {
        return name;
    }

    public String getReason() {
        return reason;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
