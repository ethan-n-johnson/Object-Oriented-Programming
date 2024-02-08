package test;
import store.Customer;
import store.Exposure;
import store.Item;
import store.Order;
import store.Plant;
import store.Product;
import store.Tool;

public class TestOutput {
    public static void main(String[] args) {
        try {
            store.Customer c1 = new store.Customer("Prof Rice", "george.rice@uta.edu");
            store.Customer c2 = new store.Customer("President Joe Biden", "president@whitehouse.gov");
            store.Customer c3 = new store.Customer("The Late Queen Elizabeth II", "queen@royal.gov.uk");
            store.Customer c4 = new store.Customer("Mark Zuckerberg", "mark.zuckerberg@facebook.com");

            System.out.println("Famous customers include\n  "
                             + c1 + "\n  " + c2 + "\n  "+ c3 + "\n  " + c4);

            store.Plant p1 = new store.Plant("Cactus Cereus Peruvianus", 4990, Exposure.SHADE);
            store.Plant p2 = new store.Plant("'White Princess' Philodendron", 5500, Exposure.SUN);
            store.Plant p3 = new store.Plant("6 inch English Lavender", 2909, Exposure.PARTSUN);
            store.Plant p4 = new store.Plant("'Hayi' Rhaphidophora", 3299, Exposure.SHADE);

            System.out.println("Our best plants include:\n  "
                             + p1 + "\n  " + p2 + "\n  "+ p3 + "\n  " + p4);

            store.Item i1 = new store.Item(p1, 1);
            store.Item i2 = new store.Item(p2, 2);
            store.Item i3 = new store.Item(p3, 3);
            store.Item i4 = new store.Item(p4, 4);

            System.out.println("And my order will include:\n  "
                             + i1 + "\n  " + i2 + "\n  "+ i3 + "\n  " + i4);
        } catch(Exception e) {
            System.err.println("Failed to create and print objects: \n" + e);
        }
    }
}