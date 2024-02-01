public class Item {
    public Item(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    } 
    public int getPrice(int quantity, int price){
        return quantity*price;
    }

    @Override
    public String toString(){

    }
    private Product product;
}
