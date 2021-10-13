package racinggame.service;

import racinggame.controller.dto.RacingCarGameRequestDto;
import racinggame.controller.dto.RacingCarGameResponseDto;
import racinggame.model.RacingCarGame;
import racinggame.model.RacingCarGameResult;

public class RacingCarGameService {
	public RacingCarGameResponseDto start(RacingCarGameRequestDto requestDto) {
		final RacingCarGame racingCarGame = requestDto.toEntity();
		final RacingCarGameResult carGameResult = racingCarGame.start();
		return RacingCarGameResponseDto.toDto(carGameResult);
	}
}
