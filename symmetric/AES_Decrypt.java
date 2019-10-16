package symmetric;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class AES_Decrypt {

	public static void main(String[] args) throws Exception {
		byte[] ct = CryptoTools.hexToBytes("531D5041A12019ACE603BAB33B7A63DF");
		byte[] key = CryptoTools.hexToBytes("6A6B6C6D6E6F7071727475767778797A");
		byte[] iv = CryptoTools.hexToBytes("31323334353637383930717765727479");
		
		IvParameterSpec ivSpec = new IvParameterSpec(iv);
		Key secretKey = new SecretKeySpec(key, "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		
		cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
		byte[] pt = cipher.doFinal(ct);
		
	//	System.out.println("PT: " + new String(pt) + "<");
		
		byte[] key1 = "Strongly".getBytes();
		Key secretKey1 = new SecretKeySpec(key1, "DES");
		Cipher cipher2 = Cipher.getInstance("DES/ECB/NoPadding");
		cipher2.init(Cipher.DECRYPT_MODE, secretKey1);
		byte[] pt1 = cipher2.doFinal(pt);
//		
//		String out = new String(pt1) +  "UVN";
//		byte[] pt2 = out.getBytes();
		
		
		
		System.out.println(new String(pt1));
		
		
	}

}
