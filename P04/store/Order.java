package store;
import java.util.ArrayList;

public class Order{
    public Order(Customer customer){
        this.orderNumber = nextOrderNumber++;
        this.customer = customer;
        this.items = new ArrayList<Item>();
    }
    public void addItem(Item item){
        items.add(item);
    }
    public int getPrice(){
        int totalPrice = 0;
        for(Item item : items){
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
    @Override
    public String toString(){
        return "Test";
    }
    private Customer customer;
    private ArrayList<Item> items;
    private int orderNumber;
    private static int nextOrderNumber = 0;
}