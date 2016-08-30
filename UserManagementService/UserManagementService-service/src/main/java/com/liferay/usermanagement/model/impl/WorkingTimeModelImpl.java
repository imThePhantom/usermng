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

package com.liferay.usermanagement.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.usermanagement.model.WorkingTime;
import com.liferay.usermanagement.model.WorkingTimeModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the WorkingTime service. Represents a row in the &quot;CRM_WorkingTime&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link WorkingTimeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WorkingTimeImpl}.
 * </p>
 *
 * @author phantoan
 * @see WorkingTimeImpl
 * @see WorkingTime
 * @see WorkingTimeModel
 * @generated
 */
@ProviderType
public class WorkingTimeModelImpl extends BaseModelImpl<WorkingTime>
	implements WorkingTimeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a working time model instance should use the {@link WorkingTime} interface instead.
	 */
	public static final String TABLE_NAME = "CRM_WorkingTime";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "workingTimeId", Types.BIGINT },
			{ "date_", Types.TIMESTAMP },
			{ "userCode", Types.VARCHAR },
			{ "startTime", Types.TIMESTAMP },
			{ "endTime", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("workingTimeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("date_", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("userCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("startTime", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("endTime", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table CRM_WorkingTime (uuid_ VARCHAR(75) null,workingTimeId LONG not null primary key,date_ DATE null,userCode VARCHAR(75) null,startTime DATE null,endTime DATE null)";
	public static final String TABLE_SQL_DROP = "drop table CRM_WorkingTime";
	public static final String ORDER_BY_JPQL = " ORDER BY workingTime.workingTimeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CRM_WorkingTime.workingTimeId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.usermanagement.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.usermanagement.model.WorkingTime"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.usermanagement.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.usermanagement.model.WorkingTime"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.usermanagement.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.usermanagement.model.WorkingTime"),
			true);
	public static final long DATE_COLUMN_BITMASK = 1L;
	public static final long USERCODE_COLUMN_BITMASK = 2L;
	public static final long UUID_COLUMN_BITMASK = 4L;
	public static final long WORKINGTIMEID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.usermanagement.service.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.usermanagement.model.WorkingTime"));

	public WorkingTimeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _workingTimeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setWorkingTimeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _workingTimeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return WorkingTime.class;
	}

	@Override
	public String getModelClassName() {
		return WorkingTime.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("workingTimeId", getWorkingTimeId());
		attributes.put("date", getDate());
		attributes.put("userCode", getUserCode());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long workingTimeId = (Long)attributes.get("workingTimeId");

		if (workingTimeId != null) {
			setWorkingTimeId(workingTimeId);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		String userCode = (String)attributes.get("userCode");

		if (userCode != null) {
			setUserCode(userCode);
		}

		Date startTime = (Date)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Date endTime = (Date)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getWorkingTimeId() {
		return _workingTimeId;
	}

	@Override
	public void setWorkingTimeId(long workingTimeId) {
		_workingTimeId = workingTimeId;
	}

	@Override
	public Date getDate() {
		return _date;
	}

	@Override
	public void setDate(Date date) {
		_columnBitmask |= DATE_COLUMN_BITMASK;

		if (_originalDate == null) {
			_originalDate = _date;
		}

		_date = date;
	}

	public Date getOriginalDate() {
		return _originalDate;
	}

	@Override
	public String getUserCode() {
		if (_userCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _userCode;
		}
	}

	@Override
	public void setUserCode(String userCode) {
		_columnBitmask |= USERCODE_COLUMN_BITMASK;

		if (_originalUserCode == null) {
			_originalUserCode = _userCode;
		}

		_userCode = userCode;
	}

	public String getOriginalUserCode() {
		return GetterUtil.getString(_originalUserCode);
	}

	@Override
	public Date getStartTime() {
		return _startTime;
	}

	@Override
	public void setStartTime(Date startTime) {
		_startTime = startTime;
	}

	@Override
	public Date getEndTime() {
		return _endTime;
	}

	@Override
	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			WorkingTime.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public WorkingTime toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (WorkingTime)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		WorkingTimeImpl workingTimeImpl = new WorkingTimeImpl();

		workingTimeImpl.setUuid(getUuid());
		workingTimeImpl.setWorkingTimeId(getWorkingTimeId());
		workingTimeImpl.setDate(getDate());
		workingTimeImpl.setUserCode(getUserCode());
		workingTimeImpl.setStartTime(getStartTime());
		workingTimeImpl.setEndTime(getEndTime());

		workingTimeImpl.resetOriginalValues();

		return workingTimeImpl;
	}

	@Override
	public int compareTo(WorkingTime workingTime) {
		long primaryKey = workingTime.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkingTime)) {
			return false;
		}

		WorkingTime workingTime = (WorkingTime)obj;

		long primaryKey = workingTime.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		WorkingTimeModelImpl workingTimeModelImpl = this;

		workingTimeModelImpl._originalUuid = workingTimeModelImpl._uuid;

		workingTimeModelImpl._originalDate = workingTimeModelImpl._date;

		workingTimeModelImpl._originalUserCode = workingTimeModelImpl._userCode;

		workingTimeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<WorkingTime> toCacheModel() {
		WorkingTimeCacheModel workingTimeCacheModel = new WorkingTimeCacheModel();

		workingTimeCacheModel.uuid = getUuid();

		String uuid = workingTimeCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			workingTimeCacheModel.uuid = null;
		}

		workingTimeCacheModel.workingTimeId = getWorkingTimeId();

		Date date = getDate();

		if (date != null) {
			workingTimeCacheModel.date = date.getTime();
		}
		else {
			workingTimeCacheModel.date = Long.MIN_VALUE;
		}

		workingTimeCacheModel.userCode = getUserCode();

		String userCode = workingTimeCacheModel.userCode;

		if ((userCode != null) && (userCode.length() == 0)) {
			workingTimeCacheModel.userCode = null;
		}

		Date startTime = getStartTime();

		if (startTime != null) {
			workingTimeCacheModel.startTime = startTime.getTime();
		}
		else {
			workingTimeCacheModel.startTime = Long.MIN_VALUE;
		}

		Date endTime = getEndTime();

		if (endTime != null) {
			workingTimeCacheModel.endTime = endTime.getTime();
		}
		else {
			workingTimeCacheModel.endTime = Long.MIN_VALUE;
		}

		return workingTimeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", workingTimeId=");
		sb.append(getWorkingTimeId());
		sb.append(", date=");
		sb.append(getDate());
		sb.append(", userCode=");
		sb.append(getUserCode());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.liferay.usermanagement.model.WorkingTime");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workingTimeId</column-name><column-value><![CDATA[");
		sb.append(getWorkingTimeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date</column-name><column-value><![CDATA[");
		sb.append(getDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userCode</column-name><column-value><![CDATA[");
		sb.append(getUserCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = WorkingTime.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			WorkingTime.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _workingTimeId;
	private Date _date;
	private Date _originalDate;
	private String _userCode;
	private String _originalUserCode;
	private Date _startTime;
	private Date _endTime;
	private long _columnBitmask;
	private WorkingTime _escapedModel;
}