package test;
import store.Item;
import store.Product;
public class TestItem{
    public static void main(String[] args)
    {
        int price = 1200;
        int failureCode = 0;
        int quantity = 5;
        double totalPrice = price*quantity/100.00;

        String testProduct = "Test Product 1";
        store.Product p1 = new store.Product("Test Product 1", price);
        store.Item i1 = new store.Item(p1, quantity);
        String stringTest = String.format("%-30s $%8.2f", testProduct, price / 100.00);
        String itemTest = String.format("%3d %-30s $%8.2f", quantity, p1.toString(), totalPrice);
        
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