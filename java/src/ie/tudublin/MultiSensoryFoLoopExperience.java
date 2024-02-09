package ie.tudublin;

import ddf.minim.AudioOutput;
import ddf.minim.Minim;
import processing.core.PApplet;

public class MultiSensoryFoLoopExperience extends PApplet {
    
    int mode = 0;

    Minim minim;
    AudioOutput out;

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        colorMode(HSB, 255); // Adjusted color mode to match Processing's default

        minim = new Minim(this);
        out = minim.getLineOut();
    }

    public void draw() {
        background(255);

        int numCircles = 10;
        float circleSize = width / (float)numCircles;

        for(int i = 0; i < numCircles; i++){
            for(int j = 0; j < numCircles; j++){
                float hue = map(i + j, 0, numCircles * 2 - 2, 0, 180);

                fill(hue, 255, 255);
                noStroke();

                float xPos = j * circleSize + circleSize/2;
                float yPos = i * circleSize + circleSize/2;

                ellipse(xPos, yPos, circleSize, circleSize);
            }
        }

    }

    public void keyPressed() {
        if (key >= '0' && key <= '9') {
            mode = key - '0';
        }
    }

    public static void main(String[] args) {
        PApplet.main("MultiSensoryFoLoopExperience");
    }
}
