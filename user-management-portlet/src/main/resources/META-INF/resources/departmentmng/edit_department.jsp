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

<portlet:renderURL var="departmentmngURL">
	<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
	<portlet:param name="tab" value="department"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="addDepartment" var="addDepartmentURL"></portlet:actionURL>


<liferay-ui:header backURL="<%=departmentmngURL.toString()%>" title="Add Department" />

<aui:form action="<%=addDepartmentURL%>" name="<portlet:namespace />fm">
	<aui:fieldset>
		<aui:input inlineLabel="true" label="Department Code"
			name="departmentCode">
			<aui:validator name="required" />
			<aui:validator name="alphanum" />
			<aui:validator name="maxLength">20</aui:validator>
		</aui:input>
		<aui:input inlineLabel="true" label="Department Name"
			name="departmentName">
			<aui:validator name="required" />
			<aui:validator name="maxLength">50</aui:validator>
		</aui:input>
		<aui:input inlineLabel="true" label="Leader Code" name="leaderCode" >
			<aui:validator name="required" />
			<aui:validator name="alphanum" />
			<aui:validator name="maxLength">20</aui:validator>
		</aui:input>
		<aui:input inlineLabel="true" label="Description" name="description">
			<aui:validator name="maxLength">500</aui:validator>
		</aui:input>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= departmentmngURL.toString() %>"></aui:button>
	</aui:button-row>
</aui:form>