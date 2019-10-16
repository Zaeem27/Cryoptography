package symmetric;

import java.io.FileReader;
import java.security.Key;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class DES_Double_Decrypt {

	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("data/check (1).txt");
		Scanner sc = new Scanner(fr);
		String fileText = sc.next();
		byte[] fileTextInBytes = CryptoTools.hexToBytes(fileText);
		//byte[] keyInBytes = ("FACEBOOK").getBytes();
		byte[] keyInBytes = CryptoTools.hexToBytes("636F6E74696E7565");
		byte[] complementedKeyInBytes = CryptoTools.negateByteArray(keyInBytes); 
		
		Key secret = new SecretKeySpec(complementedKeyInBytes, "DES");
		Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
		cipher.init(Cipher.DECRYPT_MODE, secret);
		byte[] firstDecrypt = cipher.doFinal(fileTextInBytes);

		Key secret2 = new SecretKeySpec(keyInBytes, "DES");
		Cipher cipher2 = Cipher.getInstance("DES/ECB/NoPadding");
		cipher2.init(Cipher.DECRYPT_MODE, secret2);
		byte[] secondDecrypt = cipher2.doFinal(firstDecrypt);

		System.out.println("BK = " + new String(secondDecrypt) + "<");

	}

	
	
	
}
