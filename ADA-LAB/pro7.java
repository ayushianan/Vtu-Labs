import java.util.*;
public class pro7 {
	static int d[]=new int[50];
	static int s[]=new int[50];
	public static int findmin(int n)
	{
		int min=0;
		for(int i=1;i<=n;i++)
		{
			if(s[i]==0)
			{
				min=i;
				break;
			}
		}
		for(int i=1;i<=n;i++)
		{
			if(d[min]>d[i]&&s[i]==0)
			{
				min=i;
			}
		}
		return min;
		
	}
	public static void dijkstra(int n,int w[][],int v)
	{
		int p[]=new int[50];
		for(int i=1;i<=n;i++)
		{
			s[i]=0;
			p[i]=0;
			d[i]=999;
		}
		d[v]=0;
		int u;
		int w1;
		for(int k=1;k<=n;k++)
		{
			u=findmin(n);
			s[u]=1;
			for(w1=1;w1<=n;w1++)
			{
				if(w[u][w1]!=999&&s[w1]==0)
				{
					if(d[w1]>d[u]+w[u][w1])
					{
						
						d[w1]=d[u]+w[u][w1];
						p[w1]=u;
					}
				}
			}
			
		}
		System.out.println("Group of paths");
		for(int i=1;i<=n;i++)
		{
			if(d[i]!=999)
			{
				System.out.println(v+"---"+i+"is"+d[i]+"\n");
			}
			else
			{
				System.out.println("no");
			}

		}
		int j,i;
		for(i=1;i<=n;i++)
		{
			if(i!=v&&d[i]!=999)
			{
			System.out.println(i);
			j=p[i];
			while(p[j]!=0)
			{
				System.out.println("<--"+j+" ");
				j=p[j];
			}
			System.out.println("<---"+v+" ");
			}
		}
	}
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		pro7 d1=new pro7();
		int w[][]=new int[50][50];
		System.out.println("number");
		int n=in.nextInt();
		System.out.println("cost");
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				w[i][j]=in.nextInt();
			}
		}
		System.out.println("source");
		int v=in.nextInt();
		d1.dijkstra(n,w,v);
	}

}
