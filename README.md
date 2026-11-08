Project name: OrganizerApp

Function: Uses Java command line that keeps my grade, study time, budget, and notes organized and in one place.



Problem Statement: My problem is organization. I want to create a single place where I can organize my life, like calculating "what-if" grades, logging study time, tracking my budget, and having a place to study with flashcards.

Idea: I am going to create a Java program that can calculate "what-if" grades, log study time for each of my classes, track my monthly budget, and create flashcards from Obsidian using .md files.



Tech Stack: 
languages: Java


How it works:
![System Diagram](System%20Diagram.pdf)


libraries/commands: I/O (BufferedReader, InputStreamReader, FileReader, FileWriter, PrintWriter), Util for ArrayLists, LocalDate (time stamping for study dates), Util.collections (shuffling/randomizing)



Data storage: CSV/text file



Data Source: No API's, just my own .md files

MVP: Main menu, what if calculator, study time logger, budget tracker, flashcards, load/save feature

Future plans: weekly study plan, budget suggestions, folder loading

Chunked Build Plan:
1. Setup GIT repo with required initial setup like requirements for this assignment

2\. Build main menu with BufferedReader or other IO commands

3\. Build the what if grade calculator taking current grade and adding the "needed score" for future assignments

4\. Add save/load feature, using FileWriter or other IO commands to output what that session did

5\. Build the study time logger with LocalDate, and creating totals per class

6.Build monthly budget tracker for specific catagories

7\. Read Obsidian .md files and parse using some type of "question \_\_ answer" format and create Flashcard Objects

8\. Build the flashcard setup using util.collections to shuffle and generate a final score

9\. add error handling, and create documentation like README












