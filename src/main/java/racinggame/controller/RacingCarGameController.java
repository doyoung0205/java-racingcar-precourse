package racinggame.controller;

import racinggame.model.RacingCarGame;
import racinggame.model.RacingCarGameResult;

public class RacingCarGameController {
    public RacingCarGameResult start(final RacingCarGameRequestDto requestDto) {
        final RacingCarGame racingCarGame = requestDto.toEntity();
        return racingCarGame.start();
    }
}
