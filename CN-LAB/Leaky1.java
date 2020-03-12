import java.io.*;
import java.util.*;
public class Leaky1 {
	public static void main(String args[])throws IOException
	{
		Scanner in=new Scanner(System.in);
		int bucket_size;
		int no_grps;
		System.out.println("Enter bucket size:");
		bucket_size=in.nextInt();
        System.out.println("Enter no. of groups:");
		no_grps=in.nextInt();
		int no_packets[]=new int[no_grps];
		int in_bw[]=new int[no_grps];
		int tot_packets=0;
		int reqd_bw=0;
		for(int i=0;i<no_grps;i++)
		{
			System.out.println("Enter no. of packets for group " + (i+1) + ":");
            no_packets[i] = in.nextInt();
            System.out.println("Enter input bandwidth for group " + (i+1) + ":");
            in_bw[i] = in.nextInt();
            if(tot_packets+no_packets[i]<=bucket_size)
            {
            	tot_packets+=no_packets[i];
            }
            else
            {
            	do
            	{
            		System.out.println("Bucket overflow!");
                    System.out.println("Enter value less than " + (bucket_size - tot_packets) + ":");
                    no_packets[i] = in.nextInt();
            	}while(tot_packets+no_packets[i]>bucket_size);
            	tot_packets+=no_packets[i];
            }
            reqd_bw+=no_packets[i]*in_bw[i];
		}
		System.out.println("\nThe total required bandwidth is " + reqd_bw);
        System.out.println("Enter the output bandwidth:");
        int out_bw = in.nextInt();
		int temp=tot_packets;
		int bw=reqd_bw;
		while(out_bw<=bw && temp>0)
		{
			System.out.println("\nData sent");
            System.out.println("Remaining packets " + (--temp));
            System.out.println("Remaining bandwidth " + (bw -= out_bw));
            if(out_bw>bw&&temp>0)
                System.out.println(temp+ " packet(s) discarded due to insufficient bandwidth");
		}

	}

}
