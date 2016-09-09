<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="javax.portlet.PortletURL"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
    String active = ParamUtil.getString(request, "tab");
    String selectedTab = "workingtimemng";
    if (active.equals("workingtime")) {
		selectedTab = "workingtimemng";
    }
    if (active.equals("user")) {
		selectedTab = "usermng";
    }
    if (active.equals("department")) {
		selectedTab = "departmentmng";
    }
%>

<liferay-ui:tabs
	names="UserManagement, DepartmentManagement, WorkingTimeManagement"
	refresh="false" tabsValues="usermng, departmentmng, workingtimemng"
	value="departmentmng">
	<liferay-ui:section>
		<%@ include file="/usermng/user_mng.jsp"%>
	</liferay-ui:section>
	<liferay-ui:section>
		<%@ include file="/departmentmng/department_mng.jsp"%>
	</liferay-ui:section>
	<liferay-ui:section>
		<%@ include file="/workingtimemng/working_time_mng.jsp"%>
	</liferay-ui:section>

</liferay-ui:tabs>