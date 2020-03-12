import java.util.*;
class Staff
{
  int staffid;
  String name;
  long phone;
  float salary;
  void getSdetails()
  {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter Staff Name\n ");
    name= in.nextLine();
    System.out.println("Enter staff id\n");
    staffid = in.nextInt();
    System.out.println("Enter phone number\n ");
    phone= in.nextLong();
    System.out.println("Enter salary\n ");
    salary=in.nextFloat();
  }
  void putSdetails()
  {
    System.out.println("StaffId:"+ staffid);
    System.out.println("Staff Name:"+ name);
    System.out.println("Phone Number:"+ phone);
    System.out.println("Salary:"+ salary);
    System.out.println("\n");
  }
}
class pro2a
{
    public static void main(String args[])
    {
      int i,n;
      System.out.println("Enter the number of Staff");
      Scanner in = new Scanner(System.in);
      n= in.nextInt();
      Staff sf[] = new Staff[n];
      Teaching t[] = new Teaching[n];
      Technical t1[] = new Technical[n];
      Contract c[] = new Contract[n];
      for(i=0;i<n;i++)
      {
        sf[i] = new Staff();
        t[i] = new Teaching();
        t1[i] = new Technical();
        c[i] = new Contract();
      }
      for(i=0;i<n;i++)
      {
        System.out.println("Enter the details of staff"+(i+1));
        sf[i].getSdetails();
        t[i].getTdetails();
        t1[i].getT1details();
        c[i].getCdetails();
      }
      System.out.println(".................");
      for(i=0;i<n;i++)
      {
        System.out.println("The details of staff"+(i+1));
        sf[i].putSdetails();
        t[i].putTdetails();
        t1[i].putT1details();
        c[i].putCdetails();
      }
      System.out.println(".................");

    }
}


class Teaching extends Staff
{
  String domain;
  String publication;

  void getTdetails()
  {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the domain");
    domain= in.nextLine();
    System.out.println("Enter Publication");
    publication = in.nextLine();
  }
  void putTdetails()
  {
    System.out.println("Domain:"+ domain);
    System.out.println("Publication:"+ publication);
    System.out.println("\n");
  }
}
class Technical extends Staff
{
  String skills;
  void  getT1details()
  {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the skills");
    skills = in.nextLine();
  }
  void putT1details()
  {
    System.out.println("Skills:"+ skills);
    System.out.println("\n");
  }
}
class Contract extends Staff
{
  String period;
  void getCdetails()
  {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the Period");
    period = in.nextLine();
  }
  void putCdetails()
  {
    System.out.println("Period:"+ period);
    System.out.println("\n");
  }
}
