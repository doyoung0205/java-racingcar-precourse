package racinggame.model;

import racinggame.model.expcetion.InvalidRoundsValueException;

public class Rounds {
    private static final String INVALID_RACING_ROUNDS_INPUT_ERROR_MESSAGE = "[ERROR] 라운드의 총 횟수는 0 에서 " + Integer.MAX_VALUE + "까지의 숫자만 입력 가능합니다.";
    private final int rounds;
    private int current;

    public Rounds(int rounds) {
        validateMinValue(rounds);
        this.rounds = rounds;
        this.current = 0;
    }

    public static Rounds valueOf(int rounds) {
        return new Rounds(rounds);
    }

    public static Rounds valueOf(String roundsStr) {
        try {
            final int rounds = Integer.parseInt(roundsStr);
            return new Rounds(rounds);
        } catch (NumberFormatException exception) {
            throw new InvalidRoundsValueException(INVALID_RACING_ROUNDS_INPUT_ERROR_MESSAGE);
        }
    }

    private static void validateMinValue(int rounds) {
        if (rounds <= 0) {
            throw new InvalidRoundsValueException(INVALID_RACING_ROUNDS_INPUT_ERROR_MESSAGE);
        }
    }

    public boolean hasNextRound() {
        return current < rounds;
    }

    public int nextRound() {
        this.current += 1;
        return this.current;
    }
}
