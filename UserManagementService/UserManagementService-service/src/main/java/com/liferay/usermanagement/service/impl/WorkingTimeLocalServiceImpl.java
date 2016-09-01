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

package com.liferay.usermanagement.service.impl;

import aQute.bnd.annotation.ProviderType;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.usermanagement.exception.WorkingTimeDateException;
import com.liferay.usermanagement.exception.WorkingTimeUserCodeException;
import com.liferay.usermanagement.model.WorkingTime;
import com.liferay.usermanagement.service.base.WorkingTimeLocalServiceBaseImpl;

/**
 * The implementation of the working time local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.usermanagement.service.WorkingTimeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author phantoan
 * @see WorkingTimeLocalServiceBaseImpl
 * @see com.liferay.usermanagement.service.WorkingTimeLocalServiceUtil
 */
@ProviderType
public class WorkingTimeLocalServiceImpl extends WorkingTimeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.liferay.usermanagement.service.WorkingTimeLocalServiceUtil} to access
	 * the working time local service.
	 */
	public WorkingTime addWorkingTime(Date date, String userCode, Date startTime, Date endTime,
			ServiceContext serviceContext) throws PortalException, SystemException {
		long groupId = serviceContext.getScopeGroupId();
		long companyId = CompanyLocalServiceUtil.getCompanyByWebId("liferay.com").getCompanyId();

		validate(date, userCode);

		long workingTimeId = counterLocalService.increment();
		WorkingTime workingTime = workingTimePersistence.create(workingTimeId);

		workingTime.setUuid(serviceContext.getUuid());
		workingTime.setDate(date);
		workingTime.setUserCode(userCode);
		workingTime.setStartTime(startTime);
		workingTime.setEndTime(endTime);
		workingTime.setGroupId(groupId);
		workingTime.setCompanyId(companyId);

		workingTimePersistence.update(workingTime);

		return workingTime;
	}

	public List<WorkingTime> getWorkingTimesByDate(Date date) throws PortalException, SystemException {
		return workingTimePersistence.findByDate(date);
	}

	public int countWorkingTimeByDate(Date date) throws PortalException, SystemException {
		return workingTimePersistence.countByDate(date);
	}

	public List<WorkingTime> getWorkingTimesByUserCode(String userCode) throws PortalException, SystemException {
		return workingTimePersistence.findByuserCode(userCode);
	}

	public int countWorkingTimeByUserCode(String userCode) throws PortalException, SystemException {
		return workingTimePersistence.countByuserCode(userCode);
	}

	public WorkingTime getWorkingTimeByC_D(Date date, String userCode) throws PortalException, SystemException {
		return workingTimePersistence.findByC_D(userCode, date);
	}

	public WorkingTime updateWorkingTime(long workingTimeId, Date startTime, Date endTime,
			ServiceContext serviceContext) throws PortalException, SystemException {
		long groupId = serviceContext.getScopeGroupId();
		long companyId = CompanyLocalServiceUtil.getCompanyByWebId("liferay.com").getCompanyId();

		WorkingTime workingTime = getWorkingTime(workingTimeId);

		workingTime.setUuid(serviceContext.getUuid());
		workingTime.setStartTime(startTime);
		workingTime.setEndTime(endTime);
		workingTime.setGroupId(groupId);
		workingTime.setCompanyId(companyId);

		workingTimePersistence.update(workingTime);

		return workingTime;
	}

	protected void validate(Date date, String userCode) throws PortalException {
		if (Validator.isNull(date)) {
			throw new WorkingTimeDateException();
		}
		if (Validator.isNull(userCode)) {
			throw new WorkingTimeUserCodeException();
		}
	}
}