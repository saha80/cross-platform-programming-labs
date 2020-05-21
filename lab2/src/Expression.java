import java.util.ArrayList;
import java.util.Random;

enum Operation {
    ADD, SUB;
}

public class Expression {
    private ArrayList<ComplexLinearForm> list;
    private final Operation operation = Operation.values()[new Random().nextInt(Operation.values().length - 1)];

    public Expression(ArrayList<ComplexLinearForm> list) {
        this.list = list;
    }

    public ComplexLinearForm calculateResult() {
        ComplexLinearForm sum = new ComplexLinearForm(0, 0);
        switch (operation) {
            case ADD:
                for (ComplexLinearForm n : list) {
                    sum.add(n);
                }
                return sum;
            case SUB:
                for (ComplexLinearForm n : list) {
                    sum.sub(n);
                }
                return sum;
        }
        return sum;
    }
}