package racinggame.controller;

import racinggame.controller.dto.RacingCarGameRequestDto;
import racinggame.controller.dto.RacingCarGameResponseDto;
import racinggame.service.RacingCarGameService;

public class RacingCarGameController {

	private final RacingCarGameService racingCarGameService;

	public RacingCarGameController() {
		this.racingCarGameService = new RacingCarGameService();
	}

	public RacingCarGameResponseDto start(final RacingCarGameRequestDto requestDto) {
		return racingCarGameService.start(requestDto);
	}
}
