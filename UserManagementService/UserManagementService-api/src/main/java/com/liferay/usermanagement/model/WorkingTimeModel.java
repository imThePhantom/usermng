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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the WorkingTime service. Represents a row in the &quot;CRM_WorkingTime&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.usermanagement.model.impl.WorkingTimeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.usermanagement.model.impl.WorkingTimeImpl}.
 * </p>
 *
 * @author phantoan
 * @see WorkingTime
 * @see com.liferay.usermanagement.model.impl.WorkingTimeImpl
 * @see com.liferay.usermanagement.model.impl.WorkingTimeModelImpl
 * @generated
 */
@ProviderType
public interface WorkingTimeModel extends BaseModel<WorkingTime> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a working time model instance should use the {@link WorkingTime} interface instead.
	 */

	/**
	 * Returns the primary key of this working time.
	 *
	 * @return the primary key of this working time
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this working time.
	 *
	 * @param primaryKey the primary key of this working time
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this working time.
	 *
	 * @return the uuid of this working time
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this working time.
	 *
	 * @param uuid the uuid of this working time
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the working time ID of this working time.
	 *
	 * @return the working time ID of this working time
	 */
	public long getWorkingTimeId();

	/**
	 * Sets the working time ID of this working time.
	 *
	 * @param workingTimeId the working time ID of this working time
	 */
	public void setWorkingTimeId(long workingTimeId);

	/**
	 * Returns the date of this working time.
	 *
	 * @return the date of this working time
	 */
	public Date getDate();

	/**
	 * Sets the date of this working time.
	 *
	 * @param date the date of this working time
	 */
	public void setDate(Date date);

	/**
	 * Returns the user code of this working time.
	 *
	 * @return the user code of this working time
	 */
	@AutoEscape
	public String getUserCode();

	/**
	 * Sets the user code of this working time.
	 *
	 * @param userCode the user code of this working time
	 */
	public void setUserCode(String userCode);

	/**
	 * Returns the start time of this working time.
	 *
	 * @return the start time of this working time
	 */
	public Date getStartTime();

	/**
	 * Sets the start time of this working time.
	 *
	 * @param startTime the start time of this working time
	 */
	public void setStartTime(Date startTime);

	/**
	 * Returns the end time of this working time.
	 *
	 * @return the end time of this working time
	 */
	public Date getEndTime();

	/**
	 * Sets the end time of this working time.
	 *
	 * @param endTime the end time of this working time
	 */
	public void setEndTime(Date endTime);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(WorkingTime workingTime);

	@Override
	public int hashCode();

	@Override
	public CacheModel<WorkingTime> toCacheModel();

	@Override
	public WorkingTime toEscapedModel();

	@Override
	public WorkingTime toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}