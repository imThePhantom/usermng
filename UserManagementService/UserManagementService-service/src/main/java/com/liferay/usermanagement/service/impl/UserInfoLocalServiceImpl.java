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

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.usermanagement.exception.UserCodeException;
import com.liferay.usermanagement.exception.UserEmailException;
import com.liferay.usermanagement.exception.UserPhoneException;
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

	public UserInfo addUserInfo(String userCode, String username, boolean male, Date birthday, String address,
			String email, String phone, String departmentCode, String role, ServiceContext serviceContext)
			throws PortalException, SystemException {
		long groupId = serviceContext.getScopeGroupId();
		long companyId = CompanyLocalServiceUtil.getCompanyByWebId("liferay.com").getCompanyId();
		Date now = new Date();
		LocalDate localDate = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		validate(userCode, username, email, phone);

		UserInfo userInfo = userInfoPersistence.create(userCode);

		User user = null;
		long creatorId = serviceContext.getUserId();
		boolean autoPassword = false;
		String password1 = userCode;
		String password2 = userCode;
		boolean autoScreenName = false;
		String screenName = username.replaceAll("\\s+", "").toLowerCase();
		long facebookId = 0;
		String openId = "";
		Locale locale = Locale.US;
		int prefixId = 0;
		int suffixId = 0;
		int birthdayMonth = localDate.getDayOfMonth();
		int birthdayDay = localDate.getMonthValue();
		int birthdayYear = localDate.getDayOfYear();
		String jobTitle = "";
		boolean sendEmail = false;

		user = UserLocalServiceUtil.addUser(creatorId, companyId, autoPassword, password1, password2, autoScreenName,
				screenName, email, facebookId, openId, locale, username, "", "", prefixId, suffixId, male,
				birthdayMonth, birthdayDay, birthdayYear, jobTitle, null, null, null, null, sendEmail, serviceContext);

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

		Indexer<UserInfo> indexer = IndexerRegistryUtil.nullSafeGetIndexer(UserInfo.class);
		indexer.reindex(userInfo);

		return userInfo;
	}

	public UserInfo deleteUserInfo(String userCode, ServiceContext serviceContext)
			throws PortalException, SystemException {
		UserInfo userInfo = getUserInfo(userCode);

		Indexer<UserInfo> indexer = IndexerRegistryUtil.nullSafeGetIndexer(UserInfo.class);
		indexer.delete(userInfo);

		userInfo = deleteUserInfo(userCode);
		return userInfo;
	}

	public List<UserInfo> getUserInfos(long groupId) throws PortalException, SystemException {
		return userInfoPersistence.findBygroupId(groupId);
	}

	public List<UserInfo> getUserInfos(long groupId, int start, int end) throws PortalException, SystemException{
		return userInfoPersistence.findBygroupId(groupId, start, end);
	}
	
	public List<UserInfo> getUserInfosByC_N_E(String userCode, String username, String email) throws PortalException, SystemException{
		return userInfoPersistence.findByC_N_E(userCode, username, email);
	}

	public UserInfo updateUserInfo(String userCode, String username, boolean male, Date birthday, String address,
			String email, String phone, String departmentCode, String role, ServiceContext serviceContext)
			throws PortalException, SystemException {
		long groupId = serviceContext.getScopeGroupId();
		long companyId = CompanyLocalServiceUtil.getCompanyByWebId("liferay.com").getCompanyId();
		Date now = new Date();
		String screenName = username.replaceAll("\\s+", "").toLowerCase();

		validate(userCode, username, email, phone);

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

		user.setFirstName(username);
		user.setScreenName(screenName);
		user.getContact().setBirthday(birthday);
		user.getContact().setMale(male);
		user.getContact().setEmailAddress(email);

		UserLocalServiceUtil.updateUser(user);
		userInfoPersistence.update(userInfo);

		Indexer<UserInfo> indexer = IndexerRegistryUtil.nullSafeGetIndexer(UserInfo.class);
		indexer.reindex(userInfo);

		return userInfo;
	}

	protected void validate(String userCode, String username, String email, String phone) throws PortalException {
		if (Validator.isNull(userCode)) {
			throw new UserCodeException();
		}
		if (Validator.isNull(username) || Validator.isName(username)) {
			throw new UsernameException();
		}
		if (Validator.isNull(email) || Validator.isEmailAddress(email)) {
			throw new UserEmailException();
		}
		if (Validator.isPhoneNumber(phone)) {
			throw new UserPhoneException();
		}
	}

}