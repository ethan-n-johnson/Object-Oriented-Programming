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
        for(int i = 0, i < customers.size(), i++){
            customerList.append(i).append(": ").append(customers.get(i).append("\n"));
        }
        return customerList.toString();
    }
    public void addProduct(Product product){
        products.add(product);
    }
    public String getProductList(){
        StringBuilder productList = new StringBuilder();
        for(int i = 0, i < products.size(), i++){
            productList.append(i).append(": ").append(products.get(i).append("\n"));
        }
        return productList.toString();
    } 
    public int newOrder(int customer){
        
        return tempint;
    }
    public void addToOrder(int order, int product, int quantity){
    
    }
    public String getOrderList(){
        return tempString;
    }
    private String name;
    private ArrayList<Customer> customers;
    private ArrayList<Product> products;
    private ArrayList<Order> orders;
}