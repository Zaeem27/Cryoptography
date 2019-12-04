package hash;

import java.math.BigInteger;

import util.CryptoTools;

public class Q2 {

	public static void main(String[] args) {
		BigInteger nA, eA, pB, qB, eB, mPrime, sPrime;
		
		nA = new BigInteger("171024704183616109700818066925197841516671277");
		eA = new BigInteger("1571");
		
		qB = new BigInteger("8495789457893457345793");
		pB = new BigInteger("98763457697834568934613");
		eB = new BigInteger("87697");
		
		mPrime = new BigInteger("418726553997094258577980055061305150940547956");
		sPrime = new BigInteger("749142649641548101520133634736865752883277237");
		
		BigInteger nB = pB.multiply(qB);
		BigInteger phiB = (pB.subtract(new BigInteger("1"))).multiply(qB.subtract(new BigInteger("1")));
		BigInteger dB = eB.modInverse(phiB);
		//BigInteger dB = getD(pB, qB, eB);
		BigInteger m = mPrime.modPow(dB, nB);
		
		System.out.println(new String(m.toByteArray()));
	
		
		
		/////////Signature Decrypt////////////////
		BigInteger sigDecrypt1 = sPrime.modPow(dB, nB);
		BigInteger sigDecrypt2 = sigDecrypt1.modPow(eA, nA);
		
		System.out.println(new String(sigDecrypt2.toByteArray()));
	
		
		//Since it was not the hash that was signed but the message itself, the message decrypt is the same as the sign decrypt 2
	}
	
	
//	public static BigInteger getD(BigInteger p, BigInteger q, BigInteger e) {
//		BigInteger phi = (p.subtract(new BigInteger("1"))).multiply(q.subtract(new BigInteger("1")));
//		BigInteger d = e.modInverse(phi);
//		return d;
//		
//	}

}
