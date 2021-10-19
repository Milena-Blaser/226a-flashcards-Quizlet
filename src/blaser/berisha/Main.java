package blaser.berisha;

/*
 * Authors: Milena Blaser, Blerinë Berisha
 * Project: Flashcards
 */


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Flashcard> cards = new ArrayList<Flashcard>();
        Set set = new Set(cards, "cards");
        set.addFlashcard();
        set.addFlashcard();
        set.searchByWord();
        set.deleteCard();

    }
}
