package blaser.berisha;

import java.lang.reflect.Array;
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
    private Scanner scan = new Scanner(System.in);

    public Set(ArrayList<Flashcard> set, String title) {
        this.set = set;
        this.title = title;
    }

    /**
     * @return returns the ArrayList set with the added flashcard.
     */
    public ArrayList<Flashcard> addFlashcard() {
        System.out.println("Enter a word: ");
        String word = scan.nextLine();
        System.out.println("Enter the definition: ");
        String definition = scan.nextLine();
        Flashcard newCard = new Flashcard(word, definition);
        set.add(newCard);
        System.out.println("Card added!");
        return set;
    }

    /**
     * @return returns an Arraylist with all results.
     */
    public ArrayList<Flashcard> searchByWord() {
        ArrayList<Flashcard> result = new ArrayList<Flashcard>();
        System.out.println("Which word would you like to search for?");
        String search = scan.nextLine();
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i).getWord().toLowerCase().contains(search.toLowerCase())) {
                result.add(set.get(i));
                System.out.println(i + ". " + "Word: " + set.get(i).getWord() + "\tDefinition: " + set.get(i).getDefinition());
            }
        }
        if (result.isEmpty()) {
            System.out.println("No word has been found.");
        }
        return result;
    }

    /**
     * @return returns ArrayList without the card that has been deleted.
     */
    public ArrayList<Flashcard> deleteCard() {
        ArrayList<Flashcard> result = new ArrayList<Flashcard>();
        result = searchByWord();
        System.out.println("Enter the index of the word you'd like to delete: ");
        int delete = scan.nextInt();
        for (int i = 0; i < result.size(); i++) {
            if (delete == i) {
                result.remove(result.get(i));
            }
        }
        return result;
    }

    public ArrayList<Flashcard> updateFlashcard() {
        searchByWord();
        System.out.println("Enter the index of the word you'd like to edit: ");
        int edit = scan.nextInt();
        for (int i = 0; i < set.size(); i++) {
            if (edit == i) {
                System.out.println("Would you like to change the word, the definition or both? w/d/b");
                String editWord = " ";
                String editDef = " ";
                switch (editWord.toLowerCase().charAt(0)) {
                    case 'w':
                        System.out.println("Enter the new word: ");
                        set.get(i).setWord(scan.nextLine());
                        System.out.println("Card edited!\nNew word: " + set.get(i).getWord() + "\nNew Definition: " + set.get(i).getDefinition());
                        break;
                    case 'd':
                        System.out.println("Enter the new definition: ");
                        set.get(i).setDefinition(scan.nextLine());
                        System.out.println("Card edited!\nNew word: " + set.get(i).getWord() + "\nNew Definition: " + set.get(i).getDefinition());
                        break;

                    case 'b':
                        System.out.println("Enter the new word: ");
                        set.get(i).setDefinition(scan.nextLine());
                        System.out.println("Enter the new definition: ");
                        set.get(i).setDefinition(scan.nextLine());
                        System.out.println("Card edited!\nNew word: " + set.get(i).getWord() + "\nNew Definition: " + set.get(i).getDefinition());
                        break;
                }
            }
        }
        return set;
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