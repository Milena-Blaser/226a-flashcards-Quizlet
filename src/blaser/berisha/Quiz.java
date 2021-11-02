package blaser.berisha;

/*
 * Authors: Milena Blaser, Blerinë Berisha
 * Project: Flashcards
 */

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Class to start the quiz. Here the methods written in other classes will be called and that method will be called
 * in the main.
 */
public class Quiz {
    private QuizManager manager;
    Scanner scan = new Scanner(System.in);


    public Quiz(QuizManager manager) {
        this.manager = manager;
    }

    public QuizManager getManager() {
        return manager;
    }

    public void setManager(QuizManager manager) {
        this.manager = manager;
    }


    public void startQuiz() {
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
                    manager.chooseAction();
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
    public static void practiceFlashcards(Set set){
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to guess the word(1) or the defintion of the word(2)?");
        int setting = scan.nextInt();
        int setLength = set.getSet().size();
        int correctWords = 0;
        do {
            for (int i = 0; i < setLength; i++) {
                if (set.getSet().get(i).getStatus() < 3) {
                    IOHandler.printFlipcard(setting, set, set.getSet().get(i));
                } else {
                    correctWords += 1;
                }
            }
        }while (correctWords < setLength);
        System.out.println("Well done you went through the whole set!");

    }

}
