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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.liferay.usermanagement.exception.NoSuchUserInfoException;
import com.liferay.usermanagement.model.UserInfo;

/**
 * The persistence interface for the user info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author phantoan
 * @see com.liferay.usermanagement.service.persistence.impl.UserInfoPersistenceImpl
 * @see UserInfoUtil
 * @generated
 */
@ProviderType
public interface UserInfoPersistence extends BasePersistence<UserInfo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserInfoUtil} to access the user info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the user infos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching user infos
	*/
	public java.util.List<UserInfo> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the user infos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @return the range of matching user infos
	*/
	public java.util.List<UserInfo> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the user infos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user infos
	*/
	public java.util.List<UserInfo> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator);

	/**
	* Returns an ordered range of all the user infos where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user infos
	*/
	public java.util.List<UserInfo> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user info in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user info
	* @throws NoSuchUserInfoException if a matching user info could not be found
	*/
	public UserInfo findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator)
		throws NoSuchUserInfoException;

	/**
	* Returns the first user info in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user info, or <code>null</code> if a matching user info could not be found
	*/
	public UserInfo fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator);

	/**
	* Returns the last user info in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user info
	* @throws NoSuchUserInfoException if a matching user info could not be found
	*/
	public UserInfo findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator)
		throws NoSuchUserInfoException;

	/**
	* Returns the last user info in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user info, or <code>null</code> if a matching user info could not be found
	*/
	public UserInfo fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator);

	/**
	* Returns the user infos before and after the current user info in the ordered set where uuid = &#63;.
	*
	* @param userCode the primary key of the current user info
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user info
	* @throws NoSuchUserInfoException if a user info with the primary key could not be found
	*/
	public UserInfo[] findByUuid_PrevAndNext(java.lang.String userCode,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator)
		throws NoSuchUserInfoException;

	/**
	* Removes all the user infos where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of user infos where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching user infos
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the user info where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchUserInfoException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching user info
	* @throws NoSuchUserInfoException if a matching user info could not be found
	*/
	public UserInfo findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchUserInfoException;

	/**
	* Returns the user info where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching user info, or <code>null</code> if a matching user info could not be found
	*/
	public UserInfo fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the user info where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user info, or <code>null</code> if a matching user info could not be found
	*/
	public UserInfo fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the user info where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the user info that was removed
	*/
	public UserInfo removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchUserInfoException;

	/**
	* Returns the number of user infos where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching user infos
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the user infos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching user infos
	*/
	public java.util.List<UserInfo> findByUuid_C(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of all the user infos where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @return the range of matching user infos
	*/
	public java.util.List<UserInfo> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the user infos where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user infos
	*/
	public java.util.List<UserInfo> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator);

	/**
	* Returns an ordered range of all the user infos where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user infos
	*/
	public java.util.List<UserInfo> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user info in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user info
	* @throws NoSuchUserInfoException if a matching user info could not be found
	*/
	public UserInfo findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator)
		throws NoSuchUserInfoException;

	/**
	* Returns the first user info in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user info, or <code>null</code> if a matching user info could not be found
	*/
	public UserInfo fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator);

	/**
	* Returns the last user info in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user info
	* @throws NoSuchUserInfoException if a matching user info could not be found
	*/
	public UserInfo findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator)
		throws NoSuchUserInfoException;

	/**
	* Returns the last user info in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user info, or <code>null</code> if a matching user info could not be found
	*/
	public UserInfo fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator);

	/**
	* Returns the user infos before and after the current user info in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param userCode the primary key of the current user info
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user info
	* @throws NoSuchUserInfoException if a user info with the primary key could not be found
	*/
	public UserInfo[] findByUuid_C_PrevAndNext(java.lang.String userCode,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator)
		throws NoSuchUserInfoException;

	/**
	* Removes all the user infos where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of user infos where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching user infos
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the user infos where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching user infos
	*/
	public java.util.List<UserInfo> findByGroupId(long groupId);

	/**
	* Returns a range of all the user infos where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @return the range of matching user infos
	*/
	public java.util.List<UserInfo> findByGroupId(long groupId, int start,
		int end);

	/**
	* Returns an ordered range of all the user infos where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user infos
	*/
	public java.util.List<UserInfo> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator);

	/**
	* Returns an ordered range of all the user infos where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user infos
	*/
	public java.util.List<UserInfo> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user info in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user info
	* @throws NoSuchUserInfoException if a matching user info could not be found
	*/
	public UserInfo findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator)
		throws NoSuchUserInfoException;

	/**
	* Returns the first user info in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user info, or <code>null</code> if a matching user info could not be found
	*/
	public UserInfo fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator);

	/**
	* Returns the last user info in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user info
	* @throws NoSuchUserInfoException if a matching user info could not be found
	*/
	public UserInfo findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator)
		throws NoSuchUserInfoException;

	/**
	* Returns the last user info in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user info, or <code>null</code> if a matching user info could not be found
	*/
	public UserInfo fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator);

	/**
	* Returns the user infos before and after the current user info in the ordered set where groupId = &#63;.
	*
	* @param userCode the primary key of the current user info
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user info
	* @throws NoSuchUserInfoException if a user info with the primary key could not be found
	*/
	public UserInfo[] findByGroupId_PrevAndNext(java.lang.String userCode,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator)
		throws NoSuchUserInfoException;

	/**
	* Removes all the user infos where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of user infos where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching user infos
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns the user info where email = &#63; or throws a {@link NoSuchUserInfoException} if it could not be found.
	*
	* @param email the email
	* @return the matching user info
	* @throws NoSuchUserInfoException if a matching user info could not be found
	*/
	public UserInfo findByEmail(java.lang.String email)
		throws NoSuchUserInfoException;

	/**
	* Returns the user info where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param email the email
	* @return the matching user info, or <code>null</code> if a matching user info could not be found
	*/
	public UserInfo fetchByEmail(java.lang.String email);

	/**
	* Returns the user info where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param email the email
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user info, or <code>null</code> if a matching user info could not be found
	*/
	public UserInfo fetchByEmail(java.lang.String email,
		boolean retrieveFromCache);

	/**
	* Removes the user info where email = &#63; from the database.
	*
	* @param email the email
	* @return the user info that was removed
	*/
	public UserInfo removeByEmail(java.lang.String email)
		throws NoSuchUserInfoException;

	/**
	* Returns the number of user infos where email = &#63;.
	*
	* @param email the email
	* @return the number of matching user infos
	*/
	public int countByEmail(java.lang.String email);

	/**
	* Returns all the user infos where departmentCode = &#63;.
	*
	* @param departmentCode the department code
	* @return the matching user infos
	*/
	public java.util.List<UserInfo> findByDepartmentCode(
		java.lang.String departmentCode);

	/**
	* Returns a range of all the user infos where departmentCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentCode the department code
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @return the range of matching user infos
	*/
	public java.util.List<UserInfo> findByDepartmentCode(
		java.lang.String departmentCode, int start, int end);

	/**
	* Returns an ordered range of all the user infos where departmentCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentCode the department code
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user infos
	*/
	public java.util.List<UserInfo> findByDepartmentCode(
		java.lang.String departmentCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator);

	/**
	* Returns an ordered range of all the user infos where departmentCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentCode the department code
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user infos
	*/
	public java.util.List<UserInfo> findByDepartmentCode(
		java.lang.String departmentCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user info in the ordered set where departmentCode = &#63;.
	*
	* @param departmentCode the department code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user info
	* @throws NoSuchUserInfoException if a matching user info could not be found
	*/
	public UserInfo findByDepartmentCode_First(
		java.lang.String departmentCode,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator)
		throws NoSuchUserInfoException;

	/**
	* Returns the first user info in the ordered set where departmentCode = &#63;.
	*
	* @param departmentCode the department code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user info, or <code>null</code> if a matching user info could not be found
	*/
	public UserInfo fetchByDepartmentCode_First(
		java.lang.String departmentCode,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator);

	/**
	* Returns the last user info in the ordered set where departmentCode = &#63;.
	*
	* @param departmentCode the department code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user info
	* @throws NoSuchUserInfoException if a matching user info could not be found
	*/
	public UserInfo findByDepartmentCode_Last(java.lang.String departmentCode,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator)
		throws NoSuchUserInfoException;

	/**
	* Returns the last user info in the ordered set where departmentCode = &#63;.
	*
	* @param departmentCode the department code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user info, or <code>null</code> if a matching user info could not be found
	*/
	public UserInfo fetchByDepartmentCode_Last(
		java.lang.String departmentCode,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator);

	/**
	* Returns the user infos before and after the current user info in the ordered set where departmentCode = &#63;.
	*
	* @param userCode the primary key of the current user info
	* @param departmentCode the department code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user info
	* @throws NoSuchUserInfoException if a user info with the primary key could not be found
	*/
	public UserInfo[] findByDepartmentCode_PrevAndNext(
		java.lang.String userCode, java.lang.String departmentCode,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator)
		throws NoSuchUserInfoException;

	/**
	* Removes all the user infos where departmentCode = &#63; from the database.
	*
	* @param departmentCode the department code
	*/
	public void removeByDepartmentCode(java.lang.String departmentCode);

	/**
	* Returns the number of user infos where departmentCode = &#63;.
	*
	* @param departmentCode the department code
	* @return the number of matching user infos
	*/
	public int countByDepartmentCode(java.lang.String departmentCode);

	/**
	* Caches the user info in the entity cache if it is enabled.
	*
	* @param userInfo the user info
	*/
	public void cacheResult(UserInfo userInfo);

	/**
	* Caches the user infos in the entity cache if it is enabled.
	*
	* @param userInfos the user infos
	*/
	public void cacheResult(java.util.List<UserInfo> userInfos);

	/**
	* Creates a new user info with the primary key. Does not add the user info to the database.
	*
	* @param userCode the primary key for the new user info
	* @return the new user info
	*/
	public UserInfo create(java.lang.String userCode);

	/**
	* Removes the user info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userCode the primary key of the user info
	* @return the user info that was removed
	* @throws NoSuchUserInfoException if a user info with the primary key could not be found
	*/
	public UserInfo remove(java.lang.String userCode)
		throws NoSuchUserInfoException;

	public UserInfo updateImpl(UserInfo userInfo);

	/**
	* Returns the user info with the primary key or throws a {@link NoSuchUserInfoException} if it could not be found.
	*
	* @param userCode the primary key of the user info
	* @return the user info
	* @throws NoSuchUserInfoException if a user info with the primary key could not be found
	*/
	public UserInfo findByPrimaryKey(java.lang.String userCode)
		throws NoSuchUserInfoException;

	/**
	* Returns the user info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userCode the primary key of the user info
	* @return the user info, or <code>null</code> if a user info with the primary key could not be found
	*/
	public UserInfo fetchByPrimaryKey(java.lang.String userCode);

	@Override
	public java.util.Map<java.io.Serializable, UserInfo> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the user infos.
	*
	* @return the user infos
	*/
	public java.util.List<UserInfo> findAll();

	/**
	* Returns a range of all the user infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @return the range of user infos
	*/
	public java.util.List<UserInfo> findAll(int start, int end);

	/**
	* Returns an ordered range of all the user infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user infos
	*/
	public java.util.List<UserInfo> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator);

	/**
	* Returns an ordered range of all the user infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user infos
	* @param end the upper bound of the range of user infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user infos
	*/
	public java.util.List<UserInfo> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserInfo> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the user infos from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of user infos.
	*
	* @return the number of user infos
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}