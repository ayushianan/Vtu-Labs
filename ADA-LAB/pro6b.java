import java.util.*;
public class pro6b {
	
	public static void knapsack(int n,int item[],float weight[],float profit[],float capacity)
	{
		int i;
		float x[]=new float[100];
		float tp=0;float u;
		u=capacity;
		for(i=0;i<n;i++)
		{
			x[i]=(float)0.0;
		}
		for(i=0;i<n;i++)
		{
			if(weight[i]>u)
			{
				break;
			}
			else
			{
				x[i]=(float)1.0;
				tp=tp+profit[i];
				u=(int)(u-weight[i]);
			}
		}
		//int p=(int)u;
		if(i<n)
			x[i]=u/weight[i];
		tp=tp+(x[i]*profit[i]);
		for(i=0;i<n;i++)
		System.out.println(item[i]+" "+x[i]);
		System.out.println("profit"+tp);
	}
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n;
		n=in.nextInt();
		int item[]=new int[100];
		float weight[]=new float[100];
		float profit[]=new float[100];
		float ratio[]=new float[100];
		for(int i=0;i<n;i++)
		{
			item[i]=in.nextInt();
			weight[i]=in.nextInt();
			profit[i]=in.nextInt();
		}
		System.out.println("Capacity");
		int capacity=in.nextInt();
		for(int i=0;i<n;i++)
		{
			ratio[i]=profit[i]/weight[i];
		}
		float temp;
		int temp1;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(ratio[i]<ratio[j])
				{
					temp=ratio[i];
					ratio[i]=ratio[j];
					ratio[j]=temp;
					temp1=item[i];
					item[i]=item[j];
					item[j]=temp1;
					temp=weight[i];
					weight[i]=weight[j];
					weight[j]=temp;
					temp=profit[i];
					profit[i]=profit[j];
					profit[j]=temp;
				}
			}
		}
		knapsack(n,item,weight,profit,capacity);
	}

}
