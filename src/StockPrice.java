/*
import java.util.Comparator;
import java.util.PriorityQueue;

class StockRecord {

    Integer timeStamp;
    Integer price;

    StockRecord(Integer  timeStamp,Integer price){
        this.timeStamp=timeStamp;
        this.price=price;
    }

}
public class StockPrice {

    PriorityQueue<StockRecord> minQueue;
    PriorityQueue<StockRecord> maxQueue;
    public StockPrice() {
        minQueue=new PriorityQueue<>(new Comparator<StockRecord>() {
            @Override
            public int compare(StockRecord o1, StockRecord o2) {
                return o1.price-o2.price;
            }
        });
        maxQueue=new PriorityQueue<>(new Comparator<StockRecord>() {
            @Override
            public int compare(StockRecord o1, StockRecord o2) {
                return -(o1.price-o2.price);
            }
        });
    }

    public void update(int timestamp, int price) {
        minQueue.add(new StockRecord(timestamp,price));
        maxQueue.add(new StockRecord(timestamp,price));

    }

    public int current() {
        minQueue.
    }

    public int maximum() {

    }

    public int minimum() {

    }
}*/
