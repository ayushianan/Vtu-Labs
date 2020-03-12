import java.util.*;
public class pro3a
{
  public static void main(String args[])
  {
    int a,b,d;
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the value a ");
    a=in.nextInt();
    System.out.println("Enter the value b ");
    b= in.nextInt();
    try
    {
      d=a/b;
      System.out.println("\nThe Result of "+a+"/"+b+" is "+d);
    }
    catch(ArithmeticException ae)
    {
      System.out.println("Division by zero ");
    }
  }
}
