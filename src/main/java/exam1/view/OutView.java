package exam1.view;

import exam1.core.Calculator;

public class OutView {
    public OutView() {

    }

    public void print(Calculator calculator) {
        System.out.println(calculator.getResultValue().getResult());
    }
}
