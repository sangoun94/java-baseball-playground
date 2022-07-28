package study.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class Position {
    private baseball.core.Position position;
    ArrayList<Integer> sourceAL = new ArrayList<>();
    ArrayList<Integer> clientSourceAL = new ArrayList<>();

    @BeforeEach
    public void beforeEach() {
        position = new baseball.core.Position();
        sourceAL.add(2);
        sourceAL.add(2);
        sourceAL.add(4);
        clientSourceAL.add(3);
        clientSourceAL.add(2);
        clientSourceAL.add(2);
    }

    @Test
    public void getStrikeCount() {
        assertThat(position.getStrikeCount(sourceAL, clientSourceAL)).isEqualTo(1);
    }

    @Test
    public void getBallCount() {
        position.getStrikeCount(sourceAL, clientSourceAL);
        assertThat(position.getBallCount(sourceAL, clientSourceAL)).isEqualTo(1);
    }

}
