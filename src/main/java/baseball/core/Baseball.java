package baseball.core;

import baseball.view.InputView;
import baseball.view.ResultView;

public class Baseball {
    private Computer computer;
    private InputView inputView;
    private ResultView resultView;
    private Game game;

    public Baseball() {
        this.computer = new Computer();
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.game = new Game();

        computer.randomSource();
    }

    public void play() {
        clientBaseball();
        game.start(computer.getSource(), inputView.getClientSource());
        resultView.result(this);
    }

    public void rePlay() {
        this.game = new Game();
        play();
    }

    private void clientBaseball() {
        inputView.showClientView();
    }

    public Computer getComputer() {
        return computer;
    }

    public InputView getInputView() {
        return inputView;
    }

    public Game getGame() {
        return game;
    }

}
