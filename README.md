# CSCI 205 - Software Engineering and Design
Bucknell University <br>
Lewisburg, PA

### Course Info
Instructor: Prof. Brian King <br>
Semester: Fall 2022

## Team Information
### Members: <br>
Connor Coles - Sophomore Computer Science Major and Project Owner <br>
Eric Reinhart - Sophomore Computer Science Major and Developer <br>
Jiasong Zhu - Junior Mathematics Major and Developer <br>
Mikey Ferguson - Sophomore Computer Science Major and Scrum Master

## Project Information
*This project is a recreation of the Pokémon game, in which two teams of six creatures battle it out until all creatures of one team are knocked unconscious. The last team standing wins! The user plays against the computer in a Pokémon showdown, and they have the option to make the computer smart and play strategically, or make the computer select moves randomly.<br><br>
The package structure of this project breaks down the code into different components of the project. The three main packages under the main package org.Fearsome_Foursome are Application, Battle, Creatures, and Moves.<br><br>
Application contains a subpackage Controllers, as well as two classes GameModel and HelloPokemon. HelloPokemon is responsible for launching the application, GameModel is responsible for bookkeeping the status of each team in the battle, and inside Controllers are 5 different classes, each responsible for controlling one of the 5 scenes of the application.<br><br>
The Battle package contains the Arena and Player classes. Each Player possesses six Pokémon, or Creatures, and each Arena has two Players. The arena is responsible for setting the two players' teams against each other, each having one Pokémon up to bat at a time.<br><br>
The Creatures package is responsible for the creation of all Pokémon creatures. With an abstract Creature class, which itself has a bunch of static maps that store information on the moves, appearances, and names of different specific types of creatures, this package provides the means of creating Pokémon. Its scalability also makes adding new types of Pokémon into the game manageable.<br><br>
Finally, the Moves package contains the means of creating new Moves which Pokémon creatures can perform. Each type of Move implements the Move interface, and the two implementations are AttackMove and SupportMove. AttackMoves performed by a Creature damage the Creature's target, and SupportMoves boost a certain attribute of whichever Creature uses said SupportMove.*

## How to run it
*Open terminal, navigate to a location in which you are comfortable copying files, and type in the following command:<br>*
git clone git@gitlab.bucknell.edu:mtf009/csci205_final_project.git<br>
*A folder named 'csci205_final_project' should have been created. Navigate into this folder and run the following command:<br>*
gradle wrapper<br>
*Once the latter operation completes, run the command:<br>*
./gradlew run<br>
*The application should launch!*