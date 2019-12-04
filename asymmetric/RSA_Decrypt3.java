package asymmetric;

import java.math.BigInteger;

public class RSA_Decrypt3 {
	
	public static void main(String[] args) {
	
	BigInteger phi = new BigInteger("858403791364243414411127906284740592182316386584270178500860237740068149514754"
			+ "1519557274092429073976252689387304835782258785521935078205581766754116919200");
	
	BigInteger q = new BigInteger("87020952829623092932322362936864583897972618059974315662422560067745889600571");
	
	BigInteger e = new BigInteger("65537");
	
	BigInteger c = new BigInteger("18174873136983478910341579706849261752118341095732777931029018544826117261415609"
			+ "63120214926234448852417078321539316776648109260519063106558303669880226359");


	BigInteger pMinusOne = phi.divide(q.subtract(new BigInteger("1")));
	
	BigInteger p = pMinusOne.add(new BigInteger("1"));
	
	BigInteger n = q.multiply(p);
	
	BigInteger d = e.modInverse(phi);
	
	BigInteger pt = c.modPow(d, n);
	
	System.out.println(new String(pt.toByteArray()));
	
	
	}
}
