package Processing;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Random;

public class FirstGui extends PApplet {
    ArrayList<Float> chartValues = new ArrayList<>();
    static Random random = new Random();

    /*public static void main(String[] args){
        PApplet.main(FirstGui.class);
    }*/

    public FirstGui(){
        
    }

    public void addData(ArrayList<Float> chartValues){
        for (Float float1 : chartValues) {
            this.chartValues.add(float1);
        }
    }

    public void renderData(){
        PApplet.main(FirstGui.class); 
    }

    public void settings () { // startup settings
        size (1500 , 805);
    }

    public void setup () { // setup called after settings
        //stroke (255 , 0 , 0 , 255);
        //textSize (72);
        //line(2,2,4,4);
        stroke(255);
        setupData();
        background(0);
        noFill();
        //textSize(500);
        System.out.println(chartValues);
        
        //point(320,200);
    }

    public void draw(){
        for (int i = 0; i < chartValues.size() - 1; i++) {
            strokeWeight(1);
            line((i * 1.5f),( 800 - ((chartValues.get(i)) * 1.5f)),((i + 1) * 1.5f), (800 - ((chartValues.get(i + 1)) * 1.5f)));
            //strokeWeight(4);
            //point(i,( 800 - (chartValues.get(i)*3)));
            //point(i + 1, (800 - (chartValues.get(i+1)*3)));
        }
    }

    /*private void setupData(){
        chartValues.add((float)1);
        chartValues.add(random.nextFloat(20,50));
        for (int i = 2; i < 1000; i = i + 2) {
            chartValues.add((float)(i / 2) + 1);
            chartValues.add((float)(chartValues.get(i - 1) + (random.nextGaussian()) * 5));
            if(chartValues.get(i + 1) <= 0){
                chartValues.set((i + 1), 0.0f);
            }
        }

    }*/

    private void setupData(){
        chartValues.add(random.nextFloat(20,50));
        for (int i = 1; i < 1000; i++) {
            chartValues.add((chartValues.get(i - 1)) + ((float)(random.nextGaussian()) * 5));
            if(chartValues.get(i) <= 0){
                chartValues.set((i), 0.0f);
            }
        }
    }
    /*int bgCol = 1;
    public void draw () { // draw called every frame
        background ( 0,0,0 ); // clear background
        textSize ( bgCol ) ;
        text (" Hello World !" ,10 ,300) ; // set text
        bgCol = ( bgCol + 1) % 128; // animate color
    }*/
}
