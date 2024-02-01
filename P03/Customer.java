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
    public String toString(){
        String formattedString = String.format("%s (%s)", name, email);
        return formattedString;
    }
    private String name;
    private String email;
}
