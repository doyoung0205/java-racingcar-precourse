package racinggame.model;

import racinggame.model.expcetion.InvalidRacingCarNameException;

public class Name {
    private static final String CAR_NAME_EXCEEDED_MAXIMUM_LENGTH_ERROR_MESSAGE = "[ERROR] 경주할 자동차의 이름이 5자 초과하였습니다.";
    private static final String CAR_NAME_IS_EMPTY_ERROR_MESSAGE = "[ERROR] 경주할 자동차의 이름을 입력해주세요.";

    private final String name;

    public Name(String name) {
        this.name = name;
    }

    public static Name valueOf(String name) {
        validate(name);
        return new Name(name);
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

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Name name1 = (Name) o;

        return name.equals(name1.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
