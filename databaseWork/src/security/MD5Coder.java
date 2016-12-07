package security;


import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5加密组件
 * 
 * @author 梁栋
 * @version 1.0
 * @since 1.0
 */
public abstract class MD5Coder {

	/**
	 * MD5加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encodeMD5(String data) throws Exception {

		// 执行消息摘要
		return DigestUtils.md5(data);
	}

    public static String convertToHexString(byte[] digesta) {
        String result = "";
        for (int i = 0; i < digesta.length; i++) {
            //0xff & digesta[i] 取低8位
            String temp = Integer.toHexString(0xff & digesta[i]);
            if(temp.length()==1){
                temp = "0"+temp;
            }
            result += temp;
        }
        return result;
    }
	/**
	 * MD5加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static String encodeMD5Hex(String data) throws Exception {

		// 执行消息摘要
		return DigestUtils.md5Hex(data);
	}
}
