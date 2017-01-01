package security;

import org.apache.commons.codec.binary.Base64;

public class Message {

	private static byte[] publicKey;

	private static byte[] privateKey;

	public String massage(String message, String publickey) throws Exception {
		publicKey = RSACoderPP.getPublicKey(publickey);
		System.out.println(message);
		System.out.println(Base64.encodeBase64String(publicKey));
		String inputStr2 = message;
		String encodeDate3 = null;
		byte[] data2 = inputStr2.getBytes("UTF8");
		byte[] encodedData2 = RSACoderPP.encryptByPublicKey(data2, publicKey);
		encodeDate3 = Base64.encodeBase64String(encodedData2);
		return encodeDate3;
	}

	public String d_massage(String message, String privatekey) throws Exception {
		privateKey = RSACoderPP.getPrivateKey(privatekey);
		byte[] data2 = Base64.decodeBase64(message);
		byte[] encodedData2 = RSACoderPP.decryptByPrivateKey(data2, privateKey);
		System.out.println(new String(encodedData2, "UTF8"));
		System.out.println(Base64.encodeBase64String(privateKey));
		String outputStr2 = new String(encodedData2, "UTF8");
		return outputStr2;
	}

	public static void main(String[] args) throws Exception {

		Message mes = new Message();
		RSACoderPP.initKey("abc", "3");
		String me = mes.massage("fff", "abc");
		String me2 = mes.d_massage(me, "3");

		System.out.println("me is " + me + "\n me2 is " + me2);
	}

}
