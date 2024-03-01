package store;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
/**
 * Defining an order placed by a customer.
 * @author Ethan Johnson
 * @version 0.2
 * @since Version 0.1
 * @license.agreement Public Domain
*/

public class Item {
    /**
     * Constructs the Item object.
     * @param product The product attached to the item.
     * @param quantity The amount of the product.
     * @since Version 0.1
    */
    public Item(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    } 
    public Item(BufferedReader br) throws IOException{
        String type = br.readLine();
        if(type.equals("store.Plant")) this.product = new Plant(br);
        else if(type.equals("store.Tool")) this.product = new Tool(br);
        this.quantity = Integer.parseInt(br.readLine());
    }
    /**
     * Multiplies the product's price with the quantity.
     * @return Returns the total price of the Item
     * @since Version 0.1
    */
    public int getPrice(){
        return quantity*product.getPrice();
    }

    @Override
    /**
     * Provides a string representation of the item with formatting.
     * @return Returns the string representation of the item.
     * @since Version 0.1
    */
    public String toString(){
        double priceInDollars = getPrice()/100.00;
        String formattedItem = String.format("%3d %-30s $%8.2f", quantity, product.toString(), priceInDollars);
        return formattedItem;
    }
    public void save(BufferedWriter bw) throws IOException{
        product.save(bw);
        bw.write("" + quantity  + '\n');
    }
    private Product product;
    private int quantity;
}
