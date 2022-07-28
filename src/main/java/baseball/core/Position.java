package baseball.core;

import java.util.ArrayList;

public class Position {
    private ArrayList<Integer> strikeSourcePosition = new ArrayList<>();

    public Position() {
    }

    public ArrayList<Integer> getStrikeSourcePosition() {
        return strikeSourcePosition;
    }

    public int searchStrikePosition(ArrayList<Integer> source, ArrayList<Integer> clientSource) {
        int strikeCount = 0;
        for (int i = 0; i < source.size(); i++) {
            removePosition(source, clientSource, i);
            strikeCount += 1;
        }
        return strikeCount;
    }

    private void removePosition(ArrayList<Integer> source, ArrayList<Integer> clientSource, int i) {
        if (source.get(i) == clientSource.get(i)) {
            source.remove(i);
            clientSource.remove(i);
        }
    }

    private void compareValueCheck(String source, String clientSource, int i) {
        if(clientSource.toCharArray()[i] == source.toCharArray()[i]){
            strikeSourcePosition.add(source.indexOf(source.toCharArray()[i]));
        }
    }

    public boolean strikeExcept(int index) {
        boolean expectFlag = false;

        if (!strikeSourcePosition.contains(index)) {
            expectFlag = true;
        }

        return expectFlag;
    }
}
