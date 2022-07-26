package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현
    @Test
    @DisplayName("Set Size Test")
    public void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    // Test Case 구현
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("Set contain Test")
    public void contain(int number) {
        assertTrue(numbers.contains(number));
    }

    // Test Case 구현
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("Set Csv Test")
    public void contain2(int input, Boolean expect) {
        assertEquals(isContain(input), expect);
    }

    private boolean isContain(int input) {
        return numbers.contains(input);
    }
}
