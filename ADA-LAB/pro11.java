import java.util.*;
public class pro11 {
	static int w[]=new int[100];
	static int d;static int count=0;
	static int x[]=new int[100];
	public static void main(String args[])
	{
		Scanner in =new Scanner(System.in);
		int i,n;int sum=0;
		System.out.println("Enetr the no. of elements");
		n=in.nextInt();
		System.out.println("elements");
		for(i=0;i<n;i++)
			w[i]=in.nextInt();
		System.out.println("enter the sum");
		d=in.nextInt();
		for(i=0;i<n;i++)
			sum=sum+w[i];
		if(sum<d)
			System.out.println("no solution");
		subset(0,0,sum);
		if(count==0)
		{
			System.out.println("no\n");
			return;
		}
	}
	public static void subset(int cs,int k,int r)
	{
		x[k]=1;
		if(cs+w[k]==d)
		{
			System.out.println("Subset"+(++count));
			for(int i=0;i<=k;i++)
			{
				if(x[i]==1)
					System.out.println(w[i]+" ");
			}
		}
		else if(cs+w[k]+w[k+1]<=d)
		{
			subset(cs+w[k],k+1,r-w[k]);
		}
		if(cs+r-w[k]>=d&&cs+w[k]<=d)
		{
			x[k]=0;
			subset(cs,k+1,r-w[k]);
		}
	}

}
