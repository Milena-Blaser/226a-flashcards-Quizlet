package blaser.berisha;

import java.util.ArrayList;

/**
 * Authors: Milena Blaser, Blerinë Berisha
 * Project: Flashcards
 */

public class Set {
    private ArrayList<Flashcard> set;
    private String title;
    private String zipCode;
    private String country;

    public Set(ArrayList<Flashcard> set, String title, String zipCode, String country) {
        this.set = set;
        this.title = title;
        this.zipCode = zipCode;
        this.country = country;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
