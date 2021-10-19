package blaser.berisha;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Authors: Milena Blaser, Blerinë Berisha
 * Project: Flashcards
 */

/**
 * Class to administer all sets. Here you can show, create and delete sets.
 */
public class QuizManager {
    private ArrayList<Set> sets;
    private Scanner scan = new Scanner(System.in);

    public QuizManager(ArrayList<Set> sets) {
        this.sets = sets;
    }

    public ArrayList<Set> addSet() {
        System.out.println("Enter the title of the set: ");
        String setTitle = scan.nextLine();
        ArrayList<Flashcard> cards = new ArrayList<Flashcard>();
        Set newSet = new Set(cards, setTitle);
        sets.add(newSet);
        System.out.println("Set added!");
        return sets;
    }

    public ArrayList<Set> deleteSet() {
        ArrayList<Set> result = new ArrayList<Set>();
        searchByWord();
        System.out.println("Enter the index of the set you'd like to delete: ");
        int delete = scan.nextInt();
        for (int i = 0; i < sets.size(); i++) {
            if (delete == i) {
                sets.remove(sets.get(i));
            }
        }
        return sets;
    }

    public ArrayList<Set> searchByWord() {
        ArrayList<Set> result = new ArrayList<Set>();
        System.out.println("What would you like to search for?");
        String search = scan.nextLine();
        for (int i = 0; i < sets.size(); i++) {
            if (sets.get(i).getTitle().toLowerCase().contains(search.toLowerCase())) {
                result.add(sets.get(i));
                System.out.println(i + ". " + "Title: " + sets.get(i).getTitle());
            }
        }
        if (result.isEmpty()) {
            System.out.println("No set has been found.");
        }
        return result;
    }



    public ArrayList<Set> getSets() {
        return sets;
    }

    public void setSets(ArrayList<Set> sets) {
        this.sets = sets;
    }
}