package blaser.berisha;

import java.io.File;
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
    private static ArrayList<Set> sets1;
    private ArrayList<Set> sets;

    public QuizManager(ArrayList<Set> sets) {
        this.sets = sets;
    }

    /**
     * This method starts the program and checks if
     * there are already existing set file, those
     * sets are then added to the Arraylist of sets
     */
    public static void startProgramm() {
        ArrayList<Set> sets = new ArrayList<>();
        FileHandler.createTheSetFile();
        FileHandler.readSetFile(sets);
        QuizManager qm = new QuizManager(sets);
        Quiz quiz = new Quiz(qm);
        quiz.startQuiz();
    }

    /**
     * This method adds a new set to the Arraylist sets
     * and calls the method that will add the set to the
     * setFile. It also calls the creatSetFile()
     ** @return the updated Arraylist sets
     */
    public ArrayList<Set> addSet() {
        Scanner scan = new Scanner(System.in);
        System.out.println(IOHandler.getColor() + "Enter the title of the set: " + IOHandler.RESET);
        String setTitle = scan.nextLine();
        boolean isTitleOkay = IOHandler.printMessages(30, setTitle);
        if (isTitleOkay) {
            ArrayList<Flashcard> cards = new ArrayList<>();
            Set newSet = new Set(cards, setTitle);
            sets.add(newSet);
            FileHandler.createSetFile(newSet);
            FileHandler.addToSetFile(sets);
            System.out.println(IOHandler.getColor() + "Set added!" + IOHandler.RESET);
        } else if (!isTitleOkay) {
            System.err.println("Could not add set! See error message.");
        }
        return sets;
    }

    /**
     * This method changes the set title and calls
     * the method the will updated the setFile
     * accordingly
     */
    public void changeSetTitle() {
        Scanner scan = new Scanner(System.in);
        searchByWord();
        System.out.println(IOHandler.getColor() + "Enter the index of the title you'd like to change: " + IOHandler.RESET);
        int edit = scan.nextInt();
        for (int i = 0; i < sets.size(); i++) {
            if (edit == i) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the new title: ");
                String title = scanner.nextLine();
                FileHandler.updateSetFile(sets.get(i), title);
                sets.get(i).setTitle(title);
                System.out.println("Title changed!");
            }
        }
    }

    /**
     * This method deletes a set and also calls
     * the method that will delete the set from
     * the setFile
     */

    public void deleteSet() {
        Scanner scan = new Scanner(System.in);
        searchByWord();
        System.out.println(IOHandler.getColor() + "Enter the index of the set you'd like to delete: " + IOHandler.RESET);
        int delete = scan.nextInt();
        for (int i = 0; i < sets.size(); i++) {
            if (delete == i) {
                FileHandler.deleteFromSetFile(sets.get(i));
                sets.remove(sets.get(i));
            }
        }
    }
/*
This method lets the user search for a specific word in the set
and checks whether or not it exists
 */
    public void searchByWord() {
        Scanner scan = new Scanner(System.in);
        System.out.println(IOHandler.getColor() + "What would you like to search for?" + IOHandler.RESET);
        String search = scan.nextLine();
        for (int i = 0; i < sets.size(); i++) {
            if (sets.get(i).getTitle().toLowerCase().contains(search.toLowerCase())) {
                System.out.println(IOHandler.getColor() + i + ". " + "Title: " + sets.get(i).getTitle() + IOHandler.RESET);
            }
        }
    }

    /**
     * This method lets the user choose which
     * sets they want to work with and if this
     * set even exists
     * @return the index of the chosen set
     */
    public Set chooseSet() {
        Set res = null;
        while (res == null) {
            Scanner scan = new Scanner(System.in);
            IOHandler.printSets(QuizManager.this);
            System.out.println(IOHandler.getColor() + ": " + IOHandler.RESET);
            int answer = (scan.nextInt());
            if (answer >= sets.size()) {
                System.err.println("Set not found. Please try again.");
            } else {
                for (int i = 0; i < sets.size(); i++) {
                    if (answer == i) {
                        System.out.println(IOHandler.getColor() + "Set found. " + IOHandler.RESET);
                        res = sets.get(i);
                    }
                }
            }
        }
        return res;
    }

    /**
     * This method calls the method that prints the set menu
     * and lets the user choose what they want to do with the
     * chosen set:
     * add, edit, delete a card
     * practice word or learn writing
     * go back to main menu
     */
    public void chooseAction() {
        Scanner scanner = new Scanner(System.in);
        Set result = chooseSet();
        IOHandler.printSetMenu();
        FileHandler.readFlashcards(result);
        int choice = scanner.nextInt();
        while (choice != 5) {
            switch (choice) {
                case 1:
                    IOHandler.printFlashcards(result);
                    break;
                case 2:
                    result.addFlashcard(result);
                    break;
                case 3:
                    result.updateFlashcard(result);
                    break;
                case 4:
                    result.deleteCard(result);
                    break;
                case 6:
                    Quiz.practiceFlashcards(result);
                    break;
                case 7:
                    Quiz.learnWords(result);
                    break;
                case 8:
                    System.exit(0);
            }
            IOHandler.printSetMenu();
            choice = scanner.nextInt();
        }
    }

    public ArrayList<Set> getSets() {
        return sets;
    }
}
