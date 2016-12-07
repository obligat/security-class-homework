package encrypt;

import org.apache.commons.codec.digest.DigestUtils;

public abstract class MD5Coder {

	public static String encodeMD5Hex(String data) throws Exception {

		return DigestUtils.md5Hex(data);
	}
}
