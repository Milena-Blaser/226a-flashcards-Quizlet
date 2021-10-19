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
                System.out.println(i +" "+ "Word: "+set.get(i).getWord()+"\nDefinition: "+set.get(i).getDefinition());
            }
        }
        if(result.isEmpty()){
            System.out.println("No word has been found.");
        }
        return result;
    }

    /**
     * @return returns ArrayList without the card that has been deleted.
     */
    public ArrayList<Flashcard> deleteCard(){
        ArrayList<Flashcard> result = new ArrayList<Flashcard>();
        result = searchByWord();
        System.out.println("Enter the index of the word you'd like to delete: ");
        int delete = scan.nextInt();
        for(int i=0; i<result.size(); i++){
            if(delete == i){
                result.remove(result.get(i));
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