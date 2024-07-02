package com.bento.mandelbrot.controller;

import com.bento.mandelbrot.Maths.ComplexNumber;
import com.bento.mandelbrot.Maths.SetProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/v1")
@Slf4j
public class ComplexNumbersController {

    @GetMapping("/getMandelbrotSet")
    public ResponseEntity<Set<ComplexNumber>> getMandelbrotSet(
            @RequestParam int noOfPixelsInXAxis,
            @RequestParam int noOfPixelsInYAxis,
            @RequestParam float smallestReal,
            @RequestParam float largestReal,
            @RequestParam float smallestIm,
            @RequestParam float largestIm
    ) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("Get Mandelbrot Set");
        log.info(String.format("Have received a request to get the Mandelbrot set! Number of Pixels in X axis: %s Number of Pixels in Y axis: %s\nSmallest Real: %s, Largest Real: %s, Smallest Imaginary: %s, Largest Imaginary: %s", noOfPixelsInXAxis, noOfPixelsInYAxis, largestReal, largestIm, smallestReal, smallestIm));
        final Set<ComplexNumber> mandelBrotSet = new SetProvider().getMandelBrotSet(noOfPixelsInXAxis, noOfPixelsInYAxis, smallestReal, largestReal, smallestIm, largestIm);
        stopWatch.stop();
        log.info(String.format("Have calculated %s complex numbers z which are in the Mandelbrot set! %s", mandelBrotSet.size(), stopWatch.prettyPrint()));
        return new ResponseEntity<>(mandelBrotSet, HttpStatus.OK);
    }
//
//    @GetMapping("/getOutsideMandelbrotSet")
//    public ResponseEntity<Set<ComplexNumber>> getOutsideMandelBrotSet(@RequestBody final ComplexPlaneRequest request) {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start("Get Mandelbrot Set");
//        log.info("Have received a request to get the Mandelbrot set! " + request);
//        final Set<ComplexNumber> mandelBrotSet = SetProvider.getNotMandelBrotSet(request.getNoOfPixelsInXAxis(), request.getNoOfPixelsInYAxis());
//        stopWatch.stop();
//        log.info(String.format("Have calculated %s complex numbers z which are in the Mandelbrot set! %s", mandelBrotSet.size(), stopWatch.prettyPrint()));
//        return new ResponseEntity<>(mandelBrotSet, HttpStatus.OK);    }

}
