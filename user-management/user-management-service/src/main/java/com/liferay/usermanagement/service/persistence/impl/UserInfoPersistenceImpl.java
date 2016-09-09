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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.liferay.usermanagement.exception.NoSuchUserInfoException;
import com.liferay.usermanagement.model.UserInfo;
import com.liferay.usermanagement.model.impl.UserInfoImpl;
import com.liferay.usermanagement.model.impl.UserInfoModelImpl;
import com.liferay.usermanagement.service.persistence.UserInfoPersistence;

import java.io.Serializable;

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
 * The persistence implementation for the user info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author phantoan
 * @see UserInfoPersistence
 * @see com.liferay.usermanagement.service.persistence.UserInfoUtil
 * @generated
 */
@ProviderType
public class UserInfoPersistenceImpl extends BasePersistenceImpl<UserInfo>
	implements UserInfoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserInfoUtil} to access the user info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserInfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, UserInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, UserInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, UserInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, UserInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			UserInfoModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the user infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user infos
	 */
	@Override
	public List<UserInfo> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<UserInfo> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<UserInfo> findByUuid(String uuid, int start, int end,
		OrderByComparator<UserInfo> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

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
	@Override
	public List<UserInfo> findByUuid(String uuid, int start, int end,
		OrderByComparator<UserInfo> orderByComparator, boolean retrieveFromCache) {
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

		List<UserInfo> list = null;

		if (retrieveFromCache) {
			list = (List<UserInfo>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserInfo userInfo : list) {
					if (!Objects.equals(uuid, userInfo.getUuid())) {
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

			query.append(_SQL_SELECT_USERINFO_WHERE);

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
				query.append(UserInfoModelImpl.ORDER_BY_JPQL);
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
					list = (List<UserInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserInfo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user info
	 * @throws NoSuchUserInfoException if a matching user info could not be found
	 */
	@Override
	public UserInfo findByUuid_First(String uuid,
		OrderByComparator<UserInfo> orderByComparator)
		throws NoSuchUserInfoException {
		UserInfo userInfo = fetchByUuid_First(uuid, orderByComparator);

		if (userInfo != null) {
			return userInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserInfoException(msg.toString());
	}

	/**
	 * Returns the first user info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user info, or <code>null</code> if a matching user info could not be found
	 */
	@Override
	public UserInfo fetchByUuid_First(String uuid,
		OrderByComparator<UserInfo> orderByComparator) {
		List<UserInfo> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user info
	 * @throws NoSuchUserInfoException if a matching user info could not be found
	 */
	@Override
	public UserInfo findByUuid_Last(String uuid,
		OrderByComparator<UserInfo> orderByComparator)
		throws NoSuchUserInfoException {
		UserInfo userInfo = fetchByUuid_Last(uuid, orderByComparator);

		if (userInfo != null) {
			return userInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserInfoException(msg.toString());
	}

	/**
	 * Returns the last user info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user info, or <code>null</code> if a matching user info could not be found
	 */
	@Override
	public UserInfo fetchByUuid_Last(String uuid,
		OrderByComparator<UserInfo> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UserInfo> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user infos before and after the current user info in the ordered set where uuid = &#63;.
	 *
	 * @param userCode the primary key of the current user info
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user info
	 * @throws NoSuchUserInfoException if a user info with the primary key could not be found
	 */
	@Override
	public UserInfo[] findByUuid_PrevAndNext(String userCode, String uuid,
		OrderByComparator<UserInfo> orderByComparator)
		throws NoSuchUserInfoException {
		UserInfo userInfo = findByPrimaryKey(userCode);

		Session session = null;

		try {
			session = openSession();

			UserInfo[] array = new UserInfoImpl[3];

			array[0] = getByUuid_PrevAndNext(session, userInfo, uuid,
					orderByComparator, true);

			array[1] = userInfo;

			array[2] = getByUuid_PrevAndNext(session, userInfo, uuid,
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

	protected UserInfo getByUuid_PrevAndNext(Session session,
		UserInfo userInfo, String uuid,
		OrderByComparator<UserInfo> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERINFO_WHERE);

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
			query.append(UserInfoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(userInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user infos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (UserInfo userInfo : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(userInfo);
		}
	}

	/**
	 * Returns the number of user infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user infos
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERINFO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "userInfo.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "userInfo.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(userInfo.uuid IS NULL OR userInfo.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, UserInfoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			UserInfoModelImpl.UUID_COLUMN_BITMASK |
			UserInfoModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the user info where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchUserInfoException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user info
	 * @throws NoSuchUserInfoException if a matching user info could not be found
	 */
	@Override
	public UserInfo findByUUID_G(String uuid, long groupId)
		throws NoSuchUserInfoException {
		UserInfo userInfo = fetchByUUID_G(uuid, groupId);

		if (userInfo == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchUserInfoException(msg.toString());
		}

		return userInfo;
	}

	/**
	 * Returns the user info where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user info, or <code>null</code> if a matching user info could not be found
	 */
	@Override
	public UserInfo fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the user info where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching user info, or <code>null</code> if a matching user info could not be found
	 */
	@Override
	public UserInfo fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof UserInfo) {
			UserInfo userInfo = (UserInfo)result;

			if (!Objects.equals(uuid, userInfo.getUuid()) ||
					(groupId != userInfo.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_USERINFO_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<UserInfo> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					UserInfo userInfo = list.get(0);

					result = userInfo;

					cacheResult(userInfo);

					if ((userInfo.getUuid() == null) ||
							!userInfo.getUuid().equals(uuid) ||
							(userInfo.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, userInfo);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (UserInfo)result;
		}
	}

	/**
	 * Removes the user info where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user info that was removed
	 */
	@Override
	public UserInfo removeByUUID_G(String uuid, long groupId)
		throws NoSuchUserInfoException {
		UserInfo userInfo = findByUUID_G(uuid, groupId);

		return remove(userInfo);
	}

	/**
	 * Returns the number of user infos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user infos
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERINFO_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "userInfo.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "userInfo.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(userInfo.uuid IS NULL OR userInfo.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "userInfo.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, UserInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, UserInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			UserInfoModelImpl.UUID_COLUMN_BITMASK |
			UserInfoModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the user infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user infos
	 */
	@Override
	public List<UserInfo> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<UserInfo> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

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
	@Override
	public List<UserInfo> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<UserInfo> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<UserInfo> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<UserInfo> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<UserInfo> list = null;

		if (retrieveFromCache) {
			list = (List<UserInfo>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserInfo userInfo : list) {
					if (!Objects.equals(uuid, userInfo.getUuid()) ||
							(companyId != userInfo.getCompanyId())) {
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

			query.append(_SQL_SELECT_USERINFO_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserInfoModelImpl.ORDER_BY_JPQL);
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

				qPos.add(companyId);

				if (!pagination) {
					list = (List<UserInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserInfo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user info
	 * @throws NoSuchUserInfoException if a matching user info could not be found
	 */
	@Override
	public UserInfo findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<UserInfo> orderByComparator)
		throws NoSuchUserInfoException {
		UserInfo userInfo = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (userInfo != null) {
			return userInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserInfoException(msg.toString());
	}

	/**
	 * Returns the first user info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user info, or <code>null</code> if a matching user info could not be found
	 */
	@Override
	public UserInfo fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<UserInfo> orderByComparator) {
		List<UserInfo> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user info
	 * @throws NoSuchUserInfoException if a matching user info could not be found
	 */
	@Override
	public UserInfo findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<UserInfo> orderByComparator)
		throws NoSuchUserInfoException {
		UserInfo userInfo = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (userInfo != null) {
			return userInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserInfoException(msg.toString());
	}

	/**
	 * Returns the last user info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user info, or <code>null</code> if a matching user info could not be found
	 */
	@Override
	public UserInfo fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<UserInfo> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<UserInfo> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public UserInfo[] findByUuid_C_PrevAndNext(String userCode, String uuid,
		long companyId, OrderByComparator<UserInfo> orderByComparator)
		throws NoSuchUserInfoException {
		UserInfo userInfo = findByPrimaryKey(userCode);

		Session session = null;

		try {
			session = openSession();

			UserInfo[] array = new UserInfoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, userInfo, uuid,
					companyId, orderByComparator, true);

			array[1] = userInfo;

			array[2] = getByUuid_C_PrevAndNext(session, userInfo, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserInfo getByUuid_C_PrevAndNext(Session session,
		UserInfo userInfo, String uuid, long companyId,
		OrderByComparator<UserInfo> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_USERINFO_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			query.append(UserInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user infos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (UserInfo userInfo : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userInfo);
		}
	}

	/**
	 * Returns the number of user infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user infos
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERINFO_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "userInfo.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "userInfo.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(userInfo.uuid IS NULL OR userInfo.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "userInfo.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, UserInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, UserInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			UserInfoModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the user infos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching user infos
	 */
	@Override
	public List<UserInfo> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<UserInfo> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

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
	@Override
	public List<UserInfo> findByGroupId(long groupId, int start, int end,
		OrderByComparator<UserInfo> orderByComparator) {
		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<UserInfo> findByGroupId(long groupId, int start, int end,
		OrderByComparator<UserInfo> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<UserInfo> list = null;

		if (retrieveFromCache) {
			list = (List<UserInfo>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserInfo userInfo : list) {
					if ((groupId != userInfo.getGroupId())) {
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

			query.append(_SQL_SELECT_USERINFO_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<UserInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserInfo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user info in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user info
	 * @throws NoSuchUserInfoException if a matching user info could not be found
	 */
	@Override
	public UserInfo findByGroupId_First(long groupId,
		OrderByComparator<UserInfo> orderByComparator)
		throws NoSuchUserInfoException {
		UserInfo userInfo = fetchByGroupId_First(groupId, orderByComparator);

		if (userInfo != null) {
			return userInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserInfoException(msg.toString());
	}

	/**
	 * Returns the first user info in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user info, or <code>null</code> if a matching user info could not be found
	 */
	@Override
	public UserInfo fetchByGroupId_First(long groupId,
		OrderByComparator<UserInfo> orderByComparator) {
		List<UserInfo> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user info in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user info
	 * @throws NoSuchUserInfoException if a matching user info could not be found
	 */
	@Override
	public UserInfo findByGroupId_Last(long groupId,
		OrderByComparator<UserInfo> orderByComparator)
		throws NoSuchUserInfoException {
		UserInfo userInfo = fetchByGroupId_Last(groupId, orderByComparator);

		if (userInfo != null) {
			return userInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserInfoException(msg.toString());
	}

	/**
	 * Returns the last user info in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user info, or <code>null</code> if a matching user info could not be found
	 */
	@Override
	public UserInfo fetchByGroupId_Last(long groupId,
		OrderByComparator<UserInfo> orderByComparator) {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<UserInfo> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user infos before and after the current user info in the ordered set where groupId = &#63;.
	 *
	 * @param userCode the primary key of the current user info
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user info
	 * @throws NoSuchUserInfoException if a user info with the primary key could not be found
	 */
	@Override
	public UserInfo[] findByGroupId_PrevAndNext(String userCode, long groupId,
		OrderByComparator<UserInfo> orderByComparator)
		throws NoSuchUserInfoException {
		UserInfo userInfo = findByPrimaryKey(userCode);

		Session session = null;

		try {
			session = openSession();

			UserInfo[] array = new UserInfoImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, userInfo, groupId,
					orderByComparator, true);

			array[1] = userInfo;

			array[2] = getByGroupId_PrevAndNext(session, userInfo, groupId,
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

	protected UserInfo getByGroupId_PrevAndNext(Session session,
		UserInfo userInfo, long groupId,
		OrderByComparator<UserInfo> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERINFO_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(UserInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user infos where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (UserInfo userInfo : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(userInfo);
		}
	}

	/**
	 * Returns the number of user infos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching user infos
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERINFO_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "userInfo.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_EMAIL = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, UserInfoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByEmail",
			new String[] { String.class.getName() },
			UserInfoModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAIL = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmail",
			new String[] { String.class.getName() });

	/**
	 * Returns the user info where email = &#63; or throws a {@link NoSuchUserInfoException} if it could not be found.
	 *
	 * @param email the email
	 * @return the matching user info
	 * @throws NoSuchUserInfoException if a matching user info could not be found
	 */
	@Override
	public UserInfo findByEmail(String email) throws NoSuchUserInfoException {
		UserInfo userInfo = fetchByEmail(email);

		if (userInfo == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("email=");
			msg.append(email);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchUserInfoException(msg.toString());
		}

		return userInfo;
	}

	/**
	 * Returns the user info where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching user info, or <code>null</code> if a matching user info could not be found
	 */
	@Override
	public UserInfo fetchByEmail(String email) {
		return fetchByEmail(email, true);
	}

	/**
	 * Returns the user info where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching user info, or <code>null</code> if a matching user info could not be found
	 */
	@Override
	public UserInfo fetchByEmail(String email, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { email };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_EMAIL,
					finderArgs, this);
		}

		if (result instanceof UserInfo) {
			UserInfo userInfo = (UserInfo)result;

			if (!Objects.equals(email, userInfo.getEmail())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERINFO_WHERE);

			boolean bindEmail = false;

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
			}
			else if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmail) {
					qPos.add(email);
				}

				List<UserInfo> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_EMAIL,
						finderArgs, list);
				}
				else {
					UserInfo userInfo = list.get(0);

					result = userInfo;

					cacheResult(userInfo);

					if ((userInfo.getEmail() == null) ||
							!userInfo.getEmail().equals(email)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_EMAIL,
							finderArgs, userInfo);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_EMAIL, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (UserInfo)result;
		}
	}

	/**
	 * Removes the user info where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the user info that was removed
	 */
	@Override
	public UserInfo removeByEmail(String email) throws NoSuchUserInfoException {
		UserInfo userInfo = findByEmail(email);

		return remove(userInfo);
	}

	/**
	 * Returns the number of user infos where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching user infos
	 */
	@Override
	public int countByEmail(String email) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAIL;

		Object[] finderArgs = new Object[] { email };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERINFO_WHERE);

			boolean bindEmail = false;

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
			}
			else if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmail) {
					qPos.add(email);
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

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_1 = "userInfo.email IS NULL";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 = "userInfo.email = ?";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 = "(userInfo.email IS NULL OR userInfo.email = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTCODE =
		new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, UserInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDepartmentCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTCODE =
		new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, UserInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDepartmentCode",
			new String[] { String.class.getName() },
			UserInfoModelImpl.DEPARTMENTCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTCODE = new FinderPath(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDepartmentCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the user infos where departmentCode = &#63;.
	 *
	 * @param departmentCode the department code
	 * @return the matching user infos
	 */
	@Override
	public List<UserInfo> findByDepartmentCode(String departmentCode) {
		return findByDepartmentCode(departmentCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<UserInfo> findByDepartmentCode(String departmentCode,
		int start, int end) {
		return findByDepartmentCode(departmentCode, start, end, null);
	}

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
	@Override
	public List<UserInfo> findByDepartmentCode(String departmentCode,
		int start, int end, OrderByComparator<UserInfo> orderByComparator) {
		return findByDepartmentCode(departmentCode, start, end,
			orderByComparator, true);
	}

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
	@Override
	public List<UserInfo> findByDepartmentCode(String departmentCode,
		int start, int end, OrderByComparator<UserInfo> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTCODE;
			finderArgs = new Object[] { departmentCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTCODE;
			finderArgs = new Object[] {
					departmentCode,
					
					start, end, orderByComparator
				};
		}

		List<UserInfo> list = null;

		if (retrieveFromCache) {
			list = (List<UserInfo>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserInfo userInfo : list) {
					if (!Objects.equals(departmentCode,
								userInfo.getDepartmentCode())) {
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

			query.append(_SQL_SELECT_USERINFO_WHERE);

			boolean bindDepartmentCode = false;

			if (departmentCode == null) {
				query.append(_FINDER_COLUMN_DEPARTMENTCODE_DEPARTMENTCODE_1);
			}
			else if (departmentCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DEPARTMENTCODE_DEPARTMENTCODE_3);
			}
			else {
				bindDepartmentCode = true;

				query.append(_FINDER_COLUMN_DEPARTMENTCODE_DEPARTMENTCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDepartmentCode) {
					qPos.add(departmentCode);
				}

				if (!pagination) {
					list = (List<UserInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserInfo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first user info in the ordered set where departmentCode = &#63;.
	 *
	 * @param departmentCode the department code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user info
	 * @throws NoSuchUserInfoException if a matching user info could not be found
	 */
	@Override
	public UserInfo findByDepartmentCode_First(String departmentCode,
		OrderByComparator<UserInfo> orderByComparator)
		throws NoSuchUserInfoException {
		UserInfo userInfo = fetchByDepartmentCode_First(departmentCode,
				orderByComparator);

		if (userInfo != null) {
			return userInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentCode=");
		msg.append(departmentCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserInfoException(msg.toString());
	}

	/**
	 * Returns the first user info in the ordered set where departmentCode = &#63;.
	 *
	 * @param departmentCode the department code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user info, or <code>null</code> if a matching user info could not be found
	 */
	@Override
	public UserInfo fetchByDepartmentCode_First(String departmentCode,
		OrderByComparator<UserInfo> orderByComparator) {
		List<UserInfo> list = findByDepartmentCode(departmentCode, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user info in the ordered set where departmentCode = &#63;.
	 *
	 * @param departmentCode the department code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user info
	 * @throws NoSuchUserInfoException if a matching user info could not be found
	 */
	@Override
	public UserInfo findByDepartmentCode_Last(String departmentCode,
		OrderByComparator<UserInfo> orderByComparator)
		throws NoSuchUserInfoException {
		UserInfo userInfo = fetchByDepartmentCode_Last(departmentCode,
				orderByComparator);

		if (userInfo != null) {
			return userInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentCode=");
		msg.append(departmentCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserInfoException(msg.toString());
	}

	/**
	 * Returns the last user info in the ordered set where departmentCode = &#63;.
	 *
	 * @param departmentCode the department code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user info, or <code>null</code> if a matching user info could not be found
	 */
	@Override
	public UserInfo fetchByDepartmentCode_Last(String departmentCode,
		OrderByComparator<UserInfo> orderByComparator) {
		int count = countByDepartmentCode(departmentCode);

		if (count == 0) {
			return null;
		}

		List<UserInfo> list = findByDepartmentCode(departmentCode, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user infos before and after the current user info in the ordered set where departmentCode = &#63;.
	 *
	 * @param userCode the primary key of the current user info
	 * @param departmentCode the department code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user info
	 * @throws NoSuchUserInfoException if a user info with the primary key could not be found
	 */
	@Override
	public UserInfo[] findByDepartmentCode_PrevAndNext(String userCode,
		String departmentCode, OrderByComparator<UserInfo> orderByComparator)
		throws NoSuchUserInfoException {
		UserInfo userInfo = findByPrimaryKey(userCode);

		Session session = null;

		try {
			session = openSession();

			UserInfo[] array = new UserInfoImpl[3];

			array[0] = getByDepartmentCode_PrevAndNext(session, userInfo,
					departmentCode, orderByComparator, true);

			array[1] = userInfo;

			array[2] = getByDepartmentCode_PrevAndNext(session, userInfo,
					departmentCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserInfo getByDepartmentCode_PrevAndNext(Session session,
		UserInfo userInfo, String departmentCode,
		OrderByComparator<UserInfo> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERINFO_WHERE);

		boolean bindDepartmentCode = false;

		if (departmentCode == null) {
			query.append(_FINDER_COLUMN_DEPARTMENTCODE_DEPARTMENTCODE_1);
		}
		else if (departmentCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DEPARTMENTCODE_DEPARTMENTCODE_3);
		}
		else {
			bindDepartmentCode = true;

			query.append(_FINDER_COLUMN_DEPARTMENTCODE_DEPARTMENTCODE_2);
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
			query.append(UserInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDepartmentCode) {
			qPos.add(departmentCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user infos where departmentCode = &#63; from the database.
	 *
	 * @param departmentCode the department code
	 */
	@Override
	public void removeByDepartmentCode(String departmentCode) {
		for (UserInfo userInfo : findByDepartmentCode(departmentCode,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userInfo);
		}
	}

	/**
	 * Returns the number of user infos where departmentCode = &#63;.
	 *
	 * @param departmentCode the department code
	 * @return the number of matching user infos
	 */
	@Override
	public int countByDepartmentCode(String departmentCode) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DEPARTMENTCODE;

		Object[] finderArgs = new Object[] { departmentCode };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERINFO_WHERE);

			boolean bindDepartmentCode = false;

			if (departmentCode == null) {
				query.append(_FINDER_COLUMN_DEPARTMENTCODE_DEPARTMENTCODE_1);
			}
			else if (departmentCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DEPARTMENTCODE_DEPARTMENTCODE_3);
			}
			else {
				bindDepartmentCode = true;

				query.append(_FINDER_COLUMN_DEPARTMENTCODE_DEPARTMENTCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDepartmentCode) {
					qPos.add(departmentCode);
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

	private static final String _FINDER_COLUMN_DEPARTMENTCODE_DEPARTMENTCODE_1 = "userInfo.departmentCode IS NULL";
	private static final String _FINDER_COLUMN_DEPARTMENTCODE_DEPARTMENTCODE_2 = "userInfo.departmentCode = ?";
	private static final String _FINDER_COLUMN_DEPARTMENTCODE_DEPARTMENTCODE_3 = "(userInfo.departmentCode IS NULL OR userInfo.departmentCode = '')";

	public UserInfoPersistenceImpl() {
		setModelClass(UserInfo.class);
	}

	/**
	 * Caches the user info in the entity cache if it is enabled.
	 *
	 * @param userInfo the user info
	 */
	@Override
	public void cacheResult(UserInfo userInfo) {
		entityCache.putResult(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoImpl.class, userInfo.getPrimaryKey(), userInfo);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { userInfo.getUuid(), userInfo.getGroupId() }, userInfo);

		finderCache.putResult(FINDER_PATH_FETCH_BY_EMAIL,
			new Object[] { userInfo.getEmail() }, userInfo);

		userInfo.resetOriginalValues();
	}

	/**
	 * Caches the user infos in the entity cache if it is enabled.
	 *
	 * @param userInfos the user infos
	 */
	@Override
	public void cacheResult(List<UserInfo> userInfos) {
		for (UserInfo userInfo : userInfos) {
			if (entityCache.getResult(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
						UserInfoImpl.class, userInfo.getPrimaryKey()) == null) {
				cacheResult(userInfo);
			}
			else {
				userInfo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user infos.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserInfoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user info.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserInfo userInfo) {
		entityCache.removeResult(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoImpl.class, userInfo.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((UserInfoModelImpl)userInfo);
	}

	@Override
	public void clearCache(List<UserInfo> userInfos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserInfo userInfo : userInfos) {
			entityCache.removeResult(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
				UserInfoImpl.class, userInfo.getPrimaryKey());

			clearUniqueFindersCache((UserInfoModelImpl)userInfo);
		}
	}

	protected void cacheUniqueFindersCache(
		UserInfoModelImpl userInfoModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					userInfoModelImpl.getUuid(), userInfoModelImpl.getGroupId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				userInfoModelImpl);

			args = new Object[] { userInfoModelImpl.getEmail() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_EMAIL, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_EMAIL, args,
				userInfoModelImpl);
		}
		else {
			if ((userInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userInfoModelImpl.getUuid(),
						userInfoModelImpl.getGroupId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					userInfoModelImpl);
			}

			if ((userInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { userInfoModelImpl.getEmail() };

				finderCache.putResult(FINDER_PATH_COUNT_BY_EMAIL, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_EMAIL, args,
					userInfoModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(UserInfoModelImpl userInfoModelImpl) {
		Object[] args = new Object[] {
				userInfoModelImpl.getUuid(), userInfoModelImpl.getGroupId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((userInfoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					userInfoModelImpl.getOriginalUuid(),
					userInfoModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { userInfoModelImpl.getEmail() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_EMAIL, args);

		if ((userInfoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMAIL.getColumnBitmask()) != 0) {
			args = new Object[] { userInfoModelImpl.getOriginalEmail() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMAIL, args);
		}
	}

	/**
	 * Creates a new user info with the primary key. Does not add the user info to the database.
	 *
	 * @param userCode the primary key for the new user info
	 * @return the new user info
	 */
	@Override
	public UserInfo create(String userCode) {
		UserInfo userInfo = new UserInfoImpl();

		userInfo.setNew(true);
		userInfo.setPrimaryKey(userCode);

		String uuid = PortalUUIDUtil.generate();

		userInfo.setUuid(uuid);

		userInfo.setCompanyId(companyProvider.getCompanyId());

		return userInfo;
	}

	/**
	 * Removes the user info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userCode the primary key of the user info
	 * @return the user info that was removed
	 * @throws NoSuchUserInfoException if a user info with the primary key could not be found
	 */
	@Override
	public UserInfo remove(String userCode) throws NoSuchUserInfoException {
		return remove((Serializable)userCode);
	}

	/**
	 * Removes the user info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user info
	 * @return the user info that was removed
	 * @throws NoSuchUserInfoException if a user info with the primary key could not be found
	 */
	@Override
	public UserInfo remove(Serializable primaryKey)
		throws NoSuchUserInfoException {
		Session session = null;

		try {
			session = openSession();

			UserInfo userInfo = (UserInfo)session.get(UserInfoImpl.class,
					primaryKey);

			if (userInfo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userInfo);
		}
		catch (NoSuchUserInfoException nsee) {
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
	protected UserInfo removeImpl(UserInfo userInfo) {
		userInfo = toUnwrappedModel(userInfo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userInfo)) {
				userInfo = (UserInfo)session.get(UserInfoImpl.class,
						userInfo.getPrimaryKeyObj());
			}

			if (userInfo != null) {
				session.delete(userInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userInfo != null) {
			clearCache(userInfo);
		}

		return userInfo;
	}

	@Override
	public UserInfo updateImpl(UserInfo userInfo) {
		userInfo = toUnwrappedModel(userInfo);

		boolean isNew = userInfo.isNew();

		UserInfoModelImpl userInfoModelImpl = (UserInfoModelImpl)userInfo;

		if (Validator.isNull(userInfo.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			userInfo.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (userInfo.getCreateDate() == null)) {
			if (serviceContext == null) {
				userInfo.setCreateDate(now);
			}
			else {
				userInfo.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!userInfoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				userInfo.setModifiedDate(now);
			}
			else {
				userInfo.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (userInfo.isNew()) {
				session.save(userInfo);

				userInfo.setNew(false);
			}
			else {
				userInfo = (UserInfo)session.merge(userInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserInfoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((userInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { userInfoModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { userInfoModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((userInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userInfoModelImpl.getOriginalUuid(),
						userInfoModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						userInfoModelImpl.getUuid(),
						userInfoModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((userInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userInfoModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { userInfoModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((userInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userInfoModelImpl.getOriginalDepartmentCode()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTCODE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTCODE,
					args);

				args = new Object[] { userInfoModelImpl.getDepartmentCode() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTCODE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTCODE,
					args);
			}
		}

		entityCache.putResult(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
			UserInfoImpl.class, userInfo.getPrimaryKey(), userInfo, false);

		clearUniqueFindersCache(userInfoModelImpl);
		cacheUniqueFindersCache(userInfoModelImpl, isNew);

		userInfo.resetOriginalValues();

		return userInfo;
	}

	protected UserInfo toUnwrappedModel(UserInfo userInfo) {
		if (userInfo instanceof UserInfoImpl) {
			return userInfo;
		}

		UserInfoImpl userInfoImpl = new UserInfoImpl();

		userInfoImpl.setNew(userInfo.isNew());
		userInfoImpl.setPrimaryKey(userInfo.getPrimaryKey());

		userInfoImpl.setUuid(userInfo.getUuid());
		userInfoImpl.setUserCode(userInfo.getUserCode());
		userInfoImpl.setUserId(userInfo.getUserId());
		userInfoImpl.setUsername(userInfo.getUsername());
		userInfoImpl.setMale(userInfo.isMale());
		userInfoImpl.setBirthday(userInfo.getBirthday());
		userInfoImpl.setAddress(userInfo.getAddress());
		userInfoImpl.setEmail(userInfo.getEmail());
		userInfoImpl.setPhone(userInfo.getPhone());
		userInfoImpl.setDepartmentCode(userInfo.getDepartmentCode());
		userInfoImpl.setRole(userInfo.getRole());
		userInfoImpl.setGroupId(userInfo.getGroupId());
		userInfoImpl.setCompanyId(userInfo.getCompanyId());
		userInfoImpl.setCreateDate(userInfo.getCreateDate());
		userInfoImpl.setModifiedDate(userInfo.getModifiedDate());

		return userInfoImpl;
	}

	/**
	 * Returns the user info with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user info
	 * @return the user info
	 * @throws NoSuchUserInfoException if a user info with the primary key could not be found
	 */
	@Override
	public UserInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserInfoException {
		UserInfo userInfo = fetchByPrimaryKey(primaryKey);

		if (userInfo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userInfo;
	}

	/**
	 * Returns the user info with the primary key or throws a {@link NoSuchUserInfoException} if it could not be found.
	 *
	 * @param userCode the primary key of the user info
	 * @return the user info
	 * @throws NoSuchUserInfoException if a user info with the primary key could not be found
	 */
	@Override
	public UserInfo findByPrimaryKey(String userCode)
		throws NoSuchUserInfoException {
		return findByPrimaryKey((Serializable)userCode);
	}

	/**
	 * Returns the user info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user info
	 * @return the user info, or <code>null</code> if a user info with the primary key could not be found
	 */
	@Override
	public UserInfo fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
				UserInfoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		UserInfo userInfo = (UserInfo)serializable;

		if (userInfo == null) {
			Session session = null;

			try {
				session = openSession();

				userInfo = (UserInfo)session.get(UserInfoImpl.class, primaryKey);

				if (userInfo != null) {
					cacheResult(userInfo);
				}
				else {
					entityCache.putResult(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
						UserInfoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
					UserInfoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userInfo;
	}

	/**
	 * Returns the user info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userCode the primary key of the user info
	 * @return the user info, or <code>null</code> if a user info with the primary key could not be found
	 */
	@Override
	public UserInfo fetchByPrimaryKey(String userCode) {
		return fetchByPrimaryKey((Serializable)userCode);
	}

	@Override
	public Map<Serializable, UserInfo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, UserInfo> map = new HashMap<Serializable, UserInfo>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			UserInfo userInfo = fetchByPrimaryKey(primaryKey);

			if (userInfo != null) {
				map.put(primaryKey, userInfo);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
					UserInfoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (UserInfo)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 4) +
				1);

		query.append(_SQL_SELECT_USERINFO_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(StringPool.APOSTROPHE);
			query.append((String)primaryKey);
			query.append(StringPool.APOSTROPHE);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (UserInfo userInfo : (List<UserInfo>)q.list()) {
				map.put(userInfo.getPrimaryKeyObj(), userInfo);

				cacheResult(userInfo);

				uncachedPrimaryKeys.remove(userInfo.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(UserInfoModelImpl.ENTITY_CACHE_ENABLED,
					UserInfoImpl.class, primaryKey, nullModel);
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
	 * Returns all the user infos.
	 *
	 * @return the user infos
	 */
	@Override
	public List<UserInfo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<UserInfo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<UserInfo> findAll(int start, int end,
		OrderByComparator<UserInfo> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<UserInfo> findAll(int start, int end,
		OrderByComparator<UserInfo> orderByComparator, boolean retrieveFromCache) {
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

		List<UserInfo> list = null;

		if (retrieveFromCache) {
			list = (List<UserInfo>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERINFO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERINFO;

				if (pagination) {
					sql = sql.concat(UserInfoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserInfo>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the user infos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserInfo userInfo : findAll()) {
			remove(userInfo);
		}
	}

	/**
	 * Returns the number of user infos.
	 *
	 * @return the number of user infos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERINFO);

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
		return UserInfoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user info persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(UserInfoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_USERINFO = "SELECT userInfo FROM UserInfo userInfo";
	private static final String _SQL_SELECT_USERINFO_WHERE_PKS_IN = "SELECT userInfo FROM UserInfo userInfo WHERE userCode IN (";
	private static final String _SQL_SELECT_USERINFO_WHERE = "SELECT userInfo FROM UserInfo userInfo WHERE ";
	private static final String _SQL_COUNT_USERINFO = "SELECT COUNT(userInfo) FROM UserInfo userInfo";
	private static final String _SQL_COUNT_USERINFO_WHERE = "SELECT COUNT(userInfo) FROM UserInfo userInfo WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userInfo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserInfo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserInfo exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(UserInfoPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}