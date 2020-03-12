import java.util.*;
public class Pro1
{
  String usn;
  String name;
  String branch;
  long phone;

  void getDetails()
  {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the Student's USN ");
    usn = input.nextLine();
    System.out.println("Enter the Student's Name ");
    name = input.nextLine();
    System.out.println("Enter the Student's branch ");
    branch = input.nextLine();
    System.out.println("Enter the Student's phone number");
    phone = input.nextLong();
  }

  void putDetails()
  {
    System.out.println("\n\t USN:"+usn+"\n\t Name:"+name+"\n\t Branch:"+branch+"\n\t Phone:"+phone);
    System.out.println("\n");
  }
  public static void main(String args[])
  {
    int i,n;
    System.out.println("Enter the number of the Students ");
    Scanner input = new Scanner(System.in);
    n = input.nextInt();
    Pro1 a[]= new Pro1[n];

    for(i=0;i<n;i++)
    {
      a[i] = new Pro1();
    }
    for(i=0;i<n;i++)
    {
      System.out.println("\nEnter details of student"+(i+1));
      a[i].getDetails();
    }
    for(i=0;i<n;i++)
    {
      System.out.println("\nThe details of student "+(i+1));
      a[i].putDetails();
    }
  }
}
