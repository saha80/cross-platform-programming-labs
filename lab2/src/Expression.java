import number.complex.complexImpl.ComplexLinearForm;

import java.util.List;
import java.util.Random;

enum Operation {
    ADD, SUB
}

public class Expression {
    private final List<ComplexLinearForm> list;
    private final Operation operation = Operation.values()[new Random().nextInt(Operation.values().length)];

    public Expression(List<ComplexLinearForm> list) {
        this.list = list;
    }

    public ComplexLinearForm calculateResult() {
        ComplexLinearForm sum = list.get(0);
        switch (operation) {
            case ADD:
                sum.add(list.get(1));
                return sum;
            case SUB:
                sum.sub(list.get(1));
                return sum;
        }
        return sum;
    }
}