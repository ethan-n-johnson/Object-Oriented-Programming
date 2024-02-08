package test;
import store.*;

public class TestItem{
    public static void main(String[] args)
    {
        int price = 1200;
        int failureCode = 0;
        int quantity = 5;
        double totalPrice = price*quantity/100.00;

        String testItem = "Test Tool 1";
        store.Tool t1 = new store.Tool("Test Tool 1", price);
        store.Item i1 = new store.Item(t1, quantity);
        String itemTest = String.format("%3d %-30s $%8.2f", quantity, testItem, totalPrice);
        
        if (i1.getPrice()/100.00 != totalPrice){
            failureCode = failureCode+1;
            System.err.println("Error Invalid price\nexpected: " + totalPrice + " provided: " + i1.getPrice()/100.00);
        }
        if (!i1.toString().equals(itemTest)){
            failureCode = failureCode+10;
            System.err.println("Error Invalid string\nexpected:\n" + itemTest + "\nprovided:\n" + i1.toString());
        }

        System.exit(failureCode);
    }
}