package com.benco.mandelbrot.Graphics;

import com.benco.mandelbrot.Maths.ComplexNumber;
import com.benco.mandelbrot.Maths.SetProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class VisualPatternRenderer extends JFrame {
    public VisualPatternRenderer() {
        setTitle("Visual Pattern Renderer");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to draw the pattern
        PatternPanel patternPanel = new PatternPanel();
        getContentPane().add(patternPanel);

        // Add a button to change the pattern
        JButton changePatternButton = new JButton("Change Pattern");
        changePatternButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                patternPanel.changePattern();
            }
        });
        getContentPane().add(changePatternButton, BorderLayout.SOUTH);
    }
}

class PatternPanel extends JPanel {
    private int patternType = 0;
    public void changePattern() {
        // Change the pattern type when the button is clicked
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the pattern based on the current pattern type
        switch (patternType) {
            case 0:
                drawPattern2(g);
                break;
        }
    }

    private void drawPattern1(Graphics g) {
        // Implement your first pattern drawing logic here
        // Example: Draw a simple pattern of circles
        g.setColor(Color.RED);
        for (int i = 0; i < 10; i++) {
            int x = (int) (Math.random() * getWidth());
            int y = (int) (Math.random() * getHeight());
            int radius = (int) (Math.random() * 50);
            g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
        }
    }

    private void drawPattern2(Graphics g) {
        final Set<ComplexNumber> mandelBrotSet = SetProvider.getMandelBrotSet(400, 400);
        g.setColor(Color.black);
        for (ComplexNumber z : mandelBrotSet) {
            Double real = z.getR();
            Double imaginary = z.getI();
            int xCoord = (int) (400 * real) + 700;
            int yCoord = (int) (400 * imaginary) + 400;
            g.drawLine(xCoord, yCoord, xCoord , yCoord);
        }
    }

    private static void extracted(Set<ComplexNumber> mandelBrotSet) {
        ComplexNumber a = ComplexNumber.builder()
                .r(1).i(0)
                .build();
        ComplexNumber b = ComplexNumber.builder()
                .r(0).i(-1)
                .build();
        ComplexNumber c = ComplexNumber.builder()
                .r(1).i(0)
                .build();
        ComplexNumber d = ComplexNumber.builder()
                .r(0).i(1).
                build();
        final Set<ComplexNumber> transformedSet = SetProvider.mobiusTransform(mandelBrotSet, a, b, c, d);
    }
}