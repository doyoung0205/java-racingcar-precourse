package racinggame.view;

import racinggame.controller.dto.CarCaptureResponseDto;
import racinggame.controller.dto.RacingCarGameResponseDto;
import racinggame.controller.dto.RoundScoreResponseDto;

import java.util.List;
import java.util.StringJoiner;

public class RacingCarGameResultView {
    private static final String TITLE = "실행 결과";
    private static final String NAME_DELIMITER = ",";
    private static final String VICTORY_GROUPS_NAMES_MESSAGE_TEMPLATE = "최종 우승자는 %s 입니다.";
    private static final String RACING_CAR_CAPTURE_GROUPS_MESSAGE_TEMPLATE = "%s : %s \n";

    public void resolve(final RacingCarGameResponseDto gameResponseDto) {
        printTitle();
        printRoundScoreGroups(gameResponseDto.getRoundScores());
        printVictoryGroupsNames(gameResponseDto.getVictoryCarNames());
    }

    private void printTitle() {
        System.out.println(TITLE);
    }

    private void printRoundScoreGroups(final List<RoundScoreResponseDto> roundScores) {
        for (RoundScoreResponseDto roundScore : roundScores) {
            final List<CarCaptureResponseDto> carCaptures = roundScore.getCarCaptures();
            printRacingCarCaptureGroups(carCaptures);
        }
    }

    private void printRacingCarCaptureGroups(final List<CarCaptureResponseDto> carCaptures) {
        for (CarCaptureResponseDto carCapture : carCaptures) {
            System.out.printf(RACING_CAR_CAPTURE_GROUPS_MESSAGE_TEMPLATE, carCapture.getName(), getDistance(carCapture.getLap()));
        }
        System.out.println();
    }

    private String getDistance(final int lap) {
        final StringBuilder distanceBuilder = new StringBuilder();
        for (int i = 0; i < lap; i++) {
            distanceBuilder.append("-");
        }
        return distanceBuilder.toString();
    }

    private void printVictoryGroupsNames(final List<String> names) {
        final StringJoiner delimiterJoinedNames = new StringJoiner(NAME_DELIMITER);
        for (String name : names) {
            delimiterJoinedNames.add(name);
        }
        System.out.printf(VICTORY_GROUPS_NAMES_MESSAGE_TEMPLATE, delimiterJoinedNames);
    }
}
