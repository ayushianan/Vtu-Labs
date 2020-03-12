import java.util.*;
public class pro6a {
	static int b[]=new int[100];
	static int v[][]=new int[100][100];
	static int w[]=new int[100];
	static int value[]=new int[100];


	public static int max(int a,int b)
	{
		return(a>b)?a:b;
	}
	public static int knap(int i,int j)
	{
		if(i==0||j==0)
			v[i][j]=0;
		else if(j<w[i])
			v[i][j]=knap(i-1,j);
		else
			v[i][j]=max(knap(i-1,j),value[i]+knap(i-1,j-w[i]));
		return v[i][j];
		
	}
	public static void optimal(int i,int j)
	{
		if(i>=1||j>=1)
			if(v[i][j]!=v[i-1][j])
			{
				System.out.println("Item"+i);
				j=j-w[i];
				b[i]=1;
				optimal(i-1,j);
			}
			else
			{
				optimal(i-1,j);
			}
	}
	
	public static void main(String args[])
	{
		Scanner in =new Scanner(System.in);
		int n,w1;
		System.out.println("Enter no. of items");
		n=in.nextInt();
		System.out.println("Enter no. of capacity");
		w1=in.nextInt();
		System.out.println("Enter values");
		for(int i=1;i<=n;i++)
		{
			value[i]=in.nextInt();
		}
		System.out.println("Enter weights");
		for(int i=1;i<=n;i++)
		{
			w[i]=in.nextInt();
		}
		int profit=knap(n,w1);
		System.out.println(profit);
		optimal(n,w1);
		for(int i=1;i<=n;i++)
		{
			System.out.println(b[i]);
		}
	}

}
