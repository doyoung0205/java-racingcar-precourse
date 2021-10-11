package racinggame.model;

import java.util.ArrayList;
import java.util.List;

public class RoundScoreGroups {
    private final List<RoundScore> roundScores = new ArrayList<>();

    private RoundScoreGroups(List<RoundScore> roundScores) {
        this.roundScores.addAll(roundScores);
    }

    public static RoundScoreGroups valueOf(List<RoundScore> roundScores) {
        return new RoundScoreGroups(roundScores);
    }

    /**
     * 가장 마지막 라운드의 결과를 바탕으로 우승 그룹을 결정
     */
    public RacingCarCaptureGroups getVictoryGroups() {
        final RoundScore roundScore = roundScores.get(roundScores.size() - 1);
        return roundScore.getMaxLapRacingCarGroups();
    }
}
