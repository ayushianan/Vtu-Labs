import java.util.*;
public class pro5
{
  static int max = 5000;
  public static void mergesort(int a[],int low,int high)
  {
    int mid;
    if(high>low)
    {
      mid = (low+high)/2;
      mergesort(a,low,mid);
      mergesort(a,mid+1,high);
      merge(a,low,mid,high);
      
    }
  }
  public static void merge(int a[],int low,int mid,int high)
  {
    int k=low,j=mid+1,i=low;
    int c[] = new int[1000];

    while(i<=mid && j<=high)
    {
      if(a[i]<=a[j])
      {
        c[k]=a[i];
        i++;
      }
      else
      {
        c[k]= a[j];
        j++;
      }
      k++;
    }
    while(i<=mid)
    {
      c[k]= a[i];
      k++;
      i++;
    }
    while(j<=high)
    {
      c[k]=a[j];
      k=k+1;
      j=j+1;
    }
    for(i=low;i<=high;i++)
    a[i]=c[i];
  }
  public static void main(String args[])
  {
    int i,n;
    Scanner in = new Scanner(System.in);
    Random rand = new Random();
    System.out.println("MergeSort");

    System.out.println("Enter number of elements");
    n = in.nextInt();
    int arr[] = new int[max];
    try
    {
       for(i=0;i<n;i++)
        arr[i]=rand.nextInt(100);
      System.out.println("The random elements are:");
      for(i=0;i<n;i++)
        System.out.println(arr[i]+" ");
      long start_time = System.nanoTime();
      mergesort(arr, 0, n-1);
      long end_time = System.nanoTime();
      System.out.println("The elements after sorting ");
      for(i=0;i<n;i++)
        System.out.println( arr[i]+" ");
      long t = end_time - start_time;
      System.out.println("time taken in execution is "+t+"nanoseconds");

    }
    catch(ArrayIndexOutOfBoundsException ae)
    {
      System.out.println("Array index reached maximum");
    }
  }
}