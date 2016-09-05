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
 * Provides a wrapper for {@link UserInfoLocalService}.
 *
 * @author phantoan
 * @see UserInfoLocalService
 * @generated
 */
@ProviderType
public class UserInfoLocalServiceWrapper implements UserInfoLocalService,
	ServiceWrapper<UserInfoLocalService> {
	public UserInfoLocalServiceWrapper(
		UserInfoLocalService userInfoLocalService) {
		_userInfoLocalService = userInfoLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userInfoLocalService.dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userInfoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userInfoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the user info to the database. Also notifies the appropriate model listeners.
	*
	* @param userInfo the user info
	* @return the user info that was added
	*/
	@Override
	public com.liferay.usermanagement.model.UserInfo addUserInfo(
		com.liferay.usermanagement.model.UserInfo userInfo) {
		return _userInfoLocalService.addUserInfo(userInfo);
	}

	/**
	* Creates a new user info with the primary key. Does not add the user info to the database.
	*
	* @param userCode the primary key for the new user info
	* @return the new user info
	*/
	@Override
	public com.liferay.usermanagement.model.UserInfo createUserInfo(
		java.lang.String userCode) {
		return _userInfoLocalService.createUserInfo(userCode);
	}

	/**
	* Deletes the user info from the database. Also notifies the appropriate model listeners.
	*
	* @param userInfo the user info
	* @return the user info that was removed
	*/
	@Override
	public com.liferay.usermanagement.model.UserInfo deleteUserInfo(
		com.liferay.usermanagement.model.UserInfo userInfo) {
		return _userInfoLocalService.deleteUserInfo(userInfo);
	}

	/**
	* Deletes the user info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userCode the primary key of the user info
	* @return the user info that was removed
	* @throws PortalException if a user info with the primary key could not be found
	*/
	@Override
	public com.liferay.usermanagement.model.UserInfo deleteUserInfo(
		java.lang.String userCode)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userInfoLocalService.deleteUserInfo(userCode);
	}

	@Override
	public com.liferay.usermanagement.model.UserInfo fetchUserInfo(
		java.lang.String userCode) {
		return _userInfoLocalService.fetchUserInfo(userCode);
	}

	/**
	* Returns the user info matching the UUID and group.
	*
	* @param uuid the user info's UUID
	* @param groupId the primary key of the group
	* @return the matching user info, or <code>null</code> if a matching user info could not be found
	*/
	@Override
	public com.liferay.usermanagement.model.UserInfo fetchUserInfoByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _userInfoLocalService.fetchUserInfoByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the user info with the primary key.
	*
	* @param userCode the primary key of the user info
	* @return the user info
	* @throws PortalException if a user info with the primary key could not be found
	*/
	@Override
	public com.liferay.usermanagement.model.UserInfo getUserInfo(
		java.lang.String userCode)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userInfoLocalService.getUserInfo(userCode);
	}

	/**
	* Returns the user info matching the UUID and group.
	*
	* @param uuid the user info's UUID
	* @param groupId the primary key of the group
	* @return the matching user info
	* @throws PortalException if a matching user info could not be found
	*/
	@Override
	public com.liferay.usermanagement.model.UserInfo getUserInfoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userInfoLocalService.getUserInfoByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the user info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userInfo the user info
	* @return the user info that was updated
	*/
	@Override
	public com.liferay.usermanagement.model.UserInfo updateUserInfo(
		com.liferay.usermanagement.model.UserInfo userInfo) {
		return _userInfoLocalService.updateUserInfo(userInfo);
	}

	/**
	* Returns the number of user infos.
	*
	* @return the number of user infos
	*/
	@Override
	public int getUserInfosCount() {
		return _userInfoLocalService.getUserInfosCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _userInfoLocalService.getOSGiServiceIdentifier();
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
		return _userInfoLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _userInfoLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _userInfoLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
	@Override
	public java.util.List<com.liferay.usermanagement.model.UserInfo> getUserInfos(
		int start, int end) {
		return _userInfoLocalService.getUserInfos(start, end);
	}

	/**
	* Returns all the user infos matching the UUID and company.
	*
	* @param uuid the UUID of the user infos
	* @param companyId the primary key of the company
	* @return the matching user infos, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.usermanagement.model.UserInfo> getUserInfosByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _userInfoLocalService.getUserInfosByUuidAndCompanyId(uuid,
			companyId);
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
	@Override
	public java.util.List<com.liferay.usermanagement.model.UserInfo> getUserInfosByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.usermanagement.model.UserInfo> orderByComparator) {
		return _userInfoLocalService.getUserInfosByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
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
		return _userInfoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _userInfoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public UserInfoLocalService getWrappedService() {
		return _userInfoLocalService;
	}

	@Override
	public void setWrappedService(UserInfoLocalService userInfoLocalService) {
		_userInfoLocalService = userInfoLocalService;
	}

	private UserInfoLocalService _userInfoLocalService;
}