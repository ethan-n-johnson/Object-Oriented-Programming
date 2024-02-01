public class TestProduct{
    public int regressionTest(){
        int price = 6390;
        int numberOfFailures = 0;
        Product p1 = new Product("Test Product 1", price);
        Product p2 = new Product("Test Product 2", price+500);
        try{            
            if(p1.getStockNumber() != 0 || p2.getStockNumber() != 1){
                numberOfFailures++;
                throw new IllegalArgumentException("Invalid stock number expected: 0 1 provided: " + p1.getStockNumber() + p2.getStockNumber());
            }
            if (p1.getPrice() != 5){
                numberOfFailures++;
                throw new IllegalArgumentException("Invalid price expected: " + x + " provided: " + p1.getPrice());
            }
        }
        catch(Exception e){
            System.err.println("Number of failures: " + numberOfFailures);
        }
    }
    public static void main(String[] args)
    {
        System.exit(regressionTest());
    }
}