package hash;

import java.security.MessageDigest;

import util.CryptoTools;

public class York232
{
        public static void main(String[] args) throws Exception
        {
		byte[] msg = "abcdefghijklmnopqrstuvwxyzaa".getBytes();
                String result;
                if (msg.length == 28)
                {
                        result = "00" + CryptoTools.bytesToHex(msg);
                }
                else
                {   
                        MessageDigest md = MessageDigest.getInstance("Sha-224");
                        result = "01" +  CryptoTools.bytesToHex(md.digest(msg));  
                }
                System.out.println(result);
                System.out.println(new String(CryptoTools.hexToBytes(result)));
        	}
}
