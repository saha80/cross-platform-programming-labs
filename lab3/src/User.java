public class User {
    private String name;

    User(String name) {
        this.name = name;
    }

    public void calculateExpression(Expression expr, Operation op) {
        expr.setOperation(op);
        expr.calculateResult();
    }
}
