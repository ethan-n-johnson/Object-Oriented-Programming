package mdi;
import java.util.Scanner;
public class Controller{

    public Controller(String storeName){
        this.store = storeName;
        this.view = View.CUSTOMERS; 
        this.mainMenu = createMainMenu();
        this.output = "";
        this.isRunning = true;
        this.in = new Scanner(System.in);
    }
    public void mdi()
    {
        while(isRunning){
            try{
                Integer i = selectFromMenu();
                if(i == null) continue;
                menu.run(i);

            } catch(Exception e){
                System.err.println("Invalid Input");
            }
        }
    }
    private void exit()
    {
        isRunning = false;
    }
    private void placeOrder()
    {
        System.out.println("Customer List:");
        store.getCustomerList();
        System.out.println("What is your customer number?\n>");
        int customerIndex = getInt("Select customer\n>") - 1;
        if(customerIndex < 0 || customerIndex >= customers.size()) {
            System.out.println("Invalid customer selection.\nPlease try again\n");
            placeOrder();
        }
        Customer customer = customers.get(customerIndex)
        Order order = store.newOrder(customer);
        System.out.println("Product List:");
        store.getProductList();
        int productIndex = 0;
        while(productIndex != -1){
            productIndex = getInt("Select product (0 to quit)\n>") - 1;
            while (productIndex < 0 || productIndex >= products.size()) {
                if(productIndex == -1) break;
                System.out.println("Invalid product selection.");
                productIndex = getInt("Select product (0 to quit)\n>") - 1;
            }
        }
        Product product = products.get(productIndex);
        int quantity = getInt("Enter quantity for " + product.getName() + ": ");
        store.addToOrder(order, product, quantity);
        output = "Order placed successfully.";
        view = View.ORDERS;
    }
    private void newCustomer(){
        System.out.println("Enter the name of the customer\n>")
        String customerName = getString();
        System.out.println("Enter the email of the customer\n>")
        Customer customer = new Customer(customerName, getString());
        store.addCustomer(customer);
        output = "Customer added successfully";
        view = CUSTOMERS;
    }
    private void newTool(){
        System.out.println("Enter the name of the tool\n>")
        String toolName = getString();
        System.out.println("Enter the price of the tool\n>");
        Tool tool = new Tool(toolName, getInt());
        store.addProduct(tool);
        output = "Product added successfully";
        view = PRODUCTS;
    }
    private void newPlant(){
        System.out.println("Enter the species of the plant\n>");
        String plantSpecies = getString();
        System.out.println("Enter the level of exposure (" + Exposure.values() + ")\n>");
        Exposure exposure = getString();
        System.out.println("Enter the price of the plant\n>");
        Plant plant = new Plant(plantSpecies, getInt(), exposure);
        store.addProduct(plant);
        output = "Product added successfully";
        view = PRODUCTS;
    }
    private void switchView(){
        getString("Select a view (CUSTOMERS, PRODUCTS, or ORDERS)\n>");
    }
    private String getView(){
        switch(view){
            case CUSTOMERS:
                getCustomerList();
                break;
            case PRODUCTS:
                getProductList();
                break;
            case ORDERS:
                getOrderList();
                break; 
        }
    }
    private Integer selectFromMenu(){
        System.out.println(clearscreen + store.name + "\n");
        System.out.println("Main Menu");
        System.out.println("Current View: " + view);
        getView();
        System.out.println(output);
        output = "";
        return getInt("Select an option\n>");
    }
    private void print(String s){
        output += s + '\n';
    }
    private String getString(String prompt){
        String s = null;
        while(true){
            try{
                System.out.print(prompt)
                s = in.nextLine().trim();
                break;
            } catch(Exception e)
        }
        return s;
    }
    private Integer getInt(String prompt){
        Integer i = null;
        while(true){
            try{
                String input = getString(prompt);
                if(input != null && !input.isEmpty()) i = Integer.parseInt(input);
                break;
            } catch(Exception e){
                System.err.println(("Invalid Input"));
            }
        }
        return i;
    }
    private Double getDouble(String prompt){
        Double d = null;
        while(true){
            try{
                String input = getString(prompt);
                if(input != null && !input.isEmpty()) d = Integer.parseDouble(input)
                break;
            } catch(Exception e){
                System.err.println(("Invalid Input"));
            }
        }
        return d; 
    }

    private Store store;
    private View view;
    private Menu mainMenu;
    private String output;
    private boolean isRunning;
    private Scanner in;
    private static final String clearscreen = "\n".repeat(255);
}