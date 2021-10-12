package racinggame;

import racinggame.controller.RacingCarGameController;
import racinggame.controller.dto.RacingCarGameRequestDto;
import racinggame.controller.dto.RacingCarGameResponseDto;
import racinggame.view.RacingCarGameForm;
import racinggame.view.RacingCarGameResultView;

public class Application {
    private static final RacingCarGameController controller;
    private static final RacingCarGameForm form;
    private static final RacingCarGameResultView view;

    static {
        controller = new RacingCarGameController();
        form = new RacingCarGameForm();
        view = new RacingCarGameResultView();
    }

    public static void main(String[] args) {
        final RacingCarGameRequestDto requestDto = form.submit();
        final RacingCarGameResponseDto gameResultResponseDto = controller.start(requestDto);
        view.resolve(gameResultResponseDto);
    }
}
