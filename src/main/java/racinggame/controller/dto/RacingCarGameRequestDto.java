package racinggame.controller.dto;

import racinggame.model.RacingCarGame;

public class RacingCarGameRequestDto {
	private final String participatedNames;
	private final int rounds;

	public RacingCarGameRequestDto(String participatedNames, int rounds) {
		this.participatedNames = participatedNames;
		this.rounds = rounds;
	}

	public RacingCarGame toEntity() {
		return RacingCarGame.getInstanceByParticipatedNamesAndRounds(this.participatedNames, this.rounds);
	}
}
