package symmetric;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class AES_Decrypt2 {

	public static void main(String[] args) throws Exception {
		byte[] keyAsBytes = "DO NOT TELL EVE!".getBytes();
		
		byte[] ct = CryptoTools.hexToBytes("3188073EA5DB3F5C05B6307B3595607135F5D4B22F2C3EB710AA31377F78B997");
		//byte[] key = CryptoTools.hexToBytes("9F0DCEDB322F3C6873F9256E01376BA4");
		byte[] iv = CryptoTools.hexToBytes("20FC19123087BF6CAC8D0F1254123004");
		
		
		IvParameterSpec ivSpec = new IvParameterSpec(iv);
		Key secretKey = new SecretKeySpec(keyAsBytes, "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		
		cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
		byte[] pt = cipher.doFinal(ct);
		
		System.out.println("PT: " + new String(pt) + "<");

	}

}
