package baseball.core;

import java.util.Random;

public class Computer {
    private String source = "";
    private static final int LENGTH = 3;

    public Computer() {
    }

    public String getSource() {
        return this.source;
    }

    public void randomSource() {
        int element = 0;

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        for (int i = 0; i < LENGTH; i++) {
            element = random.nextInt(9);
            source += Integer.toString(element);
        }

        validationSource();
    }

    private void validationSource() {
        if(source.length() != 3){
            throw new IllegalStateException("난수가 잘못 생성되었습니다.");
        }
    }
}
