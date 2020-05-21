
public class ComplexLinearForm extends Complex {
    private double real;
    private double imag;

    ComplexLinearForm(double real, double img) {
        this.real = real;
        this.imag = img;
    }

    double real() {
        return real;
    }

    double img() {
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
