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
    private double status;

    public Flashcard(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    public String printStatus(){
        String printableStatus = "";
        int countCorrectAnswer = (int) this.getStatus();
        for(int i = 0; i < countCorrectAnswer; i++){
            printableStatus += "*";
        }
        return printableStatus;
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

    public double getStatus() {
        return status;
    }

    public void setStatus(double status) {
        this.status = status;
    }
}
