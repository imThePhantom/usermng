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

package com.liferay.usermanagement.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link UserInfo}.
 * </p>
 *
 * @author phantoan
 * @see UserInfo
 * @generated
 */
@ProviderType
public class UserInfoWrapper implements UserInfo, ModelWrapper<UserInfo> {
	public UserInfoWrapper(UserInfo userInfo) {
		_userInfo = userInfo;
	}

	@Override
	public Class<?> getModelClass() {
		return UserInfo.class;
	}

	@Override
	public String getModelClassName() {
		return UserInfo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("userCode", getUserCode());
		attributes.put("userId", getUserId());
		attributes.put("username", getUsername());
		attributes.put("male", getMale());
		attributes.put("birthday", getBirthday());
		attributes.put("address", getAddress());
		attributes.put("email", getEmail());
		attributes.put("phone", getPhone());
		attributes.put("departmentCode", getDepartmentCode());
		attributes.put("role", getRole());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String userCode = (String)attributes.get("userCode");

		if (userCode != null) {
			setUserCode(userCode);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String username = (String)attributes.get("username");

		if (username != null) {
			setUsername(username);
		}

		Boolean male = (Boolean)attributes.get("male");

		if (male != null) {
			setMale(male);
		}

		Date birthday = (Date)attributes.get("birthday");

		if (birthday != null) {
			setBirthday(birthday);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String departmentCode = (String)attributes.get("departmentCode");

		if (departmentCode != null) {
			setDepartmentCode(departmentCode);
		}

		String role = (String)attributes.get("role");

		if (role != null) {
			setRole(role);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public UserInfo toEscapedModel() {
		return new UserInfoWrapper(_userInfo.toEscapedModel());
	}

	@Override
	public UserInfo toUnescapedModel() {
		return new UserInfoWrapper(_userInfo.toUnescapedModel());
	}

	/**
	* Returns the male of this user info.
	*
	* @return the male of this user info
	*/
	@Override
	public boolean getMale() {
		return _userInfo.getMale();
	}

	@Override
	public boolean isCachedModel() {
		return _userInfo.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _userInfo.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this user info is male.
	*
	* @return <code>true</code> if this user info is male; <code>false</code> otherwise
	*/
	@Override
	public boolean isMale() {
		return _userInfo.isMale();
	}

	@Override
	public boolean isNew() {
		return _userInfo.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _userInfo.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<UserInfo> toCacheModel() {
		return _userInfo.toCacheModel();
	}

	@Override
	public int compareTo(UserInfo userInfo) {
		return _userInfo.compareTo(userInfo);
	}

	@Override
	public int hashCode() {
		return _userInfo.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userInfo.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new UserInfoWrapper((UserInfo)_userInfo.clone());
	}

	/**
	* Returns the address of this user info.
	*
	* @return the address of this user info
	*/
	@Override
	public java.lang.String getAddress() {
		return _userInfo.getAddress();
	}

	/**
	* Returns the department code of this user info.
	*
	* @return the department code of this user info
	*/
	@Override
	public java.lang.String getDepartmentCode() {
		return _userInfo.getDepartmentCode();
	}

	/**
	* Returns the email of this user info.
	*
	* @return the email of this user info
	*/
	@Override
	public java.lang.String getEmail() {
		return _userInfo.getEmail();
	}

	/**
	* Returns the phone of this user info.
	*
	* @return the phone of this user info
	*/
	@Override
	public java.lang.String getPhone() {
		return _userInfo.getPhone();
	}

	/**
	* Returns the primary key of this user info.
	*
	* @return the primary key of this user info
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _userInfo.getPrimaryKey();
	}

	/**
	* Returns the role of this user info.
	*
	* @return the role of this user info
	*/
	@Override
	public java.lang.String getRole() {
		return _userInfo.getRole();
	}

	/**
	* Returns the user code of this user info.
	*
	* @return the user code of this user info
	*/
	@Override
	public java.lang.String getUserCode() {
		return _userInfo.getUserCode();
	}

	/**
	* Returns the user uuid of this user info.
	*
	* @return the user uuid of this user info
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _userInfo.getUserUuid();
	}

	/**
	* Returns the username of this user info.
	*
	* @return the username of this user info
	*/
	@Override
	public java.lang.String getUsername() {
		return _userInfo.getUsername();
	}

	/**
	* Returns the uuid of this user info.
	*
	* @return the uuid of this user info
	*/
	@Override
	public java.lang.String getUuid() {
		return _userInfo.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _userInfo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userInfo.toXmlString();
	}

	/**
	* Returns the birthday of this user info.
	*
	* @return the birthday of this user info
	*/
	@Override
	public Date getBirthday() {
		return _userInfo.getBirthday();
	}

	/**
	* Returns the create date of this user info.
	*
	* @return the create date of this user info
	*/
	@Override
	public Date getCreateDate() {
		return _userInfo.getCreateDate();
	}

	/**
	* Returns the modified date of this user info.
	*
	* @return the modified date of this user info
	*/
	@Override
	public Date getModifiedDate() {
		return _userInfo.getModifiedDate();
	}

	/**
	* Returns the company ID of this user info.
	*
	* @return the company ID of this user info
	*/
	@Override
	public long getCompanyId() {
		return _userInfo.getCompanyId();
	}

	/**
	* Returns the group ID of this user info.
	*
	* @return the group ID of this user info
	*/
	@Override
	public long getGroupId() {
		return _userInfo.getGroupId();
	}

	/**
	* Returns the user ID of this user info.
	*
	* @return the user ID of this user info
	*/
	@Override
	public long getUserId() {
		return _userInfo.getUserId();
	}

	@Override
	public void persist() {
		_userInfo.persist();
	}

	/**
	* Sets the address of this user info.
	*
	* @param address the address of this user info
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_userInfo.setAddress(address);
	}

	/**
	* Sets the birthday of this user info.
	*
	* @param birthday the birthday of this user info
	*/
	@Override
	public void setBirthday(Date birthday) {
		_userInfo.setBirthday(birthday);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userInfo.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this user info.
	*
	* @param companyId the company ID of this user info
	*/
	@Override
	public void setCompanyId(long companyId) {
		_userInfo.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this user info.
	*
	* @param createDate the create date of this user info
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_userInfo.setCreateDate(createDate);
	}

	/**
	* Sets the department code of this user info.
	*
	* @param departmentCode the department code of this user info
	*/
	@Override
	public void setDepartmentCode(java.lang.String departmentCode) {
		_userInfo.setDepartmentCode(departmentCode);
	}

	/**
	* Sets the email of this user info.
	*
	* @param email the email of this user info
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_userInfo.setEmail(email);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_userInfo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_userInfo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_userInfo.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this user info.
	*
	* @param groupId the group ID of this user info
	*/
	@Override
	public void setGroupId(long groupId) {
		_userInfo.setGroupId(groupId);
	}

	/**
	* Sets whether this user info is male.
	*
	* @param male the male of this user info
	*/
	@Override
	public void setMale(boolean male) {
		_userInfo.setMale(male);
	}

	/**
	* Sets the modified date of this user info.
	*
	* @param modifiedDate the modified date of this user info
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_userInfo.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_userInfo.setNew(n);
	}

	/**
	* Sets the phone of this user info.
	*
	* @param phone the phone of this user info
	*/
	@Override
	public void setPhone(java.lang.String phone) {
		_userInfo.setPhone(phone);
	}

	/**
	* Sets the primary key of this user info.
	*
	* @param primaryKey the primary key of this user info
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_userInfo.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_userInfo.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the role of this user info.
	*
	* @param role the role of this user info
	*/
	@Override
	public void setRole(java.lang.String role) {
		_userInfo.setRole(role);
	}

	/**
	* Sets the user code of this user info.
	*
	* @param userCode the user code of this user info
	*/
	@Override
	public void setUserCode(java.lang.String userCode) {
		_userInfo.setUserCode(userCode);
	}

	/**
	* Sets the user ID of this user info.
	*
	* @param userId the user ID of this user info
	*/
	@Override
	public void setUserId(long userId) {
		_userInfo.setUserId(userId);
	}

	/**
	* Sets the user uuid of this user info.
	*
	* @param userUuid the user uuid of this user info
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userInfo.setUserUuid(userUuid);
	}

	/**
	* Sets the username of this user info.
	*
	* @param username the username of this user info
	*/
	@Override
	public void setUsername(java.lang.String username) {
		_userInfo.setUsername(username);
	}

	/**
	* Sets the uuid of this user info.
	*
	* @param uuid the uuid of this user info
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_userInfo.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserInfoWrapper)) {
			return false;
		}

		UserInfoWrapper userInfoWrapper = (UserInfoWrapper)obj;

		if (Objects.equals(_userInfo, userInfoWrapper._userInfo)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _userInfo.getStagedModelType();
	}

	@Override
	public UserInfo getWrappedModel() {
		return _userInfo;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _userInfo.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _userInfo.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_userInfo.resetOriginalValues();
	}

	private final UserInfo _userInfo;
}