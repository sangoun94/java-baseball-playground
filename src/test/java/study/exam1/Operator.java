package study.exam1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class Operator {
    private exam1.core.Operator operator;
    private final static String[] arrStr = "2 + 7 * 8 - 5".split(" ");

    @BeforeEach
    void beforeEach() {
        this.operator = new exam1.core.Operator();
    }

    @Test
    @DisplayName("결과값 가져오기")
    public void getResult() {
        assertThat(operator.getResult()).isEqualTo(0);
    }

    @Test
    @DisplayName("결과값 초기화")
    public void initResult() {
        assertThat(operator.initResult(arrStr, 0)).isEqualTo(2);
    }

    @Test
    @DisplayName("연산된 결과값")
    public void calResult() {
        operator.initResult(arrStr, 0);
        assertThat(operator.calResult(arrStr, 5)).isEqualTo(-3);
    }
}
