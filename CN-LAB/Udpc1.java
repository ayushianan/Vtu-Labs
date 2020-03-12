import java.io.*;
import java.net.*;
public class Udpc1 {
	public static void main(String args[])
	{
		DatagramSocket skt;
		try
		{
			skt=new DatagramSocket();
			String msg="udp";
			byte b[]=msg.getBytes();
			InetAddress host=InetAddress.getByName("127.0.0.1");
			int port=6799;
			DatagramPacket request=new DatagramPacket(b,b.length,host,port);
			skt.send(request);
			byte[]buffer=new byte[1000];
			DatagramPacket reply=new DatagramPacket(buffer,buffer.length);
			skt.receive(reply);
			System.out.println("Client received: " + new String(reply.getData()));
			skt.close();
		}catch(Exception ex) {}
	}

}
