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
    private ArrayList<Set> sets;

    public QuizManager(ArrayList<Set> sets) {
        this.sets = sets;
    }

    public static void startProgramm(){
        ArrayList<Set> sets = new ArrayList<>();
        FileHandler.addToSetFile(sets);
        FileHandler.readSetFile(sets);
        for(int i = 0; i < sets.size(); i++){
            FileHandler.readFlashcards(sets.get(i));
        }
        QuizManager qm = new QuizManager(sets);
        Quiz quiz = new Quiz(qm);
        quiz.startQuiz();
    }

    public ArrayList<Set> addSet() {
        Scanner scan = new Scanner(System.in);
        System.out.println(IOHandler.getColor() + "Enter the title of the set: " + IOHandler.RESET);
        String setTitle = scan.nextLine();
        ArrayList<Flashcard> cards = new ArrayList<>();
        Set newSet = new Set(cards, setTitle);
        sets.add(newSet);
        FileHandler.createSetFile(newSet);
        FileHandler.addToSetFile(sets);
        System.out.println(IOHandler.getColor() + "Set added!" + IOHandler.RESET);
        return sets;
    }

    public void changeSetTitle() {
        Scanner scan = new Scanner(System.in);
        searchByWord();
        System.out.println(IOHandler.getColor() + "Enter the index of the title you'd like to change: " + IOHandler.RESET);
        int edit = scan.nextInt();
        for (int i = 0; i < sets.size(); i++) {
            if (edit == i) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the new title: ");
                sets.get(i).setTitle(scanner.nextLine());
                System.out.println("Title changed!");
            }
        }
    }

    public void deleteSet() {
        Scanner scan = new Scanner(System.in);
        searchByWord();
        System.out.println(IOHandler.getColor() + "Enter the index of the set you'd like to delete: " + IOHandler.RESET);
        int delete = scan.nextInt();
        for (int i = 0; i < sets.size(); i++) {
            if (delete == i) {
                sets.remove(sets.get(i));
            }
        }
    }

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

    public Set chooseSet() {
        Scanner scan = new Scanner(System.in);
        //searchByWord();
        IOHandler.printSets(QuizManager.this);
        Set result = new Set(new ArrayList<>(), " ");
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
        Scanner scanner = new Scanner(System.in);
        Set result = chooseSet();
        IOHandler.printSetMenu();
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

    public void setSets(ArrayList<Set> sets) {
        this.sets = sets;
    }

}
