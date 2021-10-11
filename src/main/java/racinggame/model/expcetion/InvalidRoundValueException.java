package racinggame.model.expcetion;

public class InvalidRoundValueException extends RuntimeException {
    private final String message;

    public InvalidRoundValueException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
