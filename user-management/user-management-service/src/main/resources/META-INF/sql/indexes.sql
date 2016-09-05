create index IX_9191F7AC on CRM_Department (departmentCode[$COLUMN_LENGTH:75$]);
create index IX_A39614CA on CRM_Department (departmentName[$COLUMN_LENGTH:75$]);
create index IX_A817B931 on CRM_Department (groupId);
create index IX_73EF654D on CRM_Department (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_F0BADB0F on CRM_Department (uuid_[$COLUMN_LENGTH:75$], groupId);

create unique index IX_64473D6C on CRM_UserInfo (email[$COLUMN_LENGTH:75$]);
create index IX_98B53ECA on CRM_UserInfo (groupId);
create index IX_B9C1BD4 on CRM_UserInfo (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_97618756 on CRM_UserInfo (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_4C6F027E on CRM_WorkingTime (date_);
create unique index IX_575E7F72 on CRM_WorkingTime (userCode[$COLUMN_LENGTH:75$], date_);
create index IX_423A9037 on CRM_WorkingTime (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_EC7B879 on CRM_WorkingTime (uuid_[$COLUMN_LENGTH:75$], groupId);