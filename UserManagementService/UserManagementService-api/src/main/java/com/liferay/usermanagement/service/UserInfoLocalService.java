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

import com.liferay.usermanagement.model.UserInfo;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

/**
 * Provides the local service interface for UserInfo. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author phantoan
 * @see UserInfoLocalServiceUtil
 * @see com.liferay.usermanagement.service.base.UserInfoLocalServiceBaseImpl
 * @see com.liferay.usermanagement.service.impl.UserInfoLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface UserInfoLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserInfoLocalServiceUtil} to access the user info local service. Add custom service methods to {@link com.liferay.usermanagement.service.impl.UserInfoLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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
	* Adds the user info to the database. Also notifies the appropriate model listeners.
	*
	* @param userInfo the user info
	* @return the user info that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public UserInfo addUserInfo(UserInfo userInfo);

	public UserInfo addUserInfo(java.lang.String userCode,
		java.lang.String username, boolean male, Date birthday,
		java.lang.String address, java.lang.String email,
		java.lang.String phone, java.lang.String departmentCode,
		java.lang.String role, ServiceContext serviceContext)
		throws PortalException, SystemException;

	/**
	* Creates a new user info with the primary key. Does not add the user info to the database.
	*
	* @param userCode the primary key for the new user info
	* @return the new user info
	*/
	public UserInfo createUserInfo(java.lang.String userCode);

	/**
	* Deletes the user info from the database. Also notifies the appropriate model listeners.
	*
	* @param userInfo the user info
	* @return the user info that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public UserInfo deleteUserInfo(UserInfo userInfo);

	/**
	* Deletes the user info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userCode the primary key of the user info
	* @return the user info that was removed
	* @throws PortalException if a user info with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public UserInfo deleteUserInfo(java.lang.String userCode)
		throws PortalException;

	public UserInfo deleteUserInfo(java.lang.String userCode,
		ServiceContext serviceContext) throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserInfo fetchUserInfo(java.lang.String userCode);

	/**
	* Returns the user info matching the UUID and group.
	*
	* @param uuid the user info's UUID
	* @param groupId the primary key of the group
	* @return the matching user info, or <code>null</code> if a matching user info could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserInfo fetchUserInfoByUuidAndGroupId(java.lang.String uuid,
		long groupId);

	/**
	* Returns the user info with the primary key.
	*
	* @param userCode the primary key of the user info
	* @return the user info
	* @throws PortalException if a user info with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserInfo getUserInfo(java.lang.String userCode)
		throws PortalException;

	/**
	* Returns the user info matching the UUID and group.
	*
	* @param uuid the user info's UUID
	* @param groupId the primary key of the group
	* @return the matching user info
	* @throws PortalException if a matching user info could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserInfo getUserInfoByUuidAndGroupId(java.lang.String uuid,
		long groupId) throws PortalException;

	/**
	* Updates the user info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userInfo the user info
	* @return the user info that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public UserInfo updateUserInfo(UserInfo userInfo);

	public UserInfo updateUserInfo(java.lang.String userCode,
		java.lang.String username, boolean male, Date birthday,
		java.lang.String address, java.lang.String email,
		java.lang.String phone, java.lang.String departmentCode,
		java.lang.String role, ServiceContext serviceContext)
		throws PortalException, SystemException;

	/**
	* Returns the number of user infos.
	*
	* @return the number of user infos
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUserInfosCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.usermanagement.model.impl.UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.usermanagement.model.impl.UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserInfo> getUserInfos(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserInfo> getUserInfos(long groupId)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserInfo> getUserInfos(long groupId, int start, int end)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserInfo> getUserInfosByC_N_E(java.lang.String userCode,
		java.lang.String username, java.lang.String email)
		throws PortalException, SystemException;

	/**
	* Returns all the user infos matching the UUID and company.
	*
	* @param uuid the UUID of the user infos
	* @param companyId the primary key of the company
	* @return the matching user infos, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserInfo> getUserInfosByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserInfo> getUserInfosByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<UserInfo> orderByComparator);

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