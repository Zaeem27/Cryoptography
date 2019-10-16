package conceptual;

import java.math.BigInteger;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import util.CryptoTools;

public class Des_Bit_FLip_Calculation {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		byte[] pt = "FACEBOOK".getBytes();
		byte[] key = "universe".getBytes();

		Key secret = new SecretKeySpec(key, "DES");
		Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
		cipher.init(Cipher.ENCRYPT_MODE, secret);
		byte[] ct = cipher.doFinal(pt);
		String ctInBits = CryptoTools.bytesToBin(ct);
		System.out.println("CT in Bits: " + ctInBits);

		//byte[] flippedBitPT = ;
		int avgSum=0;
		for (int i =0 ; i<100; i++) {
			byte[] ctFlipped = cipher.doFinal(flipRandomBitInPT(pt));
			String ctFlippedInBits = CryptoTools.bytesToBin(ctFlipped);
			avgSum += (getDifference(ctInBits, ctFlippedInBits));
		}
		System.out.println("Average: " + ((((double)avgSum/100))/64)*100 +"%");
		

	}

	private static int getDifference(String ctInBits, String ctFlippedInBits) {
		int sum = 0;
		for (int i = 0; i != ctFlippedInBits.length(); i++) {
			char chA = ctInBits.charAt(i);
			char chB = ctFlippedInBits.charAt(i);
			if (chA != chB) {
				sum++;
			}
		}
		return sum;
	}

	private static byte[] flipRandomBitInPT(byte[] pt) {
		int pos = (int) (63 * Math.random());
		pt[pos/8] = (byte) (pt[pos/8] ^ ((int)Math.pow(2, (pos%8))));
		return pt;
	}

}
