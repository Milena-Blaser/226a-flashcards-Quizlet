package blaser.berisha;

import java.util.ArrayList;

/*
 * Authors: Milena Blaser, Blerinë Berisha
 * Project: Flashcards
*/
/**
 * Class to administer all sets. Here you can show, create and delete sets.
 */
public class QuizManager {
    private ArrayList<Set> sets;

    public QuizManager(ArrayList<Set> sets) {
        this.sets = sets;
    }

    public ArrayList<Set> getSets() {
        return sets;
    }

    public void setSets(ArrayList<Set> sets) {
        this.sets = sets;
    }
}