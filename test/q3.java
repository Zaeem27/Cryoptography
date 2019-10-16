package test;

import util.CryptoTools;

public class q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		byte[] bt = CryptoTools.hexToBytes("180D1D00000416451B551D4E6F1A0D45741A041D5435040A");
		byte[] ft = "fifteen".getBytes();
		
		int ln = ft.length;
		
		
		//we would only xor with the ln length of the bt and key byte arrays
		byte[] key = CryptoTools.xorByteArray(ft, bt);	
		byte[] sixteen = "sixteen".getBytes();
		CryptoTools.xorByteArray(key, sixteen);
		
	}

}
