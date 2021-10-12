package racinggame.model.roundscore;

import nextstep.test.NSTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.model.RacingCar;
import racinggame.model.RacingCarCapture;
import racinggame.model.RacingCarGroups;
import racinggame.model.RoundScore;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RoundScoreValueOfTest extends NSTest {
    private static final int MOVE_FORWARD = 5;
    RoundScore roundScore;
    List<RacingCarCapture> racingCars;

    @BeforeEach
    public void setup() {
        final List<RacingCarCapture> racingCars = new ArrayList<>();
        final RacingCar racingCar = RacingCar.getInstanceByName("테스트차1");
        alwaysMoveForward(racingCar);
        alwaysMoveForward(racingCar);
        racingCars.add(RacingCarCapture.valueOf(racingCar));

        final RacingCar racingCar2 = RacingCar.getInstanceByName("테스트차2");
        alwaysMoveForward(racingCar2);
        racingCars.add(RacingCarCapture.valueOf(racingCar2));

        this.roundScore = RoundScore.valueOf(racingCars);
        this.racingCars = racingCars;
    }

    @Test
    void 레이싱카캡처가_모여서_라운드스코어를_생성할_수_있다() {
        final List<RacingCarCapture> racingCarCaptures = roundScore.getRacingCarCaptureGroups();
        assertAll(() -> {
            assertEquals(racingCarCaptures.get(0).getName(), racingCars.get(0).getName());
            assertEquals(racingCarCaptures.get(0).getDistance(), racingCars.get(0).getDistance());
            assertEquals(racingCarCaptures.get(1).getName(), racingCars.get(1).getName());
            assertEquals(racingCarCaptures.get(1).getDistance(), racingCars.get(1).getDistance());
        });
    }

    @Test
    void 레이싱카그룹의_라운드_레이스_결과를_반환한다() {
        //given
        final String names = "a,b,c,d,e";
        final StringTokenizer namesToken = new StringTokenizer(names, ",");
        final RacingCarGroups racingCarGroups = RacingCarGroups.getInstanceByNames(names);
        // when
        final RoundScore race = racingCarGroups.race();
        final List<RacingCarCapture> racingCarCaptureGroups = race.getRacingCarCaptureGroups();
        // then
        for (RacingCarCapture carCapture : racingCarCaptureGroups) {
            assertEquals(carCapture.getName(), namesToken.nextToken());
            assertThat(carCapture.getDistance()).isLessThanOrEqualTo(1);
            assertThat(carCapture.getDistance()).isGreaterThanOrEqualTo(0);
        }
    }

    public void alwaysMoveForward(RacingCar racingCar) {
        assertRandomTest(racingCar::race, MOVE_FORWARD, 1, 9);
    }

    @Override
    protected void runMain() {
    }
}