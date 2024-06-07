package com.benco.mandelbrot.Maths;

import org.junit.jupiter.api.Test;

import static com.benco.mandelbrot.Maths.ComplexNumber.builder;
import static com.benco.mandelbrot.Maths.Function.isInMandelbrotSet;
import static com.benco.mandelbrot.Maths.Function.mandelbrotIter;
import static com.benco.mandelbrot.Maths.Operand.divide;
import static org.junit.jupiter.api.Assertions.*;

class FunctionTest {

    @Test
    public void numberNotInMandelbrotSetOne() {
        //c=1
        assertFalse(isInMandelbrotSet(builder().r(1).i(0).build()));
    }

    @Test
    public void numberNotInMandelbrotSetTwo() {
        //c=2i
        assertFalse(isInMandelbrotSet(builder().r(0).i(2).build()));
    }

    @Test
    public void numberNotInMandelbrotSetThree() {
        //c=3
        assertFalse(isInMandelbrotSet(builder().r(3).i(0).build()));
    }

    @Test
    public void numberInMandelbrotSetOne() {
        //constant c = i
        assertTrue(isInMandelbrotSet(builder().r(0).i(1).build()));
    }

    @Test
    public void numberInMandelbrotSetTwo() {
        //constant c = (1+i)/4
        assertTrue(isInMandelbrotSet(divide(builder().r(1).i(1).build(), 4)));
    }

    @Test
    public void numberInMandelbrotSetThree() {
        //constant c = -1.5
        assertTrue(isInMandelbrotSet(divide(builder().r(-5).i(0).build(), 3)));
    }


    @Test
    public void countInterationsBeforeEscape_numberNotInMandelbrotSetOne() {
        //c=1
        assertEquals(3, mandelbrotIter(builder().r(1).i(0).build(), 10));
    }

    @Test
    public void countInterationsBeforeEscape_numberNotInMandelbrotSetTwo() {
        //c=2i
        assertEquals(2, mandelbrotIter(builder().r(0).i(2).build(), 10));
    }

    @Test
    public void countInterationsBeforeEscape_numberNotInMandelbrotSetThree() {
        //c=3
        assertEquals(19, mandelbrotIter(builder().r(-1.2).i(0.2).build(), 10));
    }

    @Test
    public void countInterationsBeforeEscape_numberInMandelbrotSetOne() {
        //constant c = i
        assertEquals(0, (mandelbrotIter(builder().r(0).i(1).build(), 10)));
    }

    @Test
    public void countInterationsBeforeEscape_numberInMandelbrotSetTwo() {
        //constant c = (1+i)/4
        assertEquals(0, mandelbrotIter(divide(builder().r(1).i(1).build(), 4), 10));
    }

    @Test
    public void countInterationsBeforeEscape_numberInMandelbrotSetThree() {
        //constant c = -1.5
        assertEquals(0, mandelbrotIter(divide(builder().r(-5).i(0).build(), 3), 10));
    }

}