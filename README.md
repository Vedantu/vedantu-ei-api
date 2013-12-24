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
|**Platform**           | Java 6 <br/> **_tested with:_** <br/> *java version "1.6.0_30"* <br/> *Java(TM) SE Runtime Environment (build 1.6.0_30-b12)* <br/> *Java HotSpot(TM) 64-Bit Server VM (build 20.5-b03, mixed mode)* |
|**Build system**       | Ant (1.8.2 or above) <br/> **_tested with:_** <br/> *Apache Ant(TM) version 1.8.2* <br/> |
|**Application Server** | Apache Tomcat <br/> **_tested with:_** <br/> *Apache Tomcat 7.0.42* <br/> *Using some other Application Server would require appropriately adapting the build.xml file, as presently it refers ${env.CATALINA_HOME} or ${env.TOMCAT_HOME} for compilation.* |


### How to build?

The code can be built using Ant on a shell prompt.

To get the available build options:

```shell
ant
OR
ant help
```

**Note: Appropriately set the environment variable CATALINA_HOME or TOMCAT_HOME to refer to the base directory of your Apache Tomcat installation.**

Once you build you will find the following files in the dist folder:

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
