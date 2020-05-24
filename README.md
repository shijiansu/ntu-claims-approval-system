
![](https://img.shields.io/badge/language-java-blue)
![](https://img.shields.io/badge/technology-jsp,%20strut2,%20hibernate3,%20bootstrap,%20bootstrap%20datepicker,%20jQuery,%20maven,%20maven%20jetty-blue)
![](https://img.shields.io/badge/development%20year-2014-orange)
![](https://img.shields.io/badge/contributor-shijian%20su-purple)
![](https://img.shields.io/badge/license-MIT-lightgrey)

![](https://img.shields.io/github/languages/top/shijiansu/ntu-claims-approval-system)
![](https://img.shields.io/github/languages/count/shijiansu/ntu-claims-approval-system)
![](https://img.shields.io/github/languages/code-size/shijiansu/ntu-claims-approval-system)
![](https://img.shields.io/github/repo-size/shijiansu/ntu-claims-approval-system)
![](https://img.shields.io/github/last-commit/shijiansu/ntu-claims-approval-system?color=red)

--------------------------------------------------------------------------------

# Background

This application is built in about 5 days with all the systems design, implementation, and documentation - a school work at 2014.

The application origianl name is "Travel Expense Reimbursement Application (TERA)"

The first version is with the JSP/Servlet/EJB/JPA, but later on, update the technologies to JSP/Strut2/Hibernate to decouple from JavaEE application server.

# Features

It provides below 4 majar features,

- typical security handling, e.g. sign in, sign out, remember me
- administration - CURD for user management and department management
- submit claim form, with 1 level or 2 level approval process by department manager and finacial department
- reporting, with 2 reports plus simple and complex report formats, as well as report downloading

# Tech Stack

- Web
  - jQuery v1.11.0
  - bootstrap
  - bootstrap-datepicker
  - display tag
  - JSP/JSTL
  - Strut2 tag
- Application
  - Strut2
  - Hiberate3
- Build
  - Maven
- Database
  - MySQL 8.0.20 (updated from mysql5 at 20200524)

# How to configure executable environment

## Setup database

Updated at 20200524, to use the Docker to setup the mysql - `setup-database.sh`

- Docker
  - setup-database.sh there is environment variable to setup the root user password, database name

The shell script also load the data installation at `data/init.sql`, which export at 2014

## Connect database

There are 2 connections options in the application,

- Hibernate
  - hibernate.cfg.xml - with database connection string, user name, password, database name
  - *.hbm.xml - mappings for table name, database name (catalog)
- Report.java
  - JDBC + SQL - table names

## Run application

- `mvn clean compile jetty:run`
- `mvn jetty:run`
- `http://localhost:8088/ntu-claims-approval-system/` - this port and context path are in pom.xml

## Sign in username / password

|------------------------------------------------------------------------------------------------------------------------------------|
|User Name             |Password |Is Normal User |Is System Administrator |Is Department Manager |Is Finacial Department User        |
|------------------------------------------------------------------------------------------------------------------------------------|
|isadmin               |root     |Y              |Y                       |Y                     |N                                  |
|account-user1         |root     |Y              |N                       |N                     |Y                                  |
|account-user2-manager |root     |Y              |N                       |Y                     |Y                                  |
|------------------------------------------------------------------------------------------------------------------------------------|

## Approval logic

```java
isApprover = user.equals(department.getManager());
isFinancial = "Y".equalsIgnoreCase(department.getOperationArea().getIsFinancial());
```

# Update log

- 20200524
  - Fixed MySQL upper case in database name and table names
  - Fixed missing library of "hibernate-c3p0"
  - Fixed Hibernate xml metadata of dtd path
  - Provided Docker for mysql database environment
  - Provided more descriptive information in README.md
  - Upgraded MySQL from 5.7 to 8.0.20
  - Exported documents from word to PDF
  - Updated Struts2 filter in web.xml 

# Remaining issues

- In User and Department form, there is no interative response when click Submit button
