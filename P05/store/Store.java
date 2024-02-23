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
            customerList.append(i+1).append(": ").append(customers.get(i)).append("\n");
        }
        return customerList.toString();
    }
    public void addProduct(Product product){
        products.add(product);
    }
    public String getProductList(){
        StringBuilder productList = new StringBuilder();
        for(int i = 0; i < products.size(); i++){
            productList.append(i+1).append(": ").append(products.get(i)).append("\n");
        }
        return productList.toString();
    } 
    public int newOrder(Customer customer){
        Order order = new Order(customer);
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
            orderList.append(i+1).append(": ").append(orders.get(i)).append("\n");
        }
        return orderList.toString();
    }
    private String name;
    private ArrayList<Customer> customers;
    private ArrayList<Product> products;
    private ArrayList<Order> orders;

    // Basic Test Remove Later
    public static void main(String[] args) {
        Store store = new Store("MyStore");

        Customer customer1 = new Customer("Grover McDonald", "Grovers_farm@realemail.com");
        Customer customer2 = new Customer("John Doe", "Johns_email@realemail.com");
        store.addCustomer(customer1);
        store.addCustomer(customer2);

        Tool product1 = new Tool("Hammer", 1500);
        Tool product2 = new Tool("Axe", 3000);
        store.addProduct(product1);
        store.addProduct(product2);

        System.out.println("Customer List:");
        System.out.println(store.getCustomerList());

        System.out.println("Product List:");
        System.out.println(store.getProductList());

        int order1 = store.newOrder(customer1);
        int order2 = store.newOrder(customer2);
        store.addToOrder(order1, 0, 2);
        store.addToOrder(order1, 1, 1);

        store.addToOrder(order, 0, 2); 
        store.addToOrder(order1, 1, 1);
        System.out.println(store.getOrderList());
    }
}