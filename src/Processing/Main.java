package Processing;
import StockGraph.Utils.StockTicker;

public class Main {
    public static void main(String[] args){
        StockTicker stockTicker = new StockTicker(500, 1);
        //stockTicker.simulateStocks();
        FirstGui frame = new FirstGui();
        //frame.addData(stockTicker.getSimulatedStocks());
        frame.renderData();
        //System.out.println(stockTicker.getSimulatedStocks());
    }
}
