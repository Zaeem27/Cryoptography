package asymmetric;

import java.math.BigInteger;

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger n = new BigInteger("1886551174440596431363530829856821585399702388566818912805438570822614968272903435658873334130205328539");
		BigInteger e = new BigInteger("101");
		BigInteger d = new BigInteger("1494297959952947668406757043668665878753149067546266865968740955277419236413038416419087591492839525101");

		
		//Since according to euler de = 1 mod(phi(n))
		// we can calculate k = de-1 and try to find the 
		//GCD of n and val^(k/2^x) exhaustively 
		//where x is any small number and val is a random number 
		BigInteger k = (d.multiply(e)).subtract(new BigInteger("1"));
		System.out.println(k.toString());
		
		for (int i=0; i < 10; i++) {
			BigInteger g = new BigInteger(String.valueOf(i));
			BigInteger expo =  (new BigInteger("2")).pow(2);
			BigInteger expo2 = k.divide(expo);
			BigInteger out = n.gcd(g.pow(expo.intValue()));
			System.out.println(out.toString());
		}

	}


}
