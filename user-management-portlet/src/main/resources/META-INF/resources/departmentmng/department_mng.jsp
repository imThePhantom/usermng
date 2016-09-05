<%@page
	import="com.liferay.usermanagement.service.DepartmentLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<portlet:renderURL var="addDepartmentURL">
	<portlet:param name="mvcPath"
		value="/departmentmng/edit_department.jsp"></portlet:param>
</portlet:renderURL>

<b>Department Management</b>

<aui:button-row cssClass="add-department-btn">
	<aui:button name="Add Department"
		onClick="<%= addDepartmentURL.toString() %>" value="Add Department"></aui:button>
</aui:button-row>

<liferay-ui:search-container>
	<liferay-ui:search-container-results
		results="<%=DepartmentLocalServiceUtil.getDepartments(searchContainer.getStart(),
						searchContainer.getEnd())%>"
		total="<%=DepartmentLocalServiceUtil.getDepartmentsCount()%>" />

	<liferay-ui:search-container-row
		className="com.liferay.usermanagement.model.Department"
		modelVar="aDepartment">
		
		<liferay-ui:search-container-column-text property="departmentCode" />
		<liferay-ui:search-container-column-text property="departmentName" />
		<liferay-ui:search-container-column-text property="leaderCode" />
		<liferay-ui:search-container-column-text property="description" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>