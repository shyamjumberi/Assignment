## Introduction

Developed a spring boot application which calculates the maximum satisfaction a person can get from eating at the restaurant.

## Code Example

Github url : https://github.com/shyamjumberi/Assignment.git

Developed a rest service which calculates the maximum satisfaction.To calculate maximum satisfaction,used the Ksnapsack algorithm.
Here reading the sample data from application.yml file while loading the spring boot application.

## How to run the application
Import the project into eclipse as a existing maven project.
 To compile the application run the "mvn clean install" maven command.
 To run the application, right click on the project and click on the run as "Spring Boot App" option (if you don't see the "Spring Boot App" option,install the spring sts plugin in eclipse ) or open command prompt and run the "java -jar fullpath of the jar location", 
 example "java -jar e://FoodSatisfaction//target//FoodSatisfaction-0.0.1-SNAPSHOT.jar". or go to project directory and run "spring-boot:run" command in command prompt.

Once spring boot application is up , hit the rest service url : "http://localhost:8080/getMaxSatisfaction" 
in browser which returns the max satisfaction value

## Test Cases
Test case file exists in src/java/test folder.To run test case right click on the test case file and run as junit


## ScreenShot
![capture](https://cloud.githubusercontent.com/assets/18001158/21235932/edb087f6-c31e-11e6-8d5d-b32602226c68.JPG)
