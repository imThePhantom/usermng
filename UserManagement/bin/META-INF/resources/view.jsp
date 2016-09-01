<%@ include file="/init.jsp"%>

<liferay-ui:tabs names="Working Time Management, User
	Management, Department Management" refresh="false" tabsValues="
	Working Time Management, User Management, DepartmentManagement">
	<liferay-ui:section>
		<%@ include file="/workingtimemng/working_time_mng.jsp" %>
	</liferay-ui:section>
	<liferay-ui:section>
		<%@ include file="/usermng/user_mng.jsp" %>
	</liferay-ui:section>
	<liferay-ui:section>
		<%@ include file="/departmentmng/department_mng.jsp" %>
	</liferay-ui:section>
</liferay-ui:tabs>