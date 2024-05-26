package StockGraph.Components;

import processing.core.PApplet;

public class TextLabel {
    float x,y, w,h;
    PApplet pApplet;
    String text;
    float state;
    boolean hasState = false;
    int r,g,b;

    public TextLabel(float x, float y, float w, float h, String text, int r, int g, int b, PApplet pApplet){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.text = text;
        this.r = r;
        this.g = g;
        this.b = b;
        this.pApplet = pApplet;
    }

    public void addState(float state) {
        this.state = state;
        this.hasState = true;
    }

    public void removeState(){
        if(this.hasState){
            this.state = 0.0f;
            this.hasState = false;
        }
    }

    public void render(){
        pApplet.strokeWeight(1);
        //pApplet.stroke(0);
        pApplet.textSize(32);
        //pApplet.fill(200);
	    pApplet.fill(r,g,b);
        if(this.hasState){
            pApplet.text(this.text + String.valueOf(state), this.x, this.y, this.w, this.h);
        }else{
            pApplet.text(this.text, this.x, this.y, this.w, this.h);
        }
    }
}
