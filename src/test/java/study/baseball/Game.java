package study.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

public class Game {
    private baseball.core.Game game;
    public static final String source = "542";
    public static final String clientSource = "452";

    @BeforeEach
    public void beforeEach() {
        InputStream in = new ByteArrayInputStream(clientSource.getBytes());
        System.setIn(in);
        game = new baseball.core.Game();
    }
}
