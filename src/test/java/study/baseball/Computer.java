package study.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class Computer {
    private baseball.core.Computer computer;

    @BeforeEach
    public void beforeEach() {
        computer = new baseball.core.Computer();
    }

    //source 초기화 필요
    @Test
    public void 랜덤생성_3자리_테스트_예외() {
        assertThatThrownBy(()->computer.randomSource())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("난수가");
    }

    @Test
    public void 랜덤생성_3자리_테스트() {
        computer.randomSource();
        assertThat(computer.getSource().length()).isEqualTo(3);
    }
}
