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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link WorkingTime}.
 * </p>
 *
 * @author phantoan
 * @see WorkingTime
 * @generated
 */
@ProviderType
public class WorkingTimeWrapper implements WorkingTime,
	ModelWrapper<WorkingTime> {
	public WorkingTimeWrapper(WorkingTime workingTime) {
		_workingTime = workingTime;
	}

	@Override
	public Class<?> getModelClass() {
		return WorkingTime.class;
	}

	@Override
	public String getModelClassName() {
		return WorkingTime.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("workingTimeId", getWorkingTimeId());
		attributes.put("date", getDate());
		attributes.put("userCode", getUserCode());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long workingTimeId = (Long)attributes.get("workingTimeId");

		if (workingTimeId != null) {
			setWorkingTimeId(workingTimeId);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		String userCode = (String)attributes.get("userCode");

		if (userCode != null) {
			setUserCode(userCode);
		}

		Date startTime = (Date)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Date endTime = (Date)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}
	}

	@Override
	public WorkingTime toEscapedModel() {
		return new WorkingTimeWrapper(_workingTime.toEscapedModel());
	}

	@Override
	public WorkingTime toUnescapedModel() {
		return new WorkingTimeWrapper(_workingTime.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _workingTime.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _workingTime.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _workingTime.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _workingTime.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<WorkingTime> toCacheModel() {
		return _workingTime.toCacheModel();
	}

	@Override
	public int compareTo(WorkingTime workingTime) {
		return _workingTime.compareTo(workingTime);
	}

	@Override
	public int hashCode() {
		return _workingTime.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _workingTime.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WorkingTimeWrapper((WorkingTime)_workingTime.clone());
	}

	/**
	* Returns the user code of this working time.
	*
	* @return the user code of this working time
	*/
	@Override
	public java.lang.String getUserCode() {
		return _workingTime.getUserCode();
	}

	/**
	* Returns the uuid of this working time.
	*
	* @return the uuid of this working time
	*/
	@Override
	public java.lang.String getUuid() {
		return _workingTime.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _workingTime.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _workingTime.toXmlString();
	}

	/**
	* Returns the date of this working time.
	*
	* @return the date of this working time
	*/
	@Override
	public Date getDate() {
		return _workingTime.getDate();
	}

	/**
	* Returns the end time of this working time.
	*
	* @return the end time of this working time
	*/
	@Override
	public Date getEndTime() {
		return _workingTime.getEndTime();
	}

	/**
	* Returns the start time of this working time.
	*
	* @return the start time of this working time
	*/
	@Override
	public Date getStartTime() {
		return _workingTime.getStartTime();
	}

	/**
	* Returns the primary key of this working time.
	*
	* @return the primary key of this working time
	*/
	@Override
	public long getPrimaryKey() {
		return _workingTime.getPrimaryKey();
	}

	/**
	* Returns the working time ID of this working time.
	*
	* @return the working time ID of this working time
	*/
	@Override
	public long getWorkingTimeId() {
		return _workingTime.getWorkingTimeId();
	}

	@Override
	public void persist() {
		_workingTime.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_workingTime.setCachedModel(cachedModel);
	}

	/**
	* Sets the date of this working time.
	*
	* @param date the date of this working time
	*/
	@Override
	public void setDate(Date date) {
		_workingTime.setDate(date);
	}

	/**
	* Sets the end time of this working time.
	*
	* @param endTime the end time of this working time
	*/
	@Override
	public void setEndTime(Date endTime) {
		_workingTime.setEndTime(endTime);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_workingTime.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_workingTime.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_workingTime.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_workingTime.setNew(n);
	}

	/**
	* Sets the primary key of this working time.
	*
	* @param primaryKey the primary key of this working time
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_workingTime.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_workingTime.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the start time of this working time.
	*
	* @param startTime the start time of this working time
	*/
	@Override
	public void setStartTime(Date startTime) {
		_workingTime.setStartTime(startTime);
	}

	/**
	* Sets the user code of this working time.
	*
	* @param userCode the user code of this working time
	*/
	@Override
	public void setUserCode(java.lang.String userCode) {
		_workingTime.setUserCode(userCode);
	}

	/**
	* Sets the uuid of this working time.
	*
	* @param uuid the uuid of this working time
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_workingTime.setUuid(uuid);
	}

	/**
	* Sets the working time ID of this working time.
	*
	* @param workingTimeId the working time ID of this working time
	*/
	@Override
	public void setWorkingTimeId(long workingTimeId) {
		_workingTime.setWorkingTimeId(workingTimeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkingTimeWrapper)) {
			return false;
		}

		WorkingTimeWrapper workingTimeWrapper = (WorkingTimeWrapper)obj;

		if (Objects.equals(_workingTime, workingTimeWrapper._workingTime)) {
			return true;
		}

		return false;
	}

	@Override
	public WorkingTime getWrappedModel() {
		return _workingTime;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _workingTime.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _workingTime.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_workingTime.resetOriginalValues();
	}

	private final WorkingTime _workingTime;
}