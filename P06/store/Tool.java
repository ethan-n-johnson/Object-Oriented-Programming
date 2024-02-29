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
 * @since Version 0.2
 * @license.agreement Public Domain
*/
public class Tool extends Product{
    /**
     * Constructs the Tool object.
     * @param name The name of the tool.
     * @param price The price of the tool
     * @since Version 0.2
    */
    public Tool(String name, int price){
        super(name, price);
    }
    public Tool(BufferedReader br) throws IOException{
        super(br);
    }
}