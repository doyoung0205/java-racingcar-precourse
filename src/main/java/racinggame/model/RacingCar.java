package racinggame.model;

import racinggame.model.expcetion.InvalidRacingCarNameException;

public class RacingCar {
    private static final String CAR_NAME_EXCEEDED_MAXIMUM_LENGTH_ERROR_MESSAGE = "[ERROR] 경주할 자동차의 이름이 5자 초과하였습니다.";
    private static final String CAR_NAME_IS_EMPTY_ERROR_MESSAGE = "[ERROR] 경주할 자동차의 이름을 입력해주세요.";

    private final String name;
    private final int forwardCount;

    private RacingCar(final String name) {
        this.name = name;
        this.forwardCount = 0;
    }

    public static RacingCar getInstanceByName(final String name) {
        validate(name);
        return new RacingCar(name);
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public String getName() {
        return this.name;
    }

    private static void validate(final String name) {
        validateNameNotEmpty(name);
        validateNameLength(name);
    }

    private static void validateNameLength(final String name) {
        if (invalidLength(name)) {
            throw new InvalidRacingCarNameException(CAR_NAME_EXCEEDED_MAXIMUM_LENGTH_ERROR_MESSAGE);
        }
    }

    private static void validateNameNotEmpty(final String name) {
        if (isEmpty(name)) {
            throw new InvalidRacingCarNameException(CAR_NAME_IS_EMPTY_ERROR_MESSAGE);
        }
    }

    private static boolean invalidLength(String name) {
        return name.length() > 5;
    }

    private static boolean isEmpty(String name) {
        return name == null || name.equals("");
    }
}
