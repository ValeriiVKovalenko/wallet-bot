package telegrambot.config.exception.api;

public class ApiDefaultException extends RuntimeException {

    public ApiDefaultException() {
        super();
    }

    public ApiDefaultException(String message) {
        super(message);
    }

    public ApiDefaultException(String message, Throwable cause) {
        super(message, cause);
    }
}