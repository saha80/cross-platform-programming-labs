package number.complex.complexImpl;

import number.complex.Complex;

public class ComplexLinearForm extends Complex {
    private double real;
    private double imag;

    public ComplexLinearForm(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double real() {
        return real;
    }

    public double imag() {
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
