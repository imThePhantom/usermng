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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Department. This utility wraps
 * {@link com.liferay.usermanagement.service.impl.DepartmentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author phantoan
 * @see DepartmentLocalService
 * @see com.liferay.usermanagement.service.base.DepartmentLocalServiceBaseImpl
 * @see com.liferay.usermanagement.service.impl.DepartmentLocalServiceImpl
 * @generated
 */
@ProviderType
public class DepartmentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.usermanagement.service.impl.DepartmentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the department to the database. Also notifies the appropriate model listeners.
	*
	* @param department the department
	* @return the department that was added
	*/
	public static com.liferay.usermanagement.model.Department addDepartment(
		com.liferay.usermanagement.model.Department department) {
		return getService().addDepartment(department);
	}

	public static com.liferay.usermanagement.model.Department addDepartment(
		java.lang.String departmentCode, java.lang.String departmentName,
		java.lang.String leaderCode, java.lang.String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addDepartment(departmentCode, departmentName, leaderCode,
			description, serviceContext);
	}

	/**
	* Creates a new department with the primary key. Does not add the department to the database.
	*
	* @param departmentCode the primary key for the new department
	* @return the new department
	*/
	public static com.liferay.usermanagement.model.Department createDepartment(
		java.lang.String departmentCode) {
		return getService().createDepartment(departmentCode);
	}

	/**
	* Deletes the department from the database. Also notifies the appropriate model listeners.
	*
	* @param department the department
	* @return the department that was removed
	*/
	public static com.liferay.usermanagement.model.Department deleteDepartment(
		com.liferay.usermanagement.model.Department department) {
		return getService().deleteDepartment(department);
	}

	/**
	* Deletes the department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param departmentCode the primary key of the department
	* @return the department that was removed
	* @throws PortalException if a department with the primary key could not be found
	*/
	public static com.liferay.usermanagement.model.Department deleteDepartment(
		java.lang.String departmentCode)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteDepartment(departmentCode);
	}

	public static com.liferay.usermanagement.model.Department deleteDepartment(
		java.lang.String departmentCode,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDepartment(departmentCode, serviceContext);
	}

	public static com.liferay.usermanagement.model.Department fetchDepartment(
		java.lang.String departmentCode) {
		return getService().fetchDepartment(departmentCode);
	}

	public static com.liferay.usermanagement.model.Department fetchDepartmentByName(
		java.lang.String departmentName) {
		return getService().fetchDepartmentByName(departmentName);
	}

	/**
	* Returns the department matching the UUID and group.
	*
	* @param uuid the department's UUID
	* @param groupId the primary key of the group
	* @return the matching department, or <code>null</code> if a matching department could not be found
	*/
	public static com.liferay.usermanagement.model.Department fetchDepartmentByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchDepartmentByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.usermanagement.model.Department fetchDepartmetnByCode(
		java.lang.String departmentCode) {
		return getService().fetchDepartmetnByCode(departmentCode);
	}

	/**
	* Returns the department with the primary key.
	*
	* @param departmentCode the primary key of the department
	* @return the department
	* @throws PortalException if a department with the primary key could not be found
	*/
	public static com.liferay.usermanagement.model.Department getDepartment(
		java.lang.String departmentCode)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getDepartment(departmentCode);
	}

	/**
	* Returns the department matching the UUID and group.
	*
	* @param uuid the department's UUID
	* @param groupId the primary key of the group
	* @return the matching department
	* @throws PortalException if a matching department could not be found
	*/
	public static com.liferay.usermanagement.model.Department getDepartmentByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getDepartmentByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the department in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param department the department
	* @return the department that was updated
	*/
	public static com.liferay.usermanagement.model.Department updateDepartment(
		com.liferay.usermanagement.model.Department department) {
		return getService().updateDepartment(department);
	}

	public static com.liferay.usermanagement.model.Department updateDepartment(
		java.lang.String departmentCode, java.lang.String departmentName,
		java.lang.String leaderCode, java.lang.String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateDepartment(departmentCode, departmentName,
			leaderCode, description, serviceContext);
	}

	/**
	* Returns the number of departments.
	*
	* @return the number of departments
	*/
	public static int getDepartmentsCount() {
		return getService().getDepartmentsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<com.liferay.usermanagement.model.Department> getDepartments()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDepartments();
	}

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
	public static java.util.List<com.liferay.usermanagement.model.Department> getDepartments(
		int start, int end) {
		return getService().getDepartments(start, end);
	}

	/**
	* Returns all the departments matching the UUID and company.
	*
	* @param uuid the UUID of the departments
	* @param companyId the primary key of the company
	* @return the matching departments, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.usermanagement.model.Department> getDepartmentsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getDepartmentsByUuidAndCompanyId(uuid, companyId);
	}

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
	public static java.util.List<com.liferay.usermanagement.model.Department> getDepartmentsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.usermanagement.model.Department> orderByComparator) {
		return getService()
				   .getDepartmentsByUuidAndCompanyId(uuid, companyId, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static DepartmentLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DepartmentLocalService, DepartmentLocalService> _serviceTracker =
		ServiceTrackerFactory.open(DepartmentLocalService.class);
}