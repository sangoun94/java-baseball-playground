package baseball.view;

import java.util.Scanner;

public class InputView {
    private String clientSource;

    public InputView() {
    }

    public void showClientView() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("숫자를 입력해 주세요 : ");

        clientSource = scanner.next();

        if (clientSource.length() > 3 || clientSource.length() < 3) {
            throw new IllegalStateException("3자리로 입력해주세요.");
        }
    }

    public String getClientSource() {
        return clientSource;
    }
}
