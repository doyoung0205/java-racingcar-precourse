package racinggame.model.expcetion;

public class RacingCarGameException extends RuntimeException {
    private final String message;

    public RacingCarGameException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
