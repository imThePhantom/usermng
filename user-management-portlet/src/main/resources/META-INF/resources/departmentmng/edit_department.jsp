<%@page
	import="com.liferay.usermanagement.service.DepartmentLocalServiceUtil"%>
<%@page import="com.liferay.usermanagement.model.Department"%>
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
    String editMode = ParamUtil.getString(request, "editmode");
    String departmentAction = "addDepartment";
    String title = "title-add-department";
    boolean disabledField = false;
    Department department = null;
    String departmentCode = ParamUtil.getString(request, "departmentCode");
    
    if (editMode.equalsIgnoreCase("update")) {
		departmentAction = "updateDepartment";
		title = "title-update-department";
		disabledField = true;
		department = DepartmentLocalServiceUtil.getDepartment(departmentCode);
    }

%>

<portlet:renderURL var="departmentmngURL">
	<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
	<portlet:param name="tab" value="department"></portlet:param>
</portlet:renderURL>

<liferay-ui:header backURL="<%=departmentmngURL.toString()%>"
	title="<%=title%>" />

<portlet:actionURL name="<%=departmentAction%>"	var="editDepartmentURL">
<%
	if (editMode.equals("update")){
%>
	<portlet:param name="departmentCode" value="<%= departmentCode %>"/>
<%
	}
%>
</portlet:actionURL>

<aui:form action="<%=editDepartmentURL%>" name="<portlet:namespace />dept">
	<aui:model-context bean="<%=department%>" model="<%=Department.class%>" />
	<aui:fieldset>
		<aui:input label="department-code" name="departmentCode"
			disabled="<%=disabledField%>">
			<aui:validator name="required" />
			<aui:validator name="alphanum" />
			<aui:validator name="maxLength">20</aui:validator>
		</aui:input>
		<aui:input label="department-name" name="departmentName">
			<aui:validator name="required" />
			<aui:validator name="maxLength">100</aui:validator>
		</aui:input>
		<aui:input label="leader-code" name="leaderCode">
			<aui:validator name="required" />
			<aui:validator name="alphanum" />
			<aui:validator name="maxLength">20</aui:validator>
		</aui:input>
		<aui:input label="description" name="description">
			<aui:validator name="maxLength">500</aui:validator>
		</aui:input>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= departmentmngURL.toString() %>"></aui:button>
	</aui:button-row>
</aui:form>