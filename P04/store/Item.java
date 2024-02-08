package store;

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
    private Product product;
    private int quantity;
}
