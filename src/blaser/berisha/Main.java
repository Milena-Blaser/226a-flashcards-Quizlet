package blaser.berisha;

/*
 * Authors: Milena Blaser, Blerinë Berisha
 * Project: Flashcards
 */


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Flashcard> cards = new ArrayList<Flashcard>();
        Set set = new Set(cards, " ");
        ArrayList<Set> sets = new ArrayList<Set>();
        QuizManager qm = new QuizManager(sets);
        Quiz quiz = new Quiz(qm);
        quiz.startQuiz();
    }
}
