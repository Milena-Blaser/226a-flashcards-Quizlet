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
    private Scanner scan = new Scanner(System.in);
    public Set(ArrayList<Flashcard> set, String title) {
        this.set = set;
        this.title = title;
    }

    /**
     * @return returns the ArrayList set with the added flashcard.
     */
    public ArrayList<Flashcard> addFlashcard(){
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
    public ArrayList<Flashcard> searchByWord(){
        ArrayList<Flashcard> result = new ArrayList<Flashcard>();
        System.out.println("What would you like to search for?");
        String search = scan.nextLine();
        for(int i=0; i < set.size(); i++){
            if(set.get(i).getWord().toLowerCase().contains(search.toLowerCase())){
                result.add(set.get(i));
                System.out.println("Word: "+set.get(i).getWord()+"\nDefinition: "+set.get(i).getDefinition());
            }
        }
        return result;
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