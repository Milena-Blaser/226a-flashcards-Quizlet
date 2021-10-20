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
        System.out.println(IOHandler.getColor() + "Enter the title of the set: " + IOHandler.RESET);
        String setTitle = scan.nextLine();
        ArrayList<Flashcard> cards = new ArrayList<Flashcard>();
        Set newSet = new Set(cards, setTitle);
        sets.add(newSet);
        System.out.println(IOHandler.getColor() + "Set added!" + IOHandler.RESET);
        return sets;
    }

    public ArrayList<Set> deleteSet() {
        ArrayList<Set> result = new ArrayList<Set>();
        searchByWord();
        System.out.println(IOHandler.getColor() + "Enter the index of the set you'd like to delete: " + IOHandler.RESET);
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
        System.out.println(IOHandler.getColor() + "What would you like to search for?" + IOHandler.RESET);
        String search = scan.nextLine();
        for (int i = 0; i < sets.size(); i++) {
            if (sets.get(i).getTitle().toLowerCase().contains(search.toLowerCase())) {
                result.add(sets.get(i));
                System.out.println(IOHandler.getColor() + i + ". " + "Title: " + sets.get(i).getTitle() + IOHandler.RESET);
            }
        }
        if (result.isEmpty()) {
            System.out.println(IOHandler.getColor() + "No set has been found." + IOHandler.RESET);
        }
        return result;
    }

    public Set chooseSet() {
        searchByWord();
        Set result = new Set(new ArrayList<Flashcard>(), " ");
        System.out.println(IOHandler.getColor() + "Enter the index of the set you'd like to practice: " + IOHandler.RESET);
        int answer = scan.nextInt();
        int count = 0;
        for (int i = 0; i < sets.size(); i++) {
            if (answer == i) {
                result.setSet(sets.get(i).getSet());
                result.setTitle(sets.get(i).getTitle());
                count++;
                System.out.println(IOHandler.getColor() + "Found " + count + " set(s)." + IOHandler.RESET);
                System.out.println(sets.get(i).getTitle());
            }
        }
        return result;
    }

    public void chooseAction() {
        Set result = chooseSet();
        IOHandler.printSetMenu();
        int choice = scan.nextInt();
        while (choice != 4) {
            switch (choice) {
                case 1:
                    IOHandler.printFlashcards(result);
                    break;
                case 2:
                    result.addFlashcard();
                    break;
                case 3:
                    result.updateFlashcard();
                    break;
                case 4:
                    result.deleteCard();
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println(IOHandler.getColor() + "Doesn't work yet." + IOHandler.RESET);
                    break;
                case 7:
                    System.out.println(IOHandler.getColor() + "Doesn't work yet." + IOHandler.RESET);
                    break;
                case 8:
                    System.exit(0);
            }
            IOHandler.printSetMenu();
            choice = scan.nextInt();
        }
    }

    public ArrayList<Set> getSets() {
        return sets;
    }

    public void setSets(ArrayList<Set> sets) {
        this.sets = sets;
    }
}