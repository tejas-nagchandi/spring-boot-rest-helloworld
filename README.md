# tejas-nagchandi/spring-boot-rest-helloworld
Using this repository you can create sample hello-world rest API using maven that responds "Hello World" message on GET request

## Expected output
You will build a service that will accept HTTP GET requests at http://localhost:8080/helloworld.
It will respond with a JSON representation of a Hello World message, as the following listing shows:
```json
{
    "content": "Hello, World!!!"
}
```

## Pre-requisites
### Required
1. A favorite text editor or IDE. ( *Please find documentation on few of the famous editors and IDE, I have used VS code for this project* )
    * [VS Code](https://code.visualstudio.com/)
    * [Notepadd ++](https://notepad-plus-plus.org/downloads/)
    * [Eclipe](https://www.eclipse.org/eclipseide/)
    * [IntelliJ IDEA](https://www.jetbrains.com/idea/promo/)
    * [Sublime](https://www.sublimetext.com/)
1. [JDK 1.8](https://www.oracle.com/java/technologies/javase-downloads.html) or later ( *I have used [Open JDK 15](https://jdk.java.net/15/) for this project* )
1. [Maven 3.2](https://maven.apache.org/download.cgi) or later ( *I have used 3.6.3 version this project* )

### Optional
1. [Git](https://git-scm.com/downloads)
1. [Postman](https://www.postman.com/downloads/)

## How to use this repository
You can use this repository to learn, how to create a Rest API from scratch and complete each step or you can bypass basic setup steps that are already familiar to you and directly clone this repository. Either way, you end up with working code.

To **start from the scratch**, move to [next section](#starting-with-spring-initializr)

To **skip the tutorial**, do the following:
* [Download](https://github.com/tejas-nagchandi/spring-boot-rest-helloworld/archive/main.zip) and unzip the source repository for this guide, or clone it using [Git](https://github.com/tejas-nagchandi/spring-boot-rest-helloworld.git):
```sh
git clone https://github.com/tejas-nagchandi/spring-boot-rest-helloworld.git
```
* cd into spring-boot-rest-helloworld/
```sh
cd spring-boot-rest-helloworld/
```
* Run maven clean package command using maven wrapper
```sh
./mvnw clean package
```
* cd into target directory
```sh
cd target/
```
* Run Jar using JAVA -jar command
```java
java -jar rest-get-hello-world-0.0.1-SNAPSHOT.jar
```
* Test your application from your preferred browser or Postman GET request using localhost [URL](localhost:8080/helloworld)

## Starting with Spring Initializr
For all Spring applications, you should start with the [Spring Initializr](https://start.spring.io/). The Initializr offers a fast way to pull in all the dependencies you need for an application and does a lot of the setup for you. This example needs only the Spring Web dependency.
* Under Project, select "Maven Project"
* Under Languare, select "Java"
* Under spring Boot, select any version ( *I have selected 2.4.2 for this project* )
* Fill in your details for Project Metadata
* Select "Jar" as packaging
* Select required Java version ( *I have selected version 15 for this project* )
* Add maven dependency "Spring Web", you will need only this dependency for this project.
* Generate, download and unzip the package to the desired location.
* After unzip, following files will be available in your workspace.
```
 ├── .gitignore
 ├── .mvn
 |       └── wrapper
 |           ├── MavenWrapperDownloader.java
 |           ├── maven-wrapper.properties
 |           └── maven-wrapper.jar
 ├── HELP.md
 ├── mvnw
 ├── mvnw.cmd
 ├── pom.xml
 └── src
        ├── main
        |    ├── java (Further directories as Group name)
        |    |   └── <ArtifactApplication.java>
        |    └── resources
        |        ├── static
        |        ├── templates
        |        └── application.properties
        └── test
             └── java (Further directories as Group name)
                 └── <ArtifactApplicationTests.java>
```
## Create a Resource Representation Class
Now that you have set up the project and build system, you can create your web service.

Begin the process by thinking about service interactions.

The service will handle *GET* requests for */helloworld*. The GET request should return a *200 OK* response with JSON in the body that represents a greeting. It should resemble the following output:
```json
{
    "content": "Hello, World!!!"
}
```
To model the helloworld representation, create a resource representation class. To do so, provide a plain old Java object with fields, constructors and accessors for content data, as the following listing (from src/main/java/com/spring/restgethelloworld/Helloworld.java) shows:
*Please update package and class name as per your convenience*
```java
package com.spring.restgethelloworld;

public class Helloworld {

	private final String content;

	public Helloworld(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
}
```

## Create a Resource Controller
In Spring’s approach to building RESTful web services, HTTP requests are handled by a controller. These components are identified by the *@RestController* annotation, and the HelloworldController shown in the following listing (from src/main/java/com/spring/restgethellowor/HelloworldController.java) handles GET requests for /helloworld by returning a new instance of the Helloworld class:
*Please update package and class name as per your convenience*
```java
package com.spring.restgethelloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {

	private static final String template = "Hello, %s!";

	@GetMapping("/helloworld")
	public Helloworld greeting(String name) {
		return new Helloworld(String.format(template, "World!!"));
	}
}
```
## Build an executable JAR
You can run the application from the command line with Maven. You can also build a single executable JAR file that contains all the necessary dependencies, classes, and resources and run that. Building an executable jar makes it easy to ship, version, and deploy the service as an application throughout the development lifecycle, across different environments, and so forth.

You can run the application by using:
```
./mvnw spring-boot:run
```
Alternatively, you can build the JAR file with
```
./mvnw clean package
```
And then run the JAR file, as follows:
*Please update the JAR name as per your configuration*
```
java -jar target/rest-get-hello-world-0.0.1-SNAPSHOT.jar
```

## Test the Service
Test your application from your preferred browser Postman GET request using localhost [URL](localhost:8080/helloworld)