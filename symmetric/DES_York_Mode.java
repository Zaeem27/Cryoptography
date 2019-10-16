package symmetric;

import java.math.BigInteger;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class DES_York_Mode {

	public static void main(String[] args) throws Exception {
		String pt = "437DBAB5607137A5CFC1031114634087";
		byte[] ky = CryptoTools.hexToBytes("6B79466F724D4F50");
		byte[] ivInBytes = CryptoTools.hexToBytes("6976466F724D4F50");
		byte[] ivNegated = CryptoTools.negateByteArray(ivInBytes);

		Key secret = new SecretKeySpec(ky, "DES");
		Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
		cipher.init(Cipher.DECRYPT_MODE, secret);
		String outputStringBuild = "";
		byte[] xorResult = null;
		for (int i = 0; i < pt.length(); i = i + 16) {
			// grab next block of pt and decrypt for xor-ing later in if code block
			String blockInString = pt.substring(i, i + 16);
			byte[] blockInBytes = CryptoTools.hexToBytes(blockInString);
			byte[] bkBlock = cipher.doFinal(blockInBytes);
			if (i == 0) {
				//for first block
				xorResult = CryptoTools.xorByteArray(ivNegated, bkBlock);
			} else {
				// for subsequent blocks
				String prevBlock = pt.substring(i - 16, i);
				byte[] prevBlockInBytes = CryptoTools.hexToBytes(prevBlock);
				byte[] prevBlockInverted = CryptoTools.negateByteArray(prevBlockInBytes);
				xorResult = CryptoTools.xorByteArray(prevBlockInverted, bkBlock);
			}
			outputStringBuild = outputStringBuild.concat(new String(xorResult));
		}

		System.out.println("Decrypt Rsult: " + outputStringBuild);

	}

}