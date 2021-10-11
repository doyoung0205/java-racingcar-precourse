package racinggame.model.expcetion;

public class DuplicatedRacingCarNameException extends RuntimeException {
    private final String message;

    public DuplicatedRacingCarNameException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
