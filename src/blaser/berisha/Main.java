package blaser.berisha;

/*
 * Authors: Milena Blaser, Blerinë Berisha
 * Project: Flashcards
 */


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Flashcard> setlist = new ArrayList();
        Flashcard card = new Flashcard("a super long word", "a random thing");
        Flashcard card1 = new Flashcard("another word", "wow so cool!");
        Set set = new Set(setlist,"test" );
        set.getSet().add(card);
        set.getSet().add(card1);


        QuizManager.startProgramm();


    }
}
