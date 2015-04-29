package com.tcl.idm.model;

import com.tcl.idm.util.StringUtils;

/**
 * AccessKey״̬
 * 
 * @author yuanhuan
 * 2014��3��28�� ����11:32:15
 */
public class AccessKeyStatus
{
	/**
	 * ����״̬
	 */
	final public static String ACTIVE = "active";

	/**
	 * ��Ч״̬
	 */
	final public static String INACTIVE = "inactive";

	/**
	 * �ж�״̬�Ƿ�Ϸ�
	 * 
	 * @param status ״̬
	 * @return true��ʾ�Ϸ���false��ʾ���Ϸ�
	 */
	public static boolean isStatusValid(String status)
	{
		if (StringUtils.isStringNull(status))
		{
			return false;
		}

		if (AccessKeyStatus.ACTIVE.equals(status) || AccessKeyStatus.INACTIVE.equals(status))
		{
			return true;
		}

		return false;
	}
}
