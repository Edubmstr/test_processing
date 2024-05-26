package Processing;
import processing.core.PApplet;

public class Processing extends PApplet {
    public static void main(String[] args){
        PApplet.main(Processing.class);
    }

    public void settings () { // startup settings
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
    }
}
