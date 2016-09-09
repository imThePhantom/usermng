<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.usermanagement.model.UserInfo"%>
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

	UserInfo userInfo = (UserInfo) row.getObject();
%>

<portlet:renderURL var="viewUserURL">
	<portlet:param name="mvcPath" value="/usermng/edit_user.jsp"/>
	<portlet:param name="userCode" value="<%= String.valueOf(userInfo.getUserCode()) %>"/>
	<portlet:param name="editmode" value="view"/>
</portlet:renderURL>

<portlet:renderURL var="editUserURL">
	<portlet:param name="mvcPath" value="/usermng/edit_user.jsp"/>
	<portlet:param name="userCode" value="<%= String.valueOf(userInfo.getUserCode()) %>"/>
	<portlet:param name="editmode" value="update"/>
</portlet:renderURL>

<portlet:actionURL name="deleteUser" var="deleteUserURL">
	<portlet:param name="userCode" value="<%= String.valueOf(userInfo.getUserCode()) %>"/>
</portlet:actionURL>

<liferay-ui:icon-menu>
	<liferay-ui:icon image="info" message="Info"
		url="<%=viewUserURL%>"></liferay-ui:icon>
	<liferay-ui:icon image="edit" message="edit"
		url="<%= editUserURL.toString() %>" />
	<liferay-ui:icon-delete message="Delete" confirmation="confirm-delete-user"
	url="<%= deleteUserURL.toString() %>" />
</liferay-ui:icon-menu>