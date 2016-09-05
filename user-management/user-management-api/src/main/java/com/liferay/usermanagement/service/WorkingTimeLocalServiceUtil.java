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
 * Provides the local service utility for WorkingTime. This utility wraps
 * {@link com.liferay.usermanagement.service.impl.WorkingTimeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author phantoan
 * @see WorkingTimeLocalService
 * @see com.liferay.usermanagement.service.base.WorkingTimeLocalServiceBaseImpl
 * @see com.liferay.usermanagement.service.impl.WorkingTimeLocalServiceImpl
 * @generated
 */
@ProviderType
public class WorkingTimeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.usermanagement.service.impl.WorkingTimeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
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
	* Adds the working time to the database. Also notifies the appropriate model listeners.
	*
	* @param workingTime the working time
	* @return the working time that was added
	*/
	public static com.liferay.usermanagement.model.WorkingTime addWorkingTime(
		com.liferay.usermanagement.model.WorkingTime workingTime) {
		return getService().addWorkingTime(workingTime);
	}

	public static com.liferay.usermanagement.model.WorkingTime addWorkingTime(
		java.util.Date date, java.lang.String userCode,
		java.util.Date startTime, java.util.Date endTime,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addWorkingTime(date, userCode, startTime, endTime,
			serviceContext);
	}

	/**
	* Creates a new working time with the primary key. Does not add the working time to the database.
	*
	* @param workingTimeId the primary key for the new working time
	* @return the new working time
	*/
	public static com.liferay.usermanagement.model.WorkingTime createWorkingTime(
		long workingTimeId) {
		return getService().createWorkingTime(workingTimeId);
	}

	/**
	* Deletes the working time from the database. Also notifies the appropriate model listeners.
	*
	* @param workingTime the working time
	* @return the working time that was removed
	*/
	public static com.liferay.usermanagement.model.WorkingTime deleteWorkingTime(
		com.liferay.usermanagement.model.WorkingTime workingTime) {
		return getService().deleteWorkingTime(workingTime);
	}

	/**
	* Deletes the working time with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workingTimeId the primary key of the working time
	* @return the working time that was removed
	* @throws PortalException if a working time with the primary key could not be found
	*/
	public static com.liferay.usermanagement.model.WorkingTime deleteWorkingTime(
		long workingTimeId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteWorkingTime(workingTimeId);
	}

	public static com.liferay.usermanagement.model.WorkingTime fetchWorkingTime(
		long workingTimeId) {
		return getService().fetchWorkingTime(workingTimeId);
	}

	/**
	* Returns the working time matching the UUID and group.
	*
	* @param uuid the working time's UUID
	* @param groupId the primary key of the group
	* @return the matching working time, or <code>null</code> if a matching working time could not be found
	*/
	public static com.liferay.usermanagement.model.WorkingTime fetchWorkingTimeByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchWorkingTimeByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the working time with the primary key.
	*
	* @param workingTimeId the primary key of the working time
	* @return the working time
	* @throws PortalException if a working time with the primary key could not be found
	*/
	public static com.liferay.usermanagement.model.WorkingTime getWorkingTime(
		long workingTimeId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getWorkingTime(workingTimeId);
	}

	public static com.liferay.usermanagement.model.WorkingTime getWorkingTimeByC_D(
		java.util.Date date, java.lang.String userCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getWorkingTimeByC_D(date, userCode);
	}

	/**
	* Returns the working time matching the UUID and group.
	*
	* @param uuid the working time's UUID
	* @param groupId the primary key of the group
	* @return the matching working time
	* @throws PortalException if a matching working time could not be found
	*/
	public static com.liferay.usermanagement.model.WorkingTime getWorkingTimeByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getWorkingTimeByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the working time in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param workingTime the working time
	* @return the working time that was updated
	*/
	public static com.liferay.usermanagement.model.WorkingTime updateWorkingTime(
		com.liferay.usermanagement.model.WorkingTime workingTime) {
		return getService().updateWorkingTime(workingTime);
	}

	public static com.liferay.usermanagement.model.WorkingTime updateWorkingTime(
		long workingTimeId, java.util.Date startTime, java.util.Date endTime,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateWorkingTime(workingTimeId, startTime, endTime,
			serviceContext);
	}

	public static int countWorkingTimeByDate(java.util.Date date)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countWorkingTimeByDate(date);
	}

	public static int countWorkingTimeByUserCode(java.lang.String userCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countWorkingTimeByUserCode(userCode);
	}

	/**
	* Returns the number of working times.
	*
	* @return the number of working times
	*/
	public static int getWorkingTimesCount() {
		return getService().getWorkingTimesCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.usermanagement.model.impl.WorkingTimeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.usermanagement.model.impl.WorkingTimeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	/**
	* Returns a range of all the working times.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.usermanagement.model.impl.WorkingTimeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of working times
	* @param end the upper bound of the range of working times (not inclusive)
	* @return the range of working times
	*/
	public static java.util.List<com.liferay.usermanagement.model.WorkingTime> getWorkingTimes(
		int start, int end) {
		return getService().getWorkingTimes(start, end);
	}

	public static java.util.List<com.liferay.usermanagement.model.WorkingTime> getWorkingTimesByDate(
		java.util.Date date)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getWorkingTimesByDate(date);
	}

	public static java.util.List<com.liferay.usermanagement.model.WorkingTime> getWorkingTimesByUserCode(
		java.lang.String userCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getWorkingTimesByUserCode(userCode);
	}

	/**
	* Returns all the working times matching the UUID and company.
	*
	* @param uuid the UUID of the working times
	* @param companyId the primary key of the company
	* @return the matching working times, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.usermanagement.model.WorkingTime> getWorkingTimesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getWorkingTimesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of working times matching the UUID and company.
	*
	* @param uuid the UUID of the working times
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of working times
	* @param end the upper bound of the range of working times (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching working times, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.usermanagement.model.WorkingTime> getWorkingTimesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.usermanagement.model.WorkingTime> orderByComparator) {
		return getService()
				   .getWorkingTimesByUuidAndCompanyId(uuid, companyId, start,
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

	public static WorkingTimeLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WorkingTimeLocalService, WorkingTimeLocalService> _serviceTracker =
		ServiceTrackerFactory.open(WorkingTimeLocalService.class);
}