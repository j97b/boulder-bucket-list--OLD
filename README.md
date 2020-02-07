# Boulder Bucket List

## Index

### Individual Project

[Brief](#brief)
 * [Solution](#solution)
 
[Architecture](#architecture)
 * [Entity Relationship Diagram](#erd)
 * [Architecture Diagram](#arch)

[Testing](#testing)
 * [Report](#report)
 
[Deployment](#deployment)
 * [Technologies](#tech)

[Front end](#frontEnd)

[Future Development](#future)

### DevOps Project

[Brief](#devopsbrief)
 * [Solution](#devopssolution)

[Authors](#auth)

[External Links](#links)

# Individual Project
James Barron

<a name="brief"></a>
## Project Brief
 
To create an OOP-based application with utilisation of supporting tools, methodologies and technologies that encapsulate all core modules covered during training.
 
<a name="solution"></a>
### My Solution
 
I chose to create an application for climbers to create a bucket list of boulders they wish to climb, and to track their progress on different boulders over time.

<a name="architecture"></a>
## Architecture

<a name="erd"></a>
### Entity Relationship Diagram
![ERD](/Documentation/erd.png)

This is a diagram of the entities in my final application and the relationship between them.

![ERD Future](/Documentation/erdFuture.png)

This is my idea for the ERD if I implement the notes functionality as discussed [here](#future).

<a name="arch"></a>
![Architecture Diagram](/Documentation/architecture.png)

This is a high level diagram of the system architecture of my application, excluding the classes found in each package.

<a name="testing"></a>
## Testing

I used JUnit, Mockito and Selenium for unit, integration, and frontend testing respectively, and SonarQube for static reporting.

<a name="report"></a>
### Reports

My Surefire can be found [here](/Documentation/SurefireReport.pdf).

Overall coverage is at 89.6%, with 0 bugs, 4 vulnerabilities, 0 duplications and 24 code smells. The vulnerabilities stem from not using DTO objects, which was cleared with a trainer.

![SonarQube Report](/Documentation/SonarQube.png)


<a name="deployment"></a>
## Deployment
![CI/CD Pipeline](/Documentation/CICDPipeline.png)

The Boulder Bucket List is deployable both locally and through a virtual machine, using Jenkins to automate the process of building, testing and deploying. This process is triggered by updates to the GitHub repository.

<a name="tech"></a>
### Technologies

The application was created using the following technologies:
 * H2 - Database
 * Java - Backend Logic
 * JavaScript, CSS, HTML - Frontend
 * GitHub - Version Control
 * Jenkins - CI Server
 * Maven - Build Tool
 * AWS - Deployment Environment
 * Jacoco, Surefire, SonarQube - Test Reporting
 * [Trello](https://trello.com/b/smf3HVHB/bouldering-bucket-list) - Project Management/Tracking

<a name="frontEnd"></a>
## Initial Front End Design
![Bucket List Wireframe](/Documentation/bucketListPage.png)

This is the wireframe for my initial design of the bucket list page.

![Add Climb Wireframe](/Documentation/addClimb.png)


![Login Page Wireframe](/Documentation/loginPage.png)

A full set of wireframes with attached user stories can be found on my trello board [here](https://trello.com/b/smf3HVHB/bouldering-bucket-list).

<a name="future"></a>
## Future Development

The next step for me is to refine the login system, giving users a password and adding user verification to view their bucket list. I would also like to change the login process, as at the moment it is not very secure notwithstanding the lack of a password, because anyone can easily see all the users who have a bucket list.

I would also like to add a note system, where each boulder can have a number of notes attached to them, giving users the possibilty to create a diary of each climb, or to note down specific directions for a hard to find boulder. Another idea would be to improve on the location functionality, so each boulder could be assigned coordinates, and the user can see a map with the boulder location shown on the map. This could allow users to find boulders more easily.



# DevOps Project
James Barron & Tigs Knowles

<a name="devopsbrief"></a>
## Brief

To create a fully-deployed version of a full-stack OOP application, with utilisation of supporting tools, methodologies and technologies that encapsulate all core modules covered during training.

<a name="devopssolution"></a>
## Our Solution

We have created four pipelines using Jenkins, two to deploy the front end and back end of the development branch of the boulder bucket list project to a test environment hosted on AWS, and two to deploy the front and back end of the master branch to a live environment, via the test environment. 
The back end pipelines achieve this by packaging the application as cloned from the github repository, creating an image of the .jar file produced, and pushing the image to Dockerhub. Snapshots are also stored in a Nexus artifact repository. Once these images are on Dockerhub, the relevant environment instance pulls the image from Dockerhub and runs it on the instance.



![backend test pipeline](/Documentation/backendTestPipeline.png)

![frontend test pipeline](/Documentation/frontendTestPipeline.png)

![backend live pipleine](/Documentation/backendLivePipeline.png)

![frontend live pipeline](/Documentation/frontendLivePipeline.png)

<a name="devopstech"></a>
## Technologies

* Trello - Project Management
* Github - Version Control
* Maven - Build Tool
* Docker/Dockerhub - Containerisation and image storing
* Nexus - Artifact Repository
* AWS - Hosting test and production environments


<a name="auth"></a>
## Authors

James Barron

Tigs Knowles

<a name="links"></a>
## Links

[Trello board (Individual Project)](https://trello.com/b/smf3HVHB/bouldering-bucket-list)

[Trello board (DevOps Project)](https://trello.com/b/Cy0aExH2/devops-project)

[GitHub repository for front end](https://github.com/j97b/boulder-bucket-list-frontend)

[Slides for presentation given on 20/01/2020](https://drive.google.com/file/d/1jSpfCxke0iwbbhMG-sXShDcBtMZq94Mp/view?usp=sharing)
