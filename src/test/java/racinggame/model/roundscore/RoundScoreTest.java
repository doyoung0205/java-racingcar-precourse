package racinggame.model.roundscore;

import org.junit.jupiter.api.Test;
import racinggame.model.RacingCarCapture;
import racinggame.model.RacingCarGroups;
import racinggame.model.RoundScore;

import java.util.List;
import java.util.StringTokenizer;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RoundScoreTest {

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
}