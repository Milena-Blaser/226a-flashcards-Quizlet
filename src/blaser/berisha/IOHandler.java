package blaser.berisha;

/*
 * Authors: Milena Blaser, Blerinë Berisha
 * Project: Flashcards
 */

import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;

/**
 * Class to print menus, sets, flashcards, options, etc. and handle user input.
 */
public class IOHandler {
    public static Scanner scan = new Scanner(System.in);
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

    public static void printColors() {
        System.out.println(GRAY + "╔═══════════════════════════════════╗");
        System.out.println(GRAY + "\u001B[1m║ Available colors:                 ║\u001B[0m");
        System.out.println(GRAY + "║───────────────────────────────────║");
        System.out.println("║" + BLUE + " Blue (b)                          " + GRAY + "║");
        System.out.println("║ " + BLUE_BACKGROUND + BLACK + "Black on blue (bob)              " + RESET + GRAY + " ║");
        System.out.println("║" + PURPLE + " Purple (p)                        " + GRAY + "║");
        System.out.println("║ " + PURPLE_BACKGROUND + BLACK + "Black on purple (bop)            " + RESET + GRAY + " ║");
        System.out.println("║" + CYAN + " Cyan (c)                          " + GRAY + "║");
        System.out.println("║ " + CYAN_BACKGROUND + BLACK + "Black on cyan (boc)              " + RESET + GRAY + " ║");
        System.out.println("║ Gray (g)                          ║");
        System.out.println("║ " + GRAY_BACKGROUND + BLACK + "Black on gray (bog)              " + RESET + GRAY + " ║");
        System.out.println("║ " + RESET + "White (w)                         " + GRAY + "║");
        System.out.println(GRAY + "╚═══════════════════════════════════╝");
    }

    public static void chooseColor() {
        printColors();
        System.out.println(getColor() + "Enter the letters in braces to choose: ");
        String chosen = scan.nextLine();
        switch (chosen.toLowerCase()) {
            case "b" -> setColor(BLUE);
            case "bob" -> setColor(BLUE_BACKGROUND + BLACK);
            case "p" -> setColor(PURPLE);
            case "bop" -> setColor(PURPLE_BACKGROUND + BLACK);
            case "c" -> setColor(CYAN);
            case "boc" -> setColor(CYAN_BACKGROUND + BLACK);
            case "g" -> setColor(GRAY);
            case "bog" -> setColor(GRAY_BACKGROUND + BLACK);
            case "w" -> setColor(RESET);
            default -> setColor(RESET);
        }
    }


    public static void printStartMenu() {
        System.out.println(getColor() + "╔═══════════════════════════════════╗" + RESET);
        System.out.println(getColor() + "\u001B[1m║ Enter the number to..             ║\u001B[0m" + RESET);
        System.out.println(getColor() + "║───────────────────────────────────║" + RESET);
        System.out.println(getColor() + "║ 1. show all sets                  ║" + RESET);
        System.out.println(getColor() + "║ 2. create new set                 ║" + RESET);
        System.out.println(getColor() + "║ 3. delete set                     ║" + RESET);
        System.out.println(getColor() + "║ 4. choose set                     ║" + RESET);
        System.out.println(getColor() + "║ 5. change color                   ║" + RESET);
        System.out.println(getColor() + "║ 6. end program                    ║" + RESET);
        System.out.println(getColor() + "╚═══════════════════════════════════╝" + RESET);
    }


    public static void printSetMenu() {
        System.out.println(getColor() + "╔═══════════════════════════════════╗" + RESET);
        System.out.println(getColor() + "\u001B[1m║ Enter the number in braces to..   ║\u001B[0m" + RESET);
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
     * @param manager Prints all sets. Since an Arraylist of sets is saved in
     *                quizmanager, that's where we get the needed data from
     *                resp. we give the method a quizmanager, to access the
     *                arraylist with the saved sets.
     */
    public static void printSets(QuizManager manager) {
        System.out.println(getColor() + "╔═══════════════════════════════════╗" + RESET);
        System.out.println(getColor() + "\u001B[1m║ SETS                              ║\u001B[0m" + RESET);
        System.out.println(getColor() + "║───────────────────────────────────║" + RESET);
        for (int i = 0; i < manager.getSets().size(); i++) {
            String toPad = manager.getSets().get(i).getTitle();
            String padded = String.format("%-30s", toPad);
            System.out.println(getColor() + "║ " + i + ". " + padded + " ║" + RESET);

        }
        System.out.println(getColor() + "╚═══════════════════════════════════╝" + RESET);
    }

    /**
     * @param set Prints all Flashcards in a set. Since an Arraylist of Flashcards
     *            is saved is Set, that's where we get the needed data from
     *            resp. we give the method a Set, to access the
     *            Set with the saved Flashcard.
     */
    public static void printFlashcards(Set set) {
        System.out.println(getColor() + "╔═════════════════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(getColor() + "\u001B[1m║ CARDS                                                                   ║\u001B[0m" + RESET);
        System.out.println(getColor() + "║─────────────────────────────────────────────────────────────────────────║" + RESET);
        System.out.println(getColor() + "║ Nr.  Word                                                    Definition ║" + RESET);
        System.out.println(getColor() + "║═════════════════════════════════════════════════════════════════════════║" + RESET)
        ;
        for (int i = 0; i < set.getSet().size(); i++) {
            String toPad = (String.format("%-20s", set.getSet().get(i).getWord()) + "---->" + String.format("%40s", set.getSet().get(i).getDefinition()));
            String padded = String.format("%-45s", toPad);
            System.out.println(getColor() + "║ " + i + ".   " + padded + "  ║" + RESET);

        }
        System.out.println(getColor() + "╚═════════════════════════════════════════════════════════════════════════╝" + RESET);
    }

    public static String getColor() {
        return color;
    }

    public static void setColor(String color) {
        IOHandler.color = color;
    }
}
