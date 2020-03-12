import java.io.*;
import java.net.*;
public class serverc1 {
	public static void main(String args[])throws IOException
	{
		Socket sock=new Socket("127.0.0.1",4003);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String fname=br.readLine();
		OutputStream ostream=sock.getOutputStream();
		PrintWriter pwrite=new PrintWriter(ostream,true);
		pwrite.println(fname);
		InputStream istream=sock.getInputStream();
		BufferedReader br1=new BufferedReader(new InputStreamReader(istream));
		String str;
		while((str=br1.readLine())!=null)
		{
			System.out.println(str);
		}
		sock.close();
		br.close();
		br1.close();
		pwrite.close();
	}
}
