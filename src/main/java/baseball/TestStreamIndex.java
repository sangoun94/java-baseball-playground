package baseball;

import java.util.stream.Collectors;

public class TestStreamIndex {
    private String filtered(String s) {
        int[] index = {0};
        return s.chars()
                .filter(c -> ++index[0] % 2 == 0)  // 여기!!
                .mapToObj(Character::toString)
                .collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        TestStreamIndex testStreamIndex = new TestStreamIndex();
        String nums = "123456789";
        System.out.println(testStreamIndex.filtered(nums));
    }
}
