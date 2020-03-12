import java.util.*;
public class pro3b {
	public static void main(String args[])
	{
		multithread t3=new multithread("first");
		t3.start();
	}
}
class multithread extends Thread
{
	String name;
	public multithread(String x)
	{
		name=x;
	}
	int num=0;Thread t1,t2;
	Random rand=new Random();
	public void run()
	{
		try
		{
			for(int i=0;i<10;i++)
			{
				num=rand.nextInt(100);
				System.out.println("Selcted");
				System.out.println(num);
				if(num%2==0)
				{
					t1=new Thread(new even(num));
					t1.start();
				}
				else
				{
					t2=new Thread(new odd(num));
					t2.start();
				}
			}
			Thread.sleep(1000);
			System.out.println("----------");
		}
		catch(InterruptedException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
}
class even implements Runnable
{
	public int n;
	even(int x)
	{
		n=x;
	}
	public void run()
	{
		System.out.println("thread even"+n*n);
	}
}
class odd implements Runnable
{
	public int n;
	odd(int x)
	{
		n=x;
	}
	public void run()
	{
		System.out.println("thread odd"+n*n*n);
	}
}



