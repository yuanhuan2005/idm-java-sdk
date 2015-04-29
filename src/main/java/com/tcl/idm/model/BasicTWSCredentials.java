package com.tcl.idm.model;

import org.apache.commons.lang.StringUtils;

/**
 *
 * 
 * @author yuanhuan
 * 2014年5月8日 下午2:25:21
 */
public class BasicTWSCredentials
{
	String twsAccessKeyId;

	String twsSecretAccessKey;

	public String getTwsAccessKeyId()
	{
		return twsAccessKeyId;
	}

	public void setTwsAccessKeyId(String twsAccessKeyId)
	{
		this.twsAccessKeyId = twsAccessKeyId;
	}

	public String getTwsSecretAccessKey()
	{
		return twsSecretAccessKey;
	}

	public void setTwsSecretAccessKey(String twsSecretAccessKey)
	{
		this.twsSecretAccessKey = twsSecretAccessKey;
	}

	@Override
	public String toString()
	{
		return "BasicTWSCredentials [twsAccessKeyId=" + twsAccessKeyId + ", twsSecretAccessKey=" + twsSecretAccessKey
		        + "]";
	}

	public boolean isEmpty()
	{
		if (StringUtils.isEmpty(twsAccessKeyId) || StringUtils.isEmpty(twsSecretAccessKey))
		{
			return true;
		}

		return false;
	}

}
