package racinggame.model;

import racinggame.model.expcetion.InvalidRoundsValueException;

public class Rounds {
    private static final String ROUNDS_MIN_VALUE_ERROR_MESSAGE = "[ERROR] 라운드의 총 횟수는 최소 0 보다 커야 합니다.";
    private final int rounds;
    private int current;

    public Rounds(int rounds) {
        this.rounds = rounds;
        this.current = 0;
    }

    public static Rounds valueOf(int rounds) {
        validateMinValue(rounds);
        return new Rounds(rounds);
    }

    private static void validateMinValue(int rounds) {
        if (rounds <= 0) {
            throw new InvalidRoundsValueException(ROUNDS_MIN_VALUE_ERROR_MESSAGE);
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
