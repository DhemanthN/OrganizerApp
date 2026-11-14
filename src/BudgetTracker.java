import java.io.*;
import java.time.LocalDate;

public class BudgetTracker {

    private String budgetFile = "data/budget.csv";

    public void run() {
        String category = IO.readln("Category: ");
        double amount = readAmount("Amount spent: $");
        double budget = readAmount("Monthly budget: $");
        saveExpense(LocalDate.now() + "," + category + "," + amount);

        double monthTotal = monthTotal("");
        IO.println("Spent on " + category + " this month: $" + String.format("%.2f", monthTotal(category)));
        IO.println("Total spent this month: $" + String.format("%.2f", monthTotal));
        IO.println("Left in budget: $" + String.format("%.2f", budget - monthTotal));
    }

    // blank category means add up every category
    private double monthTotal(String category) {
        String month = LocalDate.now().toString().substring(0, 7);
        double total = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(budgetFile));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                if (parts[0].startsWith(month) && (category.isEmpty() || parts[1].equals(category))) {
                    total += Double.parseDouble(parts[2]);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            IO.println("Could not read budget file.");
        }
        return total;
    }

    // appends so old expenses aren't overwritten
    private void saveExpense(String line) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(budgetFile, true));
            writer.println(line);
            writer.close();
        } catch (IOException e) {
            IO.println("Could not save expense.");
        }
    }
        //reader
    private double readAmount(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(IO.readln(prompt));
            } catch (NumberFormatException e) {
                IO.println("Enter a number.");
            }
        }
    }
}