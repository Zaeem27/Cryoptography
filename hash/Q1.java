package hash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;

import util.CryptoTools;

public class Q1 {

	public static void main(String[] args) throws Exception {
		String message = "Meet me at 5 pm tomorrow";
		
		BigInteger n, e ,d;
		
		n = new BigInteger("945874683351289829816050197767812346183848578056570056860845622609107886220137" + 
				"220709264916908438536900712481301344278323249667285825328323632215422317870682" + 
				"037630270674000828353944598575250177072847684118190067762114937353265007829546" + 
				"21660256501187035611332577696332459049538105669711385995976912007767106063");
		
		e = new BigInteger("74327");
		
		d = new BigInteger("7289370196881601766768920490284861650464951706793000236386405648425161747775298" + 
				"3441046583933853592091262678338882236956093668440986552405421520173544428836766" + 
				"3419319185756836904299985444024205035318170370675348574916529512369448767695219" + 
				"8090537385200990850805837963871485320168470788328336240930212290450023");
		
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		byte[] hash = md.digest(message.getBytes());
		
		BigInteger hashAsBigInt = new BigInteger(hash);
		
		BigInteger signature = hashAsBigInt.modPow(d, n);
		
		System.out.println(CryptoTools.bytesToHex(hash));
		
		
		/////////////////////////////////
		System.out.println("Test");
		BigInteger sigToHash = signature.modPow(e, n);
		
		byte[] hash1 = md.digest(message.getBytes());
		System.out.println(CryptoTools.bytesToHex(hash1) + " = " + CryptoTools.bytesToHex(sigToHash.toByteArray()));
		
	}

}
