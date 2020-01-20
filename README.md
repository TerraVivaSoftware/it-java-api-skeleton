# it-java-api-skeleton

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/d74b7535bb984aa8a82c9aa4aab167f7)](https://app.codacy.com/app/marcosvidolin/it-java-api-skeleton?utm_source=github.com&utm_medium=referral&utm_content=ciandt-dev/it-java-api-skeleton&utm_campaign=Badge_Grade_Dashboard)
[![Build Status](https://travis-ci.org/ciandt-dev/it-java-api-skeleton.svg?branch=master)](https://travis-ci.org/ciandt-dev/it-java-api-skeleton)

CI&amp;T IT's default Java project skeleton for Microservices and APIs (with basic example)

### Prerequisites

- Java >= 1.8
- Gradle >= 2
- [Lombok](https://projectlombok.org/download.html)

### Stack

- Spring Boot
- Spring MVC
- Spring Data
- Docker
- [Ditiow](https://github.com/marcosvidolin/ditiow)

### Packages

**com.ciandt.skeleton.core**

**com.ciandt.skeleton.core.domain**

**com.ciandt.skeleton.business**

**com.ciandt.skeleton.core.exception**

**com.ciandt.skeleton.core.enumeration**


**com.ciandt.skeleton.service**

**com.ciandt.skeleton.data.repository**

**com.ciandt.skeleton.util**


**com.ciandt.skeleton.web.rest.v1**

**com.ciandt.skeleton.web.rest.v1.resource**

**com.ciandt.skeleton.web.rest.v1.controller**



### Profiles

To run the application in a specific profile you must set the argument in VM options:
```shell
-Dspring.profiles.active=dev
```

### Run

```
./gradlew bootRun
```

### Docker
```shell
docker build --build-arg profile=<PROFILE> .
```
```shell
docker build --build-arg profile=local .
```
Arguments:
* profile (Default = notset)


### Dependency Check
Run the following comand and check the report: "build/reports/dependency-check-report.html"

```shell~~~~
./gradlew dependencyCheckAnalyze --info
```

### Relational Database Pattern

You can find [here](DATABASE_PATTERN.md) all the object name pattern to create tables, columns, triggers, functions and others. 
Please check the documentation.

### Contributors
[![](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/images/0)](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/links/0)[![](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/images/1)](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/links/1)[![](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/images/2)](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/links/2)[![](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/images/3)](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/links/3)[![](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/images/4)](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/links/4)[![](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/images/5)](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/links/5)[![](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/images/6)](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/links/6)[![](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/images/7)](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/links/7)
