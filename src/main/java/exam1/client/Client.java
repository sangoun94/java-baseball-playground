package exam1.client;

import java.util.Scanner;

public class Client {
    private static String[] inputString;

    public Client() {
    }

    public String[] initInput() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        if(str.length() < 1 || str.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*") || str.matches(".*[a-zA-Z]+.*")){
            throw new IllegalStateException("연산에 대한 요소들로 작성해주세요.");
        }

        String[] inputString = str.split(" ");


        return inputString;
    }
}
