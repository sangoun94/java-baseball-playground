package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String actual = "(1,2)";
        actual = actual.substring(1,actual.length()-1);

        String[] actualArr = actual.split(",");

        assertThat(actualArr[0]).isEqualTo("1");
        assertThat(actualArr[1]).isEqualTo("2");
    }

    @Test
    @DisplayName("charAt 테스트")
    void charAt() {
        String actual = "abc";
        assertThatThrownBy(() -> {
            actual.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
