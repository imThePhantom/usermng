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

package com.liferay.usermanagement.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.liferay.usermanagement.exception.NoSuchWorkingTimeException;
import com.liferay.usermanagement.model.WorkingTime;
import com.liferay.usermanagement.model.impl.WorkingTimeImpl;
import com.liferay.usermanagement.model.impl.WorkingTimeModelImpl;
import com.liferay.usermanagement.service.persistence.WorkingTimePersistence;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the working time service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author phantoan
 * @see WorkingTimePersistence
 * @see com.liferay.usermanagement.service.persistence.WorkingTimeUtil
 * @generated
 */
@ProviderType
public class WorkingTimePersistenceImpl extends BasePersistenceImpl<WorkingTime>
	implements WorkingTimePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WorkingTimeUtil} to access the working time persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WorkingTimeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
			WorkingTimeModelImpl.FINDER_CACHE_ENABLED, WorkingTimeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
			WorkingTimeModelImpl.FINDER_CACHE_ENABLED, WorkingTimeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
			WorkingTimeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
			WorkingTimeModelImpl.FINDER_CACHE_ENABLED, WorkingTimeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
			WorkingTimeModelImpl.FINDER_CACHE_ENABLED, WorkingTimeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			WorkingTimeModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
			WorkingTimeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the working times where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching working times
	 */
	@Override
	public List<WorkingTime> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<WorkingTime> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<WorkingTime> findByUuid(String uuid, int start, int end,
		OrderByComparator<WorkingTime> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<WorkingTime> findByUuid(String uuid, int start, int end,
		OrderByComparator<WorkingTime> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<WorkingTime> list = null;

		if (retrieveFromCache) {
			list = (List<WorkingTime>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkingTime workingTime : list) {
					if (!Objects.equals(uuid, workingTime.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_WORKINGTIME_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WorkingTimeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<WorkingTime>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WorkingTime>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first working time in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching working time
	 * @throws NoSuchWorkingTimeException if a matching working time could not be found
	 */
	@Override
	public WorkingTime findByUuid_First(String uuid,
		OrderByComparator<WorkingTime> orderByComparator)
		throws NoSuchWorkingTimeException {
		WorkingTime workingTime = fetchByUuid_First(uuid, orderByComparator);

		if (workingTime != null) {
			return workingTime;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkingTimeException(msg.toString());
	}

	/**
	 * Returns the first working time in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching working time, or <code>null</code> if a matching working time could not be found
	 */
	@Override
	public WorkingTime fetchByUuid_First(String uuid,
		OrderByComparator<WorkingTime> orderByComparator) {
		List<WorkingTime> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last working time in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching working time
	 * @throws NoSuchWorkingTimeException if a matching working time could not be found
	 */
	@Override
	public WorkingTime findByUuid_Last(String uuid,
		OrderByComparator<WorkingTime> orderByComparator)
		throws NoSuchWorkingTimeException {
		WorkingTime workingTime = fetchByUuid_Last(uuid, orderByComparator);

		if (workingTime != null) {
			return workingTime;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkingTimeException(msg.toString());
	}

	/**
	 * Returns the last working time in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching working time, or <code>null</code> if a matching working time could not be found
	 */
	@Override
	public WorkingTime fetchByUuid_Last(String uuid,
		OrderByComparator<WorkingTime> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<WorkingTime> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public WorkingTime[] findByUuid_PrevAndNext(long workingTimeId,
		String uuid, OrderByComparator<WorkingTime> orderByComparator)
		throws NoSuchWorkingTimeException {
		WorkingTime workingTime = findByPrimaryKey(workingTimeId);

		Session session = null;

		try {
			session = openSession();

			WorkingTime[] array = new WorkingTimeImpl[3];

			array[0] = getByUuid_PrevAndNext(session, workingTime, uuid,
					orderByComparator, true);

			array[1] = workingTime;

			array[2] = getByUuid_PrevAndNext(session, workingTime, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkingTime getByUuid_PrevAndNext(Session session,
		WorkingTime workingTime, String uuid,
		OrderByComparator<WorkingTime> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WORKINGTIME_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(WorkingTimeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(workingTime);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorkingTime> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the working times where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (WorkingTime workingTime : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(workingTime);
		}
	}

	/**
	 * Returns the number of working times where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching working times
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WORKINGTIME_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "workingTime.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "workingTime.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(workingTime.uuid IS NULL OR workingTime.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DATE = new FinderPath(WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
			WorkingTimeModelImpl.FINDER_CACHE_ENABLED, WorkingTimeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDate",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE = new FinderPath(WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
			WorkingTimeModelImpl.FINDER_CACHE_ENABLED, WorkingTimeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDate",
			new String[] { Date.class.getName() },
			WorkingTimeModelImpl.DATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DATE = new FinderPath(WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
			WorkingTimeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDate",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the working times where date = &#63;.
	 *
	 * @param date the date
	 * @return the matching working times
	 */
	@Override
	public List<WorkingTime> findByDate(Date date) {
		return findByDate(date, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<WorkingTime> findByDate(Date date, int start, int end) {
		return findByDate(date, start, end, null);
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
	@Override
	public List<WorkingTime> findByDate(Date date, int start, int end,
		OrderByComparator<WorkingTime> orderByComparator) {
		return findByDate(date, start, end, orderByComparator, true);
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
	@Override
	public List<WorkingTime> findByDate(Date date, int start, int end,
		OrderByComparator<WorkingTime> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE;
			finderArgs = new Object[] { date };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DATE;
			finderArgs = new Object[] { date, start, end, orderByComparator };
		}

		List<WorkingTime> list = null;

		if (retrieveFromCache) {
			list = (List<WorkingTime>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkingTime workingTime : list) {
					if (!Objects.equals(date, workingTime.getDate())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_WORKINGTIME_WHERE);

			boolean bindDate = false;

			if (date == null) {
				query.append(_FINDER_COLUMN_DATE_DATE_1);
			}
			else {
				bindDate = true;

				query.append(_FINDER_COLUMN_DATE_DATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WorkingTimeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDate) {
					qPos.add(new Timestamp(date.getTime()));
				}

				if (!pagination) {
					list = (List<WorkingTime>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WorkingTime>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first working time in the ordered set where date = &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching working time
	 * @throws NoSuchWorkingTimeException if a matching working time could not be found
	 */
	@Override
	public WorkingTime findByDate_First(Date date,
		OrderByComparator<WorkingTime> orderByComparator)
		throws NoSuchWorkingTimeException {
		WorkingTime workingTime = fetchByDate_First(date, orderByComparator);

		if (workingTime != null) {
			return workingTime;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("date=");
		msg.append(date);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkingTimeException(msg.toString());
	}

	/**
	 * Returns the first working time in the ordered set where date = &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching working time, or <code>null</code> if a matching working time could not be found
	 */
	@Override
	public WorkingTime fetchByDate_First(Date date,
		OrderByComparator<WorkingTime> orderByComparator) {
		List<WorkingTime> list = findByDate(date, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last working time in the ordered set where date = &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching working time
	 * @throws NoSuchWorkingTimeException if a matching working time could not be found
	 */
	@Override
	public WorkingTime findByDate_Last(Date date,
		OrderByComparator<WorkingTime> orderByComparator)
		throws NoSuchWorkingTimeException {
		WorkingTime workingTime = fetchByDate_Last(date, orderByComparator);

		if (workingTime != null) {
			return workingTime;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("date=");
		msg.append(date);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkingTimeException(msg.toString());
	}

	/**
	 * Returns the last working time in the ordered set where date = &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching working time, or <code>null</code> if a matching working time could not be found
	 */
	@Override
	public WorkingTime fetchByDate_Last(Date date,
		OrderByComparator<WorkingTime> orderByComparator) {
		int count = countByDate(date);

		if (count == 0) {
			return null;
		}

		List<WorkingTime> list = findByDate(date, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public WorkingTime[] findByDate_PrevAndNext(long workingTimeId, Date date,
		OrderByComparator<WorkingTime> orderByComparator)
		throws NoSuchWorkingTimeException {
		WorkingTime workingTime = findByPrimaryKey(workingTimeId);

		Session session = null;

		try {
			session = openSession();

			WorkingTime[] array = new WorkingTimeImpl[3];

			array[0] = getByDate_PrevAndNext(session, workingTime, date,
					orderByComparator, true);

			array[1] = workingTime;

			array[2] = getByDate_PrevAndNext(session, workingTime, date,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkingTime getByDate_PrevAndNext(Session session,
		WorkingTime workingTime, Date date,
		OrderByComparator<WorkingTime> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WORKINGTIME_WHERE);

		boolean bindDate = false;

		if (date == null) {
			query.append(_FINDER_COLUMN_DATE_DATE_1);
		}
		else {
			bindDate = true;

			query.append(_FINDER_COLUMN_DATE_DATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(WorkingTimeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDate) {
			qPos.add(new Timestamp(date.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(workingTime);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorkingTime> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the working times where date = &#63; from the database.
	 *
	 * @param date the date
	 */
	@Override
	public void removeByDate(Date date) {
		for (WorkingTime workingTime : findByDate(date, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(workingTime);
		}
	}

	/**
	 * Returns the number of working times where date = &#63;.
	 *
	 * @param date the date
	 * @return the number of matching working times
	 */
	@Override
	public int countByDate(Date date) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DATE;

		Object[] finderArgs = new Object[] { date };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WORKINGTIME_WHERE);

			boolean bindDate = false;

			if (date == null) {
				query.append(_FINDER_COLUMN_DATE_DATE_1);
			}
			else {
				bindDate = true;

				query.append(_FINDER_COLUMN_DATE_DATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDate) {
					qPos.add(new Timestamp(date.getTime()));
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DATE_DATE_1 = "workingTime.date IS NULL";
	private static final String _FINDER_COLUMN_DATE_DATE_2 = "workingTime.date = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERCODE = new FinderPath(WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
			WorkingTimeModelImpl.FINDER_CACHE_ENABLED, WorkingTimeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERCODE =
		new FinderPath(WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
			WorkingTimeModelImpl.FINDER_CACHE_ENABLED, WorkingTimeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserCode",
			new String[] { String.class.getName() },
			WorkingTimeModelImpl.USERCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERCODE = new FinderPath(WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
			WorkingTimeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the working times where userCode = &#63;.
	 *
	 * @param userCode the user code
	 * @return the matching working times
	 */
	@Override
	public List<WorkingTime> findByuserCode(String userCode) {
		return findByuserCode(userCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<WorkingTime> findByuserCode(String userCode, int start, int end) {
		return findByuserCode(userCode, start, end, null);
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
	@Override
	public List<WorkingTime> findByuserCode(String userCode, int start,
		int end, OrderByComparator<WorkingTime> orderByComparator) {
		return findByuserCode(userCode, start, end, orderByComparator, true);
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
	@Override
	public List<WorkingTime> findByuserCode(String userCode, int start,
		int end, OrderByComparator<WorkingTime> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERCODE;
			finderArgs = new Object[] { userCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERCODE;
			finderArgs = new Object[] { userCode, start, end, orderByComparator };
		}

		List<WorkingTime> list = null;

		if (retrieveFromCache) {
			list = (List<WorkingTime>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkingTime workingTime : list) {
					if (!Objects.equals(userCode, workingTime.getUserCode())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_WORKINGTIME_WHERE);

			boolean bindUserCode = false;

			if (userCode == null) {
				query.append(_FINDER_COLUMN_USERCODE_USERCODE_1);
			}
			else if (userCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERCODE_USERCODE_3);
			}
			else {
				bindUserCode = true;

				query.append(_FINDER_COLUMN_USERCODE_USERCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WorkingTimeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserCode) {
					qPos.add(userCode);
				}

				if (!pagination) {
					list = (List<WorkingTime>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WorkingTime>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first working time in the ordered set where userCode = &#63;.
	 *
	 * @param userCode the user code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching working time
	 * @throws NoSuchWorkingTimeException if a matching working time could not be found
	 */
	@Override
	public WorkingTime findByuserCode_First(String userCode,
		OrderByComparator<WorkingTime> orderByComparator)
		throws NoSuchWorkingTimeException {
		WorkingTime workingTime = fetchByuserCode_First(userCode,
				orderByComparator);

		if (workingTime != null) {
			return workingTime;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userCode=");
		msg.append(userCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkingTimeException(msg.toString());
	}

	/**
	 * Returns the first working time in the ordered set where userCode = &#63;.
	 *
	 * @param userCode the user code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching working time, or <code>null</code> if a matching working time could not be found
	 */
	@Override
	public WorkingTime fetchByuserCode_First(String userCode,
		OrderByComparator<WorkingTime> orderByComparator) {
		List<WorkingTime> list = findByuserCode(userCode, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last working time in the ordered set where userCode = &#63;.
	 *
	 * @param userCode the user code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching working time
	 * @throws NoSuchWorkingTimeException if a matching working time could not be found
	 */
	@Override
	public WorkingTime findByuserCode_Last(String userCode,
		OrderByComparator<WorkingTime> orderByComparator)
		throws NoSuchWorkingTimeException {
		WorkingTime workingTime = fetchByuserCode_Last(userCode,
				orderByComparator);

		if (workingTime != null) {
			return workingTime;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userCode=");
		msg.append(userCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkingTimeException(msg.toString());
	}

	/**
	 * Returns the last working time in the ordered set where userCode = &#63;.
	 *
	 * @param userCode the user code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching working time, or <code>null</code> if a matching working time could not be found
	 */
	@Override
	public WorkingTime fetchByuserCode_Last(String userCode,
		OrderByComparator<WorkingTime> orderByComparator) {
		int count = countByuserCode(userCode);

		if (count == 0) {
			return null;
		}

		List<WorkingTime> list = findByuserCode(userCode, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public WorkingTime[] findByuserCode_PrevAndNext(long workingTimeId,
		String userCode, OrderByComparator<WorkingTime> orderByComparator)
		throws NoSuchWorkingTimeException {
		WorkingTime workingTime = findByPrimaryKey(workingTimeId);

		Session session = null;

		try {
			session = openSession();

			WorkingTime[] array = new WorkingTimeImpl[3];

			array[0] = getByuserCode_PrevAndNext(session, workingTime,
					userCode, orderByComparator, true);

			array[1] = workingTime;

			array[2] = getByuserCode_PrevAndNext(session, workingTime,
					userCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkingTime getByuserCode_PrevAndNext(Session session,
		WorkingTime workingTime, String userCode,
		OrderByComparator<WorkingTime> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WORKINGTIME_WHERE);

		boolean bindUserCode = false;

		if (userCode == null) {
			query.append(_FINDER_COLUMN_USERCODE_USERCODE_1);
		}
		else if (userCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_USERCODE_USERCODE_3);
		}
		else {
			bindUserCode = true;

			query.append(_FINDER_COLUMN_USERCODE_USERCODE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(WorkingTimeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUserCode) {
			qPos.add(userCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(workingTime);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorkingTime> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the working times where userCode = &#63; from the database.
	 *
	 * @param userCode the user code
	 */
	@Override
	public void removeByuserCode(String userCode) {
		for (WorkingTime workingTime : findByuserCode(userCode,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(workingTime);
		}
	}

	/**
	 * Returns the number of working times where userCode = &#63;.
	 *
	 * @param userCode the user code
	 * @return the number of matching working times
	 */
	@Override
	public int countByuserCode(String userCode) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERCODE;

		Object[] finderArgs = new Object[] { userCode };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WORKINGTIME_WHERE);

			boolean bindUserCode = false;

			if (userCode == null) {
				query.append(_FINDER_COLUMN_USERCODE_USERCODE_1);
			}
			else if (userCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERCODE_USERCODE_3);
			}
			else {
				bindUserCode = true;

				query.append(_FINDER_COLUMN_USERCODE_USERCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserCode) {
					qPos.add(userCode);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERCODE_USERCODE_1 = "workingTime.userCode IS NULL";
	private static final String _FINDER_COLUMN_USERCODE_USERCODE_2 = "workingTime.userCode = ?";
	private static final String _FINDER_COLUMN_USERCODE_USERCODE_3 = "(workingTime.userCode IS NULL OR workingTime.userCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_D = new FinderPath(WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
			WorkingTimeModelImpl.FINDER_CACHE_ENABLED, WorkingTimeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_D",
			new String[] {
				Date.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_D = new FinderPath(WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
			WorkingTimeModelImpl.FINDER_CACHE_ENABLED, WorkingTimeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_D",
			new String[] { Date.class.getName(), String.class.getName() },
			WorkingTimeModelImpl.DATE_COLUMN_BITMASK |
			WorkingTimeModelImpl.USERCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_D = new FinderPath(WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
			WorkingTimeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_D",
			new String[] { Date.class.getName(), String.class.getName() });

	/**
	 * Returns all the working times where date = &#63; and userCode = &#63;.
	 *
	 * @param date the date
	 * @param userCode the user code
	 * @return the matching working times
	 */
	@Override
	public List<WorkingTime> findByC_D(Date date, String userCode) {
		return findByC_D(date, userCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<WorkingTime> findByC_D(Date date, String userCode, int start,
		int end) {
		return findByC_D(date, userCode, start, end, null);
	}

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
	@Override
	public List<WorkingTime> findByC_D(Date date, String userCode, int start,
		int end, OrderByComparator<WorkingTime> orderByComparator) {
		return findByC_D(date, userCode, start, end, orderByComparator, true);
	}

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
	@Override
	public List<WorkingTime> findByC_D(Date date, String userCode, int start,
		int end, OrderByComparator<WorkingTime> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_D;
			finderArgs = new Object[] { date, userCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_D;
			finderArgs = new Object[] {
					date, userCode,
					
					start, end, orderByComparator
				};
		}

		List<WorkingTime> list = null;

		if (retrieveFromCache) {
			list = (List<WorkingTime>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (WorkingTime workingTime : list) {
					if (!Objects.equals(date, workingTime.getDate()) ||
							!Objects.equals(userCode, workingTime.getUserCode())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_WORKINGTIME_WHERE);

			boolean bindDate = false;

			if (date == null) {
				query.append(_FINDER_COLUMN_C_D_DATE_1);
			}
			else {
				bindDate = true;

				query.append(_FINDER_COLUMN_C_D_DATE_2);
			}

			boolean bindUserCode = false;

			if (userCode == null) {
				query.append(_FINDER_COLUMN_C_D_USERCODE_1);
			}
			else if (userCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_D_USERCODE_3);
			}
			else {
				bindUserCode = true;

				query.append(_FINDER_COLUMN_C_D_USERCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WorkingTimeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDate) {
					qPos.add(new Timestamp(date.getTime()));
				}

				if (bindUserCode) {
					qPos.add(userCode);
				}

				if (!pagination) {
					list = (List<WorkingTime>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WorkingTime>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first working time in the ordered set where date = &#63; and userCode = &#63;.
	 *
	 * @param date the date
	 * @param userCode the user code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching working time
	 * @throws NoSuchWorkingTimeException if a matching working time could not be found
	 */
	@Override
	public WorkingTime findByC_D_First(Date date, String userCode,
		OrderByComparator<WorkingTime> orderByComparator)
		throws NoSuchWorkingTimeException {
		WorkingTime workingTime = fetchByC_D_First(date, userCode,
				orderByComparator);

		if (workingTime != null) {
			return workingTime;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("date=");
		msg.append(date);

		msg.append(", userCode=");
		msg.append(userCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkingTimeException(msg.toString());
	}

	/**
	 * Returns the first working time in the ordered set where date = &#63; and userCode = &#63;.
	 *
	 * @param date the date
	 * @param userCode the user code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching working time, or <code>null</code> if a matching working time could not be found
	 */
	@Override
	public WorkingTime fetchByC_D_First(Date date, String userCode,
		OrderByComparator<WorkingTime> orderByComparator) {
		List<WorkingTime> list = findByC_D(date, userCode, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last working time in the ordered set where date = &#63; and userCode = &#63;.
	 *
	 * @param date the date
	 * @param userCode the user code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching working time
	 * @throws NoSuchWorkingTimeException if a matching working time could not be found
	 */
	@Override
	public WorkingTime findByC_D_Last(Date date, String userCode,
		OrderByComparator<WorkingTime> orderByComparator)
		throws NoSuchWorkingTimeException {
		WorkingTime workingTime = fetchByC_D_Last(date, userCode,
				orderByComparator);

		if (workingTime != null) {
			return workingTime;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("date=");
		msg.append(date);

		msg.append(", userCode=");
		msg.append(userCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkingTimeException(msg.toString());
	}

	/**
	 * Returns the last working time in the ordered set where date = &#63; and userCode = &#63;.
	 *
	 * @param date the date
	 * @param userCode the user code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching working time, or <code>null</code> if a matching working time could not be found
	 */
	@Override
	public WorkingTime fetchByC_D_Last(Date date, String userCode,
		OrderByComparator<WorkingTime> orderByComparator) {
		int count = countByC_D(date, userCode);

		if (count == 0) {
			return null;
		}

		List<WorkingTime> list = findByC_D(date, userCode, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public WorkingTime[] findByC_D_PrevAndNext(long workingTimeId, Date date,
		String userCode, OrderByComparator<WorkingTime> orderByComparator)
		throws NoSuchWorkingTimeException {
		WorkingTime workingTime = findByPrimaryKey(workingTimeId);

		Session session = null;

		try {
			session = openSession();

			WorkingTime[] array = new WorkingTimeImpl[3];

			array[0] = getByC_D_PrevAndNext(session, workingTime, date,
					userCode, orderByComparator, true);

			array[1] = workingTime;

			array[2] = getByC_D_PrevAndNext(session, workingTime, date,
					userCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkingTime getByC_D_PrevAndNext(Session session,
		WorkingTime workingTime, Date date, String userCode,
		OrderByComparator<WorkingTime> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_WORKINGTIME_WHERE);

		boolean bindDate = false;

		if (date == null) {
			query.append(_FINDER_COLUMN_C_D_DATE_1);
		}
		else {
			bindDate = true;

			query.append(_FINDER_COLUMN_C_D_DATE_2);
		}

		boolean bindUserCode = false;

		if (userCode == null) {
			query.append(_FINDER_COLUMN_C_D_USERCODE_1);
		}
		else if (userCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_D_USERCODE_3);
		}
		else {
			bindUserCode = true;

			query.append(_FINDER_COLUMN_C_D_USERCODE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(WorkingTimeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDate) {
			qPos.add(new Timestamp(date.getTime()));
		}

		if (bindUserCode) {
			qPos.add(userCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(workingTime);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorkingTime> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the working times where date = &#63; and userCode = &#63; from the database.
	 *
	 * @param date the date
	 * @param userCode the user code
	 */
	@Override
	public void removeByC_D(Date date, String userCode) {
		for (WorkingTime workingTime : findByC_D(date, userCode,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(workingTime);
		}
	}

	/**
	 * Returns the number of working times where date = &#63; and userCode = &#63;.
	 *
	 * @param date the date
	 * @param userCode the user code
	 * @return the number of matching working times
	 */
	@Override
	public int countByC_D(Date date, String userCode) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_D;

		Object[] finderArgs = new Object[] { date, userCode };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WORKINGTIME_WHERE);

			boolean bindDate = false;

			if (date == null) {
				query.append(_FINDER_COLUMN_C_D_DATE_1);
			}
			else {
				bindDate = true;

				query.append(_FINDER_COLUMN_C_D_DATE_2);
			}

			boolean bindUserCode = false;

			if (userCode == null) {
				query.append(_FINDER_COLUMN_C_D_USERCODE_1);
			}
			else if (userCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_D_USERCODE_3);
			}
			else {
				bindUserCode = true;

				query.append(_FINDER_COLUMN_C_D_USERCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDate) {
					qPos.add(new Timestamp(date.getTime()));
				}

				if (bindUserCode) {
					qPos.add(userCode);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_D_DATE_1 = "workingTime.date IS NULL AND ";
	private static final String _FINDER_COLUMN_C_D_DATE_2 = "workingTime.date = ? AND ";
	private static final String _FINDER_COLUMN_C_D_USERCODE_1 = "workingTime.userCode IS NULL";
	private static final String _FINDER_COLUMN_C_D_USERCODE_2 = "workingTime.userCode = ?";
	private static final String _FINDER_COLUMN_C_D_USERCODE_3 = "(workingTime.userCode IS NULL OR workingTime.userCode = '')";

	public WorkingTimePersistenceImpl() {
		setModelClass(WorkingTime.class);
	}

	/**
	 * Caches the working time in the entity cache if it is enabled.
	 *
	 * @param workingTime the working time
	 */
	@Override
	public void cacheResult(WorkingTime workingTime) {
		entityCache.putResult(WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
			WorkingTimeImpl.class, workingTime.getPrimaryKey(), workingTime);

		workingTime.resetOriginalValues();
	}

	/**
	 * Caches the working times in the entity cache if it is enabled.
	 *
	 * @param workingTimes the working times
	 */
	@Override
	public void cacheResult(List<WorkingTime> workingTimes) {
		for (WorkingTime workingTime : workingTimes) {
			if (entityCache.getResult(
						WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
						WorkingTimeImpl.class, workingTime.getPrimaryKey()) == null) {
				cacheResult(workingTime);
			}
			else {
				workingTime.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all working times.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WorkingTimeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the working time.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkingTime workingTime) {
		entityCache.removeResult(WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
			WorkingTimeImpl.class, workingTime.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WorkingTime> workingTimes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WorkingTime workingTime : workingTimes) {
			entityCache.removeResult(WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
				WorkingTimeImpl.class, workingTime.getPrimaryKey());
		}
	}

	/**
	 * Creates a new working time with the primary key. Does not add the working time to the database.
	 *
	 * @param workingTimeId the primary key for the new working time
	 * @return the new working time
	 */
	@Override
	public WorkingTime create(long workingTimeId) {
		WorkingTime workingTime = new WorkingTimeImpl();

		workingTime.setNew(true);
		workingTime.setPrimaryKey(workingTimeId);

		String uuid = PortalUUIDUtil.generate();

		workingTime.setUuid(uuid);

		return workingTime;
	}

	/**
	 * Removes the working time with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workingTimeId the primary key of the working time
	 * @return the working time that was removed
	 * @throws NoSuchWorkingTimeException if a working time with the primary key could not be found
	 */
	@Override
	public WorkingTime remove(long workingTimeId)
		throws NoSuchWorkingTimeException {
		return remove((Serializable)workingTimeId);
	}

	/**
	 * Removes the working time with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the working time
	 * @return the working time that was removed
	 * @throws NoSuchWorkingTimeException if a working time with the primary key could not be found
	 */
	@Override
	public WorkingTime remove(Serializable primaryKey)
		throws NoSuchWorkingTimeException {
		Session session = null;

		try {
			session = openSession();

			WorkingTime workingTime = (WorkingTime)session.get(WorkingTimeImpl.class,
					primaryKey);

			if (workingTime == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkingTimeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(workingTime);
		}
		catch (NoSuchWorkingTimeException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected WorkingTime removeImpl(WorkingTime workingTime) {
		workingTime = toUnwrappedModel(workingTime);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workingTime)) {
				workingTime = (WorkingTime)session.get(WorkingTimeImpl.class,
						workingTime.getPrimaryKeyObj());
			}

			if (workingTime != null) {
				session.delete(workingTime);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (workingTime != null) {
			clearCache(workingTime);
		}

		return workingTime;
	}

	@Override
	public WorkingTime updateImpl(WorkingTime workingTime) {
		workingTime = toUnwrappedModel(workingTime);

		boolean isNew = workingTime.isNew();

		WorkingTimeModelImpl workingTimeModelImpl = (WorkingTimeModelImpl)workingTime;

		if (Validator.isNull(workingTime.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			workingTime.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (workingTime.isNew()) {
				session.save(workingTime);

				workingTime.setNew(false);
			}
			else {
				workingTime = (WorkingTime)session.merge(workingTime);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WorkingTimeModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((workingTimeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						workingTimeModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { workingTimeModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((workingTimeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						workingTimeModelImpl.getOriginalDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE,
					args);

				args = new Object[] { workingTimeModelImpl.getDate() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE,
					args);
			}

			if ((workingTimeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						workingTimeModelImpl.getOriginalUserCode()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERCODE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERCODE,
					args);

				args = new Object[] { workingTimeModelImpl.getUserCode() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERCODE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERCODE,
					args);
			}

			if ((workingTimeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_D.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						workingTimeModelImpl.getOriginalDate(),
						workingTimeModelImpl.getOriginalUserCode()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_D, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_D,
					args);

				args = new Object[] {
						workingTimeModelImpl.getDate(),
						workingTimeModelImpl.getUserCode()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_D, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_D,
					args);
			}
		}

		entityCache.putResult(WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
			WorkingTimeImpl.class, workingTime.getPrimaryKey(), workingTime,
			false);

		workingTime.resetOriginalValues();

		return workingTime;
	}

	protected WorkingTime toUnwrappedModel(WorkingTime workingTime) {
		if (workingTime instanceof WorkingTimeImpl) {
			return workingTime;
		}

		WorkingTimeImpl workingTimeImpl = new WorkingTimeImpl();

		workingTimeImpl.setNew(workingTime.isNew());
		workingTimeImpl.setPrimaryKey(workingTime.getPrimaryKey());

		workingTimeImpl.setUuid(workingTime.getUuid());
		workingTimeImpl.setWorkingTimeId(workingTime.getWorkingTimeId());
		workingTimeImpl.setDate(workingTime.getDate());
		workingTimeImpl.setUserCode(workingTime.getUserCode());
		workingTimeImpl.setStartTime(workingTime.getStartTime());
		workingTimeImpl.setEndTime(workingTime.getEndTime());

		return workingTimeImpl;
	}

	/**
	 * Returns the working time with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the working time
	 * @return the working time
	 * @throws NoSuchWorkingTimeException if a working time with the primary key could not be found
	 */
	@Override
	public WorkingTime findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkingTimeException {
		WorkingTime workingTime = fetchByPrimaryKey(primaryKey);

		if (workingTime == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkingTimeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return workingTime;
	}

	/**
	 * Returns the working time with the primary key or throws a {@link NoSuchWorkingTimeException} if it could not be found.
	 *
	 * @param workingTimeId the primary key of the working time
	 * @return the working time
	 * @throws NoSuchWorkingTimeException if a working time with the primary key could not be found
	 */
	@Override
	public WorkingTime findByPrimaryKey(long workingTimeId)
		throws NoSuchWorkingTimeException {
		return findByPrimaryKey((Serializable)workingTimeId);
	}

	/**
	 * Returns the working time with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the working time
	 * @return the working time, or <code>null</code> if a working time with the primary key could not be found
	 */
	@Override
	public WorkingTime fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
				WorkingTimeImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		WorkingTime workingTime = (WorkingTime)serializable;

		if (workingTime == null) {
			Session session = null;

			try {
				session = openSession();

				workingTime = (WorkingTime)session.get(WorkingTimeImpl.class,
						primaryKey);

				if (workingTime != null) {
					cacheResult(workingTime);
				}
				else {
					entityCache.putResult(WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
						WorkingTimeImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
					WorkingTimeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return workingTime;
	}

	/**
	 * Returns the working time with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workingTimeId the primary key of the working time
	 * @return the working time, or <code>null</code> if a working time with the primary key could not be found
	 */
	@Override
	public WorkingTime fetchByPrimaryKey(long workingTimeId) {
		return fetchByPrimaryKey((Serializable)workingTimeId);
	}

	@Override
	public Map<Serializable, WorkingTime> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, WorkingTime> map = new HashMap<Serializable, WorkingTime>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			WorkingTime workingTime = fetchByPrimaryKey(primaryKey);

			if (workingTime != null) {
				map.put(primaryKey, workingTime);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
					WorkingTimeImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (WorkingTime)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WORKINGTIME_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (WorkingTime workingTime : (List<WorkingTime>)q.list()) {
				map.put(workingTime.getPrimaryKeyObj(), workingTime);

				cacheResult(workingTime);

				uncachedPrimaryKeys.remove(workingTime.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WorkingTimeModelImpl.ENTITY_CACHE_ENABLED,
					WorkingTimeImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the working times.
	 *
	 * @return the working times
	 */
	@Override
	public List<WorkingTime> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<WorkingTime> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<WorkingTime> findAll(int start, int end,
		OrderByComparator<WorkingTime> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<WorkingTime> findAll(int start, int end,
		OrderByComparator<WorkingTime> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<WorkingTime> list = null;

		if (retrieveFromCache) {
			list = (List<WorkingTime>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WORKINGTIME);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WORKINGTIME;

				if (pagination) {
					sql = sql.concat(WorkingTimeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WorkingTime>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<WorkingTime>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the working times from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WorkingTime workingTime : findAll()) {
			remove(workingTime);
		}
	}

	/**
	 * Returns the number of working times.
	 *
	 * @return the number of working times
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WORKINGTIME);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return WorkingTimeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the working time persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WorkingTimeImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_WORKINGTIME = "SELECT workingTime FROM WorkingTime workingTime";
	private static final String _SQL_SELECT_WORKINGTIME_WHERE_PKS_IN = "SELECT workingTime FROM WorkingTime workingTime WHERE workingTimeId IN (";
	private static final String _SQL_SELECT_WORKINGTIME_WHERE = "SELECT workingTime FROM WorkingTime workingTime WHERE ";
	private static final String _SQL_COUNT_WORKINGTIME = "SELECT COUNT(workingTime) FROM WorkingTime workingTime";
	private static final String _SQL_COUNT_WORKINGTIME_WHERE = "SELECT COUNT(workingTime) FROM WorkingTime workingTime WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "workingTime.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WorkingTime exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WorkingTime exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(WorkingTimePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "date"
			});
}