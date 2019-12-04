package selected_topics;

import java.math.BigInteger;
import java.util.Random;

public class Key_Splitting {

	public static void main(String[] args) {
		BigInteger m = new BigInteger("291639075201575653178417");
		
		BigInteger s1 = new BigInteger(80, new Random()); 
		BigInteger s2 = new BigInteger(80, new Random());
		BigInteger s3 = new BigInteger(80, new Random());
		BigInteger s4 = new BigInteger(80, new Random());
	    
		BigInteger xor = s1.xor(s2).xor(s3).xor(s4);
		
		BigInteger s5 = xor.xor(m);
		
		
		System.out.println("Share 5= " + s5.toString());
		System.out.println("Check = " + xor.xor(s5));

	}

}
