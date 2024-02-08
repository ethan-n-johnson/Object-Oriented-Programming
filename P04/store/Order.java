package store;
import java.util.ArrayList;

/**
 * Defining an order placed by a customer.
 * @author Ethan Johnson
 * @version 0.2
 * @since Version 0.2
*/

public class Order{

    /**
     * Constructs the order object.
     * @param Customer The customer attached to the order
     * @since Version 0.2
    */
    public Order(Customer customer){
        this.orderNumber = nextOrderNumber++;
        this.customer = customer;
        this.items = new ArrayList<Item>();
    }
    /**
     * Adds an item to the order.
     * @param Item The item added to the order.
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
        sb.append("Order # ").append(orderNumber).append(" for ").append(customer.toString()).append("\n");
        for(Item item : items){
            sb.append(item).append("\n");
        }
        sb.append("Order total $   ").append(getPrice());
        return sb.toString();
    }
    private Customer customer;
    private ArrayList<Item> items;
    private int orderNumber;
    private static int nextOrderNumber = 0;
}