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

package com.liferay.usermanagement.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.usermanagement.model.UserInfo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserInfo in entity cache.
 *
 * @author phantoan
 * @see UserInfo
 * @generated
 */
@ProviderType
public class UserInfoCacheModel implements CacheModel<UserInfo>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserInfoCacheModel)) {
			return false;
		}

		UserInfoCacheModel userInfoCacheModel = (UserInfoCacheModel)obj;

		if (userCode.equals(userInfoCacheModel.userCode)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userCode);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", userCode=");
		sb.append(userCode);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", username=");
		sb.append(username);
		sb.append(", Male=");
		sb.append(Male);
		sb.append(", birthday=");
		sb.append(birthday);
		sb.append(", address=");
		sb.append(address);
		sb.append(", email=");
		sb.append(email);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", departmentCode=");
		sb.append(departmentCode);
		sb.append(", role=");
		sb.append(role);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserInfo toEntityModel() {
		UserInfoImpl userInfoImpl = new UserInfoImpl();

		if (uuid == null) {
			userInfoImpl.setUuid(StringPool.BLANK);
		}
		else {
			userInfoImpl.setUuid(uuid);
		}

		if (userCode == null) {
			userInfoImpl.setUserCode(StringPool.BLANK);
		}
		else {
			userInfoImpl.setUserCode(userCode);
		}

		userInfoImpl.setUserId(userId);

		if (username == null) {
			userInfoImpl.setUsername(StringPool.BLANK);
		}
		else {
			userInfoImpl.setUsername(username);
		}

		userInfoImpl.setMale(Male);

		if (birthday == Long.MIN_VALUE) {
			userInfoImpl.setBirthday(null);
		}
		else {
			userInfoImpl.setBirthday(new Date(birthday));
		}

		if (address == null) {
			userInfoImpl.setAddress(StringPool.BLANK);
		}
		else {
			userInfoImpl.setAddress(address);
		}

		if (email == null) {
			userInfoImpl.setEmail(StringPool.BLANK);
		}
		else {
			userInfoImpl.setEmail(email);
		}

		if (phone == null) {
			userInfoImpl.setPhone(StringPool.BLANK);
		}
		else {
			userInfoImpl.setPhone(phone);
		}

		if (departmentCode == null) {
			userInfoImpl.setDepartmentCode(StringPool.BLANK);
		}
		else {
			userInfoImpl.setDepartmentCode(departmentCode);
		}

		if (role == null) {
			userInfoImpl.setRole(StringPool.BLANK);
		}
		else {
			userInfoImpl.setRole(role);
		}

		userInfoImpl.setGroupId(groupId);
		userInfoImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			userInfoImpl.setCreateDate(null);
		}
		else {
			userInfoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userInfoImpl.setModifiedDate(null);
		}
		else {
			userInfoImpl.setModifiedDate(new Date(modifiedDate));
		}

		userInfoImpl.resetOriginalValues();

		return userInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		userCode = objectInput.readUTF();

		userId = objectInput.readLong();
		username = objectInput.readUTF();

		Male = objectInput.readBoolean();
		birthday = objectInput.readLong();
		address = objectInput.readUTF();
		email = objectInput.readUTF();
		phone = objectInput.readUTF();
		departmentCode = objectInput.readUTF();
		role = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		if (userCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userCode);
		}

		objectOutput.writeLong(userId);

		if (username == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(username);
		}

		objectOutput.writeBoolean(Male);
		objectOutput.writeLong(birthday);

		if (address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (phone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (departmentCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(departmentCode);
		}

		if (role == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(role);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public String userCode;
	public long userId;
	public String username;
	public boolean Male;
	public long birthday;
	public String address;
	public String email;
	public String phone;
	public String departmentCode;
	public String role;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
}