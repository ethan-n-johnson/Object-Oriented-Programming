package.store;
public class Order{
    public class Order(Customer customer){
        this.orderNumber = nextOrderNumber++;
    }
    public class Item(Item item){

    }
    public int getPrice(){
        return customer.price;
    }
    @Override
    public Stirng toString(){

    }
    private Customer customer;
    private ArrayList<Item> items;
    private int orderNumber;
    private int static nextOrderNumber = 0;
}