public class TestCustomer{
    public static void main(String[] args)
    {
        int failureCode = 0;
        String name = "Grover McDonald";
        String email = "Grovers_farm@realemail.com";
        Customer c1 = new Customer(name, email);
        String stringTest = String.format("%s (%s)", name, email);
        
        if (!c1.toString().equals(stringTest)){
            failureCode = failureCode+1;
            System.err.println("Error Invalid string\nexpected: " + stringTest + " provided: " + c1.toString());
        }
        try{
            Customer c2 = new Customer(name, "Grover.s.farmrealemail.com");
        }
        catch(IllegalArgumentException e){
            System.err.println("1st Exception Caught");
        }
        catch(Exception e)
        {
            System.err.println("Error: Unexpected exception");
            failureCode = failureCode+10;
        }

        try{
            Customer c2 = new Customer(name, "Grover.s.farm@realemail");
        }
        catch(IllegalArgumentException e){
            System.err.println("2nd Exception Caught");
        }
        catch(Exception e)
        {
            System.err.println("Error: Unexpected exception");
            failureCode = failureCode+100;
        }
        System.exit(failureCode);
    }
}