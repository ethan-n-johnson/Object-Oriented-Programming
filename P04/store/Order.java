package.store;
public class Order{
    public class Order(Customer customer){
        this.orderNumber = nextOrderNumber++;
        this.customer = customer;
    }
    public class AddItem(Item item){
        items = ArrayList.add(item);
    }
    public int getPrice(){
        return customer.price;
    }
    @Override
    public String toString(){
        
    }
    private Customer customer;
    private ArrayList<Item> items;
    private int orderNumber;
    private int static nextOrderNumber = 0;
}