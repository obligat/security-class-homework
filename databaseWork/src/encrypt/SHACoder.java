package encrypt;

import java.security.MessageDigest;

public abstract class SHACoder {

	public static byte[] encodeSHA(byte[] data) throws Exception {
		
		MessageDigest md = MessageDigest.getInstance("SHA");

		return md.digest(data);
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
}
