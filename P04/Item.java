public class Item {
    public Item(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    } 
    public int getPrice(){
        return quantity*product.getPrice();
    }

    @Override
    public String toString(){
        double priceInDollars = getPrice()/100.00;
        String formattedItem = String.format("%3d %-30s $%8.2f", quantity, product.toString(), priceInDollars);
        return formattedItem;
    }
    private Product product;
    private int quantity;
}
