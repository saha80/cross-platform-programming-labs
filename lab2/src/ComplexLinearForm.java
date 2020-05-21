
public class ComplexLinearForm extends Complex {
    private double real;
    private double imag;

    ComplexLinearForm(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    double real() {
        return real;
    }

    double imag() {
        return imag;
    }

    public void add(ComplexLinearForm r) {
        this.real += r.real;
        this.imag += r.imag;
    }

    public void sub(ComplexLinearForm r) {
        this.real -= r.real;
        this.imag -= r.imag;
    }
}
