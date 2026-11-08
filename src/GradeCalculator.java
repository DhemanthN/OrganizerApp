import java.io.*;

public class GradeCalculator {

    private String gradeFile = "data/grades.csv";

    public void run() {
        String course = IO.readln("Class name: ");
        double current = readNumber("Current grade (%): ");
        double graded = readNumber("Percent of class graded so far: ");
        double target = readNumber("Target final grade (%): ");

        if (graded >= 100) {
            IO.println("Class is fully graded. Final grade: " + current + "%");
            return;
        }

        // final = current * graded/100 + needed * (100 - graded)/100, solved for needed
        double needed = (target * 100 - current * graded) / (100 - graded);
        IO.println("You need " + needed + "% on the rest of " + course + ".");
        saveGrade(course + "," + current + "," + graded + "," + target + "," + needed);
    }

    // append so old results aren't overwritten
    private void saveGrade(String line) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(gradeFile, true));
            writer.println(line);
            writer.close();
        } catch (IOException e) {
            IO.println("Could not save grade.");
        }
    }

    private double readNumber(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(IO.readln(prompt));
            } catch (NumberFormatException e) {
                IO.println("Enter a number.");
            }
        }
    }
}