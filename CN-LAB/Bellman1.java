import java.io.*;
import java.util.Scanner;
class Edge1
{
	int source;
	int dest;
	int weight;
}
public class Bellman1 {
	public static void BellmanFord(Edge1 edge[],int edgecount,int nodecount,int source)
	{
		int distance[] =new int[nodecount];
		int infinity=500000;
		for(int i=0;i<nodecount;i++)
			distance[i]=infinity;
		distance[source]=0;
		for(int i=0;i<nodecount;i++)
		{
			boolean somethingchanged=false;
			for(int j=0;j<edgecount;j++)
			{
				if(distance[edge[j].source]!=infinity)
				{
					int new_distance=edge[j].weight+distance[edge[j].source];
					if(new_distance<distance[edge[j].dest])
					{
						distance[edge[j].dest]=new_distance;
						somethingchanged=true;
					}
				}
			}
			if(!somethingchanged)
				break;
		}
		for(int i=0;i<edgecount;i++)
			{
				if(distance[edge[i].dest]>distance[edge[i].source]+edge[i].weight);
			}
			for(int i=0;i<nodecount;i++)
			{
				System.out.println("Distance from "+source+"to"+(i)+"is"+distance[i]);
			}
	}
	public static void main(String args[])throws IOException
	{
		Scanner in=new Scanner(System.in);
		Edge1 edge[]=new Edge1[16];
		for(int i=0;i<16;i++)
		{
			edge[i]=new Edge1();
			System.out.println("Enter source no"+"["+i+"]");
			edge[i].source=in.nextInt();
			System.out.println("Enter dest no"+"["+i+"]");
			edge[i].dest=in.nextInt();
			System.out.println("Enter source no"+"["+i+"]");
			edge[i].weight=in.nextInt();	
		}
		BellmanFord(edge,16,4,1);
	}

}
