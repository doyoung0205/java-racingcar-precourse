package racinggame.model;

import racinggame.model.expcetion.DuplicatedRacingCarNameException;
import racinggame.model.expcetion.EmptyRacingCarNameException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class RacingCarGroups {
    private static final String DUPLICATED_RACING_CAR_NAME_ERROR_MESSAGE = "[ERROR] 중복된 이름이 존재합니다.";
    private static final String RACING_CAR_NAME_NOT_EMPTY_ERROR_MESSAGE = "[ERROR] 레이싱카의 이름들은 빈문자열이거나 Null 일 수 없습니다.";
    private static final String CAR_NAME_DELIM = ",";

    private final List<RacingCar> racingCars;

    public RacingCarGroups(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingCarGroups getInstanceByNames(String names) {
        validateEmptyNames(names);
        final List<RacingCar> racingCars = getRacingCarsByNames(names);
        validateDuplicatedNames(racingCars);
        return new RacingCarGroups(racingCars);
    }

    private static void validateEmptyNames(String names) {
        if (names == null || names.equals("")) {
            throw new EmptyRacingCarNameException(RACING_CAR_NAME_NOT_EMPTY_ERROR_MESSAGE);
        }
    }

    private static List<RacingCar> getRacingCarsByNames(String names) {
        final List<RacingCar> racingCars = new ArrayList<>();
        final StringTokenizer nameTokens = new StringTokenizer(names, CAR_NAME_DELIM);
        while (nameTokens.hasMoreTokens()) {
            final String name = nameTokens.nextToken();
            racingCars.add(RacingCar.getInstanceByName(name));
        }
        return racingCars;
    }

    private static void validateDuplicatedNames(List<RacingCar> racingCarCaptures) {
        final Set<RacingCar> racingCarSet = new HashSet<>(racingCarCaptures);
        if (racingCarSet.size() != racingCarCaptures.size()) {
            throw new DuplicatedRacingCarNameException(DUPLICATED_RACING_CAR_NAME_ERROR_MESSAGE);
        }
    }

    public static RacingCarGroups valueOf(List<RacingCar> racingCars) {
        return new RacingCarGroups(racingCars);
    }

    public int size() {
        return this.racingCars.size();
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }

    public RoundScore race() {
        final List<RacingCarCapture> racingCarCaptures = new ArrayList<>();
        for (final RacingCar racingCar : racingCars) {
            racingCar.race();
            racingCarCaptures.add(racingCar.toCapture());
        }
        return RoundScore.valueOf(racingCarCaptures);
    }

    @Override
    public String toString() {
        return racingCars.toString();
    }
}
