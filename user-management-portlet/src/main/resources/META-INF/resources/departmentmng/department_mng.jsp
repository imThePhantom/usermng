<%@page
	import="com.liferay.usermanagement.service.DepartmentLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>


<liferay-theme:defineObjects />

<portlet:defineObjects />

<liferay-ui:header title="title-department-management"></liferay-ui:header>

<portlet:renderURL var="addDepartmentURL">
	<portlet:param name="mvcPath"
		value="/departmentmng/edit_department.jsp"></portlet:param>
	<portlet:param name="editmode" value="add"/>
</portlet:renderURL>

<aui:button-row cssClass="add-department-btn">
	<aui:button name="btn-add-department"
		onClick="<%= addDepartmentURL.toString() %>" value="btn-add-department"></aui:button>
</aui:button-row>

<liferay-ui:search-container delta="10" emptyResultsMessage="no-department-found"
	total="<%=DepartmentLocalServiceUtil.getDepartmentsCount()%>">
	<liferay-ui:search-container-results
		results="<%=DepartmentLocalServiceUtil.getDepartments(searchContainer.getStart(),
			searchContainer.getEnd())%>" />
	<liferay-ui:search-container-row
		className="com.liferay.usermanagement.model.Department"
		modelVar="department">
		
		<liferay-ui:search-container-column-text align="left"
			name="Department Code" property="departmentCode" />
		<liferay-ui:search-container-column-text align="center"
			name="Department Name" property="departmentName" />
		<liferay-ui:search-container-column-text align="center"
			name="LeaderCode" property="leaderCode" />
		<liferay-ui:search-container-column-text align="left"
			name="Description" property="description" />
		<liferay-ui:search-container-column-jsp align="right"
			path="/departmentmng/department_actions.jsp" />
	
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

