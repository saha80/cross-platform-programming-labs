package number.complex.complexImpl;

import number.complex.Complex;

public class ComplexPolarForm extends Complex {
    private double r;
    private double phi;
    private final static double PI2 = Math.PI * 2;

    public ComplexPolarForm(double r, double phi) {
        if (r == 0) {
            this.phi = 0;
            return;
        }
        if (r < 0) {
            this.r = Math.abs(r);
        }
        this.r = r;
        if (phi < -Math.PI) {
            while (phi < -Math.PI) {
                phi += PI2;
            }
        }
        if (phi > Math.PI) {
            while (phi > Math.PI) {
                phi -= PI2;
            }
        }
        this.phi = phi;
    }

    public ComplexPolarForm(ComplexPolarForm c) {
        this.r = c.r;
        this.phi = c.phi;
    }

    double r() {
        return r;
    }

    double phi() {
        return phi;
    }

    private ComplexLinearForm toLinearForm() {
        double real = this.r * Math.cos(this.phi);
        double imag = this.r * Math.sin(this.phi);
        return new ComplexLinearForm(real, imag);
    }

    @Override
    public void add(Complex c) {
        final ComplexPolarForm temp = (ComplexPolarForm) c;
        ComplexLinearForm l = this.toLinearForm();
        ComplexLinearForm r = temp.toLinearForm();
        l.add(r);
        this.r = Math.hypot(l.real(), l.imag());
        this.phi = Math.atan2(l.real(), l.imag());
    }

    @Override
    public void sub(Complex c) {
        final ComplexPolarForm temp = (ComplexPolarForm) c;
        ComplexLinearForm l = this.toLinearForm();
        ComplexLinearForm r = temp.toLinearForm();
        l.sub(r);
        this.r = Math.hypot(l.real(), l.imag());
        this.phi = Math.atan2(l.real(), l.imag());
    }

    @Override
    public void mul(Complex c) {
        final ComplexPolarForm temp = (ComplexPolarForm) c;
        this.r *= temp.r;
        this.phi += temp.phi;
    }

    @Override
    public void div(Complex c) {
        final ComplexPolarForm temp = (ComplexPolarForm) c;
        this.r /= temp.r;
        this.phi -= temp.phi;
    }
}
