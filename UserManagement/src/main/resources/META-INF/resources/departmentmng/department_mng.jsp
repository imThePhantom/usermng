<%@ include file="/init.jsp"%>

<portlet:renderURL var="addDepartmentURL">
	<portlet:param name="mvcPath"
		value="/departmentmng/edit_department.jsp"></portlet:param>
</portlet:renderURL>

<b>Department Management</b>

<aui:button-row cssClass="add-department-btn">
	<aui:button name="Add Department" onClick="<%= addDepartmentURL.toString() %>"
		value="Add Department"></aui:button>
</aui:button-row>