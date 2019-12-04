package asymmetric;

import java.math.BigInteger;

public class Q1 {

	public static void main(String[] args) {
		BigInteger p = new BigInteger("264208679307705732524907225971531207681");
		BigInteger q = new BigInteger("200181170185227101268806368199715987557");
		BigInteger e = new BigInteger("1031");
		BigInteger ct = new BigInteger("46903772711485649870400600542340635647113782148471559341585401119110429267342");

			
		BigInteger n = p.multiply(q);
		BigInteger phi = (p.subtract(new BigInteger("1")).multiply(q.subtract(new BigInteger("1"))));
		
		BigInteger d = e.modInverse(phi);
		
		BigInteger pt = ct.modPow(d, n);
		
		System.out.println(new String(pt.toByteArray()));
		
	}

}
