package racinggame.model.expcetion;

public class ParticipatedGroupNotEmptyException extends RuntimeException {
    private final String message;

    public ParticipatedGroupNotEmptyException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
