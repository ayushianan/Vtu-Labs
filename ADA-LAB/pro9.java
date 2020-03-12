import java.util.*;
public class pro9 {
	public static void main(String args[])
	{
		int n,i,j;int a=0;int b=0;int u=0;int v=0;int min_cost=0;
		Scanner in=new Scanner(System.in);
		int cost[][]=new int[20][20];
		int visited[]=new int[20];
		int source;
		System.out.println("number");
		n=in.nextInt();
		System.out.println("cost");
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				cost[i][j]=in.nextInt();
			}
		}
		for(i=1;i<=n;i++)
		{
			visited[i]=0;
		}
		System.out.println("enter source\n");
		source=in.nextInt();
		int ne=1;int min;
		visited[source]=1;
		while(ne<n)
		{
			min=999;
			for(i=1;i<=n;i++)
			{
				for(j=1;j<=n;j++)
				{
					if(cost[i][j]<min)
						if(visited[i]==0)
							continue;
					else
					{
						min=cost[i][j];
						a=u=i;
						b=v=j;
					}
				}
			}
			if(visited[u]==1||visited[v]==0)
			{
				ne++;
				System.out.println(ne+" "+a+" "+b+" "+min+"\n");
				min_cost=min_cost+min;
				visited[b]=1;
				
			}
			cost[a][b]=cost[b][a]=999;
		}
		System.out.println("Sum"+min_cost);
	}

}
