import java.util.*;
import java.util.StringTokenizer;
public class pro2b
{
  String str;
  public String read()
  {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the name and DOB in <name,dd/mm/yyyy> format");
    str = in.next();
    if(!str.startsWith("<")||!str.endsWith(">"))
    {
      System.out.println("Please enter in proper format");
      System.exit(0);
    }
    return str;
  }
  void display(String data)
  {
    String st = data.substring(0,data.length());
    StringTokenizer token = new StringTokenizer(st,"<,/,>");
    String finalString = null;
    while(token.hasMoreTokens())
    {
      if(finalString==null)
      {
        finalString = token.nextToken();
      }
      else
      {
        finalString = finalString+","+token.nextToken();
      }
    }
    System.out.println("The resultant string is "+"<"+finalString+">");
  }
  public static void main(String args[])
  {
    pro2b c = new pro2b();
    String data = c.read();
    c.display(data);
  }

}