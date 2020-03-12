import java.util.*;
public class pro8 {
	static int s[]=new int[100];
	public static int find(int v,int s[])
	{
		if(s[v]!=v)
			v=s[v];
		return v;
	}
	public static void union(int i,int j,int s[])
	{
		s[i]=j;
	}
	public static void krushkal(int n,int c[][])
	{
		int i,j,u,v;int k=0;int sum=0;u=0;v=0;
		int t[][]=new int[10][2];
		for(i=0;i<n;i++)
		{
			s[i]=i;
		}
		int min;
		int count=0;
		while(count<n-1)
		{
			min=999;
			for(i=0;i<n;i++)
			{
				for(j=0;j<n;j++)
				{
					if(c[i][j]!=0&&c[i][j]<min)
					{
						min=c[i][j];
						u=i;
						v=j;
					}
				}
			}
			if(min==999)break;
			i=find(u,s);
			j=find(v,s);
			if(i!=j)
			{
				t[k][0]=u;
				t[k][1]=v;
				k++;
				count++;
				sum=sum+min;
				union(i,j,s);
			}
			c[u][v]=c[v][u]=999;
		}
		if(count==n-1)
		{
			System.out.println("Sum"+sum);
			for(i=0;i<n;i++)
			{
				System.out.println(t[i][0]+" "+t[i][1]+"\n");
			}
		}
		else
		{
			System.out.println("no");
		}
	}
	public static void main(String args[])
	{
		int n,i,j;
		Scanner in=new Scanner(System.in);
		int c[][]=new int[10][10];
		System.out.println("number");
		n=in.nextInt();
		System.out.println("cost");
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				c[i][j]=in.nextInt();
			}
		}
		krushkal(n,c);
	}

}
