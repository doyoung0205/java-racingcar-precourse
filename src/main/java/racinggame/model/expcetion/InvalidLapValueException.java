package racinggame.model.expcetion;

public class InvalidLapValueException extends RuntimeException {
    private final String message;

    public InvalidLapValueException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
