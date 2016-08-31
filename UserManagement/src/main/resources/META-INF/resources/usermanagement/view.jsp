<%@ include file="/init.jsp"%>

<portlet:renderURL var="workingTimeURL">
	<portlet:param name="mvcPath"
		value="/usermanagement/working_time_management.jsp"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="userMngURL">
	<portlet:param name="mvcPath"
		value="/usermanagement/user_management.jsp"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="departmentMngURL">
	<portlet:param name="mvcPath"
		value="/usermanagement/department_management.jsp"></portlet:param>
</portlet:renderURL>

<aui:nav cssClass="nav-tabs">
	<aui:nav-item href="<%=workingTimeURL.toString()%>"
		label="Working Time" />
	<aui:nav-item href="<%=userMngURL.toString()%>"
		label="User Management" />
	<aui:nav-item href="<%=departmentMngURL.toString()%>"
		label="Department Management" />
</aui:nav>
