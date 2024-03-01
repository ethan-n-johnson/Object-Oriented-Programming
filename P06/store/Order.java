package store;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
/**
 * Defining an order placed by a customer.
 * @author Ethan Johnson
 * @version 0.2
 * @since Version 0.2
 * @license.agreement Public Domain
*/

public class Order{

    /**
     * Constructs the order object.
     * @param customer The customer attached to the order
     * @since Version 0.2
    */
    public Order(Customer customer){
        this.orderNumber = nextOrderNumber++;
        this.customer = customer;
        this.items = new ArrayList<Item>();
    }
    public Order(BufferedReader br) throws IOException{
        this.items = new ArrayList<Item>();
        this.customer = new Customer(br);
        int numberofItems = Integer.parseInt(br.readLine());
        for(int i = 0; i < numberofItems; i++){
            addItem(new Item(br));
        }
        this.orderNumber = Integer.parseInt(br.readLine());
        this.nextOrderNumber = Integer.parseInt(br.readLine());
    }
    /**
     * Adds an item to the order.
     * @param item The item added to the order.
     * @since Version 0.2
    */
    public void addItem(Item item){
        items.add(item);
    }
    /**
     * Sums the price of all items and returns the result.
     * @return Returns the total price.
     * @since Version 0.2
    */
    public int getPrice(){
        int totalPrice = 0;
        for(Item item : items){
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
    /**
     * Provides a string representation of the order formatted like a receipt.
     * @return The string representation of the order.
     * @since Version 0.2
    */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Order #").append(orderNumber).append(" for ").append(customer.toString()).append("\n");
        for(Item item : items){
            sb.append(item).append("\n");
        }
        sb.append("Order total $  ").append(getPrice()/100.00);
        return sb.toString();
    }
    public void save(BufferedWriter bw) throws IOException{
        customer.save(bw);
        bw.write("" + items.size() + '\n');
        for(Item i : items){
            i.save(bw);
        }
        bw.write("" + orderNumber + '\n');
        bw.write("" + nextOrderNumber + '\n');
    }

    private Customer customer;
    private ArrayList<Item> items;
    private int orderNumber;
    private static int nextOrderNumber = 1;
}