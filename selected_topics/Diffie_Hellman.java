package selected_topics;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class Diffie_Hellman {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BigInteger p = new BigInteger("1426978031065901624399459");  //prime modulus
		BigInteger g = new BigInteger("142983226354603241203899");   //primitive root
		BigInteger aX = new BigInteger("129297004550995975790831");  //Alice's DH private
		BigInteger bY = new BigInteger("973099250992133155840609"); //Bob's DH public
		byte[] ct = CryptoTools.hexToBytes("FB818242D8712E23"); //The received DES/ECB/PKCS5Padding ciphertext 0x
		
		BigInteger k = bY.modPow(aX, p);

		byte[] key = k.toByteArray();
		System.out.println(key.length);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		//key.length is 10, we only need 64 bits = 8 bytes
		for (int i=0; i<key.length-2; i++) {
			baos.write(key[i]);
		}
		
		byte[] finalKey = baos.toByteArray();
		
		
		
		Key secret = new SecretKeySpec(finalKey, "DES");
		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, secret);
		byte[] pt = cipher.doFinal(ct);
		
		System.out.println("PT = " + new String(pt));
	}

}
