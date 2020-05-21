
public class Trapeze implements Runnable {
    private final double begin, end, height;
    private double result;

    Trapeze(double begin, double end, double height) {
        this.begin = begin;
        this.end = end;
        this.height = height;
    }

    public void calculateArea() {
        result = (begin + end) / 2 * height;
    }

    public double getResult() {
        return result;
    }

    @Override
    public void run() {
        calculateArea();
    }
}
