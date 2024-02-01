public class TestProduct{
    public static int regressionTest(){
        int price = 6390;
        int numberOfFailures = 0;
        String testProduct = "Test Product 1";
        Product p1 = new Product("Test Product 1", price);
        Product p2 = new Product("Test Product 2", price+500);
        String stringTest = String.format("%-30s $%8.2f", testProduct, price / 100.00);
        
        if(p1.getStockNumber() != 0 || p2.getStockNumber() != 1){
            numberOfFailures++;
            System.err.println("Error Invalid stock number. expected: 0 1 provided: " + p1.getStockNumber() + p2.getStockNumber());
        }
        if (p1.getPrice() != price){
            numberOfFailures++;
            System.err.println("Error Invalid price. expected: " + price + " provided: " + p1.getPrice());
        }
        if (!p1.toString().equals(stringTest)){
            numberOfFailures++;
            System.err.println("Error Invalid string. expected:\n" + stringTest + "\nprovided:\n" + p1.toString());
        }
        try{
            Product p3 = new Product("Test Product 3", -7090);
        }
        catch(IllegalArgumentException e){
            System.err.println("Error negative price provided");
            numberOfFailures++;
        }
        return numberOfFailures;
    }
    public static void main(String[] args)
    {
        int numberOfFailures = regressionTest();
        System.out.println(numberOfFailures);
        System.exit(numberOfFailures);
    }
}