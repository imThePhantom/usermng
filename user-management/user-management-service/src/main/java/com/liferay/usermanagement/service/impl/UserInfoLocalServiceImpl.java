/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.usermanagement.service.impl;

import aQute.bnd.annotation.ProviderType;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.usermanagement.exception.UserCodeException;
import com.liferay.usermanagement.exception.UserEmailException;
import com.liferay.usermanagement.exception.UsernameException;
import com.liferay.usermanagement.model.UserInfo;
import com.liferay.usermanagement.service.base.UserInfoLocalServiceBaseImpl;

/**
 * The implementation of the user info local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.usermanagement.service.UserInfoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author phantoan
 * @see UserInfoLocalServiceBaseImpl
 * @see com.liferay.usermanagement.service.UserInfoLocalServiceUtil
 */
@ProviderType
public class UserInfoLocalServiceImpl extends UserInfoLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Always use {@link
     * com.liferay.usermanagement.service.UserInfoLocalServiceUtil} to access
     * the user info local service.
     */

    public UserInfo addUserInfo(String userCode, String username, boolean male, Date birthday,
	    String address, String email, String phone, String departmentCode, String role,
	    ServiceContext serviceContext) throws PortalException, SystemException {

	validate(userCode, username, email);
	UserInfo userInfo = userInfoPersistence.create(userCode);

	long groupId = serviceContext.getScopeGroupId();
	long companyId = serviceContext.getCompanyId();
	Date now = new Date();

	long creatorId = serviceContext.getUserId();

	boolean autoPassword = false;
	String password1 = userCode;
	String password2 = userCode;
	boolean autoScreenName = false;
	String screenName = username.replaceAll("\\s+", "").toLowerCase();

	System.out.println(userCode);
	System.out.println(email);

	String[] nameTokens = username.split(" ");
	String firstName = nameTokens[0];
	String lastName = nameTokens[nameTokens.length - 1];
	String midleName = "";
	for (int i = 1; i < nameTokens.length - 1; i++) {
	    midleName = midleName.concat(nameTokens[i]);
	}

	long facebookId = 0;
	String openId = "";
	Locale locale = LocaleUtil.getDefault();
	int prefixId = 0;
	int suffixId = 0;

	Calendar cal = Calendar.getInstance();
	cal.setTime(birthday);
	int birthdayMonth = cal.get(Calendar.MONTH);
	int birthdayDay = cal.get(Calendar.DAY_OF_MONTH);
	int birthdayYear = cal.get(Calendar.YEAR);

	long[] groupIds = null;
	long[] organizationIds = null;
	long[] userGroupIds = null;
	Role roleUser = RoleLocalServiceUtil.getRole(companyId, RoleConstants.USER);
	long[] roleIds = { roleUser.getRoleId() };
	String jobTitle = "";
	boolean sendEmail = false;

	System.out.println("start create liferay user");
	User user = UserLocalServiceUtil.addUser(creatorId, companyId, autoPassword, password1,
		password2, autoScreenName, screenName, email, facebookId, openId, locale, firstName,
		midleName, lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay,
		birthdayYear, jobTitle, groupIds, organizationIds, roleIds, userGroupIds, sendEmail,
		serviceContext);
	System.out.println("created liferay user");
	userInfo.setUuid(serviceContext.getUuid());
	userInfo.setUserId(user.getUserId());
	userInfo.setUsername(username);
	userInfo.setMale(male);
	userInfo.setBirthday(birthday);
	userInfo.setAddress(address);
	userInfo.setEmail(email);
	userInfo.setPhone(phone);
	userInfo.setDepartmentCode(departmentCode);
	userInfo.setRole(role);
	userInfo.setGroupId(groupId);
	userInfo.setCompanyId(companyId);
	userInfo.setCreateDate(serviceContext.getCreateDate(now));
	userInfo.setModifiedDate(serviceContext.getModifiedDate(now));

	userInfoPersistence.update(userInfo);
	return userInfo;
    }

    public UserInfo deleteUserInfo(String userCode, ServiceContext serviceContext)
	    throws PortalException, SystemException {

	UserInfo userInfo = getUserInfo(userCode);
	long userId = userInfo.getUserId();
	if (UserLocalServiceUtil.fetchUser(userId) != null) {
	    System.out.println("DELETE Liferay user");
	    UserLocalServiceUtil.deleteUser(userId);
	}
	userInfo = deleteUserInfo(userCode);

	return userInfo;
    }

    public List<UserInfo> getUserInfos(long groupId) throws PortalException, SystemException {
	return userInfoPersistence.findByGroupId(groupId);
    }

    public List<UserInfo> getUserInfos(long groupId, int start, int end)
	    throws PortalException, SystemException {
	return userInfoPersistence.findByGroupId(groupId, start, end);
    }

    public int getUserInfosCount(long groupId) throws SystemException {
	return userInfoPersistence.countByGroupId(groupId);
    }

    public List<UserInfo> getUserInfosByDepartmentCode(String departmentCode)
	    throws PortalException, SystemException {
	return userInfoPersistence.findByDepartmentCode(departmentCode);
    }

    public int getUserInfosByDepartmentCodeCount(String departmentCode) throws SystemException {
	return userInfoPersistence.countByDepartmentCode(departmentCode);
    }

    public UserInfo fetchUserInfoByEmail(String email) {
	return userInfoPersistence.fetchByEmail(email);
    }

    public UserInfo fetchUserInfoByCode(String userCode) {
	return userInfoPersistence.fetchByPrimaryKey(userCode);
    }

    public UserInfo updateUserInfo(String userCode, String username, boolean male, Date birthday,
	    String address, String email, String phone, String departmentCode, String role,
	    ServiceContext serviceContext) throws PortalException, SystemException {

	long groupId = serviceContext.getScopeGroupId();
	long companyId = PortalUtil.getDefaultCompanyId();
	Date now = new Date();
	String screenName = username.replaceAll("\\s+", "").toLowerCase();
	departmentCode = departmentCode.replaceAll("\\s+", "").toLowerCase();

	validate(userCode, username, email);

	UserInfo userInfo = getUserInfo(userCode);

	userInfo.setUsername(username);
	userInfo.setMale(male);
	userInfo.setAddress(address);
	userInfo.setBirthday(birthday);
	userInfo.setEmail(email);
	userInfo.setPhone(phone);
	userInfo.setDepartmentCode(departmentCode);
	userInfo.setRole(role);
	userInfo.setGroupId(groupId);
	userInfo.setCompanyId(companyId);
	userInfo.setModifiedDate(serviceContext.getModifiedDate(now));

	User user = UserLocalServiceUtil.getUser(userInfo.getUserId());

	String[] nameTokens = username.split("\\s+");
	String firstName = nameTokens[0];
	String lastName = nameTokens[nameTokens.length - 1];
	String midleName = "";
	for (int i = 1; i < nameTokens.length - 1; i++) {
	    midleName = midleName.concat(nameTokens[i]);
	}
	user.setFirstName(firstName);
	user.setMiddleName(midleName);
	user.setLastName(lastName);
	user.setScreenName(screenName);
	user.getContact().setBirthday(birthday);
	user.getContact().setMale(male);
	user.getContact().setEmailAddress(email);

	UserLocalServiceUtil.updateUser(user);
	userInfoPersistence.update(userInfo);

	return userInfo;
    }

    protected void validate(String userCode, String username, String email) throws PortalException {
	if (Validator.isNull(userCode)) {
	    throw new UserCodeException("userCode-missing");
	}
	if (Validator.isNull(username)) {
	    throw new UsernameException("username-missing");
	}
	if (Validator.isNull(email) || !Validator.isEmailAddress(email)) {
	    throw new UserEmailException("email-invalid");
	}
    }
}