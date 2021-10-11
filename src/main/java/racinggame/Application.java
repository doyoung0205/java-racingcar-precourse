package racinggame;

import racinggame.controller.RacingCarGameController;
import racinggame.controller.RacingCarGameRequestDto;
import racinggame.model.RacingCarGameResult;
import racinggame.view.RacingCarGameForm;
import racinggame.view.RacingCarGameView;

public class Application {
    private static final RacingCarGameController controller;
    private static final RacingCarGameForm form;
    private static final RacingCarGameView view;

    static {
        controller = new RacingCarGameController();
        form = new RacingCarGameForm();
        view = new RacingCarGameView();
    }

    public static void main(String[] args) {
        final RacingCarGameRequestDto requestDto = form.submit();
        final RacingCarGameResult gameResult = controller.start(requestDto);
        view.resolve(gameResult);
    }

}
