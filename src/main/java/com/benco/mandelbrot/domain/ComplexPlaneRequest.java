package com.benco.mandelbrot.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ComplexPlaneRequest {

    int noOfPixelsInXAxis;
    int noOfPixelsInYAxis;
}
