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

package com.liferay.usermanagement.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.liferay.usermanagement.model.Department;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the department service. This utility wraps {@link com.liferay.usermanagement.service.persistence.impl.DepartmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author phantoan
 * @see DepartmentPersistence
 * @see com.liferay.usermanagement.service.persistence.impl.DepartmentPersistenceImpl
 * @generated
 */
@ProviderType
public class DepartmentUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Department department) {
		getPersistence().clearCache(department);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Department> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Department> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Department> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Department> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Department update(Department department) {
		return getPersistence().update(department);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Department update(Department department,
		ServiceContext serviceContext) {
		return getPersistence().update(department, serviceContext);
	}

	/**
	* Returns all the departments where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching departments
	*/
	public static List<Department> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the departments where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @return the range of matching departments
	*/
	public static List<Department> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the departments where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching departments
	*/
	public static List<Department> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Department> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the departments where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching departments
	*/
	public static List<Department> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Department> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first department in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching department
	* @throws NoSuchDepartmentException if a matching department could not be found
	*/
	public static Department findByUuid_First(java.lang.String uuid,
		OrderByComparator<Department> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchDepartmentException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first department in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching department, or <code>null</code> if a matching department could not be found
	*/
	public static Department fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Department> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last department in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching department
	* @throws NoSuchDepartmentException if a matching department could not be found
	*/
	public static Department findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Department> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchDepartmentException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last department in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching department, or <code>null</code> if a matching department could not be found
	*/
	public static Department fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Department> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the departments before and after the current department in the ordered set where uuid = &#63;.
	*
	* @param departmentCode the primary key of the current department
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next department
	* @throws NoSuchDepartmentException if a department with the primary key could not be found
	*/
	public static Department[] findByUuid_PrevAndNext(
		java.lang.String departmentCode, java.lang.String uuid,
		OrderByComparator<Department> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchDepartmentException {
		return getPersistence()
				   .findByUuid_PrevAndNext(departmentCode, uuid,
			orderByComparator);
	}

	/**
	* Removes all the departments where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of departments where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching departments
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the department where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchDepartmentException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching department
	* @throws NoSuchDepartmentException if a matching department could not be found
	*/
	public static Department findByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.usermanagement.exception.NoSuchDepartmentException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the department where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching department, or <code>null</code> if a matching department could not be found
	*/
	public static Department fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the department where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching department, or <code>null</code> if a matching department could not be found
	*/
	public static Department fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the department where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the department that was removed
	*/
	public static Department removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.usermanagement.exception.NoSuchDepartmentException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of departments where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching departments
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the departments where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching departments
	*/
	public static List<Department> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the departments where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @return the range of matching departments
	*/
	public static List<Department> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the departments where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching departments
	*/
	public static List<Department> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Department> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the departments where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching departments
	*/
	public static List<Department> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Department> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first department in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching department
	* @throws NoSuchDepartmentException if a matching department could not be found
	*/
	public static Department findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Department> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchDepartmentException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first department in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching department, or <code>null</code> if a matching department could not be found
	*/
	public static Department fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Department> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last department in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching department
	* @throws NoSuchDepartmentException if a matching department could not be found
	*/
	public static Department findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Department> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchDepartmentException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last department in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching department, or <code>null</code> if a matching department could not be found
	*/
	public static Department fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Department> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the departments before and after the current department in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param departmentCode the primary key of the current department
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next department
	* @throws NoSuchDepartmentException if a department with the primary key could not be found
	*/
	public static Department[] findByUuid_C_PrevAndNext(
		java.lang.String departmentCode, java.lang.String uuid, long companyId,
		OrderByComparator<Department> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchDepartmentException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(departmentCode, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the departments where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of departments where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching departments
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the departments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching departments
	*/
	public static List<Department> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the departments where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @return the range of matching departments
	*/
	public static List<Department> findByGroupId(long groupId, int start,
		int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the departments where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching departments
	*/
	public static List<Department> findByGroupId(long groupId, int start,
		int end, OrderByComparator<Department> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the departments where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching departments
	*/
	public static List<Department> findByGroupId(long groupId, int start,
		int end, OrderByComparator<Department> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first department in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching department
	* @throws NoSuchDepartmentException if a matching department could not be found
	*/
	public static Department findByGroupId_First(long groupId,
		OrderByComparator<Department> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchDepartmentException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first department in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching department, or <code>null</code> if a matching department could not be found
	*/
	public static Department fetchByGroupId_First(long groupId,
		OrderByComparator<Department> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last department in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching department
	* @throws NoSuchDepartmentException if a matching department could not be found
	*/
	public static Department findByGroupId_Last(long groupId,
		OrderByComparator<Department> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchDepartmentException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last department in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching department, or <code>null</code> if a matching department could not be found
	*/
	public static Department fetchByGroupId_Last(long groupId,
		OrderByComparator<Department> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the departments before and after the current department in the ordered set where groupId = &#63;.
	*
	* @param departmentCode the primary key of the current department
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next department
	* @throws NoSuchDepartmentException if a department with the primary key could not be found
	*/
	public static Department[] findByGroupId_PrevAndNext(
		java.lang.String departmentCode, long groupId,
		OrderByComparator<Department> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchDepartmentException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(departmentCode, groupId,
			orderByComparator);
	}

	/**
	* Removes all the departments where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of departments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching departments
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the departments where departmentName = &#63;.
	*
	* @param departmentName the department name
	* @return the matching departments
	*/
	public static List<Department> findByDepartmentName(
		java.lang.String departmentName) {
		return getPersistence().findByDepartmentName(departmentName);
	}

	/**
	* Returns a range of all the departments where departmentName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentName the department name
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @return the range of matching departments
	*/
	public static List<Department> findByDepartmentName(
		java.lang.String departmentName, int start, int end) {
		return getPersistence().findByDepartmentName(departmentName, start, end);
	}

	/**
	* Returns an ordered range of all the departments where departmentName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentName the department name
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching departments
	*/
	public static List<Department> findByDepartmentName(
		java.lang.String departmentName, int start, int end,
		OrderByComparator<Department> orderByComparator) {
		return getPersistence()
				   .findByDepartmentName(departmentName, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the departments where departmentName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentName the department name
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching departments
	*/
	public static List<Department> findByDepartmentName(
		java.lang.String departmentName, int start, int end,
		OrderByComparator<Department> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByDepartmentName(departmentName, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first department in the ordered set where departmentName = &#63;.
	*
	* @param departmentName the department name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching department
	* @throws NoSuchDepartmentException if a matching department could not be found
	*/
	public static Department findByDepartmentName_First(
		java.lang.String departmentName,
		OrderByComparator<Department> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchDepartmentException {
		return getPersistence()
				   .findByDepartmentName_First(departmentName, orderByComparator);
	}

	/**
	* Returns the first department in the ordered set where departmentName = &#63;.
	*
	* @param departmentName the department name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching department, or <code>null</code> if a matching department could not be found
	*/
	public static Department fetchByDepartmentName_First(
		java.lang.String departmentName,
		OrderByComparator<Department> orderByComparator) {
		return getPersistence()
				   .fetchByDepartmentName_First(departmentName,
			orderByComparator);
	}

	/**
	* Returns the last department in the ordered set where departmentName = &#63;.
	*
	* @param departmentName the department name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching department
	* @throws NoSuchDepartmentException if a matching department could not be found
	*/
	public static Department findByDepartmentName_Last(
		java.lang.String departmentName,
		OrderByComparator<Department> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchDepartmentException {
		return getPersistence()
				   .findByDepartmentName_Last(departmentName, orderByComparator);
	}

	/**
	* Returns the last department in the ordered set where departmentName = &#63;.
	*
	* @param departmentName the department name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching department, or <code>null</code> if a matching department could not be found
	*/
	public static Department fetchByDepartmentName_Last(
		java.lang.String departmentName,
		OrderByComparator<Department> orderByComparator) {
		return getPersistence()
				   .fetchByDepartmentName_Last(departmentName, orderByComparator);
	}

	/**
	* Returns the departments before and after the current department in the ordered set where departmentName = &#63;.
	*
	* @param departmentCode the primary key of the current department
	* @param departmentName the department name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next department
	* @throws NoSuchDepartmentException if a department with the primary key could not be found
	*/
	public static Department[] findByDepartmentName_PrevAndNext(
		java.lang.String departmentCode, java.lang.String departmentName,
		OrderByComparator<Department> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchDepartmentException {
		return getPersistence()
				   .findByDepartmentName_PrevAndNext(departmentCode,
			departmentName, orderByComparator);
	}

	/**
	* Removes all the departments where departmentName = &#63; from the database.
	*
	* @param departmentName the department name
	*/
	public static void removeByDepartmentName(java.lang.String departmentName) {
		getPersistence().removeByDepartmentName(departmentName);
	}

	/**
	* Returns the number of departments where departmentName = &#63;.
	*
	* @param departmentName the department name
	* @return the number of matching departments
	*/
	public static int countByDepartmentName(java.lang.String departmentName) {
		return getPersistence().countByDepartmentName(departmentName);
	}

	/**
	* Returns all the departments where departmentCode = &#63;.
	*
	* @param departmentCode the department code
	* @return the matching departments
	*/
	public static List<Department> findByCode(java.lang.String departmentCode) {
		return getPersistence().findByCode(departmentCode);
	}

	/**
	* Returns a range of all the departments where departmentCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentCode the department code
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @return the range of matching departments
	*/
	public static List<Department> findByCode(java.lang.String departmentCode,
		int start, int end) {
		return getPersistence().findByCode(departmentCode, start, end);
	}

	/**
	* Returns an ordered range of all the departments where departmentCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentCode the department code
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching departments
	*/
	public static List<Department> findByCode(java.lang.String departmentCode,
		int start, int end, OrderByComparator<Department> orderByComparator) {
		return getPersistence()
				   .findByCode(departmentCode, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the departments where departmentCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentCode the department code
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching departments
	*/
	public static List<Department> findByCode(java.lang.String departmentCode,
		int start, int end, OrderByComparator<Department> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCode(departmentCode, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first department in the ordered set where departmentCode = &#63;.
	*
	* @param departmentCode the department code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching department
	* @throws NoSuchDepartmentException if a matching department could not be found
	*/
	public static Department findByCode_First(java.lang.String departmentCode,
		OrderByComparator<Department> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchDepartmentException {
		return getPersistence()
				   .findByCode_First(departmentCode, orderByComparator);
	}

	/**
	* Returns the first department in the ordered set where departmentCode = &#63;.
	*
	* @param departmentCode the department code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching department, or <code>null</code> if a matching department could not be found
	*/
	public static Department fetchByCode_First(
		java.lang.String departmentCode,
		OrderByComparator<Department> orderByComparator) {
		return getPersistence()
				   .fetchByCode_First(departmentCode, orderByComparator);
	}

	/**
	* Returns the last department in the ordered set where departmentCode = &#63;.
	*
	* @param departmentCode the department code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching department
	* @throws NoSuchDepartmentException if a matching department could not be found
	*/
	public static Department findByCode_Last(java.lang.String departmentCode,
		OrderByComparator<Department> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchDepartmentException {
		return getPersistence()
				   .findByCode_Last(departmentCode, orderByComparator);
	}

	/**
	* Returns the last department in the ordered set where departmentCode = &#63;.
	*
	* @param departmentCode the department code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching department, or <code>null</code> if a matching department could not be found
	*/
	public static Department fetchByCode_Last(java.lang.String departmentCode,
		OrderByComparator<Department> orderByComparator) {
		return getPersistence()
				   .fetchByCode_Last(departmentCode, orderByComparator);
	}

	/**
	* Removes all the departments where departmentCode = &#63; from the database.
	*
	* @param departmentCode the department code
	*/
	public static void removeByCode(java.lang.String departmentCode) {
		getPersistence().removeByCode(departmentCode);
	}

	/**
	* Returns the number of departments where departmentCode = &#63;.
	*
	* @param departmentCode the department code
	* @return the number of matching departments
	*/
	public static int countByCode(java.lang.String departmentCode) {
		return getPersistence().countByCode(departmentCode);
	}

	/**
	* Caches the department in the entity cache if it is enabled.
	*
	* @param department the department
	*/
	public static void cacheResult(Department department) {
		getPersistence().cacheResult(department);
	}

	/**
	* Caches the departments in the entity cache if it is enabled.
	*
	* @param departments the departments
	*/
	public static void cacheResult(List<Department> departments) {
		getPersistence().cacheResult(departments);
	}

	/**
	* Creates a new department with the primary key. Does not add the department to the database.
	*
	* @param departmentCode the primary key for the new department
	* @return the new department
	*/
	public static Department create(java.lang.String departmentCode) {
		return getPersistence().create(departmentCode);
	}

	/**
	* Removes the department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param departmentCode the primary key of the department
	* @return the department that was removed
	* @throws NoSuchDepartmentException if a department with the primary key could not be found
	*/
	public static Department remove(java.lang.String departmentCode)
		throws com.liferay.usermanagement.exception.NoSuchDepartmentException {
		return getPersistence().remove(departmentCode);
	}

	public static Department updateImpl(Department department) {
		return getPersistence().updateImpl(department);
	}

	/**
	* Returns the department with the primary key or throws a {@link NoSuchDepartmentException} if it could not be found.
	*
	* @param departmentCode the primary key of the department
	* @return the department
	* @throws NoSuchDepartmentException if a department with the primary key could not be found
	*/
	public static Department findByPrimaryKey(java.lang.String departmentCode)
		throws com.liferay.usermanagement.exception.NoSuchDepartmentException {
		return getPersistence().findByPrimaryKey(departmentCode);
	}

	/**
	* Returns the department with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param departmentCode the primary key of the department
	* @return the department, or <code>null</code> if a department with the primary key could not be found
	*/
	public static Department fetchByPrimaryKey(java.lang.String departmentCode) {
		return getPersistence().fetchByPrimaryKey(departmentCode);
	}

	public static java.util.Map<java.io.Serializable, Department> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the departments.
	*
	* @return the departments
	*/
	public static List<Department> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @return the range of departments
	*/
	public static List<Department> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of departments
	*/
	public static List<Department> findAll(int start, int end,
		OrderByComparator<Department> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of departments
	*/
	public static List<Department> findAll(int start, int end,
		OrderByComparator<Department> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the departments from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of departments.
	*
	* @return the number of departments
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static DepartmentPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DepartmentPersistence, DepartmentPersistence> _serviceTracker =
		ServiceTrackerFactory.open(DepartmentPersistence.class);
}