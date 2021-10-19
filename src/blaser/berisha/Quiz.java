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
    private Scanner scan = new Scanner(System.in);

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
        IOHandler.chooseColor();
        IOHandler.printStartMenu();
        int choice = scan.nextInt();
        while (choice != 6) {
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
                    manager.chooseAction();
                    break;
                case 5:
                    IOHandler.chooseColor();
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }
            IOHandler.printStartMenu();
            choice = scan.nextInt();
        }
    }
}
