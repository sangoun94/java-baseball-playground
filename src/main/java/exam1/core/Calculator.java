package exam1.core;

import exam1.client.Client;

public class Calculator {
    private Client client;
    private String[] inputStr;
    private Operator operator;

    public Calculator() {
        client = new Client();
        inputStr = client.initInput();
        operator = new Operator();
    }

    public Operator getResultValue() {
        return operator;
    }

    public void cal() {
        for (int i = 0; i < inputStr.length; i++) {
            operator.initResult(inputStr, i);

            operator.calResult(inputStr, i);
        }
    }
}
