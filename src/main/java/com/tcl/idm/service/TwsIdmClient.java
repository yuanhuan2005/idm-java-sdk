package com.tcl.idm.service;

import com.tcl.idm.IdmServiceInterface;
import com.tcl.idm.model.BasicTWSCredentials;
import com.tcl.idm.model.CustomHttpResponse;
import com.tcl.idm.model.IdmSdkConfig;
import com.tcl.idm.util.CommonService;
import com.tcl.idm.util.DateFormatterUtils;
import com.tcl.idm.util.FileUtils;
import com.tcl.idm.util.HttpRequestUtils;
import com.tcl.idm.util.IDMServiceUtils;
import com.tcl.idm.util.SignatureUtils;
import com.tcl.idm.util.StringUtils;
import com.tcl.idm.util.UrlUtils;

/**
 *
 * 
 * @author yuanhuan
 * 2014年5月8日 下午2:23:35
 */
public class TwsIdmClient implements IdmServiceInterface
{
	private BasicTWSCredentials basicTWSCredentials;

	private String idmEndpoint;

	private void setBasicTWSCredentials(BasicTWSCredentials basicTWSCredentials)
	{
		this.basicTWSCredentials = basicTWSCredentials;
	}

	private void setIdmEndpoint(String idmEndpoint)
	{
		this.idmEndpoint = idmEndpoint;
	}

	private static String genSignatureString(String httpMethod, String host, String uri, String params)
	{
		StringBuffer signatureStringBuffer = new StringBuffer();

		signatureStringBuffer.append(httpMethod);
		signatureStringBuffer.append("\n");
		signatureStringBuffer.append(host);
		signatureStringBuffer.append("\n");
		signatureStringBuffer.append(uri);
		signatureStringBuffer.append("\n");
		signatureStringBuffer.append(params);

		return signatureStringBuffer.toString();
	}

	public TwsIdmClient(BasicTWSCredentials credentials)
	{
		setBasicTWSCredentials(credentials);
		setEndpoint(IDMServiceUtils.getIdmEndpoint());
	}

	@Override
	public void setEndpoint(String endpoint)
	{
		setIdmEndpoint(endpoint);
	}

