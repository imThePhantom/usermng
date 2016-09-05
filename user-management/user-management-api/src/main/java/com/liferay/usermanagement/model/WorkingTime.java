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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the WorkingTime service. Represents a row in the &quot;CRM_WorkingTime&quot; database table, with each column mapped to a property of this class.
 *
 * @author phantoan
 * @see WorkingTimeModel
 * @see com.liferay.usermanagement.model.impl.WorkingTimeImpl
 * @see com.liferay.usermanagement.model.impl.WorkingTimeModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.usermanagement.model.impl.WorkingTimeImpl")
@ProviderType
public interface WorkingTime extends WorkingTimeModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.usermanagement.model.impl.WorkingTimeImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<WorkingTime, Long> WORKING_TIME_ID_ACCESSOR = new Accessor<WorkingTime, Long>() {
			@Override
			public Long get(WorkingTime workingTime) {
				return workingTime.getWorkingTimeId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<WorkingTime> getTypeClass() {
				return WorkingTime.class;
			}
		};
}