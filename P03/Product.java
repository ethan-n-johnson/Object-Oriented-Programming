public class Product {
    public Product(String name, int price){
        if(price < 0){
            throw new IllegalArgumentException("Invalid price of " + name + ": " + price);
        }
        else{
            this.stockNumber = nextStockNumber++;
            this.price = price;
            this.name = name;
        }
    }
    public int getStockNumber(){
        return stockNumber;
    }
    public int getPrice(){
        return price;   
    }
    @Override
    public String toString(){
        String price = String.format("%5.2d", price);
        return String.format("-30%s $%s", name, price);
    }

    private static int nextStockNumber = 0;
    private int stockNumber;
    private String name;
    private int price;
}
