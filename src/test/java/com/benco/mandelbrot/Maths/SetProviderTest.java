package com.benco.mandelbrot.Maths;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class SetProviderTest {

    private static final double SMALLEST_REAL = -2;
    private static final double LARGEST_REAL = 0.5;
    private static final double SMALLEST_IMAGINARY = -1.5;
    private static final double LARGEST_IMAGINARY = 1.5;

    @Test
    public void getSetOfPixels() {
        int width = 13;
        int height = 8;
        Set<ComplexNumber> mandelBrotSet = SetProvider.getMandelBrotSet(width, height, SMALLEST_REAL, LARGEST_REAL, SMALLEST_IMAGINARY, LARGEST_IMAGINARY);
        assertThat(mandelBrotSet.size(), is(14));
    }

    @Test
    public void testGetXCoords() {
        List<Double> xCoords = SetProvider.getXCoords(11, SMALLEST_REAL, LARGEST_REAL);
        assertThat(xCoords, is(Arrays.asList(-2.0, -1.75, -1.5, -1.25, -1.0, -0.75, -0.5, -0.25, 0.0, 0.25, 0.5)));
    }

    @Test
    public void testGetXIncrement() {
        double actual = SetProvider.getXIncrement(11, SMALLEST_REAL, LARGEST_REAL);
        assertThat(actual, is(0.25));
    }

    @Test
    public void testGetYCoords() {
        List<Double> yCoords = SetProvider.getYCoords(13, SMALLEST_IMAGINARY, LARGEST_IMAGINARY);
        assertThat(yCoords, is(Arrays.asList(-1.5, -1.25, -1.0, -0.75, -0.5, -0.25, 0.0, 0.25, 0.5, 0.75, 1.0, 1.25, 1.5)));
    }

    @Test
    public void testGetYIncrement() {
        double actual = SetProvider.getYIncrement(13, SMALLEST_IMAGINARY, LARGEST_IMAGINARY);
        assertThat(actual, is(0.25));
    }
}