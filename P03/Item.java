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
        String formattedItem = String.format("%3d %-30s $%7d", quantity, product.toString(), getPrice());
        return formattedItem;
    }
    private Product product;
    private int quantity;
}
