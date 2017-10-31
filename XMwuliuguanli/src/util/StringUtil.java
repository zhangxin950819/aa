package util;

import java.util.Random;
import java.util.UUID;

public class StringUtil {
	private StringUtil() {
	}

	/**
	 * 此方法用于判断一个字符串是否不为空
	 * 
	 * @param 用于判断的字符串
	 * @return 判断结果，字符串不为空，返回true，为空返回false
	 */
	public static boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}

	/**
	 * 此方法用于判断一个字符串是否为空
	 * 
	 * @param 用于判断的字符串
	 * @return 判断结果，字符串为空，返回true，不为空返回false
	 */
	public static boolean isBlank(String str) {
		return !hasLength(str);
	}

	/**
	 * 此方法用于产生一个随机码
	 * 
	 * @param length
	 *            需要产生随机码的长度
	 * @return 以字符串的形式返回生成的随机码
	 */
	public static String produceRandomCode(int length) {
		StringBuilder sBuder = new StringBuilder(length);
		String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		for (int i = 0; i < length; i++) {
			sBuder.append(s1.charAt(new Random().nextInt(s1.length())));
		}
		return sBuder.toString();
	}

	/**
	 * 得到处理过的UUID
	 * 
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 返回指定长度的处理过的UUID
	 * 
	 * @param length
	 * @return
	 */
	public static String getUUID(int length) {
		if (length > 32)
			length = 32;
		return UUID.randomUUID().toString().replace("-", "").substring(0, length);
	}
}
