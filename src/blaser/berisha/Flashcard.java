package blaser.berisha;
/*
 * Authors: Milena Blaser, Blerinë Berisha
 * Project: Flashcards
 */

/**
 * Class with attributes, constructor, getters and setters for Flashcards.
 * Here are no specific methods needed, since the flashcards will be handled in their sets.
 */
public class Flashcard {
    private String word;
    private String definition;
    private boolean isCorrect;

    public Flashcard(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    public Flashcard(){

    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
