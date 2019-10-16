package symmetric;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class DES_SAE_PKCS5Padding {

	public static void main(String[] args) throws Exception {
		String pt = "7AA38A029E773CBBC188A9FCEADAE99DA560B784C99AFEF2";
		byte[] ky = CryptoTools.hexToBytes("4F75725269676874");
		byte[] ivInBytes = CryptoTools.hexToBytes("496E566563746F72");

		
		Key secret = new SecretKeySpec(ky, "DES");
		Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
		cipher.init(Cipher.DECRYPT_MODE, secret);
		String outputStringBuild = "";
		byte[] xorResult = null;
		
		for (int i = 0; i < pt.length(); i = i + 16) {
			
			String blockInString = pt.substring(i, i + 16);
			byte[] blockInBytes = CryptoTools.hexToBytes(blockInString);
			if (i == 0) {
				xorResult = CryptoTools.xorByteArray(ivInBytes, blockInBytes);
			} else {
				String prevBlock = pt.substring(i - 16, i);
				byte[] prevBlockInBytes = CryptoTools.hexToBytes(prevBlock);
				xorResult = CryptoTools.xorByteArray(prevBlockInBytes, blockInBytes);
			}
			byte[] bkBlock = cipher.doFinal(xorResult);
			outputStringBuild = outputStringBuild.concat(new String(bkBlock));
		}

		System.out.println("Decrypt Result: " + outputStringBuild);

	}

}