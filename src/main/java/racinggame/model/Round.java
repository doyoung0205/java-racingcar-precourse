package racinggame.model;

import racinggame.model.expcetion.InvalidRoundValueException;

public class Round {
    private static final String ROUND_MIN_VALUE_ERROR_MESSAGE = "[ERROR] 라운드는 최소 0보다 커야 합니다.";
    private final int round;

    private Round(int round) {
        this.round = round;
    }

    public static Round valueOf(int round) {
        validateMinValue(round);
        return new Round(round);
    }

    private static void validateMinValue(int rounds) {
        if (rounds <= 0) {
            throw new InvalidRoundValueException(ROUND_MIN_VALUE_ERROR_MESSAGE);
        }
    }

}
