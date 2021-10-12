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

    private RacingCarCaptureGroups getVictoryGroups() {
        return roundScoreGroups.getVictoryGroups();
    }

    public List<String> getVictoryGroupsNames() {
        final RacingCarCaptureGroups victoryGroups = getVictoryGroups();
        return victoryGroups.getNames();
    }

    public List<RoundScore> getRoundScoreGroups() {
        return roundScoreGroups.getRoundScores();
    }
}
