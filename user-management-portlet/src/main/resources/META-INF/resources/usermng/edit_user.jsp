<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.liferay.usermanagement.util.Role"%>
<%@page
	import="com.liferay.usermanagement.service.DepartmentLocalServiceUtil"%>
<%@page import="com.liferay.usermanagement.model.Department"%>
<%@page import="java.util.List"%>
<%@page
	import="com.liferay.usermanagement.service.UserInfoLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.usermanagement.model.UserInfo"%>
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
    String userAction = "addUser";
    String title = "Add User";
    boolean disabledField = false;
    boolean disabledAll = false;
    UserInfo userInfo = null;
    String userCode = ParamUtil.getString(request, "userCode");

    if (editMode.equalsIgnoreCase("update")) {
		userAction = "updateUser";
		title = "Update User";
		disabledField = true;
		userInfo = UserInfoLocalServiceUtil.getUserInfo(userCode);
    }
    if (editMode.equalsIgnoreCase("view")) {
		title = "User Profile";
		disabledField = true;
		disabledAll = true;
		userInfo = UserInfoLocalServiceUtil.getUserInfo(userCode);
		System.out.println("view " + userCode + " code");
    }

    List<Department> departments = DepartmentLocalServiceUtil.getDepartments();
    Role[] roles = Role.values();
%>

<portlet:renderURL var="usermngURL">
	<portlet:param name="mvcPath" value="/view.jsp" />
	<portlet:param name="tab" value="user" />
</portlet:renderURL>

<liferay-ui:header backURL="<%=usermngURL.toString()%>"
	title="<%=title%>" />

<portlet:actionURL name="<%=userAction%>" var="editUserURL">
	<%
	    if (editMode.equalsIgnoreCase("update")) {
	%>
	<portlet:param name="userCode" value="<%=userCode%>" />
	<%
	    System.out.println("update " + userCode + "code");
			}
	%>
</portlet:actionURL>

<aui:form action="<%=editUserURL%>" name="<portlet:namespace />user">
	<aui:model-context bean="<%=userInfo%>" model="<%=UserInfo.class%>" />

	<aui:fieldset>
		<aui:input labe="user-code" name="userCode"
			disabled="<%=disabledField%>">
			<aui:validator name="required" />
			<aui:validator name="alphanum" />
			<aui:validator name="maxLength">20</aui:validator>
		</aui:input>

		<aui:input label="username" name="username"
			disabled="<%=disabledAll%>">
			<aui:validator name="required" />
			<aui:validator name="maxLength">100</aui:validator>
		</aui:input>

		<aui:select label="gender" name="male" disabled="<%=disabledAll%>">
			<aui:option value="true" selected="true">Male</aui:option>
			<aui:option value="false">Female</aui:option>
		</aui:select>

		<label >Birthday</label>
		<liferay-ui:input-date formName="birthday" name="birthday"
			dayParam="bday" dayValue="20" monthParam="bmonth" monthValue="4"
			yearParam="byear" yearValue="1993" disabled="<%=disabledAll%>" />

		<aui:input label="address" name="address" disabled="<%=disabledAll%>">
			<aui:validator name="address" />
			<aui:validator name="maxLength">500</aui:validator>
		</aui:input>

		<aui:input label="email" name="email" disabled="<%=disabledAll%>">
			<aui:validator name="required" />
			<aui:validator name="email" />
		</aui:input>

		<aui:input label="phone" name="phone" disabled="<%=disabledAll%>">
			<aui:validator name="number" />
			<aui:validator name="minLength">10</aui:validator>
			<aui:validator name="maxLength">11</aui:validator>
		</aui:input>

		<aui:select label="department" name="departmentCode"
			disabled="<%=disabledAll%>">
			<aui:option value="<%=StringPool.BLANK%>"></aui:option>
			<%
			    if (departments != null) {
						    for (Department department : departments) {
			%>
			<aui:option value="<%=department.getDepartmentCode()%>">
				<%=department.getDepartmentName()%>
			</aui:option>
			<%
			    }
						}
			%>
		</aui:select>

		<aui:select label="role" name="role" disabled="<%=disabledAll%>">
			<aui:option value="<%=StringPool.BLANK%>"></aui:option>
			<%
			    for (Role role : roles) {
			%>
			<aui:option value="<%=role.toString()%>">
				<%=role.toString()%>
			</aui:option>
			<%
			    }
			%>
		</aui:select>
	</aui:fieldset>

	<aui:button-row>
		<%
		    if (editMode.equals("view")) {
		%>
		<portlet:renderURL var="editUserURL">
			<portlet:param name="mvcPath" value="/usermng/edit_user.jsp" />
			<portlet:param name="userCode" value="<%=userCode%>" />
			<portlet:param name="editmode" value="update" />
		</portlet:renderURL>

		<aui:button value="Update" href="<%=editUserURL%>" />
		<aui:button type="cancel" href="<%=usermngURL.toString()%>"></aui:button>
		<%
		    } else {
		%>
		<aui:button type="submit" />
		<aui:button type="cancel" href="<%=usermngURL.toString()%>"></aui:button>
		<%
		    }
		%>
	</aui:button-row>
</aui:form>



