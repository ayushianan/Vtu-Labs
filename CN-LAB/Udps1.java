import java.io.*;
import java.net.*;
public class Udps1 {
	public static void main(String args[])
	{
		DatagramSocket skt=null;
		try
		{
			skt=new DatagramSocket(6799);
			byte[] buffer=new byte[1000];
			DatagramPacket request=new DatagramPacket(buffer,buffer.length);
			skt.receive(request);
			String message[] =(new String(request.getData())).split("");
			byte[] smsg = (message[1]+"Network Laboratory").getBytes();
			DatagramPacket reply=new DatagramPacket(smsg,smsg.length,request.getAddress(),request.getPort());
			skt.send(reply);
			//System.out.println("Client communicated");
			skt.close();
		}catch(Exception ex){}
	}

}
