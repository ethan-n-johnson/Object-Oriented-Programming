public class Product {
    public Product(String name, int price){
        // Need to finish
    }
    public int getStockNumber(int stockNumber){
        this.stockNumber = stockNumber;
    }
    public int getPrice(int price, String name){
        if(price < 0){
            throw new IllegalArgumentException("Invalid price of " + name + ": " + price);
        }
        else{
            this.price = price;
            this.name = name;
        }
    }
    @Override
    public String toString(){
        return name + "$ " + price;
    }

    private int nextStockNumber;
    private int stockNumber;
    private String name;
    private int price;
}
