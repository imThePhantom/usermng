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

package com.liferay.usermanagement.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.liferay.usermanagement.exception.NoSuchDepartmentException;
import com.liferay.usermanagement.model.Department;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for Department. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author phantoan
 * @see DepartmentLocalServiceUtil
 * @see com.liferay.usermanagement.service.base.DepartmentLocalServiceBaseImpl
 * @see com.liferay.usermanagement.service.impl.DepartmentLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface DepartmentLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DepartmentLocalServiceUtil} to access the department local service. Add custom service methods to {@link com.liferay.usermanagement.service.impl.DepartmentLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public DynamicQuery dynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Adds the department to the database. Also notifies the appropriate model listeners.
	*
	* @param department the department
	* @return the department that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Department addDepartment(Department department);

	public Department addDepartment(java.lang.String departmentCode,
		java.lang.String departmentName, java.lang.String leaderCode,
		java.lang.String description, ServiceContext serviceContext)
		throws PortalException, SystemException;

	/**
	* Creates a new department with the primary key. Does not add the department to the database.
	*
	* @param departmentCode the primary key for the new department
	* @return the new department
	*/
	public Department createDepartment(java.lang.String departmentCode);

	/**
	* Deletes the department from the database. Also notifies the appropriate model listeners.
	*
	* @param department the department
	* @return the department that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public Department deleteDepartment(Department department);

	/**
	* Deletes the department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param departmentCode the primary key of the department
	* @return the department that was removed
	* @throws PortalException if a department with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Department deleteDepartment(java.lang.String departmentCode)
		throws PortalException;

	public Department deleteDepartment(java.lang.String departmentCode,
		ServiceContext serviceContext) throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Department fetchDepartment(java.lang.String departmentCode);

	/**
	* Returns the department matching the UUID and group.
	*
	* @param uuid the department's UUID
	* @param groupId the primary key of the group
	* @return the matching department, or <code>null</code> if a matching department could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Department fetchDepartmentByUuidAndGroupId(java.lang.String uuid,
		long groupId);

	/**
	* Returns the department with the primary key.
	*
	* @param departmentCode the primary key of the department
	* @return the department
	* @throws PortalException if a department with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Department getDepartment(java.lang.String departmentCode)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Department getDepartmentByName(java.lang.String departmentName)
		throws SystemException, NoSuchDepartmentException;

	/**
	* Returns the department matching the UUID and group.
	*
	* @param uuid the department's UUID
	* @param groupId the primary key of the group
	* @return the matching department
	* @throws PortalException if a matching department could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Department getDepartmentByUuidAndGroupId(java.lang.String uuid,
		long groupId) throws PortalException;

	/**
	* Updates the department in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param department the department
	* @return the department that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Department updateDepartment(Department department);

	public Department updateDepartment(java.lang.String departmentCode,
		java.lang.String departmentName, java.lang.String leaderCode,
		java.lang.String description, ServiceContext serviceContext)
		throws PortalException, SystemException;

	/**
	* Returns the number of departments.
	*
	* @return the number of departments
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDepartmentsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDepartmentsCount(long groupId) throws SystemException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.usermanagement.model.impl.DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.usermanagement.model.impl.DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns a range of all the departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.usermanagement.model.impl.DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @return the range of departments
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Department> getDepartments(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Department> getDepartments(long groupId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Department> getDepartments(long groupId, int start, int end)
		throws SystemException;

	/**
	* Returns all the departments matching the UUID and company.
	*
	* @param uuid the UUID of the departments
	* @param companyId the primary key of the company
	* @return the matching departments, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Department> getDepartmentsByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

	/**
	* Returns a range of departments matching the UUID and company.
	*
	* @param uuid the UUID of the departments
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching departments, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Department> getDepartmentsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<Department> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);
}