	@Override
	public CustomHttpResponse createAccount(String accountName, String password)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "createAccount";
		String params = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime() + "&accountName=" + accountName + "&password="
		        + password;
		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params += "&signature=" + signature;
		String url = idmEndPoint + "?" + params;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}

	@Override
	public CustomHttpResponse deleteAccount(String accountId)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "deleteAccount";
		String params = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime() + "&accountId=" + accountId;
		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params += "&signature=" + signature;
		String url = idmEndPoint + "?" + params;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}

	@Override
	public CustomHttpResponse createUser(String userName, String password)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "createUser";
		String params = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime() + "&userName=" + userName + "&password="
		        + password;
		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params += "&signature=" + signature;
		String url = idmEndPoint + "?" + params;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}

	@Override
	public CustomHttpResponse getUser(String userId)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "getUser";
		String params = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime() + "&userId=" + userId;
		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params += "&signature=" + signature;
		String url = idmEndPoint + "?" + params;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}

	@Override
	public CustomHttpResponse listUsers()
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "listUsers";
		String params = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime();
		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params += "&signature=" + signature;
		String url = idmEndPoint + "?" + params;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}

	@Override
	public CustomHttpResponse deleteUser(String userId)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "deleteUser";
		String params = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime() + "&userId=" + userId;
		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params += "&signature=" + signature;
		String url = idmEndPoint + "?" + params;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}

	@Override
	public CustomHttpResponse updateUser(String userId, String userName)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "updateUser";
		String params = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime() + "&userId=" + userId + "&userName="
		        + userName;
		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params += "&signature=" + signature;
		String url = idmEndPoint + "?" + params;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}

	@Override
	public CustomHttpResponse changePassword(String userId, String oldPassword, String newPassword)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "changePassword";
		String params = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime() + "&userId=" + userId + "&oldPassword="
		        + oldPassword + "&newPassword=" + newPassword;
		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params += "&signature=" + signature;
		String url = idmEndPoint + "?" + params;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}

	@Override
	public CustomHttpResponse createGroup(String groupName, String description)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "createGroup";
		String paramsWithoutDesc = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime() + "&groupName=" + groupName;
		String paramsWithDesc = paramsWithoutDesc;
		String paramsWithEncodedDesc = paramsWithoutDesc;
		if (StringUtils.isStringNotNull(description))
		{
			paramsWithDesc += "&description=" + description;
			paramsWithEncodedDesc += "&description=" + CommonService.getURLEncodeString(description);
		}
		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), paramsWithDesc);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		paramsWithEncodedDesc += "&signature=" + signature;
		String url = idmEndPoint + "?" + paramsWithEncodedDesc;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}

	@Override
	public CustomHttpResponse getGroup(String groupId)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "getGroup";
		String params = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime() + "&groupId=" + groupId;
		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params += "&signature=" + signature;
		String url = idmEndPoint + "?" + params;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}

	@Override
	public CustomHttpResponse listGroups(String userId)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "listGroups";
		String params = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime();
		if (StringUtils.isStringNotNull(userId))
		{
			params += "&userId=" + userId;
		}
		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params += "&signature=" + signature;
		String url = idmEndPoint + "?" + params;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}

	@Override
	public CustomHttpResponse deleteGroup(String groupId)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "deleteGroup";
		String params = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime() + "&groupId=" + groupId;
		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params += "&signature=" + signature;
		String url = idmEndPoint + "?" + params;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}

	@Override
	public CustomHttpResponse updateGroup(String groupId, String groupName, String description)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "updateGroup";
		String params = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime() + "&groupId=" + groupId;
		if (StringUtils.isStringNotNull(groupName))
		{
			params += "&groupName=" + groupName;
		}

		if (StringUtils.isStringNotNull(description))
		{
			params += "&description=" + description;
		}

		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params += "&signature=" + signature;
		String url = idmEndPoint + "?" + params;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}

	@Override
	public CustomHttpResponse addUserToGroup(String userId, String groupId)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "addUserToGroup";
		String params = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime() + "&userId=" + userId + "&groupId=" + groupId;
		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params += "&signature=" + signature;
		String url = idmEndPoint + "?" + params;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}

	@Override
	public CustomHttpResponse removeUserFromGroup(String userId, String groupId)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "removeUserFromGroup";
		String params = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime() + "&userId=" + userId + "&groupId=" + groupId;
		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params += "&signature=" + signature;
		String url = idmEndPoint + "?" + params;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}

	@Override
	public CustomHttpResponse createAccessKey(String userId)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "createAccessKey";
		String params = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime();
		if (StringUtils.isStringNotNull(userId))
		{
			params += "&userId=" + userId;
		}
		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params += "&signature=" + signature;
		String url = idmEndPoint + "?" + params;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}

	@Override
	public CustomHttpResponse deleteAccessKey(String accessKeyId)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "deleteAccessKey";
		String params = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime() + "&accessKeyId=" + accessKeyId;
		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params += "&signature=" + signature;
		String url = idmEndPoint + "?" + params;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}

	@Override
	public CustomHttpResponse updateAccessKey(String accessKeyId, String status)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "updateAccessKey";
		String params = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime() + "&accessKeyId=" + accessKeyId + "&status="
		        + status;
		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params += "&signature=" + signature;
		String url = idmEndPoint + "?" + params;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}

	@Override
	public CustomHttpResponse listAccessKeys(String userId)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "listAccessKeys";
		String params = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime();
		if (StringUtils.isStringNotNull(userId))
		{
			params += "&userId=" + userId;
		}
		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params += "&signature=" + signature;
		String url = idmEndPoint + "?" + params;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}

	@Override
	public CustomHttpResponse createUserPolicy(String userId, String policyName, String policyDocument)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "createUserPolicy";
		String params = "{\"twsAccessKeyId\":\"" + idmSdkConfig.getAccessKeyId() + "\",\"signatureMethod\":\""
		        + idmSdkConfig.getSignatureMethod() + "\",\"signatureVersion\":\"" + idmSdkConfig.getSignatureVersion()
		        + "\",\"timestamp\":\"" + DateFormatterUtils.getCurrentUTCTime() + "\",\"userId\":\"" + userId
		        + "\",\"policyName\":\"" + policyName + "\",\"policyDocument\":" + policyDocument + "}";
		String signatureString = TwsIdmClient.genSignatureString("POST", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params = params.subSequence(0, params.length() - 1) + ",\"signature\":\"" + signature + "\"}";
		CustomHttpResponse result = HttpRequestUtils.sendPostRequest(idmEndPoint, params);
		return result;
	}

	@Override
	public CustomHttpResponse getUserPolicy(String userId, String policyId)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "getUserPolicy";
		String params = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime() + "&userId=" + userId + "&policyId="
		        + policyId;
		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params += "&signature=" + signature;
		String url = idmEndPoint + "?" + params;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}

	@Override
	public CustomHttpResponse updateUserPolicy(String userId, String policyId, String policyName, String policyDocument)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "updateUserPolicy";
		String params = "{\"twsAccessKeyId\":\"" + idmSdkConfig.getAccessKeyId() + "\",\"signatureMethod\":\""
		        + idmSdkConfig.getSignatureMethod() + "\",\"signatureVersion\":\"" + idmSdkConfig.getSignatureVersion()
		        + "\",\"timestamp\":\"" + DateFormatterUtils.getCurrentUTCTime() + "\",\"userId\":\"" + userId
		        + "\",\"policyId\":\"" + policyId + "\"";
		if (StringUtils.isStringNotNull(policyName))
		{
			params += ",\"policyName\":\"" + policyName + "\"";
		}
		if (StringUtils.isStringNotNull(policyDocument))
		{
			params += ",\"policyDocument\":" + policyDocument + "";
		}
		params += "}";
		String signatureString = TwsIdmClient.genSignatureString("POST", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params = params.subSequence(0, params.length() - 1) + ",\"signature\":\"" + signature + "\"}";
		CustomHttpResponse result = HttpRequestUtils.sendPostRequest(idmEndPoint, params);
		return result;
	}

	@Override
	public CustomHttpResponse listUserPolicys(String userId)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "listUserPolicys";
		String params = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime() + "&userId=" + userId;
		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params += "&signature=" + signature;
		String url = idmEndPoint + "?" + params;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}

	@Override
	public CustomHttpResponse deleteUserPolicy(String userId, String policyId)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "deleteUserPolicy";
		String params = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime() + "&userId=" + userId + "&policyId="
		        + policyId;
		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params += "&signature=" + signature;
		String url = idmEndPoint + "?" + params;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}

	@Override
	public CustomHttpResponse createGroupPolicy(String groupId, String policyName, String policyDocument)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "createGroupPolicy";
		String params = "{\"twsAccessKeyId\":\"" + idmSdkConfig.getAccessKeyId() + "\",\"signatureMethod\":\""
		        + idmSdkConfig.getSignatureMethod() + "\",\"signatureVersion\":\"" + idmSdkConfig.getSignatureVersion()
		        + "\",\"timestamp\":\"" + DateFormatterUtils.getCurrentUTCTime() + "\",\"groupId\":\"" + groupId
		        + "\",\"policyName\":\"" + policyName + "\",\"policyDocument\":" + policyDocument + "}";
		String signatureString = TwsIdmClient.genSignatureString("POST", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params = params.subSequence(0, params.length() - 1) + ",\"signature\":\"" + signature + "\"}";
		CustomHttpResponse result = HttpRequestUtils.sendPostRequest(idmEndPoint, params);
		return result;
	}

	@Override
	public CustomHttpResponse getGroupPolicy(String groupId, String policyId)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "getGroupPolicy";
		String params = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime() + "&groupId=" + groupId + "&policyId="
		        + policyId;
		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params += "&signature=" + signature;
		String url = idmEndPoint + "?" + params;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}

	@Override
	public CustomHttpResponse updateGroupPolicy(String groupId, String policyId, String policyName,
	        String policyDocument)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "updateGroupPolicy";
		String params = "{\"twsAccessKeyId\":\"" + idmSdkConfig.getAccessKeyId() + "\",\"signatureMethod\":\""
		        + idmSdkConfig.getSignatureMethod() + "\",\"signatureVersion\":\"" + idmSdkConfig.getSignatureVersion()
		        + "\",\"timestamp\":\"" + DateFormatterUtils.getCurrentUTCTime() + "\",\"groupId\":\"" + groupId
		        + "\",\"policyId\":\"" + policyId + "\"";
		if (StringUtils.isStringNotNull(policyName))
		{
			params += ",\"policyName\":\"" + policyName + "\"";
		}
		if (StringUtils.isStringNotNull(policyDocument))
		{
			params += ",\"policyDocument\":" + policyDocument + "";
		}
		params += "}";
		String signatureString = TwsIdmClient.genSignatureString("POST", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params = params.substring(0, params.length() - 1) + ",\"signature\":\"" + signature + "\"}";
		CustomHttpResponse result = HttpRequestUtils.sendPostRequest(idmEndPoint, params);
		return result;
	}

	@Override
	public CustomHttpResponse listGroupPolicys(String groupId)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "listGroupPolicys";
		String params = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime() + "&groupId=" + groupId;
		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params += "&signature=" + signature;
		String url = idmEndPoint + "?" + params;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}

	@Override
	public CustomHttpResponse deleteGroupPolicy(String groupId, String policyId)
	{
		// 构造IDM接口请求参数
		IdmSdkConfig idmSdkConfig = IDMServiceUtils.getIdmSdkConfig(basicTWSCredentials, idmEndpoint);
		String idmEndPoint = FileUtils.addSlashToPathIfNecessary(idmSdkConfig.getIdmEndPoint()) + "deleteGroupPolicy";
		String params = "twsAccessKeyId=" + idmSdkConfig.getAccessKeyId() + "&signatureMethod="
		        + idmSdkConfig.getSignatureMethod() + "&signatureVersion=" + idmSdkConfig.getSignatureVersion()
		        + "&timestamp=" + DateFormatterUtils.getCurrentUTCTime() + "&groupId=" + groupId + "&policyId="
		        + policyId;
		String signatureString = TwsIdmClient.genSignatureString("GET", UrlUtils.getHostByEndPoint(idmEndPoint),
		        UrlUtils.getURIByEndPoint(idmEndPoint), params);
		String signature = SignatureUtils.calculateRFC2104HMAC(signatureString, idmSdkConfig.getSecretAccessKey());
		params += "&signature=" + signature;
		String url = idmEndPoint + "?" + params;
		CustomHttpResponse result = HttpRequestUtils.sendGetRequest(url);
		return result;
	}
}
