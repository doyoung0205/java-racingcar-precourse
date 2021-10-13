package racinggame.model.racingcargame;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racinggame.model.RacingCarGame;
import racinggame.model.RacingCarGameResult;
import racinggame.model.RoundScore;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarGameStartTest {

    private static final int START_RANDOM_NUMBER = 0;
    private static final int END_RANDOM_NUMBER = 9;
    private static final int MOVE_FORWARD = 4;
    private static final int STOP = 0;
    private static final String NAMES = "aCar,bCar,cCar";
    private static final int ROUNDS = 4;
    private static final String A_CAR = "aCar";
    private static final String B_CAR = "bCar";
    private static final String C_CAR = "cCar";
    RacingCarGame racingCarGame;

    @BeforeEach
    public void setup() {
        racingCarGame = RacingCarGame.getInstanceByParticipatedNamesAndRounds(NAMES, ROUNDS);
    }

    @Test
    @DisplayName("게임이_끝난후_우승자가_단일인_경우_결과값_비교")
    void singleVictory() {
        try (MockedStatic<Randoms> mockRandom = Mockito.mockStatic(Randoms.class)) {
            mockRandom.when(() -> Randoms.pickNumberInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER))
                    .thenReturn(MOVE_FORWARD, STOP, STOP,
                            MOVE_FORWARD, STOP, STOP,
                            MOVE_FORWARD, MOVE_FORWARD, STOP,
                            MOVE_FORWARD, MOVE_FORWARD, STOP);
            final RacingCarGameResult racingCarGameResult = racingCarGame.start();
            assertAllSingleVictory(racingCarGameResult);
        }
    }

    @Test
    @DisplayName("게임이_끝난후_우승자가_여럿인_경우_결과값_비교")
    void multiVictory() {
        try (MockedStatic<Randoms> mockRandom = Mockito.mockStatic(Randoms.class)) {
            mockRandom.when(() -> Randoms.pickNumberInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER))
                    .thenReturn(MOVE_FORWARD, MOVE_FORWARD, STOP,
                            MOVE_FORWARD, STOP, MOVE_FORWARD,
                            MOVE_FORWARD, MOVE_FORWARD, MOVE_FORWARD,
                            STOP, MOVE_FORWARD, STOP);
            final RacingCarGameResult racingCarGameResult = racingCarGame.start();
            assertAllMultiVictory(racingCarGameResult);
        }
    }

    private void assertAllSingleVictory(RacingCarGameResult racingCarGameResult) {
        assertAll(() -> {
            final List<String> victoryGroupsNames = racingCarGameResult.getVictoryGroupsNames();
            // 우승자 크기와 이름 검증
            assertEquals(victoryGroupsNames.size(), 1);
            assertEquals(victoryGroupsNames.get(0), A_CAR);
            // 라운드 기록 검증
            final List<RoundScore> roundScoreGroups = racingCarGameResult.getRoundScoreGroups();
            // 첫번째 라운드 기록 검증
            final RoundScore round1Score = roundScoreGroups.get(0);
            assertEquals(round1Score.getRacingCarCaptureGroups().get(0).getName(), A_CAR);
            assertEquals(round1Score.getRacingCarCaptureGroups().get(1).getName(), B_CAR);
            assertEquals(round1Score.getRacingCarCaptureGroups().get(2).getName(), C_CAR);
            assertEquals(round1Score.getRacingCarCaptureGroups().get(0).getDistance(), 1);
            assertEquals(round1Score.getRacingCarCaptureGroups().get(1).getDistance(), 0);
            assertEquals(round1Score.getRacingCarCaptureGroups().get(2).getDistance(), 0);
            // 두번째 라운드 기록 검증
            final RoundScore round2Score = roundScoreGroups.get(1);
            assertEquals(round2Score.getRacingCarCaptureGroups().get(0).getName(), A_CAR);
            assertEquals(round2Score.getRacingCarCaptureGroups().get(1).getName(), B_CAR);
            assertEquals(round2Score.getRacingCarCaptureGroups().get(2).getName(), C_CAR);
            assertEquals(round2Score.getRacingCarCaptureGroups().get(0).getDistance(), 2);
            assertEquals(round2Score.getRacingCarCaptureGroups().get(1).getDistance(), 0);
            assertEquals(round2Score.getRacingCarCaptureGroups().get(2).getDistance(), 0);
            // 세번째 라운드 기록 검증
            final RoundScore round3Score = roundScoreGroups.get(2);
            assertEquals(round3Score.getRacingCarCaptureGroups().get(0).getName(), A_CAR);
            assertEquals(round3Score.getRacingCarCaptureGroups().get(1).getName(), B_CAR);
            assertEquals(round3Score.getRacingCarCaptureGroups().get(2).getName(), C_CAR);
            assertEquals(round3Score.getRacingCarCaptureGroups().get(0).getDistance(), 3);
            assertEquals(round3Score.getRacingCarCaptureGroups().get(1).getDistance(), 1);
            assertEquals(round3Score.getRacingCarCaptureGroups().get(2).getDistance(), 0);
            // 네번째 라운드 기록 검증
            final RoundScore round4Score = roundScoreGroups.get(3);
            assertEquals(round4Score.getRacingCarCaptureGroups().get(0).getName(), A_CAR);
            assertEquals(round4Score.getRacingCarCaptureGroups().get(1).getName(), B_CAR);
            assertEquals(round4Score.getRacingCarCaptureGroups().get(2).getName(), C_CAR);
            assertEquals(round4Score.getRacingCarCaptureGroups().get(0).getDistance(), 4);
            assertEquals(round4Score.getRacingCarCaptureGroups().get(1).getDistance(), 2);
            assertEquals(round4Score.getRacingCarCaptureGroups().get(2).getDistance(), 0);
            // 마지막 라운드 결과 검증
            final RoundScore roundLastScore = roundScoreGroups.get(roundScoreGroups.size() - 1);
            assertEquals(roundLastScore.getMaxDistanceRacingCarGroups().getNames().size(), 1);
            assertEquals(roundLastScore.getMaxDistanceRacingCarGroups().getNames().get(0), A_CAR);
            assertEquals(roundLastScore.getMaxDistanceRacingCarGroups().getRacingCarCaptures().get(0).getName(), A_CAR);
            assertEquals(roundLastScore.getMaxDistanceRacingCarGroups().getRacingCarCaptures().get(0).getDistance(), 4);
        });
    }

    private void assertAllMultiVictory(RacingCarGameResult racingCarGameResult) {
        assertAll(() -> {
            final List<String> victoryGroupsNames = racingCarGameResult.getVictoryGroupsNames();
            // 우승자 크기와 이름 검증
            assertEquals(victoryGroupsNames.size(), 2);
            assertEquals(victoryGroupsNames.get(0), A_CAR);
            assertEquals(victoryGroupsNames.get(1), B_CAR);
            // 라운드 기록 검증
            final List<RoundScore> roundScoreGroups = racingCarGameResult.getRoundScoreGroups();
            // 첫번째 라운드 기록 검증
            final RoundScore round1Score = roundScoreGroups.get(0);
            assertEquals(round1Score.getRacingCarCaptureGroups().get(0).getName(), A_CAR);
            assertEquals(round1Score.getRacingCarCaptureGroups().get(1).getName(), B_CAR);
            assertEquals(round1Score.getRacingCarCaptureGroups().get(2).getName(), C_CAR);
            assertEquals(round1Score.getRacingCarCaptureGroups().get(0).getDistance(), 1);
            assertEquals(round1Score.getRacingCarCaptureGroups().get(1).getDistance(), 1);
            assertEquals(round1Score.getRacingCarCaptureGroups().get(2).getDistance(), 0);
            // 두번째 라운드 기록 검증
            final RoundScore round2Score = roundScoreGroups.get(1);
            assertEquals(round2Score.getRacingCarCaptureGroups().get(0).getName(), A_CAR);
            assertEquals(round2Score.getRacingCarCaptureGroups().get(1).getName(), B_CAR);
            assertEquals(round2Score.getRacingCarCaptureGroups().get(2).getName(), C_CAR);
            assertEquals(round2Score.getRacingCarCaptureGroups().get(0).getDistance(), 2);
            assertEquals(round2Score.getRacingCarCaptureGroups().get(1).getDistance(), 1);
            assertEquals(round2Score.getRacingCarCaptureGroups().get(2).getDistance(), 1);
            // 세번째 라운드 기록 검증
            final RoundScore round3Score = roundScoreGroups.get(2);
            assertEquals(round3Score.getRacingCarCaptureGroups().get(0).getName(), A_CAR);
            assertEquals(round3Score.getRacingCarCaptureGroups().get(1).getName(), B_CAR);
            assertEquals(round3Score.getRacingCarCaptureGroups().get(2).getName(), C_CAR);
            assertEquals(round3Score.getRacingCarCaptureGroups().get(0).getDistance(), 3);
            assertEquals(round3Score.getRacingCarCaptureGroups().get(1).getDistance(), 2);
            assertEquals(round3Score.getRacingCarCaptureGroups().get(2).getDistance(), 2);
            // 네번째 라운드 기록 검증
            final RoundScore round4Score = roundScoreGroups.get(3);
            assertEquals(round4Score.getRacingCarCaptureGroups().get(0).getName(), A_CAR);
            assertEquals(round4Score.getRacingCarCaptureGroups().get(1).getName(), B_CAR);
            assertEquals(round4Score.getRacingCarCaptureGroups().get(2).getName(), C_CAR);
            assertEquals(round4Score.getRacingCarCaptureGroups().get(0).getDistance(), 3);
            assertEquals(round4Score.getRacingCarCaptureGroups().get(1).getDistance(), 3);
            assertEquals(round4Score.getRacingCarCaptureGroups().get(2).getDistance(), 2);
            // 마지막 라운드 결과 검증
            final RoundScore roundLastScore = roundScoreGroups.get(roundScoreGroups.size() - 1);
            assertEquals(roundLastScore.getMaxDistanceRacingCarGroups().getNames().size(), 2);
            assertEquals(roundLastScore.getMaxDistanceRacingCarGroups().getNames().get(0), A_CAR);
            assertEquals(roundLastScore.getMaxDistanceRacingCarGroups().getNames().get(1), B_CAR);
            assertEquals(roundLastScore.getMaxDistanceRacingCarGroups().getRacingCarCaptures().get(0).getName(), A_CAR);
            assertEquals(roundLastScore.getMaxDistanceRacingCarGroups().getRacingCarCaptures().get(1).getName(), B_CAR);
            assertEquals(roundLastScore.getMaxDistanceRacingCarGroups().getRacingCarCaptures().get(0).getDistance(), 3);
            assertEquals(roundLastScore.getMaxDistanceRacingCarGroups().getRacingCarCaptures().get(1).getDistance(), 3);
        });
    }
}
