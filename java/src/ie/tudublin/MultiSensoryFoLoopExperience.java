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

        switch (mode) {
            case 0:
                drawDiagonalSquares();
                break;
            case 1:
                drawRandomEllipses();
                break;
            default:
                drawRandomBackground();
                break;
        }
    }

    public void keyPressed() {
        if (key >= '0' && key <= '9') {
            mode = key - '0';
        }
    }

    // Draw diagonal squares
    private void drawDiagonalSquares() {
        int cols = 10;
        float squareSize = width / (float) cols;

        for (int i = 0; i < cols; i++) {
            float hue = map(i, 0, cols - 1, 0, 255);
            float xPos = i * squareSize;
            float yPos = map(i, 0, cols - 1, 0, height);

            fill(hue, 255, 255);
            rect(xPos, yPos, squareSize, squareSize);

        }

        for(int i = 0; i < cols; i++){
            float hue = map(i, 0, cols - 1, 0, 255);
            float xPos = width - i * squareSize;
            float yPos = map(i, 0, cols - 1, 0, height);

            fill(hue, 255, 255);
            rect(xPos, yPos, squareSize, squareSize);
        }

        float middleSquareSize = squareSize * 2;
        float middleSquareX = (width - middleSquareSize)/2;
        float middleSquareY = (height - middleSquareSize)/2;

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                float hue = map(i * 2 + j, 0, 3, 0, 255);
                fill(hue, 255, 255);
                rect(middleSquareX + j * squareSize, middleSquareY + i * squareSize, squareSize, squareSize);
            }
        }

    }

    // Draw random ellipses
    private void drawRandomEllipses() {
        for (int i = 0; i < 10; i++) {
            float hue = random(255);
            fill(hue, 255, 255);
            ellipse(random(width), random(height), 50, 50);
        }
    }

    // Draw random background
    private void drawRandomBackground() {
        background(random(255), random(255), random(255));
    }

    public static void main(String[] args) {
        PApplet.main("MultiSensoryFoLoopExperience");
    }
}
