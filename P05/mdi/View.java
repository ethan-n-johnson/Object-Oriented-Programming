package mdi;
enum View{
    CUSTOMERS, ORDERS, PRODUCTS; 
        
    @Override
    public String toString() {
        switch (this) {
            case CUSTOMERS: return "Customers";
            case ORDERS: return "Orders";
            case PRODUCTS: return "Products";
        }
        return "Error view invalid";
    }
}