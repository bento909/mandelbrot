package com.benco.mandelbrot.Maths;

public class Function {

    private static final int MAX_ITERATIONS = 75;

    public static boolean isInMandelbrotSet(ComplexNumber c) {
        ComplexNumber z = Operand.complexFromReal(0);
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            z = iterate(c, z);
            if (Operand.modulus(z) > 2) return false;
        }
        return true;
    }

    public static ComplexNumber checkIsInMandelbrotSet(ComplexNumber c) {
        ComplexNumber z = Operand.complexFromReal(0);
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            z = iterate(c, z);
            if (Operand.modulus(z) > 2) return false;
        }
        return ComplexNumber;
    }

    private static ComplexNumber iterate(ComplexNumber c, ComplexNumber z) {
        return(Operand.add(Operand.square(z), c));
    }

    @Deprecated
    public static int mandelbrotIter(ComplexNumber c, int boundary) {
        ComplexNumber z = Operand.complexFromReal(0);
        for (int i = 0; i < 100; i++) {
            z = iterate(c, z);
            if (Operand.modulus(z) > boundary) return i;
        }
        return 0;
    }
}
