package baseball.core;

import baseball.view.ResultView;
import exam1.client.Client;

import javax.swing.event.ChangeEvent;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Game {
    private int strike;
    private int ball;
    private ArrayList<Integer> sourceAL = new ArrayList<>();
    private ArrayList<Integer> clientSourceAL = new ArrayList<>();
    private Position position;
    private ResultView resultView;
    private String nothing;

    public Game() {
        position = new Position();
        resultView = new ResultView();
        strike = 0;
        ball = 0;
        nothing = "";
    }

    /*
    * 456, 657 1s 1b*/
    public void start(String source, String clientSource) {
        initSource(source, clientSource);




        strike = position.searchStrikePosition(sourceAL, clientSourceAL);

        String expectedSource = expectedStrikeSources(source);
        String expectedClientSource = expectedStrikeSources(clientSource);

        setBall(expectedSource, expectedClientSource);
        setNothing();
    }

    private void initSource(String source, String clientSource) {
        addArrayList(source, sourceAL);
        addArrayList(clientSource, clientSourceAL);
    }

    private void addArrayList(String source, ArrayList<Integer> destination) {
        for (int sourceInt :
                source.chars().toArray()) {
            destination.add(sourceInt);
        }
    }

    private void setNothing() {
        if (ball == 0 && strike == 0) {
            nothing = "낫딩";
            return;
        }
        nothing = "";
    }

    //문자열을 스트라이크 제외한 새로운 문자열로 구현
    private String expectedStrikeSources(String source) {
        int[] index = {0};

        return source.chars()
                .filter(c -> position.strikeExcept(index[0]++))
                .mapToObj(Character::toString)
                .collect(Collectors.joining(""));
    }

    private void setBall(String source, String clientSource) {
        int resultBallCnt = 0;
        for (char compareChar :
                clientSource.toCharArray()) {
            resultBallCnt += source.chars()
                                .filter(standardChar -> standardChar == compareChar)
                                .count();
        }
        ball = resultBallCnt;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public String getNothing() {
        return nothing;
    }
}
