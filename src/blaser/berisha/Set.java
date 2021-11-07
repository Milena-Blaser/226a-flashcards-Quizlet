package blaser.berisha;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Authors: Milena Blaser, Blerinë Berisha
 * Project: Flashcards
 */

/**
 * Class where Flashcards are saved. Here you can also add, delete and update Flashcards in a set.
 */
public class Set {
    private ArrayList<Flashcard> set;
    private String title;

    public Set(ArrayList<Flashcard> set, String title) {
        this.set = set;
        this.title = title;
    }

    /**
     * @return returns the ArrayList set with the added flashcard.
     */
    public void addFlashcard(Set wholeSet) {
        Scanner input = new Scanner(System.in);
        System.out.println(IOHandler.getColor() + "Enter a word: " + IOHandler.RESET);
        String word = input.nextLine();
        System.out.println(IOHandler.getColor() + "Enter the definition: " + IOHandler.RESET);
        String definition = input.nextLine();
        Flashcard newCard = new Flashcard(word, definition);
        set.add(newCard);
        FileHandler.addFlashcardsToFile(wholeSet);
        System.out.println(IOHandler.getColor() + "Card added!" + IOHandler.RESET);
    }

    /**
     * @return returns an Arraylist with all results.
     */
    public void searchByWord() {
        Scanner input = new Scanner(System.in);
        System.out.println(IOHandler.getColor() + "Which word would you like to search for?" + IOHandler.RESET);
        String search = input.nextLine();
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i).getWord().toLowerCase().contains(search.toLowerCase())) {
                IOHandler.printCard(set.get(i), i);
            }
        }
    }

    /**
     * @return returns ArrayList without the card that has been deleted.
     */
    public void deleteCard(Set wholeSet) {
        Scanner input = new Scanner(System.in);
        searchByWord();
        System.out.println(IOHandler.getColor() + "Enter the index of the word you'd like to delete: " + IOHandler.RESET);
        int delete = input.nextInt();
        for (int i = 0; i < set.size(); i++) {
            if (delete == i) {

                FileHandler.deleteFlashcardFromFile(wholeSet, set.get(i));
                set.remove(set.get(i));
            }
        }
    }

    /**
     * @return returns the updated set
     */
    public void updateFlashcard(Set wholeSet) {
        Scanner input = new Scanner(System.in);
        searchByWord();
        System.out.println(IOHandler.getColor() + "Enter the index of the word you'd like to edit: " + IOHandler.RESET);
        int edit = input.nextInt();
        for (int i = 0; i < set.size(); i++) {
            if (edit == i) {
                Flashcard card = set.get(i);
                System.out.println(IOHandler.getColor() + "Would you like to change the word, the definition or both? w/d/b" + IOHandler.RESET);
                char editWord = input.next().charAt(0);
                switch (editWord) {
                    case 'w':
                        Scanner scan = new Scanner(System.in);
                        System.out.println(IOHandler.getColor() + "Enter the new word: " + IOHandler.RESET);
                        String word = scan.nextLine();
                        FileHandler.updateFlashcardInFile(wholeSet, card, word + "," + card.getDefinition());
                        set.get(i).setWord(word);
                        break;

                    case 'd':
                        Scanner sc = new Scanner(System.in);
                        System.out.println(IOHandler.getColor() + "Enter the new definition: " + IOHandler.RESET);
                        String def = sc.nextLine();
                        FileHandler.updateFlashcardInFile(wholeSet, card, card.getWord() + "," + def);
                        set.get(i).setDefinition(def);
                        break;

                    case 'b':
                        Scanner scanner = new Scanner(System.in);
                        System.out.println(IOHandler.getColor() + "Enter the new word: " + IOHandler.RESET);
                        String newWord = scanner.nextLine();
                        System.out.println(IOHandler.getColor() + "Enter the new definition: " + IOHandler.RESET);
                        String newDef = scanner.nextLine();
                        FileHandler.updateFlashcardInFile(wholeSet, card, newWord + "," + newDef);
                        set.get(i).setWord(newWord);
                        set.get(i).setDefinition(newDef);
                        break;

                    default:
                        System.out.println(IOHandler.getColor() + "Invalid input. Try again." + IOHandler.RESET);
                }
            }

        }


    }

    public ArrayList<Flashcard> getSet() {
        return set;
    }

    public void setSet(ArrayList<Flashcard> set) {
        this.set = set;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}