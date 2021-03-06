package blaser.berisha;

/*
 * Authors: Milena Blaser, Blerinë Berisha
 * Project: Flashcards
 */


import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

/**
 * Class to print menus, sets, flashcards, options, etc. and handle user input.
 */
public class IOHandler {
    public static Scanner scan = new Scanner(System.in);
    public static final String RED = "\u001B[31m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN = "\u001B[32m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW = "\u001B[33m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String GRAY_BACKGROUND = "\u001B[47m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String GRAY = "\u001B[37m";
    public static final String BLACK = "\u001B[30m";
    public static final String RESET = "\033[0m";
    public static String color = GRAY;

    /**
     * This method prints all the available colours for the menu design
     */
    public static void printColors() {
        System.out.println(GRAY + "╔═══════════════════════════════════╗");
        System.out.println(GRAY + "\u001B[1m║ Available colors:                 ║\u001B[0m");
        System.out.println(GRAY + "║───────────────────────────────────║");
        System.out.println("║" + BLUE + " Blue                          (1)" + GRAY + " ║");
        System.out.println("║ " + BLUE_BACKGROUND + BLACK + "Black on blue                 (2)" + RESET + GRAY + " ║");
        System.out.println("║" + PURPLE + " Purple                        (3)" + GRAY + " ║");
        System.out.println("║ " + PURPLE_BACKGROUND + BLACK + "Black on purple               (4)" + RESET + GRAY + " ║");
        System.out.println("║" + CYAN + " Cyan                          (5)" + GRAY + " ║");
        System.out.println("║ " + CYAN_BACKGROUND + BLACK + "Black on cyan                 (6)" + RESET + GRAY + " ║");
        System.out.println("║ Gray                          (7) ║");
        System.out.println("║ " + GRAY_BACKGROUND + BLACK + "Black on gray                 (8)" + RESET + GRAY + " ║");
        System.out.println("║ " + RED + "Red                           (9)" + RESET + GRAY + " ║");
        System.out.println("║ " + RED_BACKGROUND + BLACK + "Black on red                 (10)" + RESET + GRAY + " ║");
        System.out.println("║ " + YELLOW + "Yellow                       (11)" + RESET + GRAY + " ║");
        System.out.println("║ " + YELLOW_BACKGROUND + BLACK + "Black on yellow              (12)" + RESET + GRAY + " ║");
        System.out.println("║ " + GREEN + "Green                        (13)" + RESET + GRAY + " ║");
        System.out.println("║ " + GREEN_BACKGROUND + BLACK + "Black on green               (14)" + RESET + GRAY + " ║");
        System.out.println("║ " + RESET + "White                        (15)" + GRAY + " ║");
        System.out.println(GRAY + "╚═══════════════════════════════════╝");
    }

    /**
     * This method let's you choose which colour the menues should have
     * and sets the colour to the chosen colour
     */
    public static void chooseColor() {
        printColors();
        System.out.println(getColor() + "Enter the number in braces to choose: " + RESET);
        String chosen = scan.nextLine();
        switch (chosen.toLowerCase()) {
            case "1" -> setColor(BLUE);
            case "2" -> setColor(BLUE_BACKGROUND + BLACK);
            case "3" -> setColor(PURPLE);
            case "4" -> setColor(PURPLE_BACKGROUND + BLACK);
            case "5" -> setColor(CYAN);
            case "6" -> setColor(CYAN_BACKGROUND + BLACK);
            case "7" -> setColor(GRAY);
            case "8" -> setColor(GRAY_BACKGROUND + BLACK);
            case "9" -> setColor(RED);
            case "10" -> setColor(RED_BACKGROUND + BLACK);
            case "11" -> setColor(YELLOW);
            case "12" -> setColor(YELLOW_BACKGROUND + BLACK);
            case "13" -> setColor(GREEN);
            case "14" -> setColor(GREEN_BACKGROUND + BLACK);
            case "15" -> setColor(RESET);
            //if the input is "invalid" the default color will be set to gray
            default -> setColor(GRAY);
        }
    }

    /**
     * This method prints the main menu
     */
    public static void printStartMenu() {
        System.out.println(getColor() + "╔═══════════════════════════════════╗" + RESET);
        System.out.println(getColor() + "\u001B[1m║ Enter the number to..             ║\u001B[0m" + RESET);
        System.out.println(getColor() + "║───────────────────────────────────║" + RESET);
        System.out.println(getColor() + "║ 1. show all sets                  ║" + RESET);
        System.out.println(getColor() + "║ 2. create new set                 ║" + RESET);
        System.out.println(getColor() + "║ 3. delete set                     ║" + RESET);
        System.out.println(getColor() + "║ 4. change set title               ║" + RESET);
        System.out.println(getColor() + "║ 5. choose set                     ║" + RESET);
        System.out.println(getColor() + "║ 6. change color                   ║" + RESET);
        System.out.println(getColor() + "║ 7. end program                    ║" + RESET);
        System.out.println(getColor() + "╚═══════════════════════════════════╝" + RESET);
    }

    /**
     * This method prints the menu that is shown after a set is chosen
     */

    public static void printSetMenu() {
        System.out.println(getColor() + "╔═══════════════════════════════════╗" + RESET);
        System.out.println(getColor() + "\u001B[1m║ Enter the number to..             ║\u001B[0m" + RESET);
        System.out.println(getColor() + "║───────────────────────────────────║" + RESET);
        System.out.println(getColor() + "║ 1. show all flashcards            ║" + RESET);
        System.out.println(getColor() + "║ 2. create new flashcard           ║" + RESET);
        System.out.println(getColor() + "║ 3. edit flashcard                 ║" + RESET);
        System.out.println(getColor() + "║ 4. delete flashcard               ║" + RESET);
        System.out.println(getColor() + "║ 5. back to start menu             ║" + RESET);
        System.out.println(getColor() + "║ 6. flashcard learning             ║" + RESET);
        System.out.println(getColor() + "║ 7. learn writing                  ║" + RESET);
        System.out.println(getColor() + "║ 8. end program                    ║" + RESET);
        System.out.println(getColor() + "╚═══════════════════════════════════╝" + RESET);
    }

    /**
     * Prints all sets. Since an Arraylist of sets is saved in
     * quizmanager, that's where we get the needed data from
     * resp. We give the method a quizmanager, to access the
     * arraylist with the saved sets.
     *
     * @param manager the used Quizmanger
     */
    public static void printSets(QuizManager manager) {
        System.out.println(getColor() + "╔═══════════════════════════════════╗" + RESET);
        System.out.println(getColor() + "\u001B[1m║ SETS                              ║\u001B[0m" + RESET);
        System.out.println(getColor() + "║───────────────────────────────────║" + RESET);
        for (int i = 0; i < manager.getSets().size(); i++) {
            String toPad = manager.getSets().get(i).getTitle();
            //pads the string up to 30 characters so the box is the same width
            // as long as the set title is not longer than 30 characters
            String padded = String.format("%-30s", toPad);
            System.out.println(getColor() + "║ " + i + ". " + padded + " ║" + RESET);

        }
        System.out.println(getColor() + "╚═══════════════════════════════════╝" + RESET);
    }

    /**
     * Prints all Flashcards in a set. Since an Arraylist of Flashcards
     * is saved is Set, that's where we get the needed data from
     * resp. we give the method a Set, to access the
     * Set with the saved Flashcard.
     *
     * @param set that all the flashcards belong to
     */
    public static void printFlashcards(Set set) {
        System.out.println(getColor() + "╔═════════════════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(getColor() + "\u001B[1m║ CARDS                                                                   ║\u001B[0m" + RESET);
        System.out.println(getColor() + "║─────────────────────────────────────────────────────────────────────────║" + RESET);
        System.out.println(getColor() + "║ Nr.  Word                                                    Definition ║" + RESET);
        System.out.println(getColor() + "║═════════════════════════════════════════════════════════════════════════║" + RESET)
        ;
        for (int i = 0; i < set.getSet().size(); i++) {
            String toPad = (String.format("%-20s", set.getSet().get(i).getWord()) + " --> " + String.format("%40s", set.getSet().get(i).getDefinition()));
            String padded = String.format("%-45s", toPad);
            System.out.println(getColor() + "║ " + i + ".   " + padded + "  ║" + RESET);

        }
        System.out.println(getColor() + "╚═════════════════════════════════════════════════════════════════════════╝" + RESET);
    }

    public static void printCard(@NotNull Flashcard card, int i) {
        System.out.println(getColor() + "╔═════════════════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(getColor() + "\u001B[1m║ CARDS                                                                   ║\u001B[0m" + RESET);
        System.out.println(getColor() + "║─────────────────────────────────────────────────────────────────────────║" + RESET);
        System.out.println(getColor() + "║ Nr.  Word                                                    Definition ║" + RESET);
        System.out.println(getColor() + "║═════════════════════════════════════════════════════════════════════════║" + RESET);
        String toPad = (String.format("%-20s", card.getWord()) + " --> " + String.format("%40s", card.getDefinition()));
        String padded = String.format("%-45s", toPad);
        //prints the padded string
        System.out.println(getColor() + "║ " + i + ".   " + padded + "  ║" + RESET);
        System.out.println(getColor() + "╚═════════════════════════════════════════════════════════════════════════╝" + RESET);
    }

    /**
     * This method prints the filpcard that is used when the
     * flashcards are practiced. It can be flipped and shows either
     * the word or the definition. Lets the user rate how accurately
     * they answered the question-> 3 x correct means that card has been
     * understood and will not be shown again
     *
     * @param setting for what is shown first, word or definition
     * @param set     to print the correct title of the set
     * @param card    that will be printed out
     * @param i       number of the card to show how many of the cards the
     *                user has already gone through
     */
    public static int printFlipcard(int setting, Set set, Flashcard card, int i) {
        i++;
        int answer;
        String word;
        do {
            if (setting == 1) {
                word = card.getWord();
            } else {
                word = card.getDefinition();
            }
            String correct = "ooo";
            String status = card.printStatus();
            correct = correct.concat(status).substring(status.length());
            String filler2 = String.format("%27s", " ");
            String toPad = (String.format("%45s", word) + String.format("%28s", " "));
            String padded = String.format("%45s", toPad);
            String filler = String.format("%56s", " ");
            System.out.println(getColor() + "╔═════════════════════════════════════════════════════════════════════════╗" + RESET);
            System.out.println(getColor() + "\u001B[1m║" + set.getTitle() + filler2 + "Correct: " + correct + filler2 + i + "/" + set.getSet().size() + "║\u001B[0m" + RESET);
            System.out.println(getColor() + "║═════════════════════════════════════════════════════════════════════════║" + RESET);

            System.out.println(getColor() + "\u001B[1m║" + padded + "║\u001B[0m" + RESET);
            System.out.println(getColor() + "║ " + "Flip(1) " + filler + "Next(2)" + " ║" + RESET);
            System.out.println(getColor() + "╚═════════════════════════════════════════════════════════════════════════╝" + RESET);
            answer = scan.nextInt();
            if (answer == 1) {
                if (setting == 1) {
                    setting = 2;
                } else {
                    setting = 1;
                }
                printFlipcard(setting, set, card, i - 1);
            } else if (answer == 2) {
                System.out.println("Did you get the word correct(1), partially correct(2) or wrong(3)?");
                int answerStatus = scan.nextInt();
                if (answerStatus == 1) {
                    card.setStatus(card.getStatus() + 1);
                } else if (answerStatus == 2) {
                    card.setStatus(card.getStatus() + 0.5);
                }

            } else if (answer == 0) {

            } else {
                System.out.println("Invalid input! Either enter 1 or 2!");
            }
        }
        while (answer != 1 && answer != 2 && answer != 0);
        return answer;
    }

    /**
     * This method prints the cards that are used when
     * learning how to write the words or defintions. Checks whether
     * user gives the correct answer and saves how many times the
     * word has been answered correctly -> 3 x correct means card
     * has been understood and therefore won't be shown again
     *
     * @param setting whether the definition or word will be shown
     * @param set     to get the correct set title
     * @param card    that will be printed and asked
     * @param i       to see how many cards you already answered
     */
    public static void printLearningCard(int setting, Set set, Flashcard card, int i) {
        i++;
        String word;
        if (setting == 1) {
            word = card.getWord();
        } else {
            word = card.getDefinition();
        }
        String correct = "ooo";
        String status = card.printStatus();
        correct = correct.concat(status).substring(status.length());
        String toPad = (String.format("%45s", word) + String.format("%28s", " "));
        String padded = String.format("%45s", toPad);
        String filler = String.format("%57s", " ");
        String filler2 = String.format("%27s", " ");
        System.out.println(getColor() + "╔═════════════════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(getColor() + "\u001B[1m║" + set.getTitle() + filler2 + "Correct: " + correct + filler2 + i + "/" + set.getSet().size() + "║\u001B[0m" + RESET);
        System.out.println(getColor() + "║═════════════════════════════════════════════════════════════════════════║" + RESET);
        System.out.println(getColor() + "\u001B[1m║" + padded + "║\u001B[0m" + RESET);
        System.out.println(getColor() + "║ " + "Skip(1) " + filler + "End(2)" + " ║" + RESET);
        System.out.println(getColor() + "╚═════════════════════════════════════════════════════════════════════════╝" + RESET);

    }

    /*
    This method checks if the user has entered a word that is to long
    and returns the message "Words to long"
     */
    public static String checkInput(int length, String word) {
        String message = null;
        if (word.length() > length) {
            message = "Word is too long!";
        } else {
            message = null;
        }
        return message;
    }

    /**
     * This method prints the error messages out
     *
     * @param length the max length of the input
     * @param word   the user input
     * @return true if word is in the length limit
     */
    public static boolean printMessages(int length, String word) {
        boolean isOkay = false;
        if (checkInput(length, word) != null) {
            System.err.println("Too long! Max. length is " + length);
        }
        if (checkInput(length, word) == null) {
            isOkay = true;
        }
        return isOkay;
    }

    public static String getColor() {
        return color;
    }

    public static void setColor(String color) {
        IOHandler.color = color;
    }
}