package hash;

import java.security.Key;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class MAC {

	public static void main(String[] args) throws Exception {
		String m = "No one can make you feel inferior without your consent.";
		byte[] key = "cancerlegalcerta".getBytes();
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] digest = md.digest(m.getBytes());
		  
		Key secretKey = new SecretKeySpec(key, "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] mac = cipher.doFinal(digest);

		System.out.println(CryptoTools.bytesToHex(mac));
	}

}
