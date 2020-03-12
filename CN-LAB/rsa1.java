import java.io.*;
import java.net.*;
import java.util.*;
import java.math.BigInteger;
public class rsa1 {
	private BigInteger p;
	private BigInteger q;
	private BigInteger n;
	private BigInteger phi;
	private BigInteger e;
	private BigInteger d;
	private int bitlength=1024;
	private Random r;
	public rsa1()
	{
		r=new Random();
		p=BigInteger.probablePrime(bitlength,r);
		q=BigInteger.probablePrime(bitlength,r);
		n=p.multiply(q);
		phi=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		e=BigInteger.probablePrime(bitlength/2,r);
		while(e.gcd(phi).compareTo(BigInteger.ONE)>0&&e.compareTo(phi)<0)
		{
			e.add(BigInteger.ONE);
		}
		d=e.modInverse(phi);
	}
	public rsa1(BigInteger n,BigInteger e,BigInteger d)
	{
		this.n=n;
		this.e=e;
		this.d=d;
	}
	private static String bytesToString(byte[] encrypted) {
        String test = "";
        for(byte b:encrypted)
            test += Byte.toString(b);
        return test;
    }

    public byte[] encrypt(byte[] message) {
        return (new BigInteger(message)).modPow(e, n).toByteArray();
    }

    public byte[] decrypt(byte[] message) {
        return (new BigInteger(message)).modPow(d, n).toByteArray();
    }
	public static void main(String args[])throws IOException
	{
		rsa1 rsa2=new rsa1();
		DataInputStream in=new DataInputStream(System.in);
		String teststring;
		System.out.println("Enter plain text:");
	    teststring = in.readLine();
	        System.out.println("Encrypting string: " + teststring);
	        System.out.println("String in bytes: " + bytesToString(teststring.getBytes()));
	        byte[] encrypted=rsa2.encrypt(teststring.getBytes());
	        byte[] decrypted=rsa2.decrypt(encrypted);
	        System.out.println("Encrypting string: " + bytesToString(decrypted));
	        System.out.println("Encrypting string: " + new String(decrypted));  
	}

}
