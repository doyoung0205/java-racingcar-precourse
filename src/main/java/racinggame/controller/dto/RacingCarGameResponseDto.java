package racinggame.controller.dto;

import racinggame.model.RacingCarCapture;
import racinggame.model.RacingCarGameResult;
import racinggame.model.RoundScore;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameResponseDto {
    private final List<String> victoryCarNames;
    private final List<RoundScoreResponseDto> roundScores;


    private RacingCarGameResponseDto(List<String> victoryCarNames, List<RoundScoreResponseDto> roundScores) {
        this.victoryCarNames = victoryCarNames;
        this.roundScores = roundScores;
    }

    public static RacingCarGameResponseDto toDto(RacingCarGameResult carGameResult) {
        final List<RoundScoreResponseDto> roundScores = new ArrayList<>();
        final List<RoundScore> roundScoreGroups = carGameResult.getRoundScoreGroups();
        for (RoundScore roundScoreGroup : roundScoreGroups) {
            final List<RacingCarCapture> racingCarCaptureGroups = roundScoreGroup.getRacingCarCaptureGroups();
            roundScores.add(RoundScoreResponseDto.toDto(racingCarCaptureGroups));
        }
        return new RacingCarGameResponseDto(carGameResult.getVictoryGroupsNames(), roundScores);
    }


    public List<String> getVictoryCarNames() {
        return victoryCarNames;
    }

    public List<RoundScoreResponseDto> getRoundScores() {
        return roundScores;
    }
}
