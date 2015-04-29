package com.tcl.idm.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.tcl.idm.model.BasicTWSCredentials;
import com.tcl.idm.model.CustomErrorCode;
import com.tcl.idm.model.IdmSdkConfig;
import com.tcl.idm.model.PolicyDocument;

/**
 * IDM工具类
 * 
 * @author yuanhuan
 * 2014年4月4日 上午9:38:08
 */
public class IDMServiceUtils
{
	public static String genAccessKey()
	{
		return StringUtils.randomString(32);
	}

	public static String genSecretAccessKey()
	{
		return StringUtils.randomString(48);
	}

	public static String genOpenIDMObjectId()
	{
		return StringUtils.randomString(32);
	}

	public static PolicyDocument[] convertToPolicyDocumentArray(String policyDocumentJsonString)
	{
		PolicyDocument[] policyDocumentArr = null;

		try
		{
			JSONArray policyDocumentJSONArray = JSONArray.fromObject(policyDocumentJsonString);
			if (null != policyDocumentJSONArray && policyDocumentJSONArray.size() > 0)
			{
				policyDocumentArr = new PolicyDocument[policyDocumentJSONArray.size()];
				PolicyDocument policyDocument = null;
				for (int i = 0; i < policyDocumentJSONArray.size(); i++)
				{
					policyDocument = new PolicyDocument();
					policyDocument.setEffect(((JSONObject) policyDocumentJSONArray.get(i)).getString("effect"));
					policyDocument.setResource(((JSONObject) policyDocumentJSONArray.get(i)).getString("resource"));
					policyDocumentArr[i] = policyDocument;
				}
			}
		}
		catch (Exception e)
		{
		}

		return policyDocumentArr;
	}

	/**
	 * 获取JSON格式的响应消息，如果输入参数不是Json格式，则转换成Json格式。
	 * 
	 * @param jsonMessage
	 * @return
	 */
	public static String getJsonMessage(String jsonMessage)
	{
		try
		{
			JSONObject.fromObject(jsonMessage);
		}
		catch (Exception e)
		{
			try
			{
				JSONArray.fromObject(jsonMessage);
			}
			catch (Exception e1)
			{
				return IdmErrorMessageUtils.genErrorMessageInJson(CustomErrorCode.IDMServiceUnreachable.getCode(),
				        CustomErrorCode.IDMServiceUnreachable.getMessage());
			}
		}

		return jsonMessage;
	}

	public static String getIdmEndpoint()
	{
		String endpoint = "";
		String idmServerSchema = CommonService.getIdmJdkConfValue("idmServerSchema");
		String idmServerHost = CommonService.getIdmJdkConfValue("idmServerHost");
		String idmServerPort = CommonService.getIdmJdkConfValue("idmServerPort");
		if ("80".equals(idmServerPort))
		{
			endpoint = idmServerSchema + "://" + idmServerHost;
		}
		else
		{
			endpoint = idmServerSchema + "://" + idmServerHost + ":" + idmServerPort;
		}
		return endpoint + "/idm/";
	}

	public static IdmSdkConfig getIdmSdkConfig(BasicTWSCredentials basicTWSCredentials, String idmEndpoint)
	{
		IdmSdkConfig idmCLIConfig = new IdmSdkConfig();
		idmCLIConfig.setIdmEndPoint(idmEndpoint);
		idmCLIConfig.setAccessKeyId(basicTWSCredentials.getTwsAccessKeyId());
		idmCLIConfig.setSecretAccessKey(basicTWSCredentials.getTwsSecretAccessKey());
		String signatureMethod = "HmacSHA256";
		String signatureVersion = "1";
		idmCLIConfig.setSignatureMethod(signatureMethod);
		idmCLIConfig.setSignatureVersion(signatureVersion);
		return idmCLIConfig;
	}
}
