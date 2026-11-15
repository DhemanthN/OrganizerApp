import java.io.*;
import java.util.*;

public class OrgApp {

    private GradeCalculator grades = new GradeCalculator();
    private StudyLogger studyLog = new StudyLogger();
    private BudgetTracker budget = new BudgetTracker();
    private Flashcards flashcards = new Flashcards();

    void main() {
        IO.println("OrganizerApp");
        runMenu();
        IO.println("Goodbye!");
    }

    private void runMenu() {
        boolean running = true;
        while (running) {
            IO.println("\n1. Grades\n2. Study log\n3. Budget\n4. Flashcards\n5. Exit");
            String choice = IO.readln("Choose an option: ");
            if (choice.equals("1")) {
                grades.run();
            } else if (choice.equals("2")) {
                studyLog.run();
            } else if (choice.equals("3")) {
                budget.run();
            } else if (choice.equals("4")) {
                flashcards.run();
            } else if (choice.equals("5")) {
                running = false;
            } else {
                IO.println("Please enter 1-5.");
            }
        }
    }
}