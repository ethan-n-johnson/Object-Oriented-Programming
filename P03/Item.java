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
        String formattedItem = String.format("%3d -30%s $%s", quantity, product.toString(), product.getPrice());
        return formattedItem;
    }
    private Product product;
    private int quantity;
}
