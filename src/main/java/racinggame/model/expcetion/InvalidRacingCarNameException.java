package racinggame.model.expcetion;

public class InvalidRacingCarNameException extends RuntimeException {
    private final String message;

    public InvalidRacingCarNameException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
