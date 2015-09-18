################################################################
# SPS Commerce Software Development Kit for Java
################################################################
This bundle contains sample project and library designed to enable developers to work with Label Service from SPS Commerce
________________________________________________________________
## Getting started
The information in this README provides a Quick Start Guide to get the provided materials up and running within your development environment, for more in-depth information be sure to visit the [Dev Center Portal ](https://devcenter.spscommerce.com/developer-resources.aspx).

### Requirements for launching sample projects
    * Java 1.7+
    * Maven

### To include current Development kit in your project:
    Include *.jar file from lib/ folder to your Project Library
	
### To open the Maven JAVA project in Intellij Idea.
	Go to 'File -> Open Project' and specify the path to pom.xml
If you have any problems with importing the project, please, check this http://wiki.jetbrains.net/intellij/Creating_and_importing_Maven_projects#Importing_an_existing_Maven_project_into_an_IntelliJ_IDEA_project
		
### To open the Maven JAVA project in Eclipse.
First step is to install Maven. 
Install Maven for Eclipse can be done in two ways:
I
	1) Open Eclipse IDE
	2) Click 'Help -> Install New Software...'
	3) Click 'Add' button at top right corner
	At pop up: 
	4) Fill up 'Name' as "M2Eclipse" and 'Location' as "http://download.eclipse.org/technology/m2e/releases"
	Now click 'OK'. Installation would be started.
II
	1) Open Eclipse IDE
	2) Go to 'Help -> Eclipse Marketplace'
	3) Search by 'Maven Integration for Eclipse'
	4) Click "Install" 
	Follow the instruction step by step

Second step is open the project
In Eclipse:
	1) Go to 'File -> Import... -> Maven -> Existing Maven Projects'
	2) Click Next
	3) Click 'Browse...' button at top right corner
	4) Select Folder of unzipped project of Java SDK (shared-services-java-sdk-version).
	5) It will download pom.xml file in 'Projects' area and select it.
	6) Click 'Finish'
________________________________________________________________
## Sample project overview
### labelsample:
Label service is the latest addition to our services. At this time it uses a different method of authentication. You will need to set the correct credentials in a file named 'LabelZplTester.java' 
    (Current version requires you to provide labelServiceUsername and labelServicePassword) within the code. 
	Please replace the Auth. parameters within the project. Here is a code fragment where this needs to be done:

        String labelServiceUsername = @"customertest";
        String labelServicePassword = @"spstest".
__________________________________________________________________________________________________________
## Printing labels functionality overview
### working with local zebra printer:
In case of printing labels on zebra printer directly from your codebase, make sure you are using PrintService from axis2-1.2.jar
[Overview] (http://search.maven.org/#artifactdetails%7Corg.apache.axis2%7Caxis2%7C1.2%7Cpom)
[Direct link for package] (http://search.maven.org/remotecontent?filepath=org/apache/axis2/axis2/1.2/axis2-1.2.jar)
__________________________________________________________________________________________________________
## Documentation and resources
For more information be sure to visit:

* [Java Platform Installation](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Apache Maven Download](http://maven.apache.org/download.cgi)
* [Dev Center Developer Resources](https://devcenter.spscommerce.com/developer-resources.aspx)
