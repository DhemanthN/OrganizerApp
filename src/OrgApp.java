import java.io.*;
import java.util.*;

public class OrgApp {

    private ArrayList<String> loadedLines = new ArrayList<>();
    private GradeCalculator grades = new GradeCalculator();
    private StudyLogger studyLog = new StudyLogger();

    void main() {
        IO.println("OrganizerApp");
        loadFiles();
        runMenu();
        IO.println("Goodbye!");
    }

    private void loadFiles() {
        IO.println("Enter files to load. Leave blank when done.");
        String filename = IO.readln("File name: ");
        while (!filename.isEmpty()) {
            readFile(filename);
            filename = IO.readln("File name: ");
        }
    }

    // stores lines now so flashcards can parse them later
    private void readFile(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                loadedLines.add(line);
                line = reader.readLine();
            }
            reader.close();
            IO.println("Loaded " + filename);
        } catch (IOException e) {
            IO.println("Could not read " + filename);
        }
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
                } else if (choice.equals("3") || choice.equals("4")) {
                    IO.println("Coming soon.");
                } else if (choice.equals("5")) {
                running = false;
                } else {
                IO.println("Please enter 1-5.");
            }
        }
    }
}