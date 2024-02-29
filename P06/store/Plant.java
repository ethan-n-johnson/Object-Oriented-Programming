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

public class Plant extends Product{
    /**
     * Constructs the plant object.
     * @param species The species of the plant.
     * @param price The price of the plant.
     * @param exposure The level of exposure the plant needs.
     * @since Version 0.2
    */
    public Plant(String species, int price, Exposure exposure){
        super(species, price);
        this.exposure = exposure;
    }
    public Plant(BufferedReader br) throws IOException{
        super(br);
        this.exposure = Exposure.valueOf(br.readLine());
    }
    /**
     * Gets the level of exposure the plant needs.
     * @return Returns the level of exposure.
     * @since Version 0.2
    */
    public Exposure getExposure(){
        return exposure;
    }
    /**
     * Provides a string representation of the plant with formatting.
     * @return Returns a string representation of the plant.
     * @since Version 0.3
    */
    @Override
    public String toString(){
        double priceInDollars = getPrice() / 100.00;
        String formattedPlant = String.format("%-40s $%8.2f", "Plant: " + getName(), priceInDollars);
        return formattedPlant;
    }
    @Override
    public void save(BufferedWriter bw) throws IOException{
        super.save(bw);
        bw.write("" + exposure.name() + '\n');
    }
    private Exposure exposure;   
}