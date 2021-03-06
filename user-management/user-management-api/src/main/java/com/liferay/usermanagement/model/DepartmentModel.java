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
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Department service. Represents a row in the &quot;CRM_Department&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.usermanagement.model.impl.DepartmentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.usermanagement.model.impl.DepartmentImpl}.
 * </p>
 *
 * @author phantoan
 * @see Department
 * @see com.liferay.usermanagement.model.impl.DepartmentImpl
 * @see com.liferay.usermanagement.model.impl.DepartmentModelImpl
 * @generated
 */
@ProviderType
public interface DepartmentModel extends BaseModel<Department>, ShardedModel,
	StagedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a department model instance should use the {@link Department} interface instead.
	 */

	/**
	 * Returns the primary key of this department.
	 *
	 * @return the primary key of this department
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this department.
	 *
	 * @param primaryKey the primary key of this department
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the uuid of this department.
	 *
	 * @return the uuid of this department
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this department.
	 *
	 * @param uuid the uuid of this department
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the department code of this department.
	 *
	 * @return the department code of this department
	 */
	@AutoEscape
	public String getDepartmentCode();

	/**
	 * Sets the department code of this department.
	 *
	 * @param departmentCode the department code of this department
	 */
	public void setDepartmentCode(String departmentCode);

	/**
	 * Returns the department name of this department.
	 *
	 * @return the department name of this department
	 */
	@AutoEscape
	public String getDepartmentName();

	/**
	 * Sets the department name of this department.
	 *
	 * @param departmentName the department name of this department
	 */
	public void setDepartmentName(String departmentName);

	/**
	 * Returns the leader code of this department.
	 *
	 * @return the leader code of this department
	 */
	@AutoEscape
	public String getLeaderCode();

	/**
	 * Sets the leader code of this department.
	 *
	 * @param leaderCode the leader code of this department
	 */
	public void setLeaderCode(String leaderCode);

	/**
	 * Returns the description of this department.
	 *
	 * @return the description of this department
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this department.
	 *
	 * @param description the description of this department
	 */
	public void setDescription(String description);

	/**
	 * Returns the group ID of this department.
	 *
	 * @return the group ID of this department
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this department.
	 *
	 * @param groupId the group ID of this department
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this department.
	 *
	 * @return the company ID of this department
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this department.
	 *
	 * @param companyId the company ID of this department
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this department.
	 *
	 * @return the create date of this department
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this department.
	 *
	 * @param createDate the create date of this department
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this department.
	 *
	 * @return the modified date of this department
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this department.
	 *
	 * @param modifiedDate the modified date of this department
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

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
	public int compareTo(Department department);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Department> toCacheModel();

	@Override
	public Department toEscapedModel();

	@Override
	public Department toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}