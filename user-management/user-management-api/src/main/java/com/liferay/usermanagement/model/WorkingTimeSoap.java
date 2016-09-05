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

package com.liferay.usermanagement.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author phantoan
 * @generated
 */
@ProviderType
public class WorkingTimeSoap implements Serializable {
	public static WorkingTimeSoap toSoapModel(WorkingTime model) {
		WorkingTimeSoap soapModel = new WorkingTimeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setWorkingTimeId(model.getWorkingTimeId());
		soapModel.setDate(model.getDate());
		soapModel.setUserCode(model.getUserCode());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());

		return soapModel;
	}

	public static WorkingTimeSoap[] toSoapModels(WorkingTime[] models) {
		WorkingTimeSoap[] soapModels = new WorkingTimeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WorkingTimeSoap[][] toSoapModels(WorkingTime[][] models) {
		WorkingTimeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WorkingTimeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WorkingTimeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WorkingTimeSoap[] toSoapModels(List<WorkingTime> models) {
		List<WorkingTimeSoap> soapModels = new ArrayList<WorkingTimeSoap>(models.size());

		for (WorkingTime model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WorkingTimeSoap[soapModels.size()]);
	}

	public WorkingTimeSoap() {
	}

	public long getPrimaryKey() {
		return _workingTimeId;
	}

	public void setPrimaryKey(long pk) {
		setWorkingTimeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getWorkingTimeId() {
		return _workingTimeId;
	}

	public void setWorkingTimeId(long workingTimeId) {
		_workingTimeId = workingTimeId;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	public String getUserCode() {
		return _userCode;
	}

	public void setUserCode(String userCode) {
		_userCode = userCode;
	}

	public Date getStartTime() {
		return _startTime;
	}

	public void setStartTime(Date startTime) {
		_startTime = startTime;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	private String _uuid;
	private long _workingTimeId;
	private Date _date;
	private String _userCode;
	private Date _startTime;
	private Date _endTime;
	private long _groupId;
	private long _companyId;
}