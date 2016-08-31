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

import com.liferay.usermanagement.model.Department;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Department in entity cache.
 *
 * @author phantoan
 * @see Department
 * @generated
 */
@ProviderType
public class DepartmentCacheModel implements CacheModel<Department>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DepartmentCacheModel)) {
			return false;
		}

		DepartmentCacheModel departmentCacheModel = (DepartmentCacheModel)obj;

		if (departmentCode.equals(departmentCacheModel.departmentCode)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, departmentCode);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", departmentCode=");
		sb.append(departmentCode);
		sb.append(", departmentName=");
		sb.append(departmentName);
		sb.append(", leaderCode=");
		sb.append(leaderCode);
		sb.append(", description=");
		sb.append(description);
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
	public Department toEntityModel() {
		DepartmentImpl departmentImpl = new DepartmentImpl();

		if (uuid == null) {
			departmentImpl.setUuid(StringPool.BLANK);
		}
		else {
			departmentImpl.setUuid(uuid);
		}

		if (departmentCode == null) {
			departmentImpl.setDepartmentCode(StringPool.BLANK);
		}
		else {
			departmentImpl.setDepartmentCode(departmentCode);
		}

		if (departmentName == null) {
			departmentImpl.setDepartmentName(StringPool.BLANK);
		}
		else {
			departmentImpl.setDepartmentName(departmentName);
		}

		if (leaderCode == null) {
			departmentImpl.setLeaderCode(StringPool.BLANK);
		}
		else {
			departmentImpl.setLeaderCode(leaderCode);
		}

		if (description == null) {
			departmentImpl.setDescription(StringPool.BLANK);
		}
		else {
			departmentImpl.setDescription(description);
		}

		departmentImpl.setGroupId(groupId);
		departmentImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			departmentImpl.setCreateDate(null);
		}
		else {
			departmentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			departmentImpl.setModifiedDate(null);
		}
		else {
			departmentImpl.setModifiedDate(new Date(modifiedDate));
		}

		departmentImpl.resetOriginalValues();

		return departmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		departmentCode = objectInput.readUTF();
		departmentName = objectInput.readUTF();
		leaderCode = objectInput.readUTF();
		description = objectInput.readUTF();

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

		if (departmentCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(departmentCode);
		}

		if (departmentName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(departmentName);
		}

		if (leaderCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(leaderCode);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public String departmentCode;
	public String departmentName;
	public String leaderCode;
	public String description;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
}