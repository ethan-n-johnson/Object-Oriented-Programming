public class Customer {
    public Customer(String name, String email){
        this.name = name;
        if(name.contains("@") && email.indexOf("@") >= email.lastIndexOf(".")){
            this.email = email;
        }
        else{
            throw new IllegalArgumentException("Invalid email address: " + email);
        }
    }
    @Override
    public String toString(){
        String formattedString = String.format("%s (%s)", name, email);
        return formattedString;
    }
    private String name;
    private String email;
}
