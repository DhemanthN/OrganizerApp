import java.io.*;
import java.util.*;

public class Flashcards {

    public void run() {
        String filename = IO.readln("Flashcard .md file: ");
        ArrayList<Flashcard> cards = loadCards(filename);
        if (cards.isEmpty()) {
            IO.println("No flashcards found. Write cards as: Question :: Answer");
            return;
        }

        Collections.shuffle(cards);
        int score = 0;
        for (Flashcard card : cards) {
            String guess = IO.readln(card.question + " ");
            if (guess.trim().equalsIgnoreCase(card.answer)) {
                IO.println("Correct!");
                score++;
            } else {
                IO.println("Wrong. Answer: " + card.answer);
            }
        }
        IO.println("Score: " + score + "/" + cards.size());
    }

    // only lines with "::" become cards, so regular notes in the file are skipped
    //I haven't found a workaround to not have a specific format
    private ArrayList<Flashcard> loadCards(String filename) {
        ArrayList<Flashcard> cards = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split("::");
                if (parts.length == 2) {
                    cards.add(new Flashcard(parts[0].trim(), parts[1].trim()));
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            IO.println("Could not read " + filename);
        }
        return cards;
    }
}