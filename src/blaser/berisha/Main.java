package blaser.berisha;

/*
 * Authors: Milena Blaser, Blerinë Berisha
 * Project: Flashcards
 */


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Set> sets = new ArrayList<Set>();
        ArrayList<Flashcard> cards = new ArrayList<Flashcard>();
        QuizManager qm = new QuizManager(sets);
        qm.getSets().add(new Set(cards, "stuff"));
        IOHandler.printColors();
        IOHandler.chooseColor();
        IOHandler.printSets(qm);
        qm.getSets().get(0).getSet().add(new Flashcard("Thor", "God of thunder"));
        qm.getSets().get(0).getSet().add(new Flashcard("Loki", "Frost giant"));
        qm.getSets().get(0).getSet().add(new Flashcard("Thunder", "Ruuuumble"));
        IOHandler.printFlashcards(qm.getSets().get(0));
    }
}
