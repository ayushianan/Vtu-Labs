import java.io.*;
import java.net.*;
import java.net.ServerSocket;
import java.net.Socket;
public class servers1 {
	public static void main(String args[])throws IOException
	{
	ServerSocket sersock = new ServerSocket(4003);
    System.out.println("Server ready for connection");

    Socket sock = sersock.accept();
    System.out.println("Connection is successful");

//    Get file name from client
    InputStream istream = sock.getInputStream();
    BufferedReader nameRead = new BufferedReader(new InputStreamReader(istream));
    String fname = nameRead.readLine();
    BufferedReader contentRead = new BufferedReader(new FileReader(fname));
    OutputStream ostream = sock.getOutputStream();
    PrintWriter pwrite = new PrintWriter(ostream, true);

    String str;

    while((str = contentRead.readLine()) != null) {
        pwrite.println(str);
    }

    sersock.close();
    sock.close();

    nameRead.close();
    contentRead.close();
    pwrite.close();
	}
}
