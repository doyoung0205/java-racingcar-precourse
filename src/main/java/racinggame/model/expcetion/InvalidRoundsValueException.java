package racinggame.model.expcetion;

public class InvalidRoundsValueException extends RuntimeException {
    private final String message;

    public InvalidRoundsValueException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
