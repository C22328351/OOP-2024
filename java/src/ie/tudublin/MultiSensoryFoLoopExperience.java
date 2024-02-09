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
        background(0);

        int numCircles = 10;
        float centreX = width/2.0f;
        float centreY = height/2.0f;

        for(int i = 0; i < numCircles; i++){
            float radius = map(i, 0, numCircles -1, width/3.0f, 0);
            float hue = map(i, 0, numCircles - 1, 200, 10);

            fill(hue, 255, 255);
            noStroke();

            ellipse(centreX, centreY, radius * 2, radius * 2);
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
