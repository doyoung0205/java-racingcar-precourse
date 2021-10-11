package racinggame.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarGameTest {
    @Test
    void 레이싱카게임은_경주에_참여할_레이싱카그룹_을_게임에_참여_시킬_수_있다() {
        RacingCarGroups racingCarGroups = RacingCarGroups.getInstanceByNames("1111,2222,3333,4444,5555");
        int rounds = 1;
        final RacingCarGame racingCarGame = RacingCarGame.getInstanceByParticipatedGroupAndRounds(racingCarGroups, rounds);
        final RacingCarGroups participatedGroup = racingCarGame.getParticipatedGroups();
    }

    private void assertRacingCarNameMatch(RacingCarGroups racingCarGroups, List<RacingCar> racingCarList) {
        final List<RacingCar> racingCars = racingCarGroups.getRacingCars();
        for (int i = 0; i < racingCarGroups.size(); i++) {
            final RacingCar racingCar = racingCars.get(i);
            assertEquals(racingCar.getName(), racingCarList.get(i).getName());
        }
    }

}
