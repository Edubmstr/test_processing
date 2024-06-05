package Paint;

import Paint.Components.ColorButton;
import Paint.Components.PaintingArea;
import processing.core.PApplet;

public class Paint extends PApplet{
    private PaintingArea paintingArea;
    private ColorButton red, blue, green;
    public static void main(String[] args){
        PApplet.main(Paint.class);
    }

    public void settings(){
        size(800, 800);
    }

    public void setup(){
        paintingArea = new PaintingArea(this);
        red = new ColorButton(30,20,20,20,"test", this, 255,0,0);
        blue = new ColorButton(30,50,20,20,"test", this, 0,255,0);
        green = new ColorButton(30,80,20,20,"test", this, 0,0,255);
       
    }

    public void draw(){
        paintingArea.render();
        red.render();
        red.onClick(() -> paintingArea.setColor(255, 0, 0));
        blue.render();
        blue.onClick(() -> paintingArea.setColor(0, 255, 0));
        green.render();
        green.onClick(() -> paintingArea.setColor(0, 0, 255));
    }

}
