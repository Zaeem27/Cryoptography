package foundation;


import util.CryptoTools;

public class C_Encrypt
{

	public static void main(String[] args) throws Exception
	{
		int key = 19;
		byte[] raw = CryptoTools.fileToBytes("data/MSG1.pt");
		byte[] pt = CryptoTools.clean(raw);
		byte[] ct = new byte[pt.length];
		CryptoTools.bytesToFile(pt, "data/MSG1.clean");
		for (int i = 0; i < pt.length; i++)
		{
			ct[i] = (byte) ((pt[i] - 'A' + key) % 26 + 'A');
		}
		CryptoTools.bytesToFile(ct, "data/MSG.ct");
		//----------------------------------------------
		System.out.println("PT = " + new String(pt));
		System.out.println("CT = " + new String(ct));
		//----------------------------------------------Decrypt
		byte[] bk = new byte[ct.length];
		for (int i = 0; i < ct.length; i++)
		{
			int tmp = (ct[i] - 'A' - key) % 26;
			if (tmp < 0) tmp+= 26;
			bk[i] = (byte) (tmp + 'A');
		}	
		System.out.println("BK = " + new String(bk));
		
		
		System.out.println("MD5: " + CryptoTools.getMD5(ct));
		System.out.println("IC: " + CryptoTools.getIC(pt,1000));
		
	}

}