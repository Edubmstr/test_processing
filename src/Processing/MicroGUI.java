package Processing;

import java.util.function.Consumer;
import processing.core.*; //import processing

public class MicroGUI extends PApplet {
	
	GuiButton button1;
	int counter = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(MicroGUI.class);
	}
	
	public void settings() {
		size(800,600);
	}
	
	public void setup() {
		rectMode(PApplet.CENTER);
		textAlign(PApplet.CENTER, PApplet.CENTER);
		button1 = new GuiButton(100,300,100,50, "klick", this);
		button1.onClick = (btn) -> onButtonClick(button1);
	}
	
	public void draw() {
		background(0);
		button1.render();
	}
	
	void onButtonClick(Object btn) {
		fill(204, 200, 0);
		circle(300, 300, 50);
		print("ok");
		//counter += 1;
		//print(counter);
	}

	public void mousePressed(){
		System.out.println("Test");
	}
	
	
}


class GuiButton {
	float posX,posY; //start pos of button
	float w,h;
	int r,g,b;
	String text; //caption text of button
	
	PApplet parent;
	
	Consumer<GuiButton> onClick;
	
	public GuiButton(float x, float y, float w, float h, String text, PApplet parent) {
		this.posX = x;
		this.posY = y;
		this.w = w;
		this.h = h;
		this.text = text;
		this.parent = parent;
	}

	public void render() {
		// TODO Auto-generated method stub
		
		int btnCol = 100;
		//mouseDown handling
		if (isPosInRect(parent.mouseX,parent.mouseY)) {
			//fire event
			if (parent.mousePressed == true)
			{
			if (onClick != null) {
				onClick.accept(this);
			}
			}
			else {
				//hover
				btnCol = 150;
			}
		}
		
		parent.fill(btnCol,0,0);
		parent.rect(posX, posY, w, h); //draw button rectangle
		parent.textSize(32);
		parent.fill(200);
		parent.text(text, posX, posY);
	}

	private boolean isPosInRect(int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		//is point x,y in the button rectangle?
		boolean isInWidth = mouseX >= posX-w/2 && mouseX <= posX+w/2;
		boolean isInHeight = mouseY >= posY-h/2 && mouseY <= posY+h/2;
		return isInWidth && isInHeight;
	}
}

