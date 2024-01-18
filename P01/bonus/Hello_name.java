import java.util.Scanner;

public class Hello_name 
{
    public static void main(String[] args) 
    {
        Scanner MyScan = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = MyScan.nextLine();
        System.out.println("hello, " + name);
        MyScan.close();
    }
}