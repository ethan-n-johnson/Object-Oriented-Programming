package store;

import java.io.BufferedWriter
import java.io.BufferedReader
import java.io.IOException

/**
 * Defining an order placed by a customer.
 * @author Ethan Johnson
 * @version 0.2
 * @since Version 0.1
 * @license.agreement Public Domain
*/
public class Customer {
    /**
     * Constructs the customer object.
     * @param name The name of the customer.
     * @param email The email of the customer.
     * @since Version 0.1
    */
    public Customer(String name, String email){
        this.name = name;
        if(!email.contains("@") || email.indexOf("@") >= email.lastIndexOf(".")){
            throw new IllegalArgumentException("Invalid email address: " + email);
        }
        this.email = email;
    }
    public Customer(BufferedReader br) throws IOException{
        this.name = br.readLine();
        String email = br.readLine();
        if(!email.contains("@") || email.indexOf("@") >= email.lastIndexOf(".")){
            throw new IllegalArgumentException("Invalid email address: " + email);
        }
        this.email = email;
    }
    /**
     * Provides a string representation of the customer.
     * @return Returns the name and email of a string with formatting.
     * @since Version 0.1
    */
    @Override
    public String toString(){
        String formattedString = String.format("%s (%s)", name, email);
        return formattedString;
    }
    public void save(BufferedWriter bw) throws IOException{
        bw.write( name + '\n');
        bw.write(email + '\n');
    }
    private String name;
    private String email;
}
