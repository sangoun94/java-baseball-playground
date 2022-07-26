package exam1;

import exam1.core.Calculator;
import exam1.view.OutView;

public class CalculatorMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.cal();

        new OutView().print(calculator);
    }
}
