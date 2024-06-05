package Paint.Components;

import processing.core.PApplet;

public class ColorButton {
    float x,y;
    float w,h;
    boolean mousePressed;
    PApplet pApplet;
    int r, g, b;

    public ColorButton(float x, float y, float w, float h,String text, PApplet pApplet, int r, int g, int b){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.pApplet = pApplet;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void render(){
        pApplet.stroke(r,g,b);
        pApplet.strokeWeight(1);
        pApplet.fill(r,g,b);
        pApplet.rect(x, y, w, h);
    }

    private boolean mouseClick(){
        if(isPosInRect(pApplet.mouseX, pApplet.mouseY)){
            if(pApplet.mousePressed){
                this.mousePressed = true;
            }
            if(!(pApplet.mousePressed) && this.mousePressed){
                this.mousePressed = false;
                return true;
            }
        }
        return false;
    }

    public void onClick(Runnable function){
        if(isPosInRect(pApplet.mouseX, pApplet.mouseY) && mouseClick()){
            function.run();
        }
    }

    public boolean isPosInRect(int mouseX, int mouseY) {
		boolean isInWidth = mouseX >= x && mouseX <= x+w;
		boolean isInHeight = mouseY >= y && mouseY <= y+h;
		return isInWidth && isInHeight;
	} 

}
