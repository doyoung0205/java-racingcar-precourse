package racinggame.model;

import racinggame.model.expcetion.ParticipatedGroupNotEmptyException;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private static final String PARTICIPATED_GROUP_NOT_EMPTY_ERROR_MESSAGE = "[ERROR] 게임에 참여하는 게이싱카그룹이 비어있습니다.";
    private final RacingCarGroups participatedGroups;
    private final Rounds rounds;

    private RacingCarGame(RacingCarGroups participatedGroups, Rounds rounds) {
        this.participatedGroups = participatedGroups;
        this.rounds = rounds;
    }

    public static RacingCarGame getInstanceByParticipatedGroupAndRounds(RacingCarGroups participatedGroups, int rounds) {
        validateNotNull(participatedGroups);
        return new RacingCarGame(participatedGroups, Rounds.valueOf(rounds));
    }

    private static void validateNotNull(RacingCarGroups participatedGroups) throws ParticipatedGroupNotEmptyException {
        if (participatedGroups == null) {
            throw new ParticipatedGroupNotEmptyException(PARTICIPATED_GROUP_NOT_EMPTY_ERROR_MESSAGE);
        }
    }

    public RacingCarGameResult start() {
        final List<RoundScore> roundScoreList = raceUntilNoNextRound();
        return RacingCarGameResult.valueOf(roundScoreList);
    }

    private List<RoundScore> raceUntilNoNextRound() {
        final List<RoundScore> roundScoreList = new ArrayList<>();
        while (rounds.hasNextRound()) {
            final int round = rounds.nextRound();
            final RoundScore roundScore = participatedGroups.race(round);
            roundScoreList.add(roundScore);
        }
        return roundScoreList;
    }

    public RacingCarGroups getParticipatedGroups() {
        return participatedGroups;
    }
}
