package com.bento.mandelbrot.Maths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.bento.mandelbrot.Maths.Operand.divide;

class FunctionTest {

    @Test
    public void numberNotInMandelbrotSetOne() {
        //c=1
        Assertions.assertFalse(Function.isInMandelbrotSet(ComplexNumber.builder().r(1).i(0).build()));
    }

    @Test
    public void numberNotInMandelbrotSetTwo() {
        //c=2i
        Assertions.assertFalse(Function.isInMandelbrotSet(ComplexNumber.builder().r(0).i(2).build()));
    }

    @Test
    public void numberNotInMandelbrotSetThree() {
        //c=3
        Assertions.assertFalse(Function.isInMandelbrotSet(ComplexNumber.builder().r(3).i(0).build()));
    }

    @Test
    public void numberInMandelbrotSetOne() {
        //constant c = i
        Assertions.assertTrue(Function.isInMandelbrotSet(ComplexNumber.builder().r(0).i(1).build()));
    }

    @Test
    public void numberInMandelbrotSetTwo() {
        //constant c = (1+i)/4
        Assertions.assertTrue(Function.isInMandelbrotSet(Operand.divide(ComplexNumber.builder().r(1).i(1).build(), 4)));
    }

    @Test
    public void numberInMandelbrotSetThree() {
        //constant c = -1.5
        Assertions.assertTrue(Function.isInMandelbrotSet(Operand.divide(ComplexNumber.builder().r(-5).i(0).build(), 3)));
    }


    @Test
    public void countInterationsBeforeEscape_numberNotInMandelbrotSetOne() {
        //c=1
        Assertions.assertEquals(3, Function.mandelbrotIter(ComplexNumber.builder().r(1).i(0).build(), 10));
    }

    @Test
    public void countInterationsBeforeEscape_numberNotInMandelbrotSetTwo() {
        //c=2i
        Assertions.assertEquals(2, Function.mandelbrotIter(ComplexNumber.builder().r(0).i(2).build(), 10));
    }

    @Test
    public void countInterationsBeforeEscape_numberNotInMandelbrotSetThree() {
        //c=3
        Assertions.assertEquals(19, Function.mandelbrotIter(ComplexNumber.builder().r(-1.2).i(0.2).build(), 10));
    }

    @Test
    public void countInterationsBeforeEscape_numberInMandelbrotSetOne() {
        //constant c = i
        Assertions.assertEquals(0, (Function.mandelbrotIter(ComplexNumber.builder().r(0).i(1).build(), 10)));
    }

    @Test
    public void countInterationsBeforeEscape_numberInMandelbrotSetTwo() {
        //constant c = (1+i)/4
        Assertions.assertEquals(0, Function.mandelbrotIter(Operand.divide(ComplexNumber.builder().r(1).i(1).build(), 4), 10));
    }

    @Test
    public void countInterationsBeforeEscape_numberInMandelbrotSetThree() {
        //constant c = -1.5
        Assertions.assertEquals(0, Function.mandelbrotIter(Operand.divide(ComplexNumber.builder().r(-5).i(0).build(), 3), 10));
    }

}