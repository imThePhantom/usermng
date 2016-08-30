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

import com.liferay.usermanagement.exception.NoSuchWorkingTimeException;
import com.liferay.usermanagement.model.WorkingTime;

import java.util.Date;

/**
 * The persistence interface for the working time service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author phantoan
 * @see com.liferay.usermanagement.service.persistence.impl.WorkingTimePersistenceImpl
 * @see WorkingTimeUtil
 * @generated
 */
@ProviderType
public interface WorkingTimePersistence extends BasePersistence<WorkingTime> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkingTimeUtil} to access the working time persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the working times where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching working times
	*/
	public java.util.List<WorkingTime> findByUuid(java.lang.String uuid);

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
	public java.util.List<WorkingTime> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<WorkingTime> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator);

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
	public java.util.List<WorkingTime> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first working time in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working time
	* @throws NoSuchWorkingTimeException if a matching working time could not be found
	*/
	public WorkingTime findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator)
		throws NoSuchWorkingTimeException;

	/**
	* Returns the first working time in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working time, or <code>null</code> if a matching working time could not be found
	*/
	public WorkingTime fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator);

	/**
	* Returns the last working time in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working time
	* @throws NoSuchWorkingTimeException if a matching working time could not be found
	*/
	public WorkingTime findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator)
		throws NoSuchWorkingTimeException;

	/**
	* Returns the last working time in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working time, or <code>null</code> if a matching working time could not be found
	*/
	public WorkingTime fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator);

	/**
	* Returns the working times before and after the current working time in the ordered set where uuid = &#63;.
	*
	* @param workingTimeId the primary key of the current working time
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next working time
	* @throws NoSuchWorkingTimeException if a working time with the primary key could not be found
	*/
	public WorkingTime[] findByUuid_PrevAndNext(long workingTimeId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator)
		throws NoSuchWorkingTimeException;

	/**
	* Removes all the working times where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of working times where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching working times
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the working times where date = &#63;.
	*
	* @param date the date
	* @return the matching working times
	*/
	public java.util.List<WorkingTime> findByDate(Date date);

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
	public java.util.List<WorkingTime> findByDate(Date date, int start, int end);

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
	public java.util.List<WorkingTime> findByDate(Date date, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator);

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
	public java.util.List<WorkingTime> findByDate(Date date, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first working time in the ordered set where date = &#63;.
	*
	* @param date the date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working time
	* @throws NoSuchWorkingTimeException if a matching working time could not be found
	*/
	public WorkingTime findByDate_First(Date date,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator)
		throws NoSuchWorkingTimeException;

	/**
	* Returns the first working time in the ordered set where date = &#63;.
	*
	* @param date the date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working time, or <code>null</code> if a matching working time could not be found
	*/
	public WorkingTime fetchByDate_First(Date date,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator);

	/**
	* Returns the last working time in the ordered set where date = &#63;.
	*
	* @param date the date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working time
	* @throws NoSuchWorkingTimeException if a matching working time could not be found
	*/
	public WorkingTime findByDate_Last(Date date,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator)
		throws NoSuchWorkingTimeException;

	/**
	* Returns the last working time in the ordered set where date = &#63;.
	*
	* @param date the date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working time, or <code>null</code> if a matching working time could not be found
	*/
	public WorkingTime fetchByDate_Last(Date date,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator);

	/**
	* Returns the working times before and after the current working time in the ordered set where date = &#63;.
	*
	* @param workingTimeId the primary key of the current working time
	* @param date the date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next working time
	* @throws NoSuchWorkingTimeException if a working time with the primary key could not be found
	*/
	public WorkingTime[] findByDate_PrevAndNext(long workingTimeId, Date date,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator)
		throws NoSuchWorkingTimeException;

	/**
	* Removes all the working times where date = &#63; from the database.
	*
	* @param date the date
	*/
	public void removeByDate(Date date);

	/**
	* Returns the number of working times where date = &#63;.
	*
	* @param date the date
	* @return the number of matching working times
	*/
	public int countByDate(Date date);

	/**
	* Returns all the working times where userCode = &#63;.
	*
	* @param userCode the user code
	* @return the matching working times
	*/
	public java.util.List<WorkingTime> findByuserCode(java.lang.String userCode);

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
	public java.util.List<WorkingTime> findByuserCode(
		java.lang.String userCode, int start, int end);

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
	public java.util.List<WorkingTime> findByuserCode(
		java.lang.String userCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator);

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
	public java.util.List<WorkingTime> findByuserCode(
		java.lang.String userCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first working time in the ordered set where userCode = &#63;.
	*
	* @param userCode the user code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working time
	* @throws NoSuchWorkingTimeException if a matching working time could not be found
	*/
	public WorkingTime findByuserCode_First(java.lang.String userCode,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator)
		throws NoSuchWorkingTimeException;

	/**
	* Returns the first working time in the ordered set where userCode = &#63;.
	*
	* @param userCode the user code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working time, or <code>null</code> if a matching working time could not be found
	*/
	public WorkingTime fetchByuserCode_First(java.lang.String userCode,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator);

	/**
	* Returns the last working time in the ordered set where userCode = &#63;.
	*
	* @param userCode the user code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working time
	* @throws NoSuchWorkingTimeException if a matching working time could not be found
	*/
	public WorkingTime findByuserCode_Last(java.lang.String userCode,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator)
		throws NoSuchWorkingTimeException;

	/**
	* Returns the last working time in the ordered set where userCode = &#63;.
	*
	* @param userCode the user code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working time, or <code>null</code> if a matching working time could not be found
	*/
	public WorkingTime fetchByuserCode_Last(java.lang.String userCode,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator);

	/**
	* Returns the working times before and after the current working time in the ordered set where userCode = &#63;.
	*
	* @param workingTimeId the primary key of the current working time
	* @param userCode the user code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next working time
	* @throws NoSuchWorkingTimeException if a working time with the primary key could not be found
	*/
	public WorkingTime[] findByuserCode_PrevAndNext(long workingTimeId,
		java.lang.String userCode,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator)
		throws NoSuchWorkingTimeException;

	/**
	* Removes all the working times where userCode = &#63; from the database.
	*
	* @param userCode the user code
	*/
	public void removeByuserCode(java.lang.String userCode);

	/**
	* Returns the number of working times where userCode = &#63;.
	*
	* @param userCode the user code
	* @return the number of matching working times
	*/
	public int countByuserCode(java.lang.String userCode);

	/**
	* Returns all the working times where date = &#63; and userCode = &#63;.
	*
	* @param date the date
	* @param userCode the user code
	* @return the matching working times
	*/
	public java.util.List<WorkingTime> findByC_D(Date date,
		java.lang.String userCode);

	/**
	* Returns a range of all the working times where date = &#63; and userCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkingTimeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param date the date
	* @param userCode the user code
	* @param start the lower bound of the range of working times
	* @param end the upper bound of the range of working times (not inclusive)
	* @return the range of matching working times
	*/
	public java.util.List<WorkingTime> findByC_D(Date date,
		java.lang.String userCode, int start, int end);

	/**
	* Returns an ordered range of all the working times where date = &#63; and userCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkingTimeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param date the date
	* @param userCode the user code
	* @param start the lower bound of the range of working times
	* @param end the upper bound of the range of working times (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching working times
	*/
	public java.util.List<WorkingTime> findByC_D(Date date,
		java.lang.String userCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator);

	/**
	* Returns an ordered range of all the working times where date = &#63; and userCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WorkingTimeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param date the date
	* @param userCode the user code
	* @param start the lower bound of the range of working times
	* @param end the upper bound of the range of working times (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching working times
	*/
	public java.util.List<WorkingTime> findByC_D(Date date,
		java.lang.String userCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first working time in the ordered set where date = &#63; and userCode = &#63;.
	*
	* @param date the date
	* @param userCode the user code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working time
	* @throws NoSuchWorkingTimeException if a matching working time could not be found
	*/
	public WorkingTime findByC_D_First(Date date, java.lang.String userCode,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator)
		throws NoSuchWorkingTimeException;

	/**
	* Returns the first working time in the ordered set where date = &#63; and userCode = &#63;.
	*
	* @param date the date
	* @param userCode the user code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching working time, or <code>null</code> if a matching working time could not be found
	*/
	public WorkingTime fetchByC_D_First(Date date, java.lang.String userCode,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator);

	/**
	* Returns the last working time in the ordered set where date = &#63; and userCode = &#63;.
	*
	* @param date the date
	* @param userCode the user code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working time
	* @throws NoSuchWorkingTimeException if a matching working time could not be found
	*/
	public WorkingTime findByC_D_Last(Date date, java.lang.String userCode,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator)
		throws NoSuchWorkingTimeException;

	/**
	* Returns the last working time in the ordered set where date = &#63; and userCode = &#63;.
	*
	* @param date the date
	* @param userCode the user code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching working time, or <code>null</code> if a matching working time could not be found
	*/
	public WorkingTime fetchByC_D_Last(Date date, java.lang.String userCode,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator);

	/**
	* Returns the working times before and after the current working time in the ordered set where date = &#63; and userCode = &#63;.
	*
	* @param workingTimeId the primary key of the current working time
	* @param date the date
	* @param userCode the user code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next working time
	* @throws NoSuchWorkingTimeException if a working time with the primary key could not be found
	*/
	public WorkingTime[] findByC_D_PrevAndNext(long workingTimeId, Date date,
		java.lang.String userCode,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator)
		throws NoSuchWorkingTimeException;

	/**
	* Removes all the working times where date = &#63; and userCode = &#63; from the database.
	*
	* @param date the date
	* @param userCode the user code
	*/
	public void removeByC_D(Date date, java.lang.String userCode);

	/**
	* Returns the number of working times where date = &#63; and userCode = &#63;.
	*
	* @param date the date
	* @param userCode the user code
	* @return the number of matching working times
	*/
	public int countByC_D(Date date, java.lang.String userCode);

	/**
	* Caches the working time in the entity cache if it is enabled.
	*
	* @param workingTime the working time
	*/
	public void cacheResult(WorkingTime workingTime);

	/**
	* Caches the working times in the entity cache if it is enabled.
	*
	* @param workingTimes the working times
	*/
	public void cacheResult(java.util.List<WorkingTime> workingTimes);

	/**
	* Creates a new working time with the primary key. Does not add the working time to the database.
	*
	* @param workingTimeId the primary key for the new working time
	* @return the new working time
	*/
	public WorkingTime create(long workingTimeId);

	/**
	* Removes the working time with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workingTimeId the primary key of the working time
	* @return the working time that was removed
	* @throws NoSuchWorkingTimeException if a working time with the primary key could not be found
	*/
	public WorkingTime remove(long workingTimeId)
		throws NoSuchWorkingTimeException;

	public WorkingTime updateImpl(WorkingTime workingTime);

	/**
	* Returns the working time with the primary key or throws a {@link NoSuchWorkingTimeException} if it could not be found.
	*
	* @param workingTimeId the primary key of the working time
	* @return the working time
	* @throws NoSuchWorkingTimeException if a working time with the primary key could not be found
	*/
	public WorkingTime findByPrimaryKey(long workingTimeId)
		throws NoSuchWorkingTimeException;

	/**
	* Returns the working time with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workingTimeId the primary key of the working time
	* @return the working time, or <code>null</code> if a working time with the primary key could not be found
	*/
	public WorkingTime fetchByPrimaryKey(long workingTimeId);

	@Override
	public java.util.Map<java.io.Serializable, WorkingTime> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the working times.
	*
	* @return the working times
	*/
	public java.util.List<WorkingTime> findAll();

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
	public java.util.List<WorkingTime> findAll(int start, int end);

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
	public java.util.List<WorkingTime> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator);

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
	public java.util.List<WorkingTime> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkingTime> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the working times from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of working times.
	*
	* @return the number of working times
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}