import java.util.*;
public class pro4
{
    static int max= 5000;
  public static int partition(int arr[],int low,int high)
  {
      int key = arr[low];
      int i = low;
      int j= high+1;
      while(i<=j)
      {
        do
        {
           i++;
        }while(key>=arr[i] && i<=high);

        do
        {
          j--;
        } while(key<arr[j]);
        if(i<j)
        {
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
      int temp = arr[low];
      arr[low] = arr[j];
      arr[j] = temp;
      return j;
  }
public static void qs(int arr[],int low,int high)
{
  int mid;
  if(low<high)
  {
    mid = partition(arr, low, high);
    qs(arr,low,mid-1);
    qs(arr,mid+1,high);
  }
}
public static void main(String args[])
{
  int n,i;

  Scanner in = new Scanner(System.in);
  Random rand = new Random();
  System.out.println("\n Enter the number of elements");
  n = in.nextInt();
  int arr[] = new int[max];
  try
  {
    for(i=0;i<n;i++)
      arr[i]=rand.nextInt(100);
    System.out.println("\nThe random elements are: ");
    for(i=0;i<n;i++)
    System.out.println(arr[i]+" ");
    long start_time = System.nanoTime();
    qs(arr,0,n-1);
    long end_time = System.nanoTime();
    System.out.println("\n The elements after sorting ");
    for(i=0;i<n;i++)
    System.out.println(arr[i]+" ");
    long t = end_time - start_time;
    System.out.println("Time taken for execution is "+t+" nanoseconds");
  }
  catch(ArrayIndexOutOfBoundsException ae)
  {
    System.out.println("Array Index reached maximum");
  }
  }
}
