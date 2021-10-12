package racinggame.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private final RacingCarGroups participatedGroups;
    private final Rounds rounds;

    private RacingCarGame(RacingCarGroups participatedGroups, Rounds rounds) {
        this.participatedGroups = participatedGroups;
        this.rounds = rounds;
    }

    public static RacingCarGame getInstanceByParticipatedNamesAndRounds(String names, int rounds) {
        return new RacingCarGame(RacingCarGroups.getInstanceByNames(names), Rounds.valueOf(rounds));
    }

    public RacingCarGameResult start() {
        final List<RoundScore> roundScoreList = raceUntilNoNextRound();
        return RacingCarGameResult.valueOf(roundScoreList);
    }

    private List<RoundScore> raceUntilNoNextRound() {
        final List<RoundScore> roundScoreList = new ArrayList<>();
        while (rounds.hasNextRound()) {
            final RoundScore roundScore = participatedGroups.race();
            roundScoreList.add(roundScore);
            rounds.nextRound();
        }
        return roundScoreList;
    }

    public RacingCarGroups getParticipatedGroups() {
        return participatedGroups;
    }
}
