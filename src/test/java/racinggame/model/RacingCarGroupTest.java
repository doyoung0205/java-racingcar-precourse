package racinggame.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RacingCarGroupTest {
    @Test
    void 레이싱카그룹은_쉼표를_기준으로_레이싱카를_생성할_수_있다() {
        String names = "포르쉐,마세라티,람보르기니";
        final List<RacingCar> racingCarList = Arrays.asList(RacingCar.getInstanceByName("포르쉐"), RacingCar.getInstanceByName("마세라티"), RacingCar.getInstanceByName("람보르기니"));
        RacingCarGroup racingCarGroup = new RacingCarGroup(names);
        assertNotNull(racingCarGroup);
        assertEquals(racingCarGroup.size(), 3);
        assertRacingCarNameMatch(racingCarGroup, racingCarList);
    }

    private void assertRacingCarNameMatch(RacingCarGroup racingCarGroup, List<RacingCar> racingCarList) {
        final List<RacingCar> racingCars = racingCarGroup.getRacingCars();
        for (int i = 0; i < racingCars.size(); i++) {
            final RacingCar racingCar = racingCars.get(i);
            assertEquals(racingCar.getName(), racingCarList.get(i).getName());
        }
    }
    
}
