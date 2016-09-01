<%@ include file="/init.jsp"%>

<b> Add New Department</b>
<portlet:renderURL var="departmentmngURL">
	<portlet:param name="mvcPath" value="/departmentmng/department_mng.jsp"></portlet:param>
</portlet:renderURL>
<portlet:actionURL name="addDepartment" var="addDepartmentURL"></portlet:actionURL>

<liferay-ui:error key="department-exist" message="This Department Code or Department Name already exist." />
<liferay-ui:error key="user-not-exist" message="This User not exist." />
<liferay-ui:error key="user-already-be-leader" message="This user is leader of another department" />
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
		<aui:button type="cancel" onClick="<%= departmentmngURL %>"></aui:button>
	</aui:button-row>
</aui:form>


