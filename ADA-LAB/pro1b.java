import java.util.*;
class pro1b
{
  int top;
  int size;
  int stack[];
  public pro1b(int arraySize)
  {
    size = arraySize;
    stack = new int[size];
    top= -1;
  }
  public void push(int value)
  {
    if(top==size-1)
    {
      System.out.println("Stack is full, can't push a value");
    }
    else
    {
      top = top+1;
      stack[top]=value;
    }
  }
  public int pop()
  {
    int t;
    if(top==-1)
    {
      System.out.println("Stack is empty");
      return -1;
    }
    else
    {
      return stack[top--];
    }
  }
  public void display()
  {
    for(int i=top;i>-1;i--)
    {
        System.out.print(stack[i]+" ");
    }
    System.out.println("\n");
  }

  public static void main(String args[])
  {
    Scanner in= new Scanner(System.in);
    System.out.println("Enter the Size of Stack\n");
    int n = in.nextInt();
    int choice;
    pro1b stk = new pro1b(n);
    do
    {
      System.out.println("\nStack operations");
      System.out.println("1.Push");
      System.out.println("2. Pop");
      System.out.println("3. display");
      System.out.println("\nEnter your Choice");
      int ch = in.nextInt();
      switch(ch)
      {
        case 1: System.out.println("\nEnter the element to push");
                stk.push(in.nextInt());
                break;
        case 2: int s = stk.pop();
                if(s!=-1)
                System.out.println("Popped element="+s);
                break;
        case 3: stk.display();
                break;
      }
      System.out.println("\nPress 1 to continue");
      choice = in.nextInt();
    }

    while(choice==1);
  }
}