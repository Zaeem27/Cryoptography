package hash;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.BitSet;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class HMAC {

	public static void main(String[] args) throws Exception {
	//	String message = CryptoTools.bytesToHex("The quick brown fox jumps over the lazy dog".getBytes());
		byte[] message = "The quick brown fox jumps over the lazy dog".getBytes();
		String k = CryptoTools.bytesToHex("key".getBytes());
		String oPad = "5c";
		String iPad = "36";
		String oKey = "", iKey ="";
		
		//make key length = block size, 128 instead of 64=(512/8) because each hex char is 4 bits not 8
		while (k.length()<128) {
			k = k + "00";
		}
		System.out.println("Key: " + k);
//		byte[] check = CryptoTools.hexToBytes(k);
//		System.out.println(check.length);
		
		//create the pad of length blocksize 
		while (oKey.length() < 128) {
			oKey = oKey + oPad;
			iKey = iKey + iPad;
		}
		//System.out.println(oKey);
		//System.out.println(iKey);
		
		byte[] iKeyPad = CryptoTools.xorByteArray(CryptoTools.hexToBytes(k), CryptoTools.hexToBytes(iKey));
		byte[] oKeyPad = CryptoTools.xorByteArray(CryptoTools.hexToBytes(k), CryptoTools.hexToBytes(oKey));
		
		
		
		 MessageDigest md = MessageDigest.getInstance("SHA-1");

		// Concatenate & hash inner
		ByteArrayOutputStream baos = new ByteArrayOutputStream();	
		baos.write(iKeyPad);
		baos.write(message);
		byte[] innerConcat = baos.toByteArray();
		byte[] innerHash = md.digest(innerConcat);
		
		// Concatenate & hash outer
		baos = new ByteArrayOutputStream();
		baos.write(oKeyPad);
		baos.write(innerHash);
		byte[] outerConcat = baos.toByteArray();
		byte[] outerHash = md.digest(outerConcat);
		  System.out.println(CryptoTools.bytesToHex(outerHash));
		  
		  
	}
	public static byte[] properHmac(byte[] data, byte[] key) throws Exception {
		SecretKey sKey = new SecretKeySpec(key,"HmacSHA1");
		Mac mac = Mac.getInstance("HmacSHA1");
		
		mac.init(sKey);
		
		return mac.doFinal(data);
	}

}
