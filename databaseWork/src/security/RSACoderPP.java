package security;



import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

public abstract class RSACoderPP {

	/**
	 * 非对称加密密钥算法
	 */
	public static final String KEY_ALGORITHM = "RSA";

	/**
	 * 公钥
	 */
	private static final String PUBLIC_KEY = "RSAPublicKey";

	/**
	 * 私钥
	 */
	private static final String PRIVATE_KEY = "RSAPrivateKey";

	/**
	 * RSA密钥长度 
	 * 默认1024位，
	 * 密钥长度必须是64的倍数， 
	 * 范围在512至65536位之间。
	 */
	private static final int KEY_SIZE = 512;
	public static Map<String, Object> keyMap= new HashMap<String, Object>();
	/**
	 * 私钥解密
	 * 
	 * @param data
	 *            待解密数据
	 * @param key
	 *            私钥
	 * @return byte[] 解密数据
	 * @throws Exception
	 */
	public static byte[] decryptByPrivateKey(byte[] data, byte[] key)
			throws Exception {

		// 取得私钥
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);

		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

		// 生成私钥
		PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

		// 对数据解密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());

		cipher.init(Cipher.DECRYPT_MODE, privateKey);

		int inputLen = data.length;  
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        int offSet = 0;  
        byte[] cache;  
        int i = 0;  
        // 对数据分段解密  
        while (inputLen - offSet > 0) {  
            if (inputLen - offSet > 64) {  
                cache = cipher.doFinal(data, offSet, 64);  
            } else {  
                cache = cipher.doFinal(data, offSet, inputLen - offSet);  
            }  
            out.write(cache, 0, cache.length);  
            i++;  
            offSet = i * 64;  
        }  
        byte[] decryptedData = out.toByteArray();  
        out.close();  
        return decryptedData;
	}

	/**
	 * 公钥解密
	 * 
	 * @param data
	 *            待解密数据
	 * @param key
	 *            公钥
	 * @return byte[] 解密数据
	 * @throws Exception
	 */
	public static byte[] decryptByPublicKey(byte[] data, byte[] key)
			throws Exception {

		// 取得公钥
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);

		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

		// 生成公钥
		PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);

		// 对数据解密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());

		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		
		int inputLen = data.length;  
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        int offSet = 0;  
        byte[] cache;  
        int i = 0;  
        // 对数据分段解密  
        while (inputLen - offSet > 0) {  
            if (inputLen - offSet > 63) {  
                cache = cipher.doFinal(data, offSet, 63);  
            } else {  
                cache = cipher.doFinal(data, offSet, inputLen - offSet);  
            }  
            out.write(cache, 0, cache.length);  
            i++;  
            offSet = i * 63;  
        }  
        byte[] decryptedData = out.toByteArray();  
        out.close();  
        return decryptedData; 
		


	}

	/**
	 * 公钥加密
	 * 
	 * @param data
	 *            待加密数据
	 * @param key
	 *            公钥
	 * @return byte[] 加密数据
	 * @throws Exception
	 */
	public static byte[] encryptByPublicKey(byte[] data, byte[] key)
			throws Exception {

		// 取得公钥
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);

		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

		PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);

		// 对数据加密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());

		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		 int inputLen = data.length;  
	        ByteArrayOutputStream out = new ByteArrayOutputStream();  
	    
	        int offSet = 0;  
	        byte[] cache;  
	        int i = 0;  
	        // 对数据分段加密  
	        while (inputLen - offSet > 0) {  
	            if (inputLen - offSet > 117) {  
	                cache = cipher.doFinal(data, offSet, 117);  
	            } else {  
	                cache = cipher.doFinal(data, offSet, inputLen - offSet);  
	            }  
	            out.write(cache, 0, cache.length);  
	            i++;  
	            offSet = i * 117;  
	        }  
	        byte[] encryptedData = out.toByteArray();  
	        out.close();  
	        return encryptedData;  
	}

	/**
	 * 私钥加密
	 * 
	 * @param data
	 *            待加密数据
	 * @param key
	 *            私钥
	 * @return byte[] 加密数据
	 * @throws Exception
	 */
	public static byte[] encryptByPrivateKey(byte[] data, byte[] key)
			throws Exception {

		// 取得私钥
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);

		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

		// 生成私钥
		PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

		// 对数据加密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());

		cipher.init(Cipher.ENCRYPT_MODE, privateKey);

		return cipher.doFinal(data);
	}

	/**
	 * 取得私钥
	 * 
	 * @param keyMap
	 *            密钥Map
	 * @return byte[] 私钥
	 * @throws Exception
	 */
	public static byte[] getPrivateKey(String privatekey)
			throws Exception {

		Key key = (Key) keyMap.get(privatekey);

		return key.getEncoded();
	}

	/**
	 * 取得公钥
	 * 
	 * @param keyMap
	 *            密钥Map
	 * @return byte[] 公钥
	 * @throws Exception
	 */
	public static byte[] getPublicKey(String publicKey)
			throws Exception {

		Key key = (Key) keyMap.get(publicKey);

		return key.getEncoded();
	}

	/**
	 * 初始化密钥
	 * 
	 * @return Map 密钥Map
	 * @throws Exception
	 */
	public static Map<String, Object> initKey(String PUBLIC_KEY, String PRIVATE_KEY ) throws Exception {

		// 实例化密钥对生成器
		KeyPairGenerator keyPairGen = KeyPairGenerator
				.getInstance(KEY_ALGORITHM);

		// 初始化密钥对生成器
		keyPairGen.initialize(KEY_SIZE);

		// 生成密钥对
		KeyPair keyPair = keyPairGen.generateKeyPair();

		// 公钥
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

		// 私钥
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

		// 封装密钥


		keyMap.put(PUBLIC_KEY, publicKey);
		keyMap.put(PRIVATE_KEY, privateKey);

		return keyMap;
	}
}
