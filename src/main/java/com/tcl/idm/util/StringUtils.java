package com.tcl.idm.util;

import java.util.Random;

/**
 * 字符串工具集合 
 * 
 * @author yuanhuan
 * 2014年3月28日 下午3:19:07
 */
public class StringUtils
{
	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 *            字符串
	 * @return true表示为空，false表示非空
	 */
	public static boolean isStringNull(String str)
	{
		boolean result = false;

		if (null == str || "".equals(str))
		{
			return true;
		}

		return result;
	}

	/**
	 * 判断字符串是否不为空
	 * 
	 * @param str
	 *            字符串
	 * @return true表示不为空，false表示为空
	 */
	public static boolean isStringNotNull(String str)
	{
		return !StringUtils.isStringNull(str);
	}

	/**
	 * 生成包含数字和大小写字母的随机字符串
	 * 
	 * @param length 字符串长度
	 * @return 随机生成的字符串
	 */
	public static String randomString(int length)
	{
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		int strLen = str.length();
		Random random = new Random();
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < length; i++)
		{
			int num = random.nextInt(strLen);
			buf.append(str.charAt(num));
		}
		return buf.toString();
	}
}
