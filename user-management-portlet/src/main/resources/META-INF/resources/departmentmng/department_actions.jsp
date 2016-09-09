<%@page import="com.liferay.usermanagement.model.Department"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
    String mvcPath = ParamUtil.getString(request, "mvcPath");

    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

    Department department = (Department) row.getObject();
%>

<portlet:renderURL var="editDepartmentURL">
	<portlet:param name="mvcPath"
		value="/departmentmng/edit_department.jsp" />
	<portlet:param name="departmentCode"
		value="<%=String.valueOf(department.getDepartmentCode())%>" />
	<portlet:param name="editmode" value="update" />
</portlet:renderURL>

<portlet:actionURL name="deleteDepartment" var="deleteDepartmentURL">
	<portlet:param name="departmentCode"
		value="<%=String.valueOf(department.getDepartmentCode())%>" />
</portlet:actionURL>

<liferay-ui:icon-menu>
	<liferay-ui:icon image="edit" message="edit"
		url="<%=editDepartmentURL.toString()%>" />
	<liferay-ui:icon-delete label="true" message="Delete"
		url="<%=deleteDepartmentURL%>" 
		confirmation="confirm-delete-department" />
</liferay-ui:icon-menu>