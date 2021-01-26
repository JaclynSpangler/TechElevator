package com.techelevator;

import processing.core.PApplet;

public class MySketch extends PApplet {

    @Override
    public void settings() {
        size(640, 480);
    }

    @Override
    public void setup() {
        background(255 );
    }

    @Override
    public void draw() {
        float centerX = width / 2.0f;
        float centerY = height / 2.0f;

        circle(centerX, centerY, 200);
        ellipse(centerX - 30, centerY - 40, 20, 40);
        ellipse(centerX + 30, centerY - 40, 20, 40);
        curve(centerX - 70, centerY - 130, centerX-50, centerY + 30, centerX+50, centerY+30, centerX + 70, centerY - 130);

    }
    }


