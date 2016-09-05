<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="javax.portlet.PortletURL"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	String active = ParamUtil.getString(request, "tab");
	String selectedTab = "Working Time Management";	
	switch (active) {
	case "workingtime": selectedTab = "workingtimemng";
	case "user": selectedTab = "usermng";
	case "department": selectedTab = "departmentmng";
	}
%>

<liferay-ui:tabs 
	names="Working Time Management, User Management, Department Management"
	refresh="false"	tabsValues="workingtimemng, usermng, departmentmng"
	value="<%= selectedTab %>">
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