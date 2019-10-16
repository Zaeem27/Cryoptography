package symmetric;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class DES_Decrypt_Missing_Block
{

	public static void main(String[] args) throws Exception
	{
		byte[] ctPart = CryptoTools.hexToBytes("4E51297B424F90D8B2ACD6ADF010DDC4");
		//byte[] block3 = CryptoTools.hexToBytes("B2ACD6ADF010DDC4");
		
		byte[] ky = ("CSE@YORK").getBytes();
		byte[] iv = CryptoTools.hexToBytes("0123456701234567");
		
		Key secret = new SecretKeySpec(ky, "DES");
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		AlgorithmParameterSpec aps = new IvParameterSpec(iv);
	//	cipher.init(Cipher.ENCRYPT_MODE, secret, aps);
	//	byte[] ct = cipher.doFinal(pt);
		
	//	System.out.println("CT = " + CryptoTools.bytesToHex(ct));
		
		cipher.init(Cipher.DECRYPT_MODE, secret, aps);
		byte[] bk = cipher.doFinal(ctPart);
		System.out.println("BK = " + new String(bk) + "<");
		

	}

}