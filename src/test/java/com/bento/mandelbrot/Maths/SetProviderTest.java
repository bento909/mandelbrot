package com.bento.mandelbrot.Maths;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static com.bento.mandelbrot.Maths.ComplexNumber.builder;
import static com.bento.mandelbrot.Maths.Operand.r;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(OutputCaptureExtension.class)
class SetProviderTest {

    private static final float SMALLEST_REAL = -2F;
    private static final float LARGEST_REAL = 0.5F;
    private static final float SMALLEST_IMAGINARY = -1.5F;
    private static final float LARGEST_IMAGINARY = 1.5F;

    @Test
    public void getSetOfPixels() {
        int width = 13;
        int height = 8;
        Set<ComplexNumber> mandelBrotSet = new SetProvider().getMandelBrotSet(width, height, SMALLEST_REAL, LARGEST_REAL, SMALLEST_IMAGINARY, LARGEST_IMAGINARY);
        assertThat(mandelBrotSet.size(), is(126));
    }

    @Test
    public void testGetXCoords() {
        List<Double> xCoords = SetProvider.getXCoords(10, SMALLEST_REAL, LARGEST_REAL);
        assertThat(xCoords, is(Arrays.asList(-2.0, -1.75, -1.5, -1.25, -1.0, -0.75, -0.5, -0.25, 0.0, 0.25, 0.5)));
    }

    @Test
    public void testGetXIncrement() {
        double actual = SetProvider.getXIncrement(10, SMALLEST_REAL, LARGEST_REAL);
        assertThat(actual, is(0.25));
    }

    @Test
    public void testGetYCoords() {
        List<Double> yCoords = SetProvider.getYCoords(12, SMALLEST_IMAGINARY, LARGEST_IMAGINARY);
        assertThat(yCoords, is(Arrays.asList(-1.5, -1.25, -1.0, -0.75, -0.5, -0.25, 0.0, 0.25, 0.5, 0.75, 1.0, 1.25, 1.5)));
    }

    @Test
    public void testGetYIncrement() {
        double actual = SetProvider.getYIncrement(12, SMALLEST_IMAGINARY, LARGEST_IMAGINARY);
        assertThat(actual, is(0.25));
    }
//
//    @Test
//    public void testMobiusTransform(CapturedOutput output) {
//        final Set<ComplexNumber> input = Set.of(
//                r(0),
//                r(1),
//                r((double) -5/4));
//        final Set<ComplexNumber> complexNumbers = SetProvider.mobiusTransform(
//                input,
//                r(2),
//                r(3),
//                r(4),
//                r(5)
//        );
//        assertTrue(complexNumbers.size() == 2);
//        final String out = output.getOut();
//        assertThat(out, containsString("we cannot divide by zero! z = ComplexNumber(r=-1.25, i=0.0, x=0, y=0, noOfIterations=0, isInMandelbrotSet=false)"));
//    }
}