# CS4773-HW4

This assignment is a 2-view JavaFX application. 

# Overview

At program initialization the user is met with a window that displays team and score information for a fictional contest. This information is held within a JavaFX ListView instance. Once the user clicks on one of the teams in the ListView, a detail/editor view of that team will pop up where the user can then modify that team's name and score. Changing this information will be reflected upon the scoreboard, it will also do so for any other instances of that teams editor windows that are open. 

The program follows a MVVM structure and utilizes Facade and Observer patterns. 
General functionalities of the structure and design can be viewed at the below links:
MVVM: https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel
Design patterns: https://refactoring.guru/design-patterns/facade | https://refactoring.guru/design-patterns/observer

# Diagram
![alt text](https://github.com/Jalyn-Merritt/CS4773-HW4/blob/main/assignment4UML.jpg?raw=true)

# Inputs
Legal input for the team editor window operates as such:
  - Team Name: A string of between 5 and 50 alpha/numeric characters. No special characters or symbols except for the space character. The default is “No name provided”
  - Score: An integer between 0 and 2,000 (inclusive). The default is 0
  - Modification Date: A date (including time) automatically set by your program every time the model data changes. The format is yyyy-mm-dd hh:mm:ss (hh is military/24 hr. time format). The default is the date when the object is created.

# Misc.
This program is a Maven Java project, the zip file 'hw4.zip' within the repository will contain the pom.xml file, UML diagram, and source code for the program. Additionally, the most recent version of JavaFX should be used to interact with this project.
