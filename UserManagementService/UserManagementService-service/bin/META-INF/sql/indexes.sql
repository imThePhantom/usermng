create index IX_A817B931 on CRM_Department (groupId);
create index IX_73EF654D on CRM_Department (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_F0BADB0F on CRM_Department (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_98B53ECA on CRM_UserInfo (groupId);
create index IX_81FE8C16 on CRM_UserInfo (userCode[$COLUMN_LENGTH:75$], username[$COLUMN_LENGTH:75$], email[$COLUMN_LENGTH:75$]);
create index IX_B9C1BD4 on CRM_UserInfo (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_97618756 on CRM_UserInfo (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_85E6124A on CRM_WorkingTime (date_, userCode[$COLUMN_LENGTH:75$]);
create index IX_BDA9968F on CRM_WorkingTime (userCode[$COLUMN_LENGTH:75$]);
create index IX_F13E6751 on CRM_WorkingTime (uuid_[$COLUMN_LENGTH:75$]);