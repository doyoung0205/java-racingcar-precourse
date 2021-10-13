package racinggame.model.racingcargame;

import org.junit.jupiter.api.Test;
import racinggame.model.RacingCarGame;
import racinggame.model.RacingCarGroups;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarGameGetInstanceTest {
    @Test
    void 레이싱카게임은_경주에_참여할_레이싱카그룹_을_게임에_참여_시킬_수_있다() {
        String names = "aCar,bCar,cCar,dCar,eCar";
        final RacingCarGroups carGroups = RacingCarGroups.getInstanceByNames(names);
        int rounds = 1;
        final RacingCarGame racingCarGame = RacingCarGame.getInstanceByParticipatedNamesAndRounds(names, rounds);
        final RacingCarGroups participatedGroups = racingCarGame.getParticipatedGroups();
        assertEquals(carGroups, participatedGroups);
    }
}
