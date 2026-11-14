import java.io.*;
import java.time.LocalDate;

public class StudyLogger {

    private String studyFile = "data/study.csv";

    public void run() {
        String course = IO.readln("Class name: ");
        int minutes = readMinutes();
        saveSession(LocalDate.now() + "," + course + "," + minutes);
        IO.println("Total time studied for " + course + ": " + totalMinutes(course) + " minutes");
    }

    // re-reads the whole file so the total includes past sessions
    private int totalMinutes(String course) {
        int total = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(studyFile));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                if (parts[1].equals(course)) {
                    total += Integer.parseInt(parts[2]);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            IO.println("Could not read study log.");
        }
        return total;
    }

    // append so old sessions aren't overwritten
    private void saveSession(String line) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(studyFile, true));
            writer.println(line);
            writer.close();
        } catch (IOException e) {
            IO.println("Could not save session.");
        }
    }

    private int readMinutes() {
        while (true) {
            try {
                return Integer.parseInt(IO.readln("Minutes studied: "));
            } catch (NumberFormatException e) {
                IO.println("Enter a whole number.");
            }
        }
    }
}