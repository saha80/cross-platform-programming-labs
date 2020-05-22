import number.complex.complexImpl.ComplexLinearForm;

import java.util.List;
import java.util.Random;

enum Operation {
    ADD, SUB, DIV, MUL
}

public class Expression {
    private final List<ComplexLinearForm> list;
    private Operation operation;
    private ComplexLinearForm result;

    public Expression(List<ComplexLinearForm> list) {
        this.list = list;
    }

    public void setOperation(Operation op) {
        this.operation = op;
    }

    public ComplexLinearForm getResult() {
        return result;
    }

    public void calculateResult() {
        ComplexLinearForm res = list.get(0);
        switch (operation) {
            case ADD:
                res.add(list.get(1));
                result = res;
                return;
            case SUB:
                res.sub(list.get(1));
                result = res;
                return;
            case MUL:
                res.mul(list.get(1));
                result = res;
                return;
            case DIV:
                res.div(list.get(1));
                result = res;
        }
    }
}