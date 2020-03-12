import java.util.*;
public class pro10b {
	final static int max=100;
	final static int INFINITY=999;
	static int tour[]=new int[100];
	public static int tsp_dp(int c[][],int tour[],int start,int n)
	{
		int i,j;
		int temp[]=new int[100];
		int mintour[]=new int[100];
		int ccost=0;
		if(start==n-2)
			return(c[tour[n-2]][tour[n-1]]+c[tour[n-1]][0]);
		int min_cost=INFINITY;
		int k;
		for(i=start+1;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				temp[j]=tour[j];
			temp[start+1]=tour[i];
			temp[i]=tour[start+1];
			}
			if(c[tour[start]][tour[i]]+(ccost=tsp_dp(c,temp,start+1,n))<min_cost)
			{
				min_cost=ccost+c[tour[start]][tour[i]];
				for(k=0;k<n;k++)
				{
					mintour[k]=temp[k];
				}
			}
		}
		for(i=0;i<n;i++)
			tour[i]=mintour[i];
		tour[i]=start;
		return min_cost;
	}
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n;int i,j;int cost[][]=new int [20][20];
		
		System.out.println("number");
		n=in.nextInt();
		System.out.println("cost");
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				cost[i][j]=in.nextInt();
			}
		}
		for(i=0;i<n;i++)
		{
			tour[i]=i;
		}
		int totalcost=tsp_dp(cost,tour,0,n);
		System.out.println("Total"+totalcost);
		for(i=0;i<n;i++)
			System.out.println(tour[i]+"\n");
	}

}
