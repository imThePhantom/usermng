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

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.usermanagement.exception.DepartmentCodeException;
import com.liferay.usermanagement.exception.DepartmentLeaderCodeException;
import com.liferay.usermanagement.exception.DepartmentNameException;
import com.liferay.usermanagement.model.Department;
import com.liferay.usermanagement.service.base.DepartmentLocalServiceBaseImpl;

/**
 * The implementation of the department local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.usermanagement.service.DepartmentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author phantoan
 * @see DepartmentLocalServiceBaseImpl
 * @see com.liferay.usermanagement.service.DepartmentLocalServiceUtil
 */
@ProviderType
public class DepartmentLocalServiceImpl extends DepartmentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.liferay.usermanagement.service.DepartmentLocalServiceUtil} to access
	 * the department local service.
	 */

	public Department addDepartment(String departmentCode, String departmentName, String leaderCode, String description,
			ServiceContext serviceContext) throws PortalException, SystemException {
		long groupId = serviceContext.getScopeGroupId();
		long companyId = CompanyLocalServiceUtil.getCompanyByWebId("liferay.com").getCompanyId();
		Date now = new Date();
		validate(departmentCode, departmentName, leaderCode);

		Department department = departmentPersistence.create(departmentCode);

		department.setUuid(serviceContext.getUuid());
		department.setDeapartmentName(departmentName);
		department.setLeaderCode(leaderCode);
		department.setDescription(description);
		department.setGroupId(groupId);
		department.setCompanyId(companyId);
		department.setCreateDate(serviceContext.getCreateDate(now));
		department.setModifiedDate(serviceContext.getModifiedDate(now));

		departmentPersistence.update(department);

		Indexer<Department> indexer = IndexerRegistryUtil.nullSafeGetIndexer(Department.class);
		indexer.reindex(department);

		return department;
	}

	public Department deleteDepartment(String departmentCode, ServiceContext serviceContext)
			throws PortalException, SystemException {
		Department department = getDepartment(departmentCode);
		
		Indexer<Department> indexer = IndexerRegistryUtil.nullSafeGetIndexer(Department.class);
		indexer.delete(department);
		
		department = deleteDepartment(departmentCode);
		
		return department;
	}

	public List<Department> getDepartments(long groupId) throws SystemException {
		return departmentPersistence.findByGroupId(groupId);
	}

	public List<Department> getDepartments(long groupId, int start, int end) throws SystemException {
		return departmentPersistence.findByGroupId(groupId, start, end);
	}

	public int getDepartmentsCount(long groupId) throws SystemException {
		List<Department> departments = this.getDepartments(groupId);
		return departments.size();
	}

	public Department updateDepartment(String departmentCode, String departmentName, String leaderCode,
			String description, ServiceContext serviceContext) throws PortalException, SystemException {
		long groupId = serviceContext.getScopeGroupId();
		long companyId = CompanyLocalServiceUtil.getCompanyByWebId("liferay.com").getCompanyId();
		Date now = new Date();
		validate(departmentCode, departmentName, leaderCode);

		Department department = getDepartment(departmentCode);

		department.setUuid(serviceContext.getUuid());
		department.setDeapartmentName(departmentName);
		department.setLeaderCode(leaderCode);
		department.setDescription(description);
		department.setGroupId(groupId);
		department.setCompanyId(companyId);
		department.setCreateDate(serviceContext.getCreateDate(now));
		department.setModifiedDate(serviceContext.getModifiedDate(now));

		departmentPersistence.update(department);

		Indexer<Department> indexer = IndexerRegistryUtil.nullSafeGetIndexer(Department.class);
		indexer.reindex(department);

		return department;
	}

	protected void validate(String departmentCode, String departmentName, String leaderCode) throws PortalException {
		if (Validator.isNull(departmentCode)) {
			throw new DepartmentCodeException();
		}
		if (Validator.isNull(departmentName) || Validator.isAlphanumericName(departmentName)) {
			throw new DepartmentNameException();
		}
		if (Validator.isNull(leaderCode)) {
			throw new DepartmentLeaderCodeException();
		}
	}
}