![](https://img.shields.io/badge/language-java-blue)
![](https://img.shields.io/badge/technology-jsp,%20strut2,%20hibernate3,%20jQuery,%20bootstrap,%20highchartsjs,%20mysql8,%20maven,%20maven%20jetty-blue)
![](https://img.shields.io/badge/development%20year-2014-orange)

# Update Log

- 20220907
  - Refactored automation script to boot up the application environment

- 20200525
  - Renamed packages
  - Removed some useless comments
  - Fixed small xml validation in struts.xml
  - Removed interface and implementation packages
  - Updated context path
  - Updated report images into README

- 20200524
  - Fixed MySQL upper case in database name and table names
  - Fixed missing library of "hibernate-c3p0"
  - Fixed Hibernate xml metadata of dtd path
  - Provided Docker for mysql database environment
  - Provided more descriptive information in README.md
  - Upgraded MySQL from 5.7 to 8.0.20
  - Exported documents from .word to .pdf
  - Updated Struts2 filter in web.xml
  - Added GitHub CI workflow and badge
  - Fixed pom.xml encoding and dependencies names

# Background

This application builds in about 5 days with all the systems design, implementation, and documentation - a school work at 2014.

The application original name is "Travel Expense Reimbursement Application (TERA)"

The first version is with the JSP/Servlet/EJB/JPA, but later on, update the technologies to JSP/Strut2/Hibernate to decouple from JavaEE application server.

# Features

It provides below 4 major features,

- Typical security handling, e.g. sign in, sign out, remember me
- Administration - CURD for user management and department management
- Submit claim form, with 1 level or 2 level approval process by department manager and financial department
- Reporting, with 2 reports plus simple and complex report formats, as well as report downloading

# Tech Stack

- Web
  - jQuery v1.11.0 / jQuery UI / jquery.validate
  - bootstrap / bootstrap-datepicker
  - highcharts.js
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

# Design Patterns

- BaseAction - with all controller actions, e.g. CRUD + Struts Action names
  - return result is on "struts.xml"
  - jsp -> form -> report_Get_Edit -> struts.xml settings -> map to method doGetEdit (do{1}{2})
- BaseFacade - with all service actions + facade pattern with service locator
- BaseDao - with all dao actions
- BaseEntity - with common primary id
- Entity in "model" - business model maps to database table; maps to standard response to web page
- *Root in "web.action" - web model maps to request from web page + Struts result name
- *Dto - web model maps to customized response to web page

# Application Architecture

- Classes in "app" - application specific code to handle the business logic
- Classes in "infr" - application infrastructure code to support the entire application
- Report engine - The report engine would be a separated module as it cannot fully follow the same pattern of flow

# How to Configure Executable Environment

## Setup Database

Updated at 20200524, to use the Docker to setup the mysql - `database-setup.sh`

- Docker
  - database-setup.sh there is environment variable to setup the root user password, database name

The shell script also load the data installation at `data/init.sql`, which export at 2014

## Connect Database

There are 2 connections options in the application,

- Hibernate
  - hibernate.cfg.xml - with database connection string, user name, password, database name
  - *.hbm.xml - mappings for table name, database name (catalog)
- Report.java
  - JDBC + SQL - table names

## Run Application

- `mvn clean compile jetty:run` or `mvn jetty:run`
- `http://localhost:8088` - this port and context path are in pom.xml

## Sign In Username/Password

 | User Name             | Password | Is Normal User | Is System Administrator | Is Department Manager | Is Finacial Department User |
 | --------------------- | -------- | -------------- | ----------------------- | --------------------- | --------------------------- |
 | isadmin               | root     | Y              | Y                       | Y                     | N                           |
 | account-user1         | root     | Y              | N                       | N                     | Y                           |
 | account-user2-manager | root     | Y              | N                       | Y                     | Y                           |

## Approval Logic

```java
isApprover = user.equals(department.getManager());
isFinancial = "Y".equalsIgnoreCase(department.getOperationArea().getIsFinancial());
```

# Screenshots

## Dashboard

![](images/dashboard.png)

## Reports

![](images/report-0-list.png)

![](images/report-1-summary-report-simple.png)

![](images/report-1-summary-report-complex.png)

![](images/report-2-items-report-simple.png)

![](images/report-2-items-report-complex.png)

## Github CI build

![](images/github-ci-build.png)
