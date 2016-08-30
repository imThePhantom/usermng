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

import com.liferay.usermanagement.model.WorkingTime;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WorkingTime in entity cache.
 *
 * @author phantoan
 * @see WorkingTime
 * @generated
 */
@ProviderType
public class WorkingTimeCacheModel implements CacheModel<WorkingTime>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkingTimeCacheModel)) {
			return false;
		}

		WorkingTimeCacheModel workingTimeCacheModel = (WorkingTimeCacheModel)obj;

		if (workingTimeId == workingTimeCacheModel.workingTimeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, workingTimeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", workingTimeId=");
		sb.append(workingTimeId);
		sb.append(", date=");
		sb.append(date);
		sb.append(", userCode=");
		sb.append(userCode);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WorkingTime toEntityModel() {
		WorkingTimeImpl workingTimeImpl = new WorkingTimeImpl();

		if (uuid == null) {
			workingTimeImpl.setUuid(StringPool.BLANK);
		}
		else {
			workingTimeImpl.setUuid(uuid);
		}

		workingTimeImpl.setWorkingTimeId(workingTimeId);

		if (date == Long.MIN_VALUE) {
			workingTimeImpl.setDate(null);
		}
		else {
			workingTimeImpl.setDate(new Date(date));
		}

		if (userCode == null) {
			workingTimeImpl.setUserCode(StringPool.BLANK);
		}
		else {
			workingTimeImpl.setUserCode(userCode);
		}

		if (startTime == Long.MIN_VALUE) {
			workingTimeImpl.setStartTime(null);
		}
		else {
			workingTimeImpl.setStartTime(new Date(startTime));
		}

		if (endTime == Long.MIN_VALUE) {
			workingTimeImpl.setEndTime(null);
		}
		else {
			workingTimeImpl.setEndTime(new Date(endTime));
		}

		workingTimeImpl.resetOriginalValues();

		return workingTimeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		workingTimeId = objectInput.readLong();
		date = objectInput.readLong();
		userCode = objectInput.readUTF();
		startTime = objectInput.readLong();
		endTime = objectInput.readLong();
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

		objectOutput.writeLong(workingTimeId);
		objectOutput.writeLong(date);

		if (userCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userCode);
		}

		objectOutput.writeLong(startTime);
		objectOutput.writeLong(endTime);
	}

	public String uuid;
	public long workingTimeId;
	public long date;
	public String userCode;
	public long startTime;
	public long endTime;
}