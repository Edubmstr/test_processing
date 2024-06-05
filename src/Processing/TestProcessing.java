package Processing;

import processing.core.PApplet;

public class TestProcessing extends PApplet {
    public static void main(String[] args){
        PApplet.main(TestProcessing.class);
    }

    /*public void settings () { // startup settings
        size (800 , 600) ;
    }

    public void setup () { // setup called after settings
        stroke (255 , 0 , 0 , 255) ;
        textSize (72) ;
    }

    int bgCol = 0;
    public void draw () { // draw called every frame
        background ( bgCol,0,0 ); // clear background
        textSize ( bgCol ) ;
        text (" Hello World !" ,10 ,300) ; // set text
        bgCol = ( bgCol + 1) % 128; // animate color
    }*/

    int[] data = { 50, 70, 80, 60, 90, 75, 80, 65, 90, 70 };
    int max = max(data);

    public void settings(){
        size(500, 500);
    }

    public void setup() {
      background(255);
      strokeWeight(1);
    }
    
    public void draw() {
        int dataMax = max(data); // Maximalen Wert in den Daten finden
      
        // Liniendiagramm zeichnen
        stroke(0);
        for (int i = 0; i < data.length-1; i++) {
          float x1 = map(i, 0, data.length-1, 50, width-50);
          float y1 = map(data[i], 0, dataMax, height-50, 50);
          float x2 = map(i+1, 0, data.length-1, 50, width-50);
          float y2 = map(data[i+1], 0, dataMax, height-50, 50);
      
          line(x1, y1, x2, y2);
        }
      
        // Achsen mit Abstufungen zeichnen
        strokeWeight(2);
        line(50, height-50, width-50, height-50); // x-Achse
        line(50, height-50, 50, 50); // y-Achse
        
        // Pfeile an den Achsen
        line(width-50, height-50, width-60, height-60);
        line(width-50, height-50, width-60, height-40);
        line(50, 50, 60, 60);
        line(50, 50, 40, 60);
      
        // Abstufungen
        strokeWeight(1);
        fill(0); // Schriftfarbe auf Schwarz setzen
        for (int i = 0; i < dataMax; i += (dataMax/10)) {
          float y = map(i, 0, dataMax, height-50, 50);
          line(45, y, 55, y);
          text(i, 30, y+5);
        }
      
        for (int i = 1; i < data.length - 1; i++) {
          float x = map(i, 0, data.length-1, 50, width-50);
          line(x, height-45, x, height-55);
          text(i, x-5, height-30);
        }
      
        // Achsenbeschriftungen
        text("X", width-30, height-30);
        text("Y", 30, 30);
      }
}