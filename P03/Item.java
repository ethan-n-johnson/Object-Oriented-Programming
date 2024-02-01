public class Item {
    public Item(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    } 
    public int getPrice(){
        return quantity*price;
    }

    @Override
    public String toString(){
        String formattedItem = String.format("%3d-30%s $%s",quantity, name, price);
        return formattedItem
    }
    private Product product;
}
