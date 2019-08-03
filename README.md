
Lots of things need to fix here.
The tech stack does not make sense but just from the requirement of the school course.

#-------------------------------------------------------------------------------
# Copyright (c) 2014, Shijian Su. All rights reserved.
# 
# This software is the confidential and proprietary information of Shijian Su. ("Confidential Information").  You shall not
# disclose such Confidential Information and shall use it only in
# accordance with the terms of the license agreement you entered into
# with him.
#-------------------------------------------------------------------------------
Application Name: Travel Expense Reimbursement Application (TERA)
Technical Stack:
## Web
CSS & JavaScript: 
jQuery v1.11.0
bootstrap
bootstrap-datepicker
## Application
Strut2 + Hiberate3

# Database
ntu-msis-ead-tera-v2

# preparation
execute mysql ddl - /data/init.sql

# execution
mvn clean compile jetty:run

# verification
1. url
http://localhost:8088/ntu-msis-ead-tera-v2/

2. username / password: 
|------------------------------------------------------------------------------------------------------------------------------------|
|User Name             |Password |Is Normal User |Is System Administrator |Is Department Manager |Is Finacial Department User        |
|------------------------------------------------------------------------------------------------------------------------------------|
|isadmin               |root     |Y              |Y                       |Y                     |N                                  |
|account-user1         |root     |Y              |N                       |N                     |Y                                  |
|account-user2-manager |root     |Y              |N                       |Y                     |Y                                  |
|------------------------------------------------------------------------------------------------------------------------------------|
