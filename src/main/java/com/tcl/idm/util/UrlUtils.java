package com.tcl.idm.util;

/**
 *
 * 
 * @author yuanhuan
 * 2014年4月22日 下午1:39:56
 */
public class UrlUtils
{
	public static String getHostByEndPoint(String endPoint)
	{
		// 参数非空检查
		if (StringUtils.isStringNull(endPoint))
		{
			return "";
		}

		if (endPoint.indexOf("://") < 0)
		{
			return "";
		}

		return endPoint.split("://")[1].split("/")[0].split(":")[0];
	}

	public static String getPortByEndPoint(String endPoint)
	{
		// 参数非空检查
		if (StringUtils.isStringNull(endPoint))
		{
			return "";
		}

		if (endPoint.indexOf("://") < 0)
		{
			return "";
		}

		String hostAndPort = endPoint.split("://")[1].split("/")[0];
		if (StringUtils.isStringNull(hostAndPort))
		{
			return "";
		}

		if (hostAndPort.indexOf(":") < 0)
		{
			return "80";
		}
		else
		{
			return hostAndPort.split(":")[1];
		}
	}

	public static String getURIByEndPoint(String endPoint)
	{
		// 参数非空检查
		if (StringUtils.isStringNull(endPoint))
		{
			return "";
		}

		if (endPoint.indexOf("://") < 0)
		{
			return "";
		}

		String hostAndPort = endPoint.split("://")[1].split("/")[0];
		String hostPortAndURI = endPoint.split("://")[1];
		String uri = hostPortAndURI.replaceFirst(hostAndPort, "");
		if (StringUtils.isStringNull(uri))
		{
			uri = "/";
		}

		return uri;
	}

	public static void main(String[] args)
	{
		String endPoint = "http://127.0.0.1";
		String host = UrlUtils.getHostByEndPoint(endPoint);
		System.out.println("host=" + host);

		String port = UrlUtils.getPortByEndPoint(endPoint);
		System.out.println("port=" + port);

		String uri = UrlUtils.getURIByEndPoint(endPoint);
		System.out.println("uri=" + uri);
	}

}
