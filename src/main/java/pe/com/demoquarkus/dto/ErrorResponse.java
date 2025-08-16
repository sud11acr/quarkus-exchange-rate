package pe.com.demoquarkus.dto;


import java.time.OffsetDateTime;

public class ErrorResponse {
    public OffsetDateTime timestamp;
    public int status;
    public String error;
    public String message;
    public String path;

    public ErrorResponse(int status, String error, String message, String path) {
        this.timestamp = OffsetDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}