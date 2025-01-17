package by.digitalchief.ordermanagement.ordermanagement.exception.handler;

import lombok.Data;

@Data
public class ErrorDetails {
    private String message;
    private String details;
    public ErrorDetails(String message, String details) {
        this.message = message;
        this.details = details;
    }
}
