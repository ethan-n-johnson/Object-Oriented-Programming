package store;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
/**
 * Defining an order placed by a customer.
 * @author Ethan Johnson
 * @version 0.2
 * @since Version 0.1
 * @license.agreement Public Domain
*/
public abstract class Product {
    /**
     * Constructs the product object.
     * @param name The name of the product.
     * @param price The price of the product
     * @since Version 0.2
    */
    public Product(String name, int price){
        if(price < 0){
            throw new IllegalArgumentException("Invalid price of " + name + ": " + price);
        }
        else{
            this.stockNumber = nextStockNumber++;
            this.price = price;
            this.name = name;
        }
    }
    public Product(BufferedReader br) throws IOException{
        String nameTemp = br.readLine();
        int priceTemp = Integer.parseInt(br.readLine());
        if(priceTemp < 0){
            throw new IllegalArgumentException("Invalid price of " + nameTemp + ": " + priceTemp);
        }
        else{
            this.name = nameTemp;
            this.price = priceTemp;
            this.stockNumber = Integer.parseInt(br.readLine());
            this.nextStockNumber = Integer.parseInt(br.readLine());
        }
    }
    /**
     * Provides the currect stock number.
     * @return Returns the current stock number.
     * @since Version 0.2
    */
    public int getStockNumber(){
        return stockNumber;
    }
    /**
     * Provides the price of the product.
     * @return Returns the price of the product.
     * @since Version 0.2
    */
    public int getPrice(){
        return price;   
    }
    /**
     * Provides the name of the product.
     * @return Returns the name of the product.
     * @since Version 0.3
    */
    public String getName() {
        return name;
    }
    /**
     * Provides a string representation of the product with formatting.
     * @return Returns a string representation of the product.
     * @since Version 0.2
    */
    @Override
    public String toString(){
        double priceInDollars = price/100.00;
        String formattedProduct = String.format("%-40s $%8.2f", name, priceInDollars);
        return formattedProduct;
    }
    public void save(BufferedWriter bw) throws IOException{
        bw.write(name + '\n');
        bw.write("" + price + '\n');
        bw.write("" + stockNumber  + '\n');
        bw.write("" + nextStockNumber  + '\n');
    }

    private static int nextStockNumber = 0;
    private int stockNumber;
    private String name;
    private int price;
}
