package com.benco.mandelbrot.Maths;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class OperandTest {

    @Test
    public void testMultiplyRealOne() {
        //(3 + 2i) 5 = 15 + 10i
        final ComplexNumber z1 = ComplexNumber.builder()
                .r(3)
                .i(2)
                .build();
        final double realNumber = 5;
        final ComplexNumber expected = ComplexNumber.builder().r(15).i(10).build();
        assertThat(Operand.times(z1, realNumber), is(expected));
        assertThat(Operand.times(realNumber, z1), is(expected));
    }

    @Test
    public void testMultiply() {
        //(3 + 2i) (1 + 4i) = 3 + 12i + 2i + 8i 2 = 3 + 14i – 8 = -5 + 14i.
        final ComplexNumber z1 = ComplexNumber.builder()
                .r(3)
                .i(2)
                .build();
        final ComplexNumber z2 = ComplexNumber.builder()
                .r(1)
                .i(4)
                .build();
        final ComplexNumber expected = ComplexNumber.builder().r(-5).i(14).build();
        assertThat(Operand.times(z1,z2), is(expected));
    }

    @Test
    public void testMultiplyTwo() {
        //(3 + 2i) (1 + 7i) = 3 *1 + 3* 7i + 2i *1 + 2i * 7i = 11 + 23i.
        final ComplexNumber z1 = ComplexNumber.builder()
                .r(3)
                .i(2)
                .build();
        final ComplexNumber z2 = ComplexNumber.builder()
                .r(1)
                .i(7)
                .build();
        final ComplexNumber expected = ComplexNumber.builder().r(-11).i(23).build();
        assertThat(Operand.times(z1,z2), is(expected));
    }

    @Test
    public void testSquare() {
        //(-4 + 6i) (-4 + 6i) = 16 - 24i - 24i - 36i 2 = 16 - 48i + 36 = 52 - 48i.
        final ComplexNumber z1 = ComplexNumber.builder()
                .r(-4)
                .i(6)
                .build();
        final ComplexNumber expected = ComplexNumber.builder().r(-20).i(-48).build();
        assertThat(Operand.times(z1,z1), is(expected));
        assertThat(Operand.square(z1), is(expected));
    }

    @Test
    public void testAddition() {
        //(3 + 2i) + (1 - 5i) = 4-31
        final ComplexNumber z1 = ComplexNumber.builder()
                .r(3)
                .i(2)
                .build();
        final ComplexNumber z2 = ComplexNumber.builder()
                .r(1)
                .i(-5)
                .build();
        final ComplexNumber expected = ComplexNumber.builder().r(4).i(-3).build();
        assertThat(Operand.add(z1, z2), is(expected));
    }

    @Test
    public void testAdd() {
        //(3 + 2i) + 2 = 5+2i
        final ComplexNumber z1 = ComplexNumber.builder()
                .r(3)
                .i(2)
                .build();
        final ComplexNumber expected = ComplexNumber.builder().r(5).i(2).build();
        assertThat(Operand.add(z1, 2), is(expected));
    }

    @Test
    public void testSubtraction() {
        //(2+4i)−(5−3i)=−3+7i.
        final ComplexNumber z1 = ComplexNumber.builder()
                .r(2)
                .i(4)
                .build();
        final ComplexNumber z2 = ComplexNumber.builder()
                .r(5)
                .i(-3)
                .build();
        final ComplexNumber expected = ComplexNumber.builder().r(-3).i(7).build();
        assertThat(Operand.subtract(z1, z2), is(expected));
    }

    @Test
    public void testConjugate() {
        //conjugate of x + iy = x-iy (z bar)
        final ComplexNumber z1 = ComplexNumber.builder()
                .r(2)
                .i(4)
                .build();
        final ComplexNumber expected = ComplexNumber.builder().r(2).i(-4).build();
        assertThat(Operand.conjugate(z1), is(expected));
    }

    @Test
    public void testModulus() {
        // |3+4i| = 5
        final ComplexNumber z1 = ComplexNumber.builder().
                r(3).i(4)
                        .build();
        assertThat(Operand.modulus(z1), is(5.0));
    }

    @Test
    public void testReciprocal() {
        // 1/(2-3i) = (2+3i)/13
        final ComplexNumber z1 = ComplexNumber.builder()
                .r(2)
                .i(-3)
                .build();
        final ComplexNumber expected = ComplexNumber.builder().r((double) 2 /13).i((double) 3 /13).build();
        assertThat(Operand.reciprocal(z1), is(expected));
    }

    @Test
    public void testDivision() {
        //(3+2i)/(1-i) = (0.5+2.5i)
        final ComplexNumber z1 = ComplexNumber.builder()
                .r(3)
                .i(2)
                .build();
        final ComplexNumber z2 = ComplexNumber.builder()
                .r(1)
                .i(-1)
                .build();
        final ComplexNumber expected = ComplexNumber.builder().r((double) 1/2).i((double) 5/2).build();
        ComplexNumber actual = Operand.divide(z1, z2);
        assertThat(actual, is(expected));
    }


    @Test
    public void testDivisionTwo() {
        //(2+4i) / (5-3i) = (-1+13)/17
        //(-1+13)/17 = (-1/17+13/17)
        final ComplexNumber z1 = ComplexNumber.builder()
                .r(2)
                .i(4)
                .build();
        final ComplexNumber z2 = ComplexNumber.builder()
                .r(5)
                .i(-3)
                .build();
        final ComplexNumber expectedNumerator = ComplexNumber.builder().r(-1).i(13).build();
        final double expectedDenominator = 17;
        final ComplexNumber expected = ComplexNumber.builder().r((double) -1 / expectedDenominator).i((double) 13 / expectedDenominator).build();
        assertThat(Operand.divide(z1, z2), is(expected));
        assertThat(Operand.divide(expectedNumerator, expectedDenominator), is(expected));
    }

    @Test
    public void testDivisionThree() {
        //(6-2i)/(2) = (3-i)
        final ComplexNumber z1 = ComplexNumber.builder()
                .r(6)
                .i(-2)
                .build();
        final ComplexNumber expected = ComplexNumber.builder().r(3).i(-1).build();
        final double denominator = 2;
        assertThat(Operand.divide(z1, denominator), is(expected));
    }

    @Test
    public void testDivisionFour() {
        //(2)/(1+i) = (1-i)
        final double numerator = 2;
        final ComplexNumber z1 = ComplexNumber.builder()
                .r(1)
                .i(1)
                .build();
        final ComplexNumber expected = ComplexNumber.builder().r(1).i(-1).build();
        assertThat(Operand.divide(numerator, z1), is(expected));
    }
}