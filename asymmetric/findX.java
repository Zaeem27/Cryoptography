package asymmetric;

import java.math.BigInteger;

public class findX {

	public static void main(String[] args) {
		
		BigInteger c1 = new BigInteger("365944767426");
		BigInteger c2 = new BigInteger("698856040412");
		BigInteger n1 = new BigInteger("1055827021987");
		BigInteger n2 = new BigInteger("973491987203");
		
		BigInteger n1ModInverse = n1.modInverse(n2);
		BigInteger n2ModInverse = n2.modInverse(n1);
		
		BigInteger finalModulo = n1.multiply(n2);
		
		BigInteger firstPart = c1.multiply(n2).multiply(n2ModInverse);
		BigInteger secondPart = c2.multiply(n1).multiply(n1ModInverse);
		
		BigInteger sum = firstPart.add(secondPart);
		
		BigInteger x = sum.mod(finalModulo);
		
		System.out.println("x = " + x.toString());
		
		
		///////////////////////////Check//////////////////////////////////
		System.out.println("Check:");
		
		System.out.println((x.mod(n1)).toString() + " = " + c1.toString());
		System.out.println((x.mod(n2)).toString() + " = " + c2.toString());
	}

}
