package foundation;

import java.io.ByteArrayOutputStream;

import javax.print.DocFlavor.STRING;

import util.CryptoTools;

public class VigDecrypt {

	public static void main(String[] args) throws Exception {
	//	byte[] ct = CryptoTools.fileToBytes("data/Q10.ct");
		
		byte[] ct = "SLSHWHAWLPVLLMUDECZDPTGFWCCTOQIOYLITENSPDTMKWOEDEPPUBKITEXL".getBytes();
		for (int k = 1; k < 50; k++) {
			byte[] sample = sample(ct, k);
			double ic = CryptoTools.getIC(sample, 10000);
			System.out.printf("Key length %2d --> IC = %.3f\n", k, ic);
		}
		ByteArrayOutputStream group = new ByteArrayOutputStream();
		ByteArrayOutputStream finalKey = new ByteArrayOutputStream();
		//ct.length/keylength for 1251
		
		for (int i = 0; i < ct.length/5 /*12511391*/; i++) {
			group.reset();
			//Key length for j
			for (int j = 0 + i; j < ct.length; j = j + 11) {
				group.write(ct[j]);
			}
			byte[] groupText = group.toByteArray();
			System.out.println(new String(groupText));

			int dotP = 0;
			int greatestDotP = 0;
			int predictedKey = 0;
			byte[] testByte = new byte[groupText.length];
			for (int key = 0; key < 26; key++) {
				dotP = 0;
				for (int k = 0; k < groupText.length; k++) {
					int tmp = (groupText[k] - 'A' - key) % 26;
					if (tmp < 0)
						tmp += 26;
					testByte[k] = (byte) (tmp + 'A');
				}
				int[] frequencies = CryptoTools.getFrequencies(testByte);
				for (int l = 0; l < frequencies.length; l++) {
					dotP += frequencies[l] * CryptoTools.ENGLISH[l];
				}
				if (greatestDotP < dotP) {
					predictedKey = key;
					greatestDotP = dotP;
				}

				// System.out.println("Shift: " + key + " Dot Product: " + dotP);
				// System.out.println("Possible PT = " + new String(testByte));
			}

			finalKey.write((65 + predictedKey));

			System.out.println("Predicted Key: " + ((char) (65 + predictedKey)));
		}
		System.out.println("Final Key: " + new String(finalKey.toByteArray()));

		
		System.out.println("PT: " + decrypt(new String(ct), new String(finalKey.toByteArray())));
		
		
		//shift left by key 1
		for (int l = 0; l < 37; l++) {
			
		}
	
	}

	static String decrypt(String text, final String key) {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            res += (char)((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }

	public static byte[] sample(byte[] ar, int skip) {
		// byte[] result = new byte[1 + ar.length / skip];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		// int pos = 0;
		for (int i = 0; i < ar.length; i = i + skip) {
			baos.write(ar[i]);
			// result[pos] = ar[i];
			// pos++;
		}
		// return result;
		return baos.toByteArray();
	}

}