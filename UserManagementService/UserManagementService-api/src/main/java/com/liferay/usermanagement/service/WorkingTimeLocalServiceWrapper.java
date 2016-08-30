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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WorkingTimeLocalService}.
 *
 * @author phantoan
 * @see WorkingTimeLocalService
 * @generated
 */
@ProviderType
public class WorkingTimeLocalServiceWrapper implements WorkingTimeLocalService,
	ServiceWrapper<WorkingTimeLocalService> {
	public WorkingTimeLocalServiceWrapper(
		WorkingTimeLocalService workingTimeLocalService) {
		_workingTimeLocalService = workingTimeLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _workingTimeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _workingTimeLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _workingTimeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _workingTimeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _workingTimeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the working time to the database. Also notifies the appropriate model listeners.
	*
	* @param workingTime the working time
	* @return the working time that was added
	*/
	@Override
	public com.liferay.usermanagement.model.WorkingTime addWorkingTime(
		com.liferay.usermanagement.model.WorkingTime workingTime) {
		return _workingTimeLocalService.addWorkingTime(workingTime);
	}

	/**
	* Creates a new working time with the primary key. Does not add the working time to the database.
	*
	* @param workingTimeId the primary key for the new working time
	* @return the new working time
	*/
	@Override
	public com.liferay.usermanagement.model.WorkingTime createWorkingTime(
		long workingTimeId) {
		return _workingTimeLocalService.createWorkingTime(workingTimeId);
	}

	/**
	* Deletes the working time from the database. Also notifies the appropriate model listeners.
	*
	* @param workingTime the working time
	* @return the working time that was removed
	*/
	@Override
	public com.liferay.usermanagement.model.WorkingTime deleteWorkingTime(
		com.liferay.usermanagement.model.WorkingTime workingTime) {
		return _workingTimeLocalService.deleteWorkingTime(workingTime);
	}

	/**
	* Deletes the working time with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workingTimeId the primary key of the working time
	* @return the working time that was removed
	* @throws PortalException if a working time with the primary key could not be found
	*/
	@Override
	public com.liferay.usermanagement.model.WorkingTime deleteWorkingTime(
		long workingTimeId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _workingTimeLocalService.deleteWorkingTime(workingTimeId);
	}

	@Override
	public com.liferay.usermanagement.model.WorkingTime fetchWorkingTime(
		long workingTimeId) {
		return _workingTimeLocalService.fetchWorkingTime(workingTimeId);
	}

	/**
	* Returns the working time with the primary key.
	*
	* @param workingTimeId the primary key of the working time
	* @return the working time
	* @throws PortalException if a working time with the primary key could not be found
	*/
	@Override
	public com.liferay.usermanagement.model.WorkingTime getWorkingTime(
		long workingTimeId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _workingTimeLocalService.getWorkingTime(workingTimeId);
	}

	/**
	* Updates the working time in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param workingTime the working time
	* @return the working time that was updated
	*/
	@Override
	public com.liferay.usermanagement.model.WorkingTime updateWorkingTime(
		com.liferay.usermanagement.model.WorkingTime workingTime) {
		return _workingTimeLocalService.updateWorkingTime(workingTime);
	}

	/**
	* Returns the number of working times.
	*
	* @return the number of working times
	*/
	@Override
	public int getWorkingTimesCount() {
		return _workingTimeLocalService.getWorkingTimesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _workingTimeLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _workingTimeLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _workingTimeLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _workingTimeLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
	@Override
	public java.util.List<com.liferay.usermanagement.model.WorkingTime> getWorkingTimes(
		int start, int end) {
		return _workingTimeLocalService.getWorkingTimes(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _workingTimeLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _workingTimeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public WorkingTimeLocalService getWrappedService() {
		return _workingTimeLocalService;
	}

	@Override
	public void setWrappedService(
		WorkingTimeLocalService workingTimeLocalService) {
		_workingTimeLocalService = workingTimeLocalService;
	}

	private WorkingTimeLocalService _workingTimeLocalService;
}