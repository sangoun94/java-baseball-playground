package baseball.view;

import baseball.core.Baseball;

import java.util.Scanner;

public class ResultView {
    public ResultView() {
    }

    public void showResult(Baseball baseball) {

        nothingCheckShow(baseball);
        showBallStrike(baseball);

        if (baseball.getGame().getStrike() != 3) {
            baseball.rePlay();
        }

        if (baseball.getGame().getStrike() == 3) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String answer = scanner.next();

            responseByAnswer(answer);
        }
    }

    private void responseByAnswer(String answer) {
        if (!answer.equals("1") && !answer.equals("2")) {
            throw new IllegalStateException("1 또는 2를 입력하지 않았습니다.");
        }
        if (answer.equals("1")) {
            new Baseball().play();
        }
        if (answer.equals("2")) {
            return;
        }
    }

    private void showBallStrike(Baseball baseball) {
        if (baseball.getGame().getStrike() == 0 && baseball.getGame().getBall() != 0) {
            System.out.println(baseball.getGame().getBall() + "볼");
            return;
        }

        if (baseball.getGame().getStrike() != 0 && baseball.getGame().getBall() == 0) {
            System.out.println(baseball.getGame().getStrike() + "스트라이크");
            return;
        }

        if (baseball.getGame().getStrike() != 0 && baseball.getGame().getBall() != 0) {
            System.out.println(baseball.getGame().getBall() + "볼 " + baseball.getGame().getStrike() + "스트라이크");
            return;
        }

    }

    private void nothingCheckShow(Baseball baseball) {
        if (!baseball.getGame().getNothing().equals("")) {
            System.out.println(baseball.getGame().getNothing());
            return;
        }
    }
}
