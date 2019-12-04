package hash;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;

import util.CryptoTools;

public class Q2_Test {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		byte[] message = "Temperature 28 in YYZ.".getBytes();
		byte[] k = CryptoTools.hexToBytes("7CEB25A45B2435BF457AAE");
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();	
		baos.write(k);
		baos.write(message);
		baos.write(k);
		
		byte[] fullOut = baos.toByteArray();
		 
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		byte[] ymac = md.digest(fullOut);
		System.out.println(CryptoTools.bytesToHex(ymac));
	}

}
