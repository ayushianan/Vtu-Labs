import java.util.*;
public class pro10a 
{
	public static int min(int a,int b)
	{
		return a<b?a:b;
	}
	public static void floyd(int n,int a[][])
	{
		int i,j,k;
		int d[][]=new int[10][10];
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				d[i][j]=a[i][j];
			}
		}
		for(k=1;k<=n;k++)
		{
			for(i=1;i<=n;i++)
			{
				for(j=1;j<=n;j++)
				{
					d[i][j]=min(d[i][j],d[i][k]+d[k][j]);
				}
			}
		}
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				System.out.print(+d[i][j]+" ");
			}
			System.out.println("\n");
		}
	}
	public static void main(String args[])
	{
		int n,i,j;
		Scanner in=new Scanner(System.in);
		int a[][]=new int[10][10];
		System.out.println("number");
		n=in.nextInt();
		System.out.println("cost");
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				a[i][j]=in.nextInt();
			}
		}
		floyd(n,a);
	}

}
