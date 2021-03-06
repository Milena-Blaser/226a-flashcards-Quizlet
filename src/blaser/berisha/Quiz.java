package blaser.berisha;

/*
 * Authors: Milena Blaser, BlerinĂ« Berisha
 * Project: Flashcards
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Class to start the quiz. Here the methods written in other classes will be called and that method will be called
 * in the main.
 */
public class Quiz {
    private QuizManager manager;

    public Quiz(QuizManager manager) {
        this.manager = manager;
    }

    public QuizManager getManager() {
        return manager;
    }

    /**
     * THis method starts the Quiz by calling the method
     * that prints the main menu and let's the user choose
     * what he wants to do:
     * show, add, delete, choose a set
     * change the title of a set
     * change the colour of the menu
     *
     */
    public void  startQuiz() {
        Scanner scan = new Scanner(System.in);
        IOHandler.chooseColor();
        IOHandler.printStartMenu();
        int choice = scan.nextInt();
        while (choice != 7) {
            switch (choice) {
                case 1:
                    IOHandler.printSets(getManager());
                    break;
                case 2:
                    manager.addSet();
                    break;
                case 3:
                    manager.deleteSet();
                    break;
                case 4:
                    manager.changeSetTitle();
                    break;
                case 5:
                    if(manager.getSets().size() != 0) {
                        manager.chooseAction();
                    }
                    else{
                        System.err.println("You have to add a set before you can choose one.");
                    }
                    break;
                case 6:
                    IOHandler.chooseColor();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }
            IOHandler.printStartMenu();
            choice = scan.nextInt();
        }
    }

    /**
     * This method is called when the flashcards are going to
     * be practiced. It calls the printFlipcard method to show
     * the card and checks whether the answers were correct
     * @param set the set that the program loops through to
     *            practice
     */

    public static void practiceFlashcards(Set set) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to guess the word(1) or the definition of the word(2)?");
        int setting = scan.nextInt();
        int setLength = set.getSet().size();
        int answer;
        int correctWords = 0;
        do {
            for (int i = 0; i < setLength; i++) {
                if (set.getSet().get(i).getStatus() < 3) {
                    answer = IOHandler.printFlipcard(setting, set, set.getSet().get(i), i);
                    if(answer == 0){
                        i = setLength;
                        correctWords = setLength;
                    }
                } else {
                    correctWords += 1;
                }
            }
        } while (correctWords < setLength);
        for (int i = 0; i < set.getSet().size(); i++) {
            set.getSet().get(i).setStatus(0);
        }
        System.out.println("Well done you went through the whole set!");

    }

    public static ArrayList<Integer> getRandomOrder(Set set ){
        ArrayList<Integer> indexList = new ArrayList<>();
        for(int i = 0; i < set.getSet().size(); i++){
            indexList.add(i);
        }
        Collections.shuffle(indexList);

        return indexList;
    }

    /**
     * This method is called when the use wants to practice
     * the spelling of the flashcards. It loops randomly through all
     * the flashcards of a set and checks whether the answers
     * are correct. Is the answer not correct the user will be
     * asked to repeat the correct answer that is printed out.
     *
     * @param set that is practiceed
     */
    public static void learnWords(Set set) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to guess the word(1) or the defintion of the word(2)?");
        int wordSetting = scanner.nextInt();
        System.out.println("Would you like to have the words checked on correct casing? yes(1) or no(2)");
        int checkingSetting = scanner.nextInt();
        int setLength = set.getSet().size();
        int correctWords = 0;
        String definition;
        String word;
        String guessedAnswer = "";
        scanner.nextLine();

        do {
            ArrayList<Integer> randomIndex = getRandomOrder(set);
            for (int i = 0; i < setLength; i++) {

                if (set.getSet().get(randomIndex.get(i)).getStatus() < 3) {

                    IOHandler.printLearningCard(wordSetting, set, set.getSet().get(randomIndex.get(i)), i);
                    System.out.println("Your answer: ");

                    guessedAnswer = scanner.nextLine();
                    definition = set.getSet().get(randomIndex.get(i)).getDefinition().toLowerCase();
                    word = set.getSet().get(randomIndex.get(i)).getWord().toLowerCase();
                    if(checkingSetting == 2){
                        guessedAnswer = guessedAnswer.toLowerCase();
                        definition = definition.toLowerCase();
                        word = word.toLowerCase();
                    }
                    if (guessedAnswer.equals(definition) || guessedAnswer.equals(word)) {
                        set.getSet().get(randomIndex.get(i)).setStatus(set.getSet().get(randomIndex.get(i)).getStatus() + 1);
                        System.out.println("Correct!");
                    } else if (guessedAnswer.equals("2")) {
                        correctWords = setLength;
                        break;

                    } else {
                        set.getSet().get(i).setStatus(0);
                        if (wordSetting == 2) {
                            System.out.println("Correct Answer would have been: " + set.getSet().get(randomIndex.get(i)).getWord());
                        } else {
                            System.out.println("Correct Answer would have been: " + set.getSet().get(randomIndex.get(i)).getDefinition());
                        }
                        do {
                            System.out.println("Repeat the word: ");
                            guessedAnswer = scanner.nextLine();
                        }while(!guessedAnswer.equals(definition) && wordSetting == 1 || wordSetting == 2 && !guessedAnswer.equals(word));
                    }
                } else {
                    correctWords += 1;
                }
            }
            System.out.println("NEXT ROUND!");
        } while (correctWords < setLength);

        for (int i = 0; i < set.getSet().size(); i++) {
            set.getSet().get(i).setStatus(0);
        }
        if (!guessedAnswer.equals("2")) {
            System.out.println("Well done you got all the cards correct!");
        }
    }
}
