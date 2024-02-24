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
    }
    public void mdi()
    {
        while(isRunning){
            try{
                mainMenu.run(selectFromMenu());

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
        System.out.println("\n\nPlacing an Order\n----------------\n");
        System.out.println(store.getCustomerList());
        int customerIndex = getInt("Which Customer?\n> ") - 1;
        if(customerIndex < 0) {
            System.out.println("Invalid customer selection.\nPlease try again\n");
            placeOrder();
        }
        int orderNumber = store.newOrder(customerIndex);
        System.out.println("Product List:");
        System.out.print(store.getProductList());
        int productIndex = 0;
        while(productIndex != -1){
            productIndex = getInt("Select product (0 to quit)\n> ") - 1;
            if(productIndex < -1) System.out.println("Invalid product selection.");
            else if(productIndex == -1){}
            else{
                int quantity = getInt("Enter quantity\n> ");
                store.addToOrder(orderNumber, productIndex, quantity);
            }
        }
        output = "Order placed successfully.";
        view = View.ORDERS;
    }
    private void newCustomer(){
        String customerName = getString("Enter the name of the customer\n> ");
        String customerEmail = getString("Enter the email of the customer\n> ");
        Customer customer = new Customer(customerName, customerEmail);
        store.addCustomer(customer);
        output = "Customer added successfully";
        view = View.CUSTOMERS;
    }
    private void newTool(){
        String toolName = getString("Enter the name of the tool\n> ");
        int toolPrice = getInt("Enter the price of the tool\n> ");
        Tool tool = new Tool(toolName, toolPrice);
        store.addProduct(tool);
        output = "Product added successfully";
        view = view.PRODUCTS;
    }
    private void newPlant(){
        String plantSpecies = getString("Enter the species of the plant\n> ");
        int plantPrice = getInt("Enter the price of the plant\n> ");
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
        
        Plant plant = new Plant(plantSpecies, plantPrice, exposure);
        store.addProduct(plant);
        output = "Product added successfully";
        view = View.PRODUCTS;
    }
    private void switchView(){
        boolean viewNotAssigned = true;
        System.out.println("Switching View\n--------------\n");
        System.out.println("1] Customers");
        System.out.println("2] Orders");
        System.out.println("3] Products\n");
        do{
            switch(getInt("Select an option\n> ");){
                case 1:
                    View = View.CUSTOMERS;
                    viewNotAssigned = false;
                    break;
                case 2:
                    View = View.PRODUCTS;
                    viewNotAssigned = false;
                    break;
                case 3:
                    view = View.ORDERS;
                    viewNotAssigned = false;
                    break;
                default:
                    System.out.println("Invalid View");
            }
        } while(viewNotAssigned);
    }
    private String getView(){
        switch(view){
            case CUSTOMERS:
                System.out.print(store.getCustomerList());
                break;
            case PRODUCTS:
                System.out.print(store.getProductList());
                break;
            case ORDERS:
                System.out.print(store.getOrderList());
                break; 
        }
        return "Invalid View";
    }
    private Integer selectFromMenu(){
        System.out.println(clearscreen + store.getName() + " Main Menu\n"+ mainMenu);
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
        mainMenu.addMenuItem(new MenuItem("Exit", () -> exit()));
        mainMenu.addMenuItem(new MenuItem("Place Order", () -> placeOrder()));
        mainMenu.addMenuItem(new MenuItem("Welcome new Customer", () -> newCustomer()));
        mainMenu.addMenuItem(new MenuItem("Define new Tool", () -> newTool()));
        mainMenu.addMenuItem(new MenuItem("Define new Plant", () -> newPlant()));
        mainMenu.addMenuItem(new MenuItem("Switch View", () -> switchView()));
        return mainMenu;
    }

    public void createTestStore() {
        Customer c1 = new Customer("Prof Rice", "george.rice@uta.edu");
        Customer c2 = new Customer("President Joe Biden", "president@whitehouse.gov");
        Customer c3 = new Customer("The Late Queen Elizabeth II", "queen@royal.gov.uk");
        Customer c4 = new Customer("Mark Zuckerberg", "mark.zuckerberg@facebook.com");
        store.addCustomer(c1);
        store.addCustomer(c2);
        store.addCustomer(c3);
        store.addCustomer(c4);

        Plant p1 = new Plant("Cactus Cereus Peruvianus", 4990, Exposure.SHADE);
        Plant p2 = new Plant("'White Princess' Philodendron", 5500, Exposure.SUN);
        Tool t1 = new Tool("Bypass Pruners", 2299);
        Tool t2 = new Tool("Large Gardener's Cart", 34900);
        store.addProduct(p1);
        store.addProduct(p2);
        store.addProduct(t1);
        store.addProduct(t2);
    }

    private Store store;
    private View view;
    private Menu mainMenu;
    private String output;
    private boolean isRunning;
    private Scanner in;
    private static final String clearscreen = "\n".repeat(255);
}