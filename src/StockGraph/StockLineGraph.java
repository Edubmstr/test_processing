package StockGraph;

import StockGraph.Components.LineChart;
import StockGraph.Components.RestartButton;
import StockGraph.Components.TextLabel;
import StockGraph.Utils.StockTicker;
import processing.core.PApplet;

public class StockLineGraph extends PApplet{
    private LineChart stockLineChart;
    private TextLabel maxValueLabel;
    private TextLabel minValueLabel;
    private TextLabel averageLabel;
    private TextLabel startValueLabel;
    private TextLabel volatilityLabel;
    private StockTicker stocks;
    private RestartButton restart;
    public static void main(String[] args){
        PApplet.main(StockLineGraph.class);
    }

    public void settings () { 
        size(1500 , 805);
    }

    public void setup(){
        stockLineChart = new LineChart(this);
        stocks = new StockTicker(100, 5);
        stocks.simulateStocks();
        maxValueLabel = new TextLabel(120, 0, 300, 30, "Max Value: ", 0, 255, 0, this);
        minValueLabel = new TextLabel(120, 35, 300, 30,"Min Value: ", 255, 0,0, this);
        averageLabel = new TextLabel(120, 70, 300, 300, "Average: ",255,255,255, this);
        startValueLabel = new TextLabel(425, 0, 300, 30, "Start Value: ", 0,0,255, this);
        volatilityLabel = new TextLabel(425, 35, 300, 30, "Volatility: ", 0,0,255, this);
        maxValueLabel.addState(stocks.getMaxValue());
        minValueLabel.addState(stocks.getMinValue());
        averageLabel.addState(stocks.getAverageValue());
        startValueLabel.addState(stocks.getStartValue());
        volatilityLabel.addState((float)stocks.getVolatility());
        stockLineChart.addData(stocks.getSimulatedStocks());
        restart = new RestartButton(0, 0, 100, 100, "Restart", this);
    }

    public void draw(){
        stockLineChart.renderData();
        restart.render();
        restart.onClick(() -> newData());
        maxValueLabel.render();
        minValueLabel.render();
        averageLabel.render();
        startValueLabel.render();
        volatilityLabel.render();
    }

    public void newData(){
        stocks.simulateStocks();
        stockLineChart.addData(stocks.getSimulatedStocks());
        maxValueLabel.addState(stocks.getMaxValue());
        minValueLabel.addState(stocks.getMinValue());
        averageLabel.addState(stocks.getAverageValue());
        startValueLabel.addState(stocks.getStartValue());
        volatilityLabel.addState((float)stocks.getVolatility());
    }
}
