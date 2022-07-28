package baseball.core;

import java.util.ArrayList;

public class Position {
    private ArrayList<Integer> strikePosition;
    private ArrayList<Integer> ballSourcePosition;
    private ArrayList<Integer> ballClientSourcePosition;
    public Position() {
        strikePosition = new ArrayList<>();
        ballSourcePosition = new ArrayList<>();
        ballClientSourcePosition = new ArrayList<>();
    }

    //스트라이크된 갯수 반환
    public int getStrikeCount(ArrayList<Integer> source, ArrayList<Integer> clientSource) {
        for (int i = 0; i < source.size(); i++) {
            searchStrikePosition(source, clientSource, i);
        }
        return strikePosition.size();
    }

    private void searchStrikePosition(ArrayList<Integer> source, ArrayList<Integer> clientSource, int i) {
        if (source.get(i) == clientSource.get(i)) {
            strikePosition.add(i);
        }
    }

    // 1. 스트라이크 된 애들 제외
    // 2. 볼 됐던 애들 제외 -> (source, clientSource)의 볼 됐던 position 건들 제외
    public int getBallCount(ArrayList<Integer> sourceAL, ArrayList<Integer> clientSourceAL) {
        for (int i = 0; i < sourceAL.size(); i++) {
            expectBallStrikeSource(sourceAL, clientSourceAL, i);
        }

        return ballSourcePosition.size();
    }

    private void expectBallStrikeSource(ArrayList<Integer> sourceAL, ArrayList<Integer> clientSourceAL, int i) {
        if (!strikePosition.contains(i) && !ballSourcePosition.contains(i)) {
            checkClientSource(sourceAL, clientSourceAL, i);
        }
    }

    private void checkClientSource(ArrayList<Integer> sourceAL, ArrayList<Integer> clientSourceAL, int i) {
        for (int j = 0; j < clientSourceAL.size(); j++) {
            expectBallStrikeClient(sourceAL, clientSourceAL, i, j);
        }
    }

    private void expectBallStrikeClient(ArrayList<Integer> sourceAL, ArrayList<Integer> clientSourceAL, int i, int j) {
        // 1. 스트라이크 제외, 2. 볼 된 케이스 제외
        if (!strikePosition.contains(j) && !ballClientSourcePosition.contains(j)) {
            equalsSources(sourceAL, clientSourceAL, i, j);
        }
    }

    private void equalsSources(ArrayList<Integer> sourceAL, ArrayList<Integer> clientSourceAL, int i, int j) {
        if (sourceAL.get(i) == clientSourceAL.get(j)) {
            // 2. 볼 된 애들
            ballSourcePosition.add(i);
            ballClientSourcePosition.add(j);
        }
    }
}
