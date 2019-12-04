package selected_topics;

import java.math.BigInteger;

import util.CryptoTools;

public class Diffie_Hellman_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger p = new BigInteger("341769842231234673709819975074677605139");
		BigInteger g = new BigInteger("37186859139075205179672162892481226795");
		BigInteger aX = new BigInteger("83986164647417479907629397738411168307");
		BigInteger bX = new BigInteger("140479748264028247931575653178988397140");
		
		BigInteger aY = g.modPow(aX, p);
		BigInteger kS = aY.modPow(bX, p);
		System.out.println(CryptoTools.bytesToHex(kS.toByteArray()));
		
		BigInteger bY = g.modPow(bX, p);
		BigInteger kSame = bY.modPow(aX, p);
		System.out.println(CryptoTools.bytesToHex(kSame.toByteArray()));
	}

}
