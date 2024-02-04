public class TestCustomer{
    public static void main(String[] args)
    {

        String name = "Grover McDonald";
        String email = "Grovers_farm@realemail.com";
        Customer c1 = new Customer(name, email);
        String stringTest = String.format("%s (%s)", name, email);
        
        if (!c1.toString().equals(stringTest)){
            failureCode = failureCode+1;
            System.err.println("Error Invalid string\nexpected: " + stringTest + " provided: " + c1.toString());
        }
        try{
            Customer c2 = new Customer(name, "Grover.s.farm@realemail.com");
        }
        catch(IllegalArgumentException e){
            //
        }
        System.exit(failureCode);
    }
}