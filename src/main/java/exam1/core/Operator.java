package exam1.core;

public class Operator {
    private int result;

    public Operator() {
        this.result = 0;
    }

    public int getResult() {
        return this.result;
    }

    public int initResult(String[] inputStr, int i) {
        if (i == 0) {
            result = Integer.parseInt(inputStr[i]);
        }
        return result;
    }

    public int calResult(String[] inputStr, int i) {
        if (i % 2 == 1) {
            if(inputStr[i].equals("+")){
                result += Integer.parseInt(inputStr[i + 1]);
            }
            if(inputStr[i].equals("-")){
                result -= Integer.parseInt(inputStr[i + 1]);
            }
            if(inputStr[i].equals("*")){
                result *= Integer.parseInt(inputStr[i + 1]);
            }
            if(inputStr[i].equals("/")){
                result /= Integer.parseInt(inputStr[i + 1]);
            }
        }
        return result;
    }
}
