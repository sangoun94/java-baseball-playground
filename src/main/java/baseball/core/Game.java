package baseball.core;

import baseball.view.ResultView;
import exam1.client.Client;

import javax.swing.event.ChangeEvent;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Game {
    private int strike;
    private int ball;
    private String nothing;
    private Position position;
    private ResultView resultView;
    private ArrayList<Integer> sourceAL = new ArrayList<>();
    private ArrayList<Integer> clientSourceAL = new ArrayList<>();

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

        strike = position.getStrikeCount(sourceAL, clientSourceAL);
        ball = position.getBallCount(sourceAL, clientSourceAL);
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
