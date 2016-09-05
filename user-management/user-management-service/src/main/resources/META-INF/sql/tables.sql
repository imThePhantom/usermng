create table CRM_Department (
	uuid_ VARCHAR(75) null,
	departmentCode VARCHAR(75) not null primary key,
	departmentName VARCHAR(75) null,
	leaderCode VARCHAR(75) null,
	description VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table CRM_UserInfo (
	uuid_ VARCHAR(75) null,
	userCode VARCHAR(75) not null primary key,
	userId LONG,
	username VARCHAR(75) null,
	male BOOLEAN,
	birthday DATE null,
	address VARCHAR(75) null,
	email VARCHAR(75) null,
	phone VARCHAR(75) null,
	departmentCode VARCHAR(75) null,
	role VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table CRM_WorkingTime (
	uuid_ VARCHAR(75) null,
	workingTimeId LONG not null primary key,
	date_ DATE null,
	userCode VARCHAR(75) null,
	startTime DATE null,
	endTime DATE null,
	groupId LONG,
	companyId LONG
);