package racinggame.model;

import java.util.List;

public class RacingCarGameResult {
    private final RoundScoreGroups roundScoreGroups;

    public RacingCarGameResult(List<RoundScore> roundScores) {
        this.roundScoreGroups = RoundScoreGroups.valueOf(roundScores);
    }

    public static RacingCarGameResult valueOf(List<RoundScore> roundScores) {
        return new RacingCarGameResult(roundScores);
    }

    public RacingCarCaptureGroups getVictoryGroups() {
        return roundScoreGroups.getVictoryGroups();
    }

    public RoundScoreGroups getRoundScoreGroups() {
        return roundScoreGroups;
    }
}
