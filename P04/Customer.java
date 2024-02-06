public class Customer {
    public Customer(String name, String email){
        this.name = name;
        if(!email.contains("@") || email.indexOf("@") >= email.lastIndexOf(".")){
            throw new IllegalArgumentException("Invalid email address: " + email);
        }
        this.email = email;
    }
    @Override
    public String toString(){
        String formattedString = String.format("%s (%s)", name, email);
        return formattedString;
    }
    private String name;
    private String email;
}
