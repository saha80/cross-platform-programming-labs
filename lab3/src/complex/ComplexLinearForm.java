package complex;

public class ComplexLinearForm extends Complex {
    private double real;
    private double imag;

    public ComplexLinearForm(double real, double img) {
        this.real = real;
        this.imag = img;
    }

    public ComplexLinearForm(ComplexLinearForm c) {
        this.real = c.real;
        this.imag = c.imag;
    }

    private ComplexPolarForm toPolarFrom() {
        double r = Math.hypot(this.real, this.imag);
        double phi = Math.atan2(this.real, this.imag);
        return new ComplexPolarForm(r, phi);
    }

    public double real() {
        return real;
    }

    public double imag() {
        return imag;
    }

    @Override
    public void add(Complex c) {
        final ComplexLinearForm temp = (ComplexLinearForm) c;
        this.real += temp.real;
        this.imag += temp.imag;
    }

    @Override
    public void sub(Complex c) {
        final ComplexLinearForm temp = (ComplexLinearForm) c;
        this.real -= temp.real;
        this.imag -= temp.imag;
    }

    @Override
    public void mul(Complex c) {
        final ComplexLinearForm temp = (ComplexLinearForm) c;
        ComplexPolarForm l = this.toPolarFrom();
        ComplexPolarForm r = temp.toPolarFrom();
        l.mul(r);
        this.real = l.r() * Math.cos(l.phi());
        this.imag = l.r() * Math.sin(l.phi());
    }

    @Override
    public void div(Complex c) {
        final ComplexLinearForm temp = (ComplexLinearForm) c;
        ComplexPolarForm l = this.toPolarFrom();
        ComplexPolarForm r = temp.toPolarFrom();
        l.div(r);
        this.real = l.r() * Math.cos(l.phi());
        this.imag = l.r() * Math.sin(l.phi());
    }
}
