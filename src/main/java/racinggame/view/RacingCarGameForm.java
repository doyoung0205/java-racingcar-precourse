package racinggame.view;

import nextstep.utils.Console;
import racinggame.controller.dto.RacingCarGameRequestDto;
import racinggame.view.exception.InvalidRacingCarGameFormException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCarGameForm {
    // 안내 메시지
    private static final String RACING_CAR_NAMES_INPUT_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로구분)";
    private static final String RACING_ROUNDS_INPUT_GUIDE_MESSAGE = "시도할 횟수는 몇 회인가요?";
    // 숫자만 정규식
    private static final String ONLY_NUMBER_REGEX = "^[0-9]+$";
    // 경주할 자동차 이름 구분자
    private static final String CAR_NAME_DELIM = ",";
    // 시도할 횟수 에러 메시지
    private static final String RACING_ROUNDS_INVALID_ERROR_MESSAGE = "[ERROR] 시도할 횟수는 0 에서 " + Integer.MAX_VALUE + "까지의 숫자만 입력 가능합니다.";
    private static final String RACING_ROUNDS_EMPTY_ERROR_MESSAGE = "[ERROR] 시도할 횟수는 빈문자열이거나 Null 일 수 없습니다.";
    private static final String RACING_ROUNDS_NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 시도할 횟수는 숫자만 입력 가능합니다.";
    private static final String RACING_ROUNDS_MIN_VALUE_ERROR_MESSAGE = "[ERROR] 시도할 횟수는 0 보다 크거나 같습니다.";
    // 자동차 이름 에러 메시지
    private static final String RACING_CAR_NAME_DUPLICATED_ERROR_MESSAGE = "[ERROR] 중복된 이름이 존재합니다.";
    private static final String RACING_CAR_NAME_EMPTY_ERROR_MESSAGE = "[ERROR] 경주할 자동차 이름은 빈문자열이거나 Null 일 수 없습니다.";
    private static final String RACING_CAR_NAME_EXCEEDED_MAXIMUM_LENGTH_ERROR_MESSAGE = "[ERROR] 경주할 자동차의 이름이 5자 초과하였습니다.";

    public RacingCarGameRequestDto submit() {
        try {
            return new RacingCarGameRequestDto(getInputParticipatedNames(), getInputRounds());
        } catch (InvalidRacingCarGameFormException exception) {
            System.out.println(exception.getMessage());
        }
        return submit();
    }

    private String getInputParticipatedNames() {
        System.out.println(RACING_CAR_NAMES_INPUT_GUIDE_MESSAGE);
        final String names = Console.readLine();
        validateInputNames(names);
        return names;
    }

    private void validateInputNames(String names) {
        validateEmptyNames(names);
        validateDuplicatedNames(names);
        validateLengthNames(names);
    }

    private void validateLengthNames(String names) {
        final String[] nameList = names.split(CAR_NAME_DELIM);
        for (String name : nameList) {
            checkLengthName(name);
        }
    }

    private void checkLengthName(final String name) {
        if (name.length() > 5) {
            throw new InvalidRacingCarGameFormException(RACING_CAR_NAME_EXCEEDED_MAXIMUM_LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateDuplicatedNames(String names) {
        final List<String> nameList = Arrays.asList(names.split(CAR_NAME_DELIM));
        final Set<String> namesSet = new HashSet<>(nameList);
        if (nameList.size() != namesSet.size()) {
            throw new InvalidRacingCarGameFormException(RACING_CAR_NAME_DUPLICATED_ERROR_MESSAGE);
        }
    }

    private void validateEmptyNames(String names) {
        if (names == null || names.equals("")) {
            throw new InvalidRacingCarGameFormException(RACING_CAR_NAME_EMPTY_ERROR_MESSAGE);
        }
    }

    private int getInputRounds() {
        System.out.println(RACING_ROUNDS_INPUT_GUIDE_MESSAGE);
        final String boundsStr = Console.readLine();
        validateInputRounds(boundsStr);
        return Integer.parseInt(boundsStr);
    }

    private void validateInputRounds(final String boundsStr) {
        validateEmptyInputRounds(boundsStr);
        validateOnlyNumberInputRounds(boundsStr);
        validateParseIntInputRounds(boundsStr);
        validateMinValueInputRounds(boundsStr);
    }

    private void validateMinValueInputRounds(String boundsStr) {
        if (boundsStr == null || boundsStr.equals("")) {
            throw new InvalidRacingCarGameFormException(RACING_ROUNDS_EMPTY_ERROR_MESSAGE);
        }
    }

    private void validateParseIntInputRounds(String boundsStr) {
        if (!boundsStr.matches(ONLY_NUMBER_REGEX)) {
            throw new InvalidRacingCarGameFormException(RACING_ROUNDS_NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    private void validateOnlyNumberInputRounds(String boundsStr) {
        try {
            Integer.parseInt(boundsStr);
        } catch (NumberFormatException exception) {
            throw new InvalidRacingCarGameFormException(RACING_ROUNDS_INVALID_ERROR_MESSAGE);
        }
    }

    private void validateEmptyInputRounds(String boundsStr) {
        if (Integer.parseInt(boundsStr) <= 0) {
            throw new InvalidRacingCarGameFormException(RACING_ROUNDS_MIN_VALUE_ERROR_MESSAGE);
        }
    }
}
