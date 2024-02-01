public class Customer {
    public Customer(String name, String email){
        this.name = name;
        if(name.contains("@") && email.substring(email.indexOf("@")).contains(".")){
            this.email = email;
        }
        else{
            throw new IllegalArgumentExpection("Invalid email address: " ++ email);
        }
    }
    @Override
    public String toString() {
        return name + "(" + email ")";
    }
    private String name;
    private String email;
}
