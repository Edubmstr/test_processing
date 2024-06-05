package StockGraph.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class StockTicker {
    private ArrayList<Float> simulatedStocks = new ArrayList<Float>();
    private float startValue;
    private double volatility;
    private final double DEFAULT_VOLATILITY = 20;
    private Random random = new Random();

    public StockTicker(){
        this.startValue = random.nextFloat(50);
        this.volatility = DEFAULT_VOLATILITY;
        //.add(this.startValue);
    }

    public StockTicker(float startValue, double volatilityIndex){
        this.startValue = startValue;
        this.volatility = volatilityIndex;
        //simulatedStocks.add(this.startValue);
    }

    public void simulateStocks(){
        if(simulatedStocks.size() == 1000 ){
            simulatedStocks.clear();
        }
        randomWalk();
        generateCSV();
        printInfo();
    }

    public ArrayList<Float> getSimulatedStocks() {
        return simulatedStocks;
    }

    private void randomWalk(){
        simulatedStocks.add(this.startValue);
        for (int i = 1; i < 1000; i++) {
            simulatedStocks.add(nextNumber(simulatedStocks.get(i - 1)));
            if(simulatedStocks.get(i) <= 0){
                simulatedStocks.set((i), 0.0f);
            }
        }
    }

    private void generateCSV(){
        File file = new File("src/StockGraph/Utils/data.csv"); //Might be edited, to the current working directory/package on another system.
        try {
            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < simulatedStocks.size(); i++) {
                if(i == 999){
                    writer.write((i + 1) + "," + (simulatedStocks.get(i)));
                    break;
                }
                writer.write((i + 1) + "," + (simulatedStocks.get(i)) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            if(e instanceof FileNotFoundException){
                e.printStackTrace();
                System.out.println("CSV-File could no be written. Check pathname of file as it might conflict with another filesystem or Java Project Structure. Edit the generateCSV-method of class StockTicker.");
                return;
            }else{
                e.printStackTrace();
                System.out.println("Error writing to file");
            }
        }
    }
    
    private float nextNumber(float input){
        Random random = new Random();
        return (input + (float)(random.nextGaussian() * volatility));
        //return (input + (random.nextDouble(-1, 1) * volatility));
    }

    public float getMaxValue(){
        return Collections.max(this.simulatedStocks);
    }

    public float getMinValue(){
        return Collections.min(this.simulatedStocks);
    }

    public float getAverageValue(){
        float sum = 0.0f;
        for (int i = 0; i < simulatedStocks.size(); i++) {
            sum += simulatedStocks.get(i);
        }
        return sum / simulatedStocks.size();
    }

    private void printInfo(){
        System.out.println("Start value: " + startValue +  "\nVolatility: "  + volatility + "\nThe average value of the simulated stocks was: " + this.getAverageValue());
        System.out.println("The lowest value was: " + this.getMinValue());
        System.out.println("The highest value was: " + this.getMaxValue());
    }

    public double getVolatility() {
        return volatility;
    }

    public float getStartValue() {
        return startValue;
    }
}
