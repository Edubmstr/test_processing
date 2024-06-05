package StockGraph.Components;

import processing.core.PApplet;
import processing.core.PImage;

public class Button {
    float x,y;
    float w,h;
    boolean mousePressed;
    String text;
    PApplet pApplet;
    PImage image;
    int error = 0;
    boolean imageLoaded = false;

    public Button(float x, float y, float w, float h,String text, PApplet pApplet){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.text = text;
        this.pApplet = pApplet;
    }

    public void loadImage(String path){
        try {
            image = pApplet.loadImage(path);
            pApplet.image(image, x + (w/5.5f), y + (h/5.5f));
            imageLoaded = true;
        } catch (Exception e) { 
            while(error < 2){
                System.out.println("Path of image not found. Try to edit the filepath to match your file system and pass the correct path as a parameter to the method loadImage.");
                error++;
            }
        }
    }

    public void render() {
		//int[] btnCol = {192, 192,192};
        int[] btnCol = {51, 153,255};
		if (isPosInRect(pApplet.mouseX,pApplet.mouseY)) {
				/*for (int i = 0; i < btnCol.length; i++) {
                    btnCol[i] = 224;
			}*/
            btnCol[0] = 102;
            btnCol[1] = 179;
            btnCol[2] = 255;
		}
		pApplet.fill(btnCol[0], btnCol[1], btnCol[2]);
        //pApplet.stroke(192,192,192);
        pApplet.stroke(51,153,255);
        pApplet.rect(x, y, w, h);
        if(imageLoaded){
            pApplet.image(image, x + (w/5.5f), y + (h/5.5f));
        }
        //pApplet.textSize(32);
		//pApplet.fill(0,255,255);
		//pApplet.text(text, x, y + (h /2));
	}

	private boolean isPosInRect(int mouseX, int mouseY) {
		boolean isInWidth = mouseX >= x && mouseX <= x+w;
		boolean isInHeight = mouseY >= y && mouseY <= y+h;
		return isInWidth && isInHeight;
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
}
