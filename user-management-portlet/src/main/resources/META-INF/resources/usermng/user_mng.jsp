<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.usermanagement.service.DepartmentLocalServiceUtil"%>
<%@page import="com.liferay.usermanagement.service.UserInfoLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<liferay-ui:header title="title-user-management"></liferay-ui:header>

<portlet:renderURL var="addUserURL">
	<portlet:param name="mvcPath" value="/usermng/edit_user.jsp" />
	<portlet:param name="editmode" value="add" />
</portlet:renderURL>

<aui:button-row cssClass="add-user-btn">
	<aui:button name="btn-add-user" onClick="<%= addUserURL.toString() %>"
		value="btn-add-user"></aui:button>
</aui:button-row>

<liferay-ui:search-container delta="10" emptyResultsMessage="no-user-found"
	total="<%= UserInfoLocalServiceUtil.getUserInfosCount() %>">
	<liferay-ui:search-container-results
		results="<%= UserInfoLocalServiceUtil.getUserInfos(scopeGroupId, 
			searchContainer.getStart(), searchContainer.getEnd()) %>"
			/>

	<liferay-ui:search-container-row
		className="com.liferay.usermanagement.model.UserInfo"
		modelVar="userInfo">
		
		<portlet:renderURL var="viewUserURL">
			<portlet:param name="mvcPath" value="/usermng/edit_user.jsp"/>
			<portlet:param name="userCode" value="<%= String.valueOf(userInfo.getUserCode()) %>"/>
			<portlet:param name="editmode" value="view"/>
		</portlet:renderURL>
		
		<liferay-ui:search-container-column-text property="userCode" name="User Code" 
			align="left"  href="<%= viewUserURL %>"/>
		<liferay-ui:search-container-column-text property="username" name="Name" 
			align="center" href="<%= viewUserURL %>" />
		<liferay-ui:search-container-column-text name="Department Code" align="center"
		property="departmentCode"/>
		<liferay-ui:search-container-column-text property="role" name="Role" align="Center"/>
		<liferay-ui:search-container-column-jsp align="right" path="/usermng/user_actions.jsp" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>