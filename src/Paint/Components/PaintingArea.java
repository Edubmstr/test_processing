package Paint.Components;

import processing.core.PApplet;

public class PaintingArea {
    PApplet pApplet;
    int r,g,b;
    
    public PaintingArea(PApplet pApplet){
        this.pApplet = pApplet;
    }

    public void render(){
        pApplet.strokeWeight(1);
        pApplet.stroke(255);
        pApplet.fill(255);
        pApplet.rect(0, 0 , 75, pApplet.height);
        pApplet.strokeWeight(2);
        pApplet.stroke(r,g,b);
        //paintingArea.render();
        if(pApplet.mousePressed){
            pApplet.line(pApplet.mouseX, pApplet.mouseY, pApplet.pmouseX, pApplet.pmouseY);
        }
    }

    public void setColor(int r, int g, int b){
        this.r = r;
        this.g = g;
        this.b = b;
    }

}
