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
 * This class is a wrapper for {@link Department}.
 * </p>
 *
 * @author phantoan
 * @see Department
 * @generated
 */
@ProviderType
public class DepartmentWrapper implements Department, ModelWrapper<Department> {
	public DepartmentWrapper(Department department) {
		_department = department;
	}

	@Override
	public Class<?> getModelClass() {
		return Department.class;
	}

	@Override
	public String getModelClassName() {
		return Department.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("departmentCode", getDepartmentCode());
		attributes.put("deapartmentName", getDeapartmentName());
		attributes.put("leaderCode", getLeaderCode());
		attributes.put("description", getDescription());
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

		String departmentCode = (String)attributes.get("departmentCode");

		if (departmentCode != null) {
			setDepartmentCode(departmentCode);
		}

		String deapartmentName = (String)attributes.get("deapartmentName");

		if (deapartmentName != null) {
			setDeapartmentName(deapartmentName);
		}

		String leaderCode = (String)attributes.get("leaderCode");

		if (leaderCode != null) {
			setLeaderCode(leaderCode);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
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
	public Department toEscapedModel() {
		return new DepartmentWrapper(_department.toEscapedModel());
	}

	@Override
	public Department toUnescapedModel() {
		return new DepartmentWrapper(_department.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _department.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _department.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _department.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _department.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Department> toCacheModel() {
		return _department.toCacheModel();
	}

	@Override
	public int compareTo(Department department) {
		return _department.compareTo(department);
	}

	@Override
	public int hashCode() {
		return _department.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _department.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new DepartmentWrapper((Department)_department.clone());
	}

	/**
	* Returns the deapartment name of this department.
	*
	* @return the deapartment name of this department
	*/
	@Override
	public java.lang.String getDeapartmentName() {
		return _department.getDeapartmentName();
	}

	/**
	* Returns the department code of this department.
	*
	* @return the department code of this department
	*/
	@Override
	public java.lang.String getDepartmentCode() {
		return _department.getDepartmentCode();
	}

	/**
	* Returns the description of this department.
	*
	* @return the description of this department
	*/
	@Override
	public java.lang.String getDescription() {
		return _department.getDescription();
	}

	/**
	* Returns the leader code of this department.
	*
	* @return the leader code of this department
	*/
	@Override
	public java.lang.String getLeaderCode() {
		return _department.getLeaderCode();
	}

	/**
	* Returns the primary key of this department.
	*
	* @return the primary key of this department
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _department.getPrimaryKey();
	}

	/**
	* Returns the uuid of this department.
	*
	* @return the uuid of this department
	*/
	@Override
	public java.lang.String getUuid() {
		return _department.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _department.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _department.toXmlString();
	}

	/**
	* Returns the create date of this department.
	*
	* @return the create date of this department
	*/
	@Override
	public Date getCreateDate() {
		return _department.getCreateDate();
	}

	/**
	* Returns the modified date of this department.
	*
	* @return the modified date of this department
	*/
	@Override
	public Date getModifiedDate() {
		return _department.getModifiedDate();
	}

	/**
	* Returns the company ID of this department.
	*
	* @return the company ID of this department
	*/
	@Override
	public long getCompanyId() {
		return _department.getCompanyId();
	}

	/**
	* Returns the group ID of this department.
	*
	* @return the group ID of this department
	*/
	@Override
	public long getGroupId() {
		return _department.getGroupId();
	}

	@Override
	public void persist() {
		_department.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_department.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this department.
	*
	* @param companyId the company ID of this department
	*/
	@Override
	public void setCompanyId(long companyId) {
		_department.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this department.
	*
	* @param createDate the create date of this department
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_department.setCreateDate(createDate);
	}

	/**
	* Sets the deapartment name of this department.
	*
	* @param deapartmentName the deapartment name of this department
	*/
	@Override
	public void setDeapartmentName(java.lang.String deapartmentName) {
		_department.setDeapartmentName(deapartmentName);
	}

	/**
	* Sets the department code of this department.
	*
	* @param departmentCode the department code of this department
	*/
	@Override
	public void setDepartmentCode(java.lang.String departmentCode) {
		_department.setDepartmentCode(departmentCode);
	}

	/**
	* Sets the description of this department.
	*
	* @param description the description of this department
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_department.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_department.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_department.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_department.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this department.
	*
	* @param groupId the group ID of this department
	*/
	@Override
	public void setGroupId(long groupId) {
		_department.setGroupId(groupId);
	}

	/**
	* Sets the leader code of this department.
	*
	* @param leaderCode the leader code of this department
	*/
	@Override
	public void setLeaderCode(java.lang.String leaderCode) {
		_department.setLeaderCode(leaderCode);
	}

	/**
	* Sets the modified date of this department.
	*
	* @param modifiedDate the modified date of this department
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_department.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_department.setNew(n);
	}

	/**
	* Sets the primary key of this department.
	*
	* @param primaryKey the primary key of this department
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_department.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_department.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the uuid of this department.
	*
	* @param uuid the uuid of this department
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_department.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DepartmentWrapper)) {
			return false;
		}

		DepartmentWrapper departmentWrapper = (DepartmentWrapper)obj;

		if (Objects.equals(_department, departmentWrapper._department)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _department.getStagedModelType();
	}

	@Override
	public Department getWrappedModel() {
		return _department;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _department.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _department.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_department.resetOriginalValues();
	}

	private final Department _department;
}