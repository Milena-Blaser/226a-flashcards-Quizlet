package blaser.berisha;

/**
 * Authors: Milena Blaser, Blerinë Berisha
 * Project: Flashcards
 */

public class Flashcard {
    private String word;
    private String definition;
    private int correct;

    public Flashcard(String word, String definition, int correct) {
        this.word = word;
        this.definition = definition;
        this.correct = correct;
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

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }
}
