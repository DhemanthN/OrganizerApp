Project name: OrganizerApp

Function: Uses Java command line that keeps my grade, study time, budget, and notes organized and in one place.



Problem Statement: My problem is organization. I want to create a single place where I can organize my life, like calculating "what-if" grades, logging study time, tracking my budget, and having a place to study with flashcards.

Idea: I am going to create a Java program that can calculate "what-if" grades, log study time for each of my classes, track my monthly budget, and create flashcards from Obsidian using .md files.



Tech Stack: 
languages: Java (JDK 25)
Libraries: java.io, java.util, java.time
Data storage is in csv files

Setup is the clone the repo, compile and finally run!

Example run:

=== OrganizerApp ===

1. Grades
2. Study log
3. Budget
4. Flashcards
5. Exit
Choose an option: 1
Class name: CS193
Current grade (%): 54
Percent of class graded so far: 80
Target final grade (%): 60
You need 84.0% on the rest of CS193.

1. Grades
2. Study log
3. Budget
4. Flashcards
5. Exit
Choose an option: 


How it works:
![System Diagram](System%20Diagram.png)

How it works: The user types the number for the "task" they want to accomplish and inputs required information to get an output from the task that matches the initial task name.

libraries/commands: I/O (BufferedReader, InputStreamReader, FileReader, FileWriter, PrintWriter), Util for ArrayLists, LocalDate (time stamping for study dates), Util.collections (shuffling/randomizing)



Data storage: CSV/text file



Data Source: No API's, just my own .md files

MVP: Main menu, what if calculator, study time logger, budget tracker, flashcards, load/save feature

Future plans: weekly study plan, budget suggestions, folder loading

Chunked Build Plan:
1.[x] Setup GIT repo with required initial setup like requirements for this assignment

2.[x] Build main menu with BufferedReader or other IO commands

3.[x] Build the what if grade calculator taking current grade and adding the "needed score" for future assignments

4.[x] Add save/load feature, using FileWriter or other IO commands to output what that session did

5.[x] Build the study time logger with LocalDate, and creating totals per class

6.[x] Build monthly budget tracker for specific catagories

7.[x] Read Obsidian .md files and parse using some type of "question \_\_ answer" format and create Flashcard Objects

8.[x] Build the flashcard setup using util.collections to shuffle and generate a final score

9.[x] add error handling, and create documentation like README












