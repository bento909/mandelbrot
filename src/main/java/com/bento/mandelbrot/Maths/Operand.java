package com.bento.mandelbrot.Maths;

public class Operand {

    static ComplexNumber times(final double realNumber, final ComplexNumber z1) {
        return times(z1, realNumber);
    }

    static ComplexNumber times(final ComplexNumber z1, final double realNumber) {
        return times(z1, complexFromReal(realNumber));
    }

    static ComplexNumber times(final ComplexNumber z1, final ComplexNumber z2) {
        //real component;
        double a = z1.getR() * z2.getR();
        double b = (z1.getI() * z2.getI()) * -1;
        //imaginary component;
        double c = (z1.getR() * z2.getI());
        double d = (z1.getI() * z2.getR());
        return ComplexNumber.builder()
                .r(a+b)
                .i(c+d)
                .build();
    }

    public static ComplexNumber square(final ComplexNumber z1){
        return times(z1, z1);
    }

    public static ComplexNumber add(ComplexNumber z1, ComplexNumber z2) {
        double r = z1.getR() + z2.getR();
        double i = z1.getI() + z2.getI();
        return ComplexNumber.builder().r(r).i(i).build();
    }

    public static ComplexNumber add(ComplexNumber z1, double x) {
        return add(x, z1);
    }

    public static ComplexNumber add(double x, ComplexNumber z1) {
        return add(complexFromReal(x), z1);
    }


    public static ComplexNumber subtract(ComplexNumber z1, ComplexNumber toBeSubtracted) {
        ComplexNumber z2 = ComplexNumber.builder()
                .r(toBeSubtracted.getR() * -1)
                .i(toBeSubtracted.getI() * -1)
                .build();
        return add(z1, z2);
    }

    public static ComplexNumber divide(ComplexNumber numerator, ComplexNumber denominator) {
        // w/z = (w *zbar / |z|sqrd) numerator = w, denominator = z
        ComplexNumber top = times(numerator, conjugate(denominator));
        int bottom = (int) (modulus(denominator) * modulus(denominator));
        return ComplexNumber.builder()
                .r(top.getR()/bottom)
                .i(top.getI()/bottom)
                .build();
    }

    public static ComplexNumber divide(ComplexNumber numerator, double denominator) {
        return divide(numerator, complexFromReal(denominator));
    }

    public static ComplexNumber divide(double numerator, ComplexNumber denominator) {
        ComplexNumber complexNumerator = complexFromReal(numerator);
        return divide(complexNumerator, denominator);
    }

    public static ComplexNumber complexFromReal(double realNumber) {
        return ComplexNumber.builder().r(realNumber).i(0).build();
    }

    //z1 bar
    public static ComplexNumber conjugate(ComplexNumber z1) {
        return z1.toBuilder().i(z1.getI() * -1).build();
    }

    //|z1|
    public static double modulus(ComplexNumber z1) {
        final double a2 = z1.getR() * z1.getR();
        final double b2 = z1.getI() * z1.getI();
        return Math.sqrt((a2 + b2));
    }

    public static ComplexNumber reciprocal(ComplexNumber z1) {
        final double a = z1.getR();
        final double b = z1.getI();
        final double denominator = (a * a) + (b * b);
        return ComplexNumber.builder().r(a/denominator).i(-b/denominator).build();

    }
}
