package com.liferay.usermanagement.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.usermanagement.model.Department;
import com.liferay.usermanagement.model.UserInfo;
import com.liferay.usermanagement.service.DepartmentLocalServiceUtil;
import com.liferay.usermanagement.service.UserInfoLocalServiceUtil;
import com.liferay.usermanagement.util.Role;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
	"com.liferay.portlet.instanceable=true",
	"javax.portlet.display-name=User Management Portlet",
	"javax.portlet.init-param.template-path=/",
	"javax.portlet.init-param.view-template=/view.jsp",
	"javax.portlet.resource-bundle=content.Language",
	"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class UserManagementPortlet extends MVCPortlet {

    public void addDepartment(ActionRequest actionRequest, ActionResponse actionResponse)
	    throws PortalException, SystemException {

	ServiceContext serviceContext = ServiceContextFactory
		.getInstance(Department.class.getName(), actionRequest);
	String departmentCode = ParamUtil.getString(actionRequest, "departmentCode");
	String departmentName = ParamUtil.getString(actionRequest, "departmentName");
	String leaderCode = ParamUtil.getString(actionRequest, "leaderCode");
	String description = ParamUtil.getString(actionRequest, "description");

	departmentCode = departmentCode.toLowerCase().replaceAll("\\s+", "");
	leaderCode = leaderCode.toLowerCase().replaceAll("\\s+", "");

	if (DepartmentLocalServiceUtil.fetchDepartmentByName(departmentName) != null) {
	    throw new PortalException("existing-code");
	}
	if (DepartmentLocalServiceUtil.fetchDepartmetnByCode(departmentCode) != null) {
	    throw new PortalException("existing-name");
	}
	if (UserInfoLocalServiceUtil.fetchUserInfoByCode(leaderCode) == null) {
	    throw new PortalException("user-not-exist");
	}

	UserInfo newLeader = UserInfoLocalServiceUtil.getUserInfo(leaderCode);

	if (newLeader.getRole().equalsIgnoreCase(Role.LEADER.toString())) {
	    throw new PortalException("can't-asign-leader");
	}

	try {
	    DepartmentLocalServiceUtil.addDepartment(departmentCode, departmentName, leaderCode,
		    description, serviceContext);
	    SessionMessages.add(actionRequest, "department-added");
	    newLeader.setRole(Role.LEADER.toString());
	    newLeader.setDepartmentCode(departmentCode);
	    try {
		UserInfoLocalServiceUtil.updateUserInfo(newLeader);
	    } catch (Exception e) {
		SessionErrors.add(actionRequest, e.getClass(), e);
	    }
	    actionResponse.setRenderParameter("tab", "department");
	} catch (Exception e) {
	    SessionErrors.add(actionRequest, e.getClass(), e);
	    actionResponse.setRenderParameter("mvcPath", "/departmentmng/edit_department.jsp");
	}
    }

    public void deleteDepartment(ActionRequest actionRequest, ActionResponse actionResponse)
	    throws PortalException, SystemException {

	String departmentCode = ParamUtil.getString(actionRequest, "departmentCode");
	if (departmentCode == null) {
	    throw new PortalException("missing-code");
	}
	if (DepartmentLocalServiceUtil.fetchDepartmetnByCode(departmentCode) == null) {
	    throw new PortalException("department-not-exist");
	}
	if (UserInfoLocalServiceUtil.getUserInfosByDepartmentCodeCount(departmentCode) > 0) {
	    throw new PortalException("van-com-nhan-vien");
	}

	try {
	    DepartmentLocalServiceUtil.deleteDepartment(departmentCode);
	    SessionMessages.add(actionRequest, "department-deleted");
	    actionResponse.setRenderParameter("tab", "user");
	} catch (Exception e) {
	    SessionErrors.add(actionRequest, e.getClass().getName());
	}
    }

    public void updateDepartment(ActionRequest actionRequest, ActionResponse actionResponse)
	    throws PortalException, SystemException {

	ServiceContext serviceContext = ServiceContextFactory
		.getInstance(Department.class.getName(), actionRequest);
	String departmentCode = ParamUtil.getString(actionRequest, "departmentCode");
	String departmentName = ParamUtil.getString(actionRequest, "departmentName");
	String leaderCode = ParamUtil.getString(actionRequest, "lederCode");
	String description = ParamUtil.getString(actionRequest, "description");

	departmentCode = departmentCode.toLowerCase().replaceAll("\\s+", "");
	leaderCode = leaderCode.toLowerCase().replaceAll("\\s+", "");

	if (DepartmentLocalServiceUtil.fetchDepartmetnByCode(departmentCode) == null) {
	    throw new PortalException("missing-code");
	}

	if (DepartmentLocalServiceUtil.fetchDepartmentByName(departmentName) != null) {
	    throw new PortalException("existing-name");
	}
	if (UserInfoLocalServiceUtil.fetchUserInfoByCode(leaderCode) == null) {
	    throw new PortalException("user-not-exist");
	}

	UserInfo newLeader = UserInfoLocalServiceUtil.getUserInfo(leaderCode);

	if (newLeader.getRole().equalsIgnoreCase(Role.LEADER.toString())) {
	    throw new PortalException("can't-asign-leader");
	}

	try {
	    DepartmentLocalServiceUtil.updateDepartment(departmentCode, departmentName, leaderCode,
		    description, serviceContext);
	    SessionMessages.add(actionRequest, "department-updated");

	    newLeader.setRole(Role.LEADER.toString());
	    try {
		UserInfoLocalServiceUtil.updateUserInfo(newLeader);
	    } catch (Exception e) {
		SessionErrors.add(actionRequest, e.getClass(), e);
	    }

	    actionResponse.setRenderParameter("tab", "department");
	} catch (Exception e) {
	    SessionErrors.add(actionRequest, e.getClass(), e);
	    actionResponse.setRenderParameter("mvcPath", "/departmentmng/edit_department.jsp");
	}
    }

    public void addUser(ActionRequest actionRequest, ActionResponse actionResponse)
	    throws PortalException, SystemException, ParseException {

	ServiceContext serviceContext = ServiceContextFactory.getInstance(UserInfo.class.getName(),
		actionRequest);
	String userCode = ParamUtil.getString(actionRequest, "userCode");
	String username = ParamUtil.getString(actionRequest, "username");
	boolean male = ParamUtil.getBoolean(actionRequest, "male");

	int bday = ParamUtil.getInteger(actionRequest, "bday");
	int bmonth = ParamUtil.getInteger(actionRequest, "bmonth") + 1;
	int byear = ParamUtil.getInteger(actionRequest, "byear");

	String date = bday + "/" + bmonth + "/" + byear + " 00:00:00";
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date birthday = dateFormat.parse(date);

	String address = ParamUtil.getString(actionRequest, "address");
	String email = ParamUtil.getString(actionRequest, "email");
	String phone = ParamUtil.getString(actionRequest, "phone");
	String departmentCode = ParamUtil.getString(actionRequest, "departmentCode");
	String role = ParamUtil.getString(actionRequest, "role");

	userCode = userCode.toLowerCase().replaceAll("\\s+", "");
	departmentCode = departmentCode.toLowerCase().replaceAll("\\s+", "");

	if (UserInfoLocalServiceUtil.fetchUserInfo(userCode) != null) {
	    throw new PortalException("existing-code");
	}
	if (UserInfoLocalServiceUtil.fetchUserInfoByEmail(email) != null) {
	    throw new PortalException("existing-email");
	}
	if (!departmentCode.equals(StringPool.BLANK)) {
	    if (DepartmentLocalServiceUtil.fetchDepartmetnByCode(departmentCode) == null) {
		throw new PortalException("department-not-exist");
	    }
	}
	if (role.equalsIgnoreCase(Role.LEADER.toString())) {
	    throw new PortalException("can't-asign-leader");
	}

	try {
	    System.out.println("start creat user info");
	    UserInfoLocalServiceUtil.addUserInfo(userCode, username, male, birthday, address, email,
		    phone, departmentCode, role, serviceContext);
	    System.out.println("add success");
	    SessionMessages.add(actionRequest, "user-added");
	    actionResponse.setRenderParameter("mvcPath", "/view.jsp");
	    actionResponse.setRenderParameter("tab", "user");
	} catch (Exception e) {
	    SessionErrors.add(actionRequest, e.getClass(), e);
	    actionResponse.setRenderParameter("mvcPath", "/usermng/edit_user.jsp");
	}
    }

    public void updateUser(ActionRequest actionRequest, ActionResponse actionResponse)
	    throws PortalException, SystemException, ParseException {
	
	ServiceContext serviceContext = ServiceContextFactory.getInstance(UserInfo.class.getName(),
		actionRequest);
	System.out.println("pass 1");
	String userCode = ParamUtil.getString(actionRequest, "userCode");
	System.out.println("abc" + userCode + "cde");

	String username = ParamUtil.getString(actionRequest, "username");
	boolean male = ParamUtil.getBoolean(actionRequest, "male");

	int bday = ParamUtil.getInteger(actionRequest, "bday");
	int bmonth = ParamUtil.getInteger(actionRequest, "bmonth") + 1;
	int byear = ParamUtil.getInteger(actionRequest, "byear");
	String date = bday + "/" + bmonth + "/" + byear + " 00:00:00";
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date birthday = dateFormat.parse(date);

	String address = ParamUtil.getString(actionRequest, "address");
	String email = ParamUtil.getString(actionRequest, "email");
	String phone = ParamUtil.getString(actionRequest, "phone");
	String departmentCode = ParamUtil.getString(actionRequest, "departmentCode");
	String role = ParamUtil.getString(actionRequest, "role");
	
	UserInfo userInfo = UserInfoLocalServiceUtil.getUserInfo(userCode);
	if (!userInfo.getDepartmentCode().equals(departmentCode)) {
	    departmentCode = departmentCode.toLowerCase().replaceAll("\\s+", "");
	}
	if (!userInfo.getEmail().equals(email)) {
	    if (UserInfoLocalServiceUtil.fetchUserInfoByEmail(email) != null) {
		throw new PortalException("existing-email");
	    }
	}
	if (!role.equals(Role.LEADER.toString())) {
	    if (userInfo.getRole().equals(Role.LEADER.toString())) {
		throw new PortalException();
	    }
	}
	if (departmentCode != StringPool.BLANK
		&& DepartmentLocalServiceUtil.fetchDepartmetnByCode(departmentCode) == null) {
	    throw new PortalException("department-not-exist");
	}

	try {
	    UserInfoLocalServiceUtil.updateUserInfo(userCode, username, male, birthday, address,
		    email, phone, departmentCode, role, serviceContext);
	    SessionMessages.add(actionRequest, "user-updated");
	    actionResponse.setRenderParameter("tab", "user");
	} catch (Exception e) {
	    SessionErrors.add(actionRequest, e.getClass(), e);
	    actionResponse.setRenderParameter("mvcPath", "/usermng/edit_user.jsp");
	}
    }

    public void deleteUser(ActionRequest actionRequest, ActionResponse actionResponse)
	    throws PortalException, SystemException {

	String userCode = ParamUtil.getString(actionRequest, "userCode");
	if (UserInfoLocalServiceUtil.fetchUserInfoByCode(userCode) == null) {
	    throw new PortalException("user-not-exist");
	}

	try {
	    UserInfoLocalServiceUtil.deleteUserInfo(userCode);
	    SessionMessages.add(actionRequest, "user-deleted");
	    actionResponse.setRenderParameter("tab", "user");
	} catch (Exception e) {
	    SessionErrors.add(actionRequest, e.getClass().getName());
	}
    }

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse)
	    throws PortletException, IOException {
	super.render(renderRequest, renderResponse);
    }
}