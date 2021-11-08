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
     * This method adds a Flashcard to the right set and calls
     * the method responsible for adding the flashcard to the
     * set file. The word and the definition are checked whether
     * they have a accepted length
     * @param wholeSet is used as a parameter for the Filehandler method
     **/
    public void addFlashcard(Set wholeSet) {
        Scanner input = new Scanner(System.in);
        System.out.println(IOHandler.getColor() + "Enter a word: " + IOHandler.RESET);
        String word = input.nextLine();
        boolean isWordOkay = IOHandler.printMessages(20, word);
        System.out.println(IOHandler.getColor() + "Enter the definition: " + IOHandler.RESET);
        String definition = input.nextLine();
        boolean isDefinitionOkay = IOHandler.printMessages(40, definition);
        if (isWordOkay && isDefinitionOkay) {
            Flashcard newCard = new Flashcard(word, definition);
            set.add(newCard);
            FileHandler.addFlashcardsToFile(wholeSet);
            System.out.println(IOHandler.getColor() + "Card added!" + IOHandler.RESET);
        } else if (!isWordOkay) {
            System.err.println("Card not added. See error message(s).");
        } else if (!isDefinitionOkay) {
            System.err.println("Card not added. See error message(s).");
        }
    }

    /**
     * This method lets the user search for a specific word
     */
    public void searchByWord() {
        Scanner input = new Scanner(System.in);
        System.out.println(IOHandler.getColor() + "What would you like to search for?" + IOHandler.RESET);
        String search = input.nextLine();
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i).getWord().toLowerCase().contains(search.toLowerCase())) {
                IOHandler.printCard(set.get(i), i);
            }
        }
    }

    /**
     * This method deletes a flashcard from the right
     * set. It also calls the method that will delete the
     * flashcard from the set file
     * @param wholeSet is used a parameter for the filehandler method
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
     * This method updates the Flashcard by asking
     * whether the user wants to change the definition, the word or
     * both.It also calls the method to update the flashcard in the set file
     * @return returns the updated set
     * @param wholeSet is used to hand over the updated flashcard to the filehHandler
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
                        boolean isWordOkay = IOHandler.printMessages(20, word);
                        if (isWordOkay) {
                        FileHandler.updateFlashcardInFile(wholeSet, card, word + "," + card.getDefinition());
                        set.get(i).setWord(word);
                        } else if (!isWordOkay) {
                            System.err.println("Could not update card.");
                        }
                        break;

                    case 'd':
                        Scanner sc = new Scanner(System.in);
                        System.out.println(IOHandler.getColor() + "Enter the new definition: " + IOHandler.RESET);
                        String def = sc.nextLine();
                        boolean isDefinitionOkay = IOHandler.printMessages(20, def);
                        if (isDefinitionOkay){
                            FileHandler.updateFlashcardInFile(wholeSet, card, card.getWord() + "," + def);
                            set.get(i).setDefinition(def);
                        } else if (!isDefinitionOkay) {
                        System.err.println("Could not update card.");
                        }
                        break;

                    case 'b':
                        Scanner scanner = new Scanner(System.in);
                        System.out.println(IOHandler.getColor() + "Enter the new word: " + IOHandler.RESET);
                        String newWord = scanner.nextLine();
                        isWordOkay = IOHandler.printMessages(20, newWord);
                        System.out.println(IOHandler.getColor() + "Enter the new definition: " + IOHandler.RESET);
                        String newDef = scanner.nextLine();
                        isDefinitionOkay = IOHandler.printMessages(20, newDef);
                        if (isWordOkay && isDefinitionOkay) {
                            FileHandler.updateFlashcardInFile(wholeSet, card, newWord + "," + newDef);
                            set.get(i).setWord(newWord);
                            set.get(i).setDefinition(newDef);
                            System.out.println(IOHandler.getColor() + "Card updated!" + IOHandler.RESET);
                        } else if (!isWordOkay) {
                            System.err.println("Card not added. See error message(s).");
                        } else if (!isDefinitionOkay) {
                            System.err.println("Card not added. See error message(s).");
                        }
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