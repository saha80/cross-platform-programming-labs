import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;

public class Integral {
    private Expression formula;
    private double result;
    private Thread thread;
    private final double from, to;
    private final double step;
    private final int precision;

    public Integral(double from, double to, int precision) {
        this.from = Math.min(from, to);
        this.to = Math.max(to, from);
        if (precision < 1) {
            precision = 1;
        }
        this.precision = precision;
        this.step = (this.to - this.from) / precision;
    }

    public double f(double x) {
        return formula.setVariable("x", x).evaluate();
    }

    Trapeze addTrapeze(double x1, double x2) {
        return new Trapeze(f(x1), f(x2), Math.abs(x2 - x1));
    }

    void calculateIntegral() {
        double x = from;
        ArrayList<Thread> threads = new ArrayList<>();
        ArrayList<Trapeze> trapezes = new ArrayList<>();
        for (int i = 0; i < precision; i++) {
            trapezes.add(addTrapeze(x, x + step));
            threads.add(new Thread(trapezes.get(trapezes.size() - 1)));
            threads.get(threads.size() - 1).start();
            x += step;
        }
        for (int i = 0; i < precision; i++) {
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            increaseResult(trapezes.get(i).getResult());
        }
    }

    public void increaseResult(double on) {
        result += on;
    }

    public double getResult() {
        return result;
    }

    public void setFormula(String s) {
        formula = new ExpressionBuilder(s).variable("x").build();
    }
}
