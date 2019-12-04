package asymmetric;

import java.math.BigInteger;

public class Is_Prime {

	public static void main(String[] args) {

		BigInteger n = new BigInteger("1033931178476059651954862004553");

//		boolean isPrime = n.isProbablePrime(1);
//		
//		if (isPrime) {
//			System.out.println("Prime");
//		} else
//		{
//			System.out.println("Composite");
//		}
		int runNum = 0;
		BigInteger base = new BigInteger("2");
		BigInteger expo = n.subtract(new BigInteger("1"));
		BigInteger origExpo = expo;
		BigInteger out = new BigInteger("1");

		while (out.equals((new BigInteger("1")))) {
			out = base.modPow(expo, n);
			System.out.println(base.toString() + "^" + expo.toString() + "=" + out.toString());
			if (out.equals(origExpo)) {
				System.out.println("Prime");
				break;
			}
			if (!(out.equals((new BigInteger("1")))) && !(out.equals((new BigInteger("-1"))))) {
				System.out.println("Composite");
				break;
			} else {
				if (out.equals(new BigInteger("-1")) || !(expo.mod(new BigInteger("2")).equals(BigInteger.ZERO))) {
					System.out.println("Test fails for this base");
					break;
				} else {
					expo = expo.divide(new BigInteger("2"));
				}
			}

		}
	}
}
