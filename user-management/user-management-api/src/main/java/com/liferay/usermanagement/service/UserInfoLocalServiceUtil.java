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
 * Provides the local service utility for UserInfo. This utility wraps
 * {@link com.liferay.usermanagement.service.impl.UserInfoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author phantoan
 * @see UserInfoLocalService
 * @see com.liferay.usermanagement.service.base.UserInfoLocalServiceBaseImpl
 * @see com.liferay.usermanagement.service.impl.UserInfoLocalServiceImpl
 * @generated
 */
@ProviderType
public class UserInfoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.usermanagement.service.impl.UserInfoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Adds the user info to the database. Also notifies the appropriate model listeners.
	*
	* @param userInfo the user info
	* @return the user info that was added
	*/
	public static com.liferay.usermanagement.model.UserInfo addUserInfo(
		com.liferay.usermanagement.model.UserInfo userInfo) {
		return getService().addUserInfo(userInfo);
	}

	/**
	* Creates a new user info with the primary key. Does not add the user info to the database.
	*
	* @param userCode the primary key for the new user info
	* @return the new user info
	*/
	public static com.liferay.usermanagement.model.UserInfo createUserInfo(
		java.lang.String userCode) {
		return getService().createUserInfo(userCode);
	}

	/**
	* Deletes the user info from the database. Also notifies the appropriate model listeners.
	*
	* @param userInfo the user info
	* @return the user info that was removed
	*/
	public static com.liferay.usermanagement.model.UserInfo deleteUserInfo(
		com.liferay.usermanagement.model.UserInfo userInfo) {
		return getService().deleteUserInfo(userInfo);
	}

	/**
	* Deletes the user info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userCode the primary key of the user info
	* @return the user info that was removed
	* @throws PortalException if a user info with the primary key could not be found
	*/
	public static com.liferay.usermanagement.model.UserInfo deleteUserInfo(
		java.lang.String userCode)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteUserInfo(userCode);
	}

	public static com.liferay.usermanagement.model.UserInfo fetchUserInfo(
		java.lang.String userCode) {
		return getService().fetchUserInfo(userCode);
	}

	/**
	* Returns the user info matching the UUID and group.
	*
	* @param uuid the user info's UUID
	* @param groupId the primary key of the group
	* @return the matching user info, or <code>null</code> if a matching user info could not be found
	*/
	public static com.liferay.usermanagement.model.UserInfo fetchUserInfoByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchUserInfoByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the user info with the primary key.
	*
	* @param userCode the primary key of the user info
	* @return the user info
	* @throws PortalException if a user info with the primary key could not be found
	*/
	public static com.liferay.usermanagement.model.UserInfo getUserInfo(
		java.lang.String userCode)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserInfo(userCode);
	}

	/**
	* Returns the user info matching the UUID and group.
	*
	* @param uuid the user info's UUID
	* @param groupId the primary key of the group
	* @return the matching user info
	* @throws PortalException if a matching user info could not be found
	*/
	public static com.liferay.usermanagement.model.UserInfo getUserInfoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserInfoByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the user info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userInfo the user info
	* @return the user info that was updated
	*/
	public static com.liferay.usermanagement.model.UserInfo updateUserInfo(
		com.liferay.usermanagement.model.UserInfo userInfo) {
		return getService().updateUserInfo(userInfo);
	}

	/**
	* Returns the number of user infos.
	*
	* @return the number of user infos
	*/
	public static int getUserInfosCount() {
		return getService().getUserInfosCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.usermanagement.model.impl.UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.usermanagement.model.impl.UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the user infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.usermanagement.model.impl.UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @return the range of user infos
	*/
	public static java.util.List<com.liferay.usermanagement.model.UserInfo> getUserInfos(
		int start, int end) {
		return getService().getUserInfos(start, end);
	}

	/**
	* Returns all the user infos matching the UUID and company.
	*
	* @param uuid the UUID of the user infos
	* @param companyId the primary key of the company
	* @return the matching user infos, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.usermanagement.model.UserInfo> getUserInfosByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getUserInfosByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of user infos matching the UUID and company.
	*
	* @param uuid the UUID of the user infos
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching user infos, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.usermanagement.model.UserInfo> getUserInfosByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.usermanagement.model.UserInfo> orderByComparator) {
		return getService()
				   .getUserInfosByUuidAndCompanyId(uuid, companyId, start, end,
			orderByComparator);
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

	public static UserInfoLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserInfoLocalService, UserInfoLocalService> _serviceTracker =
		ServiceTrackerFactory.open(UserInfoLocalService.class);
}