package ie.tudublin;

import ddf.minim.AudioOutput;
import ddf.minim.Minim;
import processing.core.PApplet;

public class MultiSensoryFoLoopExperience extends PApplet {

    int mode = 0;

    Minim minim;
    AudioOutput out;

    public void settings()
    {
        size(800, 800);
    }

    public void setup()
    {
        colorMode(HSB, 360, 100, 100);
       
    }

    public void draw()
    {
        background(0);
        stroke(255);
        switch(mode)
        {
            case 0:

                int cols = 10;
                noStroke();
                float w = width/(float) cols;
                float cgap = 255/(float) cols;
                for(int i = 0; i < cols;i++){
                    float x = i * w;
                    float c = i * cgap;
                    fill(cgap * i, 255, 255);
                    rect(x, 0, w, height);
                }
                //line(0, 0, width, height);
                // Code goes here
                break;
            case 1:
                for (int i = 0 ; i < 10 ; i ++)
                {
                    // Code goes here
                    float hue = map(i, 0, 10, 0, 255);
                    fill(hue, 255, 255);
                    ellipse(random(width), random(height), 50, 50);
                }
                //out.playNoise();
                break;
            default:
                // Code goes here
                background(random(255), random(255), random(255));
                out.close();
                break;
        }
    }

    public void keyPressed()
    {
        
        if (key >= '0' && key <= '9')
        {
            mode = key - '0';
        }
    }
    
}
