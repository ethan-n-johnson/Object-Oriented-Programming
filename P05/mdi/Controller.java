package mdi;
import store.*;
import java.util.Scanner;
public class Controller{
    public Controller(String storeName){
        this.store = new Store(storeName);
        this.mainMenu = createMainMenu();
        this.view = View.CUSTOMERS; 
        this.output = "";
        this.isRunning = true;
        this.in = new Scanner(System.in);

        Customer c1 = new Customer("Prof Rice", "george.rice@uta.edu");
        Customer c2 = new Customer("President Joe Biden", "president@whitehouse.gov");
        Customer c3 = new Customer("The Late Queen Elizabeth II", "queen@royal.gov.uk");
        Customer c4 = new Customer("Mark Zuckerberg", "mark.zuckerberg@facebook.com");
        
        store.addCustomer(c1);
        store.addCustomer(c2);
        store.addCustomer(c3);
        store.addCustomer(c4);
    }
    public void mdi()
    {
        while(isRunning){
            try{
                Integer i = selectFromMenu();
                if(i == null) continue;
                mainMenu.run(i);

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
        System.out.println("What is your customer number?\n> ");
        int customerIndex = getInt("Select customer\n> ") - 1;
        if(customerIndex < 0) {
            System.out.println("Invalid customer selection.\nPlease try again\n");
            placeOrder();
        }
        int orderNumber = store.newOrder(customerIndex);
        System.out.println("Product List:");
        store.getProductList();
        int productIndex = 0;
        while(productIndex != -1){
            productIndex = getInt("Select product (0 to quit)\n> ") - 1;
            while (productIndex < 0){
                if(productIndex == -1) break;
                System.out.println("Invalid product selection.");
                productIndex = getInt("Select product (0 to quit)\n> ") - 1;
            }
        }
        int quantity = getInt("Enter quantity for\n> ");
        store.addToOrder(orderNumber, productIndex, quantity);
        output = "Order placed successfully.";
        view = View.ORDERS;
    }
    private void newCustomer(){
        Customer customer = new Customer(getString("Enter the name of the customer\n> "), getString("Enter the email of the customer\n> "));
        store.addCustomer(customer);
        output = "Customer added successfully";
        view = view.CUSTOMERS;
    }
    private void newTool(){
        Tool tool = new Tool(getString("Enter the name of the tool\n> "), getInt("Enter the price of the tool\n> "));
        store.addProduct(tool);
        output = "Product added successfully";
        view = view.PRODUCTS;
    }
    private void newPlant(){
        boolean exposureNotAssigned = true;
        Exposure exposure = Exposure.SUN;
        do{
            switch(getInt("Enter the level of exposure (" + Exposure.values() + ")\n> ")){
                case 1:
                    exposure = Exposure.SUN;
                    exposureNotAssigned = false;
                    break;
                case 2:
                    exposure = Exposure.PARTSUN;
                    exposureNotAssigned = false;
                    break;
                case 3:
                    exposure = Exposure.SHADE;
                    exposureNotAssigned = false;
                    break;
                default:
                    System.out.println("Invalid Exposure");
            }
        } while(exposureNotAssigned);
        Plant plant = new Plant(getString("Enter the species of the plant\n> "), getInt("Enter the price of the plant\n> "), exposure);
        store.addProduct(plant);
        output = "Product added successfully";
        view = view.PRODUCTS;
    }
    private void switchView(){
        getString("Select a view (CUSTOMERS, PRODUCTS, or ORDERS)\n> ");
    }
    private String getView(){
        switch(view){
            case CUSTOMERS:
                store.getCustomerList();
                break;
            case PRODUCTS:
                store.getProductList();
                break;
            case ORDERS:
                store.getOrderList();
                break; 
        }
        return "Invalid View";
    }
    private Integer selectFromMenu(){
        System.out.println(clearscreen + store.getName() + "\n");
        System.out.println("Main Menu");
        System.out.println("Current View: " + view);
        getView();
        System.out.println(output);
        output = "";
        return getInt("Select an option\n> ");
    }
    private void print(String s){
        output += s + '\n';
    }
    private String getString(String prompt){
        String s = null;
        while(true){
            try{
                System.out.print(prompt);
                s = in.nextLine().trim();
                break;
            } catch(Exception e){
                System.err.println("Invalid Input");
            }
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
                System.err.println("Invalid Input");
            }
        }
        return i;
    }
    private Double getDouble(String prompt){
        Double d = null;
        while(true){
            try{
                String input = getString(prompt);
                if(input != null && !input.isEmpty()) d = Double.parseDouble(input);
                break;
            } catch(Exception e){
                System.err.println("Invalid Input");
            }
        }
        return d; 
    }

    private Menu createMainMenu() {
        mainMenu = new Menu();
        mainMenu.addMenuItem(new MenuItem("Exit", this::exit));
        mainMenu.addMenuItem(new MenuItem("Place Order", this::placeOrder));
        mainMenu.addMenuItem(new MenuItem("Welcome new Customer", this::newCustomer));
        mainMenu.addMenuItem(new MenuItem("Define new Tool", this::newTool));
        mainMenu.addMenuItem(new MenuItem("Define new Plant", this::newPlant));
        mainMenu.addMenuItem(new MenuItem("Switch View", this::switchView));
        return mainMenu;
    }

    private Store store;
    private View view;
    private Menu mainMenu;
    private String output;
    private boolean isRunning;
    private Scanner in;
    private static final String clearscreen = "\n".repeat(255);
}