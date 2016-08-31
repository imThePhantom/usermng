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

import com.liferay.usermanagement.model.WorkingTime;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the working time service. This utility wraps {@link com.liferay.usermanagement.service.persistence.impl.WorkingTimePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author phantoan
 * @see WorkingTimePersistence
 * @see com.liferay.usermanagement.service.persistence.impl.WorkingTimePersistenceImpl
 * @generated
 */
@ProviderType
public class WorkingTimeUtil {
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
	public static void clearCache(WorkingTime workingTime) {
		getPersistence().clearCache(workingTime);
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
	public static List<WorkingTime> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkingTime> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkingTime> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WorkingTime> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WorkingTime update(WorkingTime workingTime) {
		return getPersistence().update(workingTime);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WorkingTime update(WorkingTime workingTime,
		ServiceContext serviceContext) {
		return getPersistence().update(workingTime, serviceContext);
	}

	/**
	* Returns all the working times where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching working times
	*/
	public static List<WorkingTime> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the working times where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkingTimeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of working times
	* @param end the upper bound of the range of working times (not inclusive)
	* @return the range of matching working times
	*/
	public static List<WorkingTime> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the working times where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkingTimeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of working times
	* @param end the upper bound of the range of working times (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching working times
	*/
	public static List<WorkingTime> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<WorkingTime> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the working times where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkingTimeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of working times
	* @param end the upper bound of the range of working times (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching working times
	*/
	public static List<WorkingTime> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<WorkingTime> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first working time in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working time
	* @throws NoSuchWorkingTimeException if a matching working time could not be found
	*/
	public static WorkingTime findByUuid_First(java.lang.String uuid,
		OrderByComparator<WorkingTime> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchWorkingTimeException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first working time in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working time, or <code>null</code> if a matching working time could not be found
	*/
	public static WorkingTime fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<WorkingTime> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last working time in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working time
	* @throws NoSuchWorkingTimeException if a matching working time could not be found
	*/
	public static WorkingTime findByUuid_Last(java.lang.String uuid,
		OrderByComparator<WorkingTime> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchWorkingTimeException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last working time in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working time, or <code>null</code> if a matching working time could not be found
	*/
	public static WorkingTime fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<WorkingTime> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the working times before and after the current working time in the ordered set where uuid = &#63;.
	*
	* @param workingTimeId the primary key of the current working time
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next working time
	* @throws NoSuchWorkingTimeException if a working time with the primary key could not be found
	*/
	public static WorkingTime[] findByUuid_PrevAndNext(long workingTimeId,
		java.lang.String uuid, OrderByComparator<WorkingTime> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchWorkingTimeException {
		return getPersistence()
				   .findByUuid_PrevAndNext(workingTimeId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the working times where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of working times where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching working times
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the working time where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchWorkingTimeException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching working time
	* @throws NoSuchWorkingTimeException if a matching working time could not be found
	*/
	public static WorkingTime findByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.usermanagement.exception.NoSuchWorkingTimeException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the working time where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching working time, or <code>null</code> if a matching working time could not be found
	*/
	public static WorkingTime fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the working time where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching working time, or <code>null</code> if a matching working time could not be found
	*/
	public static WorkingTime fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the working time where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the working time that was removed
	*/
	public static WorkingTime removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.usermanagement.exception.NoSuchWorkingTimeException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of working times where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching working times
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the working times where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching working times
	*/
	public static List<WorkingTime> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the working times where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkingTimeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of working times
	* @param end the upper bound of the range of working times (not inclusive)
	* @return the range of matching working times
	*/
	public static List<WorkingTime> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the working times where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkingTimeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of working times
	* @param end the upper bound of the range of working times (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching working times
	*/
	public static List<WorkingTime> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<WorkingTime> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the working times where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkingTimeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of working times
	* @param end the upper bound of the range of working times (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching working times
	*/
	public static List<WorkingTime> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<WorkingTime> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first working time in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working time
	* @throws NoSuchWorkingTimeException if a matching working time could not be found
	*/
	public static WorkingTime findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<WorkingTime> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchWorkingTimeException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first working time in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working time, or <code>null</code> if a matching working time could not be found
	*/
	public static WorkingTime fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<WorkingTime> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last working time in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working time
	* @throws NoSuchWorkingTimeException if a matching working time could not be found
	*/
	public static WorkingTime findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<WorkingTime> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchWorkingTimeException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last working time in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working time, or <code>null</code> if a matching working time could not be found
	*/
	public static WorkingTime fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<WorkingTime> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the working times before and after the current working time in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param workingTimeId the primary key of the current working time
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next working time
	* @throws NoSuchWorkingTimeException if a working time with the primary key could not be found
	*/
	public static WorkingTime[] findByUuid_C_PrevAndNext(long workingTimeId,
		java.lang.String uuid, long companyId,
		OrderByComparator<WorkingTime> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchWorkingTimeException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(workingTimeId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the working times where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of working times where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching working times
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the working times where date = &#63;.
	*
	* @param date the date
	* @return the matching working times
	*/
	public static List<WorkingTime> findByDate(Date date) {
		return getPersistence().findByDate(date);
	}

	/**
	* Returns a range of all the working times where date = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkingTimeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param date the date
	* @param start the lower bound of the range of working times
	* @param end the upper bound of the range of working times (not inclusive)
	* @return the range of matching working times
	*/
	public static List<WorkingTime> findByDate(Date date, int start, int end) {
		return getPersistence().findByDate(date, start, end);
	}

	/**
	* Returns an ordered range of all the working times where date = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkingTimeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param date the date
	* @param start the lower bound of the range of working times
	* @param end the upper bound of the range of working times (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching working times
	*/
	public static List<WorkingTime> findByDate(Date date, int start, int end,
		OrderByComparator<WorkingTime> orderByComparator) {
		return getPersistence().findByDate(date, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the working times where date = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkingTimeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param date the date
	* @param start the lower bound of the range of working times
	* @param end the upper bound of the range of working times (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching working times
	*/
	public static List<WorkingTime> findByDate(Date date, int start, int end,
		OrderByComparator<WorkingTime> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByDate(date, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first working time in the ordered set where date = &#63;.
	*
	* @param date the date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working time
	* @throws NoSuchWorkingTimeException if a matching working time could not be found
	*/
	public static WorkingTime findByDate_First(Date date,
		OrderByComparator<WorkingTime> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchWorkingTimeException {
		return getPersistence().findByDate_First(date, orderByComparator);
	}

	/**
	* Returns the first working time in the ordered set where date = &#63;.
	*
	* @param date the date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working time, or <code>null</code> if a matching working time could not be found
	*/
	public static WorkingTime fetchByDate_First(Date date,
		OrderByComparator<WorkingTime> orderByComparator) {
		return getPersistence().fetchByDate_First(date, orderByComparator);
	}

	/**
	* Returns the last working time in the ordered set where date = &#63;.
	*
	* @param date the date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working time
	* @throws NoSuchWorkingTimeException if a matching working time could not be found
	*/
	public static WorkingTime findByDate_Last(Date date,
		OrderByComparator<WorkingTime> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchWorkingTimeException {
		return getPersistence().findByDate_Last(date, orderByComparator);
	}

	/**
	* Returns the last working time in the ordered set where date = &#63;.
	*
	* @param date the date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working time, or <code>null</code> if a matching working time could not be found
	*/
	public static WorkingTime fetchByDate_Last(Date date,
		OrderByComparator<WorkingTime> orderByComparator) {
		return getPersistence().fetchByDate_Last(date, orderByComparator);
	}

	/**
	* Returns the working times before and after the current working time in the ordered set where date = &#63;.
	*
	* @param workingTimeId the primary key of the current working time
	* @param date the date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next working time
	* @throws NoSuchWorkingTimeException if a working time with the primary key could not be found
	*/
	public static WorkingTime[] findByDate_PrevAndNext(long workingTimeId,
		Date date, OrderByComparator<WorkingTime> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchWorkingTimeException {
		return getPersistence()
				   .findByDate_PrevAndNext(workingTimeId, date,
			orderByComparator);
	}

	/**
	* Removes all the working times where date = &#63; from the database.
	*
	* @param date the date
	*/
	public static void removeByDate(Date date) {
		getPersistence().removeByDate(date);
	}

	/**
	* Returns the number of working times where date = &#63;.
	*
	* @param date the date
	* @return the number of matching working times
	*/
	public static int countByDate(Date date) {
		return getPersistence().countByDate(date);
	}

	/**
	* Returns all the working times where userCode = &#63;.
	*
	* @param userCode the user code
	* @return the matching working times
	*/
	public static List<WorkingTime> findByuserCode(java.lang.String userCode) {
		return getPersistence().findByuserCode(userCode);
	}

	/**
	* Returns a range of all the working times where userCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkingTimeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userCode the user code
	* @param start the lower bound of the range of working times
	* @param end the upper bound of the range of working times (not inclusive)
	* @return the range of matching working times
	*/
	public static List<WorkingTime> findByuserCode(java.lang.String userCode,
		int start, int end) {
		return getPersistence().findByuserCode(userCode, start, end);
	}

	/**
	* Returns an ordered range of all the working times where userCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkingTimeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userCode the user code
	* @param start the lower bound of the range of working times
	* @param end the upper bound of the range of working times (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching working times
	*/
	public static List<WorkingTime> findByuserCode(java.lang.String userCode,
		int start, int end, OrderByComparator<WorkingTime> orderByComparator) {
		return getPersistence()
				   .findByuserCode(userCode, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the working times where userCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkingTimeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userCode the user code
	* @param start the lower bound of the range of working times
	* @param end the upper bound of the range of working times (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching working times
	*/
	public static List<WorkingTime> findByuserCode(java.lang.String userCode,
		int start, int end, OrderByComparator<WorkingTime> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByuserCode(userCode, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first working time in the ordered set where userCode = &#63;.
	*
	* @param userCode the user code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working time
	* @throws NoSuchWorkingTimeException if a matching working time could not be found
	*/
	public static WorkingTime findByuserCode_First(java.lang.String userCode,
		OrderByComparator<WorkingTime> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchWorkingTimeException {
		return getPersistence().findByuserCode_First(userCode, orderByComparator);
	}

	/**
	* Returns the first working time in the ordered set where userCode = &#63;.
	*
	* @param userCode the user code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working time, or <code>null</code> if a matching working time could not be found
	*/
	public static WorkingTime fetchByuserCode_First(java.lang.String userCode,
		OrderByComparator<WorkingTime> orderByComparator) {
		return getPersistence()
				   .fetchByuserCode_First(userCode, orderByComparator);
	}

	/**
	* Returns the last working time in the ordered set where userCode = &#63;.
	*
	* @param userCode the user code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working time
	* @throws NoSuchWorkingTimeException if a matching working time could not be found
	*/
	public static WorkingTime findByuserCode_Last(java.lang.String userCode,
		OrderByComparator<WorkingTime> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchWorkingTimeException {
		return getPersistence().findByuserCode_Last(userCode, orderByComparator);
	}

	/**
	* Returns the last working time in the ordered set where userCode = &#63;.
	*
	* @param userCode the user code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working time, or <code>null</code> if a matching working time could not be found
	*/
	public static WorkingTime fetchByuserCode_Last(java.lang.String userCode,
		OrderByComparator<WorkingTime> orderByComparator) {
		return getPersistence().fetchByuserCode_Last(userCode, orderByComparator);
	}

	/**
	* Returns the working times before and after the current working time in the ordered set where userCode = &#63;.
	*
	* @param workingTimeId the primary key of the current working time
	* @param userCode the user code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next working time
	* @throws NoSuchWorkingTimeException if a working time with the primary key could not be found
	*/
	public static WorkingTime[] findByuserCode_PrevAndNext(long workingTimeId,
		java.lang.String userCode,
		OrderByComparator<WorkingTime> orderByComparator)
		throws com.liferay.usermanagement.exception.NoSuchWorkingTimeException {
		return getPersistence()
				   .findByuserCode_PrevAndNext(workingTimeId, userCode,
			orderByComparator);
	}

	/**
	* Removes all the working times where userCode = &#63; from the database.
	*
	* @param userCode the user code
	*/
	public static void removeByuserCode(java.lang.String userCode) {
		getPersistence().removeByuserCode(userCode);
	}

	/**
	* Returns the number of working times where userCode = &#63;.
	*
	* @param userCode the user code
	* @return the number of matching working times
	*/
	public static int countByuserCode(java.lang.String userCode) {
		return getPersistence().countByuserCode(userCode);
	}

	/**
	* Returns the working time where userCode = &#63; and date = &#63; or throws a {@link NoSuchWorkingTimeException} if it could not be found.
	*
	* @param userCode the user code
	* @param date the date
	* @return the matching working time
	* @throws NoSuchWorkingTimeException if a matching working time could not be found
	*/
	public static WorkingTime findByC_D(java.lang.String userCode, Date date)
		throws com.liferay.usermanagement.exception.NoSuchWorkingTimeException {
		return getPersistence().findByC_D(userCode, date);
	}

	/**
	* Returns the working time where userCode = &#63; and date = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userCode the user code
	* @param date the date
	* @return the matching working time, or <code>null</code> if a matching working time could not be found
	*/
	public static WorkingTime fetchByC_D(java.lang.String userCode, Date date) {
		return getPersistence().fetchByC_D(userCode, date);
	}

	/**
	* Returns the working time where userCode = &#63; and date = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userCode the user code
	* @param date the date
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching working time, or <code>null</code> if a matching working time could not be found
	*/
	public static WorkingTime fetchByC_D(java.lang.String userCode, Date date,
		boolean retrieveFromCache) {
		return getPersistence().fetchByC_D(userCode, date, retrieveFromCache);
	}

	/**
	* Removes the working time where userCode = &#63; and date = &#63; from the database.
	*
	* @param userCode the user code
	* @param date the date
	* @return the working time that was removed
	*/
	public static WorkingTime removeByC_D(java.lang.String userCode, Date date)
		throws com.liferay.usermanagement.exception.NoSuchWorkingTimeException {
		return getPersistence().removeByC_D(userCode, date);
	}

	/**
	* Returns the number of working times where userCode = &#63; and date = &#63;.
	*
	* @param userCode the user code
	* @param date the date
	* @return the number of matching working times
	*/
	public static int countByC_D(java.lang.String userCode, Date date) {
		return getPersistence().countByC_D(userCode, date);
	}

	/**
	* Caches the working time in the entity cache if it is enabled.
	*
	* @param workingTime the working time
	*/
	public static void cacheResult(WorkingTime workingTime) {
		getPersistence().cacheResult(workingTime);
	}

	/**
	* Caches the working times in the entity cache if it is enabled.
	*
	* @param workingTimes the working times
	*/
	public static void cacheResult(List<WorkingTime> workingTimes) {
		getPersistence().cacheResult(workingTimes);
	}

	/**
	* Creates a new working time with the primary key. Does not add the working time to the database.
	*
	* @param workingTimeId the primary key for the new working time
	* @return the new working time
	*/
	public static WorkingTime create(long workingTimeId) {
		return getPersistence().create(workingTimeId);
	}

	/**
	* Removes the working time with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workingTimeId the primary key of the working time
	* @return the working time that was removed
	* @throws NoSuchWorkingTimeException if a working time with the primary key could not be found
	*/
	public static WorkingTime remove(long workingTimeId)
		throws com.liferay.usermanagement.exception.NoSuchWorkingTimeException {
		return getPersistence().remove(workingTimeId);
	}

	public static WorkingTime updateImpl(WorkingTime workingTime) {
		return getPersistence().updateImpl(workingTime);
	}

	/**
	* Returns the working time with the primary key or throws a {@link NoSuchWorkingTimeException} if it could not be found.
	*
	* @param workingTimeId the primary key of the working time
	* @return the working time
	* @throws NoSuchWorkingTimeException if a working time with the primary key could not be found
	*/
	public static WorkingTime findByPrimaryKey(long workingTimeId)
		throws com.liferay.usermanagement.exception.NoSuchWorkingTimeException {
		return getPersistence().findByPrimaryKey(workingTimeId);
	}

	/**
	* Returns the working time with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workingTimeId the primary key of the working time
	* @return the working time, or <code>null</code> if a working time with the primary key could not be found
	*/
	public static WorkingTime fetchByPrimaryKey(long workingTimeId) {
		return getPersistence().fetchByPrimaryKey(workingTimeId);
	}

	public static java.util.Map<java.io.Serializable, WorkingTime> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the working times.
	*
	* @return the working times
	*/
	public static List<WorkingTime> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the working times.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkingTimeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of working times
	* @param end the upper bound of the range of working times (not inclusive)
	* @return the range of working times
	*/
	public static List<WorkingTime> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the working times.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkingTimeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of working times
	* @param end the upper bound of the range of working times (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of working times
	*/
	public static List<WorkingTime> findAll(int start, int end,
		OrderByComparator<WorkingTime> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the working times.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkingTimeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of working times
	* @param end the upper bound of the range of working times (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of working times
	*/
	public static List<WorkingTime> findAll(int start, int end,
		OrderByComparator<WorkingTime> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the working times from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of working times.
	*
	* @return the number of working times
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static WorkingTimePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WorkingTimePersistence, WorkingTimePersistence> _serviceTracker =
		ServiceTrackerFactory.open(WorkingTimePersistence.class);
}