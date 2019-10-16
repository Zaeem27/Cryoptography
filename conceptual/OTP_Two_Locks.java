package conceptual;

import util.CryptoTools;

public class OTP_Two_Locks {
	public static void main(String[] args) {
		byte[] message1 = CryptoTools.hexToBytes("0A4F0C08003503492F247442105B5757");
		byte[] message2 = CryptoTools.hexToBytes("5E2769286B507A69494B066252343579");
		byte[] message3 = CryptoTools.hexToBytes("170708454B1116002A2E2111725F5000");
		
		byte[] xor1 = CryptoTools.xorByteArray(message1, message2);
		byte[] xor2 = CryptoTools.xorByteArray(xor1, message3);
		
		System.out.println(new String(xor2));
	}

}
