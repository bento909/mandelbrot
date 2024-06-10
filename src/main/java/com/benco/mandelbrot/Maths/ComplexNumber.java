package com.benco.mandelbrot.Maths;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder(toBuilder = true)
@ToString
@EqualsAndHashCode
public class ComplexNumber {

    private double r;
    private double i;
    private int x;
    private int y;
    private int noOfIterations;
    private boolean isInMandelbrotSet;

}
