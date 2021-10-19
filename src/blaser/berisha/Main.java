package blaser.berisha;

/*
 * Authors: Milena Blaser, Blerinë Berisha
 * Project: Flashcards
 */


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Flashcard> cards = new ArrayList<Flashcard>();
        cards.add(new Flashcard("stuff", "more than one thing"));
        cards.add(new Flashcard("thunder", "rumblerumble"));
        Set set = new Set(cards, "stuff");

        ArrayList<Flashcard> moreCards = new ArrayList<Flashcard>();
        moreCards.add(new Flashcard("stuff", "more than one thing"));
        moreCards.add(new Flashcard("thunder", "rumblerumble"));
        Set moreStuff = new Set(moreCards, "woah! more!");
        ArrayList<Set> sets = new ArrayList<Set>();
        sets.add(set);
        sets.add(moreStuff);
        QuizManager qm = new QuizManager(sets);
        IOHandler.printStartMenu();
        IOHandler.printSets(qm);
        IOHandler.printSetMenu();
    }
}
