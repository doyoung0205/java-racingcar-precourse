package racinggame.view.exception;

public class InvalidRacingCarGameFormException extends RuntimeException {
	private final String message;

	public InvalidRacingCarGameFormException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
