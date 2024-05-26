package StockGraph.Components;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class LineChart {
    ArrayList<Float> chartValues = new ArrayList<>();
    float maxValue;
    float minValue;
    float average;
    Random random = new Random();
    PApplet pApplet;

    public LineChart(PApplet pApplet){
        this.pApplet = pApplet;
        this.pApplet.stroke(255);
        this.pApplet.background(0);
        this.pApplet.noFill(); 
    }

    public void addData(ArrayList<Float> chartValues){
        if(this.chartValues.size() == 1000){
            this.chartValues.clear();
        }
        for (Float float1 : chartValues) {
            this.chartValues.add(float1);
        }
        this.maxValue = Collections.max(chartValues);
        this.minValue = Collections.min(chartValues);
        float sum = 0.0f;
        for (int i = 0; i < chartValues.size(); i++) {
            sum += chartValues.get(i);
        }
        this.average = sum / chartValues.size();
        this.pApplet.background(0);
        this.pApplet.noFill();
    }

    public void renderData(){
        int counter = 0;
        for (int i = 0; i < chartValues.size() - 1; i++) {
            pApplet.stroke(0,0,255);
            pApplet.strokeWeight(1);
            pApplet.line((i * 1.5f),( 800 - ((chartValues.get(i)) * 1.5f)),((i + 1) * 1.5f), (800 - ((chartValues.get(i + 1)) * 1.5f)));
            if(chartValues.get(i) == this.maxValue){
                pApplet.stroke(0,255,0);
                pApplet.strokeWeight(4);
                pApplet.point(i * 1.5f, (800 - (chartValues.get(i) * 1.5f)));
            }
            if(chartValues.get(i) == this.minValue && counter < 1){
                pApplet.stroke(255,0,0);
                pApplet.strokeWeight(4);
                pApplet.point(i * 1.5f, (800 - (chartValues.get(i) * 1.5f)));
                counter++;
            }
        }
        if(chartValues.get(0) > chartValues.get(999)){
            pApplet.strokeWeight(2);
            pApplet.stroke(255,0,0);
        }
        else{
            pApplet.strokeWeight(2);
            pApplet.stroke(0,255,0);
        }
        pApplet.line(0, (pApplet.height - (chartValues.get(0) * 1.5f)), pApplet.width, (pApplet.height - (chartValues.get(999) * 1.5f)));
    }
}
