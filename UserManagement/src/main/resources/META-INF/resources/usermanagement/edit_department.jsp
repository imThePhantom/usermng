<%@ include file="/init.jsp"%>

<b> Add New Department</b>
<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/usermanagement/department_mng.jsp"></portlet:param>
</portlet:renderURL>
<portlet:actionURL name="addDepartment" var="addDepartmentURL"></portlet:actionURL>

<aui:form action="<%= addDepartmentURL %>" name="<portlet:namespace />fm">
	<aui:fieldset>
		<aui:input inlineLabel="true" label="Department Code" name="departmentCode">
			<aui:validator name="required" />
			<aui:validator name="alphanum" />
		</aui:input>
		<aui:input inlineLabel="true" label="Department Name" name="departmentName">
			<aui:validator name="required" />
		</aui:input>
		<aui:input inlineLabel="true" label="Leader Code" name="leaderCode">
			<aui:validator name="required" />
			<aui:validator name="alphanum" />
		</aui:input>
		<aui:input inlineLabel="true" label="Description" name="description">
		</aui:input>
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL %>" ></aui:button>
	</aui:button-row>
</aui:form>