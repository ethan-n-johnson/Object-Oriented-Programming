package store;
import java.util.ArrayList;
public class Store{
    public Store(String name){
        this.name = name;
        this.customers = new ArrayList<>();
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
    }
    public String getName(){
        return name;
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    public String getCustomerList(){
        StringBuilder customerList = new StringBuilder();
        for(int i = 0; i < customers.size(); i++){
            customerList.append("   ").append(i+1).append(": ").append(customers.get(i)).append("\n");
        }
        customerList.append("\n");
        return customerList.toString();
    }
    public void addProduct(Product product){
        products.add(product);
    }
    public String getProductList(){
        StringBuilder productList = new StringBuilder();
        for(int i = 0; i < products.size(); i++){
            productList.append("   ").append(i+1).append(": ").append(products.get(i)).append("\n");
        }
        productList.append("\n");
        return productList.toString();
    } 
    public int newOrder(int customer){
        Order order = new Order(customers.get(customer));
        orders.add(order);
        return orders.indexOf(order);
    }
    public void addToOrder(int order, int product, int quantity){
        Item item = new Item(products.get(product), quantity);
        orders.get(order).addItem(item);
    }
    public String getOrderList(){
        StringBuilder orderList = new StringBuilder();
        for(int i = 0; i < orders.size(); i++){
            orderList.append(orders.get(i)).append("\n\n");
        }
        return orderList.toString();
    }
    private String name;
    private ArrayList<Customer> customers;
    private ArrayList<Product> products;
    private ArrayList<Order> orders;
}