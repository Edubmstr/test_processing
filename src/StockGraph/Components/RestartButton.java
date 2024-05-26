package StockGraph.Components;

import processing.core.PApplet;
import processing.core.PImage;

public class RestartButton {
    float x,y;
    float w,h;
    boolean mousePressed, mouseReleased;
    String text;
    PApplet pApplet;
    PImage image;

    public RestartButton(float x, float y, float w, float h,String text, PApplet pApplet){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.text = text;
        this.pApplet = pApplet;
    }
    public void render() {
		int[] btnCol = {192, 192,192};
		if (isPosInRect(pApplet.mouseX,pApplet.mouseY)) {
				for (int i = 0; i < btnCol.length; i++) {
                    btnCol[i] = 224;
			}
		}
		pApplet.fill(btnCol[0], btnCol[1], btnCol[2]);
        pApplet.stroke(192,192,192);
		pApplet.rect(x, y, w, h);
        try {
            image = pApplet.loadImage("src/StockGraph/Static/stock-market.png");
            pApplet.image(image, x + (w/5.5f), y + (h/5.5f));
        } catch (Exception e) {
            int error = 0;
            while(error < 5){
                System.out.println("Directory of image not found. Try to edit the filepath to match your file system. File path is in Components/RestartButton.");
                error++;
            }
            
        }
        //pApplet.textSize(32);
		//pApplet.fill(0,255,255);
		//pApplet.text(text, x, y + (h /2));
	}

	public boolean isPosInRect(int mouseX, int mouseY) {
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
