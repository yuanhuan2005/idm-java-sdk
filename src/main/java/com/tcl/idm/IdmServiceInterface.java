package com.tcl.idm;

import com.tcl.idm.model.CustomHttpResponse;

/**
 *
 * 
 * @author yuanhuan
 * 2014年5月8日 下午2:27:25
 */
public interface IdmServiceInterface
{
	public void setEndpoint(String endpoint);

	public CustomHttpResponse createAccount(String accountName, String password);

	public CustomHttpResponse deleteAccount(String accountId);

	public CustomHttpResponse createUser(String userName, String password);

	public CustomHttpResponse getUser(String userId);

	public CustomHttpResponse listUsers();

	public CustomHttpResponse deleteUser(String userId);

	public CustomHttpResponse updateUser(String userId, String userName);

	public CustomHttpResponse changePassword(String userId, String oldPassword, String newPassword);

	public CustomHttpResponse createGroup(String groupName, String description);

	public CustomHttpResponse getGroup(String groupId);

	public CustomHttpResponse listGroups(String userId);

	public CustomHttpResponse deleteGroup(String groupId);

	public CustomHttpResponse updateGroup(String groupId, String groupName, String description);

	public CustomHttpResponse addUserToGroup(String userId, String groupId);

	public CustomHttpResponse removeUserFromGroup(String userId, String groupId);

	public CustomHttpResponse createAccessKey(String userId);

	public CustomHttpResponse deleteAccessKey(String accessKeyId);

	public CustomHttpResponse updateAccessKey(String accessKeyId, String status);

	public CustomHttpResponse listAccessKeys(String userId);

	public CustomHttpResponse createUserPolicy(String userId, String policyName, String policyDocument);

	public CustomHttpResponse getUserPolicy(String userId, String policyId);

	public CustomHttpResponse updateUserPolicy(String userId, String policyId, String policyName, String policyDocument);

	public CustomHttpResponse listUserPolicys(String userId);

	public CustomHttpResponse deleteUserPolicy(String userId, String policyId);

	public CustomHttpResponse createGroupPolicy(String groupId, String policyName, String policyDocument);

	public CustomHttpResponse getGroupPolicy(String groupId, String policyId);

	public CustomHttpResponse updateGroupPolicy(String groupId, String policyId, String policyName,
	        String policyDocument);

	public CustomHttpResponse listGroupPolicys(String groupId);

	public CustomHttpResponse deleteGroupPolicy(String groupId, String policyId);
}
