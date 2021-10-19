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
        System.out.println(IOHandler.getColor() +"Enter a word: " +IOHandler.RESET);
        String word = scan.nextLine();
        System.out.println(IOHandler.getColor() +"Enter the definition: " +IOHandler.RESET);
        String definition = scan.nextLine();
        Flashcard newCard = new Flashcard(word, definition);
        set.add(newCard);
        System.out.println(IOHandler.getColor() +"Card added!" +IOHandler.RESET);
        return set;
    }

    /**
     * @return returns an Arraylist with all results.
     */
    public ArrayList<Flashcard> searchByWord() {
        ArrayList<Flashcard> result = new ArrayList<Flashcard>();
        System.out.println(IOHandler.getColor() +"Which word would you like to search for?" +IOHandler.RESET);
        String search = scan.nextLine();
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i).getWord().toLowerCase().contains(search.toLowerCase())) {
                result.add(set.get(i));
                System.out.println(IOHandler.getColor() +i + ". " + "Word: " + set.get(i).getWord() + "\tDefinition: " + set.get(i).getDefinition() +IOHandler.RESET);
            }
        }
        if (result.isEmpty()) {
            System.out.println(IOHandler.getColor() +"No word has been found." +IOHandler.RESET);
        }
        return result;
    }

    /**
     * @return returns ArrayList without the card that has been deleted.
     */
    public ArrayList<Flashcard> deleteCard() {
        ArrayList<Flashcard> result = new ArrayList<Flashcard>();
        result = searchByWord();
        System.out.println(IOHandler.getColor() +"Enter the index of the word you'd like to delete: " +IOHandler.RESET);
        int delete = scan.nextInt();
        for (int i = 0; i < set.size(); i++) {
            if (delete == i) {
                set.remove(set.get(i));
            }
        }
        return result;
    }

    public ArrayList<Flashcard> updateFlashcard() {
        searchByWord();
        System.out.println(IOHandler.getColor() +"Enter the index of the word you'd like to edit: " +IOHandler.RESET);
        int edit = scan.nextInt();
        for (int i = 0; i < set.size(); i++) {
            if (edit == i) {
                System.out.println(IOHandler.getColor() +"Would you like to change the word, the definition or both? w/d/b" +IOHandler.RESET);
                char editWord = scan.next().charAt(0);
                switch (editWord) {
                    case 'w':
                        System.out.println(IOHandler.getColor() +"Enter the new word: " +IOHandler.RESET);
                        String word = scan.nextLine();
                        set.get(i).setWord(word);
                        System.out.println(IOHandler.getColor() +"Card edited!\nNew word: " + set.get(i).getWord() + "\nNew Definition: " + set.get(i).getDefinition() +IOHandler.RESET);
                        break;

                    case 'd':
                        System.out.println(IOHandler.getColor() +"Enter the new definition: " +IOHandler.RESET);
                        String def = scan.nextLine();
                        set.get(i).setDefinition(def);
                        System.out.println(IOHandler.getColor() + "Card edited!\nNew word: " + set.get(i).getWord() + "\nNew Definition: " + set.get(i).getDefinition() +IOHandler.RESET);
                        break;

                    case 'b':
                        System.out.println(IOHandler.getColor() +"Enter the new word: " +IOHandler.RESET);
                        String newWord = scan.nextLine();
                        set.get(i).setWord(newWord);
                        System.out.println(IOHandler.getColor() +"Enter the new definition: " +IOHandler.RESET);
                        String newDef = scan.nextLine();
                        set.get(i).setDefinition(newDef);
                        System.out.println(IOHandler.getColor() +"Card edited!\nNew word: " + set.get(i).getWord() + "\nNew Definition: " + set.get(i).getDefinition() +IOHandler.RESET);
                        break;

                    default:
                        System.out.println(IOHandler.getColor() +"Invalid input. Try again." +IOHandler.RESET);
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