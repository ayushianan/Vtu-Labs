import java.util.*;
public class pro12 {
	static int x[]=new int[100];
	static int g[][]=new int[100][100];
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);int i,j;
		System.out.println("Enter no. of vertices");
		int n=in.nextInt();
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				g[i][j]=0;
				x[i]=0;
			}
		}
		System.out.println("Vertices");
		int x1,x2;
		int edge=in.nextInt();
		for(i=1;i<=edge;i++)
		{
				x1=in.nextInt();
				x2=in.nextInt();
				g[x1][x2]=1;
				g[x2][x1]=1;
		}
		x[1]=1;
		hcycle(g,n,2);
	}
	public static void hcycle(int g[][],int n,int k)
	{
		while(true)
		{
		nextvalue(g,n,k);
		int i;
		if(x[k]==0)
			return;
		if(k==n)
		{
			for(i=1;i<=n;i++)
			{
			System.out.println(x[i]);
			}
			System.out.println(x[1]);
		}
		else
			hcycle(g,n,k+1);
		}
	}
	public static void nextvalue(int g[][],int n,int k)
	{
		int j;
		while(true)
		{
			x[k]=(x[k]+1)%(n+1);
			if(x[k]==0)
				return;
			if(g[x[k-1]][x[k]]==1)
			{
				for(j=1;j<=k-1;j++)
				{
					if(x[j]==x[k])
						break;
				}
				if(j==k)
				{
					if((k<n||k==n&&g[x[n]][x[1]]==1))
					{
						return;
					}
					
				}
			}
			
		}
	}

}
