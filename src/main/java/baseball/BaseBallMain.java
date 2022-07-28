package baseball;

import baseball.core.Baseball;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseBallMain {
    public static void main(String[] args) {
        Baseball baseball = new Baseball();
        baseball.play();
    }
}
