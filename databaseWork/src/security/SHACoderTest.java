package security;

import static org.junit.Assert.*;

import org.junit.Test;

import sun.io.ByteToCharConverter;

import com.google.common.base.Objects;

/**
 * SHA校验
 * 
 * @author 梁栋
 * @version 1.0
 * @since 1.0
 */
public class SHACoderTest {

	/**
	 * 测试SHA-1
	 * 
	 * @throws Exception
	 */
	@Test
	public final void testEncodeSHA() throws Exception {
		String str = "消息摘要";

		// 获得摘要信息
		byte[] data1 = SHACoder.encodeSHA(str.getBytes());
		byte[] data2 = SHACoder.encodeSHA(str.getBytes());

		System.err.println("原文：\t" + str);

		System.err.println("SHA1：\t" + data1);
		System.err.println("SHA1：\t" + data2);

		if ((MD5Coder.convertToHexString(data1)).equals(MD5Coder
				.convertToHexString(data2))) {
			System.err.println("yes/n" + MD5Coder.convertToHexString(data1)
					+ "/n" + MD5Coder.convertToHexString(data2));
		} else {
			System.err.println("no" + data1.toString() + "/n"
					+ data2.toString());
		}
		
		// 校验
		assertArrayEquals(data1, data2);
	}

	/**
	 * 测试SHA-256
	 * 
	 * @throws Exception
	 */
	@Test
	public final void testEncodeSHA256() throws Exception {
		String str = "消息摘要";

		// 获得摘要信息
		byte[] data1 = SHACoder.encodeSHA256(str.getBytes());
		byte[] data2 = SHACoder.encodeSHA256(str.getBytes());

		System.err.println("SHA256：\t" + str);

		System.err.println("SHA256：\t" + data1);
		System.err.println("SHA256：\t" + data2);

		// 校验
		assertArrayEquals(data1, data2);
	}

	/**
	 * 测试SHA-384
	 * 
	 * @throws Exception
	 */
	@Test
	public final void testEncodeSHA384() throws Exception {
		String str = "消息摘要";

		// 获得摘要信息
		byte[] data1 = SHACoder.encodeSHA384(str.getBytes());
		byte[] data2 = SHACoder.encodeSHA384(str.getBytes());

		System.err.println("SHA384：\t" + str);

		System.err.println("SHA384：\t" + data1);
		System.err.println("SHA384：\t" + data2);
		

		System.out.println(Objects.hashCode(data1)+"'------'"+Objects.hashCode(data2));
		// 校验
		assertArrayEquals(data1, data2);
	}

	/**
	 * 测试SHA-512
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@Test
	public final void testEncodeSHA512() throws Exception {
		String str = "消息摘要";

		// 获得摘要信息
		byte[] data1 = SHACoder.encodeSHA512(str.getBytes());
		byte[] data2 = SHACoder.encodeSHA512(str.getBytes());

		System.err.println("SHA512：\t" + str);

		System.err.println("SHA512：\t" + data1);
		System.err.println("SHA512：\t" + data2);
		
		System.err.println();

		// 校验
		assertArrayEquals(data1, data2);
	}
}
