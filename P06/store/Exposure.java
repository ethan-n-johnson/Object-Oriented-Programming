package store;

/**
 * Defining an order placed by a customer.
 * @author Ethan Johnson
 * @version 0.2
 * @since Version 0.2
 * @license.agreement Public Domain
*/
public enum Exposure {
    SUN, PARTSUN, SHADE;

    /**
     * Provides a string representation of the exposure.
     * @return Returns the value of exposure in a more readable way
     * @since Version 0.2
    */
    @Override
    public String toString() {
        switch (this) {
            case SUN: return "Full Sun";
            case PARTSUN: return "Part Sun";
            case SHADE: return "Full Shade";
        }
        return "Error exposure invalid";
    }
}