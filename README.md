vedantu-ei-api
==============

Vedantu External-Integration API server-side code for Institutes for integration of Vedantu with Institute's Systems. This enables Vedantu to communicate with the Institute’s Systems.

Download the latest release of vedantu-ei-api from GitHub.

#### Releases

1. [Latest release](https://github.com/Vedantu/vedantu-ei-api/releases/latest)
2. [All releases](https://github.com/Vedantu/vedantu-ei-api/releases)

### Requirements

|                       | Details                                                          |
|-----------------------|------------------------------------------------------------------|
|**Platform**           | Java 6 <br/> **_tested with:_** <br/> *java version "1.6.0_30"* <br/> *Java(TM) SE Runtime Environment (build 1.6.0_30-b12)* <br/> *Java HotSpot(TM) 64-Bit Server VM (build 20.5-b03, mixed mode)* <br/> **_also with_:** <br/> *java version "1.4.2"* |
|**Build system**       | Ant (1.8.2 or above) <br/> **_tested with:_** <br/> *Apache Ant(TM) version 1.8.2* <br/> |
|**Application Server** | Apache Tomcat <br/> **_tested with:_** <br/> *Apache Tomcat 7.0.42* <br/> *Apache Tomcat 5.5.12* |


### How to build?

The code can be built using Ant on a shell prompt. The build refers _lib_ and _common/lib_ folders (if any of them is available) for compilation (so as to pick the appropriate servlet jars). 

The build needs two environment variables:

1. JAVA_HOME
2. APP_SERVER_HOME

These variables can be set by creating a _build.properties_ file in the project (this is a local file) and putting the following properties in it:

1. REQ_JAVA_HOME
2. REQ_APP_SERVER_HOME

The next step is to actually build the project. This can be done by running the _build.sh_ from a shell:

```shell
./build.sh
```

The above procedure allows the project to be compiled against different versions of JAVA and Application Servers.


Once you build you will find the following files in the _dist_ folder:

1. vedantu-ei-api.jar
2. vedantu-ei-api.war


### Configuring Managers

Manager configuration needs to be specified in *managers.properties* file. This file needs to be on the path at runtime.

*managers.properties* file can be found in the following locations:

|                 | Location                 |
|-----------------|--------------------------|
| **code-base**   | *conf*            folder |
| **war file**    | *WEB-INF/classes* folder |
| **jar file**    | Absent.                  |


#### Supported Managers


| Manager        | Key                  | Sample                                             |
|----------------|----------------------|----------------------------------------------------|
| IUserManager   | user.manager.class   | com.vedantu.ei.managers.sample.SampleUserManager   |
| IUploadManager | upload.manager.class | com.vedantu.ei.managers.sample.SampleUploadManager |


### References
1. [docs/vedantu-ei-api.pdf](https://github.com/Vedantu/vedantu-ei-api/blob/master/docs/vedantu-ei-api.pdf) - Contains details of requirements and architecture.
