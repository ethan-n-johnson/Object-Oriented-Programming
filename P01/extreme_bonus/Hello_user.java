public class Hello_user 
{
    public static void main(String[] args) 
    {
        String systemName = System.getProperty("user.name");
        System.out.println("hello, " + systemName);
    }
}