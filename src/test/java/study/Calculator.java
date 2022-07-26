package study;

import exam1.client.Client;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.*;

/*
사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
 */
public class Calculator {
    private static final String errMsg = "연산에 대한 요소들로 작성해주세요.";

    @Test
    @DisplayName("사용자 입력 값 예외처리")
    public void new_calculator() {
        String input = "1 + 2 h 3";
        //OutputStream out = new ByteArrayOutputStream();
        //System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(()->{
            new Client().initInput();
        }).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(errMsg);
    }
}
