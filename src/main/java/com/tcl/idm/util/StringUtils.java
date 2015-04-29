package com.tcl.idm.util;

import java.util.Random;

/**
 * �ַ������߼��� 
 * 
 * @author yuanhuan
 * 2014��3��28�� ����3:19:07
 */
public class StringUtils
{
	/**
	 * �ж��ַ����Ƿ�Ϊ��
	 * 
	 * @param str
	 *            �ַ���
	 * @return true��ʾΪ�գ�false��ʾ�ǿ�
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
	 * �ж��ַ����Ƿ�Ϊ��
	 * 
	 * @param str
	 *            �ַ���
	 * @return true��ʾ��Ϊ�գ�false��ʾΪ��
	 */
	public static boolean isStringNotNull(String str)
	{
		return !StringUtils.isStringNull(str);
	}

	/**
	 * ���ɰ������ֺʹ�Сд��ĸ������ַ���
	 * 
	 * @param length �ַ�������
	 * @return ������ɵ��ַ���
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
