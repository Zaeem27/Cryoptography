package foundation;

import util.CryptoTools;
import java.math.BigInteger;

public class A_Exhaustive {

	public static void main(String[] args) throws Exception {
		byte[] rawCt = CryptoTools.fileToBytes("data/MSG3.ct");
		byte[] testByte = new byte[rawCt.length];
		int greatestDotP = 0;
		int predictedAlpha = 0;
		int predictedBeta = 0;
		for (int alpha = 1; alpha <= 25; alpha++) {
			for (int beta = 0; beta <= 25; beta++) {
				for (int i = 0; i < rawCt.length; i++) {
					int tmp = ((rawCt[i] - 'A' - beta) * getModInverse(alpha, 26)) % 26;
					if (tmp < 0)
						tmp += 26;
					testByte[i] = (byte) (tmp + 'A');
				}
				int[] frequencies = CryptoTools.getFrequencies(testByte);
				double dotP = 0;
				for (int j = 0; j < frequencies.length; j++) {
					dotP += frequencies[j] * CryptoTools.ENGLISH[j];
				}
				if (greatestDotP < dotP) {
					predictedAlpha = alpha;
					predictedBeta = beta;
					greatestDotP = (int) dotP;
				}
				// System.out.println("Alpha:" + alpha + " Beta:" + beta + " --> " + dotP);
			}
		}
		System.out.println("Predicted Alpha: " + predictedAlpha + "	Predicted Beta: " + predictedBeta);
		affineDecryption(rawCt, predictedAlpha, predictedBeta);

	}

	public static void affineDecryption(byte[] ar, int alpha, int beta) {

		byte[] outputArray = new byte[ar.length];
		for (int i = 0; i < ar.length; i++) {
			int tmp = ((ar[i] - 'A' - beta) * getModInverse(alpha, 26)) % 26;
			if (tmp < 0)
				tmp += 26;
			outputArray[i] = (byte) (tmp + 'A');
		}
		System.out.println("CT= " + new String(ar));
		System.out.println("PT= " + new String(outputArray));
	}

	public static int getModInverse(int a, int m) {
		a = a % m;
		for (int x = 1; x < m; x++)
			if ((a * x) % m == 1)
				return x;
		return 1;
	}
}