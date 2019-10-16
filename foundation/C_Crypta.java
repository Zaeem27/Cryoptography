package foundation;

import util.CryptoTools;

public class C_Crypta {

	public static void main(String[] args) throws Exception {

		byte[] rawCt = CryptoTools.fileToBytes("data/MSG2.ct");
		byte[] testByte = new byte[rawCt.length];
		int dotP = 0;

		for (int key = 1; key <= 26; key++) {
			dotP = 0;
			for (int i = 0; i < rawCt.length; i++) {
				int tmp = (rawCt[i] - 'A' - key) % 26;
				if (tmp < 0)
					tmp += 26;
				testByte[i] = (byte) (tmp + 'A');
			}
		}
		int[] frequencies = CryptoTools.getFrequencies(testByte);

		for (int i = 0; i < frequencies.length; i++) {
			System.out.printf("Alphabet: %d --> IC/Length: %.3f \n", i,
					(double) frequencies[i] / (double) testByte.length);
		}
	}

}
