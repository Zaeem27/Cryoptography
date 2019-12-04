package selected_topics;

import java.math.BigInteger;

public class Key_Sharing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 44;
		int y = 0;
		int x = 1;
		for (int i = 0; i < 5; i++) {
			y = ((5 * (x *x)) + (3 * x) + m);
			System.out.println("(" + x + "," + y + ")");
			x++;
		}
		
	}
	//M=44 when 52 = a+b+M,  70 = 4a+2b+M, 98 = 9a+3b+M are solved (1st 3) or any
	//combination of the 3

}
