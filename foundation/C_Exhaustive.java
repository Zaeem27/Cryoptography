package foundation;

import java.util.ArrayList;

import util.CryptoTools;

public class C_Exhaustive {

	public static void main(String[] args) throws Exception {

		byte[] rawCt = CryptoTools.fileToBytes("data/MSG2.ct");
		byte[] testByte = new byte[rawCt.length];
		int dotP = 0;
		int greatestDotP = 0;
		int predictedKey = 0;
		for (int key = 0; key < 26; key++) {
			dotP = 0;
			for (int i = 0; i < rawCt.length; i++) {
				int tmp = (rawCt[i] - 'A' - key) % 26;
				if (tmp < 0)
					tmp += 26;
				testByte[i] = (byte) (tmp + 'A');
			}
			int[] frequencies = CryptoTools.getFrequencies(testByte);
			for (int j = 0; j < frequencies.length; j++) {
				dotP += frequencies[j] * CryptoTools.ENGLISH[j];
			}
			if (greatestDotP < dotP) {
				predictedKey = key;
				greatestDotP = dotP;
			}
			System.out.println("Shift: " + key + " Dot Product: " + dotP);
			// System.out.println("Possible PT = " + new String(testByte));
		}
		byte[] bk = new byte[rawCt.length];
		for (int i = 0; i < rawCt.length; i++) {
			int tmp = (rawCt[i] - 'A' - predictedKey) % 26;
			if (tmp < 0)
				tmp += 26;
			bk[i] = (byte) (tmp + 'A');
		}
		System.out.println("CT = " + new String(rawCt));
		System.out.println("PT = " + new String(bk));
		// getDotProduct(testByte);
	}

}
