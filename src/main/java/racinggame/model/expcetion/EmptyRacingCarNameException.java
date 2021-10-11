package racinggame.model.expcetion;

public class EmptyRacingCarNameException extends RuntimeException {
    private final String message;

    public EmptyRacingCarNameException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
