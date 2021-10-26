package blaser.berisha;

/*
 * Authors: Milena Blaser, Blerinë Berisha
 * Project: Flashcards
 */

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
}
