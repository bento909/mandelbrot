package com.benco.mandelbrot.Maths;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class SetProvider {

    public static Set<ComplexNumber> getMandelBrotSet(int noOfPixelsInXAxis, int noOfPixelsInYAxis, double smallestReal, double largestReal, double smallestIm, double largestIm) {
        Set<ComplexNumber> mandelbrotSet = new HashSet<>();
        List<Double> xCoords = getXCoords(noOfPixelsInXAxis, smallestReal, largestReal);
        List<Double> yCoords = getYCoords(noOfPixelsInYAxis, smallestIm, largestIm);
        int i = 0;
        for (Double x : xCoords) {
            for (Double y : yCoords) {
                ComplexNumber c = ComplexNumber.builder().r(x).i(y).build();
                if (Function.isInMandelbrotSet(c)) {
                    mandelbrotSet.add(c);
                }
                i++;
            }

        }
        log.info(String.format("We checked %s complex numbers to see if they are in the Mandelbrot set.", i));
        return mandelbrotSet;
    }

    // ignore this
    public static Set<ComplexNumber> mobiusTransform(Set<ComplexNumber> complexNumbers, ComplexNumber a, ComplexNumber b, ComplexNumber c, ComplexNumber d) {
        Set<ComplexNumber> transformedSet = new HashSet<>();
        for (ComplexNumber z : complexNumbers) {
            ComplexNumber top = Operand.add(Operand.times(z, a), b);
            ComplexNumber bottom = Operand.add(Operand.times(z, c), d);
            transformedSet.add(Operand.divide(top, bottom));
        }
        return transformedSet;
    }


    public static List<Double> getXCoords(int widthPixels, double smallestReal, double largestReal) {
        List<Double> xCoords = new ArrayList<>();
        double xIncrement = getXIncrement(widthPixels);
        for (double i = smallestReal; i <= largestReal; i = i + xIncrement) {
            xCoords.add(i);
        }
        return xCoords;
    }

    public static List<Double> getYCoords(int heightPixels, double smallestIm, double largestIm) {
        List<Double> yCoords = new ArrayList<>();
        double yIncrement = getYIncrement(heightPixels);
        for (double i = smallestIm; i <= largestIm; i = i + yIncrement) {
            yCoords.add(i);
        }
        return yCoords;
    }

    public static double getXIncrement(int widthPixels, double smallestReal, double largestReal) {
        int numberOfGaps = widthPixels - 1;
        return (largestReal - smallestReal) / numberOfGaps;
    }

    public static double getYIncrement(int heightPixels, double smallestIm, double largestIm) {
        int numberOfGaps = heightPixels - 1;
        return (largestIm - smallestIm) / numberOfGaps;
    }

    public static Set<ComplexNumber> getNotMandelBrotSet(int noOfPixelsInXAxis, int noOfPixelsInYAxis) {

        return null;
    }
}
