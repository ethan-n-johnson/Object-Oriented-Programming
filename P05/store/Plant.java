package store;
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
        /**
     * Gets the level of exposure the plant needs.
     * @return Returns the level of exposure.
     * @since Version 0.2
    */
    public Exposure getExposure(){
        return exposure;
    }
    private Exposure exposure;   
}